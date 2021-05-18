
case class Contact(
                    name: String,
                    maybeEmail: Option[String],
                    phoneNumbers: List[String]
                  )

val andres = Contact("Andres", Some("andres@sca.la"), List())
val carito = Contact("Carito", None, List("+57313621"))
val contacts = List(andres, carito)

val namesAndColombiaNumbers: List[(String, String)] =
  contacts.flatMap { contact =>
    contact.phoneNumbers
      .filter(phoneNumber => phoneNumber.startsWith("+57"))
      .map(phoneNumber => (contact.name, phoneNumber))
  }

// for expresion
val nameAndColombiaNumberWithFor: List[(String, String)] =
  for {
    contact <- contacts
    phoneNumber <- contact.phoneNumbers
    if phoneNumber.startsWith("+57")
  } yield (contact.name, phoneNumber)