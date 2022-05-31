package com.kwad.sdk.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class a {
    public AdTemplate a;
    public InterfaceC0320a b;
    @Nullable
    public b c;
    public boolean d = false;

    /* renamed from: com.kwad.sdk.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0320a {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.a = adTemplate;
    }

    public void a() {
        InterfaceC0320a interfaceC0320a;
        if (this.d) {
            return;
        }
        this.d = true;
        if (d.j(this.a).status == 1 || d.j(this.a).status == 2 || d.j(this.a).status == 3) {
            return;
        }
        b bVar = this.c;
        if ((bVar == null || !bVar.a()) && (interfaceC0320a = this.b) != null) {
            interfaceC0320a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0320a interfaceC0320a) {
        this.b = interfaceC0320a;
    }

    @MainThread
    public void a(b bVar) {
        this.c = bVar;
    }
}
