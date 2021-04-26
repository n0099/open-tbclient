package d.a.j0.q0.k2;

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
import d.a.j0.q0.f1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f57931a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f57932b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f57933c;

    /* renamed from: d  reason: collision with root package name */
    public View f57934d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.a.j0.q0.k2.a> f57935e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f57936f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.q0.k2.a f57937g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1417e f57938h;

    /* renamed from: i  reason: collision with root package name */
    public d f57939i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.m.g.c(e.this.f57933c);
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
            if (e.this.f57933c != null) {
                d.a.c.e.m.g.c(e.this.f57933c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f57942e;

        public c(TabItemView tabItemView) {
            this.f57942e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.f57939i != null) {
                e.this.f57939i.a(this.f57942e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.a.j0.q0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1417e {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57944a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f57945b;

        /* renamed from: c  reason: collision with root package name */
        public View f57946c;

        /* renamed from: d  reason: collision with root package name */
        public View f57947d;
    }

    public e(Context context, InterfaceC1417e interfaceC1417e, d dVar) {
        this.f57936f = context;
        this.f57938h = interfaceC1417e;
        this.f57939i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f57931a = linearLayout;
        linearLayout.setOrientation(1);
        this.f57931a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f57934d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f57933c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1417e d() {
        return this.f57938h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f57933c == null) {
            this.f57933c = new MorePopupWindow(activity, this.f57931a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f57933c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f57932b = f1Var;
        d.a.j0.q0.k2.a aVar = this.f57935e.get(f1Var.f57672a);
        this.f57937g = aVar;
        if (aVar == null) {
            d.a.j0.q0.k2.a a2 = h.a(this.f57932b.f57672a);
            this.f57937g = a2;
            a2.a(this.f57936f, this);
            this.f57935e.put(this.f57932b.f57672a, this.f57937g);
        }
        this.f57937g.setData(f1Var.f57673b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.y(horizontalTabView.getContext());
                int i2 = l.i(horizontalTabView.getContext());
                int b2 = this.f57937g.b();
                int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f57931a.removeAllViews();
        this.f57931a.addView(this.f57937g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f57934d, R.color.common_color_10050);
        this.f57931a.addView(this.f57934d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f57933c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f57933c.setWidthAsWidthOfDeviceScreen(activity);
            this.f57933c.setHeight(-1);
            this.f57933c.showWindowInCustomPosition(0, 0);
        }
    }
}
