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
    public MemberPrivilegeActivity f60612a;

    /* renamed from: b  reason: collision with root package name */
    public View f60613b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60614c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f60615d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f60616e;

    /* renamed from: f  reason: collision with root package name */
    public c f60617f;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f60612a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f60612a = memberPrivilegeActivity;
        g();
    }

    public c e() {
        return this.f60617f;
    }

    public View f() {
        return this.f60613b;
    }

    public final void g() {
        this.f60612a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f60612a.findViewById(R.id.root);
        this.f60613b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f60614c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f60614c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f60613b.findViewById(R.id.nonetworkview);
        this.f60615d = noNetworkView;
        noNetworkView.a(new a());
        this.f60616e = (BdListView) this.f60613b.findViewById(R.id.listview);
        c cVar = new c(this.f60612a);
        this.f60617f = cVar;
        this.f60616e.setAdapter((ListAdapter) cVar);
        this.f60616e.setOnItemClickListener(this.f60612a);
    }

    public void onChangeSkinType(int i2) {
        this.f60612a.getLayoutMode().k(i2 == 1);
        this.f60612a.getLayoutMode().j(this.f60613b);
        this.f60614c.onChangeSkinType(this.f60612a.getPageContext(), i2);
        this.f60615d.c(this.f60612a.getPageContext(), i2);
    }
}
