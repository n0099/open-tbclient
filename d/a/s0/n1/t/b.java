package d.a.s0.n1.t;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.i;
import d.a.c.a.j;
import d.a.c.k.e.n;
import d.a.r0.r.f0.t.c;
import d.a.s0.n1.o.l.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f63947a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f63948b;

    /* renamed from: c  reason: collision with root package name */
    public l f63949c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63950d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f63951e;

    /* renamed from: f  reason: collision with root package name */
    public c f63952f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63953g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63954h;

    /* renamed from: i  reason: collision with root package name */
    public int f63955i;
    public Context j;
    public List<n> k;
    public ViewPager.OnPageChangeListener l;
    public long m;
    public final Handler.Callback n;
    public final Handler o;
    public ViewPager.OnPageChangeListener p;

    /* loaded from: classes9.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f63956e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63956e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.f63956e.k()) {
                    this.f63956e.i();
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: d.a.s0.n1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1612b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f63957e;

        public C1612b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63957e = bVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f63957e.l != null) {
                    this.f63957e.l.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f63957e.s();
                } else if (i2 != 0 || (count = this.f63957e.f63951e.getCount()) < 2) {
                } else {
                    int currentItem = this.f63957e.f63947a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f63957e.f63947a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f63957e.f63947a.setCurrentItem(1, false);
                    }
                    this.f63957e.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f63957e.l == null) {
                return;
            }
            this.f63957e.l.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f63957e.f63952f != null && this.f63957e.f63952f.a(i2) == i2) {
                if (this.f63957e.f63948b != null) {
                    this.f63957e.f63948b.setPosition(this.f63957e.f63952f.c(i2));
                    if (this.f63957e.f63949c != null) {
                        this.f63957e.f63948b.setVisibility(8);
                        this.f63957e.f63949c.b(this.f63957e.f63952f.c(i2));
                    }
                }
                if (this.f63957e.l != null) {
                    this.f63957e.l.onPageSelected(this.f63957e.f63952f.c(i2));
                }
            }
        }
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, listViewPager, indicatorView, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63953g = false;
        this.f63954h = true;
        this.f63955i = 2;
        this.k = new ArrayList();
        this.m = 5000L;
        this.n = new a(this);
        this.o = new Handler(this.n);
        this.p = new C1612b(this);
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63947a == null || this.f63951e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f63951e.getCount()) >= 2) {
            int currentItem = this.f63947a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f63947a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f63947a.setCurrentItem(1, false);
            } else {
                this.f63947a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, listViewPager, indicatorView, textView) == null) {
            this.f63947a = listViewPager;
            this.f63948b = indicatorView;
            this.f63950d = textView;
            this.j = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f63951e = bdBaseViewPagerAdapter;
            ListViewPager listViewPager2 = this.f63947a;
            if (listViewPager2 != null) {
                listViewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f63947a.setOnPageChangeListener(this.p);
            }
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ListViewPager listViewPager = this.f63947a;
            if (listViewPager == null) {
                return false;
            }
            int[] iArr = new int[2];
            listViewPager.getLocationOnScreen(iArr);
            int measuredHeight = iArr[1] + (this.f63947a.getMeasuredHeight() / 2);
            return measuredHeight > 0 && measuredHeight < d.a.c.e.p.l.i(this.j);
        }
        return invokeV.booleanValue;
    }

    public void l(Context context, d.a.r0.r.f0.t.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f63951e) == null) {
            return;
        }
        bdBaseViewPagerAdapter.k(context, bVar);
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.m = j;
        }
    }

    public void n(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.k = list;
        c cVar = new c(list, this.f63953g, this.f63955i);
        this.f63952f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f63952f.g(1);
        this.f63951e.l(this.f63952f.e());
        this.f63951e.notifyDataSetChanged();
        this.f63947a.setCurrentItem(this.f63952f.d(), false);
        if (this.f63952f.b() <= 0) {
            return;
        }
        if (this.f63952f.b() > this.f63955i) {
            TextView textView = this.f63950d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f63950d.setOnClickListener(null);
                IndicatorView indicatorView = this.f63948b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f63948b != null && this.f63950d == null && this.f63953g) {
                z = false;
            }
            if (!z) {
                this.f63948b.setVisibility(8);
                int count = this.f63948b.getCount();
                int i2 = this.f63955i;
                if (count != i2) {
                    this.f63948b.setCount(i2);
                }
            }
            r();
        }
        if (this.f63952f.b() >= 2 && this.f63952f.b() <= this.f63955i) {
            TextView textView2 = this.f63950d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f63948b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f63948b.getCount() != this.f63952f.b()) {
                    this.f63948b.setCount(this.f63952f.b());
                    l lVar = this.f63949c;
                    if (lVar != null) {
                        lVar.a(this.f63952f.b());
                        this.f63948b.setVisibility(8);
                    }
                } else {
                    l lVar2 = this.f63949c;
                    if (lVar2 != null) {
                        lVar2.a(this.f63952f.b());
                        this.f63948b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f63952f.b() < 2) {
            TextView textView3 = this.f63950d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f63948b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            if (lVar != null) {
                this.f63948b.setVisibility(8);
            } else {
                this.f63948b.setVisibility(0);
            }
            this.f63949c = lVar;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f63955i = i2;
            c cVar = this.f63952f;
            if (cVar != null) {
                cVar.h(i2);
            }
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.l = onPageChangeListener;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f63954h) {
                this.o.removeMessages(1);
                this.o.sendEmptyMessageDelayed(1, this.m);
                return;
            }
            this.o.removeMessages(1);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.removeMessages(1);
        }
    }
}
