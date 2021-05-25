package d.a.l0.n.l;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.utils.AbiType;
import d.a.l0.n.c;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48180d = c.f47984a;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, a> f48181e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, Map<String, a>> f48182f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f48183a;

    /* renamed from: b  reason: collision with root package name */
    public final String f48184b;

    /* renamed from: c  reason: collision with root package name */
    public final AbiType f48185c;

    public a(@NonNull String str, @NonNull AbiType abiType) {
        this.f48183a = TextUtils.isEmpty(str) ? "" : str;
        this.f48185c = abiType;
        this.f48184b = a(str, abiType);
        if (f48180d) {
            Log.i("SoBundleId", "SoBundleId: " + this.f48184b + " libName=" + str + " abi=" + abiType);
        }
    }

    public static String a(String str, AbiType abiType) {
        return "so_" + str + "_" + abiType.id;
    }

    public static synchronized Map<String, a> b(@NonNull String str) {
        HashMap hashMap;
        synchronized (a.class) {
            hashMap = new HashMap(c(str));
        }
        return hashMap;
    }

    public static synchronized Map<String, a> c(@NonNull String str) {
        Map<String, a> map;
        synchronized (a.class) {
            map = f48182f.get(str);
            if (map == null) {
                map = new HashMap<>();
                if (!TextUtils.isEmpty(str)) {
                    for (AbiType abiType : AbiType.values()) {
                        a aVar = new a(str, abiType);
                        map.put(aVar.f48184b, aVar);
                    }
                    f48181e.putAll(map);
                    f48182f.put(str, map);
                }
            }
        }
        return map;
    }

    @Nullable
    public static synchronized a d(String str, AbiType abiType) {
        a e2;
        synchronized (a.class) {
            e2 = e(str, a(str, abiType));
        }
        return e2;
    }

    @Nullable
    public static synchronized a e(String str, String str2) {
        synchronized (a.class) {
            if (f48180d) {
                Log.i("SoBundleId", "of: start libName=" + str + " bundleId=" + str2);
            }
            a aVar = null;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                c(str);
                a aVar2 = f48181e.get(str2);
                if (f48180d) {
                    Log.i("SoBundleId", "of: end libName=" + str + " soBundleId=" + aVar2);
                }
                if (aVar2 != null) {
                    if (TextUtils.equals(str, aVar2.f48183a)) {
                        aVar = aVar2;
                    }
                }
                return aVar;
            }
            return null;
        }
    }

    @NonNull
    public String toString() {
        return this.f48184b;
    }
}
