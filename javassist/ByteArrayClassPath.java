package javassist;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes.dex */
public class ByteArrayClassPath implements a {

    /* renamed from: a  reason: collision with root package name */
    protected String f2737a;
    protected byte[] b;

    @Override // javassist.a
    public void a() {
    }

    public String toString() {
        return "byte[]:" + this.f2737a;
    }

    @Override // javassist.a
    public InputStream a(String str) {
        if (this.f2737a.equals(str)) {
            return new ByteArrayInputStream(this.b);
        }
        return null;
    }

    @Override // javassist.a
    public URL b(String str) {
        if (this.f2737a.equals(str)) {
            try {
                return new URL("file:/ByteArrayClassPath/" + (str.replace('.', '/') + ".class"));
            } catch (MalformedURLException e) {
            }
        }
        return null;
    }
}
