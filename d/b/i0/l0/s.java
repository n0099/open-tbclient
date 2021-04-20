package d.b.i0.l0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class s extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public Context f58008a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f58009b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f58010c;

    /* renamed from: d  reason: collision with root package name */
    public x f58011d;

    /* renamed from: e  reason: collision with root package name */
    public int f58012e;

    /* renamed from: f  reason: collision with root package name */
    public d f58013f;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.h0.e.a item = s.this.f58011d.getItem(i);
            if ((item instanceof d.b.h0.e.a) && s.this.f58013f != null) {
                s.this.f58013f.onItemClick(i, item);
            }
            s.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            s.this.f();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onItemClick(int i, d.b.h0.e.a aVar);
    }

    public s(Context context) {
        super(context);
        this.f58008a = context;
        setWidth(-1);
        setHeight(-1);
        setContentView(e(new ArrayList(), d.b.h0.e.a.f50513f));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public final int d(List<d.b.h0.e.a> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d.b.h0.e.a aVar = list.get(i);
                if (aVar != null && str.equals(aVar.b())) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        h();
    }

    @SuppressLint({"ResourceAsColor"})
    public final View e(List<d.b.h0.e.a> list, String str) {
        BdListView bdListView = new BdListView(this.f58008a);
        this.f58009b = bdListView;
        bdListView.setCacheColorHint(this.f58008a.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        x xVar = new x(this.f58008a);
        this.f58011d = xVar;
        xVar.b(list, str);
        bdListView.setAdapter((ListAdapter) this.f58011d);
        bdListView.setOnItemClickListener(new a());
        FrameLayout frameLayout = new FrameLayout(this.f58008a);
        FrameLayout frameLayout2 = new FrameLayout(this.f58008a);
        this.f58010c = frameLayout2;
        frameLayout2.setBackgroundColor(this.f58008a.getResources().getColor(R.color.common_color_10175));
        frameLayout2.setOnClickListener(new b());
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public final void f() {
        super.dismiss();
    }

    public final void g() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new c());
        this.f58009b.startAnimation(translateAnimation);
        this.f58010c.startAnimation(alphaAnimation);
    }

    public void h() {
        g();
    }

    public void i(List<d.b.h0.e.a> list, String str) {
        if (list == null) {
            return;
        }
        this.f58012e = d(list, str);
        int dimensionPixelSize = list.size() > 5 ? this.f58008a.getResources().getDimensionPixelSize(R.dimen.ds618) : -2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f58009b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        } else {
            layoutParams.height = dimensionPixelSize;
        }
        this.f58009b.setLayoutParams(layoutParams);
        this.f58011d.b(list, str);
        this.f58011d.notifyDataSetChanged();
    }

    public void j(d dVar) {
        this.f58013f = dVar;
    }

    public final void k() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.f58009b.startAnimation(translateAnimation);
        this.f58010c.startAnimation(alphaAnimation);
    }

    public void l(View view) {
        this.f58009b.setSelection(this.f58012e);
        if (Build.VERSION.SDK_INT < 24) {
            if (d.b.c.e.m.g.k(this, view)) {
                k();
            }
        } else if (d.b.c.e.m.g.m(this, view, 0, 0, view.getHeight())) {
            k();
        }
    }
}
