package d.b.j0.z2;

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
import d.b.i0.r.f0.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class j extends d.b.c.a.d<SignAllForumActivity> {
    public static int o;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f64737a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f64738b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f64739c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f64740d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f64741e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f64742f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.f0.g f64743g;

    /* renamed from: h  reason: collision with root package name */
    public g f64744h;
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
            j.this.f64737a.finish();
        }
    }

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f64743g = null;
        this.f64737a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f64739c = (RelativeLayout) this.f64737a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f64737a.findViewById(R.id.view_navigation_bar);
        this.f64738b = navigationBar;
        navigationBar.setCenterTextTitle(this.f64737a.getPageContext().getString(R.string.signallforum));
        this.f64738b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f64738b.showBottomLine();
        BdListView bdListView = (BdListView) this.f64737a.findViewById(R.id.signallforum_list);
        this.f64742f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(signAllForumActivity.getPageContext());
        this.f64743g = gVar;
        this.f64742f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f64737a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f64742f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f64737a.getPageContext().getPageActivity());
        this.f64740d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f64741e = progressBar;
        progressBar.setOnClickListener(this.f64737a);
        this.f64742f.addHeaderView(this.f64740d);
        this.f64740d.setVisibility(8);
        this.j = (RelativeLayout) this.f64740d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f64740d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f64740d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f64740d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f64737a);
        g gVar2 = new g(this.f64737a, null);
        this.f64744h = gVar2;
        this.f64742f.setAdapter((ListAdapter) gVar2);
        this.f64742f.setOnScrollListener(this.f64744h);
    }

    public void e() {
        this.f64742f.A(0L);
    }

    public final void f() {
        c cVar = this.i;
        if (cVar == null) {
            return;
        }
        this.f64740d.setHasPrivilege(cVar.B());
        this.f64740d.setmCurrentStatus(this.i.q());
        TextView message1 = this.f64740d.getMessage1();
        SpannableString spannableString = new SpannableString(this.i.v() + this.i.t() + this.i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f64740d.getMessage2().setText(this.i.w());
        this.k.setText(this.i.h());
        if (TextUtils.isEmpty(this.i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.i.g());
        }
        this.f64740d.setVisibility(0);
        if (!this.i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g h() {
        return this.f64744h;
    }

    public c i() {
        return this.i;
    }

    public LinearLayout k() {
        return this.m;
    }

    public BdListView l() {
        return this.f64742f;
    }

    public ProgressBar m() {
        return this.f64741e;
    }

    public SignAllForumProgressView n() {
        return this.f64740d;
    }

    public RelativeLayout o() {
        return this.f64739c;
    }

    public void onChangeSkinType(int i) {
        this.f64737a.getLayoutMode().k(i == 1);
        this.f64737a.getLayoutMode().j(this.f64739c);
        this.f64737a.getLayoutMode().j(this.n);
        this.f64737a.getLayoutMode().j(this.f64740d);
        SkinManager.setBackgroundColor(this.f64739c, R.color.CAM_X0201);
        this.f64738b.onChangeSkinType(getPageContext(), i);
        SignAllForumProgressView signAllForumProgressView = this.f64740d;
        if (signAllForumProgressView != null) {
            signAllForumProgressView.k();
        }
        this.f64743g.I(i);
        this.f64744h.notifyDataSetChanged();
    }

    public void q(c cVar, boolean z) {
        if (cVar == null) {
            return;
        }
        this.i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f64744h.h(this.i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.i.y();
        if (!StringUtils.isNull(y)) {
            this.f64740d.l(this.f64737a, y, this.i.z());
            return;
        }
        this.f64740d.i();
    }

    public void r(f.g gVar) {
        this.f64743g.b(gVar);
    }

    public void s(int i) {
        this.f64742f.setSelection(i);
    }

    public void u(AdapterView.OnItemClickListener onItemClickListener) {
        this.f64742f.setOnItemClickListener(onItemClickListener);
    }

    public void v() {
        this.f64742f.F();
    }
}
