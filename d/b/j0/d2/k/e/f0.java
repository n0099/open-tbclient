package d.b.j0.d2.k.e;

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
/* loaded from: classes3.dex */
public class f0 extends d.b.c.a.d {
    public static final int v = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f54567a;

    /* renamed from: b  reason: collision with root package name */
    public View f54568b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f54569c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f54570d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f54571e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f54572f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f54573g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f54574h;
    public EMTextView i;
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
        this.f54567a = baseFragment;
        this.t = onClickListener;
        initUI();
    }

    public void A(boolean z) {
        this.f54574h.setVisibility(z ? 0 : 8);
    }

    public void B(boolean z, boolean z2) {
        this.n.setVisibility(z ? 0 : 8);
        if (z2) {
            this.n.setText(R.string.group_info_intro_more);
            P(this.n, R.drawable.icon_pure_pb_recommend_all30);
            return;
        }
        this.n.setText(R.string.view_host);
        P(this.n, R.drawable.icon_pure_pb_recommend_host30);
    }

    public final void E() {
        this.n.getLayoutParams().width = 201;
        this.j.getLayoutParams().width = 201;
        this.f54570d.getLayoutParams().width = 201;
        this.k.getLayoutParams().width = 201;
        this.f54571e.getLayoutParams().width = 201;
        this.f54572f.getLayoutParams().width = 201;
        this.m.getLayoutParams().width = 201;
        this.f54573g.getLayoutParams().width = 201;
        this.f54574h.getLayoutParams().width = 201;
        this.i.getLayoutParams().width = 201;
        this.l.getLayoutParams().width = 201;
        this.o.getLayoutParams().width = 201;
    }

    public void F(boolean z) {
        this.f54571e.setVisibility(z ? 0 : 8);
    }

    public void G(boolean z, boolean z2) {
        this.l.setVisibility(z ? 0 : 8);
        if (z2) {
            this.l.setText(R.string.pb_cancel_good);
            P(this.l, R.drawable.icon_pure_pb_recommend_bested30);
            return;
        }
        this.l.setText(R.string.commit_good);
        P(this.l, R.drawable.icon_pure_pb_recommend_best30);
    }

    public void I(boolean z, boolean z2) {
        this.i.setVisibility(z ? 0 : 8);
        if (z2) {
            this.i.setText(R.string.pb_cancel_top);
            P(this.i, R.drawable.icon_pure_pb_recommend_toped30);
            return;
        }
        this.i.setText(R.string.top);
        P(this.i, R.drawable.icon_pure_pb_recommend_top30);
    }

    public void J(boolean z, boolean z2) {
        this.k.setVisibility(z ? 0 : 8);
        if (z2) {
            this.k.setText(R.string.normal_mode);
            P(this.k, R.drawable.icon_pure_pb_recommend_daytime30);
            return;
        }
        this.k.setText(R.string.eyeshield_mode);
        P(this.k, R.drawable.icon_pure_pb_recommend_night30);
    }

    public void K(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
    }

    public void L(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
    }

    public void M(boolean z, boolean z2) {
        this.j.setVisibility(z ? 0 : 8);
        if (z2) {
            this.j.setText(R.string.view_reverse);
        } else {
            this.j.setText(R.string.default_sort);
        }
        this.j.setText(R.string.sort_selector);
    }

    public void O(boolean z) {
        this.f54570d.setVisibility(z ? 0 : 8);
    }

    public final void P(TextView textView, int i) {
        Drawable pureDrawable;
        if (textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = v;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void Q(boolean z) {
        MaskView.b(this.l, z);
        MaskView.b(this.i, z);
        MaskView.b(this.f54572f, z);
    }

    public TextView d() {
        return this.f54572f;
    }

    public TextView e() {
        return this.r;
    }

    public TextView f() {
        return this.f54573g;
    }

    public TextView h() {
        return this.f54574h;
    }

    public TextView i() {
        return this.n;
    }

    public final void initUI() {
        View inflate = LayoutInflater.from(this.f54567a.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.f54568b = inflate;
        this.f54569c = (FlowLayout) inflate.findViewById(R.id.pb_more_flowlayout);
        EMTextView eMTextView = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_host_only);
        this.n = eMTextView;
        eMTextView.setOnClickListener(this.t);
        EMTextView eMTextView2 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_reversed);
        this.j = eMTextView2;
        eMTextView2.setOnClickListener(this.t);
        EMTextView eMTextView3 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_jump);
        this.f54570d = eMTextView3;
        eMTextView3.setOnClickListener(this.t);
        EMTextView eMTextView4 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_night_style);
        this.k = eMTextView4;
        eMTextView4.setOnClickListener(this.t);
        EMTextView eMTextView5 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_jump_top);
        this.f54571e = eMTextView5;
        eMTextView5.setOnClickListener(this.t);
        EMTextView eMTextView6 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_call_fans);
        this.f54572f = eMTextView6;
        eMTextView6.setOnClickListener(this.t);
        EMTextView eMTextView7 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_report);
        this.m = eMTextView7;
        eMTextView7.setOnClickListener(this.t);
        EMTextView eMTextView8 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_delete);
        this.f54573g = eMTextView8;
        eMTextView8.setOnClickListener(this.t);
        EMTextView eMTextView9 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_forbidden);
        this.f54574h = eMTextView9;
        eMTextView9.setOnClickListener(this.t);
        EMTextView eMTextView10 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_make_top);
        this.i = eMTextView10;
        eMTextView10.setOnClickListener(this.t);
        EMTextView eMTextView11 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_add_good);
        this.l = eMTextView11;
        eMTextView11.setOnClickListener(this.t);
        EMTextView eMTextView12 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_view_item_private);
        this.o = eMTextView12;
        eMTextView12.setOnClickListener(this.t);
        this.q = (TextSizeSeekBar) this.f54568b.findViewById(R.id.pb_more_text_size_seekbar);
        this.p = (LinearLayout) this.f54568b.findViewById(R.id.size_seek_bar_group);
        EMTextView eMTextView13 = (EMTextView) this.f54568b.findViewById(R.id.pb_more_cancel);
        this.r = eMTextView13;
        eMTextView13.setOnClickListener(this.t);
        this.s = this.f54568b.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (v()) {
            return;
        }
        E();
    }

    public TextView k() {
        return this.f54570d;
    }

    public TextView l() {
        return this.f54571e;
    }

    public TextView m() {
        return this.l;
    }

    public TextView n() {
        return this.i;
    }

    public TextView o() {
        return this.k;
    }

    public TextView q() {
        return this.o;
    }

    public TextView r() {
        return this.m;
    }

    public TextView s() {
        return this.j;
    }

    public View u() {
        return this.f54568b;
    }

    public final boolean v() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f54567a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.densityDpi;
        return i % 160 == 0 || ((double) ((((float) i) * 1.0f) / 160.0f)) == 1.5d;
    }

    public void w() {
    }

    public void x() {
        int i;
        SkinManager.setBackgroundColor(this.f54569c, R.color.CAM_X0204);
        d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.p);
        d2.k(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
        SkinManager.setViewTextColorSelector(this.r, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f54570d, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f54571e, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f54572f, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f54573g, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f54574h, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.f54567a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (v()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.f54569c.setHorizontalSpacing(i);
        P(this.f54570d, R.drawable.icon_pure_pb_recommend_jump30);
        P(this.m, R.drawable.icon_pure_pb_recommend_report30);
        P(this.f54571e, R.drawable.icon_pure_pb_recommend_initial30);
        P(this.f54572f, R.drawable.icon_pure_pb_recommend_fans30);
        this.f54572f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        P(this.f54573g, this.u ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        P(this.f54574h, R.drawable.icon_pure_pb_recommend_block30);
        P(this.o, R.drawable.icon_pure_pb_recommend_private30);
        P(this.j, R.drawable.icon_pure_pb_recommend_sort30);
        TextSizeSeekBar textSizeSeekBar = this.q;
        if (textSizeSeekBar != null) {
            textSizeSeekBar.e();
        }
    }

    public void y(boolean z) {
        this.f54572f.setVisibility(z ? 0 : 8);
    }

    public void z(boolean z) {
        this.f54573g.setVisibility(z ? 0 : 8);
    }
}
