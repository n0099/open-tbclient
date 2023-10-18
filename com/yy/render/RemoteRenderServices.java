package com.yy.render;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ayb;
import com.baidu.tieba.dyb;
import com.baidu.tieba.eyb;
import com.baidu.tieba.gyb;
import com.baidu.tieba.hyb;
import com.baidu.tieba.wxb;
import com.baidu.tieba.xxb;
import com.vivo.push.PushClientConstants;
import com.yy.render.IRemoteRender;
import java.lang.Thread;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b9\u0010\u0010J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J?\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010%\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00000*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R>\u00106\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030403j\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000304`58\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00108¨\u0006;"}, d2 = {"Lcom/yy/render/RemoteRenderServices;", "java/lang/Thread$UncaughtExceptionHandler", "Landroid/app/Service;", "", PushClientConstants.TAG_CLASS_NAME, "channelId", "Lcom/yy/render/view/RenderView;", "getRenderViewByReflect", "(Ljava/lang/String;Ljava/lang/String;)Lcom/yy/render/view/RenderView;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "onCreate", "()V", MissionEvent.MESSAGE_DESTROY, "renderView", "sendCacheMessage", "(Lcom/yy/render/view/RenderView;Ljava/lang/String;)V", "Landroid/view/Surface;", "surface", "", "format", "width", "height", "serverSurfaceChanged", "(Ljava/lang/String;Landroid/view/Surface;Ljava/lang/String;III)V", "serverSurfaceCreated", "(Ljava/lang/String;Landroid/view/Surface;Ljava/lang/String;)V", "serverSurfaceDestroyed", "(Ljava/lang/String;Landroid/view/Surface;)V", "Ljava/lang/Thread;", "t", "", "e", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "Ljava/lang/Thread$UncaughtExceptionHandler;", "defaultHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Ljava/lang/Class;", "lock", "Ljava/lang/Class;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/LinkedHashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/LinkedHashMap;", "message", "Ljava/util/LinkedHashMap;", "Landroid/view/Surface;", "<init>", "Companion", "render_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class RemoteRenderServices extends Service implements Thread.UncaughtExceptionHandler {
    public static final a Companion = new a(null);
    public static final String TAG = "sub_process_view";
    public Thread.UncaughtExceptionHandler defaultHandler;
    public Context mContext;
    public Surface surface;
    public final Handler mainHandler = new Handler(Looper.getMainLooper());
    public final Class<RemoteRenderServices> lock = RemoteRenderServices.class;
    public final LinkedHashMap<String, LinkedList<String>> message = new LinkedHashMap<>();

    /* loaded from: classes10.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ Intent b;

        public b(Intent intent) {
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            String string;
            eyb.b.h();
            try {
                Bundle extras = this.b.getExtras();
                String str2 = null;
                if (extras == null || (str = extras.getString("nativeLib")) == null) {
                    str = null;
                }
                if (extras != null && (string = extras.getString("cuid")) != null) {
                    str2 = string;
                }
                eyb.b.f("The soPath is " + str + ", cuid is " + str2);
                dyb dybVar = dyb.c;
                Context applicationContext = RemoteRenderServices.this.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this.applicationContext");
                String packageName = RemoteRenderServices.this.getPackageName();
                Intrinsics.checkExpressionValueIsNotNull(packageName, "this.packageName");
                dybVar.d(applicationContext, packageName, str, str2);
            } catch (Throwable th) {
                eyb.b.c(String.valueOf(th.getMessage()));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c implements Runnable {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Surface d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public c(String str, String str2, Surface surface, int i, int i2, int i3) {
            this.b = str;
            this.c = str2;
            this.d = surface;
            this.e = i;
            this.f = i2;
            this.g = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!xxb.c.a().d(this.b)) {
                gyb renderViewByReflect = RemoteRenderServices.this.getRenderViewByReflect(this.c, this.b);
                if (renderViewByReflect == null) {
                    eyb.a aVar = eyb.b;
                    aVar.d("sub_process_view", "[RenderServices] getViewByReflect view is null, className=" + this.c);
                    return;
                }
                xxb.c.a().b(this.b, renderViewByReflect);
            }
            gyb c = xxb.c.a().c(this.b);
            if (c != null && (c instanceof hyb)) {
                hyb hybVar = (hyb) c;
                RemoteRenderServices remoteRenderServices = RemoteRenderServices.this;
                Surface surface = this.d;
                if (surface == null) {
                    Intrinsics.throwNpe();
                }
                hybVar.e(remoteRenderServices, surface, this.e, this.f, this.g);
                RemoteRenderServices.this.sendCacheMessage(c, this.b);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class d implements Runnable {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Surface d;

        public d(String str, String str2, Surface surface) {
            this.b = str;
            this.c = str2;
            this.d = surface;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!xxb.c.a().d(this.b)) {
                gyb renderViewByReflect = RemoteRenderServices.this.getRenderViewByReflect(this.c, this.b);
                if (renderViewByReflect == null) {
                    eyb.a aVar = eyb.b;
                    aVar.d("sub_process_view", "[RenderServices] getViewByReflect view is null, className=" + this.c);
                    return;
                }
                xxb.c.a().b(this.b, renderViewByReflect);
            }
            gyb c = xxb.c.a().c(this.b);
            if (c != null && (c instanceof hyb)) {
                eyb.a aVar2 = eyb.b;
                aVar2.d("sub_process_view", "[RenderServices] surface-->" + this.d);
                Surface surface = this.d;
                if (surface != null) {
                    ((hyb) c).f(RemoteRenderServices.this, surface);
                }
                RemoteRenderServices.this.sendCacheMessage(c, this.b);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class e implements Runnable {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            gyb c;
            eyb.b.g("sub_process_view", "[RenderServices] surface server_surfaceDestroyed!");
            if (xxb.c.a().d(this.a) && (c = xxb.c.a().c(this.a)) != null && (c instanceof hyb)) {
                eyb.b.g("sub_process_view", "[RenderServices] invoke surfaceDestroyed");
                ((hyb) c).g();
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        eyb.b.g("sub_process_view", "[RenderServices] onCreate!");
        this.mContext = this;
        this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        eyb.b.g("sub_process_view", "[RenderService](onDestroy)");
        eyb.b.e(true);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        new Thread(new b(intent)).start();
        return new IRemoteRender.Stub() { // from class: com.yy.render.RemoteRenderServices$onBind$2

            /* loaded from: classes10.dex */
            public static final class a implements Runnable {
                public final /* synthetic */ String b;
                public final /* synthetic */ String c;

                public a(String str, String str2) {
                    this.b = str;
                    this.c = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Context context;
                    if (xxb.c.a().d(this.b)) {
                        return;
                    }
                    gyb renderViewByReflect = RemoteRenderServices.this.getRenderViewByReflect(this.c, this.b);
                    if (renderViewByReflect == null) {
                        eyb.a aVar = eyb.b;
                        aVar.d("sub_process_view", "[RenderServices] getViewByReflect view is null, className=" + this.c);
                        return;
                    }
                    xxb.c.a().b(this.b, renderViewByReflect);
                    if (renderViewByReflect instanceof hyb) {
                        hyb hybVar = (hyb) renderViewByReflect;
                        context = RemoteRenderServices.this.mContext;
                        if (context == null) {
                            Intrinsics.throwNpe();
                        }
                        hybVar.d(context);
                        RemoteRenderServices.this.sendCacheMessage(renderViewByReflect, this.b);
                    }
                }
            }

            /* loaded from: classes10.dex */
            public static final class b implements Runnable {
                public final /* synthetic */ String a;

                public b(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    eyb.a aVar = eyb.b;
                    aVar.g("sub_process_view", "[RenderServices] removeContentView " + this.a);
                    xxb.c.a().e(this.a);
                }
            }

            @Override // com.yy.render.IRemoteRender
            public void removeContentView(String str) {
                Handler handler;
                handler = RemoteRenderServices.this.mainHandler;
                handler.post(new b(str));
            }

            @Override // com.yy.render.IRemoteRender
            public void setListener(IRemoteListener iRemoteListener) {
                eyb.b.g("sub_process_view", "[RenderServices] invokeClient");
                if (iRemoteListener == null) {
                    eyb.b.g("sub_process_view", "[RenderServices] IRemoteListener is null");
                } else {
                    eyb.b.g("sub_process_view", "[RenderServices] IRemoteListener is normal");
                }
                synchronized (this) {
                    if (iRemoteListener != null) {
                        wxb.c.a().d(iRemoteListener);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // com.yy.render.IRemoteRender
            public void addContentView(String str, String str2) {
                Handler handler;
                eyb.a aVar = eyb.b;
                aVar.g("sub_process_view", "[RenderServices](addContentView) " + str);
                handler = RemoteRenderServices.this.mainHandler;
                handler.post(new a(str, str2));
            }

            @Override // com.yy.render.IRemoteRender
            public void sendBundle(String str, Bundle bundle) {
                ayb.f.a().c(str, bundle);
            }

            @Override // com.yy.render.IRemoteRender
            public boolean sendBundleForBoolean(String str, Bundle bundle) {
                return ayb.f.a().d(str, bundle);
            }

            @Override // com.yy.render.IRemoteRender
            public String sendBundleForStr(String str, Bundle bundle) {
                return ayb.f.a().e(str, bundle);
            }

            @Override // com.yy.render.IRemoteRender
            public void sendData(String str, String str2) {
                ayb.f.a().f(str, str2);
            }

            @Override // com.yy.render.IRemoteRender
            public boolean sendDataForBoolean(String str, String str2) {
                return ayb.f.a().g(str, str2);
            }

            @Override // com.yy.render.IRemoteRender
            public String sendDataForStr(String str, String str2) {
                return ayb.f.a().h(str, str2);
            }

            @Override // com.yy.render.IRemoteRender
            public void surfaceDestroyed(String str, Surface surface) {
                RemoteRenderServices.this.serverSurfaceDestroyed(str, surface);
            }

            @Override // com.yy.render.IRemoteRender
            public boolean unRegisterDataListener(String str, ITransDataListener iTransDataListener) {
                return ayb.f.a().k(str, iTransDataListener);
            }

            @Override // com.yy.render.IRemoteRender
            public void kill() {
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }

            @Override // com.yy.render.IRemoteRender
            public boolean registerDataListener(String str, String str2, ITransDataListener iTransDataListener) {
                Context context;
                ayb a2 = ayb.f.a();
                context = RemoteRenderServices.this.mContext;
                return a2.i(context, str, str2, iTransDataListener);
            }

            @Override // com.yy.render.IRemoteRender
            public void surfaceCreated(String str, Surface surface, String str2) {
                RemoteRenderServices.this.serverSurfaceCreated(str, surface, str2);
            }

            @Override // com.yy.render.IRemoteRender
            public void sendData2Channel(String str, String str2) {
                Class cls;
                LinkedHashMap linkedHashMap;
                LinkedHashMap linkedHashMap2;
                LinkedHashMap linkedHashMap3;
                LinkedHashMap linkedHashMap4;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    eyb.a aVar = eyb.b;
                    aVar.d("sub_process_view", "[RenderServices] get data channelId: " + str + ", data: " + str2);
                    try {
                        xxb a2 = xxb.c.a();
                        if (str == null) {
                            Intrinsics.throwNpe();
                        }
                        gyb c2 = a2.c(str);
                        if (c2 == null) {
                            cls = RemoteRenderServices.this.lock;
                            synchronized (cls) {
                                linkedHashMap = RemoteRenderServices.this.message;
                                if (linkedHashMap.get(str) == null) {
                                    linkedHashMap4 = RemoteRenderServices.this.message;
                                    linkedHashMap4.put(str, new LinkedList());
                                }
                                linkedHashMap2 = RemoteRenderServices.this.message;
                                LinkedList linkedList = (LinkedList) linkedHashMap2.get(str);
                                if (linkedList == null) {
                                    Intrinsics.throwNpe();
                                }
                                if (str2 == null) {
                                    Intrinsics.throwNpe();
                                }
                                linkedList.add(str2);
                                linkedHashMap3 = RemoteRenderServices.this.message;
                                LinkedList linkedList2 = (LinkedList) linkedHashMap3.put(str, linkedList);
                            }
                            return;
                        }
                        RemoteRenderServices.this.sendCacheMessage(c2, str);
                        if (str2 == null) {
                            Intrinsics.throwNpe();
                        }
                        c2.a(str2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        eyb.a aVar2 = eyb.b;
                        aVar2.c("[RenderServices] sendData2Channel ex: " + e2.getMessage());
                    }
                }
            }

            @Override // com.yy.render.IRemoteRender
            public void surfaceChanged(String str, Surface surface, String str2, int i, int i2, int i3) {
                RemoteRenderServices.this.serverSurfaceChanged(str, surface, str2, i, i2, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void serverSurfaceCreated(String str, Surface surface, String str2) {
        this.mainHandler.post(new d(str, str2, surface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gyb getRenderViewByReflect(String str, String str2) {
        try {
            Object newInstance = Class.forName(str).getConstructor(String.class).newInstance(str2);
            if (newInstance != null) {
                return (gyb) newInstance;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.yy.render.view.RenderView");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void serverSurfaceDestroyed(String str, Surface surface) {
        this.mainHandler.post(new e(str));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        eyb.b.e(true);
        eyb.b.d("sub_process_view", "[RenderService] (uncaughtException)");
        wxb.c.a().e("service uncaughtException");
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public final void sendCacheMessage(gyb gybVar, String str) {
        synchronized (this.lock) {
            LinkedList<String> linkedList = this.message.get(str);
            if (linkedList != null && linkedList.size() != 0) {
                for (String str2 : linkedList) {
                    gybVar.a(str2);
                }
                linkedList.clear();
                this.message.put(str, linkedList);
            }
        }
    }

    public final void serverSurfaceChanged(String str, Surface surface, String str2, int i, int i2, int i3) {
        eyb.a aVar = eyb.b;
        aVar.g("sub_process_view", "[RenderServices] server_surfaceChanged " + str + ", className: " + str2);
        this.surface = surface;
        new Handler(Looper.getMainLooper()).post(new c(str, str2, surface, i, i2, i3));
    }
}
