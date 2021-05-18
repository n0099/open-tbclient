package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33155a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0377a f33156b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f33157c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33158d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0377a {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f33155a = adTemplate;
    }

    public void a() {
        InterfaceC0377a interfaceC0377a;
        if (this.f33158d) {
            return;
        }
        this.f33158d = true;
        if (com.kwad.sdk.core.response.b.c.g(this.f33155a).status == 1 || com.kwad.sdk.core.response.b.c.g(this.f33155a).status == 2 || com.kwad.sdk.core.response.b.c.g(this.f33155a).status == 3) {
            return;
        }
        b bVar = this.f33157c;
        if ((bVar == null || !bVar.a()) && (interfaceC0377a = this.f33156b) != null) {
            interfaceC0377a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0377a interfaceC0377a) {
        this.f33156b = interfaceC0377a;
    }

    @MainThread
    public void a(b bVar) {
        this.f33157c = bVar;
    }
}
