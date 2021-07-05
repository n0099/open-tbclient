package d.a.o0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.l.k;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46217a;

    /* renamed from: b  reason: collision with root package name */
    public static String f46218b;

    /* renamed from: c  reason: collision with root package name */
    public static String f46219c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0668a {
        void onFinish(String str);
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46221f;

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
            this.f46221f = aVar;
            this.f46220e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f46221f.e(this.f46220e);
                    d.a.o0.e.c.j().d(this.f46220e);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f46223f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0668a f46224g;

        public c(a aVar, Context context, long j, InterfaceC0668a interfaceC0668a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0668a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46222e = context;
            this.f46223f = j;
            this.f46224g = interfaceC0668a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.o0.e.c.j().e(this.f46222e, 0, null, this.f46223f, this.f46224g);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f46226f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0668a f46227g;

        public d(a aVar, Context context, long j, InterfaceC0668a interfaceC0668a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0668a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46225e = context;
            this.f46226f = j;
            this.f46227g = interfaceC0668a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.o0.e.c.j().f(this.f46225e, this.f46226f, this.f46227g);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f46229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0668a f46230g;

        public e(a aVar, Context context, long j, InterfaceC0668a interfaceC0668a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0668a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46228e = context;
            this.f46229f = j;
            this.f46230g = interfaceC0668a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.o0.e.c.j().l(this.f46228e, this.f46229f, this.f46230g);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
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
            if (f46217a == null) {
                synchronized (a.class) {
                    if (f46217a == null) {
                        f46217a = new a();
                    }
                }
            }
            return f46217a;
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
                    f46218b = str;
                    f46219c = str2;
                    d.a.o0.k.b.a().post(new b(this, context));
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                }
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            String l0 = d.a.o0.b.a.h(context).l0();
            if (TextUtils.isEmpty(l0)) {
                return;
            }
            String[] split = l0.split("_");
            if (split.length != 2) {
                d.a.o0.b.a.h(context).j();
            }
            f46218b = split[0];
            f46219c = split[1];
        }
    }

    public void f(Context context, long j, InterfaceC0668a interfaceC0668a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), interfaceC0668a}) == null) {
            try {
                d.a.o0.k.b.a().post(new d(this, context, j, interfaceC0668a));
            } catch (Throwable th) {
                d.a.o0.l.c.d(th);
            }
        }
    }

    public void g(Context context, long j, InterfaceC0668a interfaceC0668a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), interfaceC0668a}) == null) {
            try {
                d.a.o0.k.b.a().post(new c(this, context, j, interfaceC0668a));
            } catch (Throwable th) {
                d.a.o0.l.c.d(th);
            }
        }
    }

    public void h(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            try {
                d.a.o0.b.a.h(context).R(z);
            } catch (Throwable th) {
                d.a.o0.l.c.d(th);
            }
        }
    }

    public void i(Context context, long j, InterfaceC0668a interfaceC0668a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j), interfaceC0668a}) == null) {
            try {
                d.a.o0.k.b.a().post(new e(this, context, j, interfaceC0668a));
            } catch (Throwable th) {
                d.a.o0.l.c.d(th);
            }
        }
    }
}
