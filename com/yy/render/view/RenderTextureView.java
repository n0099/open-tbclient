package com.yy.render.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.egb;
import com.yy.render.IRemoteRender;
import com.yy.render.RenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b8\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b8\u0010;B#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010<\u001a\u00020\u001c¢\u0006\u0004\b8\u0010=J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u0013J'\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0003¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010$R\u0016\u0010(\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0016\u00105\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006>"}, d2 = {"Lcom/yy/render/view/RenderTextureView;", "Landroid/view/TextureView;", "", "clearRemote", "()V", "", "getChannelId", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "", "flag", "isConsumeKeyEvent", "(Z)V", "isConsumeTouchEvent", "data", "sendDataToView", "(Ljava/lang/String;)V", "Lcom/yy/render/IRemoteRender;", "remoteTmp", "setRemote", "(Lcom/yy/render/IRemoteRender;)V", "name", "setRenderViewFullName", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "surfaceChanged", "(Landroid/graphics/SurfaceTexture;II)V", "surfaceCreated", "(Landroid/graphics/SurfaceTexture;)V", "isKeyEvent", "Z", "isSendAddContentView", "isSendSurfaceChange", "isSendSurfaceCreate", "isSetRemoteSend", "isTouch", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "mRenderViewFullName", "Ljava/lang/String;", "Landroid/view/Surface;", "mSurface", "Landroid/view/Surface;", "mSurfaceFormat", "I", "mSurfaceHeight", "mSurfaceWidth", "remote", "Lcom/yy/render/IRemoteRender;", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "render_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class RenderTextureView extends TextureView {
    public Surface a;
    public int b;
    public int c;
    public int d;
    public Handler e;
    public String f;
    public volatile boolean g;
    public volatile boolean h;
    public volatile boolean i;
    public IRemoteRender j;
    public volatile boolean k;

    public final void p(boolean z) {
    }

    public final void q(boolean z) {
    }

    /* loaded from: classes10.dex */
    public static final class a implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            egb.a aVar = egb.b;
            aVar.f("[RenderTextureView](onSurfaceTextureAvailable) channelId: " + RenderTextureView.this.getChannelId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + "width = " + i + ", height = " + i2);
            RenderTextureView.this.t(surfaceTexture);
            RenderTextureView.this.s(surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            egb.a aVar = egb.b;
            aVar.f("[RenderTextureView](onSurfaceTextureSizeChanged) channelId: " + RenderTextureView.this.getChannelId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + "width = " + i + ", height = " + i2);
            RenderTextureView.this.s(surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @SuppressLint({"Recycle"})
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            IRemoteRender iRemoteRender;
            IRemoteRender iRemoteRender2;
            IBinder asBinder;
            IBinder asBinder2;
            egb.a aVar = egb.b;
            aVar.f("[RenderTextureView](surfaceDestroyed) channelId: " + RenderTextureView.this.getChannelId());
            RenderTextureView.this.k = false;
            if (RenderTextureView.this.j != null && (((iRemoteRender = RenderTextureView.this.j) == null || (asBinder2 = iRemoteRender.asBinder()) == null || asBinder2.isBinderAlive()) && ((iRemoteRender2 = RenderTextureView.this.j) == null || (asBinder = iRemoteRender2.asBinder()) == null || asBinder.pingBinder()))) {
                try {
                    RenderTextureView renderTextureView = RenderTextureView.this;
                    Surface surface = RenderTextureView.this.a;
                    if (surface == null) {
                        surface = new Surface(surfaceTexture);
                    }
                    renderTextureView.a = surface;
                    IRemoteRender iRemoteRender3 = RenderTextureView.this.j;
                    if (iRemoteRender3 != null) {
                        iRemoteRender3.surfaceDestroyed(RenderTextureView.this.getChannelId(), RenderTextureView.this.a);
                    }
                    Surface surface2 = RenderTextureView.this.a;
                    if (surface2 != null) {
                        surface2.release();
                    }
                    RenderTextureView.this.a = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ SurfaceTexture b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public b(SurfaceTexture surfaceTexture, int i, int i2) {
            this.b = surfaceTexture;
            this.c = i;
            this.d = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RenderTextureView renderTextureView = RenderTextureView.this;
            Surface surface = renderTextureView.a;
            if (surface == null) {
                surface = new Surface(this.b);
            }
            renderTextureView.a = surface;
            RenderTextureView.this.d = -1;
            RenderTextureView.this.c = this.c;
            RenderTextureView.this.b = this.d;
            try {
                if (RenderTextureView.this.j == null) {
                    return;
                }
                RenderTextureView.this.h = true;
                egb.a aVar = egb.b;
                aVar.f("[RenderTextureView](surfaceChanged) " + RenderTextureView.this.getChannelId());
                IRemoteRender iRemoteRender = RenderTextureView.this.j;
                if (iRemoteRender != null) {
                    iRemoteRender.surfaceChanged(RenderTextureView.this.getChannelId(), RenderTextureView.this.a, RenderTextureView.this.f, RenderTextureView.this.d, this.c, this.d);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c implements Runnable {
        public final /* synthetic */ SurfaceTexture b;

        public c(SurfaceTexture surfaceTexture) {
            this.b = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RenderTextureView renderTextureView = RenderTextureView.this;
            Surface surface = renderTextureView.a;
            if (surface == null) {
                surface = new Surface(this.b);
            }
            renderTextureView.a = surface;
            try {
                if (RenderTextureView.this.j == null) {
                    return;
                }
                RenderTextureView.this.g = true;
                IRemoteRender iRemoteRender = RenderTextureView.this.j;
                if (iRemoteRender != null) {
                    iRemoteRender.surfaceCreated(RenderTextureView.this.getChannelId(), RenderTextureView.this.a, RenderTextureView.this.f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public RenderTextureView(Context context) {
        super(context);
        o(context);
    }

    public final void o(Context context) {
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.e = new Handler(Looper.getMainLooper());
        setSurfaceTextureListener(new a());
    }

    public final void r(String str) {
        RenderEngine.r.a().G(getChannelId(), str);
    }

    public final void setRenderViewFullName(String str) {
        this.f = str;
    }

    @SuppressLint({"Recycle"})
    public final void t(SurfaceTexture surfaceTexture) {
        egb.a aVar = egb.b;
        aVar.f("[RenderTextureView](surfaceCreated) channelId: " + getChannelId());
        Handler handler = this.e;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        }
        handler.post(new c(surfaceTexture));
    }

    public RenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o(context);
    }

    public RenderTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        o(context);
    }

    @SuppressLint({"Recycle"})
    public final void s(SurfaceTexture surfaceTexture, int i, int i2) {
        Handler handler = this.e;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        }
        handler.post(new b(surfaceTexture, i, i2));
    }

    public final String getChannelId() {
        return String.valueOf(hashCode());
    }

    public final void n() {
        this.h = false;
        this.g = false;
        this.i = false;
        this.j = null;
    }

    public final void setRemote(IRemoteRender iRemoteRender) {
        this.j = iRemoteRender;
        egb.a aVar = egb.b;
        aVar.f("[RenderTextureView](setRemote) isSetRemoteSend: " + this.k + StringUtil.ARRAY_ELEMENT_SEPARATOR + "isSendSurfaceCreate: " + this.g + ", surface: " + this.a + ", channelId: " + getChannelId() + "remote: " + this.j + ", isSendSurfaceChange: " + this.h);
        if (this.a != null) {
            if (!this.g) {
                try {
                    IRemoteRender iRemoteRender2 = this.j;
                    if (iRemoteRender2 != null) {
                        iRemoteRender2.surfaceCreated(getChannelId(), this.a, this.f);
                    }
                } catch (Exception e) {
                    egb.a aVar2 = egb.b;
                    aVar2.c("[RenderTextureView](setRemote) surfaceCreated ex: " + e.getMessage());
                }
            }
            if (!this.h) {
                try {
                    IRemoteRender iRemoteRender3 = this.j;
                    if (iRemoteRender3 != null) {
                        iRemoteRender3.surfaceChanged(getChannelId(), this.a, this.f, this.d, this.c, this.b);
                    }
                } catch (Exception e2) {
                    egb.a aVar3 = egb.b;
                    aVar3.c("[RenderTextureView](setRemote) surfaceChanged ex: " + e2.getMessage());
                }
            }
        }
        if (!this.i) {
            try {
                IRemoteRender iRemoteRender4 = this.j;
                if (iRemoteRender4 != null) {
                    iRemoteRender4.addContentView(getChannelId(), this.f);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.i = true;
        }
    }
}
