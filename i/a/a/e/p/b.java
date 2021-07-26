package i.a.a.e.p;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.webview.UrlPageParams;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Gson f73424c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f73425a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f73426b;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f73427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UrlPageParams f73428f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f73429g;

        public a(b bVar, int i2, UrlPageParams urlPageParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), urlPageParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73429g = bVar;
            this.f73427e = i2;
            this.f73428f = urlPageParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73429g.f73425a == null) {
                return;
            }
            if (this.f73427e == 1) {
                this.f73429g.f73425a.b(this.f73428f);
            }
            if (this.f73427e == 3) {
                this.f73429g.f73425a.a(this.f73428f);
            }
        }
    }

    /* renamed from: i.a.a.e.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC2088b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f73430e;

        public RunnableC2088b(b bVar) {
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
            this.f73430e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73430e.f73425a == null) {
                return;
            }
            this.f73430e.f73425a.onNativeOperation(new NativeOperationParams(2));
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f73431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f73432f;

        public c(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73432f = bVar;
            this.f73431e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73432f.f73425a == null) {
                return;
            }
            this.f73432f.f73425a.onNativeOperation(new NativeOperationParams(5, this.f73431e));
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f73433e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f73434f;

        public d(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73434f = bVar;
            this.f73433e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73434f.f73425a == null) {
                return;
            }
            this.f73434f.f73425a.onNativeOperation(new NativeOperationParams(4, this.f73433e));
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f73435e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f73436f;

        public e(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73436f = bVar;
            this.f73435e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73436f.f73425a == null) {
                return;
            }
            this.f73436f.f73425a.onNativeOperation(new NativeOperationParams(6, this.f73435e));
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a(UrlPageParams urlPageParams);

        void b(UrlPageParams urlPageParams);

        String getToken();

        void onNativeOperation(NativeOperationParams nativeOperationParams);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-690085744, "Li/a/a/e/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-690085744, "Li/a/a/e/p/b;");
                return;
            }
        }
        f73424c = new Gson();
    }

    public b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73426b = new Handler(Looper.getMainLooper());
        this.f73425a = fVar;
    }

    public final void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.f73426b.post(runnable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callAndroid(int i2, String str) {
        UrlPageParams urlPageParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            RLog.info("YYPaySdkJsInterface", "callAndroid: code=" + i2 + ", params=" + str);
            switch (i2) {
                case 1:
                case 3:
                    String str2 = i2 == 1 ? "CODE_OPEN_URL_PAGE" : "CODE_UPFATE_TOP_INFO";
                    UrlPageParams urlPageParams2 = null;
                    try {
                        urlPageParams = (UrlPageParams) f73424c.fromJson(str, (Class<Object>) UrlPageParams.class);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        RLog.info("YYPaySdkJsInterface", "%s params: %s", str2, urlPageParams);
                    } catch (Throwable th2) {
                        th = th2;
                        urlPageParams2 = urlPageParams;
                        RLog.error("YYPaySdkJsInterface", str2 + " error,", th);
                        urlPageParams = urlPageParams2;
                        if (this.f73425a == null) {
                        }
                    }
                    if (this.f73425a == null) {
                        b(new a(this, i2, urlPageParams));
                        return;
                    }
                    return;
                case 2:
                    if (this.f73425a != null) {
                        b(new RunnableC2088b(this));
                        return;
                    }
                    return;
                case 4:
                    if (this.f73425a != null) {
                        b(new d(this, str));
                        return;
                    }
                    return;
                case 5:
                    if (this.f73425a != null) {
                        b(new c(this, str));
                        return;
                    }
                    return;
                case 6:
                    if (this.f73425a != null) {
                        b(new e(this, str));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @JavascriptInterface
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f fVar = this.f73425a;
            if (fVar != null) {
                return fVar.getToken();
            }
            RLog.error("YYPaySdkJsInterface", "getToken() mOnJsCallInterface null", new Object[0]);
            return "";
        }
        return (String) invokeV.objValue;
    }
}
