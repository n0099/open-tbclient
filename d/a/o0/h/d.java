package d.a.o0.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46394f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46395g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46396h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f46397i;

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
            this.f46394f = i2;
            this.f46395g = i3;
            this.f46396h = str;
            this.f46397i = context;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f46394f);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.f46395g);
                    jSONObject.put("3", this.f46396h);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    d.a.o0.h.b.c(this.f46397i).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46398f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46399g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46400h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f46401i;
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
            this.f46398f = i2;
            this.f46399g = context;
            this.f46400h = i3;
            this.f46401i = i4;
            this.j = str;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f46398f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int Z = d.a.o0.b.a.h(this.f46399g).Z();
                    if (Z != -1) {
                        jSONObject.put("4", Z);
                    }
                    jSONObject.put("5", d.a.o0.b.a.h(this.f46399g).a0());
                    jSONObject.put("7", this.f46400h);
                    if (this.f46401i != -1) {
                        jSONObject.put("8", this.f46401i);
                    }
                    jSONObject.put("9", this.j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.q);
                    jSONObject.put("12", "1");
                    new d.a.o0.f.d(this.f46399g, null).h(jSONObject);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46402f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46403g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46404h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f46405i;
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
            this.f46402f = i2;
            this.f46403g = context;
            this.f46404h = i3;
            this.f46405i = i4;
            this.j = str;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f46402f);
                    jSONObject.put("3", System.currentTimeMillis());
                    int d0 = d.a.o0.b.a.h(this.f46403g).d0();
                    if (d0 != -1) {
                        jSONObject.put("4", d0);
                    }
                    jSONObject.put("5", d.a.o0.b.a.h(this.f46403g).e0());
                    jSONObject.put("7", this.f46404h);
                    if (this.f46405i != -1) {
                        jSONObject.put("8", this.f46405i);
                    }
                    jSONObject.put("9", this.j);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", i.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    d.a.o0.h.b.c(this.f46403g).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: d.a.o0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0674d extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46406f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46407g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46408h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f46409i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0674d(int i2, int i3, String str, int i4, int i5, Context context) {
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
            this.f46406f = i2;
            this.f46407g = i3;
            this.f46408h = str;
            this.f46409i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f46409i);
                    jSONObject.put("2", this.f46406f);
                    if (this.f46407g != -1) {
                        jSONObject.put("3", this.f46407g);
                    }
                    if (!TextUtils.isEmpty(this.f46408h)) {
                        jSONObject.put("4", this.f46408h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.q);
                    jSONObject.put("7", this.j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    d.a.o0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends d.a.o0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46410f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46411g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46412h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f46413i;
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
            this.f46410f = i2;
            this.f46411g = i3;
            this.f46412h = str;
            this.f46413i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.o0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.f46413i);
                    jSONObject.put("2", this.f46410f);
                    if (this.f46411g != -1) {
                        jSONObject.put("3", this.f46411g);
                    }
                    if (!TextUtils.isEmpty(this.f46412h)) {
                        jSONObject.put("4", this.f46412h);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", i.r);
                    jSONObject.put("7", this.j);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    d.a.o0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            d.a.o0.k.e.c().b(new C0674d(i4, i5, str, i2, i3, context));
        }
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            d.a.o0.k.e.c().b(new c(i2, context, i4, i3, str));
        }
    }

    public static void c(Context context, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            d.a.o0.k.e.c().b(new a(i2, i3, str, context));
        }
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            d.a.o0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
        }
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            d.a.o0.k.e.c().b(new b(i2, context, i4, i3, str));
        }
    }
}
