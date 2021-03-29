package com.ta.utdid2.device;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public String f39002c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f39003d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f39004e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f39005f = "";

    /* renamed from: a  reason: collision with root package name */
    public long f39000a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f39001b = 0;

    public void a(long j) {
        this.f39001b = j;
    }

    public void b(long j) {
        this.f39000a = j;
    }

    public void c(String str) {
        this.f39005f = str;
    }

    public String getDeviceId() {
        return this.f39004e;
    }

    public String getImei() {
        return this.f39002c;
    }

    public String getImsi() {
        return this.f39003d;
    }

    public String getUtdid() {
        return this.f39005f;
    }

    public void setImei(String str) {
        this.f39002c = str;
    }

    public void setImsi(String str) {
        this.f39003d = str;
    }

    public long a() {
        return this.f39000a;
    }

    public void b(String str) {
        this.f39004e = str;
    }
}
