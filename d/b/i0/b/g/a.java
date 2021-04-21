package d.b.i0.b.g;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.i0.b.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f50479a = "key_user_last_access_tab_";

    /* renamed from: b  reason: collision with root package name */
    public static String f50480b = "key_frs_new_area_tab_sort_";

    /* renamed from: c  reason: collision with root package name */
    public static int f50481c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static final String f50482d = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);

    /* renamed from: e  reason: collision with root package name */
    public static final String f50483e = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static String a() {
        return f50480b + TbadkCoreApplication.getCurrentAccount();
    }

    public static String b() {
        return f50479a + TbadkCoreApplication.getCurrentAccount();
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
        return d.b.i0.r.d0.b.j().k(a(), f50481c);
    }

    public static String e() {
        return d.b.i0.r.d0.b.j().p(b(), f50482d);
    }

    public static void f(int i) {
        d.b.i0.r.d0.b.j().v(a(), i);
    }

    public static void g(String str) {
        if (f50482d.equals(str) || f50483e.equals(str)) {
            d.b.i0.r.d0.b.j().x(b(), str);
        }
    }

    public static int h(String str) {
        return (!f50482d.equals(str) && f50483e.equals(str)) ? 503 : 1;
    }
}
