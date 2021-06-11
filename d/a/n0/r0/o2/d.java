package d.a.n0.r0.o2;

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
import d.a.m0.r.q.r0;
import d.a.m0.r.s.a;
import d.a.n0.r0.f2.a.c;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class d implements d.a.n0.r0.n1.e.d {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f62912a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f62913b;

    /* renamed from: c  reason: collision with root package name */
    public l f62914c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.m3.d f62915d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r0.f2.a.c f62916e;

    /* renamed from: f  reason: collision with root package name */
    public OvalActionButton f62917f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.w3.f f62918g;

    /* renamed from: h  reason: collision with root package name */
    public c.d f62919h = new a();

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f62920i = new b();
    public final d.a.c.e.l.c<d.a.c.k.d.a> j = new c();

    /* loaded from: classes4.dex */
    public class a implements c.d {
        public a() {
        }

        @Override // d.a.n0.r0.f2.a.c.d
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

        @Override // d.a.n0.r0.f2.a.c.d
        public void b(boolean z) {
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!DialogLoginHelper.checkUpIsLogin(new r0(d.this.f62912a.getPageContext().getPageActivity(), "frs_fabu")) || !ViewHelper.checkUpIsLogin(d.this.f62912a.getPageContext().getPageActivity()) || d.this.f62915d.c() || d.this.k() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (d.this.f62914c != null) {
                d.this.f62914c.i();
            }
            if (d.this.f62912a.B2().G(502) == null || d.this.f62912a.B2().y() == null) {
                d.this.B(-1);
            } else {
                d.this.f62916e.h(d.this.f62912a.i(), d.this.f62912a.B2().y().f15822a);
            }
            d.this.j();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((c) aVar, str, i2);
            if (aVar == null || !aVar.w()) {
                d.this.w();
                return;
            }
            d.this.f62917f.setImageDrawable(null);
            aVar.h(d.this.f62917f);
        }
    }

    /* renamed from: d.a.n0.r0.o2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1586d implements a.e {
        public C1586d(d dVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f62924e;

        public e(BlockPopInfoData blockPopInfoData) {
            this.f62924e = blockPopInfoData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            UrlManager.getInstance().dealOneLink(d.this.f62912a.getPageContext(), new String[]{this.f62924e.ahead_url});
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
        this.f62912a = frsFragment;
        this.f62913b = noPressedRelativeLayout;
        this.f62915d = new d.a.n0.m3.d(frsFragment.getPageContext());
        d.a.n0.r0.f2.a.c cVar = new d.a.n0.r0.f2.a.c(frsFragment.getPageContext());
        this.f62916e = cVar;
        cVar.i(this.f62919h);
        u(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        FrsViewData j0;
        if (this.f62917f != null) {
            l();
            this.f62917f.setVisibility(z ? 0 : 8);
            if (!z || !TbadkCoreApplication.isLogin() || (j0 = this.f62912a.j0()) == null || j0.postTopic == null || j0.getForum() == null || StringUtils.isNull(j0.getForum().getId()) || StringUtils.isNull(j0.postTopic.recom_title) || StringUtils.isNull(j0.postTopic.recom_topic) || !d.a.n0.r0.p.a.d().c(j0.getForum().getId(), j0.postTopic.uniq_topicid.longValue())) {
                return;
            }
            z(this.f62917f, j0);
        }
    }

    public final void B(int i2) {
        if (this.f62918g == null) {
            d.a.n0.w3.f fVar = new d.a.n0.w3.f(this.f62912a.getPageContext(), this.f62913b, "frs");
            this.f62918g = fVar;
            fVar.C("2");
            ItemInfo itemInfo = this.f62912a.j0().itemInfo;
            this.f62918g.B((itemInfo == null || itemInfo.id.intValue() <= 0 || d.a.c.e.p.k.isEmpty(itemInfo.name)) ? false : true);
        }
        this.f62918g.E(m());
        if (this.f62912a.j0().getAnti() != null) {
            this.f62918g.y(this.f62912a.j0().getAnti().getCanGoods());
        }
        ForumWriteData r2 = this.f62912a.r2();
        r2.setDefaultZone(i2);
        this.f62918g.z(r2);
        this.f62918g.A(this.f62912a.j0().itemInfo);
        this.f62918g.D(i2 == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        FrsFragment frsFragment = this.f62912a;
        if (frsFragment != null && frsFragment.j0() != null) {
            this.f62918g.A(this.f62912a.j0().itemInfo);
        }
        this.f62918g.G(false, null, this.f62917f);
        this.f62912a.F2().setAlpha(0);
        FrsFragment frsFragment2 = this.f62912a;
        if (frsFragment2 == null || frsFragment2.j0() == null || this.f62912a.j0().itemInfo == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f62912a.i()).param("fname", this.f62912a.h()).param("obj_param1", this.f62912a.j0().itemInfo.name));
    }

    public void C() {
        OvalActionButton ovalActionButton = this.f62917f;
        if (ovalActionButton != null) {
            ovalActionButton.performClick();
        }
    }

    @Override // d.a.n0.r0.n1.e.d
    public boolean a() {
        return (this.f62915d.c() || k()) ? false : true;
    }

    public final void j() {
        StatisticItem statisticItem = new StatisticItem("c13604");
        FrsFragment frsFragment = this.f62912a;
        if (frsFragment != null) {
            d.a.m0.j0.c.b(frsFragment.getContext(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public boolean k() {
        FrsViewData j0;
        FrsFragment frsFragment = this.f62912a;
        if (frsFragment == null || (j0 = frsFragment.j0()) == null) {
            return false;
        }
        if (ViewHelper.checkUpIsLogin(this.f62912a.getPageContext().getPageActivity())) {
            AntiData anti = j0.getAnti();
            return anti != null && y(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
        }
        return true;
    }

    public boolean l() {
        FrsViewData j0;
        ActivityConfig activityConfig;
        FrsFragment frsFragment = this.f62912a;
        if (frsFragment != null && (j0 = frsFragment.j0()) != null && (activityConfig = j0.activityConfig) != null && activityConfig.type.intValue() == 2) {
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
        FrsViewData j0;
        ActivityConfig activityConfig;
        FrsFragment frsFragment = this.f62912a;
        return (frsFragment == null || (j0 = frsFragment.j0()) == null || (activityConfig = j0.activityConfig) == null) ? "" : activityConfig.addthread_text;
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
        FrsFragment frsFragment = this.f62912a;
        if (frsFragment == null || frsFragment.j0() == null || (forum = this.f62912a.j0().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f62912a.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public boolean o() {
        d.a.n0.w3.f fVar = this.f62918g;
        if (fVar == null) {
            return false;
        }
        return fVar.l();
    }

    public boolean p() {
        d.a.n0.w3.f fVar = this.f62918g;
        if (fVar == null) {
            return false;
        }
        return fVar.l();
    }

    public final void q(String str) {
        d.a.c.e.l.d.h().m(str, 10, this.j, this.f62912a.getUniqueId());
    }

    public void r() {
        d.a.n0.w3.f fVar = this.f62918g;
        if (fVar != null) {
            fVar.r();
        }
        l lVar = this.f62914c;
        if (lVar != null) {
            lVar.i();
        }
    }

    public void s() {
        l lVar = this.f62914c;
        if (lVar != null) {
            lVar.i();
        }
    }

    public void t() {
    }

    public void u(int i2) {
        d.a.n0.w3.f fVar = this.f62918g;
        if (fVar != null) {
            fVar.p(i2);
        }
    }

    public boolean v() {
        d.a.n0.w3.f fVar = this.f62918g;
        if (fVar == null || !fVar.l()) {
            return false;
        }
        this.f62918g.k(true);
        return true;
    }

    public final void w() {
        this.f62917f.setImageResource(0);
    }

    public void x(OvalActionButton ovalActionButton) {
        if (ovalActionButton == null) {
            return;
        }
        this.f62917f = ovalActionButton;
        ovalActionButton.setOnClickListener(this.f62920i);
        if (l()) {
            return;
        }
        w();
    }

    public final boolean y(int i2, BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.f62912a.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i2 == 1 || i2 == 2) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f62912a.getPageContext().getPageActivity());
            aVar.setMessage(StringHelper.getFixedText(string, 50, true));
            aVar.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.f62912a.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new C1586d(this));
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                aVar.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(blockPopInfoData));
            }
            aVar.create(this.f62912a.getPageContext()).show();
            return true;
        }
        return false;
    }

    public void z(View view, FrsViewData frsViewData) {
        if (this.f62912a == null || frsViewData == null || frsViewData.getForum() == null || frsViewData.postTopic == null) {
            return;
        }
        if (this.f62914c == null) {
            this.f62914c = new l(this.f62912a.getActivity(), this);
        }
        this.f62914c.i();
        this.f62914c.j(view, frsViewData);
    }
}
