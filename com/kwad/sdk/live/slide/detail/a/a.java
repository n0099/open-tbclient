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
    public SurfaceTexture f36358a;

    /* renamed from: b  reason: collision with root package name */
    public KSLiveAudience f36359b;

    /* renamed from: c  reason: collision with root package name */
    public List<TextureView.SurfaceTextureListener> f36360c;

    /* renamed from: d  reason: collision with root package name */
    public List<KSLiveStateListener> f36361d;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f36362e;

    /* renamed from: f  reason: collision with root package name */
    public List<InterfaceC0444a> f36363f;

    /* renamed from: g  reason: collision with root package name */
    public g f36364g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36365h;
    public boolean i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0444a {
        void a();
    }

    private void b() {
        this.f36362e.clear();
        this.f36361d.clear();
        this.f36360c.clear();
        this.f36363f.clear();
    }

    public void a() {
        KSLiveAudience kSLiveAudience = this.f36359b;
        if (kSLiveAudience != null) {
            kSLiveAudience.destroy();
        }
        b();
        this.f36365h = false;
        this.i = false;
        this.f36358a = null;
        this.f36364g.a((g.a) null);
        for (InterfaceC0444a interfaceC0444a : this.f36363f) {
            interfaceC0444a.a();
        }
    }
}
