package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class i<R extends g, T extends BaseResultData> extends a<R> {
    @Nullable
    public h<R, T> a = null;
    public final com.kwad.sdk.core.network.a.b b = new com.kwad.sdk.core.network.a.b();

    private void a(@NonNull R r) {
        h<R, T> hVar = this.a;
        if (hVar == null) {
            return;
        }
        hVar.a(r);
    }

    private void a(@NonNull R r, int i, String str) {
        h<R, T> hVar = this.a;
        if (hVar == null) {
            return;
        }
        hVar.a(r, i, str);
    }

    private void a(@NonNull R r, T t) {
        h<R, T> hVar = this.a;
        if (hVar == null) {
            return;
        }
        hVar.a(r, t);
    }

    private void a(String str, String str2) {
        try {
            l.a().a(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void a(R r, c cVar) {
        if (cVar == null) {
            f fVar = f.c;
            a(r, fVar.n, fVar.o);
            this.b.a("responseBase is null");
            com.kwad.sdk.core.d.a.e("Networking", "request responseBase is null");
        } else if (TextUtils.isEmpty(cVar.b) || cVar.a != 200) {
            a(r, cVar.a, "网络错误");
            com.kwad.sdk.core.network.a.b bVar = this.b;
            bVar.a("httpCodeError:" + cVar.a + ":" + cVar.b);
            StringBuilder sb = new StringBuilder();
            sb.append("request responseBase httpCodeError:");
            sb.append(cVar.a);
            com.kwad.sdk.core.d.a.e("Networking", sb.toString());
        } else {
            try {
                a(r.a(), cVar.b);
                T b = b(cVar.b);
                this.b.d();
                if (b.isResultOk()) {
                    if (!b.isDataEmpty()) {
                        a((i<R, T>) r, (R) b);
                        return;
                    }
                    f fVar2 = f.e;
                    a(r, fVar2.n, fVar2.o);
                    return;
                }
                a(r, b.result, b.errorMsg);
                com.kwad.sdk.core.network.a.b bVar2 = this.b;
                bVar2.a("serverCodeError:" + b.result + ":" + b.errorMsg);
            } catch (Exception e) {
                f fVar3 = f.d;
                a(r, fVar3.n, fVar3.o);
                com.kwad.sdk.core.d.a.b(e);
                com.kwad.sdk.core.network.a.b bVar3 = this.b;
                bVar3.a("parseDataError:" + e.getMessage());
            }
        }
    }

    public void a(@NonNull h<R, T> hVar) {
        this.b.a();
        this.a = hVar;
        d();
    }

    @NonNull
    public abstract T b(String str);

    public boolean c() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void e() {
        super.e();
        this.a = null;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b8: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x00b8 */
    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void f() {
        R r;
        Exception e;
        g gVar;
        g gVar2 = null;
        c cVar = null;
        try {
            try {
                try {
                    r = b();
                    try {
                        this.b.b();
                        a((i<R, T>) r);
                        if (com.ksad.download.c.b.a(KsAdSDKImpl.get().getContext())) {
                            try {
                                String a = r.a();
                                AdHttpProxy proxyForHttp = KsAdSDKImpl.get().getProxyForHttp();
                                cVar = g() ? proxyForHttp.doPost(a, r.c(), r.e()) : proxyForHttp.doPost(a, r.c(), r.d());
                            } catch (Exception e2) {
                                com.kwad.sdk.core.d.a.b(e2);
                                this.b.a("requestError:" + e2.getMessage());
                            }
                            this.b.c();
                            try {
                                a((i<R, T>) r, cVar);
                            } catch (Exception e3) {
                                this.b.a("onResponseError:" + e3.getMessage());
                                com.kwad.sdk.core.d.a.b(e3);
                            }
                        } else {
                            a(r, f.c.n, f.c.o);
                        }
                    } catch (Exception e4) {
                        e = e4;
                        try {
                            this.b.a("requestError:" + e.getMessage());
                        } catch (Exception unused) {
                        }
                        com.kwad.sdk.core.d.a.a(e);
                        if (c() && com.kwad.sdk.core.config.b.ap()) {
                            this.b.a(r.a(), r.b());
                            this.b.e();
                        }
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    gVar2 = gVar;
                    try {
                        if (c() && com.kwad.sdk.core.config.b.ap()) {
                            this.b.a(gVar2.a(), gVar2.b());
                            this.b.e();
                        }
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                r = null;
                e = e5;
            } catch (Throwable th2) {
                th = th2;
                if (c()) {
                    this.b.a(gVar2.a(), gVar2.b());
                    this.b.e();
                }
                throw th;
            }
            if (c() && com.kwad.sdk.core.config.b.ap()) {
                this.b.a(r.a(), r.b());
                this.b.e();
            }
        } catch (Exception unused3) {
        }
    }

    public boolean g() {
        return true;
    }
}
