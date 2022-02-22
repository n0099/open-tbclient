package com.kwad.sdk.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2140a f56894b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f56895c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56896d = false;

    /* renamed from: com.kwad.sdk.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2140a {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.a = adTemplate;
    }

    public void a() {
        InterfaceC2140a interfaceC2140a;
        if (this.f56896d) {
            return;
        }
        this.f56896d = true;
        if (d.j(this.a).status == 1 || d.j(this.a).status == 2 || d.j(this.a).status == 3) {
            return;
        }
        b bVar = this.f56895c;
        if ((bVar == null || !bVar.a()) && (interfaceC2140a = this.f56894b) != null) {
            interfaceC2140a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2140a interfaceC2140a) {
        this.f56894b = interfaceC2140a;
    }

    @MainThread
    public void a(b bVar) {
        this.f56895c = bVar;
    }
}
