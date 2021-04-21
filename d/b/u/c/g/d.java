package d.b.u.c.g;

import com.baidu.rtc.PeerConnectionClient;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f65736a = "/sdcard/AR/video/arvideo.mp4";

    /* renamed from: b  reason: collision with root package name */
    public int f65737b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f65738c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65739d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f65740e = PeerConnectionClient.HD_VIDEO_HEIGHT;

    /* renamed from: f  reason: collision with root package name */
    public int f65741f = 1280;

    /* renamed from: g  reason: collision with root package name */
    public String f65742g = "video/avc";

    /* renamed from: h  reason: collision with root package name */
    public int f65743h = 8294400;
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
        return this.f65736a;
    }

    public int g() {
        return this.f65737b;
    }

    public long h() {
        return this.f65738c;
    }

    public int i() {
        return this.f65743h;
    }

    public String j() {
        return this.f65742g;
    }

    public int k() {
        return this.i;
    }

    public int l() {
        return this.f65741f;
    }

    public int m() {
        return this.j;
    }

    public int n() {
        return this.f65740e;
    }

    public boolean o() {
        return this.k;
    }

    public boolean p() {
        return this.f65739d;
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
        this.f65736a = str;
    }

    public void v(long j) {
        this.f65738c = j;
    }

    public void w(int i) {
        this.f65741f = i;
    }

    public void x(int i) {
        this.f65740e = i;
    }
}
