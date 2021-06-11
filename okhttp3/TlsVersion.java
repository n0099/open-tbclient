package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    public final String javaName;

    TlsVersion(String str) {
        this.javaName = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static TlsVersion forJavaName(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == 79201641) {
            if (str.equals("SSLv3")) {
                c2 = 4;
            }
            c2 = 65535;
        } else if (hashCode != 79923350) {
            switch (hashCode) {
                case -503070503:
                    if (str.equals("TLSv1.1")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -503070502:
                    if (str.equals("TLSv1.2")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -503070501:
                    if (str.equals("TLSv1.3")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
        } else {
            if (str.equals("TLSv1")) {
                c2 = 3;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        if (c2 == 4) {
                            return SSL_3_0;
                        }
                        throw new IllegalArgumentException("Unexpected TLS version: " + str);
                    }
                    return TLS_1_0;
                }
                return TLS_1_1;
            }
            return TLS_1_2;
        }
        return TLS_1_3;
    }

    public static List<TlsVersion> forJavaNames(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(forJavaName(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String javaName() {
        return this.javaName;
    }
}
