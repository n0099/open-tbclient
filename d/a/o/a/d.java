package d.a.o.a;

import android.text.TextUtils;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f54896b;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f54897a = new LinkedHashMap<>(150, 0.75f, true);

    public static d b() {
        if (f54896b == null) {
            synchronized (d.class) {
                if (f54896b == null) {
                    f54896b = new d();
                }
            }
        }
        return f54896b;
    }

    public int a(String str) {
        Integer num = this.f54897a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f54897a.remove(str);
    }

    public void d(String str, int i2) {
        if (i2 == 0 && this.f54897a.containsKey(str)) {
            return;
        }
        this.f54897a.put(str, Integer.valueOf(i2));
    }
}
