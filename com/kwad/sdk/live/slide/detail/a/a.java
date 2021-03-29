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
    public SurfaceTexture f36069a;

    /* renamed from: b  reason: collision with root package name */
    public KSLiveAudience f36070b;

    /* renamed from: c  reason: collision with root package name */
    public List<TextureView.SurfaceTextureListener> f36071c;

    /* renamed from: d  reason: collision with root package name */
    public List<KSLiveStateListener> f36072d;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f36073e;

    /* renamed from: f  reason: collision with root package name */
    public List<InterfaceC0430a> f36074f;

    /* renamed from: g  reason: collision with root package name */
    public g f36075g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36076h;
    public boolean i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0430a {
        void a();
    }

    private void b() {
        this.f36073e.clear();
        this.f36072d.clear();
        this.f36071c.clear();
        this.f36074f.clear();
    }

    public void a() {
        KSLiveAudience kSLiveAudience = this.f36070b;
        if (kSLiveAudience != null) {
            kSLiveAudience.destroy();
        }
        b();
        this.f36076h = false;
        this.i = false;
        this.f36069a = null;
        this.f36075g.a((g.a) null);
        for (InterfaceC0430a interfaceC0430a : this.f36074f) {
            interfaceC0430a.a();
        }
    }
}
