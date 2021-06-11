package d.a.n0.a3;

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
import d.a.m0.r.f0.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class j extends d.a.c.a.d<SignAllForumActivity> {
    public static int o;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f54918a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f54919b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f54920c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f54921d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f54922e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f54923f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.g f54924g;

    /* renamed from: h  reason: collision with root package name */
    public g f54925h;

    /* renamed from: i  reason: collision with root package name */
    public c f54926i;
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
            j.this.f54918a.finish();
        }
    }

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f54924g = null;
        this.f54918a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f54920c = (RelativeLayout) this.f54918a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f54918a.findViewById(R.id.view_navigation_bar);
        this.f54919b = navigationBar;
        navigationBar.setCenterTextTitle(this.f54918a.getPageContext().getString(R.string.signallforum));
        this.f54919b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f54919b.showBottomLine();
        BdListView bdListView = (BdListView) this.f54918a.findViewById(R.id.signallforum_list);
        this.f54923f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(signAllForumActivity.getPageContext());
        this.f54924g = gVar;
        this.f54923f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f54918a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f54923f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f54918a.getPageContext().getPageActivity());
        this.f54921d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f54922e = progressBar;
        progressBar.setOnClickListener(this.f54918a);
        this.f54923f.addHeaderView(this.f54921d);
        this.f54921d.setVisibility(8);
        this.j = (RelativeLayout) this.f54921d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f54921d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f54921d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f54921d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f54918a);
        g gVar2 = new g(this.f54918a, null);
        this.f54925h = gVar2;
        this.f54923f.setAdapter((ListAdapter) gVar2);
        this.f54923f.setOnScrollListener(this.f54925h);
    }

    public void e() {
        this.f54923f.A(0L);
    }

    public final void f() {
        c cVar = this.f54926i;
        if (cVar == null) {
            return;
        }
        this.f54921d.setHasPrivilege(cVar.B());
        this.f54921d.setmCurrentStatus(this.f54926i.q());
        TextView message1 = this.f54921d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f54926i.v() + this.f54926i.t() + this.f54926i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f54926i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f54926i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f54921d.getMessage2().setText(this.f54926i.w());
        this.k.setText(this.f54926i.h());
        if (TextUtils.isEmpty(this.f54926i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f54926i.g());
        }
        this.f54921d.setVisibility(0);
        if (!this.f54926i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g h() {
        return this.f54925h;
    }

    public c i() {
        return this.f54926i;
    }

    public LinearLayout k() {
        return this.m;
    }

    public BdListView l() {
        return this.f54923f;
    }

    public ProgressBar m() {
        return this.f54922e;
    }

    public SignAllForumProgressView n() {
        return this.f54921d;
    }

    public RelativeLayout o() {
        return this.f54920c;
    }

    public void onChangeSkinType(int i2) {
        this.f54918a.getLayoutMode().k(i2 == 1);
        this.f54918a.getLayoutMode().j(this.f54920c);
        this.f54918a.getLayoutMode().j(this.n);
        this.f54918a.getLayoutMode().j(this.f54921d);
        SkinManager.setBackgroundColor(this.f54920c, R.color.CAM_X0201);
        this.f54919b.onChangeSkinType(getPageContext(), i2);
        SignAllForumProgressView signAllForumProgressView = this.f54921d;
        if (signAllForumProgressView != null) {
            signAllForumProgressView.k();
        }
        this.f54924g.I(i2);
        this.f54925h.notifyDataSetChanged();
    }

    public void p(c cVar, boolean z) {
        if (cVar == null) {
            return;
        }
        this.f54926i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f54925h.h(this.f54926i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f54926i.y();
        if (!StringUtils.isNull(y)) {
            this.f54921d.l(this.f54918a, y, this.f54926i.z());
            return;
        }
        this.f54921d.i();
    }

    public void q(f.g gVar) {
        this.f54924g.a(gVar);
    }

    public void r(int i2) {
        this.f54923f.setSelection(i2);
    }

    public void s(AdapterView.OnItemClickListener onItemClickListener) {
        this.f54923f.setOnItemClickListener(onItemClickListener);
    }

    public void t() {
        this.f54923f.F();
    }
}
