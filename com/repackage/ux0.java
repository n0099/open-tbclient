package com.repackage;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.nadcore.requester.RequestParameters;
import com.baidu.sofire.d.D;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.bumptech.glide.disklrucache.StrictLineReader;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ux0 implements wx0 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] c;
    public static final Map<String, String> d;
    public static final JSONArray e;
    public static final oh0 f;
    public static String g;
    public transient /* synthetic */ FieldHolder $fh;
    public final cy0 b;

    /* loaded from: classes7.dex */
    public class a extends no0<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RequestParameters a;
        public final /* synthetic */ NadRequester.b b;

        public a(ux0 ux0Var, RequestParameters requestParameters, NadRequester.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux0Var, requestParameters, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = requestParameters;
            this.b = bVar;
        }

        @Override // com.repackage.lo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.b.a(new NadRequester.Error());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: e */
        public void b(Headers headers, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, bVar, i) == null) {
                if (bVar != null) {
                    this.b.b(Arrays.asList(bVar.a));
                } else {
                    this.b.a(new NadRequester.Error());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: f */
        public b d(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                AdBaseModel[] c = in0.c(str, new String[]{this.a.a});
                ArrayList arrayList = new ArrayList();
                for (AdBaseModel adBaseModel : c) {
                    if (this.a.l || adBaseModel.f.a != AdBaseModel.STYLE.HIDDEN) {
                        arrayList.add(adBaseModel);
                        adBaseModel.a(this.a.e);
                    }
                }
                b bVar = new b(null);
                bVar.a = (AdBaseModel[]) arrayList.toArray(new AdBaseModel[0]);
                return bVar;
            }
            return (b) invokeLLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdBaseModel[] a;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755245724, "Lcom/repackage/ux0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755245724, "Lcom/repackage/ux0;");
                return;
            }
        }
        c = new byte[]{48, -127, -97, 48, StrictLineReader.CR, 6, 9, 42, -122, 72, -122, -9, StrictLineReader.CR, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -69, 118, 15, 43, -102, -34, -94, -8, -78, 1, 17, -80, 84, 56, 79, 40, -89, 68, 50, 105, -35, 111, -70, 68, -68, -64, 62, 111, -66, -108, 77, 21, 106, 69, -34, 94, -1, 18, -100, -75, 7, 48, -59, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 50, -58, -124, 23, -97, -14, 100, 67, 115, -70, 4, 2, Cea608Decoder.CTRL_END_OF_CAPTION, -36, Constants.GZIP_CAST_TYPE, 80, 6, -88, 116, -38, -121, -4, -61, -13, -32, 106, 7, 85, -39, 111, 53, 0, -35, Base64.INTERNAL_PADDING, 33, 106, -125, -59, 100, -42, -32, 15, -108, 33, -14, 67, 124, 57, -83, -91, -86, -67, -57, 19, 90, -113, -41, 69, -25, 70, 70, 111, -41, -47, 76, -85, 118, -52, 110, -56, -28, 9, 75, 2, 43, -35, 15, 58, 31, 126, 8, 27, -82, -107, 2, 3, 1, 0, 1};
        d = new HashMap();
        e = new JSONArray();
        f = hh0.a();
        g = null;
        d("is_https", "1");
        d(SearchJsBridge.COOKIE_MOD, f.j());
        d("ua", f.i());
        d("fmt", "json");
        d("apna", f.packageName());
        d("ver", f.q());
        d(SearchJsBridge.COOKIE_OV, f.c());
        d("ot", "2");
        d(Config.EXCEPTION_CRASH_TYPE, "2");
        d("cuid", f.b());
        d("uid", f.m());
        d(TiebaStatic.Params.BDID, f.g());
        d("encrypted_imei", g());
        d(HttpRequest.ANDROID_ID, f.a());
        e.put(f(AdExtParam.KEY_NAD_CORE_VERSION, "5.5.0.11"));
        e.put(f("os_br", Build.BRAND));
        e.put(f("os_mafa", Build.MANUFACTURER));
        e.put(f("mac", f.t()));
        e.put(f("oaid_v", f.h()));
        try {
            e.put(f("encoded_ua_new", URLEncoder.encode(hh0.e(), IMAudioTransRequest.CHARSET)));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public ux0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = fy0.a().b("nad.refresh_count.sp");
    }

    public static void c(@NonNull to0 to0Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, to0Var, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        to0Var.a(str, str2);
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        d.put(str, str2);
    }

    public static JSONObject f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("k", str);
                jSONObject.put("v", str2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = g;
            if (str != null) {
                return str;
            }
            try {
                String p = f.p();
                if (TextUtils.isEmpty(p)) {
                    g = "";
                } else {
                    byte[] a2 = z01.a(p.getBytes(), z01.b(c));
                    if (a2 != null) {
                        g = new String(android.util.Base64.encode(a2, 2));
                    } else {
                        g = "";
                    }
                }
            } catch (Throwable unused) {
                g = "";
            }
            return g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.wx0
    public void a(@NonNull RequestParameters requestParameters, @NonNull NadRequester.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, requestParameters, bVar) == null) {
            co0 b2 = co0.b();
            uo0 uo0Var = new uo0();
            JSONArray jSONArray = new JSONArray();
            to0 e2 = to0.e(d);
            for (int i = 0; i < e.length(); i++) {
                jSONArray.put(e.opt(i));
            }
            jSONArray.put(f(AdExtParam.KEY_IADEX, mf0.e()));
            NadRequester.Error error = TextUtils.isEmpty(requestParameters.a) ? new NadRequester.Error("missing placeId") : null;
            if (requestParameters.j == RequestParameters.SlotType.REWARD) {
                if (TextUtils.isEmpty(requestParameters.h)) {
                    error = new NadRequester.Error("missing tu");
                }
                if (TextUtils.isEmpty(requestParameters.i)) {
                    error = new NadRequester.Error("missing app_sid");
                }
                uo0Var.a("X-BD-SDK-SOURCE", "reward");
                c(e2, "appsid", requestParameters.i);
                jSONArray.put(f("tu", requestParameters.h));
                jSONArray.put(f("app_sid", requestParameters.i));
            }
            if (error != null) {
                bVar.a(error);
                return;
            }
            uo0Var.k("https://afd.baidu.com/afd/entry");
            c(e2, "pid", requestParameters.a);
            c(e2, D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, String.valueOf(requestParameters.b));
            c(e2, "ft", requestParameters.f.value);
            c(e2, "tabid", requestParameters.d);
            c(e2, "tabn", requestParameters.c);
            e(e2, requestParameters.a, requestParameters.c);
            c(e2, "nt", String.valueOf(new jo0().c()));
            c(e2, "qe", requestParameters.g);
            c(e2, "ext", jSONArray.toString());
            c(e2, "eid", f.d());
            b(e2, requestParameters.k);
            uo0Var.a("User-Agent", hh0.e());
            uo0Var.f(e2);
            b2.a().a(uo0Var, new a(this, requestParameters, bVar));
        }
    }

    public final void b(@NonNull to0 to0Var, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, to0Var, map) == null) || xx0.h(map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                c(to0Var, entry.getKey(), entry.getValue());
            }
        }
    }

    public final void e(@NonNull to0 to0Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, to0Var, str, str2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(str2 == null ? "" : str2);
            sb.append("_fc");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("_");
            if (str2 == null) {
                str2 = "";
            }
            sb3.append(str2);
            sb3.append("_ts");
            String sb4 = sb3.toString();
            long currentTimeMillis = System.currentTimeMillis();
            int i = p01.d(this.b.getLong(sb4, 0L), currentTimeMillis) ? this.b.getInt(sb2, 1) : 1;
            this.b.h(sb4, currentTimeMillis);
            this.b.g(sb2, i + 1);
            c(to0Var, "fc", String.valueOf(i));
        }
    }
}
