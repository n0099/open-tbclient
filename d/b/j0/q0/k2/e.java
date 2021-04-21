package d.b.j0.q0.k2;

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
import d.b.j0.q0.f1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f59860a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f59861b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f59862c;

    /* renamed from: d  reason: collision with root package name */
    public View f59863d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.b.j0.q0.k2.a> f59864e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f59865f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.q0.k2.a f59866g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1478e f59867h;
    public d i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.m.g.c(e.this.f59862c);
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
            if (e.this.f59862c != null) {
                d.b.c.e.m.g.c(e.this.f59862c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f59870e;

        public c(TabItemView tabItemView) {
            this.f59870e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.i != null) {
                e.this.i.a(this.f59870e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.b.j0.q0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1478e {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59872a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f59873b;

        /* renamed from: c  reason: collision with root package name */
        public View f59874c;

        /* renamed from: d  reason: collision with root package name */
        public View f59875d;
    }

    public e(Context context, InterfaceC1478e interfaceC1478e, d dVar) {
        this.f59865f = context;
        this.f59867h = interfaceC1478e;
        this.i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f59860a = linearLayout;
        linearLayout.setOrientation(1);
        this.f59860a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f59863d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f59862c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1478e d() {
        return this.f59867h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f59862c == null) {
            this.f59862c = new MorePopupWindow(activity, this.f59860a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f59862c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f59861b = f1Var;
        d.b.j0.q0.k2.a aVar = this.f59864e.get(f1Var.f59615a);
        this.f59866g = aVar;
        if (aVar == null) {
            d.b.j0.q0.k2.a a2 = h.a(this.f59861b.f59615a);
            this.f59866g = a2;
            a2.a(this.f59865f, this);
            this.f59864e.put(this.f59861b.f59615a, this.f59866g);
        }
        this.f59866g.setData(f1Var.f59616b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.x(horizontalTabView.getContext());
                int i = l.i(horizontalTabView.getContext());
                int b2 = this.f59866g.b();
                int measuredHeight = (i - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f59860a.removeAllViews();
        this.f59860a.addView(this.f59866g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f59863d, R.color.common_color_10050);
        this.f59860a.addView(this.f59863d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f59862c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f59862c.setWidthAsWidthOfDeviceScreen(activity);
            this.f59862c.setHeight(-1);
            this.f59862c.showWindowInCustomPosition(0, 0);
        }
    }
}
