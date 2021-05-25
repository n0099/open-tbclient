package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33084a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0378a f33085b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f33086c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33087d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0378a {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f33084a = adTemplate;
    }

    public void a() {
        InterfaceC0378a interfaceC0378a;
        if (this.f33087d) {
            return;
        }
        this.f33087d = true;
        if (com.kwad.sdk.core.response.b.c.g(this.f33084a).status == 1 || com.kwad.sdk.core.response.b.c.g(this.f33084a).status == 2 || com.kwad.sdk.core.response.b.c.g(this.f33084a).status == 3) {
            return;
        }
        b bVar = this.f33086c;
        if ((bVar == null || !bVar.a()) && (interfaceC0378a = this.f33085b) != null) {
            interfaceC0378a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0378a interfaceC0378a) {
        this.f33085b = interfaceC0378a;
    }

    @MainThread
    public void a(b bVar) {
        this.f33086c = bVar;
    }
}
