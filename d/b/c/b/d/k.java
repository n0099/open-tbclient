package d.b.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f69627a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f69628b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f69629c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f69630d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f69631e;

    /* renamed from: f  reason: collision with root package name */
    public final long f69632f;

    @Deprecated
    public k(int i2, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i2, bArr, map, a(map), z, j);
    }

    public static List<a> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new a(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static Map<String, String> b(List<a> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (a aVar : list) {
            treeMap.put(aVar.a(), aVar.b());
        }
        return treeMap;
    }

    public k(int i2, byte[] bArr, boolean z, long j, List<a> list) {
        this(i2, bArr, b(list), list, z, j);
    }

    @Deprecated
    public k(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    public k(int i2, byte[] bArr, Map<String, String> map, List<a> list, boolean z, long j) {
        this.f69627a = i2;
        this.f69628b = bArr;
        this.f69629c = map;
        if (list == null) {
            this.f69630d = null;
        } else {
            this.f69630d = Collections.unmodifiableList(list);
        }
        this.f69631e = z;
        this.f69632f = j;
    }
}
