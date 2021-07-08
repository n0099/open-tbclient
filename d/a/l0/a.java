package d.a.l0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.l0.l.k;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f42917a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42918b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42919c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0618a {
        void onFinish(String str);
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f42921f;

        public b(a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42921f = aVar;
            this.f42920e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f42921f.e(this.f42920e);
                    d.a.l0.e.c.j().d(this.f42920e);
                } catch (Throwable th) {
                    d.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42922e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42923f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0618a f42924g;

        public c(a aVar, Context context, long j, InterfaceC0618a interfaceC0618a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0618a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42922e = context;
            this.f42923f = j;
            this.f42924g = interfaceC0618a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.l0.e.c.j().e(this.f42922e, 0, null, this.f42923f, this.f42924g);
                } catch (Throwable th) {
                    d.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42926f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0618a f42927g;

        public d(a aVar, Context context, long j, InterfaceC0618a interfaceC0618a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0618a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42925e = context;
            this.f42926f = j;
            this.f42927g = interfaceC0618a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.l0.e.c.j().f(this.f42925e, this.f42926f, this.f42927g);
                } catch (Throwable th) {
                    d.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42928e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42929f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0618a f42930g;

        public e(a aVar, Context context, long j, InterfaceC0618a interfaceC0618a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0618a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42928e = context;
            this.f42929f = j;
            this.f42930g = interfaceC0618a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.l0.e.c.j().l(this.f42928e, this.f42929f, this.f42930g);
                } catch (Throwable th) {
                    d.a.l0.l.c.d(th);
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f42917a == null) {
                synchronized (a.class) {
                    if (f42917a == null) {
                        f42917a = new a();
                    }
                }
            }
            return f42917a;
        }
        return (a) invokeV.objValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            int intValue = ((Integer) k.d(context).second).intValue();
            if (intValue == 1) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE;
            }
            if (intValue == 3) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_TELECOM;
            }
            if (intValue == 2) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_UNICOM;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void d(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2) == null) {
            synchronized (this) {
                try {
                    f42918b = str;
                    f42919c = str2;
                    d.a.l0.k.b.a().post(new b(this, context));
                } catch (Throwable th) {
                    d.a.l0.l.c.d(th);
                }
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            String l0 = d.a.l0.b.a.h(context).l0();
            if (TextUtils.isEmpty(l0)) {
                return;
            }
            String[] split = l0.split("_");
            if (split.length != 2) {
                d.a.l0.b.a.h(context).j();
            }
            f42918b = split[0];
            f42919c = split[1];
        }
    }

    public void f(Context context, long j, InterfaceC0618a interfaceC0618a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), interfaceC0618a}) == null) {
            try {
                d.a.l0.k.b.a().post(new d(this, context, j, interfaceC0618a));
            } catch (Throwable th) {
                d.a.l0.l.c.d(th);
            }
        }
    }

    public void g(Context context, long j, InterfaceC0618a interfaceC0618a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), interfaceC0618a}) == null) {
            try {
                d.a.l0.k.b.a().post(new c(this, context, j, interfaceC0618a));
            } catch (Throwable th) {
                d.a.l0.l.c.d(th);
            }
        }
    }

    public void h(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            try {
                d.a.l0.b.a.h(context).R(z);
            } catch (Throwable th) {
                d.a.l0.l.c.d(th);
            }
        }
    }

    public void i(Context context, long j, InterfaceC0618a interfaceC0618a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j), interfaceC0618a}) == null) {
            try {
                d.a.l0.k.b.a().post(new e(this, context, j, interfaceC0618a));
            } catch (Throwable th) {
                d.a.l0.l.c.d(th);
            }
        }
    }
}
