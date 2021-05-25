package d.b.c.a.b.a.k;

import com.baidu.android.common.others.IStringUtil;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.CertificatePinner;
/* loaded from: classes6.dex */
public final class e implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final e f65490a = new e();

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> b2 = b(x509Certificate, 7);
        List<String> b3 = b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(b2.size() + b3.size());
        arrayList.addAll(b2);
        arrayList.addAll(b3);
        return arrayList;
    }

    public static List<String> b(X509Certificate x509Certificate, int i2) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i2 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public boolean c(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith(IStringUtil.TOP_PATH) && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith(IStringUtil.TOP_PATH)) {
            if (!str.endsWith(".")) {
                str = str + IStringUtil.EXTENSION_SEPARATOR;
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + IStringUtil.EXTENSION_SEPARATOR;
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith(CertificatePinner.Pin.WILDCARD) || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || CertificatePinner.Pin.WILDCARD.equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (str.endsWith(substring)) {
                int length = str.length() - substring.length();
                return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
            }
            return false;
        }
        return false;
    }

    public boolean d(String str, X509Certificate x509Certificate) {
        if (d.b.c.a.b.a.e.D(str)) {
            return e(str, x509Certificate);
        }
        return f(str, x509Certificate);
    }

    public final boolean e(String str, X509Certificate x509Certificate) {
        List<String> b2 = b(x509Certificate, 7);
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equalsIgnoreCase(b2.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(String str, X509Certificate x509Certificate) {
        String c2;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> b2 = b(x509Certificate, 2);
        int size = b2.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            if (c(lowerCase, b2.get(i2))) {
                return true;
            }
            i2++;
            z = true;
        }
        if (z || (c2 = new d(x509Certificate.getSubjectX500Principal()).c(AdvanceSetting.CLEAR_NOTIFICATION)) == null) {
            return false;
        }
        return c(lowerCase, c2);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return d(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
