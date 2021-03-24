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
    public SurfaceTexture f36068a;

    /* renamed from: b  reason: collision with root package name */
    public KSLiveAudience f36069b;

    /* renamed from: c  reason: collision with root package name */
    public List<TextureView.SurfaceTextureListener> f36070c;

    /* renamed from: d  reason: collision with root package name */
    public List<KSLiveStateListener> f36071d;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f36072e;

    /* renamed from: f  reason: collision with root package name */
    public List<InterfaceC0429a> f36073f;

    /* renamed from: g  reason: collision with root package name */
    public g f36074g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36075h;
    public boolean i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0429a {
        void a();
    }

    private void b() {
        this.f36072e.clear();
        this.f36071d.clear();
        this.f36070c.clear();
        this.f36073f.clear();
    }

    public void a() {
        KSLiveAudience kSLiveAudience = this.f36069b;
        if (kSLiveAudience != null) {
            kSLiveAudience.destroy();
        }
        b();
        this.f36075h = false;
        this.i = false;
        this.f36068a = null;
        this.f36074g.a((g.a) null);
        for (InterfaceC0429a interfaceC0429a : this.f36073f) {
            interfaceC0429a.a();
        }
    }
}
