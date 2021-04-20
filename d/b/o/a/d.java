package d.b.o.a;

import android.text.TextUtils;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f64885b;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f64886a = new LinkedHashMap<>(150, 0.75f, true);

    public static d b() {
        if (f64885b == null) {
            synchronized (d.class) {
                if (f64885b == null) {
                    f64885b = new d();
                }
            }
        }
        return f64885b;
    }

    public int a(String str) {
        Integer num = this.f64886a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f64886a.remove(str);
    }

    public void d(String str, int i) {
        if (i == 0 && this.f64886a.containsKey(str)) {
            return;
        }
        this.f64886a.put(str, Integer.valueOf(i));
    }
}
