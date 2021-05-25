package d.a.w.c.g;

import com.baidu.rtc.PeerConnectionClient;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f64829a = "/sdcard/AR/video/arvideo.mp4";

    /* renamed from: b  reason: collision with root package name */
    public int f64830b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f64831c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64832d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f64833e = PeerConnectionClient.HD_VIDEO_HEIGHT;

    /* renamed from: f  reason: collision with root package name */
    public int f64834f = 1280;

    /* renamed from: g  reason: collision with root package name */
    public String f64835g = "video/avc";

    /* renamed from: h  reason: collision with root package name */
    public int f64836h = 8294400;

    /* renamed from: i  reason: collision with root package name */
    public int f64837i = 30;
    public int j = 1;
    public boolean k = false;
    public String l = "audio/mp4a-latm";
    public int m = 1;
    public int n = 128000;
    public int o = 16000;
    public int p = 1024;

    public int a() {
        return this.n;
    }

    public int b() {
        return this.m;
    }

    public String c() {
        return this.l;
    }

    public int d() {
        return this.p;
    }

    public int e() {
        return this.o;
    }

    public String f() {
        return this.f64829a;
    }

    public int g() {
        return this.f64830b;
    }

    public long h() {
        return this.f64831c;
    }

    public int i() {
        return this.f64836h;
    }

    public String j() {
        return this.f64835g;
    }

    public int k() {
        return this.f64837i;
    }

    public int l() {
        return this.f64834f;
    }

    public int m() {
        return this.j;
    }

    public int n() {
        return this.f64833e;
    }

    public boolean o() {
        return this.k;
    }

    public boolean p() {
        return this.f64832d;
    }

    public void q(int i2) {
        this.m = i2;
    }

    public void r(int i2) {
        this.p = i2;
    }

    public void s(boolean z) {
        this.k = z;
    }

    public void t(int i2) {
        this.o = i2;
    }

    public void u(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f64829a = str;
    }

    public void v(long j) {
        this.f64831c = j;
    }

    public void w(int i2) {
        this.f64834f = i2;
    }

    public void x(int i2) {
        this.f64833e = i2;
    }
}
