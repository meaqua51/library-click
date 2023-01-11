package com.weijun.plugin.click.lib;

import android.os.SystemClock;
import android.util.Log;

/**
 * @author: weijun
 * date: 2023/1/10
 * description: 注入类
 *  * <p>
 *  * 这两个字段变量的值在编译时根据build.gradle配置动态改变
 *  * <p>
 *  * {@link ClickShakeChecker#sCheckTime}
 *  * {@link ClickShakeChecker#sDebug}
 *  * <p>
 */
public class ClickShakeChecker {
    private static long sCheckTime = 1000L;
    private static boolean sDebug = true;

    private long lastClickTime;

    //判断是否是快速点击
    public boolean check() {
        boolean isBounce = SystemClock.elapsedRealtime() - lastClickTime < sCheckTime;
        if (sDebug) {
            Log.d("ClickShakeChecker", "[checkTime:" + sCheckTime + ",是否快速点击:" + !isBounce + "]");
        }
        if (!isBounce) {
            lastClickTime = SystemClock.elapsedRealtime();
        }
        return isBounce;
    }
}
