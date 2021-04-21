package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.export.proxy.AdHttpProxy;
/* loaded from: classes6.dex */
public abstract class i<R extends g, T extends BaseResultData> extends a<R> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public h f34261a = null;

    @Override // com.kwad.sdk.core.network.a
    public void a(R r, c cVar) {
        if (cVar == null) {
            com.kwad.sdk.core.d.a.d("Networking", "request responseBase is null");
            h hVar = this.f34261a;
            if (hVar != null) {
                f fVar = f.f34253a;
                hVar.a(r, fVar.k, fVar.l);
            }
        } else if (TextUtils.isEmpty(cVar.f34251b) || cVar.f34250a != 200) {
            h hVar2 = this.f34261a;
            if (hVar2 != null) {
                hVar2.a(r, cVar.f34250a, "网络错误");
            }
        } else {
            try {
                T b2 = b(cVar.f34251b);
                if (b2 == null) {
                    h hVar3 = this.f34261a;
                    if (hVar3 != null) {
                        f fVar2 = f.f34254b;
                        hVar3.a(r, fVar2.k, fVar2.l);
                    }
                } else if (!b2.isResultOk()) {
                    h hVar4 = this.f34261a;
                    if (hVar4 != null) {
                        hVar4.a(r, b2.result, b2.errorMsg);
                    }
                } else if (!b2.isDataEmpty()) {
                    h hVar5 = this.f34261a;
                    if (hVar5 != null) {
                        hVar5.a(r, b2);
                    }
                } else {
                    h hVar6 = this.f34261a;
                    if (hVar6 != null) {
                        f fVar3 = f.f34255c;
                        hVar6.a(r, fVar3.k, fVar3.l);
                    }
                }
            } catch (Exception e2) {
                h hVar7 = this.f34261a;
                if (hVar7 != null) {
                    f fVar4 = f.f34254b;
                    hVar7.a(r, fVar4.k, fVar4.l);
                }
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    public void a(@NonNull h hVar) {
        this.f34261a = hVar;
        d();
    }

    public boolean a_() {
        return true;
    }

    @NonNull
    public abstract T b(String str);

    @Override // com.kwad.sdk.core.network.a
    public void e() {
        super.e();
        this.f34261a = null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0055 -> B:24:0x0058). Please submit an issue!!! */
    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void f() {
        R b2 = b();
        h hVar = this.f34261a;
        if (hVar != null) {
            hVar.a(b2);
        }
        if (!com.ksad.download.d.b.a(KsAdSDKImpl.get().getContext())) {
            h hVar2 = this.f34261a;
            if (hVar2 != null) {
                f fVar = f.f34253a;
                hVar2.a(b2, fVar.k, fVar.l);
                return;
            }
            return;
        }
        c cVar = null;
        try {
            String a2 = b2.a();
            AdHttpProxy proxyForHttp = KsAdSDKImpl.get().getProxyForHttp();
            cVar = a_() ? proxyForHttp.doPost(a2, b2.b(), b2.d()) : proxyForHttp.doPost(a2, b2.b(), b2.c());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        try {
            a(b2, cVar);
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.a(e3);
        }
    }
}
