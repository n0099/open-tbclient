package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public int A;
    public String B;
    public long C;
    public String D;
    public int E;
    public int F;
    public int G;
    public String H;
    public String I;
    public JSONArray J;
    public JSONArray K;
    public JSONObject L;
    public int M;
    public String N;
    public String O;
    public int P;
    public int Q;
    public long R;
    public String S;
    public int T;
    public int U;
    public int V;
    public int W;
    public long X;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34725a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f34726b;

    /* renamed from: c  reason: collision with root package name */
    public long f34727c;

    /* renamed from: d  reason: collision with root package name */
    public long f34728d;

    /* renamed from: e  reason: collision with root package name */
    public long f34729e;

    /* renamed from: f  reason: collision with root package name */
    public long f34730f;

    /* renamed from: g  reason: collision with root package name */
    public long f34731g;

    /* renamed from: h  reason: collision with root package name */
    public long f34732h;

    /* renamed from: i  reason: collision with root package name */
    public long f34733i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public JSONArray t;
    public JSONArray u;
    public String v;
    public String w;
    public String x;
    public long y;
    public long z;

    public a(long j) {
        this.X = -1L;
        this.k = 0L;
        this.n = -1L;
        this.o = 0;
        this.p = 0;
        this.s = 0;
        this.C = -1L;
        this.E = -1;
        this.V = -1;
        this.W = -1;
        this.f34727c = j;
        this.f34725a = null;
    }

    public a(long j, @NonNull AdTemplate adTemplate) {
        this.X = -1L;
        this.k = 0L;
        this.n = -1L;
        this.o = 0;
        this.p = 0;
        this.s = 0;
        this.C = -1L;
        this.E = -1;
        this.V = -1;
        this.W = -1;
        this.f34727c = j;
        this.f34725a = adTemplate;
        a(adTemplate.getShowPosition());
    }

    private void a(long j) {
        this.X = j + 1;
    }

    public long a() {
        return this.X;
    }

    public void b() {
        com.kwad.sdk.core.h.b a2 = com.kwad.sdk.core.h.b.a();
        this.U = a2.b() ? 1 : 0;
        this.V = a2.c();
        this.W = a2.d();
    }
}
