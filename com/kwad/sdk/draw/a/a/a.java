package com.kwad.sdk.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2124a f56682b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f56683c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56684d = false;

    /* renamed from: com.kwad.sdk.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2124a {
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
        InterfaceC2124a interfaceC2124a;
        if (this.f56684d) {
            return;
        }
        this.f56684d = true;
        if (d.j(this.a).status == 1 || d.j(this.a).status == 2 || d.j(this.a).status == 3) {
            return;
        }
        b bVar = this.f56683c;
        if ((bVar == null || !bVar.a()) && (interfaceC2124a = this.f56682b) != null) {
            interfaceC2124a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2124a interfaceC2124a) {
        this.f56682b = interfaceC2124a;
    }

    @MainThread
    public void a(b bVar) {
        this.f56683c = bVar;
    }
}
