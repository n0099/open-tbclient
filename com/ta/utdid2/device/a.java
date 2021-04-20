package com.ta.utdid2.device;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public String f39291c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f39292d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f39293e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f39294f = "";

    /* renamed from: a  reason: collision with root package name */
    public long f39289a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f39290b = 0;

    public void a(long j) {
        this.f39290b = j;
    }

    public void b(long j) {
        this.f39289a = j;
    }

    public void c(String str) {
        this.f39294f = str;
    }

    public String getDeviceId() {
        return this.f39293e;
    }

    public String getImei() {
        return this.f39291c;
    }

    public String getImsi() {
        return this.f39292d;
    }

    public String getUtdid() {
        return this.f39294f;
    }

    public void setImei(String str) {
        this.f39291c = str;
    }

    public void setImsi(String str) {
        this.f39292d = str;
    }

    public long a() {
        return this.f39289a;
    }

    public void b(String str) {
        this.f39293e = str;
    }
}
