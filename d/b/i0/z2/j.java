package d.b.i0.z2;

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
/* loaded from: classes4.dex */
public class j extends d.b.c.a.d<SignAllForumActivity> {
    public static int o;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f64316a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f64317b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f64318c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f64319d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f64320e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f64321f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.g f64322g;

    /* renamed from: h  reason: collision with root package name */
    public g f64323h;
    public c i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.f64316a.finish();
        }
    }

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f64322g = null;
        this.f64316a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f64318c = (RelativeLayout) this.f64316a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f64316a.findViewById(R.id.view_navigation_bar);
        this.f64317b = navigationBar;
        navigationBar.setCenterTextTitle(this.f64316a.getPageContext().getString(R.string.signallforum));
        this.f64317b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f64317b.showBottomLine();
        BdListView bdListView = (BdListView) this.f64316a.findViewById(R.id.signallforum_list);
        this.f64321f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(signAllForumActivity.getPageContext());
        this.f64322g = gVar;
        this.f64321f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f64316a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f64321f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f64316a.getPageContext().getPageActivity());
        this.f64319d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f64320e = progressBar;
        progressBar.setOnClickListener(this.f64316a);
        this.f64321f.addHeaderView(this.f64319d);
        this.f64319d.setVisibility(8);
        this.j = (RelativeLayout) this.f64319d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f64319d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f64319d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f64319d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f64316a);
        g gVar2 = new g(this.f64316a, null);
        this.f64323h = gVar2;
        this.f64321f.setAdapter((ListAdapter) gVar2);
        this.f64321f.setOnScrollListener(this.f64323h);
    }

    public void e() {
        this.f64321f.A(0L);
    }

    public final void f() {
        c cVar = this.i;
        if (cVar == null) {
            return;
        }
        this.f64319d.setHasPrivilege(cVar.B());
        this.f64319d.setmCurrentStatus(this.i.q());
        TextView message1 = this.f64319d.getMessage1();
        SpannableString spannableString = new SpannableString(this.i.v() + this.i.t() + this.i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f64319d.getMessage2().setText(this.i.w());
        this.k.setText(this.i.h());
        if (TextUtils.isEmpty(this.i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.i.g());
        }
        this.f64319d.setVisibility(0);
        if (!this.i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g h() {
        return this.f64323h;
    }

    public c i() {
        return this.i;
    }

    public LinearLayout k() {
        return this.m;
    }

    public BdListView l() {
        return this.f64321f;
    }

    public ProgressBar m() {
        return this.f64320e;
    }

    public SignAllForumProgressView n() {
        return this.f64319d;
    }

    public RelativeLayout o() {
        return this.f64318c;
    }

    public void onChangeSkinType(int i) {
        this.f64316a.getLayoutMode().k(i == 1);
        this.f64316a.getLayoutMode().j(this.f64318c);
        this.f64316a.getLayoutMode().j(this.n);
        this.f64316a.getLayoutMode().j(this.f64319d);
        SkinManager.setBackgroundColor(this.f64318c, R.color.CAM_X0201);
        this.f64317b.onChangeSkinType(getPageContext(), i);
        SignAllForumProgressView signAllForumProgressView = this.f64319d;
        if (signAllForumProgressView != null) {
            signAllForumProgressView.k();
        }
        this.f64322g.I(i);
        this.f64323h.notifyDataSetChanged();
    }

    public void q(c cVar, boolean z) {
        if (cVar == null) {
            return;
        }
        this.i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f64323h.h(this.i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.i.y();
        if (!StringUtils.isNull(y)) {
            this.f64319d.l(this.f64316a, y, this.i.z());
            return;
        }
        this.f64319d.i();
    }

    public void r(f.g gVar) {
        this.f64322g.b(gVar);
    }

    public void s(int i) {
        this.f64321f.setSelection(i);
    }

    public void u(AdapterView.OnItemClickListener onItemClickListener) {
        this.f64321f.setOnItemClickListener(onItemClickListener);
    }

    public void v() {
        this.f64321f.F();
    }
}
