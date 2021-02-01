package com.kwad.sdk.live.slide.detail.a;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.kuaishou.live.audience.KSLiveAudience;
import com.kuaishou.live.audience.listener.KSLiveStateListener;
import com.kwad.sdk.utils.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private SurfaceTexture f10482a;

    /* renamed from: b  reason: collision with root package name */
    private KSLiveAudience f10483b;
    private List<TextureView.SurfaceTextureListener> c;
    private List<KSLiveStateListener> d;
    private List<Object> e;
    private List<InterfaceC1143a> f;
    private g g;
    private boolean h;
    private boolean i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1143a {
        void a();
    }

    private void b() {
        this.e.clear();
        this.d.clear();
        this.c.clear();
        this.f.clear();
    }

    public void a() {
        if (this.f10483b != null) {
            this.f10483b.destroy();
        }
        b();
        this.h = false;
        this.i = false;
        this.f10482a = null;
        this.g.a((g.a) null);
        for (InterfaceC1143a interfaceC1143a : this.f) {
            interfaceC1143a.a();
        }
    }
}
