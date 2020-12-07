package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes18.dex */
public class ec extends ed {

    /* renamed from: a  reason: collision with root package name */
    public static String f4641a = "";
    public static String b = "";

    public ec(Context context, int i) {
        super(context, i);
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String[] split = str2.split(",");
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
    public int mo159a() {
        return 12;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo159a() {
        return ho.BroadcastAction;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo159a() {
        String str = "";
        if (!TextUtils.isEmpty(f4641a)) {
            str = "" + a(dv.f230a, f4641a);
            f4641a = "";
        }
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        String str2 = str + a(dv.b, b);
        b = "";
        return str2;
    }
}
