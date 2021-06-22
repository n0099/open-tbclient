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
    public SurfaceTexture f36876a;

    /* renamed from: b  reason: collision with root package name */
    public KSLiveAudience f36877b;

    /* renamed from: c  reason: collision with root package name */
    public List<TextureView.SurfaceTextureListener> f36878c;

    /* renamed from: d  reason: collision with root package name */
    public List<KSLiveStateListener> f36879d;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f36880e;

    /* renamed from: f  reason: collision with root package name */
    public List<InterfaceC0433a> f36881f;

    /* renamed from: g  reason: collision with root package name */
    public g f36882g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36883h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36884i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0433a {
        void a();
    }

    private void b() {
        this.f36880e.clear();
        this.f36879d.clear();
        this.f36878c.clear();
        this.f36881f.clear();
    }

    public void a() {
        KSLiveAudience kSLiveAudience = this.f36877b;
        if (kSLiveAudience != null) {
            kSLiveAudience.destroy();
        }
        b();
        this.f36883h = false;
        this.f36884i = false;
        this.f36876a = null;
        this.f36882g.a((g.a) null);
        for (InterfaceC0433a interfaceC0433a : this.f36881f) {
            interfaceC0433a.a();
        }
    }
}
