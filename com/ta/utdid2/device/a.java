package com.ta.utdid2.device;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public String f36153c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f36154d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f36155e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f36156f = "";

    /* renamed from: a  reason: collision with root package name */
    public long f36151a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f36152b = 0;

    public void a(long j) {
        this.f36152b = j;
    }

    public void b(long j) {
        this.f36151a = j;
    }

    public void c(String str) {
        this.f36156f = str;
    }

    public String getDeviceId() {
        return this.f36155e;
    }

    public String getImei() {
        return this.f36153c;
    }

    public String getImsi() {
        return this.f36154d;
    }

    public String getUtdid() {
        return this.f36156f;
    }

    public void setImei(String str) {
        this.f36153c = str;
    }

    public void setImsi(String str) {
        this.f36154d = str;
    }

    public long a() {
        return this.f36151a;
    }

    public void b(String str) {
        this.f36155e = str;
    }
}
