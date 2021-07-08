package d.a.o0.r.f0.u;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.i;
import d.a.c.a.j;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f52422a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f52423b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52424c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f52425d;

    /* renamed from: e  reason: collision with root package name */
    public c f52426e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52427f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52428g;

    /* renamed from: h  reason: collision with root package name */
    public int f52429h;

    /* renamed from: i  reason: collision with root package name */
    public Context f52430i;
    public List<n> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: d.a.o0.r.f0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1206a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52431e;

        public C1206a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52431e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1) {
                    return false;
                }
                this.f52431e.g();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52432e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52432e = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f52432e.k != null) {
                    this.f52432e.k.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f52432e.p();
                } else if (i2 != 0 || (count = this.f52432e.f52425d.getCount()) < 2) {
                } else {
                    int currentItem = this.f52432e.f52422a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f52432e.f52422a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f52432e.f52422a.setCurrentItem(1, false);
                    }
                    this.f52432e.o();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f52432e.k == null) {
                return;
            }
            this.f52432e.k.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f52432e.f52426e != null && this.f52432e.f52426e.a(i2) == i2) {
                if (this.f52432e.f52423b != null) {
                    this.f52432e.f52423b.setPosition(this.f52432e.f52426e.c(i2));
                }
                if (this.f52432e.k != null) {
                    this.f52432e.k.onPageSelected(this.f52432e.f52426e.c(i2));
                }
            }
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewPager, indicatorView, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52427f = false;
        this.f52428g = true;
        this.f52429h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1206a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52422a == null || this.f52425d == null) {
            return;
        }
        i c2 = j.c(this.f52430i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f52425d.getCount()) >= 2) {
            int currentItem = this.f52422a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f52422a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f52422a.setCurrentItem(1, false);
            } else {
                this.f52422a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewPager, indicatorView, textView) == null) {
            this.f52422a = viewPager;
            this.f52423b = indicatorView;
            this.f52424c = textView;
            this.f52430i = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f52425d = bdBaseViewPagerAdapter;
            ViewPager viewPager2 = this.f52422a;
            if (viewPager2 != null) {
                viewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f52422a.setOnPageChangeListener(this.o);
            }
        }
    }

    public void i(Context context, d.a.o0.r.f0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f52425d) == null) {
            return;
        }
        bdBaseViewPagerAdapter.g(context, bVar);
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.l = j;
        }
    }

    public void k(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.j = list;
        c cVar = new c(list, this.f52427f, this.f52429h);
        this.f52426e = cVar;
        cVar.i(2);
        this.f52426e.g(1);
        this.f52425d.h(this.f52426e.e());
        this.f52425d.notifyDataSetChanged();
        this.f52422a.setCurrentItem(this.f52426e.d(), false);
        if (this.f52426e.b() <= 0) {
            return;
        }
        if (this.f52426e.b() > this.f52429h) {
            TextView textView = this.f52424c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f52424c.setOnClickListener(null);
                IndicatorView indicatorView = this.f52423b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f52423b;
                if (indicatorView2 != null && !this.f52427f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f52423b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f52423b.getCount();
                int i2 = this.f52429h;
                if (count != i2) {
                    this.f52423b.setCount(i2);
                }
            }
            o();
        }
        if (this.f52426e.b() >= 2 && this.f52426e.b() <= this.f52429h) {
            TextView textView2 = this.f52424c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f52423b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f52423b.getCount() != this.f52426e.b()) {
                    this.f52423b.setCount(this.f52426e.b());
                }
            }
            o();
        }
        if (this.f52426e.b() < 2) {
            TextView textView3 = this.f52424c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f52423b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            p();
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f52428g = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f52427f = z;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f52429h = i2;
            c cVar = this.f52426e;
            if (cVar != null) {
                cVar.h(i2);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f52428g) {
                this.n.removeMessages(1);
                this.n.sendEmptyMessageDelayed(1, this.l);
                return;
            }
            this.n.removeMessages(1);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.removeMessages(1);
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewPager, indicatorView, textView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52427f = false;
        this.f52428g = true;
        this.f52429h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1206a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        this.f52427f = z;
        this.f52428g = z2;
        n(i2);
        h(context, viewPager, indicatorView, textView);
    }
}
