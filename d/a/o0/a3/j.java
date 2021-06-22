package d.a.o0.a3;

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
import d.a.n0.r.f0.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class j extends d.a.c.a.d<SignAllForumActivity> {
    public static int o;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f55043a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f55044b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f55045c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f55046d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f55047e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f55048f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.f0.g f55049g;

    /* renamed from: h  reason: collision with root package name */
    public g f55050h;

    /* renamed from: i  reason: collision with root package name */
    public c f55051i;
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
            j.this.f55043a.finish();
        }
    }

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f55049g = null;
        this.f55043a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f55045c = (RelativeLayout) this.f55043a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f55043a.findViewById(R.id.view_navigation_bar);
        this.f55044b = navigationBar;
        navigationBar.setCenterTextTitle(this.f55043a.getPageContext().getString(R.string.signallforum));
        this.f55044b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f55044b.showBottomLine();
        BdListView bdListView = (BdListView) this.f55043a.findViewById(R.id.signallforum_list);
        this.f55048f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.a.n0.r.f0.g gVar = new d.a.n0.r.f0.g(signAllForumActivity.getPageContext());
        this.f55049g = gVar;
        this.f55048f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f55043a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f55048f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f55043a.getPageContext().getPageActivity());
        this.f55046d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f55047e = progressBar;
        progressBar.setOnClickListener(this.f55043a);
        this.f55048f.addHeaderView(this.f55046d);
        this.f55046d.setVisibility(8);
        this.j = (RelativeLayout) this.f55046d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f55046d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f55046d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f55046d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f55043a);
        g gVar2 = new g(this.f55043a, null);
        this.f55050h = gVar2;
        this.f55048f.setAdapter((ListAdapter) gVar2);
        this.f55048f.setOnScrollListener(this.f55050h);
    }

    public void e() {
        this.f55048f.A(0L);
    }

    public final void f() {
        c cVar = this.f55051i;
        if (cVar == null) {
            return;
        }
        this.f55046d.setHasPrivilege(cVar.B());
        this.f55046d.setmCurrentStatus(this.f55051i.q());
        TextView message1 = this.f55046d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f55051i.v() + this.f55051i.t() + this.f55051i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f55051i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f55051i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f55046d.getMessage2().setText(this.f55051i.w());
        this.k.setText(this.f55051i.h());
        if (TextUtils.isEmpty(this.f55051i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f55051i.g());
        }
        this.f55046d.setVisibility(0);
        if (!this.f55051i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g h() {
        return this.f55050h;
    }

    public c i() {
        return this.f55051i;
    }

    public LinearLayout k() {
        return this.m;
    }

    public BdListView l() {
        return this.f55048f;
    }

    public ProgressBar m() {
        return this.f55047e;
    }

    public SignAllForumProgressView n() {
        return this.f55046d;
    }

    public RelativeLayout o() {
        return this.f55045c;
    }

    public void onChangeSkinType(int i2) {
        this.f55043a.getLayoutMode().k(i2 == 1);
        this.f55043a.getLayoutMode().j(this.f55045c);
        this.f55043a.getLayoutMode().j(this.n);
        this.f55043a.getLayoutMode().j(this.f55046d);
        SkinManager.setBackgroundColor(this.f55045c, R.color.CAM_X0201);
        this.f55044b.onChangeSkinType(getPageContext(), i2);
        SignAllForumProgressView signAllForumProgressView = this.f55046d;
        if (signAllForumProgressView != null) {
            signAllForumProgressView.k();
        }
        this.f55049g.I(i2);
        this.f55050h.notifyDataSetChanged();
    }

    public void p(c cVar, boolean z) {
        if (cVar == null) {
            return;
        }
        this.f55051i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f55050h.h(this.f55051i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f55051i.y();
        if (!StringUtils.isNull(y)) {
            this.f55046d.l(this.f55043a, y, this.f55051i.z());
            return;
        }
        this.f55046d.i();
    }

    public void q(f.g gVar) {
        this.f55049g.a(gVar);
    }

    public void r(int i2) {
        this.f55048f.setSelection(i2);
    }

    public void s(AdapterView.OnItemClickListener onItemClickListener) {
        this.f55048f.setOnItemClickListener(onItemClickListener);
    }

    public void t() {
        this.f55048f.F();
    }
}
