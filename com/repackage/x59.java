package com.repackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.q59;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class x59 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class b extends g69 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.repackage.g69
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x59.k(this.a);
                if (d59.h().i() != null && !d59.h().i().equals("")) {
                    m69.a("BaiDuAB sdk  init success");
                } else {
                    String h = x59.h(d59.h().getContext());
                    if (h == null || h.equals("")) {
                        m69.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY in Manifest or network is available");
                        return;
                    }
                }
                x59.d();
                x59.c();
                f69.b(new b69(), w59.e(), w59.c());
                n69.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends g69 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* loaded from: classes7.dex */
        public class a implements q59.a<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.repackage.q59.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                h69.a("status_updated");
            }

            @Override // com.repackage.q59.a
            public final void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }
        }

        public e(String str) {
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
            this.a = str;
        }

        @Override // com.repackage.g69
        public final void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || h69.b("status_updated")) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exids", this.a);
            q59.c(q59.d("http://absample.baidu.com/appabapp/appapi/updateStatus", hashMap), new a(this));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755220459, "Lcom/repackage/x59;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755220459, "Lcom/repackage/x59;");
        }
    }

    public static /* synthetic */ void a(String str) {
        f69.a(new e(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(c59 c59Var) {
        byte b2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, c59Var) == null) {
            int g = c59Var.g();
            if (g < 1000) {
                String e2 = z59.e(c59Var.a());
                int length = e2.length();
                int i2 = length << 1;
                byte[] bArr = new byte[i2];
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = e2.charAt(i4);
                    int i5 = i3 + 1;
                    bArr[i3] = (byte) (charAt & 255);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) (charAt >> '\b');
                }
                int i6 = (-1756908916) ^ i2;
                int i7 = i2 / 4;
                for (int i8 = 0; i8 < i7; i8++) {
                    int i9 = i8 * 4;
                    int i10 = ((bArr[i9 + 0] & 255) + ((bArr[i9 + 1] & 255) << 8) + ((bArr[i9 + 2] & 255) << 16) + ((bArr[i9 + 3] & 255) << 24)) * 1540483477;
                    i6 = (i6 * 1540483477) ^ (((i10 >>> 24) ^ i10) * 1540483477);
                }
                int i11 = i2 % 4;
                if (i11 == 3) {
                    int i12 = i2 & (-4);
                    i6 = (i6 ^ ((bArr[i12 + 2] & 255) << 16)) ^ ((bArr[i12 + 1] & 255) << 8);
                    b2 = bArr[i12];
                } else if (i11 == 2) {
                    int i13 = i2 & (-4);
                    i6 ^= (bArr[i13 + 1] & 255) << 8;
                    b2 = bArr[i13];
                } else {
                    if (i11 == 1) {
                        b2 = bArr[i2 & (-4)];
                    }
                    i = (i6 ^ (i6 >>> 13)) * 1540483477;
                    if (Math.abs((i ^ (i >>> 15)) % 1000) >= g) {
                        b59.f(false);
                        return;
                    }
                }
                i6 = (i6 ^ (b2 & 255)) * 1540483477;
                i = (i6 ^ (i6 >>> 13)) * 1540483477;
                if (Math.abs((i ^ (i >>> 15)) % 1000) >= g) {
                }
            }
            d59.h().a(c59Var.a());
            b59.f(true);
            m69.g(c59Var.b());
            e69.b(com.baidu.ubs.analytics.d.a.c() + "-进行一次 初始化   " + new Date().toLocaleString() + GlideException.IndentedAppendable.INDENT + j(c59Var.a()));
            w59.b(c59Var.c());
            w59.f(c59Var.d());
            w59.g(c59Var.f());
            w59.h(c59Var.e());
            s59.a(c59Var.a());
            f69.a(new b(c59Var.a()));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (TextUtils.isEmpty(d59.h().j())) {
                d();
            }
            if (TextUtils.isEmpty(d59.h().j())) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("package", d59.h().getContext().getPackageName());
            hashMap.put("cuid", d59.h().j());
            q59.c(q59.d("http://absample.baidu.com/appabapp/appapi/getgroup", hashMap), new a());
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            String e2 = h69.e("cuid", "");
            if (!TextUtils.isEmpty(e2)) {
                e69.b("本地 取得  cuid~~");
                d59.h().e(e2);
                return;
            }
            e69.b("网络请求  cuid~~");
            HashMap hashMap = new HashMap();
            hashMap.put("imei", z59.g(d59.h().getContext()));
            hashMap.put("mac", z59.h(d59.h().getContext()));
            q59.c(q59.d("http://absample.baidu.com/appabapp/appapi/getcuid", hashMap), new d());
        }
    }

    public static /* synthetic */ int f() {
        int i = a;
        a = i + 1;
        return i;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String i = i(context);
            HashMap hashMap = new HashMap();
            hashMap.put("key", i);
            hashMap.put("package", context.getPackageName());
            q59.c(q59.d("http://absample.baidu.com/appabapp/appapi/gettoken", hashMap), new c(currentTimeMillis, context));
            return d59.h().i();
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BAIDUAB_APPKEY");
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager.getRunningAppProcesses() == null) {
                return "unknow";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "unknow";
        }
        return (String) invokeL.objValue;
    }

    public static /* synthetic */ String k(Context context) {
        String e2 = h69.e("lastkey", "");
        long c2 = h69.c("token_update_time");
        if (e2.equals(i(context)) && c2 + 86400000 >= System.currentTimeMillis()) {
            String e3 = h69.e("token", "");
            if (!e3.equals("")) {
                d59.h().b(e3);
                return e3;
            }
        }
        return h(context);
    }

    /* loaded from: classes7.dex */
    public static class d implements q59.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.q59.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("cuid");
            if (TextUtils.isEmpty(optString)) {
                d59.h().e("");
                return;
            }
            d59.h().e(optString);
            h69.f("cuid", optString);
        }

        @Override // com.repackage.q59.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && str.equals("1")) {
                d59.h().e("");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements q59.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ Context b;

        public c(long j, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.q59.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("token");
            if (optString == null || optString.isEmpty()) {
                return;
            }
            d59.h().b(optString);
            h69.f("token", optString);
            h69.g("token_update_time", this.a);
            h69.f("lastkey", x59.i(this.b));
        }

        @Override // com.repackage.q59.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                m69.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY  in Manifest   or network is available");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements q59.a<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.q59.a
        public final /* synthetic */ void a(JSONArray jSONArray) {
            JSONArray jSONArray2 = jSONArray;
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                com.baidu.ubs.analytics.a.g gVar = new com.baidu.ubs.analytics.a.g();
                gVar.setGroup(optJSONObject.optString("group"));
                gVar.setId(optJSONObject.optString("id"));
                gVar.y(optJSONObject.optString("sid"));
                if (i > 0) {
                    stringBuffer.append("_");
                }
                stringBuffer.append(gVar.getId());
                arrayList.add(gVar);
            }
            d59.h().c(arrayList);
            x59.a(stringBuffer.toString());
        }

        @Override // com.repackage.q59.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                while (x59.a < 2) {
                    synchronized (this) {
                        x59.f();
                    }
                    x59.c();
                }
            }
        }
    }
}
