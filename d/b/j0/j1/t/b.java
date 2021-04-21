package d.b.j0.j1.t;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import d.b.c.a.i;
import d.b.c.a.j;
import d.b.c.j.e.n;
import d.b.i0.r.f0.r.c;
import d.b.j0.j1.o.l.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f57941a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f57942b;

    /* renamed from: c  reason: collision with root package name */
    public l f57943c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57944d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f57945e;

    /* renamed from: f  reason: collision with root package name */
    public c f57946f;
    public Context j;
    public ViewPager.OnPageChangeListener l;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57947g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57948h = true;
    public int i = 2;
    public List<n> k = new ArrayList();
    public long m = 5000;
    public final Handler.Callback n = new a();
    public final Handler o = new Handler(this.n);
    public ViewPager.OnPageChangeListener p = new C1388b();

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

    /* renamed from: d.b.j0.j1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1388b implements ViewPager.OnPageChangeListener {
        public C1388b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            if (b.this.l != null) {
                b.this.l.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                b.this.s();
            } else if (i != 0 || (count = b.this.f57945e.getCount()) < 2) {
            } else {
                int currentItem = b.this.f57941a.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    b.this.f57941a.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    b.this.f57941a.setCurrentItem(1, false);
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
            if (b.this.f57946f != null && b.this.f57946f.a(i) == i) {
                if (b.this.f57942b != null) {
                    b.this.f57942b.setPosition(b.this.f57946f.c(i));
                    if (b.this.f57943c != null) {
                        b.this.f57942b.setVisibility(8);
                        b.this.f57943c.b(b.this.f57946f.c(i));
                    }
                }
                if (b.this.l != null) {
                    b.this.l.onPageSelected(b.this.f57946f.c(i));
                }
            }
        }
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        if (this.f57941a == null || this.f57945e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f57945e.getCount()) >= 2) {
            int currentItem = this.f57941a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.f57941a.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.f57941a.setCurrentItem(1, false);
            } else {
                this.f57941a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        this.f57941a = listViewPager;
        this.f57942b = indicatorView;
        this.f57944d = textView;
        this.j = context;
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
        this.f57945e = bdBaseViewPagerAdapter;
        ListViewPager listViewPager2 = this.f57941a;
        if (listViewPager2 != null) {
            listViewPager2.setAdapter(bdBaseViewPagerAdapter);
            this.f57941a.setOnPageChangeListener(this.p);
        }
    }

    public final boolean k() {
        ListViewPager listViewPager = this.f57941a;
        if (listViewPager == null) {
            return false;
        }
        int[] iArr = new int[2];
        listViewPager.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (this.f57941a.getMeasuredHeight() / 2);
        return measuredHeight > 0 && measuredHeight < d.b.c.e.p.l.i(this.j);
    }

    public void l(Context context, d.b.i0.r.f0.r.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter = this.f57945e;
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
        c cVar = new c(list, this.f57947g, this.i);
        this.f57946f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f57946f.g(1);
        this.f57945e.l(this.f57946f.e());
        this.f57945e.notifyDataSetChanged();
        this.f57941a.setCurrentItem(this.f57946f.d(), false);
        if (this.f57946f.b() <= 0) {
            return;
        }
        if (this.f57946f.b() > this.i) {
            TextView textView = this.f57944d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f57944d.setOnClickListener(null);
                IndicatorView indicatorView = this.f57942b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f57942b != null && this.f57944d == null && this.f57947g) {
                z = false;
            }
            if (!z) {
                this.f57942b.setVisibility(8);
                int count = this.f57942b.getCount();
                int i = this.i;
                if (count != i) {
                    this.f57942b.setCount(i);
                }
            }
            r();
        }
        if (this.f57946f.b() >= 2 && this.f57946f.b() <= this.i) {
            TextView textView2 = this.f57944d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f57942b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f57942b.getCount() != this.f57946f.b()) {
                    this.f57942b.setCount(this.f57946f.b());
                    l lVar = this.f57943c;
                    if (lVar != null) {
                        lVar.a(this.f57946f.b());
                        this.f57942b.setVisibility(8);
                    }
                } else {
                    l lVar2 = this.f57943c;
                    if (lVar2 != null) {
                        lVar2.a(this.f57946f.b());
                        this.f57942b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f57946f.b() < 2) {
            TextView textView3 = this.f57944d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f57942b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(l lVar) {
        if (lVar != null) {
            this.f57942b.setVisibility(8);
        } else {
            this.f57942b.setVisibility(0);
        }
        this.f57943c = lVar;
    }

    public void p(int i) {
        this.i = i;
        c cVar = this.f57946f;
        if (cVar != null) {
            cVar.h(i);
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.l = onPageChangeListener;
    }

    public void r() {
        if (this.f57948h) {
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
