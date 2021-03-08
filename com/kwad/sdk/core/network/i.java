package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.export.proxy.AdHttpProxy;
/* loaded from: classes3.dex */
public abstract class i<R extends g, T extends BaseResultData> extends a<R> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private h f6188a = null;

    @Override // com.kwad.sdk.core.network.a
    protected void a(R r, c cVar) {
        if (cVar == null) {
            com.kwad.sdk.core.d.a.d("Networking", "request responseBase is null");
            if (this.f6188a != null) {
                this.f6188a.a(r, f.f6187a.k, f.f6187a.l);
            }
        } else if (TextUtils.isEmpty(cVar.b) || cVar.f6185a != 200) {
            if (this.f6188a != null) {
                this.f6188a.a(r, cVar.f6185a, "网络错误");
            }
        } else {
            try {
                T b = b(cVar.b);
                if (b == null) {
                    if (this.f6188a != null) {
                        this.f6188a.a(r, f.b.k, f.b.l);
                    }
                } else if (!b.isResultOk()) {
                    if (this.f6188a != null) {
                        this.f6188a.a(r, b.result, b.errorMsg);
                    }
                } else if (b.isDataEmpty()) {
                    if (this.f6188a != null) {
                        this.f6188a.a(r, f.c.k, f.c.l);
                    }
                } else if (this.f6188a != null) {
                    this.f6188a.a(r, b);
                }
            } catch (Exception e) {
                if (this.f6188a != null) {
                    this.f6188a.a(r, f.b.k, f.b.l);
                }
                com.kwad.sdk.core.d.a.a(e);
            }
        }
    }

    public void a(@NonNull h hVar) {
        this.f6188a = hVar;
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
        this.f6188a = null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0063 -> B:23:0x004c). Please submit an issue!!! */
    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    protected void f() {
        c cVar;
        R b = b();
        if (this.f6188a != null) {
            this.f6188a.a(b);
        }
        if (!com.ksad.download.d.b.a(KsAdSDKImpl.get().getContext())) {
            if (this.f6188a != null) {
                this.f6188a.a(b, f.f6187a.k, f.f6187a.l);
                return;
            }
            return;
        }
        try {
            String a2 = b.a();
            AdHttpProxy proxyForHttp = KsAdSDKImpl.get().getProxyForHttp();
            cVar = a_() ? proxyForHttp.doPost(a2, b.b(), b.d()) : proxyForHttp.doPost(a2, b.b(), b.c());
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            cVar = null;
        }
        try {
            a(b, cVar);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }
}
