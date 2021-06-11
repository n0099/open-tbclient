package d.a.n0.g1.a.c;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.g1.a.c.c;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.d<InviteFriendListActivity> implements c.b {

    /* renamed from: e  reason: collision with root package name */
    public final InviteFriendListActivity f58652e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f58653f;

    /* renamed from: g  reason: collision with root package name */
    public View f58654g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f58655h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.g1.a.c.c f58656i;
    public NoDataView j;
    public ProgressBar k;
    public View l;
    public InviteFriendCandidateList m;
    public LinearLayout n;
    public Button o;
    public View p;
    public int q;
    public boolean r;
    public TextView s;
    public View t;
    public View u;
    public EditText v;
    public TextView w;
    public TextWatcher x;
    public ImageView y;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.f58652e.getPageContext().getPageActivity())));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements InviteFriendCandidateList.b {
        public b() {
        }

        @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.b
        public void a(View view, Object obj) {
            if (obj != null) {
                if (obj instanceof TbCheckBox.c) {
                    ((TbCheckBox.c) obj).setChecked(false);
                }
                View findViewWithTag = d.this.f58655h.findViewWithTag(obj);
                if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                    ((TbCheckBox) findViewWithTag).setChecked(false);
                } else if (obj instanceof d.a.m0.s.f.a) {
                    d.this.J((d.a.m0.s.f.a) obj);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.t != null && d.this.t.getVisibility() == 0) {
                d.this.A();
                return;
            }
            l.x(d.this.f58652e.getPageContext().getPageActivity(), d.this.v);
            d.this.f58652e.finish();
        }
    }

    /* renamed from: d.a.n0.g1.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1398d implements View.OnClickListener {
        public View$OnClickListenerC1398d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.s.setVisibility(8);
            d.this.u.setVisibility(8);
            d.this.t.setVisibility(0);
            d.this.v.requestFocus();
            l.K(d.this.f58652e.getPageContext().getPageActivity(), d.this.v);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String = k.charSequence2String(editable, null);
            if (charSequence2String == null) {
                return;
            }
            if (charSequence2String.length() > 0) {
                d.this.w.setVisibility(0);
            } else {
                d.this.w.setVisibility(8);
            }
            d.this.y();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.v.getText().clear();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            d.this.z();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements TbCheckBox.b {
        public h() {
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            d.this.z();
            if (obj == null || !(obj instanceof d.a.m0.s.f.a)) {
                return;
            }
            if (z) {
                if (d.this.u() <= d.this.m.getItemLength()) {
                    d.this.f58652e.showToast(String.format(d.this.f58652e.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.q)));
                    tbCheckBox.setChecked(false);
                    ((d.a.m0.s.f.a) obj).setChecked(false);
                    return;
                }
                d.this.q((d.a.m0.s.f.a) obj);
                return;
            }
            d.this.J((d.a.m0.s.f.a) obj);
        }
    }

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.q = 0;
        this.f58652e = inviteFriendListActivity;
        this.r = z;
        F();
    }

    public void A() {
        l.x(this.f58652e.getPageContext().getPageActivity(), this.v);
        this.t.setVisibility(8);
        this.s.setVisibility(0);
        this.u.setVisibility(0);
        this.v.getText().clear();
    }

    public final void B() {
        NavigationBar navigationBar = (NavigationBar) this.f58654g.findViewById(R.id.view_navigation_bar);
        this.f58653f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
        if (this.r) {
            this.s = this.f58653f.setTitleText(R.string.invite_contact_title);
        } else {
            this.s = this.f58653f.setTitleText(R.string.invite_friend);
        }
        View addCustomView = this.f58653f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View$OnClickListenerC1398d());
        this.u = addCustomView;
        this.y = (ImageView) addCustomView.findViewById(R.id.new_friend_search);
        View addCustomView2 = this.f58653f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.t = addCustomView2;
        addCustomView2.setVisibility(8);
        EditText editText = (EditText) this.t.findViewById(R.id.search_bar_edit);
        this.v = editText;
        if (editText.getParent() != null) {
            ((View) this.v.getParent()).setFocusable(true);
            ((View) this.v.getParent()).setFocusableInTouchMode(true);
        }
        e eVar = new e();
        this.x = eVar;
        this.v.addTextChangedListener(eVar);
        TextView textView = (TextView) this.t.findViewById(R.id.search_bar_delete_button);
        this.w = textView;
        textView.setOnClickListener(new f());
    }

    public final void F() {
        this.f58652e.setContentView(R.layout.invite_friend_list);
        this.f58654g = this.f58652e.findViewById(R.id.root_view);
        B();
        BdListView bdListView = (BdListView) this.f58654g.findViewById(R.id.friend_list);
        this.f58655h = bdListView;
        bdListView.setOnItemClickListener(this.f58652e);
        if (this.r) {
            this.j = NoDataViewFactory.a(this.f58652e.getPageContext().getPageActivity(), this.f58654g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13013a), NoDataViewFactory.e.b(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.j = NoDataViewFactory.a(this.f58652e.getPageContext().getPageActivity(), this.f58654g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.f13013a), NoDataViewFactory.e.b(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.c.a(new NoDataViewFactory.b(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new a())));
        }
        this.k = (ProgressBar) this.f58654g.findViewById(R.id.progress);
        InviteFriendCandidateList inviteFriendCandidateList = (InviteFriendCandidateList) this.f58654g.findViewById(R.id.candidate_list);
        this.m = inviteFriendCandidateList;
        inviteFriendCandidateList.n(new b());
        this.n = (LinearLayout) this.f58654g.findViewById(R.id.invite_candidate);
        this.l = this.f58654g.findViewById(R.id.invite_candidate_border);
        if (this.r) {
            this.n.setVisibility(8);
            this.l.setVisibility(8);
        }
        r();
        Button button = (Button) this.f58654g.findViewById(R.id.button_send);
        this.o = button;
        button.setOnClickListener(this.f58652e);
        s();
        M();
        K(0);
    }

    public boolean G() {
        View view = this.t;
        return view != null && view.getVisibility() == 0;
    }

    public void H() {
        this.v.removeTextChangedListener(this.x);
    }

    public void I(List<d.a.m0.s.f.a> list, boolean z) {
        if (this.f58656i == null) {
            d.a.n0.g1.a.c.c cVar = new d.a.n0.g1.a.c.c(this.f58652e, this.r);
            this.f58656i = cVar;
            cVar.f(this);
            this.f58656i.d(new h());
            this.f58655h.setAdapter((ListAdapter) this.f58656i);
        }
        if (!z && list.isEmpty()) {
            this.j.setVisibility(0);
            this.f58655h.setVisibility(8);
            if (this.r) {
                return;
            }
            this.n.setVisibility(8);
            return;
        }
        this.j.setVisibility(8);
        this.f58655h.setVisibility(0);
        this.f58656i.e(list);
        this.f58656i.notifyDataSetChanged();
        if (this.r) {
            return;
        }
        this.n.setVisibility(0);
    }

    public void J(d.a.m0.s.f.a aVar) {
        if (aVar != null) {
            this.m.l(aVar);
            K(this.m.getItemLength());
            O();
        }
    }

    public final void K(int i2) {
        this.o.setText(String.format(this.f58652e.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i2)));
    }

    public void L(int i2) {
        this.q = i2;
        this.m.setMaxCount(i2);
    }

    public void M() {
        this.f58655h.setOnTouchListener(new g());
    }

    public final void O() {
        if (this.m.getItemLength() > 0) {
            this.o.setEnabled(true);
        } else {
            this.o.setEnabled(false);
        }
    }

    @Override // d.a.n0.g1.a.c.c.b
    public void c(View view, d.a.m0.s.f.a aVar) {
        if (aVar == null) {
            return;
        }
        this.m.h(aVar);
    }

    public void d() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.d(this.f58652e.getPageContext());
        }
    }

    public void e() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.e();
        }
    }

    public void q(d.a.m0.s.f.a aVar) {
        if (aVar != null) {
            this.m.e(aVar);
            K(this.m.getItemLength());
            O();
        }
    }

    public final void r() {
        int dimensionPixelSize = this.f58652e.getResources().getDimensionPixelSize(R.dimen.ds80) + this.f58652e.getResources().getDimensionPixelSize(R.dimen.ds16) + this.f58652e.getResources().getDimensionPixelSize(R.dimen.ds16);
        View view = new View(this.f58652e.getPageContext().getPageActivity());
        this.p = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.p.setEnabled(false);
        this.f58655h.addFooterView(this.p);
    }

    public void s() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f58652e.getLayoutMode().k(skinType == 1);
        this.f58652e.getLayoutMode().j(this.f58654g);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.y, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
        this.f58653f.onChangeSkinType(this.f58652e.getPageContext(), skinType);
        this.j.f(this.f58652e.getPageContext(), skinType);
        SkinManager.setBackgroundResource(this.p, R.drawable.invite_friend_list_item_bg_color);
        this.p.setEnabled(false);
    }

    public String t() {
        return this.m.g();
    }

    public int u() {
        return this.q;
    }

    public int v() {
        return this.o.getId();
    }

    public View w() {
        return this.f58654g;
    }

    public String x() {
        Editable text = this.v.getText();
        return text != null ? text.toString() : "";
    }

    public final void y() {
        InviteFriendListActivity inviteFriendListActivity = this.f58652e;
        if (inviteFriendListActivity != null) {
            inviteFriendListActivity.refreshWithCurrentData();
        }
    }

    public void z() {
        l.x(this.f58652e.getPageContext().getPageActivity(), this.v);
    }
}
