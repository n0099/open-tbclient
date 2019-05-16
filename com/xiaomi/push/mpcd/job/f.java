package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.mpcd.BroadcastActionsReceiver;
/* loaded from: classes3.dex */
public class f extends g {
    public static String a = "";
    public static String b = "";

    public f(Context context, int i) {
        super(context, i);
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length <= 10) {
            return str2;
        }
        int length = split.length;
        while (true) {
            length--;
            if (length < split.length - 10) {
                return str;
            }
            str = str + split[length];
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 12;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        String str = "";
        if (!TextUtils.isEmpty(a)) {
            str = "" + a(BroadcastActionsReceiver.a, a);
            a = "";
        }
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        String str2 = str + a(BroadcastActionsReceiver.b, b);
        b = "";
        return str2;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.BroadcastAction;
    }
}
