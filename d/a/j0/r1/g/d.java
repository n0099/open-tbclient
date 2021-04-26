package d.a.j0.r1.g;

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
    public MemberPrivilegeActivity f59744a;

    /* renamed from: b  reason: collision with root package name */
    public View f59745b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59746c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f59747d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f59748e;

    /* renamed from: f  reason: collision with root package name */
    public c f59749f;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f59744a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f59744a = memberPrivilegeActivity;
        g();
    }

    public c e() {
        return this.f59749f;
    }

    public View f() {
        return this.f59745b;
    }

    public final void g() {
        this.f59744a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f59744a.findViewById(R.id.root);
        this.f59745b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f59746c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f59746c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f59745b.findViewById(R.id.nonetworkview);
        this.f59747d = noNetworkView;
        noNetworkView.a(new a());
        this.f59748e = (BdListView) this.f59745b.findViewById(R.id.listview);
        c cVar = new c(this.f59744a);
        this.f59749f = cVar;
        this.f59748e.setAdapter((ListAdapter) cVar);
        this.f59748e.setOnItemClickListener(this.f59744a);
    }

    public void onChangeSkinType(int i2) {
        this.f59744a.getLayoutMode().k(i2 == 1);
        this.f59744a.getLayoutMode().j(this.f59745b);
        this.f59746c.onChangeSkinType(this.f59744a.getPageContext(), i2);
        this.f59747d.c(this.f59744a.getPageContext(), i2);
    }
}
