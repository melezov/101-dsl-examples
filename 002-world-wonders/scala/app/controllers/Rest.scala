package controllers

import models._
import WorldWonders.Wonder

import play.api.mvc.{ Action, Controller }

object Rest extends Controller
    with CustomParsers
    with CustomWriteables {

  private lazy val wonderParser      = parseObject[Wonder]
  private lazy val wonderArrayParser = parseIndexedSeq[Wonder]

  def read(URI: String) = Action.async {
    WonderCrud.read(URI) map { wonder =>
      Ok(wonder)
    }
  }

  def readAll = Action.async {
    WonderCrud.readAll map { wonders =>
      Ok(wonders)
    }
  }
}
