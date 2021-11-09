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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Gson f72459c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f72460a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f72461b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f72462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UrlPageParams f72463f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f72464g;

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
            this.f72464g = bVar;
            this.f72462e = i2;
            this.f72463f = urlPageParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72464g.f72460a == null) {
                return;
            }
            if (this.f72462e == 1) {
                this.f72464g.f72460a.onOpenUrl(this.f72463f);
            }
            if (this.f72462e == 3) {
                this.f72464g.f72460a.onUpdateTopUi(this.f72463f);
            }
        }
    }

    /* renamed from: i.a.a.e.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC2077b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f72465e;

        public RunnableC2077b(b bVar) {
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
            this.f72465e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72465e.f72460a == null) {
                return;
            }
            this.f72465e.f72460a.onNativeOperation(new NativeOperationParams(2));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f72466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f72467f;

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
            this.f72467f = bVar;
            this.f72466e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72467f.f72460a == null) {
                return;
            }
            this.f72467f.f72460a.onNativeOperation(new NativeOperationParams(5, this.f72466e));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f72468e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f72469f;

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
            this.f72469f = bVar;
            this.f72468e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72469f.f72460a == null) {
                return;
            }
            this.f72469f.f72460a.onNativeOperation(new NativeOperationParams(4, this.f72468e));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f72470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f72471f;

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
            this.f72471f = bVar;
            this.f72470e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72471f.f72460a == null) {
                return;
            }
            this.f72471f.f72460a.onNativeOperation(new NativeOperationParams(6, this.f72470e));
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        String getToken();

        void onNativeOperation(NativeOperationParams nativeOperationParams);

        void onOpenUrl(UrlPageParams urlPageParams);

        void onUpdateTopUi(UrlPageParams urlPageParams);
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
        f72459c = new Gson();
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
        this.f72461b = new Handler(Looper.getMainLooper());
        this.f72460a = fVar;
    }

    public final void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.f72461b.post(runnable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callAndroid(int i2, String str) {
        UrlPageParams urlPageParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            RLog.info("YYPaySdkJsInterface", "callAndroid: code=" + i2);
            switch (i2) {
                case 1:
                case 3:
                    String str2 = i2 == 1 ? "CODE_OPEN_URL_PAGE" : "CODE_UPFATE_TOP_INFO";
                    UrlPageParams urlPageParams2 = null;
                    try {
                        urlPageParams = (UrlPageParams) f72459c.fromJson(str, (Class<Object>) UrlPageParams.class);
                        try {
                            RLog.info("YYPaySdkJsInterface", "%s params: %s", str2, urlPageParams);
                        } catch (Throwable th) {
                            th = th;
                            urlPageParams2 = urlPageParams;
                            RLog.error("YYPaySdkJsInterface", str2 + " error,", th);
                            urlPageParams = urlPageParams2;
                            if (this.f72460a == null) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (this.f72460a == null) {
                        b(new a(this, i2, urlPageParams));
                        return;
                    }
                    return;
                case 2:
                    if (this.f72460a != null) {
                        b(new RunnableC2077b(this));
                        return;
                    }
                    return;
                case 4:
                    if (this.f72460a != null) {
                        b(new d(this, str));
                        return;
                    }
                    return;
                case 5:
                    if (this.f72460a != null) {
                        b(new c(this, str));
                        return;
                    }
                    return;
                case 6:
                    if (this.f72460a != null) {
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
            f fVar = this.f72460a;
            if (fVar != null) {
                return fVar.getToken();
            }
            RLog.error("YYPaySdkJsInterface", "getToken() mOnJsCallInterface null", new Object[0]);
            return "";
        }
        return (String) invokeV.objValue;
    }
}
