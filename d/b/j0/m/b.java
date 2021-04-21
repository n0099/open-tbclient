package d.b.j0.m;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Integer, Integer> f58576a = new HashMap<>();

    public int a(int i) {
        HashMap<Integer, Integer> hashMap = this.f58576a;
        if (hashMap != null && hashMap.containsKey(Integer.valueOf(i))) {
            return this.f58576a.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public void b(int i, int i2) {
        HashMap<Integer, Integer> hashMap = this.f58576a;
        if (hashMap == null) {
            return;
        }
        hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
