import java.nio.channels.NetworkChannel

/*
  1. Exercise: Video Streaming Footprint

  The impact on the environment of video streaming varies according to the
  video quality and duration and the type of internet connection.

  A simplified model of footprint is the following:

    - Data centers consume 0.000072 kWh/MB of video
    - Mobile networks consume 0.00088 kWh/MB of video whereas fixed
      networks consume 0.00043 kWh/MB of video.
    - Producing 1 kWh of electricity emits 0.5 kg of CO2 (world average)

    What is the impact of watching a 30 minutes series:

    1. in high definition (0.6 MB/s) from a mobile phone?
    2. in low definition (0.3 MB/s) from a desktop computer?
 */

/*
We are interested in the Experience of watching videos of same duration,
some quality and from some type of network.
* */

/*
  Type Networks
 */
sealed trait Network
object Fixed extends Network
object Mobile extends Network


case class Experience(duration: Int, definition: Double, network: Network)

// scenarios according to the problem statement
val lowQuality = 0.3 // MB/s
val highQuality = 0.6 // MB/s

val thirtyMinutes = 30 * 60 // seconds

val highQualityAndMobile = Experience(thirtyMinutes, highQuality, Mobile)
val lowQualityAndFixed = Experience(thirtyMinutes, lowQuality, Fixed)

// business logic
val dataCenterEnergy = 0.000072
val kgCO2PerKwh = 0.5

def networkEnergy(network: Network): Double = network match {
  case Fixed  => 0.00043
  case Mobile => 0.00088

}

def footprint(experience: Experience): Double = {
  val megabytes = experience.duration * experience.definition
  val energy = dataCenterEnergy + networkEnergy(experience.network)
  energy * megabytes * kgCO2PerKwh
}

footprint(lowQualityAndFixed)
footprint(highQualityAndMobile)








