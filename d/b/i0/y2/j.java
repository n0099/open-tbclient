package d.b.i0.y2;

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
import d.b.h0.r.f0.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class j extends d.b.b.a.d<SignAllForumActivity> {
    public static int o;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f62655a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f62656b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f62657c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f62658d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f62659e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f62660f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.g f62661g;

    /* renamed from: h  reason: collision with root package name */
    public g f62662h;
    public c i;
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
            j.this.f62655a.finish();
        }
    }

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f62661g = null;
        this.f62655a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f62657c = (RelativeLayout) this.f62655a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f62655a.findViewById(R.id.view_navigation_bar);
        this.f62656b = navigationBar;
        navigationBar.setCenterTextTitle(this.f62655a.getPageContext().getString(R.string.signallforum));
        this.f62656b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f62656b.showBottomLine();
        BdListView bdListView = (BdListView) this.f62655a.findViewById(R.id.signallforum_list);
        this.f62660f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(signAllForumActivity.getPageContext());
        this.f62661g = gVar;
        this.f62660f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f62655a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f62660f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f62655a.getPageContext().getPageActivity());
        this.f62658d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f62659e = progressBar;
        progressBar.setOnClickListener(this.f62655a);
        this.f62660f.addHeaderView(this.f62658d);
        this.f62658d.setVisibility(8);
        this.j = (RelativeLayout) this.f62658d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f62658d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f62658d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f62658d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f62655a);
        g gVar2 = new g(this.f62655a, null);
        this.f62662h = gVar2;
        this.f62660f.setAdapter((ListAdapter) gVar2);
        this.f62660f.setOnScrollListener(this.f62662h);
    }

    public void e() {
        this.f62660f.A(0L);
    }

    public final void f() {
        c cVar = this.i;
        if (cVar == null) {
            return;
        }
        this.f62658d.setHasPrivilege(cVar.B());
        this.f62658d.setmCurrentStatus(this.i.q());
        TextView message1 = this.f62658d.getMessage1();
        SpannableString spannableString = new SpannableString(this.i.v() + this.i.t() + this.i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f62658d.getMessage2().setText(this.i.w());
        this.k.setText(this.i.h());
        if (TextUtils.isEmpty(this.i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.i.g());
        }
        this.f62658d.setVisibility(0);
        if (!this.i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g h() {
        return this.f62662h;
    }

    public c i() {
        return this.i;
    }

    public LinearLayout k() {
        return this.m;
    }

    public BdListView l() {
        return this.f62660f;
    }

    public ProgressBar m() {
        return this.f62659e;
    }

    public SignAllForumProgressView n() {
        return this.f62658d;
    }

    public RelativeLayout o() {
        return this.f62657c;
    }

    public void onChangeSkinType(int i) {
        this.f62655a.getLayoutMode().k(i == 1);
        this.f62655a.getLayoutMode().j(this.f62657c);
        this.f62655a.getLayoutMode().j(this.n);
        this.f62655a.getLayoutMode().j(this.f62658d);
        SkinManager.setBackgroundColor(this.f62657c, R.color.CAM_X0201);
        this.f62656b.onChangeSkinType(getPageContext(), i);
        SignAllForumProgressView signAllForumProgressView = this.f62658d;
        if (signAllForumProgressView != null) {
            signAllForumProgressView.k();
        }
        this.f62661g.I(i);
        this.f62662h.notifyDataSetChanged();
    }

    public void q(c cVar, boolean z) {
        if (cVar == null) {
            return;
        }
        this.i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f62662h.h(this.i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.i.y();
        if (!StringUtils.isNull(y)) {
            this.f62658d.l(this.f62655a, y, this.i.z());
            return;
        }
        this.f62658d.i();
    }

    public void r(f.g gVar) {
        this.f62661g.b(gVar);
    }

    public void s(int i) {
        this.f62660f.setSelection(i);
    }

    public void u(AdapterView.OnItemClickListener onItemClickListener) {
        this.f62660f.setOnItemClickListener(onItemClickListener);
    }

    public void v() {
        this.f62660f.F();
    }
}
