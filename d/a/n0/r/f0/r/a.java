package d.a.n0.r.f0.r;

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
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f53578a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f53579b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53580c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f53581d;

    /* renamed from: e  reason: collision with root package name */
    public c f53582e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53583f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53584g;

    /* renamed from: h  reason: collision with root package name */
    public int f53585h;

    /* renamed from: i  reason: collision with root package name */
    public Context f53586i;
    public List<n> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: d.a.n0.r.f0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1197a implements Handler.Callback {
        public C1197a() {
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
            } else if (i2 != 0 || (count = a.this.f53581d.getCount()) < 2) {
            } else {
                int currentItem = a.this.f53578a.getCurrentItem();
                int i3 = count - 2;
                if (currentItem < 1) {
                    a.this.f53578a.setCurrentItem(i3, false);
                } else if (currentItem > i3) {
                    a.this.f53578a.setCurrentItem(1, false);
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
            if (a.this.f53582e != null && a.this.f53582e.a(i2) == i2) {
                if (a.this.f53579b != null) {
                    a.this.f53579b.setPosition(a.this.f53582e.c(i2));
                }
                if (a.this.k != null) {
                    a.this.k.onPageSelected(a.this.f53582e.c(i2));
                }
            }
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.f53583f = false;
        this.f53584g = true;
        this.f53585h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1197a();
        this.n = new Handler(this.m);
        this.o = new b();
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        if (this.f53578a == null || this.f53581d == null) {
            return;
        }
        i c2 = j.c(this.f53586i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f53581d.getCount()) >= 2) {
            int currentItem = this.f53578a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f53578a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f53578a.setCurrentItem(1, false);
            } else {
                this.f53578a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.f53578a = viewPager;
        this.f53579b = indicatorView;
        this.f53580c = textView;
        this.f53586i = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f53581d = bdBaseViewPagerAdapter;
        ViewPager viewPager2 = this.f53578a;
        if (viewPager2 != null) {
            viewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f53578a.setOnPageChangeListener(this.o);
        }
    }

    public void i(Context context, d.a.n0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f53581d;
        if (bdBaseViewPagerAdapter != null) {
            bdBaseViewPagerAdapter.k(context, bVar);
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
        c cVar = new c(list, this.f53583f, this.f53585h);
        this.f53582e = cVar;
        cVar.i(2);
        this.f53582e.g(1);
        this.f53581d.l(this.f53582e.e());
        this.f53581d.notifyDataSetChanged();
        this.f53578a.setCurrentItem(this.f53582e.d(), false);
        if (this.f53582e.b() <= 0) {
            return;
        }
        if (this.f53582e.b() > this.f53585h) {
            TextView textView = this.f53580c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f53580c.setOnClickListener(null);
                IndicatorView indicatorView = this.f53579b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f53579b;
                if (indicatorView2 != null && !this.f53583f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f53579b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f53579b.getCount();
                int i2 = this.f53585h;
                if (count != i2) {
                    this.f53579b.setCount(i2);
                }
            }
            o();
        }
        if (this.f53582e.b() >= 2 && this.f53582e.b() <= this.f53585h) {
            TextView textView2 = this.f53580c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f53579b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f53579b.getCount() != this.f53582e.b()) {
                    this.f53579b.setCount(this.f53582e.b());
                }
            }
            o();
        }
        if (this.f53582e.b() < 2) {
            TextView textView3 = this.f53580c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f53579b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            p();
        }
    }

    public void l(boolean z) {
        this.f53584g = z;
    }

    public void m(boolean z) {
        this.f53583f = z;
    }

    public void n(int i2) {
        this.f53585h = i2;
        c cVar = this.f53582e;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void o() {
        if (this.f53584g) {
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
        this.f53583f = false;
        this.f53584g = true;
        this.f53585h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1197a();
        this.n = new Handler(this.m);
        this.o = new b();
        this.f53583f = z;
        this.f53584g = z2;
        n(i2);
        h(context, viewPager, indicatorView, textView);
    }
}
