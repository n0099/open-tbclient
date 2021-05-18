package d.a.j0.b.g;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.j0.b.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f48861a = "key_user_last_access_tab_";

    /* renamed from: b  reason: collision with root package name */
    public static String f48862b = "key_frs_new_area_tab_sort_";

    /* renamed from: c  reason: collision with root package name */
    public static int f48863c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static final String f48864d = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);

    /* renamed from: e  reason: collision with root package name */
    public static final String f48865e = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static String a() {
        return f48862b + TbadkCoreApplication.getCurrentAccount();
    }

    public static String b() {
        return f48861a + TbadkCoreApplication.getCurrentAccount();
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
        return d.a.j0.r.d0.b.j().k(a(), f48863c);
    }

    public static String e() {
        return d.a.j0.r.d0.b.j().p(b(), f48864d);
    }

    public static void f(int i2) {
        d.a.j0.r.d0.b.j().v(a(), i2);
    }

    public static void g(String str) {
        if (f48864d.equals(str) || f48865e.equals(str)) {
            d.a.j0.r.d0.b.j().x(b(), str);
        }
    }

    public static int h(String str) {
        return (!f48864d.equals(str) && f48865e.equals(str)) ? 503 : 1;
    }
}
