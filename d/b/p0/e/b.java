package d.b.p0.e;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f65169a;

    /* renamed from: b  reason: collision with root package name */
    public static String f65170b;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f65169a = arrayList;
        arrayList.add(10000);
        f65169a.add(10001);
        f65169a.add(10002);
        f65169a.add(20001);
        f65169a.add(-1);
    }

    public static int a() {
        if (TextUtils.isEmpty(f65170b)) {
            f65170b = d.b.p0.e.h.d.a();
        }
        if (TextUtils.isEmpty(f65170b)) {
            return 20001;
        }
        if (f65170b.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return f65170b.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
