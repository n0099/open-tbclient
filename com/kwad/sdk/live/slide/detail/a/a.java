package com.kwad.sdk.live.slide.detail.a;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.kuaishou.live.audience.KSLiveAudience;
import com.kuaishou.live.audience.listener.KSLiveStateListener;
import com.kwad.sdk.utils.g;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private SurfaceTexture f10779a;

    /* renamed from: b  reason: collision with root package name */
    private KSLiveAudience f10780b;
    private List<TextureView.SurfaceTextureListener> c;
    private List<KSLiveStateListener> d;
    private List<Object> e;
    private List<InterfaceC1115a> f;
    private g g;
    private boolean h;
    private boolean i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1115a {
        void a();
    }

    private void b() {
        this.e.clear();
        this.d.clear();
        this.c.clear();
        this.f.clear();
    }

    public void a() {
        if (this.f10780b != null) {
            this.f10780b.destroy();
        }
        b();
        this.h = false;
        this.i = false;
        this.f10779a = null;
        this.g.a((g.a) null);
        for (InterfaceC1115a interfaceC1115a : this.f) {
            interfaceC1115a.a();
        }
    }
}
