package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes4.dex */
public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private c.e f9440a;

    /* renamed from: b  reason: collision with root package name */
    private c.b f9441b;
    private c.a c;
    private c.f d;
    private c.h e;
    private c.InterfaceC1100c f;
    private c.d g;
    private c.g h;

    public void a() {
        this.f9440a = null;
        this.c = null;
        this.f9441b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        if (this.c != null) {
            this.c.a(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i, int i2) {
        if (this.e != null) {
            this.e.a(this, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(TimedText timedText) {
        if (this.h != null) {
            this.h.a(this, timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        this.c = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        this.f9441b = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC1100c interfaceC1100c) {
        this.f = interfaceC1100c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        this.g = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        this.f9440a = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        this.d = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        this.e = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        if (this.f9440a != null) {
            this.f9440a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(int i, int i2) {
        return this.f != null && this.f.a(this, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (this.f9441b != null) {
            this.f9441b.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c(int i, int i2) {
        return this.g != null && this.g.a(this, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        if (this.d != null) {
            this.d.a(this);
        }
    }
}
