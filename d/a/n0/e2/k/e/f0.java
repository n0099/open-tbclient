package d.a.n0.e2.k.e;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes5.dex */
public class f0 extends d.a.c.a.d {
    public static final int v = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f56985a;

    /* renamed from: b  reason: collision with root package name */
    public View f56986b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f56987c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f56988d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f56989e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f56990f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f56991g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f56992h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f56993i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public LinearLayout p;
    public TextSizeSeekBar q;
    public EMTextView r;
    public View s;
    public View.OnClickListener t;
    public boolean u;

    public f0(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.m = null;
        this.t = null;
        this.f56985a = baseFragment;
        this.t = onClickListener;
        initUI();
    }

    public final void A() {
        this.n.getLayoutParams().width = 201;
        this.j.getLayoutParams().width = 201;
        this.f56988d.getLayoutParams().width = 201;
        this.k.getLayoutParams().width = 201;
        this.f56989e.getLayoutParams().width = 201;
        this.f56990f.getLayoutParams().width = 201;
        this.m.getLayoutParams().width = 201;
        this.f56991g.getLayoutParams().width = 201;
        this.f56992h.getLayoutParams().width = 201;
        this.f56993i.getLayoutParams().width = 201;
        this.l.getLayoutParams().width = 201;
        this.o.getLayoutParams().width = 201;
    }

