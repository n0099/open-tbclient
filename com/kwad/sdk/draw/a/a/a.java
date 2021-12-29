package com.kwad.sdk.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2107a f58901b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f58902c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58903d = false;

    /* renamed from: com.kwad.sdk.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2107a {
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
        InterfaceC2107a interfaceC2107a;
        if (this.f58903d) {
            return;
        }
        this.f58903d = true;
        if (d.j(this.a).status == 1 || d.j(this.a).status == 2 || d.j(this.a).status == 3) {
            return;
        }
        b bVar = this.f58902c;
        if ((bVar == null || !bVar.a()) && (interfaceC2107a = this.f58901b) != null) {
            interfaceC2107a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2107a interfaceC2107a) {
        this.f58901b = interfaceC2107a;
    }

    @MainThread
    public void a(b bVar) {
        this.f58902c = bVar;
    }
}
