package d.a.m0.n.l;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.utils.AbiType;
import d.a.m0.n.c;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f51962d = c.f51766a;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, a> f51963e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, Map<String, a>> f51964f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f51965a;

    /* renamed from: b  reason: collision with root package name */
    public final String f51966b;

    /* renamed from: c  reason: collision with root package name */
    public final AbiType f51967c;

    public a(@NonNull String str, @NonNull AbiType abiType) {
        this.f51965a = TextUtils.isEmpty(str) ? "" : str;
        this.f51967c = abiType;
        this.f51966b = a(str, abiType);
        if (f51962d) {
            Log.i("SoBundleId", "SoBundleId: " + this.f51966b + " libName=" + str + " abi=" + abiType);
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
            map = f51964f.get(str);
            if (map == null) {
                map = new HashMap<>();
                if (!TextUtils.isEmpty(str)) {
                    for (AbiType abiType : AbiType.values()) {
                        a aVar = new a(str, abiType);
                        map.put(aVar.f51966b, aVar);
                    }
                    f51963e.putAll(map);
                    f51964f.put(str, map);
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
            if (f51962d) {
                Log.i("SoBundleId", "of: start libName=" + str + " bundleId=" + str2);
            }
            a aVar = null;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                c(str);
                a aVar2 = f51963e.get(str2);
                if (f51962d) {
                    Log.i("SoBundleId", "of: end libName=" + str + " soBundleId=" + aVar2);
                }
                if (aVar2 != null) {
                    if (TextUtils.equals(str, aVar2.f51965a)) {
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
        return this.f51966b;
    }
}
