package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes5.dex */
public class eg5 {
    public static /* synthetic */ Interceptable $ic;
    public static DateFormat y;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public WheelView b;
    public WheelView c;
    public WheelView d;
    public WheelView e;
    public WheelView f;
    public WheelView g;
    public int h;
    public boolean[] i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public WheelView.DividerType v;
    public boolean w;
    public tf5 x;

    /* loaded from: classes5.dex */
    public class a implements ig5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg5 a;

        public a(eg5 eg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg5Var;
        }

        @Override // com.repackage.ig5
        public void onItemSelected(int i) {
            int h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + this.a.j;
                this.a.c.setAdapter(new of5(yf5.d(i2)));
                if (yf5.g(i2) == 0 || this.a.c.getCurrentItem() <= yf5.g(i2) - 1) {
                    this.a.c.setCurrentItem(this.a.c.getCurrentItem());
                } else {
                    this.a.c.setCurrentItem(this.a.c.getCurrentItem() + 1);
                }
                if (yf5.g(i2) == 0 || this.a.c.getCurrentItem() <= yf5.g(i2) - 1) {
                    this.a.d.setAdapter(new of5(yf5.b(yf5.h(i2, this.a.c.getCurrentItem() + 1))));
                    h = yf5.h(i2, this.a.c.getCurrentItem() + 1);
                } else if (this.a.c.getCurrentItem() == yf5.g(i2) + 1) {
                    this.a.d.setAdapter(new of5(yf5.b(yf5.f(i2))));
                    h = yf5.f(i2);
                } else {
                    this.a.d.setAdapter(new of5(yf5.b(yf5.h(i2, this.a.c.getCurrentItem()))));
                    h = yf5.h(i2, this.a.c.getCurrentItem());
                }
                int i3 = h - 1;
                if (this.a.d.getCurrentItem() > i3) {
                    this.a.d.setCurrentItem(i3);
                }
                if (this.a.x != null) {
                    this.a.x.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ig5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg5 a;

        public b(eg5 eg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg5Var;
        }

        @Override // com.repackage.ig5
        public void onItemSelected(int i) {
            int h;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int currentItem = this.a.b.getCurrentItem() + this.a.j;
                if (yf5.g(currentItem) == 0 || i <= yf5.g(currentItem) - 1) {
                    int i2 = i + 1;
                    this.a.d.setAdapter(new of5(yf5.b(yf5.h(currentItem, i2))));
                    h = yf5.h(currentItem, i2);
                } else if (this.a.c.getCurrentItem() == yf5.g(currentItem) + 1) {
                    this.a.d.setAdapter(new of5(yf5.b(yf5.f(currentItem))));
                    h = yf5.f(currentItem);
                } else {
                    this.a.d.setAdapter(new of5(yf5.b(yf5.h(currentItem, i))));
                    h = yf5.h(currentItem, i);
                }
                int i3 = h - 1;
                if (this.a.d.getCurrentItem() > i3) {
                    this.a.d.setCurrentItem(i3);
                }
                if (this.a.x != null) {
                    this.a.x.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ig5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ eg5 c;

        public c(eg5 eg5Var, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg5Var, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eg5Var;
            this.a = list;
            this.b = list2;
        }

        @Override // com.repackage.ig5
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + this.c.j;
                this.c.p = i2;
                int currentItem = this.c.c.getCurrentItem();
                if (this.c.j == this.c.k) {
                    this.c.c.setAdapter(new pf5(this.c.l, this.c.m));
                    if (currentItem > this.c.c.getAdapter().a() - 1) {
                        currentItem = this.c.c.getAdapter().a() - 1;
                        this.c.c.setCurrentItem(currentItem);
                    }
                    int i3 = currentItem + this.c.l;
                    if (this.c.l != this.c.m) {
                        if (i3 != this.c.l) {
                            if (i3 != this.c.m) {
                                this.c.F(i2, i3, 1, 31, this.a, this.b);
                            } else {
                                eg5 eg5Var = this.c;
                                eg5Var.F(i2, i3, 1, eg5Var.o, this.a, this.b);
                            }
                        } else {
                            eg5 eg5Var2 = this.c;
                            eg5Var2.F(i2, i3, eg5Var2.n, 31, this.a, this.b);
                        }
                    } else {
                        eg5 eg5Var3 = this.c;
                        eg5Var3.F(i2, i3, eg5Var3.n, this.c.o, this.a, this.b);
                    }
                } else if (i2 == this.c.j) {
                    this.c.c.setAdapter(new pf5(this.c.l, 12));
                    if (currentItem > this.c.c.getAdapter().a() - 1) {
                        currentItem = this.c.c.getAdapter().a() - 1;
                        this.c.c.setCurrentItem(currentItem);
                    }
                    int i4 = currentItem + this.c.l;
                    if (i4 != this.c.l) {
                        this.c.F(i2, i4, 1, 31, this.a, this.b);
                    } else {
                        eg5 eg5Var4 = this.c;
                        eg5Var4.F(i2, i4, eg5Var4.n, 31, this.a, this.b);
                    }
                } else if (i2 == this.c.k) {
                    this.c.c.setAdapter(new pf5(1, this.c.m));
                    if (currentItem > this.c.c.getAdapter().a() - 1) {
                        currentItem = this.c.c.getAdapter().a() - 1;
                        this.c.c.setCurrentItem(currentItem);
                    }
                    int i5 = 1 + currentItem;
                    if (i5 != this.c.m) {
                        this.c.F(i2, i5, 1, 31, this.a, this.b);
                    } else {
                        eg5 eg5Var5 = this.c;
                        eg5Var5.F(i2, i5, 1, eg5Var5.o, this.a, this.b);
                    }
                } else {
                    this.c.c.setAdapter(new pf5(1, 12));
                    eg5 eg5Var6 = this.c;
                    eg5Var6.F(i2, 1 + eg5Var6.c.getCurrentItem(), 1, 31, this.a, this.b);
                }
                if (this.c.x != null) {
                    this.c.x.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ig5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ eg5 c;

        public d(eg5 eg5Var, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg5Var, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eg5Var;
            this.a = list;
            this.b = list2;
        }

        @Override // com.repackage.ig5
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + 1;
                if (this.c.j == this.c.k) {
                    int i3 = (i2 + this.c.l) - 1;
                    if (this.c.l != this.c.m) {
                        if (this.c.l != i3) {
                            if (this.c.m == i3) {
                                eg5 eg5Var = this.c;
                                eg5Var.F(eg5Var.p, i3, 1, this.c.o, this.a, this.b);
                            } else {
                                eg5 eg5Var2 = this.c;
                                eg5Var2.F(eg5Var2.p, i3, 1, 31, this.a, this.b);
                            }
                        } else {
                            eg5 eg5Var3 = this.c;
                            eg5Var3.F(eg5Var3.p, i3, this.c.n, 31, this.a, this.b);
                        }
                    } else {
                        eg5 eg5Var4 = this.c;
                        eg5Var4.F(eg5Var4.p, i3, this.c.n, this.c.o, this.a, this.b);
                    }
                } else if (this.c.p == this.c.j) {
                    int i4 = (i2 + this.c.l) - 1;
                    if (i4 == this.c.l) {
                        eg5 eg5Var5 = this.c;
                        eg5Var5.F(eg5Var5.p, i4, this.c.n, 31, this.a, this.b);
                    } else {
                        eg5 eg5Var6 = this.c;
                        eg5Var6.F(eg5Var6.p, i4, 1, 31, this.a, this.b);
                    }
                } else if (this.c.p == this.c.k) {
                    if (i2 == this.c.m) {
                        eg5 eg5Var7 = this.c;
                        eg5Var7.F(eg5Var7.p, this.c.c.getCurrentItem() + 1, 1, this.c.o, this.a, this.b);
                    } else {
                        eg5 eg5Var8 = this.c;
                        eg5Var8.F(eg5Var8.p, this.c.c.getCurrentItem() + 1, 1, 31, this.a, this.b);
                    }
                } else {
                    eg5 eg5Var9 = this.c;
                    eg5Var9.F(eg5Var9.p, i2, 1, 31, this.a, this.b);
                }
                if (this.c.x != null) {
                    this.c.x.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ig5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg5 a;

        public e(eg5 eg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg5Var;
        }

        @Override // com.repackage.ig5
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.x.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755738562, "Lcom/repackage/eg5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755738562, "Lcom/repackage/eg5;");
                return;
            }
        }
        y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public eg5(View view2, boolean[] zArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, zArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = FeatureCodes.SKY_SEG;
        this.k = 2100;
        this.l = 1;
        this.m = 12;
        this.n = 1;
        this.o = 31;
        this.w = false;
        this.a = view2;
        this.i = zArr;
        this.h = i;
        this.q = i2;
        O(view2);
    }

    public void A(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.u = f;
            z();
        }
    }

    public final void B(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            WheelView wheelView = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f092491);
            this.b = wheelView;
            wheelView.setAdapter(new of5(yf5.e(this.j, this.k)));
            this.b.setLabel("");
            this.b.setCurrentItem(i - this.j);
            this.b.setGravity(this.h);
            WheelView wheelView2 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f09142a);
            this.c = wheelView2;
            wheelView2.setAdapter(new of5(yf5.d(i)));
            this.c.setLabel("");
            int g = yf5.g(i);
            if (g != 0 && (i2 > g - 1 || z)) {
                this.c.setCurrentItem(i2 + 1);
            } else {
                this.c.setCurrentItem(i2);
            }
            this.c.setGravity(this.h);
            this.d = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090762);
            if (yf5.g(i) == 0) {
                this.d.setAdapter(new of5(yf5.b(yf5.h(i, i2))));
            } else {
                this.d.setAdapter(new of5(yf5.b(yf5.f(i))));
            }
            this.d.setLabel("");
            this.d.setCurrentItem(i3 - 1);
            this.d.setGravity(this.h);
            WheelView wheelView3 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090dfa);
            this.e = wheelView3;
            wheelView3.setAdapter(new pf5(0, 23));
            this.e.setCurrentItem(i4);
            this.e.setGravity(this.h);
            WheelView wheelView4 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091416);
            this.f = wheelView4;
            wheelView4.setAdapter(new pf5(0, 59));
            this.f.setCurrentItem(i5);
            this.f.setGravity(this.h);
            WheelView wheelView5 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091c43);
            this.g = wheelView5;
            wheelView5.setAdapter(new pf5(0, 59));
            this.g.setCurrentItem(i5);
            this.g.setGravity(this.h);
            this.b.setOnItemSelectedListener(new a(this));
            this.c.setOnItemSelectedListener(new b(this));
            q(this.d);
            q(this.e);
            q(this.f);
            q(this.g);
            boolean[] zArr = this.i;
            if (zArr.length == 6) {
                this.b.setVisibility(zArr[0] ? 0 : 8);
                this.c.setVisibility(this.i[1] ? 0 : 8);
                this.d.setVisibility(this.i[2] ? 0 : 8);
                this.e.setVisibility(this.i[3] ? 0 : 8);
                this.f.setVisibility(this.i[4] ? 0 : 8);
                this.g.setVisibility(this.i[5] ? 0 : 8);
                r();
                return;
            }
            throw new RuntimeException("type[] length is not 6");
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.w = z;
        }
    }

    public void D(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (this.w) {
                int[] d2 = zf5.d(i, i2 + 1, i3);
                B(d2[0], d2[1] - 1, d2[2], d2[3] == 1, i4, i5, i6);
                return;
            }
            H(i, i2, i3, i4, i5, i6);
        }
    }

    public void E(Calendar calendar, Calendar calendar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, calendar, calendar2) == null) {
            if (calendar == null && calendar2 != null) {
                int i = calendar2.get(1);
                int i2 = calendar2.get(2) + 1;
                int i3 = calendar2.get(5);
                int i4 = this.j;
                if (i > i4) {
                    this.k = i;
                    this.m = i2;
                    this.o = i3;
                } else if (i == i4) {
                    int i5 = this.l;
                    if (i2 > i5) {
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                    } else if (i2 != i5 || i3 <= this.n) {
                    } else {
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                    }
                }
            } else if (calendar == null || calendar2 != null) {
                if (calendar == null || calendar2 == null) {
                    return;
                }
                this.j = calendar.get(1);
                this.k = calendar2.get(1);
                this.l = calendar.get(2) + 1;
                this.m = calendar2.get(2) + 1;
                this.n = calendar.get(5);
                this.o = calendar2.get(5);
            } else {
                int i6 = calendar.get(1);
                int i7 = calendar.get(2) + 1;
                int i8 = calendar.get(5);
                int i9 = this.k;
                if (i6 < i9) {
                    this.l = i7;
                    this.n = i8;
                    this.j = i6;
                } else if (i6 == i9) {
                    int i10 = this.m;
                    if (i7 < i10) {
                        this.l = i7;
                        this.n = i8;
                        this.j = i6;
                    } else if (i7 != i10 || i8 >= this.o) {
                    } else {
                        this.l = i7;
                        this.n = i8;
                        this.j = i6;
                    }
                }
            }
        }
    }

    public final void F(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), list, list2}) == null) {
            int currentItem = this.d.getCurrentItem();
            if (list.contains(String.valueOf(i2))) {
                if (i4 > 31) {
                    i4 = 31;
                }
                this.d.setAdapter(new pf5(i3, i4));
            } else if (list2.contains(String.valueOf(i2))) {
                if (i4 > 30) {
                    i4 = 30;
                }
                this.d.setAdapter(new pf5(i3, i4));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (i4 > 29) {
                    i4 = 29;
                }
                this.d.setAdapter(new pf5(i3, i4));
            } else {
                if (i4 > 28) {
                    i4 = 28;
                }
                this.d.setAdapter(new pf5(i3, i4));
            }
            if (currentItem > this.d.getAdapter().a() - 1) {
                this.d.setCurrentItem(this.d.getAdapter().a() - 1);
            }
        }
    }

    public void G(tf5 tf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tf5Var) == null) {
            this.x = tf5Var;
        }
    }

    public final void H(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
            List asList2 = Arrays.asList("4", "6", "9", "11");
            this.p = i;
            WheelView wheelView = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f092491);
            this.b = wheelView;
            wheelView.setAdapter(new pf5(this.j, this.k));
            this.b.setCurrentItem(i - this.j);
            this.b.setGravity(this.h);
            WheelView wheelView2 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f09142a);
            this.c = wheelView2;
            int i9 = this.j;
            int i10 = this.k;
            if (i9 == i10) {
                wheelView2.setAdapter(new pf5(this.l, this.m));
                this.c.setCurrentItem((i2 + 1) - this.l);
            } else if (i == i9) {
                wheelView2.setAdapter(new pf5(this.l, 12));
                this.c.setCurrentItem((i2 + 1) - this.l);
            } else if (i == i10) {
                wheelView2.setAdapter(new pf5(1, this.m));
                this.c.setCurrentItem(i2);
            } else {
                wheelView2.setAdapter(new pf5(1, 12));
                this.c.setCurrentItem(i2);
            }
            this.c.setGravity(this.h);
            this.d = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090762);
            if (this.j == this.k && this.l == this.m) {
                int i11 = i2 + 1;
                if (asList.contains(String.valueOf(i11))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.d.setAdapter(new pf5(this.n, this.o));
                } else if (asList2.contains(String.valueOf(i11))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.d.setAdapter(new pf5(this.n, this.o));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.d.setAdapter(new pf5(this.n, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.d.setAdapter(new pf5(this.n, this.o));
                }
                this.d.setCurrentItem(i3 - this.n);
            } else if (i == this.j && (i8 = i2 + 1) == this.l) {
                if (asList.contains(String.valueOf(i8))) {
                    this.d.setAdapter(new pf5(this.n, 31));
                } else if (asList2.contains(String.valueOf(i8))) {
                    this.d.setAdapter(new pf5(this.n, 30));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    this.d.setAdapter(new pf5(this.n, 29));
                } else {
                    this.d.setAdapter(new pf5(this.n, 28));
                }
                this.d.setCurrentItem(i3 - this.n);
            } else if (i == this.k && (i7 = i2 + 1) == this.m) {
                if (asList.contains(String.valueOf(i7))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.d.setAdapter(new pf5(1, this.o));
                } else if (asList2.contains(String.valueOf(i7))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.d.setAdapter(new pf5(1, this.o));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.d.setAdapter(new pf5(1, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.d.setAdapter(new pf5(1, this.o));
                }
                this.d.setCurrentItem(i3 - 1);
            } else {
                int i12 = i2 + 1;
                if (asList.contains(String.valueOf(i12))) {
                    this.d.setAdapter(new pf5(1, 31));
                } else if (asList2.contains(String.valueOf(i12))) {
                    this.d.setAdapter(new pf5(1, 30));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    this.d.setAdapter(new pf5(1, 29));
                } else {
                    this.d.setAdapter(new pf5(1, 28));
                }
                this.d.setCurrentItem(i3 - 1);
            }
            this.d.setGravity(this.h);
            WheelView wheelView3 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090dfa);
            this.e = wheelView3;
            wheelView3.setAdapter(new pf5(0, 23));
            this.e.setCurrentItem(i4);
            this.e.setGravity(this.h);
            WheelView wheelView4 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091416);
            this.f = wheelView4;
            wheelView4.setAdapter(new pf5(0, 59));
            this.f.setCurrentItem(i5);
            this.f.setGravity(this.h);
            WheelView wheelView5 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091c43);
            this.g = wheelView5;
            wheelView5.setAdapter(new pf5(0, 59));
            this.g.setCurrentItem(i6);
            this.g.setGravity(this.h);
            this.b.setOnItemSelectedListener(new c(this, asList, asList2));
            this.c.setOnItemSelectedListener(new d(this, asList, asList2));
            q(this.d);
            q(this.e);
            q(this.f);
            q(this.g);
            boolean[] zArr = this.i;
            if (zArr.length == 6) {
                this.b.setVisibility(zArr[0] ? 0 : 8);
                this.c.setVisibility(this.i[1] ? 0 : 8);
                this.d.setVisibility(this.i[2] ? 0 : 8);
                this.e.setVisibility(this.i[3] ? 0 : 8);
                this.f.setVisibility(this.i[4] ? 0 : 8);
                this.g.setVisibility(this.i[5] ? 0 : 8);
                r();
                return;
            }
            throw new IllegalArgumentException("type[] length is not 6");
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.j = i;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.setTextColorCenter(this.s);
            this.c.setTextColorCenter(this.s);
            this.b.setTextColorCenter(this.s);
            this.e.setTextColorCenter(this.s);
            this.f.setTextColorCenter(this.s);
            this.g.setTextColorCenter(this.s);
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.s = i;
            J();
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.setTextColorOut(this.r);
            this.c.setTextColorOut(this.r);
            this.b.setTextColorOut(this.r);
            this.e.setTextColorOut(this.r);
            this.f.setTextColorOut(this.r);
            this.g.setTextColorOut(this.r);
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.r = i;
            L();
        }
    }

    public void N(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.d.setTextXOffset(i);
            this.c.setTextXOffset(i2);
            this.b.setTextXOffset(i3);
            this.e.setTextXOffset(i4);
            this.f.setTextXOffset(i5);
            this.g.setTextXOffset(i6);
        }
    }

    public void O(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            this.a = view2;
        }
    }

    public final String n() {
        InterceptResult invokeV;
        int currentItem;
        boolean z;
        int currentItem2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int currentItem3 = this.b.getCurrentItem() + this.j;
            if (yf5.g(currentItem3) == 0) {
                currentItem2 = this.c.getCurrentItem();
            } else if ((this.c.getCurrentItem() + 1) - yf5.g(currentItem3) <= 0) {
                currentItem2 = this.c.getCurrentItem();
            } else if ((this.c.getCurrentItem() + 1) - yf5.g(currentItem3) == 1) {
                currentItem = this.c.getCurrentItem();
                z = true;
                int[] b2 = zf5.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
                sb.append(b2[0]);
                sb.append("-");
                sb.append(b2[1]);
                sb.append("-");
                sb.append(b2[2]);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
                return sb.toString();
            } else {
                currentItem = this.c.getCurrentItem();
                z = false;
                int[] b22 = zf5.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
                sb.append(b22[0]);
                sb.append("-");
                sb.append(b22[1]);
                sb.append("-");
                sb.append(b22[2]);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
                return sb.toString();
            }
            currentItem = currentItem2 + 1;
            z = false;
            int[] b222 = zf5.b(currentItem3, currentItem, this.d.getCurrentItem() + 1, z);
            sb.append(b222[0]);
            sb.append("-");
            sb.append(b222[1]);
            sb.append("-");
            sb.append(b222[2]);
            sb.append(" ");
            sb.append(this.e.getCurrentItem());
            sb.append(":");
            sb.append(this.f.getCurrentItem());
            sb.append(":");
            sb.append(this.g.getCurrentItem());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.w) {
                return n();
            }
            StringBuilder sb = new StringBuilder();
            if (this.p == this.j) {
                int currentItem = this.c.getCurrentItem();
                int i = this.l;
                if (currentItem + i == i) {
                    sb.append(this.b.getCurrentItem() + this.j);
                    sb.append("-");
                    sb.append(this.c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.d.getCurrentItem() + this.n);
                    sb.append(" ");
                    sb.append(this.e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.g.getCurrentItem());
                } else {
                    sb.append(this.b.getCurrentItem() + this.j);
                    sb.append("-");
                    sb.append(this.c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.d.getCurrentItem() + 1);
                    sb.append(" ");
                    sb.append(this.e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.g.getCurrentItem());
                }
            } else {
                sb.append(this.b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.c.getCurrentItem() + 1);
                sb.append("-");
                sb.append(this.d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(":");
                sb.append(this.f.getCurrentItem());
                sb.append(":");
                sb.append(this.g.getCurrentItem());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d.h(z);
            this.c.h(z);
            this.b.h(z);
            this.e.h(z);
            this.f.h(z);
            this.g.h(z);
        }
    }

    public final void q(WheelView wheelView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, wheelView) == null) || this.x == null) {
            return;
        }
        wheelView.setOnItemSelectedListener(new e(this));
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.d.setTextSize(this.q);
            this.c.setTextSize(this.q);
            this.b.setTextSize(this.q);
            this.e.setTextSize(this.q);
            this.f.setTextSize(this.q);
            this.g.setTextSize(this.q);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.b.setCyclic(z);
            this.c.setCyclic(z);
            this.d.setCyclic(z);
            this.e.setCyclic(z);
            this.f.setCyclic(z);
            this.g.setCyclic(z);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.d.setDividerColor(this.t);
            this.c.setDividerColor(this.t);
            this.b.setDividerColor(this.t);
            this.e.setDividerColor(this.t);
            this.f.setDividerColor(this.t);
            this.g.setDividerColor(this.t);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.t = i;
            t();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.d.setDividerType(this.v);
            this.c.setDividerType(this.v);
            this.b.setDividerType(this.v);
            this.e.setDividerType(this.v);
            this.f.setDividerType(this.v);
            this.g.setDividerType(this.v);
        }
    }

    public void w(WheelView.DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dividerType) == null) {
            this.v = dividerType;
            v();
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.k = i;
        }
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) || this.w) {
            return;
        }
        if (str != null) {
            this.b.setLabel(str);
        } else {
            this.b.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e49));
        }
        if (str2 != null) {
            this.c.setLabel(str2);
        } else {
            this.c.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e46));
        }
        if (str3 != null) {
            this.d.setLabel(str3);
        } else {
            this.d.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e43));
        }
        if (str4 != null) {
            this.e.setLabel(str4);
        } else {
            this.e.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e44));
        }
        if (str5 != null) {
            this.f.setLabel(str5);
        } else {
            this.f.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e45));
        }
        if (str6 != null) {
            this.g.setLabel(str6);
        } else {
            this.g.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e47));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.d.setLineSpacingMultiplier(this.u);
            this.c.setLineSpacingMultiplier(this.u);
            this.b.setLineSpacingMultiplier(this.u);
            this.e.setLineSpacingMultiplier(this.u);
            this.f.setLineSpacingMultiplier(this.u);
            this.g.setLineSpacingMultiplier(this.u);
        }
    }
}
