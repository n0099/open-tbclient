package d.b.o.a;

import android.text.TextUtils;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f65128b;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f65129a = new LinkedHashMap<>(150, 0.75f, true);

    public static d b() {
        if (f65128b == null) {
            synchronized (d.class) {
                if (f65128b == null) {
                    f65128b = new d();
                }
            }
        }
        return f65128b;
    }

    public int a(String str) {
        Integer num = this.f65129a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f65129a.remove(str);
    }

    public void d(String str, int i) {
        if (i == 0 && this.f65129a.containsKey(str)) {
            return;
        }
        this.f65129a.put(str, Integer.valueOf(i));
    }
}
