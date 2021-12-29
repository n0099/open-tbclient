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
/* loaded from: classes3.dex */
public abstract class i<R extends g, T extends BaseResultData> extends a<R> {
    @Nullable
    public h<R, T> a = null;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.network.a.b f58098b = new com.kwad.sdk.core.network.a.b();

    private void a(@NonNull R r) {
        h<R, T> hVar = this.a;
        if (hVar == null) {
            return;
        }
        hVar.a(r);
    }

    private void a(@NonNull R r, int i2, String str) {
        h<R, T> hVar = this.a;
        if (hVar == null) {
            return;
        }
        hVar.a(r, i2, str);
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void a(R r, c cVar) {
        if (cVar == null) {
            f fVar = f.f58089c;
            a(r, fVar.n, fVar.o);
            this.f58098b.a("responseBase is null");
            com.kwad.sdk.core.d.a.e("Networking", "request responseBase is null");
        } else if (TextUtils.isEmpty(cVar.f58087b) || cVar.a != 200) {
            a(r, cVar.a, "网络错误");
            com.kwad.sdk.core.network.a.b bVar = this.f58098b;
            bVar.a("httpCodeError:" + cVar.a + ":" + cVar.f58087b);
            StringBuilder sb = new StringBuilder();
            sb.append("request responseBase httpCodeError:");
            sb.append(cVar.a);
            com.kwad.sdk.core.d.a.e("Networking", sb.toString());
        } else {
            try {
                a(r.a(), cVar.f58087b);
                T b2 = b(cVar.f58087b);
                this.f58098b.d();
                if (b2.isResultOk()) {
                    if (!b2.isDataEmpty()) {
                        a((i<R, T>) r, (R) b2);
                        return;
                    }
                    f fVar2 = f.f58091e;
                    a(r, fVar2.n, fVar2.o);
                    return;
                }
                a(r, b2.result, b2.errorMsg);
                com.kwad.sdk.core.network.a.b bVar2 = this.f58098b;
                bVar2.a("serverCodeError:" + b2.result + ":" + b2.errorMsg);
            } catch (Exception e2) {
                f fVar3 = f.f58090d;
                a(r, fVar3.n, fVar3.o);
                com.kwad.sdk.core.d.a.b(e2);
                com.kwad.sdk.core.network.a.b bVar3 = this.f58098b;
                bVar3.a("parseDataError:" + e2.getMessage());
            }
        }
    }

    public void a(@NonNull h<R, T> hVar) {
        this.f58098b.a();
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
        Exception e2;
        g gVar;
        g gVar2 = null;
        c cVar = null;
        try {
            try {
                try {
                    r = b();
                    try {
                        this.f58098b.b();
                        a((i<R, T>) r);
                        if (com.ksad.download.c.b.a(KsAdSDKImpl.get().getContext())) {
                            try {
                                String a = r.a();
                                AdHttpProxy proxyForHttp = KsAdSDKImpl.get().getProxyForHttp();
                                cVar = g() ? proxyForHttp.doPost(a, r.c(), r.e()) : proxyForHttp.doPost(a, r.c(), r.d());
                            } catch (Exception e3) {
                                com.kwad.sdk.core.d.a.b(e3);
                                this.f58098b.a("requestError:" + e3.getMessage());
                            }
                            this.f58098b.c();
                            try {
                                a((i<R, T>) r, cVar);
                            } catch (Exception e4) {
                                this.f58098b.a("onResponseError:" + e4.getMessage());
                                com.kwad.sdk.core.d.a.b(e4);
                            }
                        } else {
                            a(r, f.f58089c.n, f.f58089c.o);
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        try {
                            this.f58098b.a("requestError:" + e2.getMessage());
                        } catch (Exception unused) {
                        }
                        com.kwad.sdk.core.d.a.a(e2);
                        if (c() && com.kwad.sdk.core.config.b.ap()) {
                            this.f58098b.a(r.a(), r.b());
                            this.f58098b.e();
                        }
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    gVar2 = gVar;
                    try {
                        if (c() && com.kwad.sdk.core.config.b.ap()) {
                            this.f58098b.a(gVar2.a(), gVar2.b());
                            this.f58098b.e();
                        }
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                r = null;
                e2 = e6;
            } catch (Throwable th2) {
                th = th2;
                if (c()) {
                    this.f58098b.a(gVar2.a(), gVar2.b());
                    this.f58098b.e();
                }
                throw th;
            }
            if (c() && com.kwad.sdk.core.config.b.ap()) {
                this.f58098b.a(r.a(), r.b());
                this.f58098b.e();
            }
        } catch (Exception unused3) {
        }
    }

    public boolean g() {
        return true;
    }
}
