package d.b.i0.p0.k2;

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
import d.b.b.e.p.l;
import d.b.i0.p0.f1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f57740a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f57741b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f57742c;

    /* renamed from: d  reason: collision with root package name */
    public View f57743d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.b.i0.p0.k2.a> f57744e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f57745f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.p0.k2.a f57746g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1393e f57747h;
    public d i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.m.g.c(e.this.f57742c);
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
            if (e.this.f57742c != null) {
                d.b.b.e.m.g.c(e.this.f57742c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f57750e;

        public c(TabItemView tabItemView) {
            this.f57750e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.i != null) {
                e.this.i.a(this.f57750e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.b.i0.p0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1393e {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57752a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f57753b;

        /* renamed from: c  reason: collision with root package name */
        public View f57754c;

        /* renamed from: d  reason: collision with root package name */
        public View f57755d;
    }

    public e(Context context, InterfaceC1393e interfaceC1393e, d dVar) {
        this.f57745f = context;
        this.f57747h = interfaceC1393e;
        this.i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f57740a = linearLayout;
        linearLayout.setOrientation(1);
        this.f57740a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f57743d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f57742c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1393e d() {
        return this.f57747h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f57742c == null) {
            this.f57742c = new MorePopupWindow(activity, this.f57740a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f57742c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f57741b = f1Var;
        d.b.i0.p0.k2.a aVar = this.f57744e.get(f1Var.f57495a);
        this.f57746g = aVar;
        if (aVar == null) {
            d.b.i0.p0.k2.a a2 = h.a(this.f57741b.f57495a);
            this.f57746g = a2;
            a2.a(this.f57745f, this);
            this.f57744e.put(this.f57741b.f57495a, this.f57746g);
        }
        this.f57746g.setData(f1Var.f57496b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.x(horizontalTabView.getContext());
                int i = l.i(horizontalTabView.getContext());
                int b2 = this.f57746g.b();
                int measuredHeight = (i - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f57740a.removeAllViews();
        this.f57740a.addView(this.f57746g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f57743d, R.color.common_color_10050);
        this.f57740a.addView(this.f57743d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f57742c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f57742c.setWidthAsWidthOfDeviceScreen(activity);
            this.f57742c.setHeight(-1);
            this.f57742c.showWindowInCustomPosition(0, 0);
        }
    }
}
