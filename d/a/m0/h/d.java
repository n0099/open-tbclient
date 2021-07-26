package d.a.m0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43598f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43599g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43600h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f43601i;

        public a(int i2, int i3, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43598f = i2;
            this.f43599g = i3;
            this.f43600h = str;
            this.f43601i = context;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f43598f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f43599g);
                    jSONObject.put("3", this.f43600h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    d.a.m0.h.b.c(this.f43601i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43602f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43603g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43604h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43605i;
        public final /* synthetic */ String j;

        public b(int i2, Context context, int i3, int i4, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), context, Integer.valueOf(i3), Integer.valueOf(i4), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43602f = i2;
            this.f43603g = context;
            this.f43604h = i3;
            this.f43605i = i4;
            this.j = str;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f43602f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = d.a.m0.b.a.h(this.f43603g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", d.a.m0.b.a.h(this.f43603g).a0());
                    jSONObject.put("7", this.f43604h);
                    if (this.f43605i != -1) {
                        jSONObject.put("8", this.f43605i);
                    }
                    jSONObject.put("9", this.j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new d.a.m0.f.d(this.f43603g, null).h(jSONObject);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43606f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43607g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43608h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43609i;
        public final /* synthetic */ String j;

        public c(int i2, Context context, int i3, int i4, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), context, Integer.valueOf(i3), Integer.valueOf(i4), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43606f = i2;
            this.f43607g = context;
            this.f43608h = i3;
            this.f43609i = i4;
            this.j = str;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f43606f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = d.a.m0.b.a.h(this.f43607g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", d.a.m0.b.a.h(this.f43607g).e0());
                    jSONObject.put("7", this.f43608h);
                    if (this.f43609i != -1) {
                        jSONObject.put("8", this.f43609i);
                    }
                    jSONObject.put("9", this.j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    d.a.m0.h.b.c(this.f43607g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: d.a.m0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0633d extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43611g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43612h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43613i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0633d(int i2, int i3, String str, int i4, int i5, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43610f = i2;
            this.f43611g = i3;
            this.f43612h = str;
            this.f43613i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f43613i);
                    jSONObject.put("2", this.f43610f);
                    if (this.f43611g != -1) {
                        jSONObject.put("3", this.f43611g);
                    }
                    if (!TextUtils.isEmpty(this.f43612h)) {
                        jSONObject.put("4", this.f43612h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    d.a.m0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43614f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43615g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43616h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43617i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i2, int i3, String str, int i4, int i5, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43614f = i2;
            this.f43615g = i3;
            this.f43616h = str;
            this.f43617i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f43617i);
                    jSONObject.put("2", this.f43614f);
                    if (this.f43615g != -1) {
                        jSONObject.put("3", this.f43615g);
                    }
                    if (!TextUtils.isEmpty(this.f43616h)) {
                        jSONObject.put("4", this.f43616h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    d.a.m0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            d.a.m0.k.e.c().b(new C0633d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            d.a.m0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            d.a.m0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            d.a.m0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            d.a.m0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
