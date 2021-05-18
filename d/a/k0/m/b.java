package d.a.k0.m;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Integer, Integer> f57292a = new HashMap<>();

    public int a(int i2) {
        HashMap<Integer, Integer> hashMap = this.f57292a;
        if (hashMap != null && hashMap.containsKey(Integer.valueOf(i2))) {
            return this.f57292a.get(Integer.valueOf(i2)).intValue();
        }
        return 0;
    }

    public void b(int i2, int i3) {
        HashMap<Integer, Integer> hashMap = this.f57292a;
        if (hashMap == null) {
            return;
        }
        hashMap.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
