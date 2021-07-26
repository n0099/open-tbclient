package d.a.m0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m0.l.k;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f43421a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43422b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43423c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0627a {
        void onFinish(String str);
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f43425f;

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
            this.f43425f = aVar;
            this.f43424e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f43425f.e(this.f43424e);
                    d.a.m0.e.c.j().d(this.f43424e);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43427f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0627a f43428g;

        public c(a aVar, Context context, long j, InterfaceC0627a interfaceC0627a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0627a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43426e = context;
            this.f43427f = j;
            this.f43428g = interfaceC0627a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.m0.e.c.j().e(this.f43426e, 0, null, this.f43427f, this.f43428g);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0627a f43431g;

        public d(a aVar, Context context, long j, InterfaceC0627a interfaceC0627a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0627a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43429e = context;
            this.f43430f = j;
            this.f43431g = interfaceC0627a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.m0.e.c.j().f(this.f43429e, this.f43430f, this.f43431g);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43433f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0627a f43434g;

        public e(a aVar, Context context, long j, InterfaceC0627a interfaceC0627a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0627a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43432e = context;
            this.f43433f = j;
            this.f43434g = interfaceC0627a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.m0.e.c.j().l(this.f43432e, this.f43433f, this.f43434g);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
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
            if (f43421a == null) {
                synchronized (a.class) {
                    if (f43421a == null) {
                        f43421a = new a();
                    }
                }
            }
            return f43421a;
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
                    f43422b = str;
                    f43423c = str2;
                    d.a.m0.k.b.a().post(new b(this, context));
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                }
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            String l0 = d.a.m0.b.a.h(context).l0();
            if (TextUtils.isEmpty(l0)) {
                return;
            }
            String[] split = l0.split("_");
            if (split.length != 2) {
                d.a.m0.b.a.h(context).j();
            }
            f43422b = split[0];
            f43423c = split[1];
        }
    }

    public void f(Context context, long j, InterfaceC0627a interfaceC0627a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), interfaceC0627a}) == null) {
            try {
                d.a.m0.k.b.a().post(new d(this, context, j, interfaceC0627a));
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
            }
        }
    }

    public void g(Context context, long j, InterfaceC0627a interfaceC0627a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), interfaceC0627a}) == null) {
            try {
                d.a.m0.k.b.a().post(new c(this, context, j, interfaceC0627a));
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
            }
        }
    }

    public void h(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            try {
                d.a.m0.b.a.h(context).R(z);
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
            }
        }
    }

    public void i(Context context, long j, InterfaceC0627a interfaceC0627a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j), interfaceC0627a}) == null) {
            try {
                d.a.m0.k.b.a().post(new e(this, context, j, interfaceC0627a));
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
            }
        }
    }
}
