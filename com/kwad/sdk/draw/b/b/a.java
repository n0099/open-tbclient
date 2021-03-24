package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34555a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0396a f34556b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f34557c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34558d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0396a {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f34555a = adTemplate;
    }

    public void a() {
        InterfaceC0396a interfaceC0396a;
        if (this.f34558d) {
            return;
        }
        this.f34558d = true;
        if (com.kwad.sdk.core.response.b.c.j(this.f34555a).status == DOWNLOADSTAUS.START || com.kwad.sdk.core.response.b.c.j(this.f34555a).status == DOWNLOADSTAUS.DOWNLOADING || com.kwad.sdk.core.response.b.c.j(this.f34555a).status == DOWNLOADSTAUS.PROGRESS) {
            return;
        }
        b bVar = this.f34557c;
        if ((bVar == null || !bVar.a()) && (interfaceC0396a = this.f34556b) != null) {
            interfaceC0396a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0396a interfaceC0396a) {
        this.f34556b = interfaceC0396a;
    }

    @MainThread
    public void a(b bVar) {
        this.f34557c = bVar;
    }
}
