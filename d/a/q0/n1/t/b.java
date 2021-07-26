package d.a.q0.n1.t;

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
import d.a.d.a.i;
import d.a.d.a.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.s.f0.u.c;
import d.a.q0.n1.o.l.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f61327a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f61328b;

    /* renamed from: c  reason: collision with root package name */
    public k f61329c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61330d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f61331e;

    /* renamed from: f  reason: collision with root package name */
    public c f61332f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61333g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61334h;

    /* renamed from: i  reason: collision with root package name */
    public int f61335i;
    public Context j;
    public List<n> k;
    public ViewPager.OnPageChangeListener l;
    public long m;
    public final Handler.Callback n;
    public final Handler o;
    public ViewPager.OnPageChangeListener p;

    /* loaded from: classes8.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61336e;

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
            this.f61336e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.f61336e.k()) {
                    this.f61336e.i();
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: d.a.q0.n1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1573b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61337e;

        public C1573b(b bVar) {
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
            this.f61337e = bVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f61337e.l != null) {
                    this.f61337e.l.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f61337e.s();
                } else if (i2 != 0 || (count = this.f61337e.f61331e.getCount()) < 2) {
                } else {
                    int currentItem = this.f61337e.f61327a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f61337e.f61327a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f61337e.f61327a.setCurrentItem(1, false);
                    }
                    this.f61337e.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f61337e.l == null) {
                return;
            }
            this.f61337e.l.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f61337e.f61332f != null && this.f61337e.f61332f.a(i2) == i2) {
                if (this.f61337e.f61328b != null) {
                    this.f61337e.f61328b.setPosition(this.f61337e.f61332f.c(i2));
                    if (this.f61337e.f61329c != null) {
                        this.f61337e.f61328b.setVisibility(8);
                        this.f61337e.f61329c.b(this.f61337e.f61332f.c(i2));
                    }
                }
                if (this.f61337e.l != null) {
                    this.f61337e.l.onPageSelected(this.f61337e.f61332f.c(i2));
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
        this.f61333g = false;
        this.f61334h = true;
        this.f61335i = 2;
        this.k = new ArrayList();
        this.m = 5000L;
        this.n = new a(this);
        this.o = new Handler(this.n);
        this.p = new C1573b(this);
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61327a == null || this.f61331e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f61331e.getCount()) >= 2) {
            int currentItem = this.f61327a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f61327a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f61327a.setCurrentItem(1, false);
            } else {
                this.f61327a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, listViewPager, indicatorView, textView) == null) {
            this.f61327a = listViewPager;
            this.f61328b = indicatorView;
            this.f61330d = textView;
            this.j = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f61331e = bdBaseViewPagerAdapter;
            ListViewPager listViewPager2 = this.f61327a;
            if (listViewPager2 != null) {
                listViewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f61327a.setOnPageChangeListener(this.p);
            }
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ListViewPager listViewPager = this.f61327a;
            if (listViewPager == null) {
                return false;
            }
            int[] iArr = new int[2];
            listViewPager.getLocationOnScreen(iArr);
            int measuredHeight = iArr[1] + (this.f61327a.getMeasuredHeight() / 2);
            return measuredHeight > 0 && measuredHeight < l.i(this.j);
        }
        return invokeV.booleanValue;
    }

    public void l(Context context, d.a.p0.s.f0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f61331e) == null) {
            return;
        }
        bdBaseViewPagerAdapter.g(context, bVar);
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
        c cVar = new c(list, this.f61333g, this.f61335i);
        this.f61332f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f61332f.g(1);
        this.f61331e.h(this.f61332f.e());
        this.f61331e.notifyDataSetChanged();
        this.f61327a.setCurrentItem(this.f61332f.d(), false);
        if (this.f61332f.b() <= 0) {
            return;
        }
        if (this.f61332f.b() > this.f61335i) {
            TextView textView = this.f61330d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f61330d.setOnClickListener(null);
                IndicatorView indicatorView = this.f61328b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f61328b != null && this.f61330d == null && this.f61333g) {
                z = false;
            }
            if (!z) {
                this.f61328b.setVisibility(8);
                int count = this.f61328b.getCount();
                int i2 = this.f61335i;
                if (count != i2) {
                    this.f61328b.setCount(i2);
                }
            }
            r();
        }
        if (this.f61332f.b() >= 2 && this.f61332f.b() <= this.f61335i) {
            TextView textView2 = this.f61330d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f61328b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f61328b.getCount() != this.f61332f.b()) {
                    this.f61328b.setCount(this.f61332f.b());
                    k kVar = this.f61329c;
                    if (kVar != null) {
                        kVar.a(this.f61332f.b());
                        this.f61328b.setVisibility(8);
                    }
                } else {
                    k kVar2 = this.f61329c;
                    if (kVar2 != null) {
                        kVar2.a(this.f61332f.b());
                        this.f61328b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f61332f.b() < 2) {
            TextView textView3 = this.f61330d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f61328b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kVar) == null) {
            if (kVar != null) {
                this.f61328b.setVisibility(8);
            } else {
                this.f61328b.setVisibility(0);
            }
            this.f61329c = kVar;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f61335i = i2;
            c cVar = this.f61332f;
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
            if (this.f61334h) {
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
