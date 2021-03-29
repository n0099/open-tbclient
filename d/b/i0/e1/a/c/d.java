package d.b.i0.e1.a.c;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.e1.a.c.c;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends d.b.b.a.d<InviteFriendListActivity> implements c.b {

    /* renamed from: e  reason: collision with root package name */
    public final InviteFriendListActivity f54328e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f54329f;

    /* renamed from: g  reason: collision with root package name */
    public View f54330g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f54331h;
    public d.b.i0.e1.a.c.c i;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.f54328e.getPageContext().getPageActivity())));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements InviteFriendCandidateList.b {
        public b() {
        }

        @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.b
        public void a(View view, Object obj) {
            if (obj != null) {
                if (obj instanceof TbCheckBox.c) {
                    ((TbCheckBox.c) obj).setChecked(false);
                }
                View findViewWithTag = d.this.f54331h.findViewWithTag(obj);
                if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                    ((TbCheckBox) findViewWithTag).setChecked(false);
                } else if (obj instanceof d.b.h0.s.f.a) {
                    d.this.L((d.b.h0.s.f.a) obj);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.t != null && d.this.t.getVisibility() == 0) {
                d.this.E();
                return;
            }
            l.w(d.this.f54328e.getPageContext().getPageActivity(), d.this.v);
            d.this.f54328e.finish();
        }
    }

    /* renamed from: d.b.i0.e1.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1231d implements View.OnClickListener {
        public View$OnClickListenerC1231d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.s.setVisibility(8);
            d.this.u.setVisibility(8);
            d.this.t.setVisibility(0);
            d.this.v.requestFocus();
            l.J(d.this.f54328e.getPageContext().getPageActivity(), d.this.v);
        }
    }

    /* loaded from: classes3.dex */
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
            d.this.A();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.v.getText().clear();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            d.this.B();
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements TbCheckBox.b {
        public h() {
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            d.this.B();
            if (obj == null || !(obj instanceof d.b.h0.s.f.a)) {
                return;
            }
            if (z) {
                if (d.this.w() <= d.this.m.getItemLength()) {
                    d.this.f54328e.showToast(String.format(d.this.f54328e.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.q)));
                    tbCheckBox.setChecked(false);
                    ((d.b.h0.s.f.a) obj).setChecked(false);
                    return;
                }
                d.this.r((d.b.h0.s.f.a) obj);
                return;
            }
            d.this.L((d.b.h0.s.f.a) obj);
        }
    }

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.q = 0;
        this.f54328e = inviteFriendListActivity;
        this.r = z;
        G();
    }

    public final void A() {
        InviteFriendListActivity inviteFriendListActivity = this.f54328e;
        if (inviteFriendListActivity != null) {
            inviteFriendListActivity.refreshWithCurrentData();
        }
    }

    public void B() {
        l.w(this.f54328e.getPageContext().getPageActivity(), this.v);
    }

    public void E() {
        l.w(this.f54328e.getPageContext().getPageActivity(), this.v);
        this.t.setVisibility(8);
        this.s.setVisibility(0);
        this.u.setVisibility(0);
        this.v.getText().clear();
    }

    public final void F() {
        NavigationBar navigationBar = (NavigationBar) this.f54330g.findViewById(R.id.view_navigation_bar);
        this.f54329f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
        if (this.r) {
            this.s = this.f54329f.setTitleText(R.string.invite_contact_title);
        } else {
            this.s = this.f54329f.setTitleText(R.string.invite_friend);
        }
        View addCustomView = this.f54329f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View$OnClickListenerC1231d());
        this.u = addCustomView;
        this.y = (ImageView) addCustomView.findViewById(R.id.new_friend_search);
        View addCustomView2 = this.f54329f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
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

    public final void G() {
        this.f54328e.setContentView(R.layout.invite_friend_list);
        this.f54330g = this.f54328e.findViewById(R.id.root_view);
        F();
        BdListView bdListView = (BdListView) this.f54330g.findViewById(R.id.friend_list);
        this.f54331h = bdListView;
        bdListView.setOnItemClickListener(this.f54328e);
        if (this.r) {
            this.j = NoDataViewFactory.a(this.f54328e.getPageContext().getPageActivity(), this.f54330g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f14031a), NoDataViewFactory.e.b(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.j = NoDataViewFactory.a(this.f54328e.getPageContext().getPageActivity(), this.f54330g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.f14031a), NoDataViewFactory.e.b(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.c.a(new NoDataViewFactory.b(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new a())));
        }
        this.k = (ProgressBar) this.f54330g.findViewById(R.id.progress);
        InviteFriendCandidateList inviteFriendCandidateList = (InviteFriendCandidateList) this.f54330g.findViewById(R.id.candidate_list);
        this.m = inviteFriendCandidateList;
        inviteFriendCandidateList.n(new b());
        this.n = (LinearLayout) this.f54330g.findViewById(R.id.invite_candidate);
        this.l = this.f54330g.findViewById(R.id.invite_candidate_border);
        if (this.r) {
            this.n.setVisibility(8);
            this.l.setVisibility(8);
        }
        s();
        Button button = (Button) this.f54330g.findViewById(R.id.button_send);
        this.o = button;
        button.setOnClickListener(this.f54328e);
        u();
        P();
        M(0);
    }

    public boolean I() {
        View view = this.t;
        return view != null && view.getVisibility() == 0;
    }

    public void J() {
        this.v.removeTextChangedListener(this.x);
    }

    public void K(List<d.b.h0.s.f.a> list, boolean z) {
        if (this.i == null) {
            d.b.i0.e1.a.c.c cVar = new d.b.i0.e1.a.c.c(this.f54328e, this.r);
            this.i = cVar;
            cVar.f(this);
            this.i.d(new h());
            this.f54331h.setAdapter((ListAdapter) this.i);
        }
        if (!z && list.isEmpty()) {
            this.j.setVisibility(0);
            this.f54331h.setVisibility(8);
            if (this.r) {
                return;
            }
            this.n.setVisibility(8);
            return;
        }
        this.j.setVisibility(8);
        this.f54331h.setVisibility(0);
        this.i.e(list);
        this.i.notifyDataSetChanged();
        if (this.r) {
            return;
        }
        this.n.setVisibility(0);
    }

    public void L(d.b.h0.s.f.a aVar) {
        if (aVar != null) {
            this.m.l(aVar);
            M(this.m.getItemLength());
            Q();
        }
    }

    public final void M(int i) {
        this.o.setText(String.format(this.f54328e.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public void O(int i) {
        this.q = i;
        this.m.setMaxCount(i);
    }

    public void P() {
        this.f54331h.setOnTouchListener(new g());
    }

    public final void Q() {
        if (this.m.getItemLength() > 0) {
            this.o.setEnabled(true);
        } else {
            this.o.setEnabled(false);
        }
    }

    @Override // d.b.i0.e1.a.c.c.b
    public void c(View view, d.b.h0.s.f.a aVar) {
        if (aVar == null) {
            return;
        }
        this.m.h(aVar);
    }

    public void d() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.d(this.f54328e.getPageContext());
        }
    }

    public void e() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.e();
        }
    }

    public void r(d.b.h0.s.f.a aVar) {
        if (aVar != null) {
            this.m.e(aVar);
            M(this.m.getItemLength());
            Q();
        }
    }

    public final void s() {
        int dimensionPixelSize = this.f54328e.getResources().getDimensionPixelSize(R.dimen.ds80) + this.f54328e.getResources().getDimensionPixelSize(R.dimen.ds16) + this.f54328e.getResources().getDimensionPixelSize(R.dimen.ds16);
        View view = new View(this.f54328e.getPageContext().getPageActivity());
        this.p = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.p.setEnabled(false);
        this.f54331h.addFooterView(this.p);
    }

    public void u() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f54328e.getLayoutMode().k(skinType == 1);
        this.f54328e.getLayoutMode().j(this.f54330g);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.y, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
        this.f54329f.onChangeSkinType(this.f54328e.getPageContext(), skinType);
        this.j.f(this.f54328e.getPageContext(), skinType);
        SkinManager.setBackgroundResource(this.p, R.drawable.invite_friend_list_item_bg_color);
        this.p.setEnabled(false);
    }

    public String v() {
        return this.m.g();
    }

    public int w() {
        return this.q;
    }

    public int x() {
        return this.o.getId();
    }

    public View y() {
        return this.f54330g;
    }

    public String z() {
        Editable text = this.v.getText();
        return text != null ? text.toString() : "";
    }
}
