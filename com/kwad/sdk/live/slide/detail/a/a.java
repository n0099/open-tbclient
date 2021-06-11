package com.kwad.sdk.live.slide.detail.a;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.kuaishou.live.audience.KSLiveAudience;
import com.kuaishou.live.audience.listener.KSLiveStateListener;
import com.kwad.sdk.utils.g;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SurfaceTexture f36778a;

    /* renamed from: b  reason: collision with root package name */
    public KSLiveAudience f36779b;

    /* renamed from: c  reason: collision with root package name */
    public List<TextureView.SurfaceTextureListener> f36780c;

    /* renamed from: d  reason: collision with root package name */
    public List<KSLiveStateListener> f36781d;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f36782e;

    /* renamed from: f  reason: collision with root package name */
    public List<InterfaceC0430a> f36783f;

    /* renamed from: g  reason: collision with root package name */
    public g f36784g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36785h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36786i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0430a {
        void a();
    }

    private void b() {
        this.f36782e.clear();
        this.f36781d.clear();
        this.f36780c.clear();
        this.f36783f.clear();
    }

    public void a() {
        KSLiveAudience kSLiveAudience = this.f36779b;
        if (kSLiveAudience != null) {
            kSLiveAudience.destroy();
        }
        b();
        this.f36785h = false;
        this.f36786i = false;
        this.f36778a = null;
        this.f36784g.a((g.a) null);
        for (InterfaceC0430a interfaceC0430a : this.f36783f) {
            interfaceC0430a.a();
        }
    }
}
