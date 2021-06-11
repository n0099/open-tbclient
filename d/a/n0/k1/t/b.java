package d.a.n0.k1.t;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import d.a.c.a.i;
import d.a.c.a.j;
import d.a.c.k.e.n;
import d.a.m0.r.f0.r.c;
import d.a.n0.k1.o.l.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f60491a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f60492b;

    /* renamed from: c  reason: collision with root package name */
    public l f60493c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60494d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f60495e;

    /* renamed from: f  reason: collision with root package name */
    public c f60496f;
    public Context j;
    public ViewPager.OnPageChangeListener l;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60497g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60498h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f60499i = 2;
    public List<n> k = new ArrayList();
    public long m = 5000;
    public final Handler.Callback n = new a();
    public final Handler o = new Handler(this.n);
    public ViewPager.OnPageChangeListener p = new C1473b();

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

    /* renamed from: d.a.n0.k1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1473b implements ViewPager.OnPageChangeListener {
        public C1473b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            if (b.this.l != null) {
                b.this.l.onPageScrollStateChanged(i2);
            }
            if (i2 == 1) {
                b.this.s();
            } else if (i2 != 0 || (count = b.this.f60495e.getCount()) < 2) {
            } else {
                int currentItem = b.this.f60491a.getCurrentItem();
                int i3 = count - 2;
                if (currentItem < 1) {
                    b.this.f60491a.setCurrentItem(i3, false);
                } else if (currentItem > i3) {
                    b.this.f60491a.setCurrentItem(1, false);
                }
                b.this.r();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (b.this.l != null) {
                b.this.l.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (b.this.f60496f != null && b.this.f60496f.a(i2) == i2) {
                if (b.this.f60492b != null) {
                    b.this.f60492b.setPosition(b.this.f60496f.c(i2));
                    if (b.this.f60493c != null) {
                        b.this.f60492b.setVisibility(8);
                        b.this.f60493c.b(b.this.f60496f.c(i2));
                    }
                }
                if (b.this.l != null) {
                    b.this.l.onPageSelected(b.this.f60496f.c(i2));
                }
            }
        }
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        if (this.f60491a == null || this.f60495e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f60495e.getCount()) >= 2) {
            int currentItem = this.f60491a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f60491a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f60491a.setCurrentItem(1, false);
            } else {
                this.f60491a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.f60491a = listViewPager;
        this.f60492b = indicatorView;
        this.f60494d = textView;
        this.j = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f60495e = bdBaseViewPagerAdapter;
        ListViewPager listViewPager2 = this.f60491a;
        if (listViewPager2 != null) {
            listViewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f60491a.setOnPageChangeListener(this.p);
        }
    }

    public final boolean k() {
        ListViewPager listViewPager = this.f60491a;
        if (listViewPager == null) {
            return false;
        }
        int[] iArr = new int[2];
        listViewPager.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.f60491a.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < d.a.c.e.p.l.i(this.j);
    }

    public void l(Context context, d.a.m0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f60495e;
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
        c cVar = new c(list, this.f60497g, this.f60499i);
        this.f60496f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f60496f.g(1);
        this.f60495e.l(this.f60496f.e());
        this.f60495e.notifyDataSetChanged();
        this.f60491a.setCurrentItem(this.f60496f.d(), false);
        if (this.f60496f.b() <= 0) {
            return;
        }
        if (this.f60496f.b() > this.f60499i) {
            TextView textView = this.f60494d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f60494d.setOnClickListener(null);
                IndicatorView indicatorView = this.f60492b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f60492b != null && this.f60494d == null && this.f60497g) {
                z = false;
            }
            if (!z) {
                this.f60492b.setVisibility(8);
                int count = this.f60492b.getCount();
                int i2 = this.f60499i;
                if (count != i2) {
                    this.f60492b.setCount(i2);
                }
            }
            r();
        }
        if (this.f60496f.b() >= 2 && this.f60496f.b() <= this.f60499i) {
            TextView textView2 = this.f60494d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f60492b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f60492b.getCount() != this.f60496f.b()) {
                    this.f60492b.setCount(this.f60496f.b());
                    l lVar = this.f60493c;
                    if (lVar != null) {
                        lVar.a(this.f60496f.b());
                        this.f60492b.setVisibility(8);
                    }
                } else {
                    l lVar2 = this.f60493c;
                    if (lVar2 != null) {
                        lVar2.a(this.f60496f.b());
                        this.f60492b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f60496f.b() < 2) {
            TextView textView3 = this.f60494d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f60492b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(l lVar) {
        if (lVar != null) {
            this.f60492b.setVisibility(8);
        } else {
            this.f60492b.setVisibility(0);
        }
        this.f60493c = lVar;
    }

    public void p(int i2) {
        this.f60499i = i2;
        c cVar = this.f60496f;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.l = onPageChangeListener;
    }

    public void r() {
        if (this.f60498h) {
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
