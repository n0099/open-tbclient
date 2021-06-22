package d.a.n0.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import d.a.n0.b.f.f;
import d.a.n0.b.f.g;
import d.a.n0.b.f.h;
import d.a.n0.b.f.j;
import d.a.n0.b.f.k;
import d.a.n0.b.f.m;
import d.a.n0.b.f.n;
import d.a.n0.b.f.o;
import d.a.n0.b.f.p;
import d.a.n0.b.f.q;
import d.a.n0.b.f.r;
import d.a.n0.b.f.s;
import d.a.n0.b.f.u;
import java.util.Map;
@ModifyClass
/* loaded from: classes3.dex */
public class d {
    public static boolean A() {
        return d(n.f52643c, "12_3_pb_outer_item_a");
    }

    @Modify(description = "是否命中PB页Banner位小熊广告sdk小流量abtest")
    public static boolean B() {
        return Build.VERSION.SDK_INT >= 21 && j("11_9_pb_bear_a");
    }

    @Modify(description = "是否命中首页推荐小熊广告sdk小流量abtest")
    public static boolean C() {
        return Build.VERSION.SDK_INT >= 21 && j("12_5_personalize_bear_a");
    }

    @Modify(description = "是否命中大图页小熊广告sdk小流量abtest")
    public static boolean D() {
        return Build.VERSION.SDK_INT >= 21 && j("12_2_picpage_bear_a");
    }

    @Modify(description = "吧推荐卡片是否显示hottext字段")
    public static boolean E() {
        return d(q.f52652c, "11_9_discover_hot_card_hot_text");
    }

    @Modify(description = "吧推荐卡片是否显示slogan字段")
    public static boolean F() {
        return d(q.f52652c, "11_9_discover_hot_card_slogan");
    }

    public static boolean G() {
        return d(d.a.n0.b.f.d.f52616c, "12_5_emoji_b");
    }

    @Modify(description = "isSearchLoginTestA")
    public static boolean H() {
        return d(r.f52655c, "12_3_search_login_a");
    }

    @Modify(description = "是否命中发贴显示标题小流量abtest")
    public static boolean I() {
        return j("11_9_post_thread_title_out_a");
    }

    public static boolean J() {
        return d(s.f52658c, "12_3_staticopt_a");
    }

    public static boolean K() {
        return d(u.f52664c, "12_3_video_release_a");
    }

    public static boolean L() {
        return K() || O();
    }

    public static boolean M() {
        return d(u.f52664c, "12_3_video_release_b");
    }

    public static boolean N() {
        return M() || P();
    }

    public static boolean O() {
        return d(u.f52664c, "12_3_video_release_c");
    }

    public static boolean P() {
        return d(u.f52664c, "12_3_video_release_d");
    }

    public static boolean Q() {
        return d(u.f52664c, "12_3_video_release_e");
    }

    @Modify(description = "是否命中视频号自动播放小流量abtest")
    public static boolean R() {
        return j("12_5_zp_1");
    }

    public static boolean S() {
        return true;
    }

    @Modify(description = "是否需要显示frs引导弹窗")
    public static boolean T() {
        return d(f.f52622c, "11_9_frs_page_guide_a");
    }

    @Modify(description = "是否需要显示吧推荐卡片")
    public static boolean U() {
        return F() || E();
    }

    @Modify(description = "是否展示新UI")
    public static boolean V() {
        return s();
    }

    public static boolean W() {
        return false;
    }

    public static boolean a() {
        return d(p.f52649c, "12_4_profile_a");
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
        if (eVar != null && !TextUtils.isEmpty(eVar.f52609a)) {
            for (String str : strArr) {
                if (eVar.f52609a.equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean f() {
        return d(d.a.n0.b.f.b.f52610c, "11_9_backuser_a");
    }

    @Modify(description = "是否命中12.0b UI通栏小流量")
    public static boolean g() {
        return false;
    }

    @Modify(description = "关注是否使用新样式")
    public static boolean h() {
        return d(d.a.n0.b.f.c.f52613c, "11_10_user_like_tab_a") || d(d.a.n0.b.f.c.f52613c, "11_10_user_like_tab_b");
    }

    @Modify(description = "是否命中PB、FRS和大图页命中小熊广告去重策略ABTest")
    public static boolean i() {
        return Build.VERSION.SDK_INT >= 21 && j("12_4_bear_duplicate_removal_a");
    }

    public static boolean j(String str) {
        e b2 = c.d().b(str);
        return (b2 == null || TextUtils.isEmpty(b2.f52609a) || !b2.f52609a.equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean k() {
        return d(d.a.n0.b.f.e.f52619c, "12_4_launch_login_a");
    }

    public static boolean l() {
        return d(d.a.n0.b.f.e.f52619c, "12_4_launch_login_b");
    }

    @Modify(description = "是否命中frs页小熊广告sdk小流量abtest")
    public static boolean m() {
        return Build.VERSION.SDK_INT >= 21 && j("12_2_frs_bear_a");
    }

    public static boolean n() {
        return d(g.f52625c, "12_2_frs_default_sort_a");
    }

    public static boolean o() {
        return p() || q() || r();
    }

    public static boolean p() {
        return d(h.f52628c, "12_2_frs_default_tab_a");
    }

    public static boolean q() {
        return d(h.f52628c, "12_2_frs_default_tab_b");
    }

    public static boolean r() {
        return d(h.f52628c, "12_2_frs_default_tab_c");
    }

    public static boolean s() {
        return true;
    }

    public static boolean t() {
        return d(j.f52634c, "12_4_promote_login_a");
    }

    public static boolean u() {
        return d(k.f52637c, "11_8_hot_b");
    }

    public static boolean v() {
        return d(m.f52640c, "12_2_pb_picpage_a");
    }

    public static boolean w() {
        return d(m.f52640c, "12_2_pb_picpage_b");
    }

    @Modify(description = "pb操作区, 策略a, 出右上角点点点，弹框网格")
    public static boolean x() {
        return d(o.f52646c, "12_4_pb_a");
    }

    @Modify(description = "pb操作区, 策略b, 出右上角点点点，强制出回复,弹框网格,发帖时间下移")
    public static boolean y() {
        return d(o.f52646c, "12_4_pb_b");
    }

    @Modify(description = "pb操作区, 策略c, 整个操作区左移，回复修改")
    public static boolean z() {
        return d(o.f52646c, "12_4_pb_c");
    }
}
