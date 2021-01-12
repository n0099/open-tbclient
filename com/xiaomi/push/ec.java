package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class ec extends ed {

    /* renamed from: a  reason: collision with root package name */
    public static String f13960a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f13961b = "";

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
        if (!TextUtils.isEmpty(f13960a)) {
            str = "" + a(dv.f308a, f13960a);
            f13960a = "";
        }
        if (TextUtils.isEmpty(f13961b)) {
            return str;
        }
        String str2 = str + a(dv.f13956b, f13961b);
        f13961b = "";
        return str2;
    }
}
