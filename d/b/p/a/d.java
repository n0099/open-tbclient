package d.b.p.a;

import android.text.TextUtils;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f64239b;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f64240a = new LinkedHashMap<>(150, 0.75f, true);

    public static d b() {
        if (f64239b == null) {
            synchronized (d.class) {
                if (f64239b == null) {
                    f64239b = new d();
                }
            }
        }
        return f64239b;
    }

    public int a(String str) {
        Integer num = this.f64240a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f64240a.remove(str);
    }

    public void d(String str, int i) {
        if (i == 0 && this.f64240a.containsKey(str)) {
            return;
        }
        this.f64240a.put(str, Integer.valueOf(i));
    }
}
