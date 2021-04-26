package d.a.j0.j1.t;

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
import d.a.c.j.e.n;
import d.a.i0.r.f0.r.c;
import d.a.j0.j1.o.l.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f55915a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f55916b;

    /* renamed from: c  reason: collision with root package name */
    public l f55917c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55918d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f55919e;

    /* renamed from: f  reason: collision with root package name */
    public c f55920f;
    public Context j;
    public ViewPager.OnPageChangeListener l;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55921g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55922h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f55923i = 2;
    public List<n> k = new ArrayList();
    public long m = 5000;
    public final Handler.Callback n = new a();
    public final Handler o = new Handler(this.n);
    public ViewPager.OnPageChangeListener p = new C1327b();

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

    /* renamed from: d.a.j0.j1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1327b implements ViewPager.OnPageChangeListener {
        public C1327b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            if (b.this.l != null) {
                b.this.l.onPageScrollStateChanged(i2);
            }
            if (i2 == 1) {
                b.this.s();
            } else if (i2 != 0 || (count = b.this.f55919e.getCount()) < 2) {
            } else {
                int currentItem = b.this.f55915a.getCurrentItem();
                int i3 = count - 2;
                if (currentItem < 1) {
                    b.this.f55915a.setCurrentItem(i3, false);
                } else if (currentItem > i3) {
                    b.this.f55915a.setCurrentItem(1, false);
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
            if (b.this.f55920f != null && b.this.f55920f.a(i2) == i2) {
                if (b.this.f55916b != null) {
                    b.this.f55916b.setPosition(b.this.f55920f.c(i2));
                    if (b.this.f55917c != null) {
                        b.this.f55916b.setVisibility(8);
                        b.this.f55917c.b(b.this.f55920f.c(i2));
                    }
                }
                if (b.this.l != null) {
                    b.this.l.onPageSelected(b.this.f55920f.c(i2));
                }
            }
        }
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        if (this.f55915a == null || this.f55919e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f55919e.getCount()) >= 2) {
            int currentItem = this.f55915a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f55915a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f55915a.setCurrentItem(1, false);
            } else {
                this.f55915a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.f55915a = listViewPager;
        this.f55916b = indicatorView;
        this.f55918d = textView;
        this.j = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f55919e = bdBaseViewPagerAdapter;
        ListViewPager listViewPager2 = this.f55915a;
        if (listViewPager2 != null) {
            listViewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f55915a.setOnPageChangeListener(this.p);
        }
    }

    public final boolean k() {
        ListViewPager listViewPager = this.f55915a;
        if (listViewPager == null) {
            return false;
        }
        int[] iArr = new int[2];
        listViewPager.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.f55915a.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < d.a.c.e.p.l.i(this.j);
    }

    public void l(Context context, d.a.i0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f55919e;
        if (bdBaseViewPagerAdapter != null) {
            bdBaseViewPagerAdapter.g(context, bVar);
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
        c cVar = new c(list, this.f55921g, this.f55923i);
        this.f55920f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f55920f.g(1);
        this.f55919e.h(this.f55920f.e());
        this.f55919e.notifyDataSetChanged();
        this.f55915a.setCurrentItem(this.f55920f.d(), false);
        if (this.f55920f.b() <= 0) {
            return;
        }
        if (this.f55920f.b() > this.f55923i) {
            TextView textView = this.f55918d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f55918d.setOnClickListener(null);
                IndicatorView indicatorView = this.f55916b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f55916b != null && this.f55918d == null && this.f55921g) {
                z = false;
            }
            if (!z) {
                this.f55916b.setVisibility(8);
                int count = this.f55916b.getCount();
                int i2 = this.f55923i;
                if (count != i2) {
                    this.f55916b.setCount(i2);
                }
            }
            r();
        }
        if (this.f55920f.b() >= 2 && this.f55920f.b() <= this.f55923i) {
            TextView textView2 = this.f55918d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f55916b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f55916b.getCount() != this.f55920f.b()) {
                    this.f55916b.setCount(this.f55920f.b());
                    l lVar = this.f55917c;
                    if (lVar != null) {
                        lVar.a(this.f55920f.b());
                        this.f55916b.setVisibility(8);
                    }
                } else {
                    l lVar2 = this.f55917c;
                    if (lVar2 != null) {
                        lVar2.a(this.f55920f.b());
                        this.f55916b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f55920f.b() < 2) {
            TextView textView3 = this.f55918d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f55916b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(l lVar) {
        if (lVar != null) {
            this.f55916b.setVisibility(8);
        } else {
            this.f55916b.setVisibility(0);
        }
        this.f55917c = lVar;
    }

    public void p(int i2) {
        this.f55923i = i2;
        c cVar = this.f55920f;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.l = onPageChangeListener;
    }

    public void r() {
        if (this.f55922h) {
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
