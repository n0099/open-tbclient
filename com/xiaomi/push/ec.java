package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class ec extends ed {
    public static String a = "";
    public static String b = "";

    public ec(Context context, int i) {
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

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo160a() {
        return 12;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo160a() {
        return ho.BroadcastAction;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo160a() {
        String str = "";
        if (!TextUtils.isEmpty(a)) {
            str = "" + a(dv.f235a, a);
            a = "";
        }
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        String str2 = str + a(dv.b, b);
        b = "";
        return str2;
    }
}
