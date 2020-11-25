package org.csuf.cpsc411.simplehttpclient

import java.util.*

//class Claim (var id: UUID = UUID.randomUUID(), var title:String?, var date:String?, var isSolved:Boolean = false) {
class Claim (var id: UUID = UUID.randomUUID(), var title:String?, var date:String?, var isSolved:Boolean = false) {
    var toBeDeleted : Boolean = false
}