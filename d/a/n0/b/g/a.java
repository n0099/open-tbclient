package d.a.n0.b.g;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.n0.b.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f52667a = "key_user_last_access_tab_";

    /* renamed from: b  reason: collision with root package name */
    public static String f52668b = "key_frs_new_area_tab_sort_";

    /* renamed from: c  reason: collision with root package name */
    public static int f52669c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static final String f52670d = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);

    /* renamed from: e  reason: collision with root package name */
    public static final String f52671e = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static String a() {
        return f52668b + TbadkCoreApplication.getCurrentAccount();
    }

    public static String b() {
        return f52667a + TbadkCoreApplication.getCurrentAccount();
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
        return d.a.n0.r.d0.b.j().k(a(), f52669c);
    }

    public static String e() {
        return d.a.n0.r.d0.b.j().p(b(), f52670d);
    }

    public static void f(int i2) {
        d.a.n0.r.d0.b.j().v(a(), i2);
    }

    public static void g(String str) {
        if (f52670d.equals(str) || f52671e.equals(str)) {
            d.a.n0.r.d0.b.j().x(b(), str);
        }
    }

    public static int h(String str) {
        return (!f52670d.equals(str) && f52671e.equals(str)) ? 503 : 1;
    }
}
