package d.a.u0.e;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f68481a;

    /* renamed from: b  reason: collision with root package name */
    public static String f68482b;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f68481a = arrayList;
        arrayList.add(10000);
        f68481a.add(10001);
        f68481a.add(10002);
        f68481a.add(20001);
        f68481a.add(-1);
    }

    public static int a() {
        if (TextUtils.isEmpty(f68482b)) {
            f68482b = d.a.u0.e.h.d.a();
        }
        if (TextUtils.isEmpty(f68482b)) {
            return 20001;
        }
        if (f68482b.toUpperCase().contains("HUAWEI")) {
            return 10001;
        }
        return f68482b.toUpperCase().contains("XIAOMI") ? 10002 : 20001;
    }
}
