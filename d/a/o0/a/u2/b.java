package d.a.o0.a.u2;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g1.f;
import d.a.o0.a.k;
import d.a.o0.a.u.c.d;
import d.a.o0.a.u2.a;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d implements a.InterfaceC0950a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48380f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f48381d;

    /* renamed from: e  reason: collision with root package name */
    public String f48382e;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.j1.d.a f48383e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f48384f;

        public a(b bVar, d.a.o0.a.j1.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48384f = bVar;
            this.f48383e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.o0.a.c1.a.g().a(this.f48384f.f48381d, this.f48383e)) {
                    this.f48384f.u(this.f48383e);
                    return;
                }
                b bVar = this.f48384f;
                bVar.d(bVar.f48382e, new d.a.o0.a.u.h.b(2003, "upload fail"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(522027252, "Ld/a/o0/a/u2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(522027252, "Ld/a/o0/a/u2/b;");
                return;
            }
        }
        f48380f = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.u2.a.InterfaceC0950a
    public void c(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, str) == null) {
            if (jSONObject == null) {
                d(this.f48382e, new d.a.o0.a.u.h.b(2003, "upload fail"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                d(this.f48382e, new d.a.o0.a.u.h.b(2003, "upload fail"));
                return;
            }
            String optString = jSONObject.optString("errno");
            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
                d.a.o0.a.j1.d.a a2 = d.a.o0.a.j1.d.a.a(optJSONObject, str);
                if (TextUtils.isEmpty(a2.f46224e)) {
                    d(this.f48382e, new d.a.o0.a.u.h.b(2003, "upload fail"));
                    return;
                } else {
                    ExecutorUtilsExt.postOnElastic(new a(this, a2), "doBosUpload", 2);
                    return;
                }
            }
            d(this.f48382e, new d.a.o0.a.u.h.b(2003, "upload fail"));
        }
    }

    public final void u(d.a.o0.a.j1.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bosUrl", aVar.f46224e);
                d(this.f48382e, new d.a.o0.a.u.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (f48380f) {
                    e2.printStackTrace();
                }
                d(this.f48382e, new d.a.o0.a.u.h.b(2003, "upload fail"));
            }
        }
    }

    public final boolean v(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) ? file.length() > 52428800 : invokeL.booleanValue;
    }

    public d.a.o0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (f48380f) {
                Log.d("Api-UploadBosApi", "handle: " + str);
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-UploadBosApi", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) b2.second;
                String optString = jSONObject.optString("cb");
                this.f48382e = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.o0.a.u.h.b(202);
                }
                String optString2 = jSONObject.optString("filePath");
                if (TextUtils.isEmpty(optString2)) {
                    return new d.a.o0.a.u.h.b(202);
                }
                f V = f.V();
                String i2 = V.I().i(optString2);
                this.f48381d = i2;
                if (TextUtils.isEmpty(i2)) {
                    return new d.a.o0.a.u.h.b(2001, "file not found");
                }
                File file = new File(this.f48381d);
                if (file.exists() && file.isFile()) {
                    if (v(file)) {
                        return new d.a.o0.a.u.h.b(2002, "file over size");
                    }
                    if (!d.a.o0.a.a2.d.g().r().j().e(V.getActivity())) {
                        return new d.a.o0.a.u.h.b(10004, "user not logged in");
                    }
                    d.a.o0.a.c1.a.g().b(V.getActivity(), this.f48381d, this);
                    return new d.a.o0.a.u.h.b(0);
                }
                return new d.a.o0.a.u.h.b(2001, "file not found");
            }
            return bVar;
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
