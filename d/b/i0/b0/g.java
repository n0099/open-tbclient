package d.b.i0.b0;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51986a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.s.e.a f51987b;

    /* renamed from: c  reason: collision with root package name */
    public a2 f51988c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f51989d;

    /* renamed from: e  reason: collision with root package name */
    public PopupWindow f51990e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f51991f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51992g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f51993h;
    public d.b.h0.r.f0.m.b i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public View q;
    public int r = 3;
    public PopupWindow.OnDismissListener s = new a();
    public View.OnClickListener t = new b();

    /* loaded from: classes4.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (g.this.f51990e != null) {
                g.this.f51990e.dismiss();
                g.this.f51990e = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A()) {
                g.this.f51986a.showToast(R.string.network_ungeilivable);
            }
            if (ViewHelper.checkUpIsLogin(g.this.f51986a.getPageActivity())) {
                if (g.this.f51988c == null) {
                    return;
                }
                g.this.f51987b.m(false, g.this.f51988c.T().getPortrait(), g.this.f51988c.T().getUserId(), g.this.f51988c.T().isGod(), "0", g.this.f51986a.getUniqueId(), null, "0");
                TiebaStatic.log(new StatisticItem("c13571"));
            }
            if (g.this.f51990e == null || g.this.f51989d == null) {
                return;
            }
            g.this.f51990e.dismiss();
            g.this.f51989d.dismiss();
            g.this.f51989d = null;
            g.this.f51990e = null;
        }
    }

    public g(TbPageContext tbPageContext, View view) {
        this.f51986a = tbPageContext;
        this.f51987b = new d.b.h0.s.e.a(tbPageContext);
        this.q = view;
        m();
    }

    public void h(a2 a2Var) {
        this.f51988c = a2Var;
    }

    public final boolean i(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int i5 = l.i(context);
        int k = l.k(context);
        boolean z = ((i5 - iArr2[1]) - height) - i3 < i;
        iArr[0] = k - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
        } else {
            iArr[1] = iArr2[1] + height + i4;
        }
        return z;
    }

    public final void j() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.r) {
            SkinManager.setViewTextColor(this.f51992g, R.color.CAM_X0105, 1);
            this.r = skinType;
        }
    }

    public final View k() {
        if (this.f51986a.getContext() == null) {
            return null;
        }
        if (this.f51991f == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f51986a.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.f51991f = viewGroup;
            TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
            this.f51992g = textView;
            textView.setText(this.f51986a.getString(R.string.confirm_unlike));
            SkinManager.setViewTextColor(this.f51992g, R.color.CAM_X0105, 1);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f51991f.findViewById(R.id.uninterested_btn);
            this.f51993h = tBSpecificationBtn;
            tBSpecificationBtn.setText(this.f51986a.getString(R.string.confirm_unlike_confirm));
            this.f51993h.setTextSize(R.dimen.T_X08);
            this.f51993h.setOnClickListener(this.t);
            d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
            this.i = bVar;
            bVar.q(R.color.CAM_X0304);
            this.f51993h.setConfig(this.i);
            ViewGroup viewGroup2 = this.f51991f;
            int i = this.j;
            viewGroup2.setPadding(i, 0, i, 0);
        }
        j();
        return this.f51991f;
    }

    public final int l() {
        ViewGroup viewGroup = this.f51991f;
        if (viewGroup == null) {
            return 0;
        }
        viewGroup.measure(0, 0);
        int measuredHeight = this.f51991f.getMeasuredHeight();
        this.o = measuredHeight;
        return measuredHeight;
    }

    public final void m() {
        this.j = l.g(this.f51986a.getContext(), R.dimen.M_W_X005);
        this.k = l.g(this.f51986a.getContext(), R.dimen.M_W_X004);
        this.l = l.g(this.f51986a.getContext(), R.dimen.tbds14);
        this.p = l.g(this.f51986a.getContext(), R.dimen.tbds160);
    }

    public void n() {
        if (this.f51986a.getContext() == null) {
            return;
        }
        View k = k();
        this.n = l.k(this.f51986a.getContext()) - (this.k * 2);
        this.m = l();
        int[] iArr = new int[2];
        boolean i = i(this.f51986a.getContext(), this.q, this.m, this.n, this.p, this.l, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(l.g(this.f51986a.getContext(), R.dimen.tbds31));
        k.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(k, this.n, l());
        this.f51989d = popupWindow;
        popupWindow.setFocusable(true);
        this.f51989d.setTouchable(true);
        this.f51989d.setOnDismissListener(this.s);
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f51986a.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.f51990e = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.f51990e.showAtLocation(this.q, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.f51989d.setBackgroundDrawable(new ColorDrawable(0));
        if (i) {
            this.f51989d.setAnimationStyle(R.style.scale_rb2lt_anim);
        } else {
            this.f51989d.setAnimationStyle(R.style.scale_rt2lb_anim);
        }
        this.f51989d.showAtLocation(this.q, 0, iArr[0] - this.k, iArr[1]);
    }
}
