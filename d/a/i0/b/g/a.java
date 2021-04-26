package d.a.i0.b.g;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.i0.b.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f48033a = "key_user_last_access_tab_";

    /* renamed from: b  reason: collision with root package name */
    public static String f48034b = "key_frs_new_area_tab_sort_";

    /* renamed from: c  reason: collision with root package name */
    public static int f48035c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static final String f48036d = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);

    /* renamed from: e  reason: collision with root package name */
    public static final String f48037e = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static String a() {
        return f48034b + TbadkCoreApplication.getCurrentAccount();
    }

    public static String b() {
        return f48033a + TbadkCoreApplication.getCurrentAccount();
    }

    public static int c() {
        if (d.p()) {
            return 1;
        }
        if (d.q()) {
            return 503;
        }
        if (d.r()) {
            return h(e());
        }
        return 1;
    }

    public static int d() {
        return d.a.i0.r.d0.b.j().k(a(), f48035c);
    }

    public static String e() {
        return d.a.i0.r.d0.b.j().p(b(), f48036d);
    }

    public static void f(int i2) {
        d.a.i0.r.d0.b.j().v(a(), i2);
    }

    public static void g(String str) {
        if (f48036d.equals(str) || f48037e.equals(str)) {
            d.a.i0.r.d0.b.j().x(b(), str);
        }
    }

    public static int h(String str) {
        return (!f48036d.equals(str) && f48037e.equals(str)) ? 503 : 1;
    }
}
