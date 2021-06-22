package d.a.o0.w3.t;

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
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public int f66790a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f66791b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f66792c;

    /* renamed from: d  reason: collision with root package name */
    public BaseFragmentActivity f66793d;

    /* renamed from: e  reason: collision with root package name */
    public View f66794e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f66795f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f66796g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.w3.k.b f66797h;

    /* renamed from: i  reason: collision with root package name */
    public int f66798i;
    public f j;
    public final AdapterView.OnItemClickListener k;
    public final View.OnClickListener l;

    /* renamed from: d.a.o0.w3.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1781a implements AdapterView.OnItemClickListener {
        public C1781a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.n0.e.a item = a.this.f66797h.getItem(i2);
            if (a.this.j != null) {
                a.this.j.onItemClick(i2, item);
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
            ViewGroup.LayoutParams layoutParams = a.this.f66795f.getLayoutParams();
            layoutParams.height = intValue;
            a.this.f66795f.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = a.this.f66795f.getLayoutParams();
            layoutParams.height = intValue;
            a.this.f66795f.setLayoutParams(layoutParams);
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
        void onItemClick(int i2, d.a.n0.e.a aVar);
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.k = new C1781a();
        this.l = new b();
        this.f66793d = baseFragmentActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(g(new ArrayList(), d.a.n0.e.a.f53080f));
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

    public final int e(List<d.a.n0.e.a> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.n0.e.a aVar = list.get(i2);
                if (aVar != null && str.equals(aVar.b())) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public void f() {
        ListView listView = this.f66795f;
        if (listView != null) {
            listView.clearAnimation();
        }
        ViewGroup viewGroup = this.f66796g;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final View g(List<d.a.n0.e.a> list, String str) {
        BdListView bdListView = new BdListView(this.f66793d.getPageContext().getPageActivity());
        this.f66795f = bdListView;
        bdListView.setCacheColorHint(this.f66793d.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        d.a.o0.w3.k.b bVar = new d.a.o0.w3.k.b(this.f66793d);
        this.f66797h = bVar;
        bVar.b(list, str);
        bdListView.setAdapter((ListAdapter) this.f66797h);
        FrameLayout frameLayout = new FrameLayout(this.f66793d.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.f66793d.getPageContext().getPageActivity());
        this.f66796g = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.f66795f.setOnItemClickListener(this.k);
        frameLayout.setOnClickListener(this.l);
        SkinManager.setBackgroundColor(this.f66794e, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f66795f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f66796g, R.color.black_alpha70);
        return frameLayout;
    }

    public final void h() {
        super.dismiss();
    }

    public final void i() {
        if (this.f66792c == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f66795f.getHeight(), 0);
            this.f66792c = ofInt;
            ofInt.addUpdateListener(new d());
            this.f66792c.setDuration(350L);
        }
        this.f66792c.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new e());
        this.f66796g.startAnimation(alphaAnimation);
    }

    public void j() {
        i();
    }

    public void k(List<d.a.n0.e.a> list, String str) {
        if (list == null) {
            return;
        }
        this.f66798i = e(list, str);
        this.f66790a = -2;
        if (list.size() > 5) {
            this.f66790a = this.f66793d.getResources().getDimensionPixelSize(R.dimen.ds618);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f66795f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f66790a);
        } else {
            layoutParams.height = this.f66790a;
        }
        this.f66795f.setLayoutParams(layoutParams);
        if (this.f66790a < 0) {
            this.f66790a = l.g(this.f66793d, R.dimen.tbds168) * list.size();
        }
        this.f66797h.b(list, str);
        this.f66797h.notifyDataSetChanged();
    }

    public void l(f fVar) {
        this.j = fVar;
    }

    public final void m() {
        if (this.f66791b == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f66790a);
            this.f66791b = ofInt;
            ofInt.addUpdateListener(new c());
            this.f66791b.setDuration(350L);
        }
        this.f66791b.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.f66796g.startAnimation(alphaAnimation);
    }

    public void n(View view) {
        this.f66795f.setSelection(this.f66798i);
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
        ((FrameLayout.LayoutParams) this.f66795f.getLayoutParams()).topMargin = height;
        ((FrameLayout.LayoutParams) this.f66796g.getLayoutParams()).topMargin = height;
        if (g.m(this, view, 0, 0, 0)) {
            m();
        }
    }
}
