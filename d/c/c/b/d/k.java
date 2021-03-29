package d.c.c.b.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f65723a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f65724b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f65725c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f65726d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f65727e;

    /* renamed from: f  reason: collision with root package name */
    public final long f65728f;

    @Deprecated
    public k(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, a(map), z, j);
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

    public k(int i, byte[] bArr, boolean z, long j, List<a> list) {
        this(i, bArr, b(list), list, z, j);
    }

    @Deprecated
    public k(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    public k(int i, byte[] bArr, Map<String, String> map, List<a> list, boolean z, long j) {
        this.f65723a = i;
        this.f65724b = bArr;
        this.f65725c = map;
        if (list == null) {
            this.f65726d = null;
        } else {
            this.f65726d = Collections.unmodifiableList(list);
        }
        this.f65727e = z;
        this.f65728f = j;
    }
}
