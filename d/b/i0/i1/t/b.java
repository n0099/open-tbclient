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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f56073a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f56074b;

    /* renamed from: c  reason: collision with root package name */
    public l f56075c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56076d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f56077e;

    /* renamed from: f  reason: collision with root package name */
    public c f56078f;
    public Context j;
    public ViewPager.OnPageChangeListener l;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56079g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56080h = true;
    public int i = 2;
    public List<n> k = new ArrayList();
    public long m = 5000;
    public final Handler.Callback n = new a();
    public final Handler o = new Handler(this.n);
    public ViewPager.OnPageChangeListener p = new C1309b();

    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
    public class C1309b implements ViewPager.OnPageChangeListener {
        public C1309b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (b.this.l != null) {
                b.this.l.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                b.this.s();
            } else if (i != 0 || (count = b.this.f56077e.getCount()) < 2) {
            } else {
                int currentItem = b.this.f56073a.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    b.this.f56073a.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    b.this.f56073a.setCurrentItem(1, false);
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
            if (b.this.f56078f != null && b.this.f56078f.a(i) == i) {
                if (b.this.f56074b != null) {
                    b.this.f56074b.setPosition(b.this.f56078f.c(i));
                    if (b.this.f56075c != null) {
                        b.this.f56074b.setVisibility(8);
                        b.this.f56075c.b(b.this.f56078f.c(i));
                    }
                }
                if (b.this.l != null) {
                    b.this.l.onPageSelected(b.this.f56078f.c(i));
                }
            }
        }
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        if (this.f56073a == null || this.f56077e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f56077e.getCount()) >= 2) {
            int currentItem = this.f56073a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.f56073a.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.f56073a.setCurrentItem(1, false);
            } else {
                this.f56073a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.f56073a = listViewPager;
        this.f56074b = indicatorView;
        this.f56076d = textView;
        this.j = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f56077e = bdBaseViewPagerAdapter;
        ListViewPager listViewPager2 = this.f56073a;
        if (listViewPager2 != null) {
            listViewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f56073a.setOnPageChangeListener(this.p);
        }
    }

    public final boolean k() {
        ListViewPager listViewPager = this.f56073a;
        if (listViewPager == null) {
            return false;
        }
        int[] iArr = new int[2];
        listViewPager.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.f56073a.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < d.b.b.e.p.l.i(this.j);
    }

    public void l(Context context, d.b.h0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f56077e;
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
        c cVar = new c(list, this.f56079g, this.i);
        this.f56078f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f56078f.g(1);
        this.f56077e.l(this.f56078f.e());
        this.f56077e.notifyDataSetChanged();
        this.f56073a.setCurrentItem(this.f56078f.d(), false);
        if (this.f56078f.b() <= 0) {
            return;
        }
        if (this.f56078f.b() > this.i) {
            TextView textView = this.f56076d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f56076d.setOnClickListener(null);
                IndicatorView indicatorView = this.f56074b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f56074b != null && this.f56076d == null && this.f56079g) {
                z = false;
            }
            if (!z) {
                this.f56074b.setVisibility(8);
                int count = this.f56074b.getCount();
                int i = this.i;
                if (count != i) {
                    this.f56074b.setCount(i);
                }
            }
            r();
        }
        if (this.f56078f.b() >= 2 && this.f56078f.b() <= this.i) {
            TextView textView2 = this.f56076d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f56074b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f56074b.getCount() != this.f56078f.b()) {
                    this.f56074b.setCount(this.f56078f.b());
                    l lVar = this.f56075c;
                    if (lVar != null) {
                        lVar.a(this.f56078f.b());
                        this.f56074b.setVisibility(8);
                    }
                } else {
                    l lVar2 = this.f56075c;
                    if (lVar2 != null) {
                        lVar2.a(this.f56078f.b());
                        this.f56074b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f56078f.b() < 2) {
            TextView textView3 = this.f56076d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f56074b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(l lVar) {
        if (lVar != null) {
            this.f56074b.setVisibility(8);
        } else {
            this.f56074b.setVisibility(0);
        }
        this.f56075c = lVar;
    }

    public void p(int i) {
        this.i = i;
        c cVar = this.f56078f;
        if (cVar != null) {
            cVar.h(i);
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.l = onPageChangeListener;
    }

    public void r() {
        if (this.f56080h) {
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
