package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private AdTemplate f9987a;

    /* renamed from: b  reason: collision with root package name */
    private InterfaceC1082a f9988b;
    @Nullable
    private b c;
    private boolean d = false;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1082a {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        this.f9987a = adTemplate;
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        if (com.kwad.sdk.core.response.b.c.j(this.f9987a).status == DOWNLOADSTAUS.START || com.kwad.sdk.core.response.b.c.j(this.f9987a).status == DOWNLOADSTAUS.DOWNLOADING || com.kwad.sdk.core.response.b.c.j(this.f9987a).status == DOWNLOADSTAUS.PROGRESS) {
            return;
        }
        if ((this.c == null || !this.c.a()) && this.f9988b != null) {
            this.f9988b.a();
        }
    }

    @MainThread
    public void a(InterfaceC1082a interfaceC1082a) {
        this.f9988b = interfaceC1082a;
    }

    @MainThread
    public void a(b bVar) {
        this.c = bVar;
    }
}
