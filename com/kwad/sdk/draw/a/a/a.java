package com.kwad.sdk.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1980a f40307b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f40308c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40309d = false;

    /* renamed from: com.kwad.sdk.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1980a {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.a = adTemplate;
    }

    public void a() {
        InterfaceC1980a interfaceC1980a;
        if (this.f40309d) {
            return;
        }
        this.f40309d = true;
        if (d.j(this.a).status == 1 || d.j(this.a).status == 2 || d.j(this.a).status == 3) {
            return;
        }
        b bVar = this.f40308c;
        if ((bVar == null || !bVar.a()) && (interfaceC1980a = this.f40307b) != null) {
            interfaceC1980a.a();
        }
    }

    @MainThread
    public void a(InterfaceC1980a interfaceC1980a) {
        this.f40307b = interfaceC1980a;
    }

    @MainThread
    public void a(b bVar) {
        this.f40308c = bVar;
    }
}
