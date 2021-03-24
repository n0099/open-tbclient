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
    public LinearLayout f57739a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f57740b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f57741c;

    /* renamed from: d  reason: collision with root package name */
    public View f57742d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.b.i0.p0.k2.a> f57743e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f57744f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.p0.k2.a f57745g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1392e f57746h;
    public d i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.m.g.c(e.this.f57741c);
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
            if (e.this.f57741c != null) {
                d.b.b.e.m.g.c(e.this.f57741c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f57749e;

        public c(TabItemView tabItemView) {
            this.f57749e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.i != null) {
                e.this.i.a(this.f57749e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.b.i0.p0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1392e {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57751a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f57752b;

        /* renamed from: c  reason: collision with root package name */
        public View f57753c;

        /* renamed from: d  reason: collision with root package name */
        public View f57754d;
    }

    public e(Context context, InterfaceC1392e interfaceC1392e, d dVar) {
        this.f57744f = context;
        this.f57746h = interfaceC1392e;
        this.i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f57739a = linearLayout;
        linearLayout.setOrientation(1);
        this.f57739a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f57742d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f57741c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1392e d() {
        return this.f57746h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f57741c == null) {
            this.f57741c = new MorePopupWindow(activity, this.f57739a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f57741c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f57740b = f1Var;
        d.b.i0.p0.k2.a aVar = this.f57743e.get(f1Var.f57494a);
        this.f57745g = aVar;
        if (aVar == null) {
            d.b.i0.p0.k2.a a2 = h.a(this.f57740b.f57494a);
            this.f57745g = a2;
            a2.a(this.f57744f, this);
            this.f57743e.put(this.f57740b.f57494a, this.f57745g);
        }
        this.f57745g.setData(f1Var.f57495b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.x(horizontalTabView.getContext());
                int i = l.i(horizontalTabView.getContext());
                int b2 = this.f57745g.b();
                int measuredHeight = (i - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f57739a.removeAllViews();
        this.f57739a.addView(this.f57745g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f57742d, R.color.common_color_10050);
        this.f57739a.addView(this.f57742d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f57741c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f57741c.setWidthAsWidthOfDeviceScreen(activity);
            this.f57741c.setHeight(-1);
            this.f57741c.showWindowInCustomPosition(0, 0);
        }
    }
}
