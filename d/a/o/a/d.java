package d.a.o.a;

import android.text.TextUtils;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f63441b;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f63442a = new LinkedHashMap<>(150, 0.75f, true);

    public static d b() {
        if (f63441b == null) {
            synchronized (d.class) {
                if (f63441b == null) {
                    f63441b = new d();
                }
            }
        }
        return f63441b;
    }

    public int a(String str) {
        Integer num = this.f63442a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f63442a.remove(str);
    }

    public void d(String str, int i2) {
        if (i2 == 0 && this.f63442a.containsKey(str)) {
            return;
        }
        this.f63442a.put(str, Integer.valueOf(i2));
    }
}
