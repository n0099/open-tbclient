package d.a.k0.v3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import d.a.c.e.p.l;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class h extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public int f62656a;

    /* renamed from: b  reason: collision with root package name */
    public a f62657b;

    /* renamed from: c  reason: collision with root package name */
    public int f62658c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f62659d;

    /* renamed from: e  reason: collision with root package name */
    public Context f62660e;

    /* renamed from: f  reason: collision with root package name */
    public int f62661f;

    /* loaded from: classes5.dex */
    public interface a {
        void onPrefixItemClick(int i2);
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f62662e;

        /* renamed from: f  reason: collision with root package name */
        public a f62663f;

        public b(int i2, a aVar) {
            this.f62662e = i2;
            this.f62663f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = this.f62663f;
            if (aVar != null) {
                aVar.onPrefixItemClick(this.f62662e);
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f62656a = -1;
        this.f62660e = context;
        b(context);
    }

    public void a(View view) {
        view.setOnClickListener(new b(this.f62658c, this.f62657b));
        this.f62659d.addView(view);
        this.f62658c++;
    }

    public final void b(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        this.f62659d = linearLayout;
        linearLayout.setOrientation(1);
        this.f62659d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.f62659d);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setPadding(0, 0, l.e(context, 1.0f), l.e(context, 1.0f));
        scrollView.setFadingEdgeLength(0);
        scrollView.setScrollbarFadingEnabled(false);
        try {
            Method declaredMethod = scrollView.getClass().getDeclaredMethod("setOverScrollMode", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(scrollView, 2);
        } catch (Exception unused) {
        }
        setContentView(scrollView);
    }

    public void c(int i2) {
        int i3 = this.f62656a;
        if (i3 != -1) {
            this.f62659d.getChildAt(i3).setSelected(false);
        }
        this.f62656a = i2;
        this.f62659d.getChildAt(i2).setSelected(true);
    }

    public void d(int i2) {
        this.f62661f = i2;
    }

    public void e(a aVar) {
        this.f62657b = aVar;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.f62660e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f62660e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        if (measuredWidth < view.getWidth()) {
            measuredWidth = view.getWidth();
        }
        int measuredHeight = getContentView().getMeasuredHeight();
        int i4 = this.f62661f;
        if (measuredHeight > i4) {
            measuredHeight = i4;
        }
        setWidth(measuredWidth);
        setHeight(measuredHeight);
        super.showAsDropDown(view, i2, i3);
    }
}
