package d.b.o0.e;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f64192a;

    /* renamed from: b  reason: collision with root package name */
    public static String f64193b;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f64192a = arrayList;
        arrayList.add(10000);
        f64192a.add(10001);
        f64192a.add(10002);
        f64192a.add(20001);
        f64192a.add(-1);
    }

    public static int a() {
        if (TextUtils.isEmpty(f64193b)) {
            f64193b = d.b.o0.e.h.d.a();
        }
        if (TextUtils.isEmpty(f64193b)) {
            return 20001;
        }
        if (f64193b.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return f64193b.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
