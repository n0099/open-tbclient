package d.b.i0.x0;

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
import d.b.b.e.p.l;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public CreateBarGuideActivity f62321a;

    /* renamed from: b  reason: collision with root package name */
    public View f62322b;

    /* renamed from: c  reason: collision with root package name */
    public View f62323c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f62324d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f62325e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f62326f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62327g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62328h;
    public TextView i;
    public LinearLayout j;
    public TbImageView k;
    public UserBfbInfo l;
    public String m;

    /* renamed from: d.b.i0.x0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1655a implements View.OnClickListener {
        public View$OnClickListenerC1655a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.l != null) {
                if (a.this.l.res_no.intValue() == 9528) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.f62321a.getActivity(), a.this.m, true)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f62321a.getActivity(), a.this.m, true)));
                }
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f62321a.getActivity(), a.this.m, true)));
            }
            TiebaStatic.log("c11223");
            a.this.f62321a.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.l != null) {
                if (a.this.l.res_no.intValue() == 9528) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.f62321a.getActivity(), a.this.m, true)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.f62321a.getActivity(), a.this.m, true)));
                }
            }
        }
    }

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.f62321a = createBarGuideActivity;
        View inflate = LayoutInflater.from(createBarGuideActivity.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.f62322b = inflate;
        this.f62321a.setContentView(inflate);
        this.f62323c = this.f62322b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f62322b.findViewById(R.id.view_navigation_bar);
        this.f62326f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62326f.setTitleText(R.string.create_bar);
        this.f62324d = (NoNetworkView) this.f62322b.findViewById(R.id.view_no_network);
        this.f62328h = (TextView) this.f62322b.findViewById(R.id.text_forum_name);
        this.f62327g = (TextView) this.f62322b.findViewById(R.id.text_forum_create);
        this.k = (TbImageView) this.f62322b.findViewById(R.id.status_icon);
        this.f62327g.setOnClickListener(new View$OnClickListenerC1655a());
        this.i = (TextView) this.f62322b.findViewById(R.id.text_create_need);
        this.j = (LinearLayout) this.f62322b.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new b(2016458));
    }

    public View d() {
        return this.f62322b;
    }

    public void e() {
        this.f62323c.setVisibility(8);
    }

    public void f() {
        d.b.h0.s0.a.a(this.f62321a.getPageContext(), this.f62322b);
        NavigationBar navigationBar = this.f62326f;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f62321a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f62324d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f62321a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        NoDataView noDataView = this.f62325e;
        if (noDataView != null) {
            noDataView.f(this.f62321a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g() {
        this.f62323c.setVisibility(0);
    }

    public void h(String str, UserBfbInfo userBfbInfo) {
        this.m = str;
        this.l = userBfbInfo;
        if (this.f62325e == null) {
            int g2 = l.g(this.f62321a.getActivity(), R.dimen.ds100);
            NoDataView a2 = NoDataViewFactory.a(this.f62321a.getPageContext().getPageActivity(), (LinearLayout) this.f62322b.findViewById(R.id.emotion_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, g2), null, null);
            this.f62325e = a2;
            a2.setVisibility(0);
            f();
        }
        TextView textView = this.f62328h;
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
