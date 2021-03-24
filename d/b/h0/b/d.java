package d.b.h0.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import d.b.h0.b.f.f;
import d.b.h0.b.f.g;
import d.b.h0.b.f.i;
import d.b.h0.b.f.j;
import d.b.h0.b.f.l;
import d.b.h0.b.f.m;
import d.b.h0.b.f.n;
import d.b.h0.b.f.o;
import d.b.h0.b.f.p;
import d.b.h0.b.f.q;
import d.b.h0.b.f.r;
import d.b.h0.b.f.t;
import java.util.Map;
@ModifyClass
/* loaded from: classes3.dex */
public class d {
    @Modify(description = "是否命中PB页Banner位小熊广告sdk小流量abtest")
    public static boolean A() {
        return Build.VERSION.SDK_INT >= 21 && i("11_9_pb_bear_a");
    }

    @Modify(description = "是否命中大图页小熊广告sdk小流量abtest")
    public static boolean B() {
        return Build.VERSION.SDK_INT >= 21 && i("12_2_picpage_bear_a");
    }

    @Modify(description = "吧推荐卡片是否显示hottext字段")
    public static boolean C() {
        return d(p.f49734c, "11_9_discover_hot_card_hot_text");
    }

    @Modify(description = "吧推荐卡片是否显示slogan字段")
    public static boolean D() {
        return d(p.f49734c, "11_9_discover_hot_card_slogan");
    }

    @Modify(description = "isSearchLoginTestA")
    public static boolean E() {
        return d(q.f49737c, "12_3_search_login_a");
    }

    @Modify(description = "是否命中发贴显示标题小流量abtest")
    public static boolean F() {
        return i("11_9_post_thread_title_out_a");
    }

    public static boolean G() {
        return d(r.f49740c, "12_3_staticopt_a");
    }

    public static boolean H() {
        return d(t.f49746c, "12_3_video_release_a");
    }

    public static boolean I() {
        return H() || L();
    }

    public static boolean J() {
        return d(t.f49746c, "12_3_video_release_b");
    }

    public static boolean K() {
        return J() || M();
    }

    public static boolean L() {
        return d(t.f49746c, "12_3_video_release_c");
    }

    public static boolean M() {
        return d(t.f49746c, "12_3_video_release_d");
    }

    public static boolean N() {
        return d(t.f49746c, "12_3_video_release_e");
    }

    public static boolean O() {
        return true;
    }

    @Modify(description = "是否需要显示frs引导弹窗")
    public static boolean P() {
        return d(d.b.h0.b.f.e.f49704c, "11_9_frs_page_guide_a");
    }

    @Modify(description = "是否需要显示吧推荐卡片")
    public static boolean Q() {
        return D() || C();
    }

    @Modify(description = "是否展示新UI")
    public static boolean R() {
        return r();
    }

    public static boolean S() {
        return false;
    }

    public static boolean a() {
        return d(o.f49731c, "12_4_profile_a");
    }

    public static e b(BdUniqueId bdUniqueId) {
        return c.d().f(bdUniqueId);
    }

    public static Map<BdUniqueId, e> c() {
        return c.d().g();
    }

    public static boolean d(BdUniqueId bdUniqueId, String... strArr) {
        return e(b(bdUniqueId), strArr);
    }

    public static boolean e(e eVar, String... strArr) {
        if (eVar != null && !TextUtils.isEmpty(eVar.f49694a)) {
            for (String str : strArr) {
                if (eVar.f49694a.equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean f() {
        return d(d.b.h0.b.f.b.f49695c, "11_9_backuser_a");
    }

    @Modify(description = "是否命中12.0b UI通栏小流量")
    public static boolean g() {
        return false;
    }

    @Modify(description = "关注是否使用新样式")
    public static boolean h() {
        return d(d.b.h0.b.f.c.f49698c, "11_10_user_like_tab_a") || d(d.b.h0.b.f.c.f49698c, "11_10_user_like_tab_b");
    }

    public static boolean i(String str) {
        e b2 = c.d().b(str);
        return (b2 == null || TextUtils.isEmpty(b2.f49694a) || !b2.f49694a.equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean j() {
        return d(d.b.h0.b.f.d.f49701c, "12_4_launch_login_a");
    }

    public static boolean k() {
        return d(d.b.h0.b.f.d.f49701c, "12_4_launch_login_b");
    }

    @Modify(description = "是否命中frs页小熊广告sdk小流量abtest")
    public static boolean l() {
        return Build.VERSION.SDK_INT >= 21 && i("12_2_frs_bear_a");
    }

    public static boolean m() {
        return d(f.f49707c, "12_2_frs_default_sort_a");
    }

    public static boolean n() {
        return o() || p() || q();
    }

    public static boolean o() {
        return d(g.f49710c, "12_2_frs_default_tab_a");
    }

    public static boolean p() {
        return d(g.f49710c, "12_2_frs_default_tab_b");
    }

    public static boolean q() {
        return d(g.f49710c, "12_2_frs_default_tab_c");
    }

    public static boolean r() {
        return true;
    }

    public static boolean s() {
        return d(i.f49716c, "12_4_promote_login_a");
    }

    public static boolean t() {
        return d(j.f49719c, "11_8_hot_b");
    }

    public static boolean u() {
        return d(l.f49722c, "12_2_pb_picpage_a");
    }

    public static boolean v() {
        return d(l.f49722c, "12_2_pb_picpage_b");
    }

    @Modify(description = "pb操作区, 策略a, 出右上角点点点，弹框网格")
    public static boolean w() {
        return d(n.f49728c, "12_4_pb_a");
    }

    @Modify(description = "pb操作区, 策略b, 出右上角点点点，强制出回复,弹框网格,发帖时间下移")
    public static boolean x() {
        return d(n.f49728c, "12_4_pb_b");
    }

    @Modify(description = "pb操作区, 策略c, 整个操作区左移，回复修改")
    public static boolean y() {
        return d(n.f49728c, "12_4_pb_c");
    }

    public static boolean z() {
        return d(m.f49725c, "12_3_pb_outer_item_a");
    }
}
