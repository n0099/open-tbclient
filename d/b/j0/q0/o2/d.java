package d.b.j0.q0.o2;

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
import d.b.i0.r.q.r0;
import d.b.i0.r.s.a;
import d.b.j0.q0.f2.a.c;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class d implements d.b.j0.q0.n1.e.d {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f60252a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f60253b;

    /* renamed from: c  reason: collision with root package name */
    public l f60254c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.l3.d f60255d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.q0.f2.a.c f60256e;

    /* renamed from: f  reason: collision with root package name */
    public OvalActionButton f60257f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.v3.g f60258g;

    /* renamed from: h  reason: collision with root package name */
    public c.d f60259h = new a();
    public final View.OnClickListener i = new b();
    public final d.b.c.e.l.c<d.b.c.j.d.a> j = new c();

    /* loaded from: classes4.dex */
    public class a implements c.d {
        public a() {
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void a(boolean z, int i) {
            if (z && i == 502) {
                d.this.B(1);
            } else if (z) {
                d.this.B(0);
            } else if (i != 502) {
                d.this.B(-1);
            } else {
                d.this.n();
            }
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void b(boolean z) {
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!DialogLoginHelper.checkUpIsLogin(new r0(d.this.f60252a.getPageContext().getPageActivity(), "frs_fabu")) || !ViewHelper.checkUpIsLogin(d.this.f60252a.getPageContext().getPageActivity()) || d.this.f60255d.c() || d.this.k() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (d.this.f60254c != null) {
                d.this.f60254c.i();
            }
            if (d.this.f60252a.z2().G(502) == null || d.this.f60252a.z2().y() == null) {
                d.this.B(-1);
            } else {
                d.this.f60256e.i(d.this.f60252a.h(), d.this.f60252a.z2().y().f16322a);
            }
            d.this.j();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((c) aVar, str, i);
            if (aVar == null || !aVar.w()) {
                d.this.w();
                return;
            }
            d.this.f60257f.setImageDrawable(null);
            aVar.h(d.this.f60257f);
        }
    }

    /* renamed from: d.b.j0.q0.o2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1504d implements a.e {
        public C1504d(d dVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            if (aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f60263e;

        public e(BlockPopInfoData blockPopInfoData) {
            this.f60263e = blockPopInfoData;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            UrlManager.getInstance().dealOneLink(d.this.f60252a.getPageContext(), new String[]{this.f60263e.ahead_url});
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
        this.f60252a = frsFragment;
        this.f60253b = noPressedRelativeLayout;
        this.f60255d = new d.b.j0.l3.d(frsFragment.getPageContext());
        d.b.j0.q0.f2.a.c cVar = new d.b.j0.q0.f2.a.c(frsFragment.getPageContext());
        this.f60256e = cVar;
        cVar.j(this.f60259h);
        u(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        FrsViewData S;
        if (this.f60257f != null) {
            l();
            this.f60257f.setVisibility(z ? 0 : 8);
            if (!z || !TbadkCoreApplication.isLogin() || (S = this.f60252a.S()) == null || S.postTopic == null || S.getForum() == null || StringUtils.isNull(S.getForum().getId()) || StringUtils.isNull(S.postTopic.recom_title) || StringUtils.isNull(S.postTopic.recom_topic) || !d.b.j0.q0.p.a.d().c(S.getForum().getId(), S.postTopic.uniq_topicid.longValue())) {
                return;
            }
            z(this.f60257f, S);
        }
    }

    public final void B(int i) {
        if (this.f60258g == null) {
            d.b.j0.v3.g gVar = new d.b.j0.v3.g(this.f60252a.getPageContext(), this.f60253b, "frs");
            this.f60258g = gVar;
            gVar.F("2");
            ItemInfo itemInfo = this.f60252a.S().itemInfo;
            this.f60258g.E((itemInfo == null || itemInfo.id.intValue() <= 0 || d.b.c.e.p.k.isEmpty(itemInfo.name)) ? false : true);
        }
        this.f60258g.H(m());
        if (this.f60252a.S().getAnti() != null) {
            this.f60258g.B(this.f60252a.S().getAnti().getCanGoods());
        }
        ForumWriteData p2 = this.f60252a.p2();
        p2.setDefaultZone(i);
        this.f60258g.C(p2);
        this.f60258g.D(this.f60252a.S().itemInfo);
        this.f60258g.G(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        FrsFragment frsFragment = this.f60252a;
        if (frsFragment != null && frsFragment.S() != null) {
            this.f60258g.D(this.f60252a.S().itemInfo);
        }
        this.f60258g.J(false, null, this.f60257f);
        this.f60252a.D2().setAlpha(0);
        FrsFragment frsFragment2 = this.f60252a;
        if (frsFragment2 == null || frsFragment2.S() == null || this.f60252a.S().itemInfo == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f60252a.h()).param("fname", this.f60252a.i()).param("obj_param1", this.f60252a.S().itemInfo.name));
    }

    public void C() {
        OvalActionButton ovalActionButton = this.f60257f;
        if (ovalActionButton != null) {
            ovalActionButton.performClick();
        }
    }

    @Override // d.b.j0.q0.n1.e.d
    public boolean a() {
        return (this.f60255d.c() || k()) ? false : true;
    }

    public final void j() {
        StatisticItem statisticItem = new StatisticItem("c13604");
        FrsFragment frsFragment = this.f60252a;
        if (frsFragment != null) {
            d.b.i0.j0.c.b(frsFragment.getContext(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public boolean k() {
        FrsViewData S;
        FrsFragment frsFragment = this.f60252a;
        if (frsFragment == null || (S = frsFragment.S()) == null) {
            return false;
        }
        if (ViewHelper.checkUpIsLogin(this.f60252a.getPageContext().getPageActivity())) {
            AntiData anti = S.getAnti();
            return anti != null && y(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
        }
        return true;
    }

    public boolean l() {
        FrsViewData S;
        ActivityConfig activityConfig;
        FrsFragment frsFragment = this.f60252a;
        if (frsFragment != null && (S = frsFragment.S()) != null && (activityConfig = S.activityConfig) != null && activityConfig.type.intValue() == 2) {
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
        FrsViewData S;
        ActivityConfig activityConfig;
        FrsFragment frsFragment = this.f60252a;
        return (frsFragment == null || (S = frsFragment.S()) == null || (activityConfig = S.activityConfig) == null) ? "" : activityConfig.addthread_text;
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
        FrsFragment frsFragment = this.f60252a;
        if (frsFragment == null || frsFragment.S() == null || (forum = this.f60252a.S().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f60252a.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public boolean o() {
        d.b.j0.v3.g gVar = this.f60258g;
        if (gVar == null) {
            return false;
        }
        return gVar.o();
    }

    public boolean p() {
        d.b.j0.v3.g gVar = this.f60258g;
        if (gVar == null) {
            return false;
        }
        return gVar.o();
    }

    public final void q(String str) {
        d.b.c.e.l.d.h().m(str, 10, this.j, this.f60252a.getUniqueId());
    }

    public void r() {
        d.b.j0.v3.g gVar = this.f60258g;
        if (gVar != null) {
            gVar.u();
        }
        l lVar = this.f60254c;
        if (lVar != null) {
            lVar.i();
        }
    }

    public void s() {
        l lVar = this.f60254c;
        if (lVar != null) {
            lVar.i();
        }
    }

    public void t() {
    }

    public void u(int i) {
        d.b.j0.v3.g gVar = this.f60258g;
        if (gVar != null) {
            gVar.s(i);
        }
    }

    public boolean v() {
        d.b.j0.v3.g gVar = this.f60258g;
        if (gVar == null || !gVar.o()) {
            return false;
        }
        this.f60258g.n(true);
        return true;
    }

    public final void w() {
        this.f60257f.setImageResource(0);
    }

    public void x(OvalActionButton ovalActionButton) {
        if (ovalActionButton == null) {
            return;
        }
        this.f60257f = ovalActionButton;
        ovalActionButton.setOnClickListener(this.i);
        if (l()) {
            return;
        }
        w();
    }

    public final boolean y(int i, BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.f60252a.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i == 1 || i == 2) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f60252a.getPageContext().getPageActivity());
            aVar.setMessage(StringHelper.getFixedText(string, 50, true));
            aVar.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.f60252a.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new C1504d(this));
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                aVar.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(blockPopInfoData));
            }
            aVar.create(this.f60252a.getPageContext()).show();
            return true;
        }
        return false;
    }

    public void z(View view, FrsViewData frsViewData) {
        if (this.f60252a == null || frsViewData == null || frsViewData.getForum() == null || frsViewData.postTopic == null) {
            return;
        }
        if (this.f60254c == null) {
            this.f60254c = new l(this.f60252a.getActivity(), this);
        }
        this.f60254c.i();
        this.f60254c.j(view, frsViewData);
    }
}