    public void B(boolean z) {
        this.f56989e.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.l.setVisibility(z ? 0 : 8);
        if (z2) {
            this.l.setText(R.string.pb_cancel_good);
            M(this.l, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.l.setText(R.string.commit_good);
        M(this.l, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void G(boolean z, boolean z2) {
        this.f56993i.setVisibility(z ? 0 : 8);
        if (z2) {
            this.f56993i.setText(R.string.pb_cancel_top);
            M(this.f56993i, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.f56993i.setText(R.string.top);
        M(this.f56993i, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void H(boolean z, boolean z2) {
        this.k.setVisibility(z ? 0 : 8);
        if (z2) {
            this.k.setText(R.string.normal_mode);
            M(this.k, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.k.setText(R.string.eyeshield_mode);
        M(this.k, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void I(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
    }

    public void J(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.j.setVisibility(z ? 0 : 8);
        if (z2) {
            this.j.setText(R.string.view_reverse);
        } else {
            this.j.setText(R.string.default_sort);
        }
        this.j.setText(R.string.sort_selector);
    }

    public void L(boolean z) {
        this.f56988d.setVisibility(z ? 0 : 8);
    }

    public final void M(TextView textView, int i2) {
        Drawable pureDrawable;
        if (textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = v;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void O(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public void P(boolean z) {
        MaskView.b(this.l, z);
        MaskView.b(this.f56993i, z);
        MaskView.b(this.f56990f, z);
    }

    public TextView d() {
        return this.f56990f;
    }

    public TextView e() {
        return this.r;
    }

    public TextView f() {
        return this.f56991g;
    }

    public TextView h() {
        return this.f56992h;
    }

    public TextView i() {
        return this.n;
    }

    public final void initUI() {
        View inflate = LayoutInflater.from(this.f56985a.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.f56986b = inflate;
        this.f56987c = (FlowLayout) inflate.findViewById(R.id.pb_more_flowlayout);
        EMTextView eMTextView = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_host_only);
        this.n = eMTextView;
        eMTextView.setOnClickListener(this.t);
        EMTextView eMTextView2 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_reversed);
        this.j = eMTextView2;
        eMTextView2.setOnClickListener(this.t);
        EMTextView eMTextView3 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_jump);
        this.f56988d = eMTextView3;
        eMTextView3.setOnClickListener(this.t);
        EMTextView eMTextView4 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_night_style);
        this.k = eMTextView4;
        eMTextView4.setOnClickListener(this.t);
        EMTextView eMTextView5 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_jump_top);
        this.f56989e = eMTextView5;
        eMTextView5.setOnClickListener(this.t);
        EMTextView eMTextView6 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_call_fans);
        this.f56990f = eMTextView6;
        eMTextView6.setOnClickListener(this.t);
        EMTextView eMTextView7 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_report);
        this.m = eMTextView7;
        eMTextView7.setOnClickListener(this.t);
        EMTextView eMTextView8 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_delete);
        this.f56991g = eMTextView8;
        eMTextView8.setOnClickListener(this.t);
        EMTextView eMTextView9 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_forbidden);
        this.f56992h = eMTextView9;
        eMTextView9.setOnClickListener(this.t);
        EMTextView eMTextView10 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_make_top);
        this.f56993i = eMTextView10;
        eMTextView10.setOnClickListener(this.t);
        EMTextView eMTextView11 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_add_good);
        this.l = eMTextView11;
        eMTextView11.setOnClickListener(this.t);
        EMTextView eMTextView12 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_view_item_private);
        this.o = eMTextView12;
        eMTextView12.setOnClickListener(this.t);
        this.q = (TextSizeSeekBar) this.f56986b.findViewById(R.id.pb_more_text_size_seekbar);
        this.p = (LinearLayout) this.f56986b.findViewById(R.id.size_seek_bar_group);
        EMTextView eMTextView13 = (EMTextView) this.f56986b.findViewById(R.id.pb_more_cancel);
        this.r = eMTextView13;
        eMTextView13.setOnClickListener(this.t);
        this.s = this.f56986b.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (t()) {
            return;
        }
        A();
    }

    public TextView k() {
        return this.f56988d;
    }

    public TextView l() {
        return this.f56989e;
    }

    public TextView m() {
        return this.l;
    }

    public TextView n() {
        return this.f56993i;
    }

    public TextView o() {
        return this.k;
    }

    public TextView p() {
        return this.o;
    }

    public TextView q() {
        return this.m;
    }

    public TextView r() {
        return this.j;
    }

    public View s() {
        return this.f56986b;
    }

    public final boolean t() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f56985a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.densityDpi;
        return i2 % 160 == 0 || ((double) ((((float) i2) * 1.0f) / 160.0f)) == 1.5d;
    }

    public void u() {
    }

    public void v() {
        int i2;
        SkinManager.setBackgroundColor(this.f56987c, R.color.CAM_X0204);
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.p);
        d2.m(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
        SkinManager.setViewTextColorSelector(this.r, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f56988d, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f56989e, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f56990f, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f56991g, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f56993i, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f56992h, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.f56985a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (t()) {
            i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i2 = (width - 1005) / 4;
        }
        this.f56987c.setHorizontalSpacing(i2);
        M(this.f56988d, R.drawable.icon_pure_pb_recommend_jump30);
        M(this.m, R.drawable.icon_pure_pb_recommend_report30);
        M(this.f56989e, R.drawable.icon_pure_pb_recommend_initial30);
        M(this.f56990f, R.drawable.icon_pure_pb_recommend_fans30);
        this.f56990f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        M(this.f56991g, this.u ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        M(this.f56992h, R.drawable.icon_pure_pb_recommend_block30);
        M(this.o, R.drawable.icon_pure_pb_recommend_private30);
        M(this.j, R.drawable.icon_pure_pb_recommend_sort30);
        TextSizeSeekBar textSizeSeekBar = this.q;
        if (textSizeSeekBar != null) {
            textSizeSeekBar.e();
        }
    }

    public void w(boolean z) {
        this.f56990f.setVisibility(z ? 0 : 8);
    }

    public void x(boolean z) {
        this.f56991g.setVisibility(z ? 0 : 8);
    }

    public void y(boolean z) {
        this.f56992h.setVisibility(z ? 0 : 8);
    }

    public void z(boolean z, boolean z2) {
        this.n.setVisibility(z ? 0 : 8);
        if (z2) {
            this.n.setText(R.string.group_info_intro_more);
            M(this.n, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.n.setText(R.string.view_host);
        M(this.n, R.drawable.icon_pure_pb_recommend_host30);
    }
}
