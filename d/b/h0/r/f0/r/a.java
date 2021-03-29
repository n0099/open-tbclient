package d.b.h0.r.f0.r;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import d.b.b.a.i;
import d.b.b.a.j;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f50564a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f50565b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50566c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f50567d;

    /* renamed from: e  reason: collision with root package name */
    public c f50568e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50569f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50570g;

    /* renamed from: h  reason: collision with root package name */
    public int f50571h;
    public Context i;
    public List<n> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: d.b.h0.r.f0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1079a implements Handler.Callback {
        public C1079a() {
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
        public void onPageScrollStateChanged(int i) {
            int count;
            if (a.this.k != null) {
                a.this.k.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                a.this.p();
            } else if (i != 0 || (count = a.this.f50567d.getCount()) < 2) {
            } else {
                int currentItem = a.this.f50564a.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    a.this.f50564a.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    a.this.f50564a.setCurrentItem(1, false);
                }
                a.this.o();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (a.this.k != null) {
                a.this.k.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (a.this.f50568e != null && a.this.f50568e.a(i) == i) {
                if (a.this.f50565b != null) {
                    a.this.f50565b.setPosition(a.this.f50568e.c(i));
                }
                if (a.this.k != null) {
                    a.this.k.onPageSelected(a.this.f50568e.c(i));
                }
            }
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.f50569f = false;
        this.f50570g = true;
        this.f50571h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1079a();
        this.n = new Handler(this.m);
        this.o = new b();
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        if (this.f50564a == null || this.f50567d == null) {
            return;
        }
        i c2 = j.c(this.i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f50567d.getCount()) >= 2) {
            int currentItem = this.f50564a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.f50564a.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.f50564a.setCurrentItem(1, false);
            } else {
                this.f50564a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.f50564a = viewPager;
        this.f50565b = indicatorView;
        this.f50566c = textView;
        this.i = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f50567d = bdBaseViewPagerAdapter;
        ViewPager viewPager2 = this.f50564a;
        if (viewPager2 != null) {
            viewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f50564a.setOnPageChangeListener(this.o);
        }
    }

    public void i(Context context, d.b.h0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f50567d;
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
        c cVar = new c(list, this.f50569f, this.f50571h);
        this.f50568e = cVar;
        cVar.i(2);
        this.f50568e.g(1);
        this.f50567d.l(this.f50568e.e());
        this.f50567d.notifyDataSetChanged();
        this.f50564a.setCurrentItem(this.f50568e.d(), false);
        if (this.f50568e.b() <= 0) {
            return;
        }
        if (this.f50568e.b() > this.f50571h) {
            TextView textView = this.f50566c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f50566c.setOnClickListener(null);
                IndicatorView indicatorView = this.f50565b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f50565b;
                if (indicatorView2 != null && !this.f50569f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f50565b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f50565b.getCount();
                int i = this.f50571h;
                if (count != i) {
                    this.f50565b.setCount(i);
                }
            }
            o();
        }
        if (this.f50568e.b() >= 2 && this.f50568e.b() <= this.f50571h) {
            TextView textView2 = this.f50566c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f50565b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f50565b.getCount() != this.f50568e.b()) {
                    this.f50565b.setCount(this.f50568e.b());
                }
            }
            o();
        }
        if (this.f50568e.b() < 2) {
            TextView textView3 = this.f50566c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f50565b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            p();
        }
    }

    public void l(boolean z) {
        this.f50570g = z;
    }

    public void m(boolean z) {
        this.f50569f = z;
    }

    public void n(int i) {
        this.f50571h = i;
        c cVar = this.f50568e;
        if (cVar != null) {
            cVar.h(i);
        }
    }

    public void o() {
        if (this.f50570g) {
            this.n.removeMessages(1);
            this.n.sendEmptyMessageDelayed(1, this.l);
            return;
        }
        this.n.removeMessages(1);
    }

    public void p() {
        this.n.removeMessages(1);
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        this.f50569f = false;
        this.f50570g = true;
        this.f50571h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1079a();
        this.n = new Handler(this.m);
        this.o = new b();
        this.f50569f = z;
        this.f50570g = z2;
        n(i);
        h(context, viewPager, indicatorView, textView);
    }
}
