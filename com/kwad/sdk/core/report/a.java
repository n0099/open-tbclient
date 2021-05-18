package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public JSONArray A;
    public JSONArray B;
    public String C;
    public String D;
    public String E;
    public String F;
    public long G;
    public long H;
    public int I;
    public String J;
    public long K;
    public String L;
    public long M;
    public int N;
    public int O;
    public int P;
    public String Q;
    public String R;
    public int S;
    public JSONArray T;
    public JSONArray U;
    public JSONObject V;
    public int W;
    public String X;
    public String Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f32609a;
    public int aa;
    public long ab;
    public String ac;
    public int ad;
    public int ae;
    public int af;
    public int ag;
    public JSONArray ah;
    public boolean ai;
    public int aj;
    public String ak;
    public int al;
    public long am;
    public long an;
    public JSONArray ao;
    public String ap;
    public long aq;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f32610b;

    /* renamed from: c  reason: collision with root package name */
    public long f32611c;

    /* renamed from: d  reason: collision with root package name */
    public long f32612d;

    /* renamed from: e  reason: collision with root package name */
    public long f32613e;

    /* renamed from: f  reason: collision with root package name */
    public long f32614f;

    /* renamed from: g  reason: collision with root package name */
    public long f32615g;

    /* renamed from: h  reason: collision with root package name */
    public long f32616h;

    /* renamed from: i  reason: collision with root package name */
    public long f32617i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public int o;
    public int p;
    public int q;
    public String r;
    public int s;
    public int t;
    public long u;
    public long v;
    public int w;
    public int x;
    public int y;
    public int z;

    public a(long j) {
        this.aq = -1L;
        this.k = 0L;
        this.n = -1L;
        this.o = 0;
        this.p = 0;
        this.q = -1;
        this.y = -1;
        this.z = 0;
        this.K = -1L;
        this.M = -1L;
        this.N = -1;
        this.af = -1;
        this.ag = -1;
        this.aj = -1;
        this.al = 0;
        this.f32611c = j;
        this.f32609a = null;
    }

    public a(long j, @NonNull AdTemplate adTemplate) {
        this.aq = -1L;
        this.k = 0L;
        this.n = -1L;
        this.o = 0;
        this.p = 0;
        this.q = -1;
        this.y = -1;
        this.z = 0;
        this.K = -1L;
        this.M = -1L;
        this.N = -1;
        this.af = -1;
        this.ag = -1;
        this.aj = -1;
        this.al = 0;
        this.f32611c = j;
        this.f32609a = adTemplate;
        a(adTemplate.getShowPosition());
    }

    private void a(long j) {
        this.aq = j + 1;
    }

    public long a() {
        return this.aq;
    }

    public void b() {
        com.kwad.sdk.core.h.b a2 = com.kwad.sdk.core.h.b.a();
        this.ae = a2.b() ? 1 : 0;
        this.af = a2.c();
        this.ag = a2.d();
    }
}
