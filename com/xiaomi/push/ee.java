package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes18.dex */
public class ee extends ed {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4643a;
    private boolean b;
    private boolean c;
    private boolean d;

    public ee(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, i);
        this.f4643a = z;
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
        if (this.f4643a) {
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
        return !this.b ? "off" : "";
    }

    private String e() {
        return !this.c ? "off" : "";
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo159a() {
        return 13;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo159a() {
        return ho.DeviceBaseInfo;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo159a() {
        return b() + "|" + d() + "|" + e() + "|" + a(this.f232a);
    }
}
