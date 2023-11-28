package com.kwad.components.ad.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class a {
    public InterfaceC0582a cF;
    @Nullable
    public b cG;
    public boolean cH = false;
    public AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0582a {
        void aq();
    }

    /* loaded from: classes10.dex */
    public interface b {
        boolean ar();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0582a interfaceC0582a) {
        this.cF = interfaceC0582a;
    }

    @MainThread
    public final void a(b bVar) {
        this.cG = bVar;
    }

    public final void ap() {
        InterfaceC0582a interfaceC0582a;
        if (this.cH) {
            return;
        }
        this.cH = true;
        if (e.dP(this.mAdTemplate).status != 1 && e.dP(this.mAdTemplate).status != 2 && e.dP(this.mAdTemplate).status != 3) {
            b bVar = this.cG;
            if ((bVar == null || !bVar.ar()) && (interfaceC0582a = this.cF) != null) {
                interfaceC0582a.aq();
            }
        }
    }
}
