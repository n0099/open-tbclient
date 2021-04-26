package d.r.b.a.a;

import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, IRevenue> f66955a = new HashMap();

    public static void a(IRLogDelegate iRLogDelegate) {
        d.r.b.a.a.f.d.d.a(iRLogDelegate);
    }

    public static synchronized IRevenue b(int i2, int i3, b bVar) {
        IRevenue iRevenue;
        synchronized (d.class) {
            String e2 = e(i2, i3);
            d.r.b.a.a.f.d.d.f("RevenueSdk", "initRevenue: appId =" + i2 + " userchanel=" + i3 + " mapKey=" + e2);
            if (f66955a.get(Integer.valueOf(i2)) == null) {
                try {
                    a aVar = new a(i2);
                    aVar.b(bVar);
                    RevenueDataParser.INSTANCE.registerDataReceivers(aVar);
                    f66955a.put(e2, aVar);
                } catch (Exception e3) {
                    d.r.b.a.a.f.d.d.d("RevenueSdk", "initRevenue error.", e3);
                    return null;
                }
            } else {
                c.a(i2, bVar);
            }
            iRevenue = f66955a.get(e2);
        }
        return iRevenue;
    }

    public static synchronized List<IRevenue> c() {
        ArrayList arrayList;
        synchronized (d.class) {
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < f66955a.size(); i2++) {
                arrayList.add(f66955a.get(Integer.valueOf(i2)));
            }
        }
        return arrayList;
    }

    public static synchronized IRevenue d(int i2, int i3) {
        IRevenue iRevenue;
        synchronized (d.class) {
            String e2 = e(i2, i3);
            iRevenue = f66955a.get(e2);
            if (iRevenue == null) {
                d.r.b.a.a.f.d.d.e("RevenueSdk", "getRevenue == null,mapKey = %d", e2);
            }
        }
        return iRevenue;
    }

    public static String e(int i2, int i3) {
        return i2 + "-" + i3;
    }

    public static synchronized void f(int i2, int i3) {
        synchronized (d.class) {
            String e2 = e(i2, i3);
            d.r.b.a.a.f.d.d.f("RevenueSdk", "removeRevenueConfig: appId =" + i2 + " userchanel=" + i3 + " mapKey=" + e2);
            if (f66955a.get(Integer.valueOf(i2)) == null) {
                return;
            }
            f66955a.remove(Integer.valueOf(i2));
            c.c(i2);
        }
    }
}
