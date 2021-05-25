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
    public BaseFragment f53296a;

    /* renamed from: b  reason: collision with root package name */
    public View f53297b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f53298c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f53299d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f53300e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f53301f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f53302g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f53303h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f53304i;
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
        this.f53296a = baseFragment;
        this.t = onClickListener;
        initUI();
    }

    public void A(boolean z) {
        this.f53300e.setVisibility(z ? 0 : 8);
    }

    public void B(boolean z, boolean z2) {
        this.l.setVisibility(z ? 0 : 8);
        if (z2) {
            this.l.setText(R.string.pb_cancel_good);
            L(this.l, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.l.setText(R.string.commit_good);
        L(this.l, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void F(boolean z, boolean z2) {
        this.f53304i.setVisibility(z ? 0 : 8);
        if (z2) {
            this.f53304i.setText(R.string.pb_cancel_top);
            L(this.f53304i, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.f53304i.setText(R.string.top);
        L(this.f53304i, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void G(boolean z, boolean z2) {
        this.k.setVisibility(z ? 0 : 8);
        if (z2) {
            this.k.setText(R.string.normal_mode);
            L(this.k, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.k.setText(R.string.eyeshield_mode);
        L(this.k, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void H(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
    }

    public void J(boolean z, boolean z2) {
        this.j.setVisibility(z ? 0 : 8);
        if (z2) {
            this.j.setText(R.string.view_reverse);
        } else {
            this.j.setText(R.string.default_sort);
        }
        this.j.setText(R.string.sort_selector);
    }

    public void K(boolean z) {
        this.f53299d.setVisibility(z ? 0 : 8);
    }

    public final void L(TextView textView, int i2) {
        Drawable pureDrawable;
        if (textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = v;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void N(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public void O(boolean z) {
        MaskView.b(this.l, z);
        MaskView.b(this.f53304i, z);
        MaskView.b(this.f53301f, z);
    }

    public TextView d() {
        return this.f53301f;
    }

    public TextView e() {
        return this.r;
    }

    public TextView f() {
        return this.f53302g;
    }

    public TextView g() {
        return this.f53303h;
    }

    public TextView h() {
        return this.n;
    }

    public final void initUI() {
        View inflate = LayoutInflater.from(this.f53296a.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.f53297b = inflate;
        this.f53298c = (FlowLayout) inflate.findViewById(R.id.pb_more_flowlayout);
        EMTextView eMTextView = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_host_only);
        this.n = eMTextView;
        eMTextView.setOnClickListener(this.t);
        EMTextView eMTextView2 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_reversed);
        this.j = eMTextView2;
        eMTextView2.setOnClickListener(this.t);
        EMTextView eMTextView3 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_jump);
        this.f53299d = eMTextView3;
        eMTextView3.setOnClickListener(this.t);
        EMTextView eMTextView4 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_night_style);
        this.k = eMTextView4;
        eMTextView4.setOnClickListener(this.t);
        EMTextView eMTextView5 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_jump_top);
        this.f53300e = eMTextView5;
        eMTextView5.setOnClickListener(this.t);
        EMTextView eMTextView6 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_call_fans);
        this.f53301f = eMTextView6;
        eMTextView6.setOnClickListener(this.t);
        EMTextView eMTextView7 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_report);
        this.m = eMTextView7;
        eMTextView7.setOnClickListener(this.t);
        EMTextView eMTextView8 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_delete);
        this.f53302g = eMTextView8;
        eMTextView8.setOnClickListener(this.t);
        EMTextView eMTextView9 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_forbidden);
        this.f53303h = eMTextView9;
        eMTextView9.setOnClickListener(this.t);
        EMTextView eMTextView10 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_make_top);
        this.f53304i = eMTextView10;
        eMTextView10.setOnClickListener(this.t);
        EMTextView eMTextView11 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_add_good);
        this.l = eMTextView11;
        eMTextView11.setOnClickListener(this.t);
        EMTextView eMTextView12 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_view_item_private);
        this.o = eMTextView12;
        eMTextView12.setOnClickListener(this.t);
        this.q = (TextSizeSeekBar) this.f53297b.findViewById(R.id.pb_more_text_size_seekbar);
        this.p = (LinearLayout) this.f53297b.findViewById(R.id.size_seek_bar_group);
        EMTextView eMTextView13 = (EMTextView) this.f53297b.findViewById(R.id.pb_more_cancel);
        this.r = eMTextView13;
        eMTextView13.setOnClickListener(this.t);
        this.s = this.f53297b.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (s()) {
            return;
        }
        z();
    }

    public TextView j() {
        return this.f53299d;
    }

    public TextView k() {
        return this.f53300e;
    }

    public TextView l() {
        return this.l;
    }

    public TextView m() {
        return this.f53304i;
    }

    public TextView n() {
        return this.k;
    }

    public TextView o() {
        return this.o;
    }

    public TextView p() {
        return this.m;
    }

    public TextView q() {
        return this.j;
    }

    public View r() {
        return this.f53297b;
    }

    public final boolean s() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f53296a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.densityDpi;
        return i2 % 160 == 0 || ((double) ((((float) i2) * 1.0f) / 160.0f)) == 1.5d;
    }

    public void t() {
    }

    public void u() {
        int i2;
        SkinManager.setBackgroundColor(this.f53298c, R.color.CAM_X0204);
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.p);
        d2.m(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
        SkinManager.setViewTextColorSelector(this.r, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f53299d, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f53300e, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f53301f, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f53302g, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f53304i, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f53303h, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.f53296a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (s()) {
            i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i2 = (width - 1005) / 4;
        }
        this.f53298c.setHorizontalSpacing(i2);
        L(this.f53299d, R.drawable.icon_pure_pb_recommend_jump30);
        L(this.m, R.drawable.icon_pure_pb_recommend_report30);
        L(this.f53300e, R.drawable.icon_pure_pb_recommend_initial30);
        L(this.f53301f, R.drawable.icon_pure_pb_recommend_fans30);
        this.f53301f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        L(this.f53302g, this.u ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        L(this.f53303h, R.drawable.icon_pure_pb_recommend_block30);
        L(this.o, R.drawable.icon_pure_pb_recommend_private30);
        L(this.j, R.drawable.icon_pure_pb_recommend_sort30);
        TextSizeSeekBar textSizeSeekBar = this.q;
        if (textSizeSeekBar != null) {
            textSizeSeekBar.e();
        }
    }

    public void v(boolean z) {
        this.f53301f.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z) {
        this.f53302g.setVisibility(z ? 0 : 8);
    }

    public void x(boolean z) {
        this.f53303h.setVisibility(z ? 0 : 8);
    }

    public void y(boolean z, boolean z2) {
        this.n.setVisibility(z ? 0 : 8);
        if (z2) {
            this.n.setText(R.string.group_info_intro_more);
            L(this.n, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.n.setText(R.string.view_host);
        L(this.n, R.drawable.icon_pure_pb_recommend_host30);
    }

    public final void z() {
        this.n.getLayoutParams().width = 201;
        this.j.getLayoutParams().width = 201;
        this.f53299d.getLayoutParams().width = 201;
        this.k.getLayoutParams().width = 201;
        this.f53300e.getLayoutParams().width = 201;
        this.f53301f.getLayoutParams().width = 201;
        this.m.getLayoutParams().width = 201;
        this.f53302g.getLayoutParams().width = 201;
        this.f53303h.getLayoutParams().width = 201;
        this.f53304i.getLayoutParams().width = 201;
        this.l.getLayoutParams().width = 201;
        this.o.getLayoutParams().width = 201;
    }
}
