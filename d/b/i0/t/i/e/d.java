package d.b.i0.t.i.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import d.b.h0.r.q.a2;
import d.b.i0.c3.h;
import d.b.i0.x.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.i0.x.b<h> implements z {
    public boolean A;
    public int B;
    public ViewPager.OnPageChangeListener C;
    public d.b.i0.t.i.d.c D;
    public ForbidParentSwipeBackRelativeLayout m;
    public FrsAlaStageLiveViewPager n;
    public FrsAlaStageLiveViewItemAdapter o;
    public LinearLayout p;
    public IndicatorView q;
    public View r;
    public View s;
    public String t;
    public h u;
    public int v;
    public d.b.i0.t.i.d.a w;
    public d.b.i0.t.i.d.b x;
    public boolean y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements SwipeBackLayout.c {
        public a() {
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            if (d.this.u == null || ListUtils.isEmpty(d.this.u.f53365e) || d.this.u.f53365e.size() <= 1) {
                return;
            }
            if (d.this.f62181f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) d.this.f62181f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (d.this.f62181f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) d.this.f62181f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            if (d.this.f62181f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) d.this.f62181f.getOrignalPage()).setSwipeBackEnabled(d.this.A);
            } else if (d.this.f62181f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) d.this.f62181f.getOrignalPage()).setSwipeBackEnabled(d.this.A);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (i != 1 && i == 0 && (count = d.this.o.getCount()) >= 2) {
                int currentItem = d.this.n.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    d.this.n.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    d.this.n.setCurrentItem(1, false);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            d.this.v = i;
            if (d.this.x == null) {
                return;
            }
            int a2 = d.this.x.a(i + 1);
            d.this.v = a2;
            if (d.this.q != null) {
                d.this.q.setPosition(d.this.x.c(a2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.i0.t.i.d.c {
        public c() {
        }

        @Override // d.b.i0.t.i.d.c
        public void a(View view, a2 a2Var) {
            d.this.I(view, a2Var);
            d.this.F(a2Var);
            d dVar = d.this;
            dVar.J(dVar.f62181f, a2Var);
        }

        @Override // d.b.i0.t.i.d.c
        public void b(View view, a2 a2Var) {
            d.this.I(view, a2Var);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.v = 1;
        this.y = false;
        this.z = 5;
        this.A = true;
        this.C = new b();
        this.D = new c();
        this.m = (ForbidParentSwipeBackRelativeLayout) m().findViewById(R.id.layout_root);
        this.r = m().findViewById(R.id.divider_line);
        this.s = m().findViewById(R.id.divider_pager_and_indicator);
        this.n = (FrsAlaStageLiveViewPager) m().findViewById(R.id.frs_stage_live_listview);
        this.p = (LinearLayout) m().findViewById(R.id.frs_stage_indicator_parent);
        this.q = (IndicatorView) m().findViewById(R.id.frs_stage_indicator);
        d.b.i0.t.i.d.a aVar = new d.b.i0.t.i.d.a(tbPageContext, this.m);
        this.w = aVar;
        aVar.d(k());
        this.n.setBackgroundResource(R.drawable.transparent_bg);
        this.n.setOnPageChangeListener(this.C);
        FrsAlaStageLiveViewItemAdapter frsAlaStageLiveViewItemAdapter = new FrsAlaStageLiveViewItemAdapter(this.f62181f, k());
        this.o = frsAlaStageLiveViewItemAdapter;
        this.n.setAdapter(frsAlaStageLiveViewItemAdapter);
        if (this.f62181f.getOrignalPage() instanceof BaseActivity) {
            this.A = ((BaseActivity) this.f62181f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f62181f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.A = ((BaseFragmentActivity) this.f62181f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.m.setSwipeControlInterface(new a());
    }

    public final void F(a2 a2Var) {
        if (a2Var.q1() == null || a2Var.q1().user_info == null || a2Var.q1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12805").param("tid", a2Var.o0()));
    }

    public final void G() {
        int c2;
        h hVar = this.u;
        if (hVar == null || !ListUtils.isEmpty(hVar.f53365e) || (c2 = this.x.c(this.v)) >= this.u.f53365e.size() || c2 < 0) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        List<a2> list = this.u.f53365e;
        if (list != null && list.get(c2) != null) {
            this.u.f53365e.get(c2).M1 = this.B;
        }
        customMessage.setData(this.u.f53365e.get(c2));
        MessageManager.getInstance().sendMessage(customMessage);
        if (this.u.f53365e.get(c2) != null) {
            TiebaStatic.log(new StatisticItem("c12804").param("tid", this.u.f53365e.get(c2).o0()));
        }
    }

    public final void I(View view, a2 a2Var) {
        CustomMessage customMessage;
        if (view.getId() == R.id.layout_root) {
            customMessage = new CustomMessage(2921018);
        } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header) {
            customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
        } else {
            customMessage = new CustomMessage(2921016);
        }
        if (customMessage == null || this.f62181f == null) {
            return;
        }
        customMessage.setData(a2Var);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void J(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = a2Var.T().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        if (a2Var.q1() != null && a2Var.q1().user_info != null) {
            alaLiveInfoCoreData.userName = a2Var.q1().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        h hVar = this.u;
        if (hVar != null && !ListUtils.isEmpty(hVar.f53365e)) {
            for (a2 a2Var2 : this.u.f53365e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(L(a2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.t)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: K */
    public void n(h hVar) {
        if (hVar == null || hVar.f53365e == null) {
            return;
        }
        this.u = hVar;
        s(0);
        if (this.x == null) {
            d.b.i0.t.i.d.b bVar = new d.b.i0.t.i.d.b(hVar.f53365e, this.y, this.z);
            this.x = bVar;
            bVar.i(2);
            this.x.h(6);
            this.x.g(1);
        }
        this.x.j(hVar.f53365e);
        this.o.g(this.t);
        this.o.f(this.x.e(), this.D);
        this.n.setCurrentItem(this.x.d(), false);
        if (hVar.f53365e.size() >= 2) {
            this.p.setVisibility(0);
            if (this.q.getCount() != this.x.b()) {
                this.q.setCount(this.x.b());
                this.v = this.x.d();
            }
            this.q.setPosition(this.x.c(this.v));
        } else {
            this.p.setVisibility(8);
        }
        if (hVar.f53365e.size() > 0) {
            this.w.b(hVar.f53365e.get(0), "ala_frs_stage_live_feed_back_type");
        }
        G();
        o(l(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData L(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
        this.t = str;
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.frs_ala_stage_live_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62180e != i) {
            SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
            this.f62180e = i;
        }
        this.w.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
    }
}
