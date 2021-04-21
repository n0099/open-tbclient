package com.kwad.sdk.live.slide.detail.a;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.kuaishou.live.audience.KSLiveAudience;
import com.kuaishou.live.audience.listener.KSLiveStateListener;
import com.kwad.sdk.utils.g;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SurfaceTexture f36453a;

    /* renamed from: b  reason: collision with root package name */
    public KSLiveAudience f36454b;

    /* renamed from: c  reason: collision with root package name */
    public List<TextureView.SurfaceTextureListener> f36455c;

    /* renamed from: d  reason: collision with root package name */
    public List<KSLiveStateListener> f36456d;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f36457e;

    /* renamed from: f  reason: collision with root package name */
    public List<InterfaceC0447a> f36458f;

    /* renamed from: g  reason: collision with root package name */
    public g f36459g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36460h;
    public boolean i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0447a {
        void a();
    }

    private void b() {
        this.f36457e.clear();
        this.f36456d.clear();
        this.f36455c.clear();
        this.f36458f.clear();
    }

    public void a() {
        KSLiveAudience kSLiveAudience = this.f36454b;
        if (kSLiveAudience != null) {
            kSLiveAudience.destroy();
        }
        b();
        this.f36460h = false;
        this.i = false;
        this.f36453a = null;
        this.f36459g.a((g.a) null);
        for (InterfaceC0447a interfaceC0447a : this.f36458f) {
            interfaceC0447a.a();
        }
    }
}
