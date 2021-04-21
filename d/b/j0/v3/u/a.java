package d.b.j0.v3.u;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.c.e.m.g;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public int f63877a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f63878b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f63879c;

    /* renamed from: d  reason: collision with root package name */
    public BaseFragmentActivity f63880d;

    /* renamed from: e  reason: collision with root package name */
    public View f63881e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f63882f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f63883g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.v3.l.b f63884h;
    public int i;
    public f j;
    public final AdapterView.OnItemClickListener k;
    public final View.OnClickListener l;

    /* renamed from: d.b.j0.v3.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1704a implements AdapterView.OnItemClickListener {
        public C1704a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.i0.e.a item = a.this.f63884h.getItem(i);
            if (a.this.j != null) {
                a.this.j.onItemClick(i, item);
            }
            a.this.j();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = a.this.f63882f.getLayoutParams();
            layoutParams.height = intValue;
            a.this.f63882f.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = a.this.f63882f.getLayoutParams();
            layoutParams.height = intValue;
            a.this.f63882f.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void onItemClick(int i, d.b.i0.e.a aVar);
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.k = new C1704a();
        this.l = new b();
        this.f63880d = baseFragmentActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(g(new ArrayList(), d.b.i0.e.a.f50849f));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        j();
    }

    public final int e(List<d.b.i0.e.a> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d.b.i0.e.a aVar = list.get(i);
                if (aVar != null && str.equals(aVar.b())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void f() {
        ListView listView = this.f63882f;
        if (listView != null) {
            listView.clearAnimation();
        }
        ViewGroup viewGroup = this.f63883g;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final View g(List<d.b.i0.e.a> list, String str) {
        BdListView bdListView = new BdListView(this.f63880d.getPageContext().getPageActivity());
        this.f63882f = bdListView;
        bdListView.setCacheColorHint(this.f63880d.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        d.b.j0.v3.l.b bVar = new d.b.j0.v3.l.b(this.f63880d);
        this.f63884h = bVar;
        bVar.b(list, str);
        bdListView.setAdapter((ListAdapter) this.f63884h);
        FrameLayout frameLayout = new FrameLayout(this.f63880d.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.f63880d.getPageContext().getPageActivity());
        this.f63883g = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.f63882f.setOnItemClickListener(this.k);
        frameLayout.setOnClickListener(this.l);
        SkinManager.setBackgroundColor(this.f63881e, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f63882f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f63883g, R.color.black_alpha70);
        return frameLayout;
    }

    public final void h() {
        super.dismiss();
    }

    public final void i() {
        if (this.f63879c == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f63882f.getHeight(), 0);
            this.f63879c = ofInt;
            ofInt.addUpdateListener(new d());
            this.f63879c.setDuration(350L);
        }
        this.f63879c.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new e());
        this.f63883g.startAnimation(alphaAnimation);
    }

    public void j() {
        i();
    }

    public void k(List<d.b.i0.e.a> list, String str) {
        if (list == null) {
            return;
        }
        this.i = e(list, str);
        this.f63877a = -2;
        if (list.size() > 5) {
            this.f63877a = this.f63880d.getResources().getDimensionPixelSize(R.dimen.ds618);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f63882f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f63877a);
        } else {
            layoutParams.height = this.f63877a;
        }
        this.f63882f.setLayoutParams(layoutParams);
        if (this.f63877a < 0) {
            this.f63877a = l.g(this.f63880d, R.dimen.tbds168) * list.size();
        }
        this.f63884h.b(list, str);
        this.f63884h.notifyDataSetChanged();
    }

    public void l(f fVar) {
        this.j = fVar;
    }

    public final void m() {
        if (this.f63878b == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f63877a);
            this.f63878b = ofInt;
            ofInt.addUpdateListener(new c());
            this.f63878b.setDuration(350L);
        }
        this.f63878b.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.f63883g.startAnimation(alphaAnimation);
    }

    public void n(View view) {
        this.f63882f.setSelection(this.i);
        if (Build.VERSION.SDK_INT < 24) {
            if (g.k(this, view)) {
                m();
                return;
            }
            return;
        }
        int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int height = (iArr[1] + view.getHeight()) - statusBarHeight;
        ((FrameLayout.LayoutParams) this.f63882f.getLayoutParams()).topMargin = height;
        ((FrameLayout.LayoutParams) this.f63883g.getLayoutParams()).topMargin = height;
        if (g.m(this, view, 0, 0, 0)) {
            m();
        }
    }
}
