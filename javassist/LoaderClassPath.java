package javassist;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
/* loaded from: classes.dex */
public class LoaderClassPath implements a {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f2727a;

    public LoaderClassPath(ClassLoader classLoader) {
        this.f2727a = new WeakReference(classLoader);
    }

    public String toString() {
        Object obj = null;
        if (this.f2727a != null) {
            obj = this.f2727a.get();
        }
        return obj == null ? "<null>" : obj.toString();
    }

    @Override // javassist.a
    public InputStream a(String str) {
        String str2 = str.replace('.', '/') + ".class";
        ClassLoader classLoader = (ClassLoader) this.f2727a.get();
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResourceAsStream(str2);
    }

    @Override // javassist.a
    public URL b(String str) {
        String str2 = str.replace('.', '/') + ".class";
        ClassLoader classLoader = (ClassLoader) this.f2727a.get();
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResource(str2);
    }

    @Override // javassist.a
    public void a() {
        this.f2727a = null;
    }
}
