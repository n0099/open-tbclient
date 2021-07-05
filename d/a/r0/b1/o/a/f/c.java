package d.a.r0.b1.o.a.f;

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
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static DateFormat y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f55090a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f55091b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f55092c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f55093d;

    /* renamed from: e  reason: collision with root package name */
    public WheelView f55094e;

    /* renamed from: f  reason: collision with root package name */
    public WheelView f55095f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView f55096g;

    /* renamed from: h  reason: collision with root package name */
    public int f55097h;

    /* renamed from: i  reason: collision with root package name */
    public boolean[] f55098i;
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
    public d.a.r0.b1.o.a.d.b x;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.b1.o.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55099a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55099a = cVar;
        }

        @Override // d.a.r0.b1.o.b.c.b
        public void a(int i2) {
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = i2 + this.f55099a.j;
                this.f55099a.f55092c.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.d(i3)));
                if (d.a.r0.b1.o.a.e.a.g(i3) == 0 || this.f55099a.f55092c.getCurrentItem() <= d.a.r0.b1.o.a.e.a.g(i3) - 1) {
                    this.f55099a.f55092c.setCurrentItem(this.f55099a.f55092c.getCurrentItem());
                } else {
                    this.f55099a.f55092c.setCurrentItem(this.f55099a.f55092c.getCurrentItem() + 1);
                }
                if (d.a.r0.b1.o.a.e.a.g(i3) == 0 || this.f55099a.f55092c.getCurrentItem() <= d.a.r0.b1.o.a.e.a.g(i3) - 1) {
                    this.f55099a.f55093d.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.b(d.a.r0.b1.o.a.e.a.h(i3, this.f55099a.f55092c.getCurrentItem() + 1))));
                    h2 = d.a.r0.b1.o.a.e.a.h(i3, this.f55099a.f55092c.getCurrentItem() + 1);
                } else if (this.f55099a.f55092c.getCurrentItem() == d.a.r0.b1.o.a.e.a.g(i3) + 1) {
                    this.f55099a.f55093d.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.b(d.a.r0.b1.o.a.e.a.f(i3))));
                    h2 = d.a.r0.b1.o.a.e.a.f(i3);
                } else {
                    this.f55099a.f55093d.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.b(d.a.r0.b1.o.a.e.a.h(i3, this.f55099a.f55092c.getCurrentItem()))));
                    h2 = d.a.r0.b1.o.a.e.a.h(i3, this.f55099a.f55092c.getCurrentItem());
                }
                int i4 = h2 - 1;
                if (this.f55099a.f55093d.getCurrentItem() > i4) {
                    this.f55099a.f55093d.setCurrentItem(i4);
                }
                if (this.f55099a.x != null) {
                    this.f55099a.x.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.r0.b1.o.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55100a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55100a = cVar;
        }

        @Override // d.a.r0.b1.o.b.c.b
        public void a(int i2) {
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int currentItem = this.f55100a.f55091b.getCurrentItem() + this.f55100a.j;
                if (d.a.r0.b1.o.a.e.a.g(currentItem) == 0 || i2 <= d.a.r0.b1.o.a.e.a.g(currentItem) - 1) {
                    int i3 = i2 + 1;
                    this.f55100a.f55093d.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.b(d.a.r0.b1.o.a.e.a.h(currentItem, i3))));
                    h2 = d.a.r0.b1.o.a.e.a.h(currentItem, i3);
                } else if (this.f55100a.f55092c.getCurrentItem() == d.a.r0.b1.o.a.e.a.g(currentItem) + 1) {
                    this.f55100a.f55093d.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.b(d.a.r0.b1.o.a.e.a.f(currentItem))));
                    h2 = d.a.r0.b1.o.a.e.a.f(currentItem);
                } else {
                    this.f55100a.f55093d.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.b(d.a.r0.b1.o.a.e.a.h(currentItem, i2))));
                    h2 = d.a.r0.b1.o.a.e.a.h(currentItem, i2);
                }
                int i4 = h2 - 1;
                if (this.f55100a.f55093d.getCurrentItem() > i4) {
                    this.f55100a.f55093d.setCurrentItem(i4);
                }
                if (this.f55100a.x != null) {
                    this.f55100a.x.a();
                }
            }
        }
    }

    /* renamed from: d.a.r0.b1.o.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1233c implements d.a.r0.b1.o.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f55101a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f55102b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f55103c;

        public C1233c(c cVar, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55103c = cVar;
            this.f55101a = list;
            this.f55102b = list2;
        }

        @Override // d.a.r0.b1.o.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = i2 + this.f55103c.j;
                this.f55103c.p = i3;
                int currentItem = this.f55103c.f55092c.getCurrentItem();
                if (this.f55103c.j == this.f55103c.k) {
                    this.f55103c.f55092c.setAdapter(new d.a.r0.b1.o.a.a.b(this.f55103c.l, this.f55103c.m));
                    if (currentItem > this.f55103c.f55092c.getAdapter().a() - 1) {
                        currentItem = this.f55103c.f55092c.getAdapter().a() - 1;
                        this.f55103c.f55092c.setCurrentItem(currentItem);
                    }
                    int i4 = currentItem + this.f55103c.l;
                    if (this.f55103c.l != this.f55103c.m) {
                        if (i4 != this.f55103c.l) {
                            if (i4 != this.f55103c.m) {
                                this.f55103c.F(i3, i4, 1, 31, this.f55101a, this.f55102b);
                            } else {
                                c cVar = this.f55103c;
                                cVar.F(i3, i4, 1, cVar.o, this.f55101a, this.f55102b);
                            }
                        } else {
                            c cVar2 = this.f55103c;
                            cVar2.F(i3, i4, cVar2.n, 31, this.f55101a, this.f55102b);
                        }
                    } else {
                        c cVar3 = this.f55103c;
                        cVar3.F(i3, i4, cVar3.n, this.f55103c.o, this.f55101a, this.f55102b);
                    }
                } else if (i3 == this.f55103c.j) {
                    this.f55103c.f55092c.setAdapter(new d.a.r0.b1.o.a.a.b(this.f55103c.l, 12));
                    if (currentItem > this.f55103c.f55092c.getAdapter().a() - 1) {
                        currentItem = this.f55103c.f55092c.getAdapter().a() - 1;
                        this.f55103c.f55092c.setCurrentItem(currentItem);
                    }
                    int i5 = currentItem + this.f55103c.l;
                    if (i5 != this.f55103c.l) {
                        this.f55103c.F(i3, i5, 1, 31, this.f55101a, this.f55102b);
                    } else {
                        c cVar4 = this.f55103c;
                        cVar4.F(i3, i5, cVar4.n, 31, this.f55101a, this.f55102b);
                    }
                } else if (i3 == this.f55103c.k) {
                    this.f55103c.f55092c.setAdapter(new d.a.r0.b1.o.a.a.b(1, this.f55103c.m));
                    if (currentItem > this.f55103c.f55092c.getAdapter().a() - 1) {
                        currentItem = this.f55103c.f55092c.getAdapter().a() - 1;
                        this.f55103c.f55092c.setCurrentItem(currentItem);
                    }
                    int i6 = 1 + currentItem;
                    if (i6 != this.f55103c.m) {
                        this.f55103c.F(i3, i6, 1, 31, this.f55101a, this.f55102b);
                    } else {
                        c cVar5 = this.f55103c;
                        cVar5.F(i3, i6, 1, cVar5.o, this.f55101a, this.f55102b);
                    }
                } else {
                    this.f55103c.f55092c.setAdapter(new d.a.r0.b1.o.a.a.b(1, 12));
                    c cVar6 = this.f55103c;
                    cVar6.F(i3, 1 + cVar6.f55092c.getCurrentItem(), 1, 31, this.f55101a, this.f55102b);
                }
                if (this.f55103c.x != null) {
                    this.f55103c.x.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements d.a.r0.b1.o.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f55104a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f55105b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f55106c;

        public d(c cVar, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55106c = cVar;
            this.f55104a = list;
            this.f55105b = list2;
        }

        @Override // d.a.r0.b1.o.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = i2 + 1;
                if (this.f55106c.j == this.f55106c.k) {
                    int i4 = (i3 + this.f55106c.l) - 1;
                    if (this.f55106c.l != this.f55106c.m) {
                        if (this.f55106c.l != i4) {
                            if (this.f55106c.m == i4) {
                                c cVar = this.f55106c;
                                cVar.F(cVar.p, i4, 1, this.f55106c.o, this.f55104a, this.f55105b);
                            } else {
                                c cVar2 = this.f55106c;
                                cVar2.F(cVar2.p, i4, 1, 31, this.f55104a, this.f55105b);
                            }
                        } else {
                            c cVar3 = this.f55106c;
                            cVar3.F(cVar3.p, i4, this.f55106c.n, 31, this.f55104a, this.f55105b);
                        }
                    } else {
                        c cVar4 = this.f55106c;
                        cVar4.F(cVar4.p, i4, this.f55106c.n, this.f55106c.o, this.f55104a, this.f55105b);
                    }
                } else if (this.f55106c.p == this.f55106c.j) {
                    int i5 = (i3 + this.f55106c.l) - 1;
                    if (i5 == this.f55106c.l) {
                        c cVar5 = this.f55106c;
                        cVar5.F(cVar5.p, i5, this.f55106c.n, 31, this.f55104a, this.f55105b);
                    } else {
                        c cVar6 = this.f55106c;
                        cVar6.F(cVar6.p, i5, 1, 31, this.f55104a, this.f55105b);
                    }
                } else if (this.f55106c.p == this.f55106c.k) {
                    if (i3 == this.f55106c.m) {
                        c cVar7 = this.f55106c;
                        cVar7.F(cVar7.p, this.f55106c.f55092c.getCurrentItem() + 1, 1, this.f55106c.o, this.f55104a, this.f55105b);
                    } else {
                        c cVar8 = this.f55106c;
                        cVar8.F(cVar8.p, this.f55106c.f55092c.getCurrentItem() + 1, 1, 31, this.f55104a, this.f55105b);
                    }
                } else {
                    c cVar9 = this.f55106c;
                    cVar9.F(cVar9.p, i3, 1, 31, this.f55104a, this.f55105b);
                }
                if (this.f55106c.x != null) {
                    this.f55106c.x.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements d.a.r0.b1.o.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55107a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55107a = cVar;
        }

        @Override // d.a.r0.b1.o.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f55107a.x.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1197516925, "Ld/a/r0/b1/o/a/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1197516925, "Ld/a/r0/b1/o/a/f/c;");
                return;
            }
        }
        y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public c(View view, boolean[] zArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, zArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
        this.f55090a = view;
        this.f55098i = zArr;
        this.f55097h = i2;
        this.q = i3;
        O(view);
    }

    public void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.u = f2;
            z();
        }
    }

    public final void B(int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            WheelView wheelView = (WheelView) this.f55090a.findViewById(R.id.year);
            this.f55091b = wheelView;
            wheelView.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.e(this.j, this.k)));
            this.f55091b.setLabel("");
            this.f55091b.setCurrentItem(i2 - this.j);
            this.f55091b.setGravity(this.f55097h);
            WheelView wheelView2 = (WheelView) this.f55090a.findViewById(R.id.month);
            this.f55092c = wheelView2;
            wheelView2.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.d(i2)));
            this.f55092c.setLabel("");
            int g2 = d.a.r0.b1.o.a.e.a.g(i2);
            if (g2 != 0 && (i3 > g2 - 1 || z)) {
                this.f55092c.setCurrentItem(i3 + 1);
            } else {
                this.f55092c.setCurrentItem(i3);
            }
            this.f55092c.setGravity(this.f55097h);
            this.f55093d = (WheelView) this.f55090a.findViewById(R.id.day);
            if (d.a.r0.b1.o.a.e.a.g(i2) == 0) {
                this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.b(d.a.r0.b1.o.a.e.a.h(i2, i3))));
            } else {
                this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.a(d.a.r0.b1.o.a.e.a.b(d.a.r0.b1.o.a.e.a.f(i2))));
            }
            this.f55093d.setLabel("");
            this.f55093d.setCurrentItem(i4 - 1);
            this.f55093d.setGravity(this.f55097h);
            WheelView wheelView3 = (WheelView) this.f55090a.findViewById(R.id.hour);
            this.f55094e = wheelView3;
            wheelView3.setAdapter(new d.a.r0.b1.o.a.a.b(0, 23));
            this.f55094e.setCurrentItem(i5);
            this.f55094e.setGravity(this.f55097h);
            WheelView wheelView4 = (WheelView) this.f55090a.findViewById(R.id.min);
            this.f55095f = wheelView4;
            wheelView4.setAdapter(new d.a.r0.b1.o.a.a.b(0, 59));
            this.f55095f.setCurrentItem(i6);
            this.f55095f.setGravity(this.f55097h);
            WheelView wheelView5 = (WheelView) this.f55090a.findViewById(R.id.second);
            this.f55096g = wheelView5;
            wheelView5.setAdapter(new d.a.r0.b1.o.a.a.b(0, 59));
            this.f55096g.setCurrentItem(i6);
            this.f55096g.setGravity(this.f55097h);
            this.f55091b.setOnItemSelectedListener(new a(this));
            this.f55092c.setOnItemSelectedListener(new b(this));
            q(this.f55093d);
            q(this.f55094e);
            q(this.f55095f);
            q(this.f55096g);
            boolean[] zArr = this.f55098i;
            if (zArr.length == 6) {
                this.f55091b.setVisibility(zArr[0] ? 0 : 8);
                this.f55092c.setVisibility(this.f55098i[1] ? 0 : 8);
                this.f55093d.setVisibility(this.f55098i[2] ? 0 : 8);
                this.f55094e.setVisibility(this.f55098i[3] ? 0 : 8);
                this.f55095f.setVisibility(this.f55098i[4] ? 0 : 8);
                this.f55096g.setVisibility(this.f55098i[5] ? 0 : 8);
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

    public void D(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            if (this.w) {
                int[] d2 = d.a.r0.b1.o.a.e.b.d(i2, i3 + 1, i4);
                B(d2[0], d2[1] - 1, d2[2], d2[3] == 1, i5, i6, i7);
                return;
            }
            H(i2, i3, i4, i5, i6, i7);
        }
    }

    public void E(Calendar calendar, Calendar calendar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, calendar, calendar2) == null) {
            if (calendar == null && calendar2 != null) {
                int i2 = calendar2.get(1);
                int i3 = calendar2.get(2) + 1;
                int i4 = calendar2.get(5);
                int i5 = this.j;
                if (i2 > i5) {
                    this.k = i2;
                    this.m = i3;
                    this.o = i4;
                } else if (i2 == i5) {
                    int i6 = this.l;
                    if (i3 > i6) {
                        this.k = i2;
                        this.m = i3;
                        this.o = i4;
                    } else if (i3 != i6 || i4 <= this.n) {
                    } else {
                        this.k = i2;
                        this.m = i3;
                        this.o = i4;
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
                int i7 = calendar.get(1);
                int i8 = calendar.get(2) + 1;
                int i9 = calendar.get(5);
                int i10 = this.k;
                if (i7 < i10) {
                    this.l = i8;
                    this.n = i9;
                    this.j = i7;
                } else if (i7 == i10) {
                    int i11 = this.m;
                    if (i8 < i11) {
                        this.l = i8;
                        this.n = i9;
                        this.j = i7;
                    } else if (i8 != i11 || i9 >= this.o) {
                    } else {
                        this.l = i8;
                        this.n = i9;
                        this.j = i7;
                    }
                }
            }
        }
    }

    public final void F(int i2, int i3, int i4, int i5, List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), list, list2}) == null) {
            int currentItem = this.f55093d.getCurrentItem();
            if (list.contains(String.valueOf(i3))) {
                if (i5 > 31) {
                    i5 = 31;
                }
                this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(i4, i5));
            } else if (list2.contains(String.valueOf(i3))) {
                if (i5 > 30) {
                    i5 = 30;
                }
                this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(i4, i5));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                if (i5 > 29) {
                    i5 = 29;
                }
                this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(i4, i5));
            } else {
                if (i5 > 28) {
                    i5 = 28;
                }
                this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(i4, i5));
            }
            if (currentItem > this.f55093d.getAdapter().a() - 1) {
                this.f55093d.setCurrentItem(this.f55093d.getAdapter().a() - 1);
            }
        }
    }

    public void G(d.a.r0.b1.o.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public final void H(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
            List asList2 = Arrays.asList("4", "6", "9", "11");
            this.p = i2;
            WheelView wheelView = (WheelView) this.f55090a.findViewById(R.id.year);
            this.f55091b = wheelView;
            wheelView.setAdapter(new d.a.r0.b1.o.a.a.b(this.j, this.k));
            this.f55091b.setCurrentItem(i2 - this.j);
            this.f55091b.setGravity(this.f55097h);
            WheelView wheelView2 = (WheelView) this.f55090a.findViewById(R.id.month);
            this.f55092c = wheelView2;
            int i10 = this.j;
            int i11 = this.k;
            if (i10 == i11) {
                wheelView2.setAdapter(new d.a.r0.b1.o.a.a.b(this.l, this.m));
                this.f55092c.setCurrentItem((i3 + 1) - this.l);
            } else if (i2 == i10) {
                wheelView2.setAdapter(new d.a.r0.b1.o.a.a.b(this.l, 12));
                this.f55092c.setCurrentItem((i3 + 1) - this.l);
            } else if (i2 == i11) {
                wheelView2.setAdapter(new d.a.r0.b1.o.a.a.b(1, this.m));
                this.f55092c.setCurrentItem(i3);
            } else {
                wheelView2.setAdapter(new d.a.r0.b1.o.a.a.b(1, 12));
                this.f55092c.setCurrentItem(i3);
            }
            this.f55092c.setGravity(this.f55097h);
            this.f55093d = (WheelView) this.f55090a.findViewById(R.id.day);
            if (this.j == this.k && this.l == this.m) {
                int i12 = i3 + 1;
                if (asList.contains(String.valueOf(i12))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(this.n, this.o));
                } else if (asList2.contains(String.valueOf(i12))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(this.n, this.o));
                } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(this.n, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(this.n, this.o));
                }
                this.f55093d.setCurrentItem(i4 - this.n);
            } else if (i2 == this.j && (i9 = i3 + 1) == this.l) {
                if (asList.contains(String.valueOf(i9))) {
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(this.n, 31));
                } else if (asList2.contains(String.valueOf(i9))) {
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(this.n, 30));
                } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(this.n, 29));
                } else {
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(this.n, 28));
                }
                this.f55093d.setCurrentItem(i4 - this.n);
            } else if (i2 == this.k && (i8 = i3 + 1) == this.m) {
                if (asList.contains(String.valueOf(i8))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(1, this.o));
                } else if (asList2.contains(String.valueOf(i8))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(1, this.o));
                } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(1, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(1, this.o));
                }
                this.f55093d.setCurrentItem(i4 - 1);
            } else {
                int i13 = i3 + 1;
                if (asList.contains(String.valueOf(i13))) {
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(1, 31));
                } else if (asList2.contains(String.valueOf(i13))) {
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(1, 30));
                } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(1, 29));
                } else {
                    this.f55093d.setAdapter(new d.a.r0.b1.o.a.a.b(1, 28));
                }
                this.f55093d.setCurrentItem(i4 - 1);
            }
            this.f55093d.setGravity(this.f55097h);
            WheelView wheelView3 = (WheelView) this.f55090a.findViewById(R.id.hour);
            this.f55094e = wheelView3;
            wheelView3.setAdapter(new d.a.r0.b1.o.a.a.b(0, 23));
            this.f55094e.setCurrentItem(i5);
            this.f55094e.setGravity(this.f55097h);
            WheelView wheelView4 = (WheelView) this.f55090a.findViewById(R.id.min);
            this.f55095f = wheelView4;
            wheelView4.setAdapter(new d.a.r0.b1.o.a.a.b(0, 59));
            this.f55095f.setCurrentItem(i6);
            this.f55095f.setGravity(this.f55097h);
            WheelView wheelView5 = (WheelView) this.f55090a.findViewById(R.id.second);
            this.f55096g = wheelView5;
            wheelView5.setAdapter(new d.a.r0.b1.o.a.a.b(0, 59));
            this.f55096g.setCurrentItem(i7);
            this.f55096g.setGravity(this.f55097h);
            this.f55091b.setOnItemSelectedListener(new C1233c(this, asList, asList2));
            this.f55092c.setOnItemSelectedListener(new d(this, asList, asList2));
            q(this.f55093d);
            q(this.f55094e);
            q(this.f55095f);
            q(this.f55096g);
            boolean[] zArr = this.f55098i;
            if (zArr.length == 6) {
                this.f55091b.setVisibility(zArr[0] ? 0 : 8);
                this.f55092c.setVisibility(this.f55098i[1] ? 0 : 8);
                this.f55093d.setVisibility(this.f55098i[2] ? 0 : 8);
                this.f55094e.setVisibility(this.f55098i[3] ? 0 : 8);
                this.f55095f.setVisibility(this.f55098i[4] ? 0 : 8);
                this.f55096g.setVisibility(this.f55098i[5] ? 0 : 8);
                r();
                return;
            }
            throw new IllegalArgumentException("type[] length is not 6");
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.j = i2;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f55093d.setTextColorCenter(this.s);
            this.f55092c.setTextColorCenter(this.s);
            this.f55091b.setTextColorCenter(this.s);
            this.f55094e.setTextColorCenter(this.s);
            this.f55095f.setTextColorCenter(this.s);
            this.f55096g.setTextColorCenter(this.s);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.s = i2;
            J();
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f55093d.setTextColorOut(this.r);
            this.f55092c.setTextColorOut(this.r);
            this.f55091b.setTextColorOut(this.r);
            this.f55094e.setTextColorOut(this.r);
            this.f55095f.setTextColorOut(this.r);
            this.f55096g.setTextColorOut(this.r);
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.r = i2;
            L();
        }
    }

    public void N(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.f55093d.setTextXOffset(i2);
            this.f55092c.setTextXOffset(i3);
            this.f55091b.setTextXOffset(i4);
            this.f55094e.setTextXOffset(i5);
            this.f55095f.setTextXOffset(i6);
            this.f55096g.setTextXOffset(i7);
        }
    }

    public void O(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            this.f55090a = view;
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
            int currentItem3 = this.f55091b.getCurrentItem() + this.j;
            if (d.a.r0.b1.o.a.e.a.g(currentItem3) == 0) {
                currentItem2 = this.f55092c.getCurrentItem();
            } else if ((this.f55092c.getCurrentItem() + 1) - d.a.r0.b1.o.a.e.a.g(currentItem3) <= 0) {
                currentItem2 = this.f55092c.getCurrentItem();
            } else if ((this.f55092c.getCurrentItem() + 1) - d.a.r0.b1.o.a.e.a.g(currentItem3) == 1) {
                currentItem = this.f55092c.getCurrentItem();
                z = true;
                int[] b2 = d.a.r0.b1.o.a.e.b.b(currentItem3, currentItem, this.f55093d.getCurrentItem() + 1, z);
                sb.append(b2[0]);
                sb.append("-");
                sb.append(b2[1]);
                sb.append("-");
                sb.append(b2[2]);
                sb.append(" ");
                sb.append(this.f55094e.getCurrentItem());
                sb.append(":");
                sb.append(this.f55095f.getCurrentItem());
                sb.append(":");
                sb.append(this.f55096g.getCurrentItem());
                return sb.toString();
            } else {
                currentItem = this.f55092c.getCurrentItem();
                z = false;
                int[] b22 = d.a.r0.b1.o.a.e.b.b(currentItem3, currentItem, this.f55093d.getCurrentItem() + 1, z);
                sb.append(b22[0]);
                sb.append("-");
                sb.append(b22[1]);
                sb.append("-");
                sb.append(b22[2]);
                sb.append(" ");
                sb.append(this.f55094e.getCurrentItem());
                sb.append(":");
                sb.append(this.f55095f.getCurrentItem());
                sb.append(":");
                sb.append(this.f55096g.getCurrentItem());
                return sb.toString();
            }
            currentItem = currentItem2 + 1;
            z = false;
            int[] b222 = d.a.r0.b1.o.a.e.b.b(currentItem3, currentItem, this.f55093d.getCurrentItem() + 1, z);
            sb.append(b222[0]);
            sb.append("-");
            sb.append(b222[1]);
            sb.append("-");
            sb.append(b222[2]);
            sb.append(" ");
            sb.append(this.f55094e.getCurrentItem());
            sb.append(":");
            sb.append(this.f55095f.getCurrentItem());
            sb.append(":");
            sb.append(this.f55096g.getCurrentItem());
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
                int currentItem = this.f55092c.getCurrentItem();
                int i2 = this.l;
                if (currentItem + i2 == i2) {
                    sb.append(this.f55091b.getCurrentItem() + this.j);
                    sb.append("-");
                    sb.append(this.f55092c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.f55093d.getCurrentItem() + this.n);
                    sb.append(" ");
                    sb.append(this.f55094e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f55095f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f55096g.getCurrentItem());
                } else {
                    sb.append(this.f55091b.getCurrentItem() + this.j);
                    sb.append("-");
                    sb.append(this.f55092c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.f55093d.getCurrentItem() + 1);
                    sb.append(" ");
                    sb.append(this.f55094e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f55095f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f55096g.getCurrentItem());
                }
            } else {
                sb.append(this.f55091b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.f55092c.getCurrentItem() + 1);
                sb.append("-");
                sb.append(this.f55093d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f55094e.getCurrentItem());
                sb.append(":");
                sb.append(this.f55095f.getCurrentItem());
                sb.append(":");
                sb.append(this.f55096g.getCurrentItem());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f55093d.h(z);
            this.f55092c.h(z);
            this.f55091b.h(z);
            this.f55094e.h(z);
            this.f55095f.h(z);
            this.f55096g.h(z);
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
            this.f55093d.setTextSize(this.q);
            this.f55092c.setTextSize(this.q);
            this.f55091b.setTextSize(this.q);
            this.f55094e.setTextSize(this.q);
            this.f55095f.setTextSize(this.q);
            this.f55096g.setTextSize(this.q);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f55091b.setCyclic(z);
            this.f55092c.setCyclic(z);
            this.f55093d.setCyclic(z);
            this.f55094e.setCyclic(z);
            this.f55095f.setCyclic(z);
            this.f55096g.setCyclic(z);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f55093d.setDividerColor(this.t);
            this.f55092c.setDividerColor(this.t);
            this.f55091b.setDividerColor(this.t);
            this.f55094e.setDividerColor(this.t);
            this.f55095f.setDividerColor(this.t);
            this.f55096g.setDividerColor(this.t);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.t = i2;
            t();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f55093d.setDividerType(this.v);
            this.f55092c.setDividerType(this.v);
            this.f55091b.setDividerType(this.v);
            this.f55094e.setDividerType(this.v);
            this.f55095f.setDividerType(this.v);
            this.f55096g.setDividerType(this.v);
        }
    }

    public void w(WheelView.DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dividerType) == null) {
            this.v = dividerType;
            v();
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.k = i2;
        }
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) || this.w) {
            return;
        }
        if (str != null) {
            this.f55091b.setLabel(str);
        } else {
            this.f55091b.setLabel(this.f55090a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f55092c.setLabel(str2);
        } else {
            this.f55092c.setLabel(this.f55090a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f55093d.setLabel(str3);
        } else {
            this.f55093d.setLabel(this.f55090a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f55094e.setLabel(str4);
        } else {
            this.f55094e.setLabel(this.f55090a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f55095f.setLabel(str5);
        } else {
            this.f55095f.setLabel(this.f55090a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f55096g.setLabel(str6);
        } else {
            this.f55096g.setLabel(this.f55090a.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f55093d.setLineSpacingMultiplier(this.u);
            this.f55092c.setLineSpacingMultiplier(this.u);
            this.f55091b.setLineSpacingMultiplier(this.u);
            this.f55094e.setLineSpacingMultiplier(this.u);
            this.f55095f.setLineSpacingMultiplier(this.u);
            this.f55096g.setLineSpacingMultiplier(this.u);
        }
    }
}
