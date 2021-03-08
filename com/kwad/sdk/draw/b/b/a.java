package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private AdTemplate f6413a;
    private InterfaceC1129a b;
    @Nullable
    private b c;
    private boolean d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1129a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f6413a = adTemplate;
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        if (com.kwad.sdk.core.response.b.c.j(this.f6413a).status == DOWNLOADSTAUS.START || com.kwad.sdk.core.response.b.c.j(this.f6413a).status == DOWNLOADSTAUS.DOWNLOADING || com.kwad.sdk.core.response.b.c.j(this.f6413a).status == DOWNLOADSTAUS.PROGRESS) {
            return;
        }
        if ((this.c == null || !this.c.a()) && this.b != null) {
            this.b.a();
        }
    }

    @MainThread
    public void a(InterfaceC1129a interfaceC1129a) {
        this.b = interfaceC1129a;
    }

    @MainThread
    public void a(b bVar) {
        this.c = bVar;
    }
}
