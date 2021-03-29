package d.b.h0.b.g;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.h0.b.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f49750a = "key_user_last_access_tab_";

    /* renamed from: b  reason: collision with root package name */
    public static String f49751b = "key_frs_new_area_tab_sort_";

    /* renamed from: c  reason: collision with root package name */
    public static int f49752c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static final String f49753d = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);

    /* renamed from: e  reason: collision with root package name */
    public static final String f49754e = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static String a() {
        return f49751b + TbadkCoreApplication.getCurrentAccount();
    }

    public static String b() {
        return f49750a + TbadkCoreApplication.getCurrentAccount();
    }

    public static int c() {
        if (d.o()) {
            return 1;
        }
        if (d.p()) {
            return 503;
        }
        if (d.q()) {
            return h(e());
        }
        return 1;
    }

    public static int d() {
        return d.b.h0.r.d0.b.i().j(a(), f49752c);
    }

    public static String e() {
        return d.b.h0.r.d0.b.i().o(b(), f49753d);
    }

    public static void f(int i) {
        d.b.h0.r.d0.b.i().u(a(), i);
    }

    public static void g(String str) {
        if (f49753d.equals(str) || f49754e.equals(str)) {
            d.b.h0.r.d0.b.i().w(b(), str);
        }
    }

    public static int h(String str) {
        return (!f49753d.equals(str) && f49754e.equals(str)) ? 503 : 1;
    }
}
