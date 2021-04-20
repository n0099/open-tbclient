package d.b.r.a.c;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f65301a;

    /* renamed from: b  reason: collision with root package name */
    public e f65302b = null;

    public d(Context context) {
        this.f65301a = context;
    }

    public e a() {
        return this.f65302b;
    }

    public abstract InputStream b() throws Exception;

    public abstract void c(e eVar);

    public abstract boolean d() throws IOException;

    public abstract e e(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, SSLHandshakeException, AssertionError;

    public abstract void f(b bVar) throws IOException;
}
