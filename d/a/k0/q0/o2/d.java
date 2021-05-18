package d.a.k0.q0.o2;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.j0.r.q.r0;
import d.a.j0.r.s.a;
import d.a.k0.q0.f2.a.c;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class d implements d.a.k0.q0.n1.e.d {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59080a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f59081b;

    /* renamed from: c  reason: collision with root package name */
    public l f59082c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.l3.d f59083d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.q0.f2.a.c f59084e;

    /* renamed from: f  reason: collision with root package name */
    public OvalActionButton f59085f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.v3.f f59086g;

    /* renamed from: h  reason: collision with root package name */
    public c.d f59087h = new a();

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f59088i = new b();
    public final d.a.c.e.l.c<d.a.c.j.d.a> j = new c();

    /* loaded from: classes4.dex */
    public class a implements c.d {
        public a() {
        }

        @Override // d.a.k0.q0.f2.a.c.d
        public void a(boolean z, int i2) {
            if (z && i2 == 502) {
                d.this.B(1);
            } else if (z) {
                d.this.B(0);
            } else if (i2 != 502) {
                d.this.B(-1);
            } else {
                d.this.n();
            }
        }

        @Override // d.a.k0.q0.f2.a.c.d
        public void b(boolean z) {
        }

        @Override // d.a.k0.q0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!DialogLoginHelper.checkUpIsLogin(new r0(d.this.f59080a.getPageContext().getPageActivity(), "frs_fabu")) || !ViewHelper.checkUpIsLogin(d.this.f59080a.getPageContext().getPageActivity()) || d.this.f59083d.c() || d.this.k() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (d.this.f59082c != null) {
                d.this.f59082c.i();
            }
            if (d.this.f59080a.y2().G(502) == null || d.this.f59080a.y2().y() == null) {
                d.this.B(-1);
            } else {
                d.this.f59084e.i(d.this.f59080a.h(), d.this.f59080a.y2().y().f15857a);
            }
            d.this.j();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((c) aVar, str, i2);
            if (aVar == null || !aVar.w()) {
                d.this.w();
                return;
            }
            d.this.f59085f.setImageDrawable(null);
            aVar.h(d.this.f59085f);
        }
    }

    /* renamed from: d.a.k0.q0.o2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1517d implements a.e {
        public C1517d(d dVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            if (aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f59092e;

        public e(BlockPopInfoData blockPopInfoData) {
            this.f59092e = blockPopInfoData;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            UrlManager.getInstance().dealOneLink(d.this.f59080a.getPageContext(), new String[]{this.f59092e.ahead_url});
            if (aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment == null || noPressedRelativeLayout == null) {
            return;
        }
        this.f59080a = frsFragment;
        this.f59081b = noPressedRelativeLayout;
        this.f59083d = new d.a.k0.l3.d(frsFragment.getPageContext());
        d.a.k0.q0.f2.a.c cVar = new d.a.k0.q0.f2.a.c(frsFragment.getPageContext());
        this.f59084e = cVar;
        cVar.j(this.f59087h);
        u(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        FrsViewData g0;
        if (this.f59085f != null) {
            l();
            this.f59085f.setVisibility(z ? 0 : 8);
            if (!z || !TbadkCoreApplication.isLogin() || (g0 = this.f59080a.g0()) == null || g0.postTopic == null || g0.getForum() == null || StringUtils.isNull(g0.getForum().getId()) || StringUtils.isNull(g0.postTopic.recom_title) || StringUtils.isNull(g0.postTopic.recom_topic) || !d.a.k0.q0.p.a.d().c(g0.getForum().getId(), g0.postTopic.uniq_topicid.longValue())) {
                return;
            }
            z(this.f59085f, g0);
        }
    }

    public final void B(int i2) {
        if (this.f59086g == null) {
            d.a.k0.v3.f fVar = new d.a.k0.v3.f(this.f59080a.getPageContext(), this.f59081b, "frs");
            this.f59086g = fVar;
            fVar.C("2");
            ItemInfo itemInfo = this.f59080a.g0().itemInfo;
            this.f59086g.B((itemInfo == null || itemInfo.id.intValue() <= 0 || d.a.c.e.p.k.isEmpty(itemInfo.name)) ? false : true);
        }
        this.f59086g.E(m());
        if (this.f59080a.g0().getAnti() != null) {
            this.f59086g.y(this.f59080a.g0().getAnti().getCanGoods());
        }
        ForumWriteData o2 = this.f59080a.o2();
        o2.setDefaultZone(i2);
        this.f59086g.z(o2);
        this.f59086g.A(this.f59080a.g0().itemInfo);
        this.f59086g.D(i2 == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        FrsFragment frsFragment = this.f59080a;
        if (frsFragment != null && frsFragment.g0() != null) {
            this.f59086g.A(this.f59080a.g0().itemInfo);
        }
        this.f59086g.G(false, null, this.f59085f);
        this.f59080a.C2().setAlpha(0);
        FrsFragment frsFragment2 = this.f59080a;
        if (frsFragment2 == null || frsFragment2.g0() == null || this.f59080a.g0().itemInfo == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f59080a.h()).param("fname", this.f59080a.g()).param("obj_param1", this.f59080a.g0().itemInfo.name));
    }

    public void C() {
        OvalActionButton ovalActionButton = this.f59085f;
        if (ovalActionButton != null) {
            ovalActionButton.performClick();
        }
    }

    @Override // d.a.k0.q0.n1.e.d
    public boolean a() {
        return (this.f59083d.c() || k()) ? false : true;
    }

    public final void j() {
        StatisticItem statisticItem = new StatisticItem("c13604");
        FrsFragment frsFragment = this.f59080a;
        if (frsFragment != null) {
            d.a.j0.j0.c.b(frsFragment.getContext(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public boolean k() {
        FrsViewData g0;
        FrsFragment frsFragment = this.f59080a;
        if (frsFragment == null || (g0 = frsFragment.g0()) == null) {
            return false;
        }
        if (ViewHelper.checkUpIsLogin(this.f59080a.getPageContext().getPageActivity())) {
            AntiData anti = g0.getAnti();
            return anti != null && y(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
        }
        return true;
    }

    public boolean l() {
        FrsViewData g0;
        ActivityConfig activityConfig;
        FrsFragment frsFragment = this.f59080a;
        if (frsFragment != null && (g0 = frsFragment.g0()) != null && (activityConfig = g0.activityConfig) != null && activityConfig.type.intValue() == 2) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
                q(activityConfig.night_addthread_icon);
                return true;
            } else if (!TextUtils.isEmpty(activityConfig.addthread_icon)) {
                q(activityConfig.addthread_icon);
                return true;
            }
        }
        return false;
    }

    public final String m() {
        FrsViewData g0;
        ActivityConfig activityConfig;
        FrsFragment frsFragment = this.f59080a;
        return (frsFragment == null || (g0 = frsFragment.g0()) == null || (activityConfig = g0.activityConfig) == null) ? "" : activityConfig.addthread_text;
    }

    public final void n() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        FrsFragment frsFragment = this.f59080a;
        if (frsFragment == null || frsFragment.g0() == null || (forum = this.f59080a.g0().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                str8 = skinType == 0 ? themeElement.pattern_image : null;
            } else {
                str8 = null;
                str9 = null;
                str10 = null;
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                str11 = themeElement2.light_color;
                str12 = themeElement2.dark_color;
                if (skinType == 1) {
                    str8 = themeElement2.pattern_image;
                }
            } else {
                str11 = null;
                str12 = null;
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                String str13 = themeElement3.light_color;
                String str14 = themeElement3.dark_color;
                if (skinType == 4) {
                    str = themeElement3.pattern_image;
                    str6 = str13;
                } else {
                    str6 = str13;
                    str = str8;
                }
                str2 = str9;
                str3 = str10;
                str7 = str14;
            } else {
                str6 = null;
                str7 = null;
                str = str8;
                str2 = str9;
                str3 = str10;
            }
            str4 = str11;
            str5 = str12;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f59080a.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public boolean o() {
        d.a.k0.v3.f fVar = this.f59086g;
        if (fVar == null) {
            return false;
        }
        return fVar.l();
    }

    public boolean p() {
        d.a.k0.v3.f fVar = this.f59086g;
        if (fVar == null) {
            return false;
        }
        return fVar.l();
    }

    public final void q(String str) {
        d.a.c.e.l.d.h().m(str, 10, this.j, this.f59080a.getUniqueId());
    }

    public void r() {
        d.a.k0.v3.f fVar = this.f59086g;
        if (fVar != null) {
            fVar.r();
        }
        l lVar = this.f59082c;
        if (lVar != null) {
            lVar.i();
        }
    }

    public void s() {
        l lVar = this.f59082c;
        if (lVar != null) {
            lVar.i();
        }
    }

    public void t() {
    }

    public void u(int i2) {
        d.a.k0.v3.f fVar = this.f59086g;
        if (fVar != null) {
            fVar.p(i2);
        }
    }

    public boolean v() {
        d.a.k0.v3.f fVar = this.f59086g;
        if (fVar == null || !fVar.l()) {
            return false;
        }
        this.f59086g.k(true);
        return true;
    }

    public final void w() {
        this.f59085f.setImageResource(0);
    }

    public void x(OvalActionButton ovalActionButton) {
        if (ovalActionButton == null) {
            return;
        }
        this.f59085f = ovalActionButton;
        ovalActionButton.setOnClickListener(this.f59088i);
        if (l()) {
            return;
        }
        w();
    }

    public final boolean y(int i2, BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.f59080a.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i2 == 1 || i2 == 2) {
            d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f59080a.getPageContext().getPageActivity());
            aVar.setMessage(StringHelper.getFixedText(string, 50, true));
            aVar.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.f59080a.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new C1517d(this));
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                aVar.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(blockPopInfoData));
            }
            aVar.create(this.f59080a.getPageContext()).show();
            return true;
        }
        return false;
    }

    public void z(View view, FrsViewData frsViewData) {
        if (this.f59080a == null || frsViewData == null || frsViewData.getForum() == null || frsViewData.postTopic == null) {
            return;
        }
        if (this.f59082c == null) {
            this.f59082c = new l(this.f59080a.getActivity(), this);
        }
        this.f59082c.i();
        this.f59082c.j(view, frsViewData);
    }
}
