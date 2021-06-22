package d.a.o0.z0;

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
import d.a.c.e.p.l;
import tbclient.UserBfbInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public CreateBarGuideActivity f67432a;

    /* renamed from: b  reason: collision with root package name */
    public View f67433b;

    /* renamed from: c  reason: collision with root package name */
    public View f67434c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f67435d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f67436e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f67437f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f67438g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f67439h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f67440i;
    public LinearLayout j;
    public TbImageView k;
    public UserBfbInfo l;
    public String m;

    /* renamed from: d.a.o0.z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1816a implements View.OnClickListener {
        public View$OnClickListenerC1816a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.l != null) {
                if (a.this.l.res_no.intValue() == 9528) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.f67432a.getActivity(), a.this.m, true)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f67432a.getActivity(), a.this.m, true)));
                }
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f67432a.getActivity(), a.this.m, true)));
            }
            TiebaStatic.log("c11223");
            a.this.f67432a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.l != null) {
                if (a.this.l.res_no.intValue() == 9528) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.f67432a.getActivity(), a.this.m, true)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f67432a.getActivity(), a.this.m, true)));
                }
            }
        }
    }

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.f67432a = createBarGuideActivity;
        View inflate = LayoutInflater.from(createBarGuideActivity.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.f67433b = inflate;
        this.f67432a.setContentView(inflate);
        this.f67434c = this.f67433b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f67433b.findViewById(R.id.view_navigation_bar);
        this.f67437f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f67437f.setTitleText(R.string.create_bar);
        this.f67435d = (NoNetworkView) this.f67433b.findViewById(R.id.view_no_network);
        this.f67439h = (TextView) this.f67433b.findViewById(R.id.text_forum_name);
        this.f67438g = (TextView) this.f67433b.findViewById(R.id.text_forum_create);
        this.k = (TbImageView) this.f67433b.findViewById(R.id.status_icon);
        this.f67438g.setOnClickListener(new View$OnClickListenerC1816a());
        this.f67440i = (TextView) this.f67433b.findViewById(R.id.text_create_need);
        this.j = (LinearLayout) this.f67433b.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new b(2016458));
    }

    public View d() {
        return this.f67433b;
    }

    public void e() {
        this.f67434c.setVisibility(8);
    }

    public void f() {
        d.a.n0.s0.a.a(this.f67432a.getPageContext(), this.f67433b);
        NavigationBar navigationBar = this.f67437f;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f67432a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f67435d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f67432a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        NoDataView noDataView = this.f67436e;
        if (noDataView != null) {
            noDataView.f(this.f67432a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g() {
        this.f67434c.setVisibility(0);
    }

    public void h(String str, UserBfbInfo userBfbInfo) {
        this.m = str;
        this.l = userBfbInfo;
        if (this.f67436e == null) {
            int g2 = l.g(this.f67432a.getActivity(), R.dimen.ds100);
            NoDataView a2 = NoDataViewFactory.a(this.f67432a.getPageContext().getPageActivity(), (LinearLayout) this.f67433b.findViewById(R.id.emotion_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, g2), null, null);
            this.f67436e = a2;
            a2.setVisibility(0);
            f();
        }
        TextView textView = this.f67439h;
        textView.setText(this.m + "吧");
        UserBfbInfo userBfbInfo2 = this.l;
        if (userBfbInfo2 != null && userBfbInfo2.res_no.intValue() == 9528) {
            if (this.l.activity_status.intValue() == 0) {
                this.k.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.k.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.f67440i.setVisibility(4);
            this.j.setVisibility(4);
        }
        this.f67440i.setVisibility(8);
        this.j.setVisibility(8);
    }
}
