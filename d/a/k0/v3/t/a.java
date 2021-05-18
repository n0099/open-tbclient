package d.a.k0.v3.t;

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
    public int f62841a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f62842b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f62843c;

    /* renamed from: d  reason: collision with root package name */
    public BaseFragmentActivity f62844d;

    /* renamed from: e  reason: collision with root package name */
    public View f62845e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f62846f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f62847g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.v3.k.b f62848h;

    /* renamed from: i  reason: collision with root package name */
    public int f62849i;
    public f j;
    public final AdapterView.OnItemClickListener k;
    public final View.OnClickListener l;

    /* renamed from: d.a.k0.v3.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1706a implements AdapterView.OnItemClickListener {
        public C1706a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.j0.e.a item = a.this.f62848h.getItem(i2);
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
            ViewGroup.LayoutParams layoutParams = a.this.f62846f.getLayoutParams();
            layoutParams.height = intValue;
            a.this.f62846f.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = a.this.f62846f.getLayoutParams();
            layoutParams.height = intValue;
            a.this.f62846f.setLayoutParams(layoutParams);
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
        void onItemClick(int i2, d.a.j0.e.a aVar);
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.k = new C1706a();
        this.l = new b();
        this.f62844d = baseFragmentActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(g(new ArrayList(), d.a.j0.e.a.f49255f));
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

    public final int e(List<d.a.j0.e.a> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.j0.e.a aVar = list.get(i2);
                if (aVar != null && str.equals(aVar.b())) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public void f() {
        ListView listView = this.f62846f;
        if (listView != null) {
            listView.clearAnimation();
        }
        ViewGroup viewGroup = this.f62847g;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final View g(List<d.a.j0.e.a> list, String str) {
        BdListView bdListView = new BdListView(this.f62844d.getPageContext().getPageActivity());
        this.f62846f = bdListView;
        bdListView.setCacheColorHint(this.f62844d.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        d.a.k0.v3.k.b bVar = new d.a.k0.v3.k.b(this.f62844d);
        this.f62848h = bVar;
        bVar.b(list, str);
        bdListView.setAdapter((ListAdapter) this.f62848h);
        FrameLayout frameLayout = new FrameLayout(this.f62844d.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.f62844d.getPageContext().getPageActivity());
        this.f62847g = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.f62846f.setOnItemClickListener(this.k);
        frameLayout.setOnClickListener(this.l);
        SkinManager.setBackgroundColor(this.f62845e, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f62846f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f62847g, R.color.black_alpha70);
        return frameLayout;
    }

    public final void h() {
        super.dismiss();
    }

    public final void i() {
        if (this.f62843c == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f62846f.getHeight(), 0);
            this.f62843c = ofInt;
            ofInt.addUpdateListener(new d());
            this.f62843c.setDuration(350L);
        }
        this.f62843c.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new e());
        this.f62847g.startAnimation(alphaAnimation);
    }

    public void j() {
        i();
    }

    public void k(List<d.a.j0.e.a> list, String str) {
        if (list == null) {
            return;
        }
        this.f62849i = e(list, str);
        this.f62841a = -2;
        if (list.size() > 5) {
            this.f62841a = this.f62844d.getResources().getDimensionPixelSize(R.dimen.ds618);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f62846f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f62841a);
        } else {
            layoutParams.height = this.f62841a;
        }
        this.f62846f.setLayoutParams(layoutParams);
        if (this.f62841a < 0) {
            this.f62841a = l.g(this.f62844d, R.dimen.tbds168) * list.size();
        }
        this.f62848h.b(list, str);
        this.f62848h.notifyDataSetChanged();
    }

    public void l(f fVar) {
        this.j = fVar;
    }

    public final void m() {
        if (this.f62842b == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f62841a);
            this.f62842b = ofInt;
            ofInt.addUpdateListener(new c());
            this.f62842b.setDuration(350L);
        }
        this.f62842b.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.f62847g.startAnimation(alphaAnimation);
    }

    public void n(View view) {
        this.f62846f.setSelection(this.f62849i);
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
        ((FrameLayout.LayoutParams) this.f62846f.getLayoutParams()).topMargin = height;
        ((FrameLayout.LayoutParams) this.f62847g.getLayoutParams()).topMargin = height;
        if (g.m(this, view, 0, 0, 0)) {
            m();
        }
    }
}
