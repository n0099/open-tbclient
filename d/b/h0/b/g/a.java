package d.b.h0.b.g;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.h0.b.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f50143a = "key_user_last_access_tab_";

    /* renamed from: b  reason: collision with root package name */
    public static String f50144b = "key_frs_new_area_tab_sort_";

    /* renamed from: c  reason: collision with root package name */
    public static int f50145c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static final String f50146d = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);

    /* renamed from: e  reason: collision with root package name */
    public static final String f50147e = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);

    public static String a() {
        return f50144b + TbadkCoreApplication.getCurrentAccount();
    }

    public static String b() {
        return f50143a + TbadkCoreApplication.getCurrentAccount();
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
        return d.b.h0.r.d0.b.j().k(a(), f50145c);
    }

    public static String e() {
        return d.b.h0.r.d0.b.j().p(b(), f50146d);
    }

    public static void f(int i) {
        d.b.h0.r.d0.b.j().v(a(), i);
    }

    public static void g(String str) {
        if (f50146d.equals(str) || f50147e.equals(str)) {
            d.b.h0.r.d0.b.j().x(b(), str);
        }
    }

    public static int h(String str) {
        return (!f50146d.equals(str) && f50147e.equals(str)) ? 503 : 1;
    }
}
