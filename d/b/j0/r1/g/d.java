package d.b.j0.r1.g;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
/* loaded from: classes3.dex */
public class d extends d.b.c.a.d<MemberPrivilegeActivity> {

    /* renamed from: a  reason: collision with root package name */
    public MemberPrivilegeActivity f61591a;

    /* renamed from: b  reason: collision with root package name */
    public View f61592b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61593c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f61594d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f61595e;

    /* renamed from: f  reason: collision with root package name */
    public c f61596f;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f61591a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f61591a = memberPrivilegeActivity;
        h();
    }

    public c e() {
        return this.f61596f;
    }

    public View f() {
        return this.f61592b;
    }

    public final void h() {
        this.f61591a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f61591a.findViewById(R.id.root);
        this.f61592b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f61593c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f61593c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f61592b.findViewById(R.id.nonetworkview);
        this.f61594d = noNetworkView;
        noNetworkView.a(new a());
        this.f61595e = (BdListView) this.f61592b.findViewById(R.id.listview);
        c cVar = new c(this.f61591a);
        this.f61596f = cVar;
        this.f61595e.setAdapter((ListAdapter) cVar);
        this.f61595e.setOnItemClickListener(this.f61591a);
    }

    public void onChangeSkinType(int i) {
        this.f61591a.getLayoutMode().k(i == 1);
        this.f61591a.getLayoutMode().j(this.f61592b);
        this.f61593c.onChangeSkinType(this.f61591a.getPageContext(), i);
        this.f61594d.c(this.f61591a.getPageContext(), i);
    }
}
