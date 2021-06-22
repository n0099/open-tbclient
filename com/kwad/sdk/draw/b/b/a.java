package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f35306a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0400a f35307b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f35308c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35309d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0400a {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f35306a = adTemplate;
    }

    public void a() {
        InterfaceC0400a interfaceC0400a;
        if (this.f35309d) {
            return;
        }
        this.f35309d = true;
        if (com.kwad.sdk.core.response.b.c.j(this.f35306a).status == DOWNLOADSTAUS.START || com.kwad.sdk.core.response.b.c.j(this.f35306a).status == DOWNLOADSTAUS.DOWNLOADING || com.kwad.sdk.core.response.b.c.j(this.f35306a).status == DOWNLOADSTAUS.PROGRESS) {
            return;
        }
        b bVar = this.f35308c;
        if ((bVar == null || !bVar.a()) && (interfaceC0400a = this.f35307b) != null) {
            interfaceC0400a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0400a interfaceC0400a) {
        this.f35307b = interfaceC0400a;
    }

    @MainThread
    public void a(b bVar) {
        this.f35308c = bVar;
    }
}
