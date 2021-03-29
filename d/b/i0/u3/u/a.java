package d.b.i0.u3.u;

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
import d.b.b.e.m.g;
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public int f61718a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f61719b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f61720c;

    /* renamed from: d  reason: collision with root package name */
    public BaseFragmentActivity f61721d;

    /* renamed from: e  reason: collision with root package name */
    public View f61722e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f61723f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f61724g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.u3.l.b f61725h;
    public int i;
    public f j;
    public final AdapterView.OnItemClickListener k;
    public final View.OnClickListener l;

    /* renamed from: d.b.i0.u3.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1621a implements AdapterView.OnItemClickListener {
        public C1621a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.h0.e.a item = a.this.f61725h.getItem(i);
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
            ViewGroup.LayoutParams layoutParams = a.this.f61723f.getLayoutParams();
            layoutParams.height = intValue;
            a.this.f61723f.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = a.this.f61723f.getLayoutParams();
            layoutParams.height = intValue;
            a.this.f61723f.setLayoutParams(layoutParams);
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
        void onItemClick(int i, d.b.h0.e.a aVar);
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        this.k = new C1621a();
        this.l = new b();
        this.f61721d = baseFragmentActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(g(new ArrayList(), d.b.h0.e.a.f50120f));
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

    public final int e(List<d.b.h0.e.a> list, String str) {
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

    public void f() {
        ListView listView = this.f61723f;
        if (listView != null) {
            listView.clearAnimation();
        }
        ViewGroup viewGroup = this.f61724g;
        if (viewGroup != null) {
            viewGroup.clearAnimation();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final View g(List<d.b.h0.e.a> list, String str) {
        BdListView bdListView = new BdListView(this.f61721d.getPageContext().getPageActivity());
        this.f61723f = bdListView;
        bdListView.setCacheColorHint(this.f61721d.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        d.b.i0.u3.l.b bVar = new d.b.i0.u3.l.b(this.f61721d);
        this.f61725h = bVar;
        bVar.b(list, str);
        bdListView.setAdapter((ListAdapter) this.f61725h);
        FrameLayout frameLayout = new FrameLayout(this.f61721d.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.f61721d.getPageContext().getPageActivity());
        this.f61724g = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.f61723f.setOnItemClickListener(this.k);
        frameLayout.setOnClickListener(this.l);
        SkinManager.setBackgroundColor(this.f61722e, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f61723f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f61724g, R.color.black_alpha70);
        return frameLayout;
    }

    public final void h() {
        super.dismiss();
    }

    public final void i() {
        if (this.f61720c == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f61723f.getHeight(), 0);
            this.f61720c = ofInt;
            ofInt.addUpdateListener(new d());
            this.f61720c.setDuration(350L);
        }
        this.f61720c.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new e());
        this.f61724g.startAnimation(alphaAnimation);
    }

    public void j() {
        i();
    }

    public void k(List<d.b.h0.e.a> list, String str) {
        if (list == null) {
            return;
        }
        this.i = e(list, str);
        this.f61718a = -2;
        if (list.size() > 5) {
            this.f61718a = this.f61721d.getResources().getDimensionPixelSize(R.dimen.ds618);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61723f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f61718a);
        } else {
            layoutParams.height = this.f61718a;
        }
        this.f61723f.setLayoutParams(layoutParams);
        if (this.f61718a < 0) {
            this.f61718a = l.g(this.f61721d, R.dimen.tbds168) * list.size();
        }
        this.f61725h.b(list, str);
        this.f61725h.notifyDataSetChanged();
    }

    public void l(f fVar) {
        this.j = fVar;
    }

    public final void m() {
        if (this.f61719b == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f61718a);
            this.f61719b = ofInt;
            ofInt.addUpdateListener(new c());
            this.f61719b.setDuration(350L);
        }
        this.f61719b.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.f61724g.startAnimation(alphaAnimation);
    }

    public void n(View view) {
        this.f61723f.setSelection(this.i);
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
        ((FrameLayout.LayoutParams) this.f61723f.getLayoutParams()).topMargin = height;
        ((FrameLayout.LayoutParams) this.f61724g.getLayoutParams()).topMargin = height;
        if (g.m(this, view, 0, 0, 0)) {
            m();
        }
    }
}
