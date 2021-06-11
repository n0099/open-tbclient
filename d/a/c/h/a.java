package d.a.c.h;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import dalvik.system.DexClassLoader;
/* loaded from: classes.dex */
public class a extends DexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    public ClassLoader f42707a;

    public a(String str, String str2, String str3, ClassLoader classLoader, ClassLoader classLoader2) {
        super(str, str2, str3, classLoader);
        this.f42707a = null;
        this.f42707a = classLoader2;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            return super.findClass(str);
        } catch (Exception unused) {
            ClassLoader classLoader = this.f42707a;
            if (classLoader != null) {
                Class<?> loadClass = classLoader.loadClass(str);
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.i("findClass from container. classname is " + str);
                }
                return loadClass;
            }
            return null;
        }
    }
}
