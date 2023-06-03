package com.yy.transvod.player.mediacodec;

import android.graphics.SurfaceTexture;
import com.yy.transvod.player.common.AVframe;
import com.yy.transvod.player.common.AudioSendStamp;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class MediaSample {
    public String a;
    public SurfaceTexture h;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public AVframe g = null;
    public MediaInfo i = MediaInfo.a();
    public long j = 0;
    public long k = 0;
    public long l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public long t = 0;
    public long u = 0;
    public long v = 0;
    public long w = 0;
    public long x = 0;
    public long y = 0;
    public long z = 0;
    public long A = 0;
    public long B = 0;
    public boolean C = false;
    public boolean D = true;
    public boolean E = true;
    public boolean F = false;
    public boolean G = false;
    public boolean H = false;
    public ArrayList<MixAudioExtraInfo> I = null;
    public ArrayList<AudioSendStamp> J = null;
    public MediaInfo K = null;
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public boolean O = false;
    public boolean P = false;
    public boolean Q = false;

    public MediaSample d() {
        this.i.i();
        this.d = false;
        AVframe aVframe = this.g;
        if (aVframe != null) {
            aVframe.a();
            this.g = null;
        }
        this.c = false;
        this.d = false;
        this.e = false;
        this.b = false;
        this.f = false;
        this.m = 0;
        this.t = 0L;
        this.u = 0L;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.j = -1L;
        this.l = 0L;
        this.k = 0L;
        this.L = 0;
        this.M = 0;
        this.v = 0L;
        this.x = 0L;
        this.w = 0L;
        this.y = 0L;
        this.A = 0L;
        this.z = 0L;
        this.C = false;
        this.E = true;
        this.D = true;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = null;
        this.J = null;
        this.N = 0;
        this.O = false;
        this.P = true;
        this.Q = false;
        return this;
    }

    public static MediaSample a(long j) {
        MediaSample mediaSample = new MediaSample();
        mediaSample.d();
        return mediaSample;
    }

    public MediaSample c(MediaInfo mediaInfo) {
        this.K = this.i;
        this.i = mediaInfo;
        return this;
    }

    public void b(MediaSample mediaSample) {
        this.c = mediaSample.c;
        this.d = mediaSample.d;
        this.e = mediaSample.e;
        this.b = mediaSample.b;
        this.m = mediaSample.m;
        this.j = mediaSample.j;
        this.k = mediaSample.k;
        this.l = mediaSample.l;
        this.L = mediaSample.L;
        this.M = mediaSample.M;
        this.t = mediaSample.t;
        this.u = mediaSample.u;
        this.n = mediaSample.n;
        this.o = mediaSample.o;
        this.p = mediaSample.p;
        this.q = mediaSample.q;
        MediaInfo mediaInfo = mediaSample.i;
        int i = mediaInfo.b;
        int i2 = mediaInfo.c;
        this.r = mediaSample.r;
        this.s = mediaSample.s;
        this.v = mediaSample.v;
        this.x = mediaSample.x;
        this.w = mediaSample.w;
        this.y = mediaSample.y;
        this.A = mediaSample.A;
        this.z = mediaSample.z;
        this.B = mediaSample.B;
        this.C = mediaSample.C;
        this.E = mediaSample.E;
        this.D = mediaSample.D;
        this.F = mediaSample.F;
        this.G = mediaSample.G;
        this.H = mediaSample.H;
        this.I = mediaSample.I;
        this.J = mediaSample.J;
        this.f = mediaSample.f;
        this.N = mediaSample.N;
        this.O = mediaSample.O;
        this.P = mediaSample.P;
        this.Q = mediaSample.Q;
    }

    public MediaSample e() {
        this.i = this.K;
        this.K = null;
        return this;
    }
}
