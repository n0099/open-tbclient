package com.yy.render.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.sdk.internal.cl;
import com.baidu.tieba.agc;
import com.yy.render.IRemoteRender;
import com.yy.render.RenderEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b3\u0010\u000bB\u001d\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b3\u00106B%\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u0006\u00107\u001a\u00020,¢\u0006\u0004\b3\u00108J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0016\u00100\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00069"}, d2 = {"Lcom/yy/render/view/RenderSurfaceView;", "Landroid/view/SurfaceView;", "", "clearRemote", "()V", "", "getChannelId", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "", "flag", "isConsumeKeyEvent", "(Z)V", "isConsumeTouchEvent", "data", "sendDataToView", "(Ljava/lang/String;)V", "Lcom/yy/render/IRemoteRender;", "remoteTmp", "setRemote", "(Lcom/yy/render/IRemoteRender;)V", "name", "setRenderViewFullName", "isKeyEvent", "Z", "isSendAddContentView", "isSendSurfaceChange", "isSendSurfaceCreate", "isSetRemoteSend", "isTouch", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Landroid/view/SurfaceHolder;", "mHolder", "Landroid/view/SurfaceHolder;", "mRenderViewFullName", "Ljava/lang/String;", "Landroid/view/Surface;", "mSurface", "Landroid/view/Surface;", "", "mSurfaceFormat", "I", "mSurfaceHeight", "mSurfaceWidth", cl.b, "Lcom/yy/render/IRemoteRender;", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "render_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RenderSurfaceView extends SurfaceView {
    public SurfaceHolder a;
    public Surface b;
    public int c;
    public int d;
    public int e;
    public Handler f;
    public String g;
    public volatile boolean h;
    public volatile boolean i;
    public volatile boolean j;
    public IRemoteRender k;
    public volatile boolean l;

    public final void o(boolean z) {
    }

    public final void p(boolean z) {
    }

    /* loaded from: classes2.dex */
    public static final class a implements SurfaceHolder.Callback {

        /* renamed from: com.yy.render.view.RenderSurfaceView$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class RunnableC0764a implements Runnable {
            public final /* synthetic */ SurfaceHolder b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;
            public final /* synthetic */ int e;

            public RunnableC0764a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                this.b = surfaceHolder;
                this.c = i;
                this.d = i2;
                this.e = i3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RenderSurfaceView.this.b = this.b.getSurface();
                RenderSurfaceView.this.e = this.c;
                RenderSurfaceView.this.d = this.d;
                RenderSurfaceView.this.c = this.e;
                try {
                    if (RenderSurfaceView.this.k == null) {
                        return;
                    }
                    RenderSurfaceView.this.i = true;
                    IRemoteRender iRemoteRender = RenderSurfaceView.this.k;
                    if (iRemoteRender != null) {
                        iRemoteRender.surfaceChanged(RenderSurfaceView.this.getChannelId(), this.b.getSurface(), RenderSurfaceView.this.g, RenderSurfaceView.this.e, this.d, this.e);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* loaded from: classes2.dex */
        public static final class b implements Runnable {
            public final /* synthetic */ SurfaceHolder b;

            public b(SurfaceHolder surfaceHolder) {
                this.b = surfaceHolder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RenderSurfaceView.this.b = this.b.getSurface();
                try {
                    if (RenderSurfaceView.this.k == null) {
                        return;
                    }
                    RenderSurfaceView.this.h = true;
                    IRemoteRender iRemoteRender = RenderSurfaceView.this.k;
                    if (iRemoteRender != null) {
                        iRemoteRender.surfaceCreated(RenderSurfaceView.this.getChannelId(), this.b.getSurface(), RenderSurfaceView.this.g);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* loaded from: classes2.dex */
        public static final class c implements Runnable {
            public final /* synthetic */ SurfaceHolder b;

            public c(SurfaceHolder surfaceHolder) {
                this.b = surfaceHolder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    IRemoteRender iRemoteRender = RenderSurfaceView.this.k;
                    if (iRemoteRender != null) {
                        iRemoteRender.surfaceDestroyed(RenderSurfaceView.this.getChannelId(), this.b.getSurface());
                    }
                } catch (Exception e) {
                    agc.a aVar = agc.b;
                    e.printStackTrace();
                    aVar.g("sub_process_view", Unit.INSTANCE.toString());
                }
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            RenderSurfaceView.this.a = surfaceHolder;
            agc.a aVar = agc.b;
            aVar.f("surfaceCreated channelId: " + RenderSurfaceView.this.getChannelId());
            RenderSurfaceView.a(RenderSurfaceView.this).post(new b(surfaceHolder));
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            agc.a aVar = agc.b;
            aVar.f("surfaceDestroyed channelId: " + RenderSurfaceView.this.getChannelId());
            RenderSurfaceView.this.l = false;
            RenderSurfaceView.a(RenderSurfaceView.this).post(new c(surfaceHolder));
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            RenderSurfaceView.this.a = surfaceHolder;
            agc.a aVar = agc.b;
            aVar.f("surfaceChanged channelId: " + RenderSurfaceView.this.getChannelId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + "width = " + i2 + ", height = " + i3);
            RenderSurfaceView.a(RenderSurfaceView.this).post(new RunnableC0764a(surfaceHolder, i, i2, i3));
        }
    }

    public RenderSurfaceView(Context context) {
        super(context);
        n(context);
    }

    public static final /* synthetic */ Handler a(RenderSurfaceView renderSurfaceView) {
        Handler handler = renderSurfaceView.f;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        }
        return handler;
    }

    public final void n(Context context) {
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f = new Handler(Looper.getMainLooper());
        SurfaceHolder holder = getHolder();
        if (holder != null) {
            holder.addCallback(new a());
        }
    }

    public final void q(String str) {
        RenderEngine.r.a().G(getChannelId(), str);
    }

    public final void setRenderViewFullName(String str) {
        this.g = str;
    }

    public RenderSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }

    public RenderSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        n(context);
    }

    public final String getChannelId() {
        return String.valueOf(hashCode());
    }

    public final void m() {
        this.i = false;
        this.h = false;
        this.j = false;
        this.k = null;
    }

    public final void setRemote(IRemoteRender iRemoteRender) {
        this.k = iRemoteRender;
        agc.a aVar = agc.b;
        aVar.f("(setRemote) isSetRemoteSend: " + this.l + StringUtil.ARRAY_ELEMENT_SEPARATOR + "isSendSurfaceCreate: " + this.h + ", surface: " + this.b + ", channelId: " + getChannelId() + "remote: " + this.k + ", isSendSurfaceChange: " + this.i);
        if (this.b != null) {
            if (!this.h) {
                try {
                    IRemoteRender iRemoteRender2 = this.k;
                    if (iRemoteRender2 != null) {
                        iRemoteRender2.surfaceCreated(getChannelId(), this.b, this.g);
                    }
                } catch (Exception e) {
                    agc.a aVar2 = agc.b;
                    aVar2.c("setRemote surfaceCreated ex: " + e.getMessage());
                }
            }
            if (!this.i) {
                try {
                    IRemoteRender iRemoteRender3 = this.k;
                    if (iRemoteRender3 != null) {
                        iRemoteRender3.surfaceChanged(getChannelId(), this.b, this.g, this.e, this.d, this.c);
                    }
                } catch (Exception e2) {
                    agc.a aVar3 = agc.b;
                    aVar3.c("setRemote surfaceChanged ex: " + e2.getMessage());
                }
            }
        }
        if (!this.j) {
            try {
                agc.a aVar4 = agc.b;
                aVar4.c("addContentView send data to remote " + getChannelId());
                IRemoteRender iRemoteRender4 = this.k;
                if (iRemoteRender4 != null) {
                    iRemoteRender4.addContentView(getChannelId(), this.g);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.j = true;
        }
    }
}
