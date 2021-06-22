package d.a.z.b.a;

import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import d.a.z.i.h;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b extends PathClassLoader {

    /* renamed from: a  reason: collision with root package name */
    public final ClassLoader f68715a;

    /* renamed from: b  reason: collision with root package name */
    public Method f68716b;

    /* renamed from: c  reason: collision with root package name */
    public Method f68717c;

    /* renamed from: d  reason: collision with root package name */
    public Method f68718d;

    /* renamed from: e  reason: collision with root package name */
    public Method f68719e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f68720f;

    public b(ClassLoader classLoader, ClassLoader classLoader2) {
        super("", "", classLoader);
        this.f68720f = new HashSet();
        this.f68715a = classLoader2;
        b(classLoader2);
        c(classLoader2);
        this.f68720f.add("android.widget.ViewStub");
        this.f68720f.add("android.widget.View");
        this.f68720f.add("android.webkit.ViewStub");
        this.f68720f.add("android.webkit.View");
        this.f68720f.add("android.app.ViewStub");
        this.f68720f.add("android.app.View");
        this.f68720f.add("com.google.android.gms.net.PlayServicesCronetProvider");
        this.f68720f.add("com.google.android.gms.net.GmsCoreCronetProvider");
        this.f68720f.add("org.chromium.net.impl.JavaCronetProvider");
    }

    public final void a(String str, ClassLoader classLoader) {
        try {
            Field a2 = h.a(classLoader.getClass(), str);
            h.g(a2);
            h.k(a2, this, h.f(a2, classLoader));
        } catch (IllegalAccessException unused) {
        }
    }

    public final void b(ClassLoader classLoader) {
        a("pathList", classLoader);
    }

    public final void c(ClassLoader classLoader) {
        Class<?> cls = classLoader.getClass();
        Method b2 = h.b(cls, "findResource", String.class);
        this.f68716b = b2;
        b2.setAccessible(true);
        Method b3 = h.b(cls, "findResources", String.class);
        this.f68717c = b3;
        b3.setAccessible(true);
        Method b4 = h.b(cls, "findLibrary", String.class);
        this.f68718d = b4;
        b4.setAccessible(true);
        Method b5 = h.b(cls, "getPackage", String.class);
        this.f68719e = b5;
        b5.setAccessible(true);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        return super.findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        try {
            return (String) this.f68718d.invoke(this.f68715a, str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return super.findLibrary(str);
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return super.findLibrary(str);
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return super.findLibrary(str);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String str) {
        try {
            return (URL) this.f68716b.invoke(this.f68715a, str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return super.findResource(str);
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return super.findResource(str);
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return super.findResource(str);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        try {
            return (Enumeration) this.f68717c.invoke(this.f68715a, str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return super.findResources(str);
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return super.findResources(str);
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return super.findResources(str);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Package getPackage(String str) {
        Package r0 = null;
        if (str != null && !str.isEmpty()) {
            try {
                r0 = (Package) this.f68719e.invoke(this.f68715a, str);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
            if (r0 == null) {
                r0 = super.getPackage(str);
            }
            if (r0 == null) {
                return definePackage(str, "Unknown", XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT, "Unknown", "Unknown", XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT, "Unknown", null);
            }
        }
        return r0;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> loadComponentClass;
        try {
            return this.f68715a.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return (this.f68720f.contains(str) || (loadComponentClass = NPSManager.getInstance().loadComponentClass(str)) == null) ? super.loadClass(str, z) : loadComponentClass;
        }
    }

    @Override // dalvik.system.BaseDexClassLoader
    public String toString() {
        return b.class.getName() + "[mBase=" + this.f68715a.toString() + PreferencesUtil.RIGHT_MOUNT;
    }
}
