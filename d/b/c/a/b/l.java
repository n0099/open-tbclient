package d.b.c.a.b;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.wallet.home.beans.WalletHomeBeanFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    public static final Comparator<String> f65562b = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, l> f65563c = new TreeMap(f65562b);

    /* renamed from: d  reason: collision with root package name */
    public static final l f65564d;

    /* renamed from: e  reason: collision with root package name */
    public static final l f65565e;

    /* renamed from: f  reason: collision with root package name */
    public static final l f65566f;

    /* renamed from: g  reason: collision with root package name */
    public static final l f65567g;

    /* renamed from: h  reason: collision with root package name */
    public static final l f65568h;

    /* renamed from: i  reason: collision with root package name */
    public static final l f65569i;
    public static final l j;
    public static final l k;
    public static final l l;
    public static final l m;
    public static final l n;
    public static final l o;
    public static final l p;
    public static final l q;
    public static final l r;

    /* renamed from: a  reason: collision with root package name */
    public final String f65570a;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<String> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i2 = 4; i2 < min; i2++) {
                char charAt = str.charAt(i2);
                char charAt2 = str2.charAt(i2);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    static {
        b("SSL_RSA_WITH_NULL_MD5", 1);
        b("SSL_RSA_WITH_NULL_SHA", 2);
        b("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        b("SSL_RSA_WITH_RC4_128_MD5", 4);
        b("SSL_RSA_WITH_RC4_128_SHA", 5);
        b("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        b("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f65564d = b("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        b("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        b("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        b("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        b("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        b("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        b("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        b("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        b("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        b("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        b("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        b("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        b("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        b("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        b("TLS_KRB5_WITH_RC4_128_SHA", 32);
        b("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        b("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        b("TLS_KRB5_WITH_RC4_128_MD5", 36);
        b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        b("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        b("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f65565e = b("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        b("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f65566f = b("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        b("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        b("TLS_RSA_WITH_NULL_SHA256", 59);
        b("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        b("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        b("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        b("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        b("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        b("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        b("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        b("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        b("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        b("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        b("TLS_PSK_WITH_RC4_128_SHA", 138);
        b("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        b("TLS_PSK_WITH_AES_128_CBC_SHA", PbFullScreenEditorActivity.REPLY_MAX_SIZE);
        b("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        b("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f65567g = b("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f65568h = b("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        b("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        b("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
        b("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        b("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        b("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        b("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        b("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        b("TLS_FALLBACK_SCSV", 22016);
        b("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        b("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        b("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", WalletHomeBeanFactory.BEAN_ID_HOME_CFG);
        b("TLS_ECDHE_ECDSA_WITH_NULL_SHA", WalletHomeBeanFactory.BEAN_ID_HOMETAB);
        b("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        b("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        f65569i = b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        j = b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        b("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        b("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        b("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        b("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        b("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        b("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        k = b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        l = b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        b("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        b("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        b("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        b("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        b("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        m = b("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        n = b("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        b("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        b("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        o = b("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        p = b("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        b("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        b("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        b("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        b("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        q = b("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        r = b("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    public l(String str) {
        if (str != null) {
            this.f65570a = str;
            return;
        }
        throw null;
    }

    public static synchronized l a(String str) {
        l lVar;
        synchronized (l.class) {
            lVar = f65563c.get(str);
            if (lVar == null) {
                lVar = new l(str);
                f65563c.put(str, lVar);
            }
        }
        return lVar;
    }

    public static l b(String str, int i2) {
        return a(str);
    }

    public static List<l> c(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String toString() {
        return this.f65570a;
    }
}
