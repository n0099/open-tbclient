package d.b.i0.c2.k.e;

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
/* loaded from: classes4.dex */
public class d0 extends d.b.b.a.d {
    public static final int v = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f52661a;

    /* renamed from: b  reason: collision with root package name */
    public View f52662b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f52663c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f52664d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f52665e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f52666f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f52667g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f52668h;
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

    public d0(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        this.m = null;
        this.t = null;
        this.f52661a = baseFragment;
        this.t = onClickListener;
        initUI();
    }

    public void A(boolean z) {
        this.f52668h.setVisibility(z ? 0 : 8);
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
        this.f52664d.getLayoutParams().width = 201;
        this.k.getLayoutParams().width = 201;
        this.f52665e.getLayoutParams().width = 201;
        this.f52666f.getLayoutParams().width = 201;
        this.m.getLayoutParams().width = 201;
        this.f52667g.getLayoutParams().width = 201;
        this.f52668h.getLayoutParams().width = 201;
        this.i.getLayoutParams().width = 201;
        this.l.getLayoutParams().width = 201;
        this.o.getLayoutParams().width = 201;
    }

    public void F(boolean z) {
        this.f52665e.setVisibility(z ? 0 : 8);
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
        this.f52664d.setVisibility(z ? 0 : 8);
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
        MaskView.b(this.f52666f, z);
    }

    public TextView d() {
        return this.f52666f;
    }

    public TextView e() {
        return this.r;
    }

    public TextView f() {
        return this.f52667g;
    }

    public TextView h() {
        return this.f52668h;
    }

    public TextView i() {
        return this.n;
    }

    public final void initUI() {
        View inflate = LayoutInflater.from(this.f52661a.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.f52662b = inflate;
        this.f52663c = (FlowLayout) inflate.findViewById(R.id.pb_more_flowlayout);
        EMTextView eMTextView = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_host_only);
        this.n = eMTextView;
        eMTextView.setOnClickListener(this.t);
        EMTextView eMTextView2 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_reversed);
        this.j = eMTextView2;
        eMTextView2.setOnClickListener(this.t);
        EMTextView eMTextView3 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_jump);
        this.f52664d = eMTextView3;
        eMTextView3.setOnClickListener(this.t);
        EMTextView eMTextView4 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_night_style);
        this.k = eMTextView4;
        eMTextView4.setOnClickListener(this.t);
        EMTextView eMTextView5 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_jump_top);
        this.f52665e = eMTextView5;
        eMTextView5.setOnClickListener(this.t);
        EMTextView eMTextView6 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_call_fans);
        this.f52666f = eMTextView6;
        eMTextView6.setOnClickListener(this.t);
        EMTextView eMTextView7 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_report);
        this.m = eMTextView7;
        eMTextView7.setOnClickListener(this.t);
        EMTextView eMTextView8 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_delete);
        this.f52667g = eMTextView8;
        eMTextView8.setOnClickListener(this.t);
        EMTextView eMTextView9 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_forbidden);
        this.f52668h = eMTextView9;
        eMTextView9.setOnClickListener(this.t);
        EMTextView eMTextView10 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_make_top);
        this.i = eMTextView10;
        eMTextView10.setOnClickListener(this.t);
        EMTextView eMTextView11 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_add_good);
        this.l = eMTextView11;
        eMTextView11.setOnClickListener(this.t);
        EMTextView eMTextView12 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_view_item_private);
        this.o = eMTextView12;
        eMTextView12.setOnClickListener(this.t);
        this.q = (TextSizeSeekBar) this.f52662b.findViewById(R.id.pb_more_text_size_seekbar);
        this.p = (LinearLayout) this.f52662b.findViewById(R.id.size_seek_bar_group);
        EMTextView eMTextView13 = (EMTextView) this.f52662b.findViewById(R.id.pb_more_cancel);
        this.r = eMTextView13;
        eMTextView13.setOnClickListener(this.t);
        this.s = this.f52662b.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
        if (v()) {
            return;
        }
        E();
    }

    public TextView k() {
        return this.f52664d;
    }

    public TextView l() {
        return this.f52665e;
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
        return this.f52662b;
    }

    public final boolean v() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f52661a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.densityDpi;
        return i % 160 == 0 || ((double) ((((float) i) * 1.0f) / 160.0f)) == 1.5d;
    }

    public void w() {
    }

    public void x() {
        int i;
        SkinManager.setBackgroundColor(this.f52663c, R.color.CAM_X0204);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.p);
        a2.h(R.string.J_X14);
        a2.c(R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
        SkinManager.setViewTextColorSelector(this.r, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f52664d, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f52665e, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f52666f, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f52667g, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f52668h, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
        int width = ((WindowManager) this.f52661a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
        if (v()) {
            i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
        } else {
            i = (width - 1005) / 4;
        }
        this.f52663c.setHorizontalSpacing(i);
        P(this.f52664d, R.drawable.icon_pure_pb_recommend_jump30);
        P(this.m, R.drawable.icon_pure_pb_recommend_report30);
        P(this.f52665e, R.drawable.icon_pure_pb_recommend_initial30);
        P(this.f52666f, R.drawable.icon_pure_pb_recommend_fans30);
        this.f52666f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
        P(this.f52667g, this.u ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
        P(this.f52668h, R.drawable.icon_pure_pb_recommend_block30);
        P(this.o, R.drawable.icon_pure_pb_recommend_private30);
        P(this.j, R.drawable.icon_pure_pb_recommend_sort30);
        TextSizeSeekBar textSizeSeekBar = this.q;
        if (textSizeSeekBar != null) {
            textSizeSeekBar.e();
        }
    }

    public void y(boolean z) {
        this.f52666f.setVisibility(z ? 0 : 8);
    }

    public void z(boolean z) {
        this.f52667g.setVisibility(z ? 0 : 8);
    }
}
