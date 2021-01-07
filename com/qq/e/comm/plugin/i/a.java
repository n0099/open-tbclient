package com.qq.e.comm.plugin.i;

import com.qq.e.ads.dfa.GDTApk;
/* loaded from: classes4.dex */
class a implements GDTApk {

    /* renamed from: a  reason: collision with root package name */
    private final String f12385a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12386b;
    private final String c;
    private final String d;
    private final String e;
    private final com.qq.e.comm.plugin.a.c f;

    public a(String str, String str2, String str3, String str4, String str5, com.qq.e.comm.plugin.a.c cVar) {
        this.f12385a = str;
        this.f12386b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = cVar;
    }

    public com.qq.e.comm.plugin.a.c a() {
        return this.f;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getAppName() {
        return this.d;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getDesc() {
        return this.c;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getLogoUrl() {
        return this.e;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getPackageName() {
        return this.f12385a;
    }

    @Override // com.qq.e.ads.dfa.GDTApk
    public String getTitle() {
        return this.f12386b;
    }

    public String toString() {
        return "Apk{packageName='" + this.f12385a + "', title='" + this.f12386b + "', desc='" + this.c + "', appName='" + this.d + "', logoUrl='" + this.e + "'}";
    }
}
