package d.a.j0.m;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Integer, Integer> f56585a = new HashMap<>();

    public int a(int i2) {
        HashMap<Integer, Integer> hashMap = this.f56585a;
        if (hashMap != null && hashMap.containsKey(Integer.valueOf(i2))) {
            return this.f56585a.get(Integer.valueOf(i2)).intValue();
        }
        return 0;
    }

    public void b(int i2, int i3) {
        HashMap<Integer, Integer> hashMap = this.f56585a;
        if (hashMap == null) {
            return;
        }
        hashMap.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
