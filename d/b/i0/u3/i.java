package d.b.i0.u3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import d.b.b.e.p.l;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class i extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public int f61541a;

    /* renamed from: b  reason: collision with root package name */
    public a f61542b;

    /* renamed from: c  reason: collision with root package name */
    public int f61543c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f61544d;

    /* renamed from: e  reason: collision with root package name */
    public Context f61545e;

    /* renamed from: f  reason: collision with root package name */
    public int f61546f;

    /* loaded from: classes5.dex */
    public interface a {
        void onPrefixItemClick(int i);
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f61547e;

        /* renamed from: f  reason: collision with root package name */
        public a f61548f;

        public b(int i, a aVar) {
            this.f61547e = i;
            this.f61548f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = this.f61548f;
            if (aVar != null) {
                aVar.onPrefixItemClick(this.f61547e);
            }
        }
    }

    public i(Context context) {
        super(context);
        this.f61541a = -1;
        this.f61545e = context;
        b(context);
    }

    public void a(View view) {
        view.setOnClickListener(new b(this.f61543c, this.f61542b));
        this.f61544d.addView(view);
        this.f61543c++;
    }

    public final void b(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        this.f61544d = linearLayout;
        linearLayout.setOrientation(1);
        this.f61544d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.f61544d);
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

    public void c(int i) {
        int i2 = this.f61541a;
        if (i2 != -1) {
            this.f61544d.getChildAt(i2).setSelected(false);
        }
        this.f61541a = i;
        this.f61544d.getChildAt(i).setSelected(true);
    }

    public void d(int i) {
        this.f61546f = i;
    }

    public void e(a aVar) {
        this.f61542b = aVar;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.f61545e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f61545e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        if (measuredWidth < view.getWidth()) {
            measuredWidth = view.getWidth();
        }
        int measuredHeight = getContentView().getMeasuredHeight();
        int i3 = this.f61546f;
        if (measuredHeight > i3) {
            measuredHeight = i3;
        }
        setWidth(measuredWidth);
        setHeight(measuredHeight);
        super.showAsDropDown(view, i, i2);
    }
}
