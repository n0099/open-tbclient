package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class ee extends ed {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13963a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13964b;
    private boolean c;
    private boolean d;

    public ee(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, i);
        this.f13963a = z;
        this.f13964b = z2;
        if (l.d()) {
            this.f13964b = false;
        }
        this.c = z3;
        this.d = z4;
    }

    private String a(Context context) {
        return !this.d ? "off" : "";
    }

    private String b() {
        if (this.f13963a) {
            try {
                String c = c();
                return TextUtils.isEmpty(c) ? "" : bf.a(c) + "," + bf.b(c);
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
        return !this.f13964b ? "off" : "";
    }

    private String e() {
        return !this.c ? "off" : "";
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo192a() {
        return 13;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo192a() {
        return ho.DeviceBaseInfo;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo192a() {
        return b() + "|" + d() + "|" + e() + "|" + a(this.f310a);
    }
}
