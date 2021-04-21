package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34940a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0414a f34941b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f34942c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34943d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0414a {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f34940a = adTemplate;
    }

    public void a() {
        InterfaceC0414a interfaceC0414a;
        if (this.f34943d) {
            return;
        }
        this.f34943d = true;
        if (com.kwad.sdk.core.response.b.c.j(this.f34940a).status == DOWNLOADSTAUS.START || com.kwad.sdk.core.response.b.c.j(this.f34940a).status == DOWNLOADSTAUS.DOWNLOADING || com.kwad.sdk.core.response.b.c.j(this.f34940a).status == DOWNLOADSTAUS.PROGRESS) {
            return;
        }
        b bVar = this.f34942c;
        if ((bVar == null || !bVar.a()) && (interfaceC0414a = this.f34941b) != null) {
            interfaceC0414a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0414a interfaceC0414a) {
        this.f34941b = interfaceC0414a;
    }

    @MainThread
    public void a(b bVar) {
        this.f34942c = bVar;
    }
}
