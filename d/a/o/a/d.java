package d.a.o.a;

import android.text.TextUtils;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f64038b;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f64039a = new LinkedHashMap<>(150, 0.75f, true);

    public static d b() {
        if (f64038b == null) {
            synchronized (d.class) {
                if (f64038b == null) {
                    f64038b = new d();
                }
            }
        }
        return f64038b;
    }

    public int a(String str) {
        Integer num = this.f64039a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f64039a.remove(str);
    }

    public void d(String str, int i2) {
        if (i2 == 0 && this.f64039a.containsKey(str)) {
            return;
        }
        this.f64039a.put(str, Integer.valueOf(i2));
    }
}
