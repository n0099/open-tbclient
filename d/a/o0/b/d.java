package d.a.o0.b;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.b.f.f;
import d.a.o0.b.f.g;
import d.a.o0.b.f.h;
import d.a.o0.b.f.i;
import d.a.o0.b.f.k;
import d.a.o0.b.f.l;
import d.a.o0.b.f.n;
import d.a.o0.b.f.o;
import d.a.o0.b.f.p;
import d.a.o0.b.f.q;
import d.a.o0.b.f.r;
import d.a.o0.b.f.s;
import d.a.o0.b.f.t;
import d.a.o0.b.f.v;
import java.util.Map;
@ModifyClass
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-799808147, "Ld/a/o0/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-799808147, "Ld/a/o0/b/d;");
        }
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d(i.f51469c, "12_2_frs_default_tab_b") : invokeV.booleanValue;
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d(i.f51469c, "12_2_frs_default_tab_c") : invokeV.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d(k.f51475c, "12_4_promote_login_a") : invokeV.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? d(l.f51478c, "11_8_hot_b") : invokeV.booleanValue;
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d(n.f51481c, "12_2_pb_picpage_a") : invokeV.booleanValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d(n.f51481c, "12_2_pb_picpage_b") : invokeV.booleanValue;
    }

    @Modify(description = "pb操作区, 策略a, 出右上角点点点，弹框网格")
    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d(p.f51487c, "12_4_pb_a") : invokeV.booleanValue;
    }

    @Modify(description = "pb操作区, 策略b, 出右上角点点点，强制出回复,弹框网格,发帖时间下移")
    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d(p.f51487c, "12_4_pb_b") : invokeV.booleanValue;
    }

    @Modify(description = "pb操作区, 策略c, 整个操作区左移，回复修改")
    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? d(p.f51487c, "12_4_pb_c") : invokeV.booleanValue;
    }

    public static boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d(o.f51484c, "12_3_pb_outer_item_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中PB页Banner位小熊广告sdk小流量abtest")
    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.VERSION.SDK_INT >= 21 && j("11_9_pb_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中首页推荐小熊广告sdk小流量abtest")
    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.VERSION.SDK_INT >= 21 && j("12_5_personalize_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中大图页小熊广告sdk小流量abtest")
    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? Build.VERSION.SDK_INT >= 21 && j("12_2_picpage_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示hottext字段")
    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? d(r.f51493c, "11_9_discover_hot_card_hot_text") : invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示slogan字段")
    public static boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? d(r.f51493c, "11_9_discover_hot_card_slogan") : invokeV.booleanValue;
    }

    public static boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? d(d.a.o0.b.f.d.f51454c, "12_5_emoji_b") : invokeV.booleanValue;
    }

    @Modify(description = "isSearchLoginTestA")
    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? d(s.f51496c, "12_3_search_login_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中发贴显示标题小流量abtest")
    public static boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? j("11_9_post_thread_title_out_a") : invokeV.booleanValue;
    }

    public static boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? d(t.f51499c, "12_3_staticopt_a") : invokeV.booleanValue;
    }

    public static boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? d(v.f51505c, "12_3_video_release_a") : invokeV.booleanValue;
    }

    public static boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? U() || Y() : invokeV.booleanValue;
    }

    public static boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? d(v.f51505c, "12_3_video_release_b") : invokeV.booleanValue;
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? W() || Z() : invokeV.booleanValue;
    }

    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? d(v.f51505c, "12_3_video_release_c") : invokeV.booleanValue;
    }

    public static boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? d(v.f51505c, "12_3_video_release_d") : invokeV.booleanValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? d(q.f51490c, "12_4_profile_a") : invokeV.booleanValue;
    }

    public static boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? d(v.f51505c, "12_3_video_release_e") : invokeV.booleanValue;
    }

    public static e b(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, bdUniqueId)) == null) ? c.d().f(bdUniqueId) : (e) invokeL.objValue;
    }

    @Modify(description = "是否命中视频号自动播放小流量abtest")
    public static boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? j("12_5_zp_1") : invokeV.booleanValue;
    }

    public static Map<BdUniqueId, e> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? c.d().g() : (Map) invokeV.objValue;
    }

    public static boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean d(BdUniqueId bdUniqueId, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, bdUniqueId, strArr)) == null) ? e(b(bdUniqueId), strArr) : invokeLL.booleanValue;
    }

    @Modify(description = "是否需要显示frs引导弹窗")
    public static boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? d(g.f51463c, "11_9_frs_page_guide_a") : invokeV.booleanValue;
    }

    public static boolean e(e eVar, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, eVar, strArr)) == null) {
            if (eVar != null && !TextUtils.isEmpty(eVar.f51447a)) {
                for (String str : strArr) {
                    if (eVar.f51447a.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Modify(description = "是否需要显示吧推荐卡片")
    public static boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? P() || O() : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? d(d.a.o0.b.f.b.f51448c, "11_9_backuser_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否展示新UI")
    public static boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? C() : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.0b UI通栏小流量")
    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "关注是否使用新样式")
    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? d(d.a.o0.b.f.c.f51451c, "11_10_user_like_tab_a") || d(d.a.o0.b.f.c.f51451c, "11_10_user_like_tab_b") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中PB、FRS和大图页命中小熊广告去重策略ABTest")
    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? Build.VERSION.SDK_INT >= 21 && j("12_4_bear_duplicate_removal_a") : invokeV.booleanValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            e b2 = c.d().b(str);
            return (b2 == null || TextUtils.isEmpty(b2.f51447a) || !b2.f51447a.equalsIgnoreCase(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Modify(description = "是否命中12.7实验一卡片正文字号放大")
    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_text") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.7实验二卡片下方互动区icon弱化")
    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_icon") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.7实验一用户头像及名称字号缩小")
    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_name") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.7实验四多图展示实验(1)")
    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_picture_1") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.7实验四多图展示实验(2)")
    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_picture_2") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.7实验四多图展示实验(3)")
    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_picture_3") : invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? n() || o() : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.7实验五单图实验")
    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_1") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.7实验三、首页标题加粗换行")
    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_title") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.7实验三、首页标题加粗不换行")
    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? d(d.a.o0.b.f.e.f51457c, "12_7_shouye_title_1") : invokeV.booleanValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) ? d(f.f51460c, "12_4_launch_login_a") : invokeV.booleanValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? d(f.f51460c, "12_4_launch_login_b") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中frs页小熊广告sdk小流量abtest")
    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) ? Build.VERSION.SDK_INT >= 21 && j("12_2_frs_bear_a") : invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) ? d(h.f51466c, "12_2_frs_default_sort_a") : invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? z() || A() || B() : invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) ? d(i.f51469c, "12_2_frs_default_tab_a") : invokeV.booleanValue;
    }
}
