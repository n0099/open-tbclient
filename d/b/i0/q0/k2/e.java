package d.b.i0.q0.k2;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabItemView;
import d.b.c.e.p.l;
import d.b.i0.q0.f1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f59439a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f59440b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f59441c;

    /* renamed from: d  reason: collision with root package name */
    public View f59442d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.b.i0.q0.k2.a> f59443e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f59444f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.q0.k2.a f59445g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1455e f59446h;
    public d i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.m.g.c(e.this.f59441c);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements KeyEventDealContainerView.a {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
            if (e.this.f59441c != null) {
                d.b.c.e.m.g.c(e.this.f59441c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f59449e;

        public c(TabItemView tabItemView) {
            this.f59449e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.i != null) {
                e.this.i.a(this.f59449e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.b.i0.q0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1455e {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59451a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f59452b;

        /* renamed from: c  reason: collision with root package name */
        public View f59453c;

        /* renamed from: d  reason: collision with root package name */
        public View f59454d;
    }

    public e(Context context, InterfaceC1455e interfaceC1455e, d dVar) {
        this.f59444f = context;
        this.f59446h = interfaceC1455e;
        this.i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f59439a = linearLayout;
        linearLayout.setOrientation(1);
        this.f59439a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f59442d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f59441c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1455e d() {
        return this.f59446h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f59441c == null) {
            this.f59441c = new MorePopupWindow(activity, this.f59439a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f59441c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f59440b = f1Var;
        d.b.i0.q0.k2.a aVar = this.f59443e.get(f1Var.f59194a);
        this.f59445g = aVar;
        if (aVar == null) {
            d.b.i0.q0.k2.a a2 = h.a(this.f59440b.f59194a);
            this.f59445g = a2;
            a2.a(this.f59444f, this);
            this.f59443e.put(this.f59440b.f59194a, this.f59445g);
        }
        this.f59445g.setData(f1Var.f59195b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.x(horizontalTabView.getContext());
                int i = l.i(horizontalTabView.getContext());
                int b2 = this.f59445g.b();
                int measuredHeight = (i - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f59439a.removeAllViews();
        this.f59439a.addView(this.f59445g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f59442d, R.color.common_color_10050);
        this.f59439a.addView(this.f59442d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f59441c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f59441c.setWidthAsWidthOfDeviceScreen(activity);
            this.f59441c.setHeight(-1);
            this.f59441c.showWindowInCustomPosition(0, 0);
        }
    }
}
