package d.a.n0.w3;

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
    public int f62763a;

    /* renamed from: b  reason: collision with root package name */
    public a f62764b;

    /* renamed from: c  reason: collision with root package name */
    public int f62765c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f62766d;

    /* renamed from: e  reason: collision with root package name */
    public Context f62767e;

    /* renamed from: f  reason: collision with root package name */
    public int f62768f;

    /* loaded from: classes5.dex */
    public interface a {
        void onPrefixItemClick(int i2);
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f62769e;

        /* renamed from: f  reason: collision with root package name */
        public a f62770f;

        public b(int i2, a aVar) {
            this.f62769e = i2;
            this.f62770f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = this.f62770f;
            if (aVar != null) {
                aVar.onPrefixItemClick(this.f62769e);
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f62763a = -1;
        this.f62767e = context;
        b(context);
    }

    public void a(View view) {
        view.setOnClickListener(new b(this.f62765c, this.f62764b));
        this.f62766d.addView(view);
        this.f62765c++;
    }

    public final void b(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        this.f62766d = linearLayout;
        linearLayout.setOrientation(1);
        this.f62766d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.f62766d);
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
        int i3 = this.f62763a;
        if (i3 != -1) {
            this.f62766d.getChildAt(i3).setSelected(false);
        }
        this.f62763a = i2;
        this.f62766d.getChildAt(i2).setSelected(true);
    }

    public void d(int i2) {
        this.f62768f = i2;
    }

    public void e(a aVar) {
        this.f62764b = aVar;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.f62767e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f62767e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        if (measuredWidth < view.getWidth()) {
            measuredWidth = view.getWidth();
        }
        int measuredHeight = getContentView().getMeasuredHeight();
        int i4 = this.f62768f;
        if (measuredHeight > i4) {
            measuredHeight = i4;
        }
        setWidth(measuredWidth);
        setHeight(measuredHeight);
        super.showAsDropDown(view, i2, i3);
    }
}
