package j.a.a.e.r;

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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Gson f62470c;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f62471b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f62472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UrlPageParams f62473f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f62474g;

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
            this.f62474g = bVar;
            this.f62472e = i2;
            this.f62473f = urlPageParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62474g.a == null) {
                return;
            }
            if (this.f62472e == 1) {
                this.f62474g.a.onOpenUrl(this.f62473f);
            }
            if (this.f62472e == 3) {
                this.f62474g.a.onUpdateTopUi(this.f62473f);
            }
        }
    }

    /* renamed from: j.a.a.e.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC2319b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62475e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62476f;

        public RunnableC2319b(b bVar, String str) {
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
            this.f62476f = bVar;
            this.f62475e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62476f.a == null) {
                return;
            }
            this.f62476f.a.onNativeOperation(new NativeOperationParams(5, this.f62475e));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62478f;

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
            this.f62478f = bVar;
            this.f62477e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62478f.a == null) {
                return;
            }
            this.f62478f.a.onNativeOperation(new NativeOperationParams(4, this.f62477e));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62480f;

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
            this.f62480f = bVar;
            this.f62479e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62480f.a == null) {
                return;
            }
            this.f62480f.a.onNativeOperation(new NativeOperationParams(6, this.f62479e));
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        String getToken();

        void onNativeOperation(NativeOperationParams nativeOperationParams);

        void onOpenUrl(UrlPageParams urlPageParams);

        void onUpdateTopUi(UrlPageParams urlPageParams);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-560943443, "Lj/a/a/e/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-560943443, "Lj/a/a/e/r/b;");
                return;
            }
        }
        f62470c = new Gson();
    }

    public b(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62471b = new Handler(Looper.getMainLooper());
        this.a = eVar;
    }

    public final void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.f62471b.post(runnable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callAndroid(int i2, String str) {
        UrlPageParams urlPageParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            RLog.info("YYPaySdkJsInterface", "callAndroid: code=" + i2);
            if (i2 != 1 && i2 != 3) {
                if (i2 == 4) {
                    if (this.a != null) {
                        b(new c(this, str));
                        return;
                    }
                    return;
                } else if (i2 != 5) {
                    if (i2 == 6 && this.a != null) {
                        b(new d(this, str));
                        return;
                    }
                    return;
                } else if (this.a != null) {
                    b(new RunnableC2319b(this, str));
                    return;
                } else {
                    return;
                }
            }
            String str2 = i2 == 1 ? "CODE_OPEN_URL_PAGE" : "CODE_UPFATE_TOP_INFO";
            UrlPageParams urlPageParams2 = null;
            try {
                urlPageParams = (UrlPageParams) f62470c.fromJson(str, (Class<Object>) UrlPageParams.class);
                try {
                    RLog.info("YYPaySdkJsInterface", "%s params: %s", str2, urlPageParams);
                } catch (Throwable th) {
                    th = th;
                    urlPageParams2 = urlPageParams;
                    RLog.error("YYPaySdkJsInterface", str2 + " error,", th);
                    urlPageParams = urlPageParams2;
                    if (this.a == null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (this.a == null) {
                b(new a(this, i2, urlPageParams));
            }
        }
    }

    @JavascriptInterface
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e eVar = this.a;
            if (eVar != null) {
                return eVar.getToken();
            }
            RLog.error("YYPaySdkJsInterface", "getToken() mOnJsCallInterface null", new Object[0]);
            return "";
        }
        return (String) invokeV.objValue;
    }
}
