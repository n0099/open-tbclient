package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34845a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0411a f34846b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f34847c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34848d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0411a {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f34845a = adTemplate;
    }

    public void a() {
        InterfaceC0411a interfaceC0411a;
        if (this.f34848d) {
            return;
        }
        this.f34848d = true;
        if (com.kwad.sdk.core.response.b.c.j(this.f34845a).status == DOWNLOADSTAUS.START || com.kwad.sdk.core.response.b.c.j(this.f34845a).status == DOWNLOADSTAUS.DOWNLOADING || com.kwad.sdk.core.response.b.c.j(this.f34845a).status == DOWNLOADSTAUS.PROGRESS) {
            return;
        }
        b bVar = this.f34847c;
        if ((bVar == null || !bVar.a()) && (interfaceC0411a = this.f34846b) != null) {
            interfaceC0411a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0411a interfaceC0411a) {
        this.f34846b = interfaceC0411a;
    }

    @MainThread
    public void a(b bVar) {
        this.f34847c = bVar;
    }
}
