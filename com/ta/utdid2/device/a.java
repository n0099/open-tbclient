package com.ta.utdid2.device;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public String f39001c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f39002d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f39003e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f39004f = "";

    /* renamed from: a  reason: collision with root package name */
    public long f38999a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f39000b = 0;

    public void a(long j) {
        this.f39000b = j;
    }

    public void b(long j) {
        this.f38999a = j;
    }

    public void c(String str) {
        this.f39004f = str;
    }

    public String getDeviceId() {
        return this.f39003e;
    }

    public String getImei() {
        return this.f39001c;
    }

    public String getImsi() {
        return this.f39002d;
    }

    public String getUtdid() {
        return this.f39004f;
    }

    public void setImei(String str) {
        this.f39001c = str;
    }

    public void setImsi(String str) {
        this.f39002d = str;
    }

    public long a() {
        return this.f38999a;
    }

    public void b(String str) {
        this.f39003e = str;
    }
}
