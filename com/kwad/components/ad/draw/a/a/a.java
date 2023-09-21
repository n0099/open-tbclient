package com.kwad.components.ad.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class a {
    @Nullable
    public b bA;
    public boolean bB = false;
    public InterfaceC0587a bz;
    public AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0587a {
        void ax();
    }

    /* loaded from: classes10.dex */
    public interface b {
        boolean ay();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0587a interfaceC0587a) {
        this.bz = interfaceC0587a;
    }

    @MainThread
    public final void a(b bVar) {
        this.bA = bVar;
    }

    public final void aw() {
        InterfaceC0587a interfaceC0587a;
        if (this.bB) {
            return;
        }
        this.bB = true;
        if (d.bQ(this.mAdTemplate).status == 1 || d.bQ(this.mAdTemplate).status == 2 || d.bQ(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.bA;
        if ((bVar == null || !bVar.ay()) && (interfaceC0587a = this.bz) != null) {
            interfaceC0587a.ax();
        }
    }
}
