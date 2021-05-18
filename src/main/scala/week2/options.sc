case class Contact(
                  name: String,
                  maybeEmail: Option[String],
                  phoneNumbers: List[String]
                  )

val andres = Contact("Andres", Some("andres@sca.la"), List())
val carito = Contact("Carito", None, List("+7313621"))

def hasScaDotLaEmail(contact: Contact): Boolean = {
  contact.maybeEmail match {
    case Some(email) => email.endsWith("@sca.la")
    case None => false
  }
}

hasScaDotLaEmail(andres)
hasScaDotLaEmail(carito)

// other operations on Option
def emailLength(contact: Contact): Int =
  contact.maybeEmail
    .map(email => email.size) // map on Option
    .getOrElse(0) // getOrElse

emailLength(andres)
emailLength(carito)

val maybeAliceAndBobEmails: Option[(String, String)] =
  andres.maybeEmail.zip(carito.maybeEmail)

// Returning Optional Results
def sendNotification(contact: Contact, message: String): Unit =
  contact.phoneNumbers.headOption match {
    case Some(number) => println(s"sendSMS($number, $message)")
    case None =>
      contact.maybeEmail match {
        case Some(email) => println(s"sendEmail(email, message")
        case None => ()
      }
  }
