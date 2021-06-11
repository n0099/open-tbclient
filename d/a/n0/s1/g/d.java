package d.a.n0.s1.g;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
/* loaded from: classes3.dex */
public class d extends d.a.c.a.d<MemberPrivilegeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public MemberPrivilegeActivity f64303a;

    /* renamed from: b  reason: collision with root package name */
    public View f64304b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f64305c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f64306d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f64307e;

    /* renamed from: f  reason: collision with root package name */
    public c f64308f;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f64303a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f64303a = memberPrivilegeActivity;
        h();
    }

    public c e() {
        return this.f64308f;
    }

    public View f() {
        return this.f64304b;
    }

    public final void h() {
        this.f64303a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f64303a.findViewById(R.id.root);
        this.f64304b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f64305c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f64305c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f64304b.findViewById(R.id.nonetworkview);
        this.f64306d = noNetworkView;
        noNetworkView.a(new a());
        this.f64307e = (BdListView) this.f64304b.findViewById(R.id.listview);
        c cVar = new c(this.f64303a);
        this.f64308f = cVar;
        this.f64307e.setAdapter((ListAdapter) cVar);
        this.f64307e.setOnItemClickListener(this.f64303a);
    }

    public void onChangeSkinType(int i2) {
        this.f64303a.getLayoutMode().k(i2 == 1);
        this.f64303a.getLayoutMode().j(this.f64304b);
        this.f64305c.onChangeSkinType(this.f64303a.getPageContext(), i2);
        this.f64306d.c(this.f64303a.getPageContext(), i2);
    }
}
