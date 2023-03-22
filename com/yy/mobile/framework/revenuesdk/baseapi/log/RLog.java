package com.yy.mobile.framework.revenuesdk.baseapi.log;

import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class RLog {
    public static final String HEADER = "MidPay:";
    public static CopyOnWriteArrayList<IRLogDelegate> logDelegates = new CopyOnWriteArrayList<>();

    public static void addLogDelegate(IRLogDelegate iRLogDelegate) {
        if (!logDelegates.contains(iRLogDelegate)) {
            logDelegates.add(iRLogDelegate);
        }
    }

    public static String tagWithHeader(Object obj) {
        return HEADER + obj;
    }

    public static void debug(Object obj, String str) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().debug(tagWithHeader(obj), str);
            }
            return;
        }
        Log.d(tagWithHeader(obj), str);
    }

    public static void info(Object obj, String str) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().info(tagWithHeader(obj), str);
            }
        } else {
            Log.i(tagWithHeader(obj), str);
        }
        try {
            CloudLogUtil.addLogContent(tagWithHeader(obj), str);
        } catch (Exception unused) {
        }
    }

    public static void verbose(Object obj, String str) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().verbose(tagWithHeader(obj), str);
            }
        } else {
            Log.v(tagWithHeader(obj), str);
        }
        try {
            CloudLogUtil.addLogContent(tagWithHeader(obj), str);
        } catch (Exception unused) {
        }
    }

    public static void warn(Object obj, String str) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().warn(tagWithHeader(obj), str);
            }
        } else {
            Log.w(tagWithHeader(obj), str);
        }
        try {
            CloudLogUtil.addLogContent(tagWithHeader(obj), str);
        } catch (Exception unused) {
        }
    }

    public static void debug(Object obj, String str, Throwable th) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().debug(tagWithHeader(obj), str, th);
            }
            return;
        }
        Log.d(tagWithHeader(obj), str, th);
    }

    public static void debug(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().debug(tagWithHeader(obj), str, objArr);
            }
            return;
        }
        try {
            Log.d(tagWithHeader(obj), String.format(str, objArr));
        } catch (Exception unused) {
        }
    }

    public static void error(Object obj, String str, Throwable th) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().error(tagWithHeader(obj), str, th);
            }
        } else {
            Log.e(tagWithHeader(obj), str, th);
        }
        try {
            String tagWithHeader = tagWithHeader(obj);
            CloudLogUtil.addLogContent(tagWithHeader, str + ":" + th.getLocalizedMessage());
        } catch (Exception unused) {
        }
    }

    public static void error(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().error(tagWithHeader(obj), str, objArr);
            }
        } else {
            try {
                Log.e(tagWithHeader(obj), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            CloudLogUtil.addLogContent(tagWithHeader(obj), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }

    public static void info(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().info(tagWithHeader(obj), str, objArr);
            }
        } else {
            try {
                Log.i(tagWithHeader(obj), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            CloudLogUtil.addLogContent(tagWithHeader(obj), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }

    public static void verbose(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().verbose(tagWithHeader(obj), str, objArr);
            }
        } else {
            try {
                Log.v(tagWithHeader(obj), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            CloudLogUtil.addLogContent(tagWithHeader(obj), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }

    public static void warn(Object obj, String str, Object... objArr) {
        if (!logDelegates.isEmpty()) {
            Iterator<IRLogDelegate> it = logDelegates.iterator();
            while (it.hasNext()) {
                it.next().warn(tagWithHeader(obj), str, objArr);
            }
        } else {
            try {
                Log.w(tagWithHeader(obj), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            CloudLogUtil.addLogContent(tagWithHeader(obj), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }
}
