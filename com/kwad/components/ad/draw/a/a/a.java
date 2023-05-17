package com.kwad.components.ad.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class a {
    @Nullable
    public b bA;
    public boolean bB = false;
    public InterfaceC0561a bz;
    public AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0561a {
        void ax();
    }

    /* loaded from: classes9.dex */
    public interface b {
        boolean ay();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0561a interfaceC0561a) {
        this.bz = interfaceC0561a;
    }

    @MainThread
    public final void a(b bVar) {
        this.bA = bVar;
    }

    public final void aw() {
        InterfaceC0561a interfaceC0561a;
        if (this.bB) {
            return;
        }
        this.bB = true;
        if (d.bQ(this.mAdTemplate).status == 1 || d.bQ(this.mAdTemplate).status == 2 || d.bQ(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.bA;
        if ((bVar == null || !bVar.ay()) && (interfaceC0561a = this.bz) != null) {
            interfaceC0561a.ax();
        }
    }
}
