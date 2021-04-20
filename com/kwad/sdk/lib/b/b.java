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
    public Handler f36238c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public boolean f36239d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36240e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36241f;

    /* renamed from: g  reason: collision with root package name */
    public i<com.kwad.sdk.core.network.g, PAGE> f36242g;

    /* renamed from: h  reason: collision with root package name */
    public PAGE f36243h;

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(int i, String str) {
        com.kwad.sdk.core.d.a.c("BasePageList", "onError: errorCode" + i + "--errorMsg:" + str);
        boolean n = n();
        this.f36239d = a(i);
        this.f36240e = false;
        this.f36241f = false;
        this.f36242g = null;
        this.f36237b.a(n, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(PAGE page, boolean z) {
        boolean n = n();
        this.f36239d = b((b<MODEL, PAGE>) page);
        a((b<MODEL, PAGE>) page, this.f36236a);
        this.f36243h = page;
        this.f36237b.b(n, z);
        this.f36240e = false;
        this.f36241f = false;
        this.f36242g = null;
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
        i<com.kwad.sdk.core.network.g, PAGE> iVar = this.f36242g;
        if (iVar != null) {
            iVar.e();
        }
        i();
    }

    public final void i() {
        this.f36237b.a();
    }

    @Override // com.kwad.sdk.lib.b.c
    public final boolean j() {
        return this.f36239d;
    }

    @Override // com.kwad.sdk.lib.b.c
    public void k() {
        l();
        m();
    }

    public void l() {
        this.f36241f = true;
    }

    @Override // com.kwad.sdk.lib.b.c
    public void m() {
        final PAGE d2;
        if (this.f36240e) {
            return;
        }
        if (this.f36239d || this.f36241f) {
            this.f36240e = true;
            if (n() && b() && (d2 = d()) != null) {
                this.f36237b.a(n(), true);
                this.f36238c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a((b) d2, true);
                    }
                });
                return;
            }
            i<com.kwad.sdk.core.network.g, PAGE> a2 = a();
            this.f36242g = a2;
            if (a2 != null) {
                this.f36237b.a(n(), false);
                this.f36242g.a(new j<com.kwad.sdk.core.network.g, PAGE>() { // from class: com.kwad.sdk.lib.b.b.2
                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i, final String str) {
                        b.this.f36238c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a(i, str);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final PAGE page) {
                        b.this.f36238c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a((b) page, false);
                            }
                        });
                    }
                });
                return;
            }
            this.f36239d = false;
            this.f36240e = false;
            this.f36241f = false;
        }
    }

    public final boolean n() {
        return this.f36243h == null || this.f36241f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.c
    @Nullable
    /* renamed from: o */
    public PAGE p() {
        return this.f36243h;
    }
}
