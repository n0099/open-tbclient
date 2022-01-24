package com.kwad.sdk.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2130a f56727b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f56728c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56729d = false;

    /* renamed from: com.kwad.sdk.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2130a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.a = adTemplate;
    }

    public void a() {
        InterfaceC2130a interfaceC2130a;
        if (this.f56729d) {
            return;
        }
        this.f56729d = true;
        if (d.j(this.a).status == 1 || d.j(this.a).status == 2 || d.j(this.a).status == 3) {
            return;
        }
        b bVar = this.f56728c;
        if ((bVar == null || !bVar.a()) && (interfaceC2130a = this.f56727b) != null) {
            interfaceC2130a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2130a interfaceC2130a) {
        this.f56727b = interfaceC2130a;
    }

    @MainThread
    public void a(b bVar) {
        this.f56728c = bVar;
    }
}
