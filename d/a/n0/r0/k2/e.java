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
    public LinearLayout f58814a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f58815b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f58816c;

    /* renamed from: d  reason: collision with root package name */
    public View f58817d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.a.n0.r0.k2.a> f58818e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f58819f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r0.k2.a f58820g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1504e f58821h;

    /* renamed from: i  reason: collision with root package name */
    public d f58822i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.m.g.c(e.this.f58816c);
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
            if (e.this.f58816c != null) {
                d.a.c.e.m.g.c(e.this.f58816c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f58825e;

        public c(TabItemView tabItemView) {
            this.f58825e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.f58822i != null) {
                e.this.f58822i.a(this.f58825e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.a.n0.r0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1504e {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58827a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f58828b;

        /* renamed from: c  reason: collision with root package name */
        public View f58829c;

        /* renamed from: d  reason: collision with root package name */
        public View f58830d;
    }

    public e(Context context, InterfaceC1504e interfaceC1504e, d dVar) {
        this.f58819f = context;
        this.f58821h = interfaceC1504e;
        this.f58822i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f58814a = linearLayout;
        linearLayout.setOrientation(1);
        this.f58814a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f58817d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f58816c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1504e d() {
        return this.f58821h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f58816c == null) {
            this.f58816c = new MorePopupWindow(activity, this.f58814a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f58816c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f58815b = f1Var;
        d.a.n0.r0.k2.a aVar = this.f58818e.get(f1Var.f58555a);
        this.f58820g = aVar;
        if (aVar == null) {
            d.a.n0.r0.k2.a a2 = h.a(this.f58815b.f58555a);
            this.f58820g = a2;
            a2.a(this.f58819f, this);
            this.f58818e.put(this.f58815b.f58555a, this.f58820g);
        }
        this.f58820g.setData(f1Var.f58556b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.y(horizontalTabView.getContext());
                int i2 = l.i(horizontalTabView.getContext());
                int b2 = this.f58820g.b();
                int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f58814a.removeAllViews();
        this.f58814a.addView(this.f58820g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f58817d, R.color.common_color_10050);
        this.f58814a.addView(this.f58817d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f58816c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f58816c.setWidthAsWidthOfDeviceScreen(activity);
            this.f58816c.setHeight(-1);
            this.f58816c.showWindowInCustomPosition(0, 0);
        }
    }
}
