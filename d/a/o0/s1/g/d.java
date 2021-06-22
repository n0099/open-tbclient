package d.a.o0.s1.g;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.d<MemberPrivilegeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public MemberPrivilegeActivity f64428a;

    /* renamed from: b  reason: collision with root package name */
    public View f64429b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f64430c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f64431d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f64432e;

    /* renamed from: f  reason: collision with root package name */
    public c f64433f;

    /* loaded from: classes4.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f64428a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f64428a = memberPrivilegeActivity;
        h();
    }

    public c e() {
        return this.f64433f;
    }

    public View f() {
        return this.f64429b;
    }

    public final void h() {
        this.f64428a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f64428a.findViewById(R.id.root);
        this.f64429b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f64430c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f64430c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f64429b.findViewById(R.id.nonetworkview);
        this.f64431d = noNetworkView;
        noNetworkView.a(new a());
        this.f64432e = (BdListView) this.f64429b.findViewById(R.id.listview);
        c cVar = new c(this.f64428a);
        this.f64433f = cVar;
        this.f64432e.setAdapter((ListAdapter) cVar);
        this.f64432e.setOnItemClickListener(this.f64428a);
    }

    public void onChangeSkinType(int i2) {
        this.f64428a.getLayoutMode().k(i2 == 1);
        this.f64428a.getLayoutMode().j(this.f64429b);
        this.f64430c.onChangeSkinType(this.f64428a.getPageContext(), i2);
        this.f64431d.c(this.f64428a.getPageContext(), i2);
    }
}
