package d.a.n0.a.u.e.p;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import d.a.n0.a.v2.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.u.e.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0935a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47814e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47815f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f47816g;

        public RunnableC0935a(a aVar, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47816g = aVar;
            this.f47814e = jSONArray;
            this.f47815f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47816g.d(this.f47815f, this.f47816g.x(this.f47814e));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47817e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47818f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f47819g;

        public b(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47819g = aVar;
            this.f47817e = str;
            this.f47818f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47819g.d(this.f47818f, this.f47819g.v(this.f47817e));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.n0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            q.e().execute(new b(this, str, str2));
        }
    }

    public d.a.n0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-CheckAppInstall", "start check app install");
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-CheckAppInstall", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-CheckAppInstall", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("name");
            JSONArray optJSONArray = jSONObject.optJSONArray("name");
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString) && optJSONArray == null) {
                d.a.n0.a.e0.d.b("Api-CheckAppInstall", "parameter error");
                return new d.a.n0.a.u.h.b(201, "parameter error");
            }
            boolean z = optJSONArray == null;
            if (TextUtils.isEmpty(optString2)) {
                if (z) {
                    return v(optString);
                }
                return x(optJSONArray);
            }
            if (z) {
                t(optString, optString2);
            } else {
                w(optJSONArray, optString2);
            }
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final d.a.n0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                packageInfo = i().getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                d.a.n0.a.e0.d.l("Api-CheckAppInstall", str + " cannot be found");
                packageInfo = null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (packageInfo != null) {
                    jSONObject.put("hasApp", true);
                    jSONObject.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                    jSONObject.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
                } else {
                    jSONObject.put("hasApp", false);
                }
                return new d.a.n0.a.u.h.b(0, "success", jSONObject);
            } catch (JSONException e2) {
                d.a.n0.a.e0.d.c("Api-CheckAppInstall", "internal error: " + e2.getMessage(), e2);
                return new d.a.n0.a.u.h.b(1001, "internal error: " + e2.getMessage());
            }
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final void w(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONArray, str) == null) {
            q.e().execute(new RunnableC0935a(this, jSONArray, str));
        }
    }

    public final d.a.n0.a.u.h.b x(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONArray)) == null) {
            JSONObject jSONObject = new JSONObject();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    String string = jSONArray.getString(i2);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(string, y(string));
                    }
                } catch (JSONException e2) {
                    d.a.n0.a.e0.d.c("Api-CheckAppInstall", "internal error: " + e2.getMessage(), e2);
                }
            }
            return new d.a.n0.a.u.h.b(0, "success", jSONObject);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final boolean y(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                packageInfo = i().getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                d.a.n0.a.e0.d.l("Api-CheckAppInstall", str + " cannot be found");
                packageInfo = null;
            }
            return packageInfo != null;
        }
        return invokeL.booleanValue;
    }
}
