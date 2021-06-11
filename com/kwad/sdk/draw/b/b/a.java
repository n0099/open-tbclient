package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f35208a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0397a f35209b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f35210c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35211d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0397a {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f35208a = adTemplate;
    }

    public void a() {
        InterfaceC0397a interfaceC0397a;
        if (this.f35211d) {
            return;
        }
        this.f35211d = true;
        if (com.kwad.sdk.core.response.b.c.j(this.f35208a).status == DOWNLOADSTAUS.START || com.kwad.sdk.core.response.b.c.j(this.f35208a).status == DOWNLOADSTAUS.DOWNLOADING || com.kwad.sdk.core.response.b.c.j(this.f35208a).status == DOWNLOADSTAUS.PROGRESS) {
            return;
        }
        b bVar = this.f35210c;
        if ((bVar == null || !bVar.a()) && (interfaceC0397a = this.f35209b) != null) {
            interfaceC0397a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0397a interfaceC0397a) {
        this.f35209b = interfaceC0397a;
    }

    @MainThread
    public void a(b bVar) {
        this.f35210c = bVar;
    }
}
