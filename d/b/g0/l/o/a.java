package d.b.g0.l.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.utils.AbiType;
import d.b.g0.l.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f49446d = f.f49281a;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, a> f49447e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, Map<String, a>> f49448f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f49449a;

    /* renamed from: b  reason: collision with root package name */
    public final String f49450b;

    /* renamed from: c  reason: collision with root package name */
    public final AbiType f49451c;

    public a(@NonNull String str, @NonNull AbiType abiType) {
        this.f49449a = TextUtils.isEmpty(str) ? "" : str;
        this.f49451c = abiType;
        this.f49450b = a(str, abiType);
        if (f49446d) {
            Log.i("SoBundleId", "SoBundleId: " + this.f49450b + " libName=" + str + " abi=" + abiType);
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
            map = f49448f.get(str);
            if (map == null) {
                map = new HashMap<>();
                if (!TextUtils.isEmpty(str)) {
                    for (AbiType abiType : AbiType.values()) {
                        a aVar = new a(str, abiType);
                        map.put(aVar.f49450b, aVar);
                    }
                    f49447e.putAll(map);
                    f49448f.put(str, map);
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
            if (f49446d) {
                Log.i("SoBundleId", "of: start libName=" + str + " bundleId=" + str2);
            }
            a aVar = null;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                c(str);
                a aVar2 = f49447e.get(str2);
                if (f49446d) {
                    Log.i("SoBundleId", "of: end libName=" + str + " soBundleId=" + aVar2);
                }
                if (aVar2 != null) {
                    if (TextUtils.equals(str, aVar2.f49449a)) {
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
        return this.f49450b;
    }
}
