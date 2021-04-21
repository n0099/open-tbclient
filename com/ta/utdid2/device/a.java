package com.ta.utdid2.device;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public String f39386c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f39387d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f39388e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f39389f = "";

    /* renamed from: a  reason: collision with root package name */
    public long f39384a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f39385b = 0;

    public void a(long j) {
        this.f39385b = j;
    }

    public void b(long j) {
        this.f39384a = j;
    }

    public void c(String str) {
        this.f39389f = str;
    }

    public String getDeviceId() {
        return this.f39388e;
    }

    public String getImei() {
        return this.f39386c;
    }

    public String getImsi() {
        return this.f39387d;
    }

    public String getUtdid() {
        return this.f39389f;
    }

    public void setImei(String str) {
        this.f39386c = str;
    }

    public void setImsi(String str) {
        this.f39387d = str;
    }

    public long a() {
        return this.f39384a;
    }

    public void b(String str) {
        this.f39388e = str;
    }
}
