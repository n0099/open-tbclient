package d.a.o0.k1.t;

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
import d.a.n0.r.f0.r.c;
import d.a.o0.k1.o.l.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f60616a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f60617b;

    /* renamed from: c  reason: collision with root package name */
    public l f60618c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60619d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f60620e;

    /* renamed from: f  reason: collision with root package name */
    public c f60621f;
    public Context j;
    public ViewPager.OnPageChangeListener l;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60622g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60623h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f60624i = 2;
    public List<n> k = new ArrayList();
    public long m = 5000;
    public final Handler.Callback n = new a();
    public final Handler o = new Handler(this.n);
    public ViewPager.OnPageChangeListener p = new C1477b();

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

    /* renamed from: d.a.o0.k1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1477b implements ViewPager.OnPageChangeListener {
        public C1477b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            if (b.this.l != null) {
                b.this.l.onPageScrollStateChanged(i2);
            }
            if (i2 == 1) {
                b.this.s();
            } else if (i2 != 0 || (count = b.this.f60620e.getCount()) < 2) {
            } else {
                int currentItem = b.this.f60616a.getCurrentItem();
                int i3 = count - 2;
                if (currentItem < 1) {
                    b.this.f60616a.setCurrentItem(i3, false);
                } else if (currentItem > i3) {
                    b.this.f60616a.setCurrentItem(1, false);
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
            if (b.this.f60621f != null && b.this.f60621f.a(i2) == i2) {
                if (b.this.f60617b != null) {
                    b.this.f60617b.setPosition(b.this.f60621f.c(i2));
                    if (b.this.f60618c != null) {
                        b.this.f60617b.setVisibility(8);
                        b.this.f60618c.b(b.this.f60621f.c(i2));
                    }
                }
                if (b.this.l != null) {
                    b.this.l.onPageSelected(b.this.f60621f.c(i2));
                }
            }
        }
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        if (this.f60616a == null || this.f60620e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f60620e.getCount()) >= 2) {
            int currentItem = this.f60616a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f60616a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f60616a.setCurrentItem(1, false);
            } else {
                this.f60616a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.f60616a = listViewPager;
        this.f60617b = indicatorView;
        this.f60619d = textView;
        this.j = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f60620e = bdBaseViewPagerAdapter;
        ListViewPager listViewPager2 = this.f60616a;
        if (listViewPager2 != null) {
            listViewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f60616a.setOnPageChangeListener(this.p);
        }
    }

    public final boolean k() {
        ListViewPager listViewPager = this.f60616a;
        if (listViewPager == null) {
            return false;
        }
        int[] iArr = new int[2];
        listViewPager.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.f60616a.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < d.a.c.e.p.l.i(this.j);
    }

    public void l(Context context, d.a.n0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f60620e;
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
        c cVar = new c(list, this.f60622g, this.f60624i);
        this.f60621f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f60621f.g(1);
        this.f60620e.l(this.f60621f.e());
        this.f60620e.notifyDataSetChanged();
        this.f60616a.setCurrentItem(this.f60621f.d(), false);
        if (this.f60621f.b() <= 0) {
            return;
        }
        if (this.f60621f.b() > this.f60624i) {
            TextView textView = this.f60619d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f60619d.setOnClickListener(null);
                IndicatorView indicatorView = this.f60617b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f60617b != null && this.f60619d == null && this.f60622g) {
                z = false;
            }
            if (!z) {
                this.f60617b.setVisibility(8);
                int count = this.f60617b.getCount();
                int i2 = this.f60624i;
                if (count != i2) {
                    this.f60617b.setCount(i2);
                }
            }
            r();
        }
        if (this.f60621f.b() >= 2 && this.f60621f.b() <= this.f60624i) {
            TextView textView2 = this.f60619d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f60617b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f60617b.getCount() != this.f60621f.b()) {
                    this.f60617b.setCount(this.f60621f.b());
                    l lVar = this.f60618c;
                    if (lVar != null) {
                        lVar.a(this.f60621f.b());
                        this.f60617b.setVisibility(8);
                    }
                } else {
                    l lVar2 = this.f60618c;
                    if (lVar2 != null) {
                        lVar2.a(this.f60621f.b());
                        this.f60617b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f60621f.b() < 2) {
            TextView textView3 = this.f60619d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f60617b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(l lVar) {
        if (lVar != null) {
            this.f60617b.setVisibility(8);
        } else {
            this.f60617b.setVisibility(0);
        }
        this.f60618c = lVar;
    }

    public void p(int i2) {
        this.f60624i = i2;
        c cVar = this.f60621f;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.l = onPageChangeListener;
    }

    public void r() {
        if (this.f60623h) {
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
