package d.a.r0.r.f0.t;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f55716a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f55717b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55718c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f55719d;

    /* renamed from: e  reason: collision with root package name */
    public c f55720e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55721f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55722g;

    /* renamed from: h  reason: collision with root package name */
    public int f55723h;

    /* renamed from: i  reason: collision with root package name */
    public Context f55724i;
    public List<n> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: d.a.r0.r.f0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1257a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55725e;

        public C1257a(a aVar) {
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
            this.f55725e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1) {
                    return false;
                }
                this.f55725e.g();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55726e;

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
            this.f55726e = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f55726e.k != null) {
                    this.f55726e.k.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f55726e.p();
                } else if (i2 != 0 || (count = this.f55726e.f55719d.getCount()) < 2) {
                } else {
                    int currentItem = this.f55726e.f55716a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f55726e.f55716a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f55726e.f55716a.setCurrentItem(1, false);
                    }
                    this.f55726e.o();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f55726e.k == null) {
                return;
            }
            this.f55726e.k.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f55726e.f55720e != null && this.f55726e.f55720e.a(i2) == i2) {
                if (this.f55726e.f55717b != null) {
                    this.f55726e.f55717b.setPosition(this.f55726e.f55720e.c(i2));
                }
                if (this.f55726e.k != null) {
                    this.f55726e.k.onPageSelected(this.f55726e.f55720e.c(i2));
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
        this.f55721f = false;
        this.f55722g = true;
        this.f55723h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1257a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55716a == null || this.f55719d == null) {
            return;
        }
        i c2 = j.c(this.f55724i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f55719d.getCount()) >= 2) {
            int currentItem = this.f55716a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f55716a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f55716a.setCurrentItem(1, false);
            } else {
                this.f55716a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewPager, indicatorView, textView) == null) {
            this.f55716a = viewPager;
            this.f55717b = indicatorView;
            this.f55718c = textView;
            this.f55724i = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f55719d = bdBaseViewPagerAdapter;
            ViewPager viewPager2 = this.f55716a;
            if (viewPager2 != null) {
                viewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f55716a.setOnPageChangeListener(this.o);
            }
        }
    }

    public void i(Context context, d.a.r0.r.f0.t.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f55719d) == null) {
            return;
        }
        bdBaseViewPagerAdapter.k(context, bVar);
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
        c cVar = new c(list, this.f55721f, this.f55723h);
        this.f55720e = cVar;
        cVar.i(2);
        this.f55720e.g(1);
        this.f55719d.l(this.f55720e.e());
        this.f55719d.notifyDataSetChanged();
        this.f55716a.setCurrentItem(this.f55720e.d(), false);
        if (this.f55720e.b() <= 0) {
            return;
        }
        if (this.f55720e.b() > this.f55723h) {
            TextView textView = this.f55718c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f55718c.setOnClickListener(null);
                IndicatorView indicatorView = this.f55717b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f55717b;
                if (indicatorView2 != null && !this.f55721f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f55717b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f55717b.getCount();
                int i2 = this.f55723h;
                if (count != i2) {
                    this.f55717b.setCount(i2);
                }
            }
            o();
        }
        if (this.f55720e.b() >= 2 && this.f55720e.b() <= this.f55723h) {
            TextView textView2 = this.f55718c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f55717b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f55717b.getCount() != this.f55720e.b()) {
                    this.f55717b.setCount(this.f55720e.b());
                }
            }
            o();
        }
        if (this.f55720e.b() < 2) {
            TextView textView3 = this.f55718c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f55717b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            p();
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f55722g = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f55721f = z;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f55723h = i2;
            c cVar = this.f55720e;
            if (cVar != null) {
                cVar.h(i2);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f55722g) {
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
        this.f55721f = false;
        this.f55722g = true;
        this.f55723h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1257a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        this.f55721f = z;
        this.f55722g = z2;
        n(i2);
        h(context, viewPager, indicatorView, textView);
    }
}
