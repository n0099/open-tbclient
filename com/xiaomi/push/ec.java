package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class ec extends ed {

    /* renamed from: a  reason: collision with root package name */
    public static String f13962a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f13963b = "";

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
    public int mo192a() {
        return 12;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo192a() {
        return ho.BroadcastAction;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo192a() {
        String str = "";
        if (!TextUtils.isEmpty(f13962a)) {
            str = "" + a(dv.f308a, f13962a);
            f13962a = "";
        }
        if (TextUtils.isEmpty(f13963b)) {
            return str;
        }
        String str2 = str + a(dv.f13958b, f13963b);
        f13963b = "";
        return str2;
    }
}
