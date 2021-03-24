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
    public SignAllForumActivity f62654a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f62655b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f62656c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f62657d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f62658e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f62659f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.g f62660g;

    /* renamed from: h  reason: collision with root package name */
    public g f62661h;
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
            j.this.f62654a.finish();
        }
    }

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f62660g = null;
        this.f62654a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f62656c = (RelativeLayout) this.f62654a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f62654a.findViewById(R.id.view_navigation_bar);
        this.f62655b = navigationBar;
        navigationBar.setCenterTextTitle(this.f62654a.getPageContext().getString(R.string.signallforum));
        this.f62655b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f62655b.showBottomLine();
        BdListView bdListView = (BdListView) this.f62654a.findViewById(R.id.signallforum_list);
        this.f62659f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(signAllForumActivity.getPageContext());
        this.f62660g = gVar;
        this.f62659f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f62654a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f62659f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f62654a.getPageContext().getPageActivity());
        this.f62657d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f62658e = progressBar;
        progressBar.setOnClickListener(this.f62654a);
        this.f62659f.addHeaderView(this.f62657d);
        this.f62657d.setVisibility(8);
        this.j = (RelativeLayout) this.f62657d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f62657d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f62657d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f62657d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f62654a);
        g gVar2 = new g(this.f62654a, null);
        this.f62661h = gVar2;
        this.f62659f.setAdapter((ListAdapter) gVar2);
        this.f62659f.setOnScrollListener(this.f62661h);
    }

    public void e() {
        this.f62659f.A(0L);
    }

    public final void f() {
        c cVar = this.i;
        if (cVar == null) {
            return;
        }
        this.f62657d.setHasPrivilege(cVar.B());
        this.f62657d.setmCurrentStatus(this.i.q());
        TextView message1 = this.f62657d.getMessage1();
        SpannableString spannableString = new SpannableString(this.i.v() + this.i.t() + this.i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f62657d.getMessage2().setText(this.i.w());
        this.k.setText(this.i.h());
        if (TextUtils.isEmpty(this.i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.i.g());
        }
        this.f62657d.setVisibility(0);
        if (!this.i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g h() {
        return this.f62661h;
    }

    public c i() {
        return this.i;
    }

    public LinearLayout k() {
        return this.m;
    }

    public BdListView l() {
        return this.f62659f;
    }

    public ProgressBar m() {
        return this.f62658e;
    }

    public SignAllForumProgressView n() {
        return this.f62657d;
    }

    public RelativeLayout o() {
        return this.f62656c;
    }

    public void onChangeSkinType(int i) {
        this.f62654a.getLayoutMode().k(i == 1);
        this.f62654a.getLayoutMode().j(this.f62656c);
        this.f62654a.getLayoutMode().j(this.n);
        this.f62654a.getLayoutMode().j(this.f62657d);
        SkinManager.setBackgroundColor(this.f62656c, R.color.CAM_X0201);
        this.f62655b.onChangeSkinType(getPageContext(), i);
        SignAllForumProgressView signAllForumProgressView = this.f62657d;
        if (signAllForumProgressView != null) {
            signAllForumProgressView.k();
        }
        this.f62660g.I(i);
        this.f62661h.notifyDataSetChanged();
    }

    public void q(c cVar, boolean z) {
        if (cVar == null) {
            return;
        }
        this.i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f62661h.h(this.i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.i.y();
        if (!StringUtils.isNull(y)) {
            this.f62657d.l(this.f62654a, y, this.i.z());
            return;
        }
        this.f62657d.i();
    }

    public void r(f.g gVar) {
        this.f62660g.b(gVar);
    }

    public void s(int i) {
        this.f62659f.setSelection(i);
    }

    public void u(AdapterView.OnItemClickListener onItemClickListener) {
        this.f62659f.setOnItemClickListener(onItemClickListener);
    }

    public void v() {
        this.f62659f.F();
    }
}
