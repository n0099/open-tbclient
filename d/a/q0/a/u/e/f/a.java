package d.a.q0.a.u.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.u.c.d;
import d.a.q0.a.u.h.b;
import d.a.q0.a.v2.q;
import d.a.q0.a.v2.u;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.u.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0958a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f50836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50838g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f50839h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f50840i;

        public RunnableC0958a(a aVar, File file, int i2, String str, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, file, Integer.valueOf(i2), str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50840i = aVar;
            this.f50836e = file;
            this.f50837f = i2;
            this.f50838g = str;
            this.f50839h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = u.k(this.f50836e.getName());
                if (!u.b(this.f50836e, k, this.f50837f)) {
                    d.a.q0.a.e0.d.b("Api-Image", "compress image failed");
                    this.f50840i.d(this.f50838g, new b(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", d.a.q0.a.k2.b.J(k.getAbsolutePath(), this.f50839h.f46683f));
                } catch (JSONException e2) {
                    d.a.q0.a.e0.d.b("Api-Image", e2.toString());
                }
                this.f50840i.d(this.f50838g, new b(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.q0.a.u.c.b bVar) {
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
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Pair<b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Image", str);
            b bVar = (b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.q0.a.e0.d.b("Api-Image", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("Api-Image", "empty cb");
                return new b(202, "empty cb");
            }
            return s(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (b) invokeL.objValue;
    }

    public final b s(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2)) == null) {
            e i3 = e.i();
            if (i3 == null) {
                return new b(1001, "swan app is null");
            }
            int i4 = (i2 < 0 || i2 > 100) ? 80 : i2;
            if (TextUtils.isEmpty(str2)) {
                d.a.q0.a.e0.d.b("Api-Image", "src is null");
                return new b(202, "src is null");
            }
            PathType s = d.a.q0.a.k2.b.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = d.a.q0.a.k2.b.M(str2, i3.f46683f);
            } else if (s == PathType.RELATIVE) {
                str3 = d.a.q0.a.k2.b.L(str2, i3, i3.Z());
            }
            if (TextUtils.isEmpty(str3)) {
                d.a.q0.a.e0.d.b("Api-Image", "file path error");
                return new b(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                d.a.q0.a.e0.d.b("Api-Image", "file does not exist");
                return new b(2001, "file does not exist");
            }
            q.j(new RunnableC0958a(this, file, i4, str, i3), "compressImage");
            return new b(0);
        }
        return (b) invokeLLI.objValue;
    }
}
