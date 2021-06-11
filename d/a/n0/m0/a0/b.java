package d.a.n0.m0.a0;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.face.view.EmotionPreview;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailActivity;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public EmotionPackageDetailActivity f60893a;

    /* renamed from: b  reason: collision with root package name */
    public final float f60894b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60895c;

    /* renamed from: d  reason: collision with root package name */
    public final int f60896d;
    public Handler j;
    public EmotionPreview k;
    public PackageDetailListView l;
    public FrameLayout o;
    public e q;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f60897e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public int f60898f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f60899g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f60900h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f60901i = -1;
    public boolean m = false;
    public boolean n = false;
    public int p = 3;
    public final Runnable r = new a();
    public final PackageDetailListView.a s = new C1487b();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.B();
        }
    }

    /* renamed from: d.a.n0.m0.a0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1487b implements PackageDetailListView.a {
        public C1487b() {
        }

        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            e v;
            if (motionEvent == null) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (b.this.f60898f > -1 && b.this.f60899g > -1) {
                            b.this.f60900h = (int) motionEvent.getX();
                            b.this.f60901i = (int) motionEvent.getY();
                            if (b.this.m || b.this.q != null) {
                                if (b.this.q != null && (v = b.this.v()) != null && (b.this.q == null || !b.this.q.equals(v))) {
                                    b.this.z(v);
                                }
                            } else {
                                float f2 = b.this.f60900h - b.this.f60898f;
                                float f3 = b.this.f60901i - b.this.f60899g;
                                if ((f2 * f2) + (f3 * f3) > b.this.f60894b * b.this.f60894b) {
                                    b.this.m = true;
                                }
                            }
                        }
                        return b.this.q != null;
                    } else if (action != 3) {
                        return false;
                    }
                }
                b.this.u();
                return false;
            }
            b.this.f60898f = (int) motionEvent.getX();
            b.this.f60899g = (int) motionEvent.getY();
            b.this.m = false;
            b.this.A();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            b.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements SwipeBackLayout.b {
        public d() {
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.b
        public void a(boolean z) {
            b.this.n = false;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.b
        public void b() {
            b.this.n = true;
            b.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public View f60906a;

        /* renamed from: b  reason: collision with root package name */
        public int f60907b;

        /* renamed from: c  reason: collision with root package name */
        public int f60908c;

        public e(View view, int i2, int i3) {
            this.f60906a = view;
            this.f60907b = i2;
            this.f60908c = i3;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return eVar.f60907b == this.f60907b && eVar.f60908c == this.f60908c && eVar.f60906a == this.f60906a;
        }
    }

    public b(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        this.f60893a = emotionPackageDetailActivity;
        PackageDetailListView listView = emotionPackageDetailActivity.getListView();
        this.l = listView;
        listView.setTouchEventInterceptHandler(this.s);
        this.j = emotionPackageDetailActivity.getSafeHandler();
        this.l = emotionPackageDetailActivity.getListView();
        this.f60894b = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.f60895c = l.g(emotionPackageDetailActivity, R.dimen.ds240);
        this.f60896d = l.g(emotionPackageDetailActivity, R.dimen.ds260);
        this.l.setOnScrollListener(new c());
        SwipeBackLayout swipeBackLayout = emotionPackageDetailActivity.getSwipeBackLayout();
        if (swipeBackLayout != null) {
            swipeBackLayout.setOnSlidingStateChangeListener(new d());
        }
    }

    public final void A() {
        this.j.removeCallbacks(this.r);
        this.j.postDelayed(this.r, 500L);
    }

    public final void B() {
        e v;
        if (this.m || this.n || this.q != null || (v = v()) == null) {
            return;
        }
        z(v);
    }

    public void s() {
        this.j.removeCallbacks(this.r);
        u();
    }

    public final boolean t(View view, EmotionPackageData.SingleEmotionData singleEmotionData) {
        if (singleEmotionData == null || TextUtils.isEmpty(singleEmotionData.url) || view == null) {
            return false;
        }
        Log.d("PackageDetailPreview", "show preview, url: " + singleEmotionData.url);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        EmotionPreview emotionPreview = new EmotionPreview(this.f60893a);
        this.k = emotionPreview;
        SkinManager.setBackgroundResource(emotionPreview, R.drawable.bg_expression_bubble, this.p);
        this.k.e(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f60895c, this.f60896d);
        int i2 = iArr[0] - 60;
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = iArr[1] - this.f60896d;
        if (i2 < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.f60895c > l.k(this.f60893a)) {
            layoutParams.leftMargin = l.k(this.f60893a) - this.f60895c;
        }
        if (this.o == null) {
            this.o = (FrameLayout) this.f60893a.getWindow().getDecorView();
        }
        if (this.k.getParent() != null) {
            ViewParent parent = this.k.getParent();
            FrameLayout frameLayout = this.o;
            if (parent == frameLayout) {
                frameLayout.removeView(this.k);
            }
        }
        this.o.addView(this.k, layoutParams);
        return true;
    }

    public final void u() {
        this.f60901i = -1;
        this.f60900h = -1;
        this.f60899g = -1;
        this.f60898f = -1;
        this.m = false;
        this.f60893a.setSwipeBackEnabled(true);
        EmotionPreview emotionPreview = this.k;
        if (emotionPreview == null || this.q == null) {
            return;
        }
        if (emotionPreview.getParent() != null) {
            ViewParent parent = this.k.getParent();
            FrameLayout frameLayout = this.o;
            if (parent == frameLayout) {
                frameLayout.removeView(this.k);
            }
        }
        this.q = null;
        this.l.setDisableListViewTouchIntercept(false);
    }

    public final e v() {
        int i2 = this.f60900h;
        int i3 = this.f60901i;
        if (i2 < 0) {
            i2 = this.f60898f;
        }
        if (i3 < 0) {
            i3 = this.f60899g;
        }
        int pointToPosition = this.l.pointToPosition(i2, i3);
        if (pointToPosition >= 0) {
            this.f60897e.set(i2, i3, i2 + 1, i3 + 1);
            View childAt = this.l.getChildAt(pointToPosition);
            if (childAt == null || !(childAt instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) childAt;
            this.l.offsetRectIntoDescendantCoords(childAt, this.f60897e);
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = viewGroup.getChildAt(i4);
                if (childAt2.getLeft() < this.f60897e.left && childAt2.getRight() > this.f60897e.right && childAt2.getTop() < this.f60897e.left && childAt2.getBottom() > this.f60897e.bottom) {
                    int headerViewsCount = pointToPosition - this.l.getHeaderViewsCount();
                    e eVar = new e(childAt2, headerViewsCount, i4);
                    Log.d("PackageDetailPreview", "touch cell: (" + headerViewsCount + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + SmallTailInfo.EMOTION_SUFFIX);
                    return eVar;
                }
            }
            return null;
        }
        return null;
    }

    public final EmotionPackageData.SingleEmotionData w(int i2, int i3) {
        List list;
        d.a.c.k.e.e adapter2 = this.l.getAdapter2();
        int i4 = (i2 * 4) + i3;
        int headerViewsCount = i2 + this.l.getHeaderViewsCount();
        if (adapter2 == null || headerViewsCount <= -1 || headerViewsCount >= adapter2.getCount() || (list = (List) adapter2.getItem(headerViewsCount)) == null || i4 <= -1 || i4 >= list.size()) {
            return null;
        }
        return (EmotionPackageData.SingleEmotionData) list.get(i4);
    }

    public final void x() {
        EmotionPreview emotionPreview = this.k;
        if (emotionPreview == null || this.o == null) {
            return;
        }
        if (emotionPreview.getParent() != null) {
            ViewParent parent = this.k.getParent();
            FrameLayout frameLayout = this.o;
            if (parent == frameLayout) {
                frameLayout.removeView(this.k);
            }
        }
        this.k = null;
    }

    public void y(int i2) {
        this.p = i2;
        EmotionPreview emotionPreview = this.k;
        if (emotionPreview != null) {
            SkinManager.setBackgroundResource(emotionPreview, R.drawable.bg_expression_bubble, i2);
        }
    }

    public final void z(e eVar) {
        if (eVar == null) {
            return;
        }
        x();
        if (t(eVar.f60906a, w(eVar.f60907b, eVar.f60908c))) {
            this.q = eVar;
            this.l.setDisableListViewTouchIntercept(true);
            this.f60893a.setSwipeBackEnabled(false);
        }
    }
}
