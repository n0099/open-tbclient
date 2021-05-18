package d.a.k0.z2;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumProgressView;
import d.a.j0.r.f0.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class j extends d.a.c.a.d<SignAllForumActivity> {
    public static int o;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f63750a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f63751b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f63752c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f63753d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f63754e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f63755f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.f0.g f63756g;

    /* renamed from: h  reason: collision with root package name */
    public g f63757h;

    /* renamed from: i  reason: collision with root package name */
    public c f63758i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.f63750a.finish();
        }
    }

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f63756g = null;
        this.f63750a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f63752c = (RelativeLayout) this.f63750a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f63750a.findViewById(R.id.view_navigation_bar);
        this.f63751b = navigationBar;
        navigationBar.setCenterTextTitle(this.f63750a.getPageContext().getString(R.string.signallforum));
        this.f63751b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f63751b.showBottomLine();
        BdListView bdListView = (BdListView) this.f63750a.findViewById(R.id.signallforum_list);
        this.f63755f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.a.j0.r.f0.g gVar = new d.a.j0.r.f0.g(signAllForumActivity.getPageContext());
        this.f63756g = gVar;
        this.f63755f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f63750a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f63755f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f63750a.getPageContext().getPageActivity());
        this.f63753d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f63754e = progressBar;
        progressBar.setOnClickListener(this.f63750a);
        this.f63755f.addHeaderView(this.f63753d);
        this.f63753d.setVisibility(8);
        this.j = (RelativeLayout) this.f63753d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f63753d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f63753d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f63753d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f63750a);
        g gVar2 = new g(this.f63750a, null);
        this.f63757h = gVar2;
        this.f63755f.setAdapter((ListAdapter) gVar2);
        this.f63755f.setOnScrollListener(this.f63757h);
    }

    public void e() {
        this.f63755f.A(0L);
    }

    public final void f() {
        c cVar = this.f63758i;
        if (cVar == null) {
            return;
        }
        this.f63753d.setHasPrivilege(cVar.B());
        this.f63753d.setmCurrentStatus(this.f63758i.q());
        TextView message1 = this.f63753d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f63758i.v() + this.f63758i.t() + this.f63758i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f63758i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f63758i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f63753d.getMessage2().setText(this.f63758i.w());
        this.k.setText(this.f63758i.h());
        if (TextUtils.isEmpty(this.f63758i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f63758i.g());
        }
        this.f63753d.setVisibility(0);
        if (!this.f63758i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g g() {
        return this.f63757h;
    }

    public c h() {
        return this.f63758i;
    }

    public LinearLayout j() {
        return this.m;
    }

    public BdListView k() {
        return this.f63755f;
    }

    public ProgressBar l() {
        return this.f63754e;
    }

    public SignAllForumProgressView m() {
        return this.f63753d;
    }

    public RelativeLayout n() {
        return this.f63752c;
    }

    public void o(c cVar, boolean z) {
        if (cVar == null) {
            return;
        }
        this.f63758i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f63757h.h(this.f63758i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f63758i.y();
        if (!StringUtils.isNull(y)) {
            this.f63753d.l(this.f63750a, y, this.f63758i.z());
            return;
        }
        this.f63753d.i();
    }

    public void onChangeSkinType(int i2) {
        this.f63750a.getLayoutMode().k(i2 == 1);
        this.f63750a.getLayoutMode().j(this.f63752c);
        this.f63750a.getLayoutMode().j(this.n);
        this.f63750a.getLayoutMode().j(this.f63753d);
        SkinManager.setBackgroundColor(this.f63752c, R.color.CAM_X0201);
        this.f63751b.onChangeSkinType(getPageContext(), i2);
        SignAllForumProgressView signAllForumProgressView = this.f63753d;
        if (signAllForumProgressView != null) {
            signAllForumProgressView.k();
        }
        this.f63756g.I(i2);
        this.f63757h.notifyDataSetChanged();
    }

    public void p(f.g gVar) {
        this.f63756g.a(gVar);
    }

    public void q(int i2) {
        this.f63755f.setSelection(i2);
    }

    public void r(AdapterView.OnItemClickListener onItemClickListener) {
        this.f63755f.setOnItemClickListener(onItemClickListener);
    }

    public void s() {
        this.f63755f.F();
    }
}
