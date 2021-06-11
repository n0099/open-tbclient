package d.a.z.h.b;

import android.content.Context;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
/* loaded from: classes2.dex */
public class a extends BaseDexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    public ClassLoader f68675a;

    /* renamed from: b  reason: collision with root package name */
    public ClassLoader f68676b;

    /* renamed from: c  reason: collision with root package name */
    public Context f68677c;

    public a(String str, String str2, String str3, Context context) {
        super(str, new File(str2), str3, ClassLoader.getSystemClassLoader());
        this.f68677c = context;
        this.f68675a = context.getClass().getClassLoader();
        this.f68676b = ClassLoader.getSystemClassLoader();
    }

    public final Class<?> a(String str) throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = this.f68676b.loadClass(str);
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            return cls;
        }
        try {
            cls = super.findClass(str);
        } catch (ClassNotFoundException unused2) {
        }
        if (cls != null) {
            return cls;
        }
        throw new ClassNotFoundException("Didn't find class: " + str + " in own classloader.");
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        return findLibrary != null ? findLibrary : ((PathClassLoader) this.f68675a).findLibrary(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String str) {
        URL findResource = super.findResource(str);
        return findResource != null ? findResource : this.f68675a.getResource(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        Enumeration<URL> findResources = super.findResources(str);
        if (findResources != null) {
            return findResources;
        }
        try {
            return this.f68675a.getResources(str);
        } catch (IOException unused) {
            return findResources;
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            findLoadedClass = a(str);
        } catch (ClassNotFoundException unused) {
        }
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            findLoadedClass = this.f68675a.loadClass(str);
        } catch (ClassNotFoundException unused2) {
        }
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        throw new ClassNotFoundException("Didn't find class \"" + str + "\"");
    }
}
