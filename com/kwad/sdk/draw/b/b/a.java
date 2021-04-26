package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33910a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0390a f33911b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f33912c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33913d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0390a {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f33910a = adTemplate;
    }

    public void a() {
        InterfaceC0390a interfaceC0390a;
        if (this.f33913d) {
            return;
        }
        this.f33913d = true;
        if (com.kwad.sdk.core.response.b.c.g(this.f33910a).status == 1 || com.kwad.sdk.core.response.b.c.g(this.f33910a).status == 2 || com.kwad.sdk.core.response.b.c.g(this.f33910a).status == 3) {
            return;
        }
        b bVar = this.f33912c;
        if ((bVar == null || !bVar.a()) && (interfaceC0390a = this.f33911b) != null) {
            interfaceC0390a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0390a interfaceC0390a) {
        this.f33911b = interfaceC0390a;
    }

    @MainThread
    public void a(b bVar) {
        this.f33912c = bVar;
    }
}
