package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class PM {
    private static final Map<Class<?>, String> h = new HashMap<Class<?>, String>() { // from class: com.qq.e.comm.managers.plugin.PM.2
        {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Context f11549b;
    private RandomAccessFile c;
    private FileLock d;
    private a.InterfaceC1181a f;

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f11548a = Executors.newSingleThreadExecutor();
    private a.b g = new a.b() { // from class: com.qq.e.comm.managers.plugin.PM.1
    };
    private boolean e = a();

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public interface InterfaceC1181a {
        }

        /* loaded from: classes3.dex */
        public interface b {
        }
    }

    public PM(Context context, a.InterfaceC1181a interfaceC1181a) {
        this.f11549b = context.getApplicationContext();
        this.f = interfaceC1181a;
    }

    private boolean a() {
        try {
            File a2 = b.a(this.f11549b);
            if (!a2.exists()) {
                a2.createNewFile();
                StringUtil.writeTo("lock", a2);
            }
            if (a2.exists()) {
                this.c = new RandomAccessFile(a2, "rw");
                this.d = this.c.getChannel().tryLock();
                if (this.d != null) {
                    this.c.writeByte(37);
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public <T> T getFactory(Class<T> cls) throws com.qq.e.comm.managers.plugin.a {
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = getClass().getClassLoader();
        GDTLogger.d("PluginClassLoader is parent" + (getClass().getClassLoader() == classLoader));
        if (classLoader == null) {
            throw new com.qq.e.comm.managers.plugin.a("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = h.get(cls);
            if (StringUtil.isEmpty(str)) {
                throw new com.qq.e.comm.managers.plugin.a("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new com.qq.e.comm.managers.plugin.a("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public String getLocalSig() {
        return null;
    }

    public POFactory getPOFactory() throws com.qq.e.comm.managers.plugin.a {
        return (POFactory) getFactory(POFactory.class);
    }

    public int getPluginVersion() {
        return Constants.PLUGIN.ASSET_PLUGIN_VERSION;
    }

    public void update(String str, String str2) {
    }
}
