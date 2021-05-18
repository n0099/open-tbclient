package d.a.k0.r1.g;

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
    public MemberPrivilegeActivity f60489a;

    /* renamed from: b  reason: collision with root package name */
    public View f60490b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60491c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f60492d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f60493e;

    /* renamed from: f  reason: collision with root package name */
    public c f60494f;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f60489a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f60489a = memberPrivilegeActivity;
        g();
    }

    public c e() {
        return this.f60494f;
    }

    public View f() {
        return this.f60490b;
    }

    public final void g() {
        this.f60489a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f60489a.findViewById(R.id.root);
        this.f60490b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f60491c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f60491c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f60490b.findViewById(R.id.nonetworkview);
        this.f60492d = noNetworkView;
        noNetworkView.a(new a());
        this.f60493e = (BdListView) this.f60490b.findViewById(R.id.listview);
        c cVar = new c(this.f60489a);
        this.f60494f = cVar;
        this.f60493e.setAdapter((ListAdapter) cVar);
        this.f60493e.setOnItemClickListener(this.f60489a);
    }

    public void onChangeSkinType(int i2) {
        this.f60489a.getLayoutMode().k(i2 == 1);
        this.f60489a.getLayoutMode().j(this.f60490b);
        this.f60491c.onChangeSkinType(this.f60489a.getPageContext(), i2);
        this.f60492d.c(this.f60489a.getPageContext(), i2);
    }
}
