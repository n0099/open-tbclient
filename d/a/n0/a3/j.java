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
    public SignAllForumActivity f51241a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f51242b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f51243c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f51244d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f51245e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f51246f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.g f51247g;

    /* renamed from: h  reason: collision with root package name */
    public g f51248h;

    /* renamed from: i  reason: collision with root package name */
    public c f51249i;
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
            j.this.f51241a.finish();
        }
    }

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f51247g = null;
        this.f51241a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f51243c = (RelativeLayout) this.f51241a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f51241a.findViewById(R.id.view_navigation_bar);
        this.f51242b = navigationBar;
        navigationBar.setCenterTextTitle(this.f51241a.getPageContext().getString(R.string.signallforum));
        this.f51242b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f51242b.showBottomLine();
        BdListView bdListView = (BdListView) this.f51241a.findViewById(R.id.signallforum_list);
        this.f51246f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(signAllForumActivity.getPageContext());
        this.f51247g = gVar;
        this.f51246f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f51241a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f51246f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f51241a.getPageContext().getPageActivity());
        this.f51244d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f51245e = progressBar;
        progressBar.setOnClickListener(this.f51241a);
        this.f51246f.addHeaderView(this.f51244d);
        this.f51244d.setVisibility(8);
        this.j = (RelativeLayout) this.f51244d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f51244d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f51244d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f51244d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f51241a);
        g gVar2 = new g(this.f51241a, null);
        this.f51248h = gVar2;
        this.f51246f.setAdapter((ListAdapter) gVar2);
        this.f51246f.setOnScrollListener(this.f51248h);
    }

    public void e() {
        this.f51246f.A(0L);
    }

    public final void f() {
        c cVar = this.f51249i;
        if (cVar == null) {
            return;
        }
        this.f51244d.setHasPrivilege(cVar.B());
        this.f51244d.setmCurrentStatus(this.f51249i.q());
        TextView message1 = this.f51244d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f51249i.v() + this.f51249i.t() + this.f51249i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f51249i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f51249i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f51244d.getMessage2().setText(this.f51249i.w());
        this.k.setText(this.f51249i.h());
        if (TextUtils.isEmpty(this.f51249i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f51249i.g());
        }
        this.f51244d.setVisibility(0);
        if (!this.f51249i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g g() {
        return this.f51248h;
    }

    public c h() {
        return this.f51249i;
    }

    public LinearLayout j() {
        return this.m;
    }

    public BdListView k() {
        return this.f51246f;
    }

    public ProgressBar l() {
        return this.f51245e;
    }

    public SignAllForumProgressView m() {
        return this.f51244d;
    }

    public RelativeLayout n() {
        return this.f51243c;
    }

    public void o(c cVar, boolean z) {
        if (cVar == null) {
            return;
        }
        this.f51249i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f51248h.h(this.f51249i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f51249i.y();
        if (!StringUtils.isNull(y)) {
            this.f51244d.l(this.f51241a, y, this.f51249i.z());
            return;
        }
        this.f51244d.i();
    }

    public void onChangeSkinType(int i2) {
        this.f51241a.getLayoutMode().k(i2 == 1);
        this.f51241a.getLayoutMode().j(this.f51243c);
        this.f51241a.getLayoutMode().j(this.n);
        this.f51241a.getLayoutMode().j(this.f51244d);
        SkinManager.setBackgroundColor(this.f51243c, R.color.CAM_X0201);
        this.f51242b.onChangeSkinType(getPageContext(), i2);
        SignAllForumProgressView signAllForumProgressView = this.f51244d;
        if (signAllForumProgressView != null) {
            signAllForumProgressView.k();
        }
        this.f51247g.I(i2);
        this.f51248h.notifyDataSetChanged();
    }

    public void p(f.g gVar) {
        this.f51247g.a(gVar);
    }

    public void q(int i2) {
        this.f51246f.setSelection(i2);
    }

    public void r(AdapterView.OnItemClickListener onItemClickListener) {
        this.f51246f.setOnItemClickListener(onItemClickListener);
    }

    public void s() {
        this.f51246f.F();
    }
}
