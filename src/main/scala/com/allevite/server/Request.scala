package com.allevite.server

import cats.*
import cats.implicits.*

case class Request(
                    method: String,
                    url: String,
                    httpVersion: String,
                    headers: Map[String, String],
                    body: Array[Byte]
                  ):

/**
 * TODO #1
 *
 * Utility method for getting the content length of the request from the headers.
 *
 * If the header is not present or any error occurs, it returns 0.
 */
  def contentLength: Int =
    ???

  override def toString: String = Request.show.show(this)

object Request:
  val empty = new Request("", "", "", Map.empty, Array.empty)

  given show: Show[Request] = Show.show { req =>
    s"""Request(
       |  method = ${req.method}
       |  url = ${req.url}
       |  httpVersion = ${req.httpVersion}
       |  headers = [
       |    ${req.headers.map { case (k, v) => s"$k: $v" }.mkString("\n    ")}
       |  ]
       |  body = ${new String(req.body)}
       |)""".stripMargin
  }


