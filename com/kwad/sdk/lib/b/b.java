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
/* loaded from: classes4.dex */
public abstract class b<MODEL, PAGE extends BaseResultData> extends a<PAGE, MODEL> {
    private Handler c = new Handler(Looper.getMainLooper());
    private boolean d;
    private boolean e;
    private boolean f;
    private i<com.kwad.sdk.core.network.g, PAGE> g;
    private PAGE h;

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(int i, String str) {
        com.kwad.sdk.core.d.a.c("BasePageList", "onError: errorCode" + i + "--errorMsg:" + str);
        boolean n = n();
        this.d = a(i);
        this.e = false;
        this.f = false;
        this.g = null;
        this.f10421b.a(n, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(PAGE page, boolean z) {
        boolean n = n();
        this.d = b((b<MODEL, PAGE>) page);
        a((b<MODEL, PAGE>) page, this.f10420a);
        this.h = page;
        this.f10421b.b(n, z);
        this.e = false;
        this.f = false;
        this.g = null;
    }

    protected abstract i<com.kwad.sdk.core.network.g, PAGE> a();

    protected abstract List<MODEL> a(PAGE page);

    protected void a(PAGE page, List<MODEL> list) {
        if (n()) {
            list.clear();
        }
        List<MODEL> a2 = a((b<MODEL, PAGE>) page);
        if (a2 == null) {
            return;
        }
        list.addAll(a2);
    }

    protected boolean a(int i) {
        return true;
    }

    protected boolean b() {
        return false;
    }

    protected boolean b(PAGE page) {
        return true;
    }

    protected PAGE d() {
        return null;
    }

    @Override // com.kwad.sdk.lib.b.c
    public final void h() {
        if (this.g != null) {
            this.g.e();
        }
        i();
    }

    public final void i() {
        this.f10421b.a();
    }

    @Override // com.kwad.sdk.lib.b.c
    public final boolean j() {
        return this.d;
    }

    @Override // com.kwad.sdk.lib.b.c
    public void k() {
        l();
        m();
    }

    public void l() {
        this.f = true;
    }

    @Override // com.kwad.sdk.lib.b.c
    public void m() {
        final PAGE d;
        if (this.e) {
            return;
        }
        if (this.d || this.f) {
            this.e = true;
            if (n() && b() && (d = d()) != null) {
                this.f10421b.a(n(), true);
                this.c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a((b) d, true);
                    }
                });
                return;
            }
            this.g = a();
            if (this.g != null) {
                this.f10421b.a(n(), false);
                this.g.a(new j<com.kwad.sdk.core.network.g, PAGE>() { // from class: com.kwad.sdk.lib.b.b.2
                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i, final String str) {
                        b.this.c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a(i, str);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final PAGE page) {
                        b.this.c.post(new Runnable() { // from class: com.kwad.sdk.lib.b.b.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a((b) page, false);
                            }
                        });
                    }
                });
                return;
            }
            this.d = false;
            this.e = false;
            this.f = false;
        }
    }

    public final boolean n() {
        return this.h == null || this.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.c
    @Nullable
    /* renamed from: o */
    public PAGE p() {
        return this.h;
    }
}
