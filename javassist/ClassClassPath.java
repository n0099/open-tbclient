package javassist;

import java.io.InputStream;
import java.net.URL;
/* loaded from: classes.dex */
public class ClassClassPath implements a {

    /* renamed from: a  reason: collision with root package name */
    private Class f2722a;

    public ClassClassPath(Class cls) {
        this.f2722a = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClassClassPath() {
        this(Object.class);
    }

    @Override // javassist.a
    public InputStream a(String str) {
        return this.f2722a.getResourceAsStream("/" + str.replace('.', '/') + ".class");
    }

    @Override // javassist.a
    public URL b(String str) {
        return this.f2722a.getResource("/" + str.replace('.', '/') + ".class");
    }

    @Override // javassist.a
    public void a() {
    }

    public String toString() {
        return this.f2722a.getName() + ".class";
    }
}
