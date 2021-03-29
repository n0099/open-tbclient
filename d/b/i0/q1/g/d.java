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
    public MemberPrivilegeActivity f59476a;

    /* renamed from: b  reason: collision with root package name */
    public View f59477b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59478c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f59479d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f59480e;

    /* renamed from: f  reason: collision with root package name */
    public c f59481f;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                d.this.f59476a.requestMemberPrivilegeData();
            }
        }
    }

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.f59476a = memberPrivilegeActivity;
        h();
    }

    public c e() {
        return this.f59481f;
    }

    public View f() {
        return this.f59477b;
    }

    public final void h() {
        this.f59476a.setContentView(R.layout.memberprivilege_activity);
        View findViewById = this.f59476a.findViewById(R.id.root);
        this.f59477b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.navigationbar);
        this.f59478c = navigationBar;
        navigationBar.setTitleText(R.string.member_center);
        this.f59478c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NoNetworkView noNetworkView = (NoNetworkView) this.f59477b.findViewById(R.id.nonetworkview);
        this.f59479d = noNetworkView;
        noNetworkView.a(new a());
        this.f59480e = (BdListView) this.f59477b.findViewById(R.id.listview);
        c cVar = new c(this.f59476a);
        this.f59481f = cVar;
        this.f59480e.setAdapter((ListAdapter) cVar);
        this.f59480e.setOnItemClickListener(this.f59476a);
    }

    public void onChangeSkinType(int i) {
        this.f59476a.getLayoutMode().k(i == 1);
        this.f59476a.getLayoutMode().j(this.f59477b);
        this.f59478c.onChangeSkinType(this.f59476a.getPageContext(), i);
        this.f59479d.c(this.f59476a.getPageContext(), i);
    }
}
