package com.kwad.sdk.live.slide.detail.a;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.live.audience.KSLiveAudience;
import com.kuaishou.live.audience.listener.KSLiveStateListener;
import com.kwad.sdk.utils.g;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceTexture f38639a;

    /* renamed from: b  reason: collision with root package name */
    public KSLiveAudience f38640b;

    /* renamed from: c  reason: collision with root package name */
    public List<TextureView.SurfaceTextureListener> f38641c;

    /* renamed from: d  reason: collision with root package name */
    public List<KSLiveStateListener> f38642d;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f38643e;

    /* renamed from: f  reason: collision with root package name */
    public List<InterfaceC0477a> f38644f;

    /* renamed from: g  reason: collision with root package name */
    public g f38645g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38646h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38647i;

    /* renamed from: com.kwad.sdk.live.slide.detail.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0477a {
        void a();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, this) == null) {
            this.f38643e.clear();
            this.f38642d.clear();
            this.f38641c.clear();
            this.f38644f.clear();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            KSLiveAudience kSLiveAudience = this.f38640b;
            if (kSLiveAudience != null) {
                kSLiveAudience.destroy();
            }
            b();
            this.f38646h = false;
            this.f38647i = false;
            this.f38639a = null;
            this.f38645g.a((g.a) null);
            for (InterfaceC0477a interfaceC0477a : this.f38644f) {
                interfaceC0477a.a();
            }
        }
    }
}
