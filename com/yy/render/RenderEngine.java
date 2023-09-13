package com.yy.render;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.tieba.g2c;
import com.baidu.tieba.j2c;
import com.baidu.tieba.k2c;
import com.baidu.tieba.p2c;
import com.baidu.tieba.r2c;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.render.IRemoteListener;
import com.yy.render.IRemoteRender;
import com.yy.render.view.RenderSurfaceView;
import com.yy.render.view.RenderTextureView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001:\u0018\u0000 \\:\u0002\\]B\u0007¢\u0006\u0004\b[\u0010\u000bJ\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0012\u0010\u0015JC\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`\u0018¢\u0006\u0004\b\u0012\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u000bJ/\u0010&\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010 2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J/\u0010&\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010(2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010)J\u0015\u0010*\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b*\u0010\u0005J\u0015\u0010+\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\tJ\u0017\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0017H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0003H\u0002¢\u0006\u0004\b/\u0010\u000bJ!\u00102\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u00172\b\u00101\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0011¢\u0006\u0004\b4\u0010\u001cJ3\u00104\u001a\u00020\u00112\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b6\u00107J\u0017\u00106\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010(¢\u0006\u0004\b6\u00108J\u0015\u00106\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0017¢\u0006\u0004\b6\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010@\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR&\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u00060Cj\b\u0012\u0004\u0012\u00020\u0006`D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR*\u0010G\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010Cj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR2\u0010H\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$0\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 0M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR&\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020P0Cj\b\u0012\u0004\u0012\u00020P`D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010FR\u0018\u0010R\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020(0M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010O¨\u0006^"}, d2 = {"Lcom/yy/render/RenderEngine;", "Lcom/yy/render/CrashListener;", "crashListener", "", "addCrashListener", "(Lcom/yy/render/CrashListener;)V", "Lcom/yy/render/ServiceConnectListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addServiceConnectListener", "(Lcom/yy/render/ServiceConnectListener;)V", "destroy", "()V", "Lcom/yy/render/IRemoteRender;", "getRemoveService", "()Lcom/yy/render/IRemoteRender;", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)Z", "crashReport", "(Landroid/content/Context;Lcom/yy/render/CrashListener;)Z", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", WebChromeClient.KEY_ARG_ARRAY, "(Landroid/content/Context;Lcom/yy/render/CrashListener;Ljava/util/HashMap;)Z", "isBindServiceSuss", "()Z", "isSdkVersionAvailable", "notifyServiceConnect", "notifyServiceDisConnect", "Lcom/yy/render/view/RenderSurfaceView;", "view", "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "Lcom/yy/render/ViewDataListener;", WebChromeClient.KEY_ARG_CALLBACK, "registerView", "(Lcom/yy/render/view/RenderSurfaceView;Ljava/lang/Class;Lcom/yy/render/ViewDataListener;)Ljava/lang/String;", "Lcom/yy/render/view/RenderTextureView;", "(Lcom/yy/render/view/RenderTextureView;Ljava/lang/Class;Lcom/yy/render/ViewDataListener;)Ljava/lang/String;", "removeCrashListener", "removeServiceConnectListener", "info", "reportCrash", "(Ljava/lang/String;)V", "sendCacheMessage", "channelId", "data", "sendData2View", "(Ljava/lang/String;Ljava/lang/String;)V", "startRender", "(Ljava/util/HashMap;)Z", "unRegisterView", "(Lcom/yy/render/view/RenderSurfaceView;)Ljava/lang/String;", "(Lcom/yy/render/view/RenderTextureView;)Ljava/lang/String;", "(Ljava/lang/String;)Ljava/lang/String;", "com/yy/render/RenderEngine$iRemoteListener$1", "iRemoteListener", "Lcom/yy/render/RenderEngine$iRemoteListener$1;", "isBind", "Z", "isConnect", "isCrash", "mApplicationContext", "Landroid/content/Context;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mConnectList", "Ljava/util/ArrayList;", "mCrashReportList", "mDataCallbackMap", "Ljava/util/HashMap;", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/ConcurrentHashMap;", "mMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/yy/render/RenderEngine$Message;", "mMessageList", "mRemoteRender", "Lcom/yy/render/IRemoteRender;", "Landroid/os/IBinder;", "mService", "Landroid/os/IBinder;", "Landroid/content/ServiceConnection;", "mServiceConnection", "Landroid/content/ServiceConnection;", "mTextureMap", "<init>", "Companion", "Message", "render_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class RenderEngine {
    public IBinder a;
    public volatile IRemoteRender b;
    public Context g;
    public volatile boolean h;
    public volatile boolean i;
    public volatile boolean j;
    public static final a r = new a(null);
    public static RenderEngine p = new RenderEngine();
    public static final String q = "sub_process_view";
    public Handler c = new Handler(Looper.getMainLooper());
    public final ConcurrentHashMap<String, RenderSurfaceView> d = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, RenderTextureView> e = new ConcurrentHashMap<>();
    public final HashMap<String, k2c> f = new HashMap<>();
    public ArrayList<g2c> k = new ArrayList<>();
    public ArrayList<j2c> l = new ArrayList<>();
    public final RenderEngine$iRemoteListener$1 m = new IRemoteListener.Stub() { // from class: com.yy.render.RenderEngine$iRemoteListener$1

        /* loaded from: classes10.dex */
        public static final class a implements Runnable {
            public final /* synthetic */ String b;

            public a(String str) {
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RenderEngine renderEngine = RenderEngine.this;
                String str = this.b;
                if (str == null) {
                    str = "crash";
                }
                renderEngine.E(str);
            }
        }

        /* loaded from: classes10.dex */
        public static final class b implements Runnable {
            public final /* synthetic */ String b;
            public final /* synthetic */ Bitmap c;

            public b(String str, Bitmap bitmap) {
                this.b = str;
                this.c = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                HashMap hashMap;
                hashMap = RenderEngine.this.f;
                k2c k2cVar = (k2c) hashMap.get(this.b);
                if (k2cVar != null) {
                    k2cVar.c(this.c);
                }
            }
        }

        /* loaded from: classes10.dex */
        public static final class c implements Runnable {
            public final /* synthetic */ String b;
            public final /* synthetic */ android.os.Bundle c;

            public c(String str, android.os.Bundle bundle) {
                this.b = str;
                this.c = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                HashMap hashMap;
                hashMap = RenderEngine.this.f;
                k2c k2cVar = (k2c) hashMap.get(this.b);
                if (k2cVar != null) {
                    android.os.Bundle bundle = this.c;
                    if (bundle == null) {
                        Intrinsics.throwNpe();
                    }
                    k2cVar.b(bundle);
                }
            }
        }

        /* loaded from: classes10.dex */
        public static final class d implements Runnable {
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            public d(String str, String str2) {
                this.b = str;
                this.c = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                HashMap hashMap;
                hashMap = RenderEngine.this.f;
                k2c k2cVar = (k2c) hashMap.get(this.b);
                if (k2cVar != null) {
                    String str = this.c;
                    if (str == null) {
                        Intrinsics.throwNpe();
                    }
                    k2cVar.d(str);
                }
            }
        }

        @Override // com.yy.render.IRemoteListener
        public void action(String str, String str2) {
            p2c.a aVar = p2c.b;
            String str3 = RenderEngine.q;
            aVar.g(str3, "[RenderEngine](action) action:" + str + ", detail:" + str2);
            if (str != null && str.hashCode() == -272482605 && str.equals("reportCrash")) {
                RenderEngine.this.c.post(new a(str2));
            }
        }

        @Override // com.yy.render.IRemoteListener
        public void transBitmap(String str, Bitmap bitmap) {
            p2c.a aVar = p2c.b;
            String str2 = RenderEngine.q;
            aVar.g(str2, "[RenderEngine](transBitmap) channelId: " + str);
            RenderEngine.this.c.post(new b(str, bitmap));
        }

        @Override // com.yy.render.IRemoteListener
        public void transData(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                RenderEngine.this.c.post(new d(str, str2));
            }
        }

        @Override // com.yy.render.IRemoteListener
        public void transBundle(String str, android.os.Bundle bundle) {
            p2c.a aVar = p2c.b;
            String str2 = RenderEngine.q;
            aVar.g(str2, "[RenderEngine](transBundle) channelId: " + str);
            if (bundle != null) {
                RenderEngine.this.c.post(new c(str, bundle));
                return;
            }
            p2c.a aVar2 = p2c.b;
            String str3 = RenderEngine.q;
            aVar2.g(str3, "[RenderEngine](transBundle) channelId: " + str + ", bundle is null");
        }
    };
    public final ServiceConnection n = new c();
    public final ArrayList<b> o = new ArrayList<>();

    public final boolean x() {
        return true;
    }

    /* loaded from: classes10.dex */
    public static final class c implements ServiceConnection {

        /* loaded from: classes10.dex */
        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RenderEngine.this.E("onServiceConnected service is null ");
            }
        }

        /* loaded from: classes10.dex */
        public static final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RenderEngine.this.E("onServiceConnected service is not alive or ping fail");
            }
        }

        /* renamed from: com.yy.render.RenderEngine$c$c  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class RunnableC0789c implements Runnable {
            public final /* synthetic */ IBinder b;

            public RunnableC0789c(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RenderEngine.this.b = IRemoteRender.Stub.asInterface(this.b);
                RenderEngine.this.y();
                RenderEngine.this.i = true;
                try {
                    IRemoteRender iRemoteRender = RenderEngine.this.b;
                    if (iRemoteRender != null) {
                        iRemoteRender.setListener(RenderEngine.this.m);
                    }
                } catch (Exception e) {
                    p2c.a aVar = p2c.b;
                    String str = RenderEngine.q;
                    aVar.d(str, "[RenderEngine] setListener ex:" + e.getMessage());
                    e.printStackTrace();
                }
                for (Map.Entry entry : RenderEngine.this.d.entrySet()) {
                    ((RenderSurfaceView) entry.getValue()).setRemote(RenderEngine.this.b);
                }
                for (Map.Entry entry2 : RenderEngine.this.e.entrySet()) {
                    ((RenderTextureView) entry2.getValue()).setRemote(RenderEngine.this.b);
                }
                if (RenderEngine.this.b == null) {
                    return;
                }
                RenderEngine.this.F();
            }
        }

        /* loaded from: classes10.dex */
        public static final class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RenderEngine.this.z();
                if (RenderEngine.this.j) {
                    return;
                }
                RenderEngine.this.E("onServiceDisconnected");
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            p2c.b.g(RenderEngine.q, "[RenderEngine] crash onServiceDisconnected ");
            RenderEngine.this.a = null;
            RenderEngine.this.c.post(new d());
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Boolean bool;
            p2c.a aVar = p2c.b;
            String str = RenderEngine.q;
            StringBuilder sb = new StringBuilder();
            sb.append("[RenderEngine] onServiceConnected bind is alive: ");
            Boolean bool2 = null;
            if (iBinder != null) {
                bool = Boolean.valueOf(iBinder.isBinderAlive());
            } else {
                bool = null;
            }
            sb.append(bool);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pingBinder: ");
            if (iBinder != null) {
                bool2 = Boolean.valueOf(iBinder.pingBinder());
            }
            sb.append(bool2);
            aVar.g(str, sb.toString());
            if (iBinder == null) {
                RenderEngine.this.c.post(new a());
            } else if (iBinder.isBinderAlive() && iBinder.pingBinder()) {
                p2c.b.g(RenderEngine.q, "[RenderEngine] onServiceConnected");
                RenderEngine.this.c.post(new RunnableC0789c(iBinder));
            } else {
                RenderEngine.this.c.post(new b());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public a() {
        }

        public final RenderEngine a() {
            return RenderEngine.p;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public String a;
        public String b;

        public b() {
            this(null, null, 3, null);
        }

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public /* synthetic */ b(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final void c(String str) {
            this.a = str;
        }

        public final void d(String str) {
            this.b = str;
        }
    }

    public final IRemoteRender t() {
        return this.b;
    }

    public final boolean w() {
        return this.h;
    }

    public final void F() {
        synchronized (RenderEngine.class) {
            if (this.o.size() > 0) {
                Iterator<b> it = this.o.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    try {
                        IRemoteRender iRemoteRender = this.b;
                        if (iRemoteRender != null) {
                            iRemoteRender.sendData2Channel(next.a(), next.b());
                        }
                    } catch (Exception e) {
                        p2c.a aVar = p2c.b;
                        aVar.c("sendData2Channel ex: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
                this.o.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean H() {
        Intent intent = new Intent();
        Context context = this.g;
        if (context == null) {
            Intrinsics.throwNpe();
        }
        intent.setComponent(new ComponentName(context, RemoteRenderServices.class));
        Context context2 = this.g;
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        this.h = context2.bindService(intent, this.n, 65);
        p2c.a aVar = p2c.b;
        String str = q;
        aVar.d(str, "[RenderEngine] bindService result " + this.h + ")}");
        return this.h;
    }

    public final synchronized void C(g2c g2cVar) {
        if (this.k.size() > 0) {
            this.k.remove(g2cVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void D(j2c j2cVar) {
        if (this.l.size() > 0) {
            Iterator<j2c> it = this.l.iterator();
            Intrinsics.checkExpressionValueIsNotNull(it, "mConnectList.iterator()");
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() == j2cVar) {
                    break;
                }
            }
        }
    }

    public final synchronized void q(g2c g2cVar) {
        if (this.k.size() > 0 && this.k.contains(g2cVar)) {
            return;
        }
        this.k.add(g2cVar);
    }

    public final synchronized void r(j2c j2cVar) {
        if (this.i) {
            j2cVar.b();
        }
        if (this.l.size() > 0 && this.l.contains(j2cVar)) {
            return;
        }
        this.l.add(j2cVar);
    }

    public final boolean u(Context context, g2c g2cVar) {
        if (!x()) {
            return false;
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        this.g = context;
        if (g2cVar != null) {
            q(g2cVar);
        }
        this.j = false;
        this.i = false;
        return H();
    }

    public final String A(RenderSurfaceView renderSurfaceView, Class<?> cls, k2c k2cVar) {
        if (!r2c.class.isAssignableFrom(cls)) {
            p2c.b.d(q, "registerView error");
            return "";
        } else if (renderSurfaceView == null) {
            return "";
        } else {
            String channelId = renderSurfaceView.getChannelId();
            if (this.d.containsKey(channelId)) {
                p2c.b.d(q, "registerView has already created");
                return "";
            }
            this.d.put(channelId, renderSurfaceView);
            StringBuilder sb = new StringBuilder();
            Package r2 = cls.getPackage();
            Intrinsics.checkExpressionValueIsNotNull(r2, "clazz.`package`");
            sb.append(r2.getName());
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(cls.getSimpleName());
            renderSurfaceView.setRenderViewFullName(sb.toString());
            if (this.b != null) {
                renderSurfaceView.setRemote(this.b);
            }
            if (k2cVar != null) {
                this.f.put(channelId, k2cVar);
            }
            return channelId;
        }
    }

    public final String B(RenderTextureView renderTextureView, Class<?> cls, k2c k2cVar) {
        if (!r2c.class.isAssignableFrom(cls)) {
            p2c.b.d(q, "registerView error");
            return "";
        } else if (renderTextureView == null) {
            return "";
        } else {
            String channelId = renderTextureView.getChannelId();
            if (this.e.containsKey(channelId)) {
                p2c.b.d(q, "registerView has already created");
                return "";
            }
            this.e.put(channelId, renderTextureView);
            StringBuilder sb = new StringBuilder();
            Package r2 = cls.getPackage();
            Intrinsics.checkExpressionValueIsNotNull(r2, "clazz.`package`");
            sb.append(r2.getName());
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(cls.getSimpleName());
            renderTextureView.setRenderViewFullName(sb.toString());
            if (this.b != null) {
                renderTextureView.setRemote(this.b);
            }
            if (k2cVar != null) {
                this.f.put(channelId, k2cVar);
            }
            return channelId;
        }
    }

    public final void E(String str) {
        p2c.a aVar = p2c.b;
        aVar.c("[RenderEngine] (reportCrash) info: " + str);
        if (this.j) {
            return;
        }
        this.j = true;
        this.i = false;
        this.b = null;
        for (Map.Entry<String, RenderSurfaceView> entry : this.d.entrySet()) {
            entry.getValue().m();
        }
        for (Map.Entry<String, RenderTextureView> entry2 : this.e.entrySet()) {
            entry2.getValue().n();
        }
        if (this.k.size() > 0) {
            ArrayList<g2c> arrayList = new ArrayList();
            for (g2c g2cVar : this.k) {
                arrayList.add(g2cVar);
            }
            for (g2c g2cVar2 : arrayList) {
                if (g2cVar2 != null) {
                    g2cVar2.a(str);
                }
            }
            arrayList.clear();
        }
    }

    public final void G(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.b == null) {
                synchronized (RenderEngine.class) {
                    b bVar = new b(null, null, 3, null);
                    if (str == null) {
                        Intrinsics.throwNpe();
                    }
                    bVar.c(str);
                    if (str2 == null) {
                        Intrinsics.throwNpe();
                    }
                    bVar.d(str2);
                    this.o.add(bVar);
                }
                return;
            }
            F();
            try {
                IRemoteRender iRemoteRender = this.b;
                if (iRemoteRender != null) {
                    iRemoteRender.sendData2Channel(str, str2);
                    return;
                }
                return;
            } catch (Exception e) {
                p2c.a aVar = p2c.b;
                aVar.c("sendData2Channel ex: " + e.getMessage());
                e.printStackTrace();
                return;
            }
        }
        p2c.b.g(q, "[RenderEngine] sendData2View channelId or data is null or empty");
    }

    public final boolean I(HashMap<String, String> hashMap) {
        p2c.a aVar;
        String str;
        StringBuilder sb;
        Intent intent = new Intent();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("apk", hashMap.get("apk"));
        bundle.putString("nativeLib", hashMap.get("nativeLib"));
        bundle.putString("pkgName", hashMap.get("pkgName"));
        bundle.putString("yalog_switch", hashMap.get("yalog_switch"));
        bundle.putString("cuid", DeviceId.getCUID(this.g));
        intent.putExtras(bundle);
        Context context = this.g;
        if (context == null) {
            Intrinsics.throwNpe();
        }
        intent.setComponent(new ComponentName(context, RemoteRenderServices.class));
        try {
            Context context2 = this.g;
            if (context2 == null) {
                Intrinsics.throwNpe();
            }
            this.h = context2.bindService(intent, this.n, 65);
            aVar = p2c.b;
            str = q;
            sb = new StringBuilder();
        } catch (Throwable unused) {
            aVar = p2c.b;
            str = q;
            sb = new StringBuilder();
        }
        sb.append("bindService result ");
        sb.append(this.h);
        aVar.d(str, sb.toString());
        return this.h;
    }

    public final void s() {
        this.i = false;
        this.b = null;
        this.k.clear();
        this.l.clear();
        if (this.h) {
            this.h = false;
            p2c.b.g(q, "destroy unBindService");
            try {
                Context context = this.g;
                if (context != null) {
                    context.unbindService(this.n);
                }
            } catch (Exception e) {
                p2c.a aVar = p2c.b;
                String str = q;
                aVar.d(str, "unbindService ex: " + e.getMessage());
                e.printStackTrace();
            }
        }
        this.f.clear();
        for (Map.Entry<String, RenderSurfaceView> entry : this.d.entrySet()) {
            entry.getValue().m();
        }
        this.d.clear();
        for (Map.Entry<String, RenderTextureView> entry2 : this.e.entrySet()) {
            entry2.getValue().n();
        }
        this.e.clear();
        this.g = null;
    }

    public final boolean v(Context context, g2c g2cVar, HashMap<String, String> hashMap) {
        if (!x()) {
            return false;
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        this.g = context;
        if (g2cVar != null) {
            q(g2cVar);
        }
        this.j = false;
        this.i = false;
        return I(hashMap);
    }

    public final synchronized void y() {
        if (this.l.size() > 0) {
            ArrayList<j2c> arrayList = new ArrayList();
            for (j2c j2cVar : this.l) {
                arrayList.add(j2cVar);
            }
            for (j2c j2cVar2 : arrayList) {
                j2cVar2.b();
            }
            arrayList.clear();
        }
    }

    public final synchronized void z() {
        if (this.l.size() > 0) {
            ArrayList<j2c> arrayList = new ArrayList();
            for (j2c j2cVar : arrayList) {
                j2cVar.c();
            }
            for (j2c j2cVar2 : this.l) {
                arrayList.add(j2cVar2);
            }
            arrayList.clear();
        }
    }
}
