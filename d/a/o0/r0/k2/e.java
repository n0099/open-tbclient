package d.a.o0.r0.k2;

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
import d.a.o0.r0.f1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f62630a;

    /* renamed from: b  reason: collision with root package name */
    public f1 f62631b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f62632c;

    /* renamed from: d  reason: collision with root package name */
    public View f62633d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.a.o0.r0.k2.a> f62634e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public Context f62635f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.r0.k2.a f62636g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1564e f62637h;

    /* renamed from: i  reason: collision with root package name */
    public d f62638i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.m.g.c(e.this.f62632c);
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
            if (e.this.f62632c != null) {
                d.a.c.e.m.g.c(e.this.f62632c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f62641e;

        public c(TabItemView tabItemView) {
            this.f62641e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.f62638i != null) {
                e.this.f62638i.a(this.f62641e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* renamed from: d.a.o0.r0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1564e {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62643a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f62644b;

        /* renamed from: c  reason: collision with root package name */
        public View f62645c;

        /* renamed from: d  reason: collision with root package name */
        public View f62646d;
    }

    public e(Context context, InterfaceC1564e interfaceC1564e, d dVar) {
        this.f62635f = context;
        this.f62637h = interfaceC1564e;
        this.f62638i = dVar;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f62630a = linearLayout;
        linearLayout.setOrientation(1);
        this.f62630a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f62633d = view;
        view.setOnClickListener(new a());
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f62632c;
        if (morePopupWindow != null) {
            try {
                morePopupWindow.dismiss();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public InterfaceC1564e d() {
        return this.f62637h;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        if (this.f62632c == null) {
            this.f62632c = new MorePopupWindow(activity, this.f62630a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
        }
        this.f62632c.setOnDismissListener(new c(tabItemView));
    }

    public void f(Activity activity, View view, TabItemView tabItemView, f1 f1Var) {
        this.f62631b = f1Var;
        d.a.o0.r0.k2.a aVar = this.f62634e.get(f1Var.f62371a);
        this.f62636g = aVar;
        if (aVar == null) {
            d.a.o0.r0.k2.a a2 = h.a(this.f62631b.f62371a);
            this.f62636g = a2;
            a2.a(this.f62635f, this);
            this.f62634e.put(this.f62631b.f62371a, this.f62636g);
        }
        this.f62636g.setData(f1Var.f62372b);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.y(horizontalTabView.getContext());
                int i2 = l.i(horizontalTabView.getContext());
                int b2 = this.f62636g.b();
                int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < b2) {
                    horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                }
            }
        }
        this.f62630a.removeAllViews();
        this.f62630a.addView(this.f62636g.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        SkinManager.setBackgroundResource(this.f62633d, R.color.common_color_10050);
        this.f62630a.addView(this.f62633d, layoutParams);
        e(activity, view, tabItemView);
        MorePopupWindow morePopupWindow = this.f62632c;
        if (morePopupWindow != null) {
            morePopupWindow.refresh();
            this.f62632c.setWidthAsWidthOfDeviceScreen(activity);
            this.f62632c.setHeight(-1);
            this.f62632c.showWindowInCustomPosition(0, 0);
        }
    }
}
