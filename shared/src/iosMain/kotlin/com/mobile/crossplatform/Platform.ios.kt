package com.mobile.crossplatform

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() +" DSAX"
}

actual fun getPlatform(): Platform = IOSPlatform()
