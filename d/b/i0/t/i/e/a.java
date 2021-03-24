package d.b.i0.t.i.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.ala.view.ParentDisallowInterceptHListView;
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
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import d.b.h0.r.q.a2;
import d.b.i0.c3.g;
import d.b.i0.x.z;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.b.i0.x.b<g> implements z {
    public ThreadSkinView m;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public LinearLayout q;
    public View r;
    public ForbidParentSwipeBackRelativeLayout s;
    public ParentDisallowInterceptHListView t;
    public d.b.i0.t.i.a.b u;
    public boolean v;
    public g w;
    public String x;
    public AdapterView.d y;

    /* renamed from: d.b.i0.t.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1565a implements SwipeBackLayout.c {
        public C1565a() {
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            if (a.this.w == null || ListUtils.isEmpty(a.this.w.f53352e) || a.this.w.f53352e.size() <= 1) {
                return;
            }
            if (a.this.f62180f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) a.this.f62180f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (a.this.f62180f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) a.this.f62180f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            if (a.this.f62180f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) a.this.f62180f.getOrignalPage()).setSwipeBackEnabled(a.this.v);
            } else if (a.this.f62180f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) a.this.f62180f.getOrignalPage()).setSwipeBackEnabled(a.this.v);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.d {
        public b() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            a2 item = a.this.u.getItem(i);
            a.this.x(item);
            a aVar = a.this;
            aVar.z(aVar.f62180f, item);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.v = true;
        this.y = new b();
        this.s = (ForbidParentSwipeBackRelativeLayout) m().findViewById(R.id.layout_root);
        this.m = (ThreadSkinView) m().findViewById(R.id.frs_thread_skin);
        this.n = (TextView) m().findViewById(R.id.frs_insert_live_label);
        this.o = (TextView) m().findViewById(R.id.frs_insert_live_more);
        this.p = (RelativeLayout) m().findViewById(R.id.frs_insert_live_top);
        this.t = (ParentDisallowInterceptHListView) m().findViewById(R.id.frs_insert_live_listview);
        this.q = (LinearLayout) m().findViewById(R.id.frs_card_content_layout);
        this.r = m().findViewById(R.id.divider_line);
        this.t.setDividerWidth(this.f62181g.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.t.setBackgroundResource(R.drawable.transparent_bg);
        this.t.setOnItemClickListener(this.y);
        this.t.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        d.b.i0.t.i.a.b bVar = new d.b.i0.t.i.a.b(tbPageContext);
        this.u = bVar;
        this.t.setAdapter((ListAdapter) bVar);
        this.o.setOnClickListener(this);
        if (this.f62180f.getOrignalPage() instanceof BaseActivity) {
            this.v = ((BaseActivity) this.f62180f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f62180f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.v = ((BaseFragmentActivity) this.f62180f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.s.setSwipeControlInterface(new C1565a());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: A */
    public void n(g gVar) {
        if (gVar == null) {
            return;
        }
        this.w = gVar;
        y();
        this.u.b(gVar.f53352e);
        o(l(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData B(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.frs_ala_insert_rec_live_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62179e != i) {
            SkinManager.setBackgroundResource(this.s, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            this.f62179e = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.o) {
            TiebaStatic.log(new StatisticItem("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001627, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f62180f.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
    }

    public final void x(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921018);
        customMessage.setData(a2Var);
        MessageManager.getInstance().sendMessage(customMessage);
        TiebaStatic.log(new StatisticItem("c12638"));
    }

    public final void y() {
        if (ListUtils.isEmpty(this.w.f53352e)) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        customMessage.setData(this.w.f53352e.get(0));
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void z(TbPageContext<?> tbPageContext, a2 a2Var) {
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
        g gVar = this.w;
        if (gVar != null && !ListUtils.isEmpty(gVar.f53352e)) {
            for (a2 a2Var2 : this.w.f53352e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(B(a2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.x)));
    }
}
