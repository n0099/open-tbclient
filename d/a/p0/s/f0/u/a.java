package d.a.p0.s.f0.u;

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
import d.a.d.a.i;
import d.a.d.a.j;
import d.a.d.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f53086a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f53087b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53088c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f53089d;

    /* renamed from: e  reason: collision with root package name */
    public c f53090e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53091f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53092g;

    /* renamed from: h  reason: collision with root package name */
    public int f53093h;

    /* renamed from: i  reason: collision with root package name */
    public Context f53094i;
    public List<n> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: d.a.p0.s.f0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1216a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53095e;

        public C1216a(a aVar) {
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
            this.f53095e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1) {
                    return false;
                }
                this.f53095e.g();
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
        public final /* synthetic */ a f53096e;

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
            this.f53096e = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f53096e.k != null) {
                    this.f53096e.k.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f53096e.p();
                } else if (i2 != 0 || (count = this.f53096e.f53089d.getCount()) < 2) {
                } else {
                    int currentItem = this.f53096e.f53086a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f53096e.f53086a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f53096e.f53086a.setCurrentItem(1, false);
                    }
                    this.f53096e.o();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f53096e.k == null) {
                return;
            }
            this.f53096e.k.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f53096e.f53090e != null && this.f53096e.f53090e.a(i2) == i2) {
                if (this.f53096e.f53087b != null) {
                    this.f53096e.f53087b.setPosition(this.f53096e.f53090e.c(i2));
                }
                if (this.f53096e.k != null) {
                    this.f53096e.k.onPageSelected(this.f53096e.f53090e.c(i2));
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
        this.f53091f = false;
        this.f53092g = true;
        this.f53093h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1216a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53086a == null || this.f53089d == null) {
            return;
        }
        i c2 = j.c(this.f53094i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f53089d.getCount()) >= 2) {
            int currentItem = this.f53086a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f53086a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f53086a.setCurrentItem(1, false);
            } else {
                this.f53086a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewPager, indicatorView, textView) == null) {
            this.f53086a = viewPager;
            this.f53087b = indicatorView;
            this.f53088c = textView;
            this.f53094i = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f53089d = bdBaseViewPagerAdapter;
            ViewPager viewPager2 = this.f53086a;
            if (viewPager2 != null) {
                viewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f53086a.setOnPageChangeListener(this.o);
            }
        }
    }

    public void i(Context context, d.a.p0.s.f0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f53089d) == null) {
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
        c cVar = new c(list, this.f53091f, this.f53093h);
        this.f53090e = cVar;
        cVar.i(2);
        this.f53090e.g(1);
        this.f53089d.h(this.f53090e.e());
        this.f53089d.notifyDataSetChanged();
        this.f53086a.setCurrentItem(this.f53090e.d(), false);
        if (this.f53090e.b() <= 0) {
            return;
        }
        if (this.f53090e.b() > this.f53093h) {
            TextView textView = this.f53088c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f53088c.setOnClickListener(null);
                IndicatorView indicatorView = this.f53087b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f53087b;
                if (indicatorView2 != null && !this.f53091f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f53087b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f53087b.getCount();
                int i2 = this.f53093h;
                if (count != i2) {
                    this.f53087b.setCount(i2);
                }
            }
            o();
        }
        if (this.f53090e.b() >= 2 && this.f53090e.b() <= this.f53093h) {
            TextView textView2 = this.f53088c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f53087b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f53087b.getCount() != this.f53090e.b()) {
                    this.f53087b.setCount(this.f53090e.b());
                }
            }
            o();
        }
        if (this.f53090e.b() < 2) {
            TextView textView3 = this.f53088c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f53087b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            p();
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f53092g = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f53091f = z;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f53093h = i2;
            c cVar = this.f53090e;
            if (cVar != null) {
                cVar.h(i2);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f53092g) {
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
        this.f53091f = false;
        this.f53092g = true;
        this.f53093h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C1216a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        this.f53091f = z;
        this.f53092g = z2;
        n(i2);
        h(context, viewPager, indicatorView, textView);
    }
}
