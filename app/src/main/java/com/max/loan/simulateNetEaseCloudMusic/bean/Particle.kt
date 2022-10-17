package com.max.loan.simulateNetEaseCloudMusic.bean

class Particle(
    var x: Float,
    var y: Float,
    var radius: Float,
    var speed: Float,
    var alpha: Int,
    var offset: Int,//当前移动距离
    var angle: Double,//粒子角度
    var maxOffset: Float = 300f//最大移动距离

)