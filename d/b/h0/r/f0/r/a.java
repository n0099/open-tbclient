package d.b.h0.r.f0.r;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import d.b.c.a.i;
import d.b.c.a.j;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f50971a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f50972b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50973c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f50974d;

    /* renamed from: e  reason: collision with root package name */
    public c f50975e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50976f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50977g;

    /* renamed from: h  reason: collision with root package name */
    public int f50978h;
    public Context i;
    public List<n> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: d.b.h0.r.f0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1092a implements Handler.Callback {
        public C1092a() {
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
            } else if (i != 0 || (count = a.this.f50974d.getCount()) < 2) {
            } else {
                int currentItem = a.this.f50971a.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    a.this.f50971a.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    a.this.f50971a.setCurrentItem(1, false);
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
            if (a.this.f50975e != null && a.this.f50975e.a(i) == i) {
                if (a.this.f50972b != null) {
                    a.this.f50972b.setPosition(a.this.f50975e.c(i));
                }
                if (a.this.k != null) {
                    a.this.k.onPageSelected(a.this.f50975e.c(i));
                }
            }
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.f50976f = false;
        this.f50977g = true;
        this.f50978h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1092a();
        this.n = new Handler(this.m);
        this.o = new b();
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        if (this.f50971a == null || this.f50974d == null) {
            return;
        }
        i c2 = j.c(this.i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f50974d.getCount()) >= 2) {
            int currentItem = this.f50971a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.f50971a.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.f50971a.setCurrentItem(1, false);
            } else {
                this.f50971a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        this.f50971a = viewPager;
        this.f50972b = indicatorView;
        this.f50973c = textView;
        this.i = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f50974d = bdBaseViewPagerAdapter;
        ViewPager viewPager2 = this.f50971a;
        if (viewPager2 != null) {
            viewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f50971a.setOnPageChangeListener(this.o);
        }
    }

    public void i(Context context, d.b.h0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f50974d;
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
        c cVar = new c(list, this.f50976f, this.f50978h);
        this.f50975e = cVar;
        cVar.i(2);
        this.f50975e.g(1);
        this.f50974d.l(this.f50975e.e());
        this.f50974d.notifyDataSetChanged();
        this.f50971a.setCurrentItem(this.f50975e.d(), false);
        if (this.f50975e.b() <= 0) {
            return;
        }
        if (this.f50975e.b() > this.f50978h) {
            TextView textView = this.f50973c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f50973c.setOnClickListener(null);
                IndicatorView indicatorView = this.f50972b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f50972b;
                if (indicatorView2 != null && !this.f50976f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f50972b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f50972b.getCount();
                int i = this.f50978h;
                if (count != i) {
                    this.f50972b.setCount(i);
                }
            }
            o();
        }
        if (this.f50975e.b() >= 2 && this.f50975e.b() <= this.f50978h) {
            TextView textView2 = this.f50973c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f50972b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f50972b.getCount() != this.f50975e.b()) {
                    this.f50972b.setCount(this.f50975e.b());
                }
            }
            o();
        }
        if (this.f50975e.b() < 2) {
            TextView textView3 = this.f50973c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f50972b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            p();
        }
    }

    public void l(boolean z) {
        this.f50977g = z;
    }

    public void m(boolean z) {
        this.f50976f = z;
    }

    public void n(int i) {
        this.f50978h = i;
        c cVar = this.f50975e;
        if (cVar != null) {
            cVar.h(i);
        }
    }

    public void o() {
        if (this.f50977g) {
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
        this.f50976f = false;
        this.f50977g = true;
        this.f50978h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1092a();
        this.n = new Handler(this.m);
        this.o = new b();
        this.f50976f = z;
        this.f50977g = z2;
        n(i);
        h(context, viewPager, indicatorView, textView);
    }
}
