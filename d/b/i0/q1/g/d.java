package d.b.i0.q1.g;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
/* loaded from: classes3.dex */
public class d extends d.b.b.a.d<MemberPrivilegeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public MemberPrivilegeActivity f59475a;

    /* renamed from: b  reason: collision with root package name */
    public View f59476b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59477c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f59478d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f59479e;

    /* renamed from: f  reason: collision with root package name */
    public c f59480f;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f59475a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f59475a = memberPrivilegeActivity;
        h();
    }

    public c e() {
        return this.f59480f;
    }

    public View f() {
        return this.f59476b;
    }

    public final void h() {
        this.f59475a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f59475a.findViewById(R.id.root);
        this.f59476b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f59477c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f59477c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f59476b.findViewById(R.id.nonetworkview);
        this.f59478d = noNetworkView;
        noNetworkView.a(new a());
        this.f59479e = (BdListView) this.f59476b.findViewById(R.id.listview);
        c cVar = new c(this.f59475a);
        this.f59480f = cVar;
        this.f59479e.setAdapter((ListAdapter) cVar);
        this.f59479e.setOnItemClickListener(this.f59475a);
    }

    public void onChangeSkinType(int i) {
        this.f59475a.getLayoutMode().k(i == 1);
        this.f59475a.getLayoutMode().j(this.f59476b);
        this.f59477c.onChangeSkinType(this.f59475a.getPageContext(), i);
        this.f59478d.c(this.f59475a.getPageContext(), i);
    }
}
