package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class PM {
    public static final Map<Class<?>, String> n = new HashMap<Class<?>, String>() { // from class: com.qq.e.comm.managers.plugin.PM.2
        {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final Context f36249b;

    /* renamed from: c  reason: collision with root package name */
    public String f36250c;

    /* renamed from: d  reason: collision with root package name */
    public File f36251d;

    /* renamed from: e  reason: collision with root package name */
    public int f36252e;

    /* renamed from: f  reason: collision with root package name */
    public DexClassLoader f36253f;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f36254g;

    /* renamed from: h  reason: collision with root package name */
    public FileLock f36255h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36256i;
    public a.InterfaceC0431a j;
    public POFactory k;
    public int l;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f36248a = Executors.newSingleThreadExecutor();
    public a.b m = new a.b() { // from class: com.qq.e.comm.managers.plugin.PM.1
        @Override // com.qq.e.comm.managers.plugin.PM.a.b
        public final void a() {
            PM.a(PM.this);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.b
        public final void b() {
            PM.this.f();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public interface InterfaceC0431a {
            void onLoadFail();

            void onLoadSuccess();
        }

        /* loaded from: classes6.dex */
        public interface b {
            void a();

            void b();
        }
    }

    public PM(Context context, a.InterfaceC0431a interfaceC0431a) {
        this.f36249b = context.getApplicationContext();
        this.j = interfaceC0431a;
        long currentTimeMillis = System.currentTimeMillis();
        this.f36256i = d();
        if (b()) {
            a();
        }
        this.l = (int) (System.currentTimeMillis() - currentTimeMillis);
    }

    private void a() {
        StringBuilder sb = new StringBuilder("PluginFile:\t");
        File file = this.f36251d;
        sb.append(file == null ? StringUtil.NULL_STRING : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (this.f36250c == null || this.f36251d == null) {
            this.f36253f = null;
            return;
        }
        try {
            this.f36253f = new DexClassLoader(this.f36251d.getAbsolutePath(), d.a(this.f36249b).getAbsolutePath(), null, getClass().getClassLoader());
            e();
        } catch (Throwable th) {
            GDTLogger.e("exception while init plugin class loader", th);
            f();
        }
    }

    public static /* synthetic */ void a(PM pm) {
        try {
            if (pm.f36253f == null && pm.c()) {
                pm.a();
            }
        } catch (Exception e2) {
            GDTLogger.report("Exception while init online plugin: ", e2);
            pm.f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r2 == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b() {
        StringBuilder sb;
        boolean z;
        boolean z2 = false;
        try {
            GDTLogger.d("TimeStap_BEFORE_PLUGIN_INIT:" + System.currentTimeMillis());
            if (!c()) {
                if (this.f36256i) {
                    if (com.qq.e.comm.managers.plugin.a.a(this.f36249b, d.b(this.f36249b), d.e(this.f36249b))) {
                        this.f36250c = Sig.ASSET_PLUGIN_SIG;
                        this.f36251d = d.b(this.f36249b);
                        this.f36252e = 1203;
                        z = true;
                    } else {
                        GDTLogger.e("Fail to prepair Defult plugin ");
                    }
                }
                z = false;
            }
            z2 = true;
            sb = new StringBuilder("TimeStap_AFTER_PLUGIN_INIT:");
        } catch (Throwable th) {
            try {
                GDTLogger.report("Exception while init plugin manager", th);
                sb = new StringBuilder("TimeStap_AFTER_PLUGIN_INIT:");
            } catch (Throwable th2) {
                GDTLogger.d("TimeStap_AFTER_PLUGIN_INIT:" + System.currentTimeMillis());
                throw th2;
            }
        }
        sb.append(System.currentTimeMillis());
        GDTLogger.d(sb.toString());
        return z2;
    }

    private boolean c() {
        if (this.f36256i) {
            com.qq.e.comm.managers.plugin.a aVar = new com.qq.e.comm.managers.plugin.a(d.d(this.f36249b), d.g(this.f36249b));
            if (aVar.a()) {
                boolean a2 = aVar.a(d.b(this.f36249b), d.e(this.f36249b));
                GDTLogger.d("NextExist,Updated=" + a2);
            }
        }
        com.qq.e.comm.managers.plugin.a aVar2 = new com.qq.e.comm.managers.plugin.a(d.b(this.f36249b), d.e(this.f36249b));
        if (aVar2.a()) {
            if (aVar2.b() >= 1203) {
                this.f36250c = aVar2.c();
                this.f36252e = aVar2.b();
                this.f36251d = d.b(this.f36249b);
                return true;
            }
            GDTLogger.d("last updated plugin version =" + this.f36252e + ";asset plugin version=1203");
            return false;
        }
        return false;
    }

    private boolean d() {
        try {
            File h2 = d.h(this.f36249b);
            if (!h2.exists()) {
                h2.createNewFile();
                com.qq.e.comm.util.StringUtil.writeTo("lock", h2);
            }
            if (h2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(h2, "rw");
                this.f36254g = randomAccessFile;
                FileLock tryLock = randomAccessFile.getChannel().tryLock();
                this.f36255h = tryLock;
                if (tryLock != null) {
                    this.f36254g.writeByte(37);
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void e() {
        a.InterfaceC0431a interfaceC0431a = this.j;
        if (interfaceC0431a != null) {
            interfaceC0431a.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        a.InterfaceC0431a interfaceC0431a = this.j;
        if (interfaceC0431a != null) {
            interfaceC0431a.onLoadFail();
        }
    }

    public <T> T getFactory(Class<T> cls) throws c {
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f36253f;
        StringBuilder sb = new StringBuilder("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new c("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = n.get(cls);
            if (com.qq.e.comm.util.StringUtil.isEmpty(str)) {
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

    public int getInitCostTime() {
        return this.l;
    }

    public String getLocalSig() {
        return this.f36250c;
    }

    public POFactory getPOFactory() throws c {
        if (this.k == null) {
            this.k = (POFactory) getFactory(POFactory.class);
        }
        return this.k;
    }

    public int getPluginVersion() {
        return this.f36252e;
    }

    public void update(String str, String str2) {
        if (this.f36256i) {
            b bVar = new b(this.f36249b, this.f36248a);
            bVar.a(this.m);
            bVar.a(str, str2);
        }
    }
}
