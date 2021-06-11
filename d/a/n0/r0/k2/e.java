package d.a.n0.r0.k2;

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
import d.a.c.e.p.l;
import d.a.n0.r0.f1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f62505a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f62506b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f62507c;

    /* renamed from: d  reason: collision with root package name */
    public View f62508d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.a.n0.r0.k2.a> f62509e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f62510f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r0.k2.a f62511g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1560e f62512h;

    /* renamed from: i  reason: collision with root package name */
    public d f62513i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.m.g.c(e.this.f62507c);
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
            if (e.this.f62507c != null) {
                d.a.c.e.m.g.c(e.this.f62507c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f62516e;

        public c(TabItemView tabItemView) {
            this.f62516e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.f62513i != null) {
                e.this.f62513i.a(this.f62516e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.a.n0.r0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1560e {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62518a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f62519b;

        /* renamed from: c  reason: collision with root package name */
        public View f62520c;

        /* renamed from: d  reason: collision with root package name */
        public View f62521d;
    }

    public e(Context context, InterfaceC1560e interfaceC1560e, d dVar) {
        this.f62510f = context;
        this.f62512h = interfaceC1560e;
        this.f62513i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f62505a = linearLayout;
        linearLayout.setOrientation(1);
        this.f62505a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f62508d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f62507c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1560e d() {
        return this.f62512h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f62507c == null) {
            this.f62507c = new MorePopupWindow(activity, this.f62505a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f62507c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f62506b = f1Var;
        d.a.n0.r0.k2.a aVar = this.f62509e.get(f1Var.f62246a);
        this.f62511g = aVar;
        if (aVar == null) {
            d.a.n0.r0.k2.a a2 = h.a(this.f62506b.f62246a);
            this.f62511g = a2;
            a2.a(this.f62510f, this);
            this.f62509e.put(this.f62506b.f62246a, this.f62511g);
        }
        this.f62511g.setData(f1Var.f62247b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.y(horizontalTabView.getContext());
                int i2 = l.i(horizontalTabView.getContext());
                int b2 = this.f62511g.b();
                int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f62505a.removeAllViews();
        this.f62505a.addView(this.f62511g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f62508d, R.color.common_color_10050);
        this.f62505a.addView(this.f62508d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f62507c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f62507c.setWidthAsWidthOfDeviceScreen(activity);
            this.f62507c.setHeight(-1);
            this.f62507c.showWindowInCustomPosition(0, 0);
        }
    }
}
