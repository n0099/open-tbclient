package d.a.o.a;

import android.text.TextUtils;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f67541b;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f67542a = new LinkedHashMap<>(150, 0.75f, true);

    public static d b() {
        if (f67541b == null) {
            synchronized (d.class) {
                if (f67541b == null) {
                    f67541b = new d();
                }
            }
        }
        return f67541b;
    }

    public int a(String str) {
        Integer num = this.f67542a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f67542a.remove(str);
    }

    public void d(String str, int i2) {
        if (i2 == 0 && this.f67542a.containsKey(str)) {
            return;
        }
        this.f67542a.put(str, Integer.valueOf(i2));
    }
}
