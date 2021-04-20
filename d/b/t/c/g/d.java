package d.b.t.c.g;

import com.baidu.rtc.PeerConnectionClient;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f65472a = "/sdcard/AR/video/arvideo.mp4";

    /* renamed from: b  reason: collision with root package name */
    public int f65473b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f65474c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65475d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f65476e = PeerConnectionClient.HD_VIDEO_HEIGHT;

    /* renamed from: f  reason: collision with root package name */
    public int f65477f = 1280;

    /* renamed from: g  reason: collision with root package name */
    public String f65478g = "video/avc";

    /* renamed from: h  reason: collision with root package name */
    public int f65479h = 8294400;
    public int i = 30;
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
        return this.f65472a;
    }

    public int g() {
        return this.f65473b;
    }

    public long h() {
        return this.f65474c;
    }

    public int i() {
        return this.f65479h;
    }

    public String j() {
        return this.f65478g;
    }

    public int k() {
        return this.i;
    }

    public int l() {
        return this.f65477f;
    }

    public int m() {
        return this.j;
    }

    public int n() {
        return this.f65476e;
    }

    public boolean o() {
        return this.k;
    }

    public boolean p() {
        return this.f65475d;
    }

    public void q(int i) {
        this.m = i;
    }

    public void r(int i) {
        this.p = i;
    }

    public void s(boolean z) {
        this.k = z;
    }

    public void t(int i) {
        this.o = i;
    }

    public void u(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f65472a = str;
    }

    public void v(long j) {
        this.f65474c = j;
    }

    public void w(int i) {
        this.f65477f = i;
    }

    public void x(int i) {
        this.f65476e = i;
    }
}
