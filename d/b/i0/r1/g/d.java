package d.b.i0.r1.g;

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
    public MemberPrivilegeActivity f61170a;

    /* renamed from: b  reason: collision with root package name */
    public View f61171b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61172c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f61173d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f61174e;

    /* renamed from: f  reason: collision with root package name */
    public c f61175f;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f61170a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f61170a = memberPrivilegeActivity;
        h();
    }

    public c e() {
        return this.f61175f;
    }

    public View f() {
        return this.f61171b;
    }

    public final void h() {
        this.f61170a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f61170a.findViewById(R.id.root);
        this.f61171b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f61172c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f61172c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f61171b.findViewById(R.id.nonetworkview);
        this.f61173d = noNetworkView;
        noNetworkView.a(new a());
        this.f61174e = (BdListView) this.f61171b.findViewById(R.id.listview);
        c cVar = new c(this.f61170a);
        this.f61175f = cVar;
        this.f61174e.setAdapter((ListAdapter) cVar);
        this.f61174e.setOnItemClickListener(this.f61170a);
    }

    public void onChangeSkinType(int i) {
        this.f61170a.getLayoutMode().k(i == 1);
        this.f61170a.getLayoutMode().j(this.f61171b);
        this.f61172c.onChangeSkinType(this.f61170a.getPageContext(), i);
        this.f61173d.c(this.f61170a.getPageContext(), i);
    }
}
