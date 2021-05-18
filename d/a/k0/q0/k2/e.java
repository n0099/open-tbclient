package d.a.k0.q0.k2;

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
import d.a.k0.q0.f1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f58673a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f58674b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f58675c;

    /* renamed from: d  reason: collision with root package name */
    public View f58676d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.a.k0.q0.k2.a> f58677e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f58678f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.q0.k2.a f58679g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1491e f58680h;

    /* renamed from: i  reason: collision with root package name */
    public d f58681i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.m.g.c(e.this.f58675c);
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
            if (e.this.f58675c != null) {
                d.a.c.e.m.g.c(e.this.f58675c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f58684e;

        public c(TabItemView tabItemView) {
            this.f58684e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.f58681i != null) {
                e.this.f58681i.a(this.f58684e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.a.k0.q0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1491e {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58686a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f58687b;

        /* renamed from: c  reason: collision with root package name */
        public View f58688c;

        /* renamed from: d  reason: collision with root package name */
        public View f58689d;
    }

    public e(Context context, InterfaceC1491e interfaceC1491e, d dVar) {
        this.f58678f = context;
        this.f58680h = interfaceC1491e;
        this.f58681i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f58673a = linearLayout;
        linearLayout.setOrientation(1);
        this.f58673a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f58676d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f58675c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1491e d() {
        return this.f58680h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f58675c == null) {
            this.f58675c = new MorePopupWindow(activity, this.f58673a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f58675c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f58674b = f1Var;
        d.a.k0.q0.k2.a aVar = this.f58677e.get(f1Var.f58414a);
        this.f58679g = aVar;
        if (aVar == null) {
            d.a.k0.q0.k2.a a2 = h.a(this.f58674b.f58414a);
            this.f58679g = a2;
            a2.a(this.f58678f, this);
            this.f58677e.put(this.f58674b.f58414a, this.f58679g);
        }
        this.f58679g.setData(f1Var.f58415b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.y(horizontalTabView.getContext());
                int i2 = l.i(horizontalTabView.getContext());
                int b2 = this.f58679g.b();
                int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f58673a.removeAllViews();
        this.f58673a.addView(this.f58679g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f58676d, R.color.common_color_10050);
        this.f58673a.addView(this.f58676d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f58675c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f58675c.setWidthAsWidthOfDeviceScreen(activity);
            this.f58675c.setHeight(-1);
            this.f58675c.showWindowInCustomPosition(0, 0);
        }
    }
}
