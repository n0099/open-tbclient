package d.b.i0.i1.t;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import d.b.b.a.i;
import d.b.b.a.j;
import d.b.b.j.e.n;
import d.b.h0.r.f0.r.c;
import d.b.i0.i1.o.l.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f56072a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f56073b;

    /* renamed from: c  reason: collision with root package name */
    public l f56074c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56075d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f56076e;

    /* renamed from: f  reason: collision with root package name */
    public c f56077f;
    public Context j;
    public ViewPager.OnPageChangeListener l;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56078g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56079h = true;
    public int i = 2;
    public List<n> k = new ArrayList();
    public long m = 5000;
    public final Handler.Callback n = new a();
    public final Handler o = new Handler(this.n);
    public ViewPager.OnPageChangeListener p = new C1308b();

    /* loaded from: classes4.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && b.this.k()) {
                b.this.i();
                return false;
            }
            return false;
        }
    }

    /* renamed from: d.b.i0.i1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1308b implements ViewPager.OnPageChangeListener {
        public C1308b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (b.this.l != null) {
                b.this.l.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                b.this.s();
            } else if (i != 0 || (count = b.this.f56076e.getCount()) < 2) {
            } else {
                int currentItem = b.this.f56072a.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    b.this.f56072a.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    b.this.f56072a.setCurrentItem(1, false);
                }
                b.this.r();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (b.this.l != null) {
                b.this.l.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (b.this.f56077f != null && b.this.f56077f.a(i) == i) {
                if (b.this.f56073b != null) {
                    b.this.f56073b.setPosition(b.this.f56077f.c(i));
                    if (b.this.f56074c != null) {
                        b.this.f56073b.setVisibility(8);
                        b.this.f56074c.b(b.this.f56077f.c(i));
                    }
                }
                if (b.this.l != null) {
                    b.this.l.onPageSelected(b.this.f56077f.c(i));
                }
            }
        }
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        if (this.f56072a == null || this.f56076e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f56076e.getCount()) >= 2) {
            int currentItem = this.f56072a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.f56072a.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.f56072a.setCurrentItem(1, false);
            } else {
                this.f56072a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.f56072a = listViewPager;
        this.f56073b = indicatorView;
        this.f56075d = textView;
        this.j = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f56076e = bdBaseViewPagerAdapter;
        ListViewPager listViewPager2 = this.f56072a;
        if (listViewPager2 != null) {
            listViewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f56072a.setOnPageChangeListener(this.p);
        }
    }

    public final boolean k() {
        ListViewPager listViewPager = this.f56072a;
        if (listViewPager == null) {
            return false;
        }
        int[] iArr = new int[2];
        listViewPager.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.f56072a.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < d.b.b.e.p.l.i(this.j);
    }

    public void l(Context context, d.b.h0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f56076e;
        if (bdBaseViewPagerAdapter != null) {
            bdBaseViewPagerAdapter.k(context, bVar);
        }
    }

    public void m(long j) {
        if (j < 0) {
            j = 0;
        }
        this.m = j;
    }

    public void n(List<n> list) {
        if (ListUtils.getCount(list) == 0) {
            return;
        }
        this.k = list;
        c cVar = new c(list, this.f56078g, this.i);
        this.f56077f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f56077f.g(1);
        this.f56076e.l(this.f56077f.e());
        this.f56076e.notifyDataSetChanged();
        this.f56072a.setCurrentItem(this.f56077f.d(), false);
        if (this.f56077f.b() <= 0) {
            return;
        }
        if (this.f56077f.b() > this.i) {
            TextView textView = this.f56075d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f56075d.setOnClickListener(null);
                IndicatorView indicatorView = this.f56073b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f56073b != null && this.f56075d == null && this.f56078g) {
                z = false;
            }
            if (!z) {
                this.f56073b.setVisibility(8);
                int count = this.f56073b.getCount();
                int i = this.i;
                if (count != i) {
                    this.f56073b.setCount(i);
                }
            }
            r();
        }
        if (this.f56077f.b() >= 2 && this.f56077f.b() <= this.i) {
            TextView textView2 = this.f56075d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f56073b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f56073b.getCount() != this.f56077f.b()) {
                    this.f56073b.setCount(this.f56077f.b());
                    l lVar = this.f56074c;
                    if (lVar != null) {
                        lVar.a(this.f56077f.b());
                        this.f56073b.setVisibility(8);
                    }
                } else {
                    l lVar2 = this.f56074c;
                    if (lVar2 != null) {
                        lVar2.a(this.f56077f.b());
                        this.f56073b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f56077f.b() < 2) {
            TextView textView3 = this.f56075d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f56073b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(l lVar) {
        if (lVar != null) {
            this.f56073b.setVisibility(8);
        } else {
            this.f56073b.setVisibility(0);
        }
        this.f56074c = lVar;
    }

    public void p(int i) {
        this.i = i;
        c cVar = this.f56077f;
        if (cVar != null) {
            cVar.h(i);
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.l = onPageChangeListener;
    }

    public void r() {
        if (this.f56079h) {
            this.o.removeMessages(1);
            this.o.sendEmptyMessageDelayed(1, this.m);
            return;
        }
        this.o.removeMessages(1);
    }

    public void s() {
        this.o.removeMessages(1);
    }
}
