package d.b.j0.y0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.home.CreateBarGuideActivity;
import d.b.c.e.p.l;
import tbclient.UserBfbInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public CreateBarGuideActivity f64427a;

    /* renamed from: b  reason: collision with root package name */
    public View f64428b;

    /* renamed from: c  reason: collision with root package name */
    public View f64429c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f64430d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f64431e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f64432f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64433g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64434h;
    public TextView i;
    public LinearLayout j;
    public TbImageView k;
    public UserBfbInfo l;
    public String m;

    /* renamed from: d.b.j0.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1737a implements View.OnClickListener {
        public View$OnClickListenerC1737a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.l != null) {
                if (a.this.l.res_no.intValue() == 9528) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.f64427a.getActivity(), a.this.m, true)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f64427a.getActivity(), a.this.m, true)));
                }
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f64427a.getActivity(), a.this.m, true)));
            }
            TiebaStatic.log("c11223");
            a.this.f64427a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.l != null) {
                if (a.this.l.res_no.intValue() == 9528) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.f64427a.getActivity(), a.this.m, true)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f64427a.getActivity(), a.this.m, true)));
                }
            }
        }
    }

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.f64427a = createBarGuideActivity;
        View inflate = LayoutInflater.from(createBarGuideActivity.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.f64428b = inflate;
        this.f64427a.setContentView(inflate);
        this.f64429c = this.f64428b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f64428b.findViewById(R.id.view_navigation_bar);
        this.f64432f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64432f.setTitleText(R.string.create_bar);
        this.f64430d = (NoNetworkView) this.f64428b.findViewById(R.id.view_no_network);
        this.f64434h = (TextView) this.f64428b.findViewById(R.id.text_forum_name);
        this.f64433g = (TextView) this.f64428b.findViewById(R.id.text_forum_create);
        this.k = (TbImageView) this.f64428b.findViewById(R.id.status_icon);
        this.f64433g.setOnClickListener(new View$OnClickListenerC1737a());
        this.i = (TextView) this.f64428b.findViewById(R.id.text_create_need);
        this.j = (LinearLayout) this.f64428b.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new b(2016458));
    }

    public View d() {
        return this.f64428b;
    }

    public void e() {
        this.f64429c.setVisibility(8);
    }

    public void f() {
        d.b.i0.s0.a.a(this.f64427a.getPageContext(), this.f64428b);
        NavigationBar navigationBar = this.f64432f;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f64427a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f64430d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f64427a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        NoDataView noDataView = this.f64431e;
        if (noDataView != null) {
            noDataView.f(this.f64427a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g() {
        this.f64429c.setVisibility(0);
    }

    public void h(String str, UserBfbInfo userBfbInfo) {
        this.m = str;
        this.l = userBfbInfo;
        if (this.f64431e == null) {
            int g2 = l.g(this.f64427a.getActivity(), R.dimen.ds100);
            NoDataView a2 = NoDataViewFactory.a(this.f64427a.getPageContext().getPageActivity(), (LinearLayout) this.f64428b.findViewById(R.id.emotion_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, g2), null, null);
            this.f64431e = a2;
            a2.setVisibility(0);
            f();
        }
        TextView textView = this.f64434h;
        textView.setText(this.m + "吧");
        UserBfbInfo userBfbInfo2 = this.l;
        if (userBfbInfo2 != null && userBfbInfo2.res_no.intValue() == 9528) {
            if (this.l.activity_status.intValue() == 0) {
                this.k.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.k.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.i.setVisibility(4);
            this.j.setVisibility(4);
        }
        this.i.setVisibility(8);
        this.j.setVisibility(8);
    }
}
