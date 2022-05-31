package com.repackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.http.PostRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rb9 implements Reporter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final String b;

    /* loaded from: classes6.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rb9 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rb9 rb9Var, JSONObject jSONObject) {
            super(rb9Var, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb9Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((rb9) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rb9Var;
            lb9.j();
        }

        @Override // com.repackage.rb9.b
        public void c() {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lb9.e("key_rpt_suc_c", lb9.h() + 1);
                rb9 rb9Var = this.e;
                rb9Var.getClass();
                int a = lb9.a();
                int f = lb9.f();
                if (a > 0 || f > 0) {
                    int h = lb9.h();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fai", a);
                        jSONObject.put("suc", h);
                        jSONObject.put("mis", f);
                    } catch (JSONException unused) {
                    }
                    dVar = new d(rb9Var, HostAppInfo.buildReportJson("k_rpt", jSONObject, System.currentTimeMillis()), a, h, f);
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    dVar.d();
                }
            }
        }

        @Override // com.repackage.rb9.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                lb9.e("key_rpt_fai_c", lb9.a() + 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final JSONObject a;
        public final /* synthetic */ rb9 b;

        public b(rb9 rb9Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb9Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rb9Var;
            this.a = jSONObject;
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // com.repackage.rb9.c
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean d() {
            boolean z;
            Response perform;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                try {
                    perform = new PostRequest(this.b.b, new RequestParams(this.a)).perform();
                } catch (IOException e) {
                    LogPrinter.e(e);
                }
                if (perform != null) {
                    if (perform.getResponseCode() == 200) {
                        z = true;
                        if (z) {
                            b();
                        } else {
                            c();
                        }
                        return z;
                    }
                }
                z = false;
                if (z) {
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    return "Event{key=" + this.a.getString("key") + ", content=" + this.a.getString("content") + '}';
                } catch (JSONException unused) {
                    return "Unknown Event";
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        boolean a();
    }

    /* loaded from: classes7.dex */
    public class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int c;
        public final int d;
        public final int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(rb9 rb9Var, JSONObject jSONObject, int i, int i2, int i3) {
            super(rb9Var, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb9Var, jSONObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((rb9) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i;
            this.d = i2;
            this.e = i3;
        }

        @Override // com.repackage.rb9.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lb9.d(this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int c;
        public final /* synthetic */ rb9 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(rb9 rb9Var, JSONObject jSONObject) {
            super(rb9Var, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb9Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((rb9) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rb9Var;
            this.c = 0;
        }

        @Override // com.repackage.rb9.b
        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.c;
                int i2 = i + 1;
                this.c = i2;
                if (i < 3) {
                    try {
                        this.a.put(HostAppInfo.RETRY_I, i2);
                    } catch (JSONException unused) {
                    }
                    rb9 rb9Var = this.d;
                    rb9Var.a.sendMessageDelayed(rb9Var.a.obtainMessage(102, this), 2000L);
                    return;
                }
                LogPrinter.e("Give up report event:" + this, new Object[0]);
                e();
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NonNull Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 101) {
                    if (i != 102) {
                        return;
                    }
                    ((c) message.obj).a();
                    return;
                }
                int i2 = message.arg1;
                int h = lb9.h();
                int a = lb9.a();
                int i3 = (i2 - h) - a;
                LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i2), Integer.valueOf(h), Integer.valueOf(a), Integer.valueOf(i3));
                if (i3 > 0) {
                    lb9.e("key_rpt_mis_c", i3);
                }
            }
        }
    }

    public rb9(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("rep");
        handlerThread.start();
        f fVar = new f(handlerThread.getLooper());
        this.a = fVar;
        this.b = str;
        fVar.obtainMessage(101, lb9.g(), 0).sendToTarget();
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            logEvent(str, jSONObject);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            logEvent(str, new JSONObject(map));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            JSONObject buildReportJson = HostAppInfo.buildReportJson(str, jSONObject, System.currentTimeMillis());
            this.a.sendMessageDelayed(this.a.obtainMessage(102, LaunchStatsUtils.AD.equals(str) ? new a(this, buildReportJson) : new e(this, buildReportJson)), 0L);
        }
    }
}
