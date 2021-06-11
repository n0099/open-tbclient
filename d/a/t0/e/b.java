package d.a.t0.e;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f68377a;

    /* renamed from: b  reason: collision with root package name */
    public static String f68378b;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f68377a = arrayList;
        arrayList.add(10000);
        f68377a.add(10001);
        f68377a.add(10002);
        f68377a.add(20001);
        f68377a.add(-1);
    }

    public static int a() {
        if (TextUtils.isEmpty(f68378b)) {
            f68378b = d.a.t0.e.h.d.a();
        }
        if (TextUtils.isEmpty(f68378b)) {
            return 20001;
        }
        if (f68378b.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return f68378b.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
