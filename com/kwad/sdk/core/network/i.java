package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.export.proxy.AdHttpProxy;
/* loaded from: classes4.dex */
public abstract class i<R extends g, T extends BaseResultData> extends a<R> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private h f9323a = null;

    @Override // com.kwad.sdk.core.network.a
    protected void a(R r, c cVar) {
        if (cVar == null) {
            com.kwad.sdk.core.d.a.d("Networking", "request responseBase is null");
            if (this.f9323a != null) {
                this.f9323a.a(r, f.f9321a.k, f.f9321a.l);
            }
        } else if (TextUtils.isEmpty(cVar.f9319b) || cVar.f9318a != 200) {
            if (this.f9323a != null) {
                this.f9323a.a(r, cVar.f9318a, "网络错误");
            }
        } else {
            try {
                T b2 = b(cVar.f9319b);
                if (b2 == null) {
                    if (this.f9323a != null) {
                        this.f9323a.a(r, f.f9322b.k, f.f9322b.l);
                    }
                } else if (!b2.isResultOk()) {
                    if (this.f9323a != null) {
                        this.f9323a.a(r, b2.result, b2.errorMsg);
                    }
                } else if (b2.isDataEmpty()) {
                    if (this.f9323a != null) {
                        this.f9323a.a(r, f.c.k, f.c.l);
                    }
                } else if (this.f9323a != null) {
                    this.f9323a.a(r, b2);
                }
            } catch (Exception e) {
                if (this.f9323a != null) {
                    this.f9323a.a(r, f.f9322b.k, f.f9322b.l);
                }
                com.kwad.sdk.core.d.a.a(e);
            }
        }
    }

    public void a(@NonNull h hVar) {
        this.f9323a = hVar;
        d();
    }

    protected boolean a_() {
        return true;
    }

    @NonNull
    protected abstract T b(String str);

    @Override // com.kwad.sdk.core.network.a
    public void e() {
        super.e();
        this.f9323a = null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0063 -> B:23:0x004c). Please submit an issue!!! */
    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    protected void f() {
        c cVar;
        R b2 = b();
        if (this.f9323a != null) {
            this.f9323a.a(b2);
        }
        if (!com.ksad.download.d.b.a(KsAdSDKImpl.get().getContext())) {
            if (this.f9323a != null) {
                this.f9323a.a(b2, f.f9321a.k, f.f9321a.l);
                return;
            }
            return;
        }
        try {
            String a2 = b2.a();
            AdHttpProxy proxyForHttp = KsAdSDKImpl.get().getProxyForHttp();
            cVar = a_() ? proxyForHttp.doPost(a2, b2.b(), b2.d()) : proxyForHttp.doPost(a2, b2.b(), b2.c());
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            cVar = null;
        }
        try {
            a(b2, cVar);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }
}
