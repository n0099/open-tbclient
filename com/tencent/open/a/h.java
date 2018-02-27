package com.tencent.open.a;

import android.text.format.Time;
import android.util.Log;
import com.baidu.sapi2.base.network.Apn;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    public final String a(int i) {
        switch (i) {
            case 1:
                return "V";
            case 2:
                return "D";
            case 4:
                return "I";
            case 8:
                return "W";
            case 16:
                return "E";
            case 32:
                return "A";
            default:
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    public String a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        long j2 = j % 1000;
        Time time = new Time();
        time.set(j);
        StringBuilder sb = new StringBuilder();
        sb.append(a(i)).append('/').append(time.format("%Y-%m-%d %H:%M:%S")).append('.');
        if (j2 < 10) {
            sb.append("00");
        } else if (j2 < 100) {
            sb.append('0');
        }
        sb.append(j2).append(' ').append('[');
        if (thread == null) {
            sb.append(Apn.APN_UNKNOWN);
        } else {
            sb.append(thread.getName());
        }
        sb.append(']').append('[').append(str).append(']').append(' ').append(str2).append('\n');
        if (th != null) {
            sb.append("* Exception : \n").append(Log.getStackTraceString(th)).append('\n');
        }
        return sb.toString();
    }
}
