package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class dy extends dx {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public dy(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, i);
        this.a = z;
        this.b = z2;
        if (l.d()) {
            this.b = false;
        }
        this.c = z3;
        this.d = z4;
    }

    private String a(Context context) {
        return !this.d ? "off" : "";
    }

    private String b() {
        if (this.a) {
            try {
                String c = c();
                return TextUtils.isEmpty(c) ? "" : ay.a(c) + Constants.ACCEPT_TIME_SEPARATOR_SP + ay.b(c);
            } catch (Throwable th) {
                return "";
            }
        }
        return "off";
    }

    private String c() {
        return "";
    }

    private String d() {
        return !this.b ? "off" : "";
    }

    private String e() {
        return !this.c ? "off" : "";
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo157a() {
        return 13;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hi mo157a() {
        return hi.DeviceBaseInfo;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo157a() {
        return b() + "|" + d() + "|" + e() + "|" + a(this.f245a);
    }
}
