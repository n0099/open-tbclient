package d.a.o0.w3;

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
    public int f66603a;

    /* renamed from: b  reason: collision with root package name */
    public a f66604b;

    /* renamed from: c  reason: collision with root package name */
    public int f66605c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f66606d;

    /* renamed from: e  reason: collision with root package name */
    public Context f66607e;

    /* renamed from: f  reason: collision with root package name */
    public int f66608f;

    /* loaded from: classes5.dex */
    public interface a {
        void onPrefixItemClick(int i2);
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f66609e;

        /* renamed from: f  reason: collision with root package name */
        public a f66610f;

        public b(int i2, a aVar) {
            this.f66609e = i2;
            this.f66610f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = this.f66610f;
            if (aVar != null) {
                aVar.onPrefixItemClick(this.f66609e);
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f66603a = -1;
        this.f66607e = context;
        b(context);
    }

    public void a(View view) {
        view.setOnClickListener(new b(this.f66605c, this.f66604b));
        this.f66606d.addView(view);
        this.f66605c++;
    }

    public final void b(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        this.f66606d = linearLayout;
        linearLayout.setOrientation(1);
        this.f66606d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        scrollView.addView(this.f66606d);
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
        int i3 = this.f66603a;
        if (i3 != -1) {
            this.f66606d.getChildAt(i3).setSelected(false);
        }
        this.f66603a = i2;
        this.f66606d.getChildAt(i2).setSelected(true);
    }

    public void d(int i2) {
        this.f66608f = i2;
    }

    public void e(a aVar) {
        this.f66604b = aVar;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.f66607e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f66607e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        if (measuredWidth < view.getWidth()) {
            measuredWidth = view.getWidth();
        }
        int measuredHeight = getContentView().getMeasuredHeight();
        int i4 = this.f66608f;
        if (measuredHeight > i4) {
            measuredHeight = i4;
        }
        setWidth(measuredWidth);
        setHeight(measuredHeight);
        super.showAsDropDown(view, i2, i3);
    }
}
