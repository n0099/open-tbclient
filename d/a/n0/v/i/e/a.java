package d.a.n0.v.i.e;

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
import d.a.m0.r.q.a2;
import d.a.n0.e3.g;
import d.a.n0.z.z;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.a.n0.z.b<g> implements z {
    public ThreadSkinView m;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public LinearLayout q;
    public View r;
    public ForbidParentSwipeBackRelativeLayout s;
    public ParentDisallowInterceptHListView t;
    public d.a.n0.v.i.a.b u;
    public boolean v;
    public g w;
    public String x;
    public AdapterView.d y;

    /* renamed from: d.a.n0.v.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1667a implements SwipeBackLayout.c {
        public C1667a() {
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            if (a.this.w == null || ListUtils.isEmpty(a.this.w.f53973e) || a.this.w.f53973e.size() <= 1) {
                return;
            }
            if (a.this.f63441f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) a.this.f63441f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (a.this.f63441f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) a.this.f63441f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            if (a.this.f63441f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) a.this.f63441f.getOrignalPage()).setSwipeBackEnabled(a.this.v);
            } else if (a.this.f63441f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) a.this.f63441f.getOrignalPage()).setSwipeBackEnabled(a.this.v);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.d {
        public b() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            a2 item = a.this.u.getItem(i2);
            a.this.v(item);
            a aVar = a.this;
            aVar.x(aVar.f63441f, item);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.v = true;
        this.y = new b();
        this.s = (ForbidParentSwipeBackRelativeLayout) l().findViewById(R.id.layout_root);
        this.m = (ThreadSkinView) l().findViewById(R.id.frs_thread_skin);
        this.n = (TextView) l().findViewById(R.id.frs_insert_live_label);
        this.o = (TextView) l().findViewById(R.id.frs_insert_live_more);
        this.p = (RelativeLayout) l().findViewById(R.id.frs_insert_live_top);
        this.t = (ParentDisallowInterceptHListView) l().findViewById(R.id.frs_insert_live_listview);
        this.q = (LinearLayout) l().findViewById(R.id.frs_card_content_layout);
        this.r = l().findViewById(R.id.divider_line);
        this.t.setDividerWidth(this.f63442g.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.t.setBackgroundResource(R.drawable.transparent_bg);
        this.t.setOnItemClickListener(this.y);
        this.t.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        d.a.n0.v.i.a.b bVar = new d.a.n0.v.i.a.b(tbPageContext);
        this.u = bVar;
        this.t.setAdapter((ListAdapter) bVar);
        this.o.setOnClickListener(this);
        if (this.f63441f.getOrignalPage() instanceof BaseActivity) {
            this.v = ((BaseActivity) this.f63441f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f63441f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.v = ((BaseFragmentActivity) this.f63441f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.s.setSwipeControlInterface(new C1667a());
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.frs_ala_insert_rec_live_layout;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f63440e != i2) {
            SkinManager.setBackgroundResource(this.s, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            this.f63440e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.o) {
            TiebaStatic.log(new StatisticItem("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001627, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f63441f.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // d.a.n0.z.z
    public void q(int i2) {
    }

    public final void v(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921018);
        customMessage.setData(a2Var);
        MessageManager.getInstance().sendMessage(customMessage);
        TiebaStatic.log(new StatisticItem("c12638"));
    }

    public final void w() {
        if (ListUtils.isEmpty(this.w.f53973e)) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        customMessage.setData(this.w.f53973e.get(0));
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void x(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.r1() == null) {
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
        if (a2Var.r1() != null && a2Var.r1().user_info != null) {
            alaLiveInfoCoreData.userName = a2Var.r1().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        g gVar = this.w;
        if (gVar != null && !ListUtils.isEmpty(gVar.f53973e)) {
            for (a2 a2Var2 : this.w.f53973e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(z(a2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.x)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: y */
    public void m(g gVar) {
        if (gVar == null) {
            return;
        }
        this.w = gVar;
        w();
        this.u.b(gVar.f53973e);
        n(k(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData z(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }
}
