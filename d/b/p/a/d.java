package d.b.p.a;

import android.text.TextUtils;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f64240b;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f64241a = new LinkedHashMap<>(150, 0.75f, true);

    public static d b() {
        if (f64240b == null) {
            synchronized (d.class) {
                if (f64240b == null) {
                    f64240b = new d();
                }
            }
        }
        return f64240b;
    }

    public int a(String str) {
        Integer num = this.f64241a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f64241a.remove(str);
    }

    public void d(String str, int i) {
        if (i == 0 && this.f64241a.containsKey(str)) {
            return;
        }
        this.f64241a.put(str, Integer.valueOf(i));
    }
}
