package com.kwad.sdk.lib.b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class b<MODEL, PAGE extends BaseResultData> extends a<PAGE, MODEL> {

    /* renamed from: c  reason: collision with root package name */
    public Handler f35949c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public boolean f35950d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35951e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35952f;

    /* renamed from: g  reason: collision with root package name */
    public i<com.kwad.sdk.core.network.g, PAGE> f35953g;

    /* renamed from: h  reason: collision with root package name */
    public PAGE f35954h;

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(int i, String str) {
        com.kwad.sdk.core.d.a.c("BasePageList", "onError: errorCode" + i + "--errorMsg:" + str);
        boolean n = n();
        this.f35950d = a(i);
        this.f35951e = false;
        this.f35952f = false;
        this.f35953g = null;
        this.f35948b.a(n, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(PAGE page, boolean z) {
        boolean n = n();
        this.f35950d = b((b<MODEL, PAGE>) page);
        a((b<MODEL, PAGE>) page, this.f35947a);
        this.f35954h = page;
        this.f35948b.b(n, z);
        this.f35951e = false;
        this.f35952f = false;
        this.f35953g = null;
    }

    public abstract i<com.kwad.sdk.core.network.g, PAGE> a();

    public abstract List<MODEL> a(PAGE page);

    public void a(PAGE page, List<MODEL> list) {
        if (n()) {
            list.clear();
        }
        List<MODEL> a2 = a((b<MODEL, PAGE>) page);
        if (a2 == null) {
            return;
        }
        list.addAll(a2);
    }

    public boolean a(int i) {
        return true;
    }

    public boolean b() {
        return false;
    }

    public boolean b(PAGE page) {
        return true;
    }

    public PAGE d() {
        return null;
    }

    @Override // com.kwad.sdk.lib.b.c
    public final void h() {
        i<com.kwad.sdk.core.network.g, PAGE> iVar = this.f35953g;
        if (iVar != null) {
            iVar.e();
        }
        i();
    }

    public final void i() {
        this.f35948b.a();
    }

    @Override // com.kwad.sdk.lib.b.c
    public final boolean j() {
        return this.f35950d;
    }

    @Override // com.kwad.sdk.lib.b.c
    public void k() {
        l();
        m();
    }

    public void l() {
        this.f35952f = true;
    }

    @Override // com.kwad.sdk.lib.b.c
    public void m() {
        final PAGE d2;
        if (this.f35951e) {
            return;
        }
        if (this.f35950d || this.f35952f) {
            this.f35951e = true;
            if (n() && b() && (d2 = d()) != null) {
                this.f35948b.a(n(), true);
                this.f35949c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a((b) d2, true);
                    }
                });
                return;
            }
            i<com.kwad.sdk.core.network.g, PAGE> a2 = a();
            this.f35953g = a2;
            if (a2 != null) {
                this.f35948b.a(n(), false);
                this.f35953g.a(new j<com.kwad.sdk.core.network.g, PAGE>() { // from class: com.kwad.sdk.lib.b.b.2
                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i, final String str) {
                        b.this.f35949c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a(i, str);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final PAGE page) {
                        b.this.f35949c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a((b) page, false);
                            }
                        });
                    }
                });
                return;
            }
            this.f35950d = false;
            this.f35951e = false;
            this.f35952f = false;
        }
    }

    public final boolean n() {
        return this.f35954h == null || this.f35952f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.c
    @Nullable
    /* renamed from: o */
    public PAGE p() {
        return this.f35954h;
    }
}
