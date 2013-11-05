package javassist;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
/* loaded from: classes.dex */
public class LoaderClassPath implements a {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f2695a;

    public LoaderClassPath(ClassLoader classLoader) {
        this.f2695a = new WeakReference(classLoader);
    }

    public String toString() {
        Object obj = null;
        if (this.f2695a != null) {
            obj = this.f2695a.get();
        }
        return obj == null ? "<null>" : obj.toString();
    }

    @Override // javassist.a
    public InputStream a(String str) {
        String str2 = str.replace('.', '/') + ".class";
        ClassLoader classLoader = (ClassLoader) this.f2695a.get();
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResourceAsStream(str2);
    }

    @Override // javassist.a
    public URL b(String str) {
        String str2 = str.replace('.', '/') + ".class";
        ClassLoader classLoader = (ClassLoader) this.f2695a.get();
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResource(str2);
    }

    @Override // javassist.a
    public void a() {
        this.f2695a = null;
    }
}
