package d.a.m0.r.f0.r;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import d.a.c.a.i;
import d.a.c.a.j;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f49796a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f49797b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49798c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f49799d;

    /* renamed from: e  reason: collision with root package name */
    public c f49800e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49801f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49802g;

    /* renamed from: h  reason: collision with root package name */
    public int f49803h;

    /* renamed from: i  reason: collision with root package name */
    public Context f49804i;
    public List<n> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: d.a.m0.r.f0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1138a implements Handler.Callback {
        public C1138a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            a.this.g();
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            if (a.this.k != null) {
                a.this.k.onPageScrollStateChanged(i2);
            }
            if (i2 == 1) {
                a.this.p();
            } else if (i2 != 0 || (count = a.this.f49799d.getCount()) < 2) {
            } else {
                int currentItem = a.this.f49796a.getCurrentItem();
                int i3 = count - 2;
                if (currentItem < 1) {
                    a.this.f49796a.setCurrentItem(i3, false);
                } else if (currentItem > i3) {
                    a.this.f49796a.setCurrentItem(1, false);
                }
                a.this.o();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (a.this.k != null) {
                a.this.k.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (a.this.f49800e != null && a.this.f49800e.a(i2) == i2) {
                if (a.this.f49797b != null) {
                    a.this.f49797b.setPosition(a.this.f49800e.c(i2));
                }
                if (a.this.k != null) {
                    a.this.k.onPageSelected(a.this.f49800e.c(i2));
                }
            }
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.f49801f = false;
        this.f49802g = true;
        this.f49803h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1138a();
        this.n = new Handler(this.m);
        this.o = new b();
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        if (this.f49796a == null || this.f49799d == null) {
            return;
        }
        i c2 = j.c(this.f49804i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f49799d.getCount()) >= 2) {
            int currentItem = this.f49796a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f49796a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f49796a.setCurrentItem(1, false);
            } else {
                this.f49796a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.f49796a = viewPager;
        this.f49797b = indicatorView;
        this.f49798c = textView;
        this.f49804i = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f49799d = bdBaseViewPagerAdapter;
        ViewPager viewPager2 = this.f49796a;
        if (viewPager2 != null) {
            viewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f49796a.setOnPageChangeListener(this.o);
        }
    }

    public void i(Context context, d.a.m0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f49799d;
        if (bdBaseViewPagerAdapter != null) {
            bdBaseViewPagerAdapter.g(context, bVar);
        }
    }

    public void j(long j) {
        if (j < 0) {
            j = 0;
        }
        this.l = j;
    }

    public void k(List<n> list) {
        if (ListUtils.getCount(list) == 0) {
            return;
        }
        this.j = list;
        c cVar = new c(list, this.f49801f, this.f49803h);
        this.f49800e = cVar;
        cVar.i(2);
        this.f49800e.g(1);
        this.f49799d.h(this.f49800e.e());
        this.f49799d.notifyDataSetChanged();
        this.f49796a.setCurrentItem(this.f49800e.d(), false);
        if (this.f49800e.b() <= 0) {
            return;
        }
        if (this.f49800e.b() > this.f49803h) {
            TextView textView = this.f49798c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f49798c.setOnClickListener(null);
                IndicatorView indicatorView = this.f49797b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f49797b;
                if (indicatorView2 != null && !this.f49801f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f49797b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f49797b.getCount();
                int i2 = this.f49803h;
                if (count != i2) {
                    this.f49797b.setCount(i2);
                }
            }
            o();
        }
        if (this.f49800e.b() >= 2 && this.f49800e.b() <= this.f49803h) {
            TextView textView2 = this.f49798c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f49797b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f49797b.getCount() != this.f49800e.b()) {
                    this.f49797b.setCount(this.f49800e.b());
                }
            }
            o();
        }
        if (this.f49800e.b() < 2) {
            TextView textView3 = this.f49798c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f49797b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            p();
        }
    }

    public void l(boolean z) {
        this.f49802g = z;
    }

    public void m(boolean z) {
        this.f49801f = z;
    }

    public void n(int i2) {
        this.f49803h = i2;
        c cVar = this.f49800e;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void o() {
        if (this.f49802g) {
            this.n.removeMessages(1);
            this.n.sendEmptyMessageDelayed(1, this.l);
            return;
        }
        this.n.removeMessages(1);
    }

    public void p() {
        this.n.removeMessages(1);
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i2, boolean z, boolean z2) {
        this.f49801f = false;
        this.f49802g = true;
        this.f49803h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1138a();
        this.n = new Handler(this.m);
        this.o = new b();
        this.f49801f = z;
        this.f49802g = z2;
        n(i2);
        h(context, viewPager, indicatorView, textView);
    }
}
