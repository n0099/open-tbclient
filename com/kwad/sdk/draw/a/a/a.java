package com.kwad.sdk.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2119a f55244b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f55245c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55246d = false;

    /* renamed from: com.kwad.sdk.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2119a {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.a = adTemplate;
    }

    public void a() {
        InterfaceC2119a interfaceC2119a;
        if (this.f55246d) {
            return;
        }
        this.f55246d = true;
        if (d.j(this.a).status == 1 || d.j(this.a).status == 2 || d.j(this.a).status == 3) {
            return;
        }
        b bVar = this.f55245c;
        if ((bVar == null || !bVar.a()) && (interfaceC2119a = this.f55244b) != null) {
            interfaceC2119a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2119a interfaceC2119a) {
        this.f55244b = interfaceC2119a;
    }

    @MainThread
    public void a(b bVar) {
        this.f55245c = bVar;
    }
}
