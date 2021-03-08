package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.yy.mediaframework.stat.VideoDataStatistic;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class PM {
    private static final Map<Class<?>, String> m = new HashMap<Class<?>, String>() { // from class: com.qq.e.comm.managers.plugin.PM.2
        {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    };
    private final Context b;
    private String c;
    private File d;
    private int e;
    private DexClassLoader f;
    private RandomAccessFile g;
    private FileLock h;
    private a.InterfaceC1204a j;
    private POFactory k;

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f7564a = Executors.newSingleThreadExecutor();
    private a.b l = new a.b() { // from class: com.qq.e.comm.managers.plugin.PM.1
        @Override // com.qq.e.comm.managers.plugin.PM.a.b
        public final void a() {
            PM.a(PM.this);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.b
        public final void b() {
            PM.this.f();
        }
    };
    private boolean i = d();

    /* loaded from: classes4.dex */
    public interface a {

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public interface InterfaceC1204a {
            void onLoadFail();

            void onLoadSuccess();
        }

        /* loaded from: classes4.dex */
        public interface b {
            void a();

            void b();
        }
    }

    public PM(Context context, a.InterfaceC1204a interfaceC1204a) {
        this.b = context.getApplicationContext();
        this.j = interfaceC1204a;
        if (b()) {
            a();
        }
    }

    private void a() {
        GDTLogger.d("PluginFile:\t" + (this.d == null ? "null" : this.d.getAbsolutePath()));
        if (this.c == null || this.d == null) {
            this.f = null;
            return;
        }
        try {
            this.f = new DexClassLoader(this.d.getAbsolutePath(), d.a(this.b).getAbsolutePath(), null, getClass().getClassLoader());
            e();
        } catch (Throwable th) {
            GDTLogger.e("exception while init plugin class loader", th);
            f();
        }
    }

    static /* synthetic */ void a(PM pm) {
        try {
            if (pm.f == null && pm.c()) {
                pm.a();
            }
        } catch (Exception e) {
            GDTLogger.report("Exception while init online plugin: ", e);
            pm.f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r2 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b() {
        boolean z;
        boolean z2 = false;
        try {
            GDTLogger.d("TimeStap_BEFORE_PLUGIN_INIT:" + System.currentTimeMillis());
            if (!c()) {
                if (!this.i) {
                    z = false;
                } else if (com.qq.e.comm.managers.plugin.a.a(this.b, d.b(this.b), d.e(this.b))) {
                    this.c = Sig.ASSET_PLUGIN_SIG;
                    this.d = d.b(this.b);
                    this.e = Constants.PLUGIN.ASSET_PLUGIN_VERSION;
                    z = true;
                } else {
                    GDTLogger.e("Fail to prepair Defult plugin ");
                    z = false;
                }
            }
            z2 = true;
        } catch (Throwable th) {
            try {
                GDTLogger.report("Exception while init plugin manager", th);
            } finally {
                GDTLogger.d("TimeStap_AFTER_PLUGIN_INIT:" + System.currentTimeMillis());
            }
        }
        return z2;
    }

    private boolean c() {
        if (this.i) {
            com.qq.e.comm.managers.plugin.a aVar = new com.qq.e.comm.managers.plugin.a(d.d(this.b), d.g(this.b));
            if (aVar.a()) {
                GDTLogger.d("NextExist,Updated=" + aVar.a(d.b(this.b), d.e(this.b)));
            }
        }
        com.qq.e.comm.managers.plugin.a aVar2 = new com.qq.e.comm.managers.plugin.a(d.b(this.b), d.e(this.b));
        if (aVar2.a()) {
            if (aVar2.b() < 1180) {
                GDTLogger.d("last updated plugin version =" + this.e + ";asset plugin version=1180");
                return false;
            }
            this.c = aVar2.c();
            this.e = aVar2.b();
            this.d = d.b(this.b);
            return true;
        }
        return false;
    }

    private boolean d() {
        try {
            File h = d.h(this.b);
            if (!h.exists()) {
                h.createNewFile();
                StringUtil.writeTo("lock", h);
            }
            if (h.exists()) {
                this.g = new RandomAccessFile(h, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                this.h = this.g.getChannel().tryLock();
                if (this.h != null) {
                    this.g.writeByte(37);
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private void e() {
        if (this.j != null) {
            this.j.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.j != null) {
            this.j.onLoadFail();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.ClassLoader] */
    public <T> T getFactory(Class<T> cls) throws c {
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        DexClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? getClass().getClassLoader() : this.f;
        GDTLogger.d("PluginClassLoader is parent" + (getClass().getClassLoader() == classLoader));
        if (classLoader == null) {
            throw new c("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = m.get(cls);
            if (StringUtil.isEmpty(str)) {
                throw new c("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new c("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public String getLocalSig() {
        return this.c;
    }

    public POFactory getPOFactory() throws c {
        if (this.k == null) {
            this.k = (POFactory) getFactory(POFactory.class);
        }
        return this.k;
    }

    public int getPluginVersion() {
        return this.e;
    }

    public void update(String str, String str2) {
        if (this.i) {
            b bVar = new b(this.b, this.f7564a);
            bVar.a(this.l);
            bVar.a(str, str2);
        }
    }
}
