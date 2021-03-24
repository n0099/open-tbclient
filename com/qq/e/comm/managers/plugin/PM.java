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
    public final Context f38288b;

    /* renamed from: c  reason: collision with root package name */
    public String f38289c;

    /* renamed from: d  reason: collision with root package name */
    public File f38290d;

    /* renamed from: e  reason: collision with root package name */
    public int f38291e;

    /* renamed from: f  reason: collision with root package name */
    public DexClassLoader f38292f;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f38293g;

    /* renamed from: h  reason: collision with root package name */
    public FileLock f38294h;
    public boolean i;
    public a.InterfaceC0469a j;
    public POFactory k;
    public int l;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f38287a = Executors.newSingleThreadExecutor();
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
        public interface InterfaceC0469a {
            void onLoadFail();

            void onLoadSuccess();
        }

        /* loaded from: classes6.dex */
        public interface b {
            void a();

            void b();
        }
    }

    public PM(Context context, a.InterfaceC0469a interfaceC0469a) {
        this.f38288b = context.getApplicationContext();
        this.j = interfaceC0469a;
        long currentTimeMillis = System.currentTimeMillis();
        this.i = d();
        if (b()) {
            a();
        }
        this.l = (int) (System.currentTimeMillis() - currentTimeMillis);
    }

    private void a() {
        StringBuilder sb = new StringBuilder("PluginFile:\t");
        File file = this.f38290d;
        sb.append(file == null ? StringUtil.NULL_STRING : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (this.f38289c == null || this.f38290d == null) {
            this.f38292f = null;
            return;
        }
        try {
            this.f38292f = new DexClassLoader(this.f38290d.getAbsolutePath(), d.a(this.f38288b).getAbsolutePath(), null, getClass().getClassLoader());
            e();
        } catch (Throwable th) {
            GDTLogger.e("exception while init plugin class loader", th);
            f();
        }
    }

    public static /* synthetic */ void a(PM pm) {
        try {
            if (pm.f38292f == null && pm.c()) {
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
                if (this.i) {
                    if (com.qq.e.comm.managers.plugin.a.a(this.f38288b, d.b(this.f38288b), d.e(this.f38288b))) {
                        this.f38289c = Sig.ASSET_PLUGIN_SIG;
                        this.f38290d = d.b(this.f38288b);
                        this.f38291e = 1203;
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
        if (this.i) {
            com.qq.e.comm.managers.plugin.a aVar = new com.qq.e.comm.managers.plugin.a(d.d(this.f38288b), d.g(this.f38288b));
            if (aVar.a()) {
                boolean a2 = aVar.a(d.b(this.f38288b), d.e(this.f38288b));
                GDTLogger.d("NextExist,Updated=" + a2);
            }
        }
        com.qq.e.comm.managers.plugin.a aVar2 = new com.qq.e.comm.managers.plugin.a(d.b(this.f38288b), d.e(this.f38288b));
        if (aVar2.a()) {
            if (aVar2.b() >= 1203) {
                this.f38289c = aVar2.c();
                this.f38291e = aVar2.b();
                this.f38290d = d.b(this.f38288b);
                return true;
            }
            GDTLogger.d("last updated plugin version =" + this.f38291e + ";asset plugin version=1203");
            return false;
        }
        return false;
    }

    private boolean d() {
        try {
            File h2 = d.h(this.f38288b);
            if (!h2.exists()) {
                h2.createNewFile();
                com.qq.e.comm.util.StringUtil.writeTo("lock", h2);
            }
            if (h2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(h2, "rw");
                this.f38293g = randomAccessFile;
                FileLock tryLock = randomAccessFile.getChannel().tryLock();
                this.f38294h = tryLock;
                if (tryLock != null) {
                    this.f38293g.writeByte(37);
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
        a.InterfaceC0469a interfaceC0469a = this.j;
        if (interfaceC0469a != null) {
            interfaceC0469a.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        a.InterfaceC0469a interfaceC0469a = this.j;
        if (interfaceC0469a != null) {
            interfaceC0469a.onLoadFail();
        }
    }

    public <T> T getFactory(Class<T> cls) throws c {
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f38292f;
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
        return this.f38289c;
    }

    public POFactory getPOFactory() throws c {
        if (this.k == null) {
            this.k = (POFactory) getFactory(POFactory.class);
        }
        return this.k;
    }

    public int getPluginVersion() {
        return this.f38291e;
    }

    public void update(String str, String str2) {
        if (this.i) {
            b bVar = new b(this.f38288b, this.f38287a);
            bVar.a(this.m);
            bVar.a(str, str2);
        }
    }
}
