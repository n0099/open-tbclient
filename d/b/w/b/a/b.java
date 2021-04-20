package d.b.w.b.a;

import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.nps.main.manager.NPSManager;
import d.b.w.h.g;
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
    public final ClassLoader f65522a;

    /* renamed from: b  reason: collision with root package name */
    public Method f65523b;

    /* renamed from: c  reason: collision with root package name */
    public Method f65524c;

    /* renamed from: d  reason: collision with root package name */
    public Method f65525d;

    /* renamed from: e  reason: collision with root package name */
    public Method f65526e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f65527f;

    public b(ClassLoader classLoader, ClassLoader classLoader2) {
        super("", "", classLoader);
        this.f65527f = new HashSet();
        this.f65522a = classLoader2;
        b(classLoader2);
        c(classLoader2);
        this.f65527f.add("android.widget.ViewStub");
        this.f65527f.add("android.widget.View");
        this.f65527f.add("android.webkit.ViewStub");
        this.f65527f.add("android.webkit.View");
        this.f65527f.add("android.app.ViewStub");
        this.f65527f.add("android.app.View");
        this.f65527f.add("com.google.android.gms.net.PlayServicesCronetProvider");
        this.f65527f.add("com.google.android.gms.net.GmsCoreCronetProvider");
        this.f65527f.add("org.chromium.net.impl.JavaCronetProvider");
    }

    public final void a(String str, ClassLoader classLoader) {
        try {
            Field a2 = g.a(classLoader.getClass(), str);
            g.g(a2);
            g.k(a2, this, g.f(a2, classLoader));
        } catch (IllegalAccessException unused) {
        }
    }

    public final void b(ClassLoader classLoader) {
        a("pathList", classLoader);
    }

    public final void c(ClassLoader classLoader) {
        Class<?> cls = classLoader.getClass();
        Method b2 = g.b(cls, "findResource", String.class);
        this.f65523b = b2;
        b2.setAccessible(true);
        Method b3 = g.b(cls, "findResources", String.class);
        this.f65524c = b3;
        b3.setAccessible(true);
        Method b4 = g.b(cls, "findLibrary", String.class);
        this.f65525d = b4;
        b4.setAccessible(true);
        Method b5 = g.b(cls, "getPackage", String.class);
        this.f65526e = b5;
        b5.setAccessible(true);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        return super.findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        try {
            return (String) this.f65525d.invoke(this.f65522a, str);
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
            return (URL) this.f65523b.invoke(this.f65522a, str);
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
            return (Enumeration) this.f65524c.invoke(this.f65522a, str);
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
                r0 = (Package) this.f65526e.invoke(this.f65522a, str);
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
            return this.f65522a.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return (this.f65527f.contains(str) || (loadComponentClass = NPSManager.getInstance().loadComponentClass(str)) == null) ? super.loadClass(str, z) : loadComponentClass;
        }
    }

    @Override // dalvik.system.BaseDexClassLoader
    public String toString() {
        return b.class.getName() + "[mBase=" + this.f65522a.toString() + "]";
    }
}
