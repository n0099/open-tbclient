package com.yy.mobile.framework.revenuesdk.baseapi.log;

import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class RLog {
    public static CopyOnWriteArrayList<IRLogDelegate> logDelegates = new CopyOnWriteArrayList<>();

    public static void addLogDelegate(IRLogDelegate iRLogDelegate) {
        logDelegates.add(iRLogDelegate);
    }

    public static void debug(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().debug(obj, str, objArr);
            }
            return;
        }
        try {
            Log.d(obj.toString(), String.format(str, objArr));
        } catch (Exception unused) {
        }
    }

    public static void error(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().error(obj, str, objArr);
            }
        } else {
            try {
                Log.e(obj.toString(), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            CloudLogUtil.addLogContent(obj.toString(), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }

    public static void info(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().info(obj, str, objArr);
            }
        } else {
            try {
                Log.i(obj.toString(), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            CloudLogUtil.addLogContent(obj.toString(), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }

    public static void verbose(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().verbose(obj, str, objArr);
            }
        } else {
            try {
                Log.v(obj.toString(), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            CloudLogUtil.addLogContent(obj.toString(), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }

    public static void warn(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().warn(obj, str, objArr);
            }
        } else {
            try {
                Log.w(obj.toString(), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            CloudLogUtil.addLogContent(obj.toString(), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }

    public static void debug(Object obj, String str) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().debug(obj, str);
            }
            return;
        }
        Log.d(obj.toString(), str);
    }

    public static void error(Object obj, String str, Throwable th) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().error(obj, str, th);
            }
        } else {
            Log.e(obj.toString(), str, th);
        }
        try {
            String obj2 = obj.toString();
            CloudLogUtil.addLogContent(obj2, str + ":" + th.getLocalizedMessage());
        } catch (Exception unused) {
        }
    }

    public static void info(Object obj, String str) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().info(obj, str);
            }
        } else {
            Log.i(obj.toString(), str);
        }
        try {
            CloudLogUtil.addLogContent(obj.toString(), str);
        } catch (Exception unused) {
        }
    }

    public static void verbose(Object obj, String str) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().verbose(obj, str);
            }
        } else {
            Log.v(obj.toString(), str);
        }
        try {
            CloudLogUtil.addLogContent(obj.toString(), str);
        } catch (Exception unused) {
        }
    }

    public static void warn(Object obj, String str) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().warn(obj, str);
            }
        } else {
            Log.w(obj.toString(), str);
        }
        try {
            CloudLogUtil.addLogContent(obj.toString(), str);
        } catch (Exception unused) {
        }
    }

    public static void debug(Object obj, String str, Throwable th) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().debug(obj, str, th);
            }
            return;
        }
        Log.d(obj.toString(), str, th);
    }
}
