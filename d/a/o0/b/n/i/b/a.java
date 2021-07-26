package d.a.o0.b.n.i.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.v2.n0;
import d.a.o0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49551a;

    /* renamed from: b  reason: collision with root package name */
    public C1037a f49552b;

    /* renamed from: c  reason: collision with root package name */
    public c f49553c;

    /* renamed from: d  reason: collision with root package name */
    public b f49554d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f49555e;

    /* renamed from: d.a.o0.b.n.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1037a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f49556a;

        /* renamed from: b  reason: collision with root package name */
        public String f49557b;

        /* renamed from: c  reason: collision with root package name */
        public int f49558c;

        /* renamed from: d  reason: collision with root package name */
        public int f49559d;

        /* renamed from: e  reason: collision with root package name */
        public String f49560e;

        /* renamed from: f  reason: collision with root package name */
        public String f49561f;

        /* renamed from: g  reason: collision with root package name */
        public int f49562g;

        /* renamed from: h  reason: collision with root package name */
        public int f49563h;

        /* renamed from: i  reason: collision with root package name */
        public String f49564i;

        public C1037a() {
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
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f49565a;

        /* renamed from: b  reason: collision with root package name */
        public int f49566b;

        public b() {
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
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f49567a;

        /* renamed from: b  reason: collision with root package name */
        public double f49568b;

        /* renamed from: c  reason: collision with root package name */
        public double f49569c;

        public c() {
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
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1037a c1037a = new C1037a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f49551a = TextUtils.isEmpty(V) ? "" : V;
        this.f49552b = c1037a;
        this.f49553c = cVar;
        this.f49554d = bVar;
        this.f49555e = jSONObject;
        String r = q0.r();
        c1037a.f49556a = "0".equals(r) ? "" : r;
        String a2 = a();
        c1037a.f49557b = "0".equals(a2) ? "" : a2;
        c1037a.f49558c = 2;
        c1037a.f49559d = d.a.o0.b.n.i.c.a.e(context) ? 3 : 2;
        String i4 = d.a.o0.a.d0.c.i();
        c1037a.f49560e = "NUL".equals(i4) ? "" : i4;
        String g2 = d.a.o0.a.d0.c.g();
        c1037a.f49561f = "NUL".equals(g2) ? "" : g2;
        c1037a.f49562g = n0.n(context);
        c1037a.f49563h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c1037a.f49564i = str;
        bVar.f49565a = d.a.o0.b.n.i.c.a.c();
        bVar.f49566b = d.a.o0.b.n.i.c.a.d(context);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String string = Settings.Secure.getString(AppRuntime.getAppContext().getContentResolver(), IAdRequestParam.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "0" : string;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                str = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            } catch (Exception unused) {
                str = null;
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject.put("app_id", this.f49551a);
                jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f49552b.f49556a);
                jSONObject2.put("androidid", this.f49552b.f49557b);
                jSONObject2.put("os_type", this.f49552b.f49558c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f49552b.f49559d);
                jSONObject2.put("device_vendor", this.f49552b.f49560e);
                jSONObject2.put("device_model", this.f49552b.f49561f);
                jSONObject2.put("screen_height", this.f49552b.f49562g);
                jSONObject2.put("screen_width", this.f49552b.f49563h);
                jSONObject2.put("mac", this.f49552b.f49564i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f49553c.f49567a);
                jSONObject3.put("latitude", this.f49553c.f49568b);
                jSONObject3.put("longitude", this.f49553c.f49569c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f49554d.f49565a);
                jSONObject4.put("operator", this.f49554d.f49566b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f49555e);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c().toString() : (String) invokeV.objValue;
    }
}
