package d.a.q0.b.n.i.b;

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
import d.a.q0.a.a2.e;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f52349a;

    /* renamed from: b  reason: collision with root package name */
    public C1079a f52350b;

    /* renamed from: c  reason: collision with root package name */
    public c f52351c;

    /* renamed from: d  reason: collision with root package name */
    public b f52352d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f52353e;

    /* renamed from: d.a.q0.b.n.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1079a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f52354a;

        /* renamed from: b  reason: collision with root package name */
        public String f52355b;

        /* renamed from: c  reason: collision with root package name */
        public int f52356c;

        /* renamed from: d  reason: collision with root package name */
        public int f52357d;

        /* renamed from: e  reason: collision with root package name */
        public String f52358e;

        /* renamed from: f  reason: collision with root package name */
        public String f52359f;

        /* renamed from: g  reason: collision with root package name */
        public int f52360g;

        /* renamed from: h  reason: collision with root package name */
        public int f52361h;

        /* renamed from: i  reason: collision with root package name */
        public String f52362i;

        public C1079a() {
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

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f52363a;

        /* renamed from: b  reason: collision with root package name */
        public int f52364b;

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

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f52365a;

        /* renamed from: b  reason: collision with root package name */
        public double f52366b;

        /* renamed from: c  reason: collision with root package name */
        public double f52367c;

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
        C1079a c1079a = new C1079a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f52349a = TextUtils.isEmpty(V) ? "" : V;
        this.f52350b = c1079a;
        this.f52351c = cVar;
        this.f52352d = bVar;
        this.f52353e = jSONObject;
        String r = q0.r();
        c1079a.f52354a = "0".equals(r) ? "" : r;
        String a2 = a();
        c1079a.f52355b = "0".equals(a2) ? "" : a2;
        c1079a.f52356c = 2;
        c1079a.f52357d = d.a.q0.b.n.i.c.a.e(context) ? 3 : 2;
        String i4 = d.a.q0.a.d0.c.i();
        c1079a.f52358e = "NUL".equals(i4) ? "" : i4;
        String g2 = d.a.q0.a.d0.c.g();
        c1079a.f52359f = "NUL".equals(g2) ? "" : g2;
        c1079a.f52360g = n0.n(context);
        c1079a.f52361h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c1079a.f52362i = str;
        bVar.f52363a = d.a.q0.b.n.i.c.a.c();
        bVar.f52364b = d.a.q0.b.n.i.c.a.d(context);
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
                jSONObject.put("app_id", this.f52349a);
                jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f52350b.f52354a);
                jSONObject2.put("androidid", this.f52350b.f52355b);
                jSONObject2.put("os_type", this.f52350b.f52356c);
                jSONObject2.put(HttpConstants.DEVICE_TYPE, this.f52350b.f52357d);
                jSONObject2.put("device_vendor", this.f52350b.f52358e);
                jSONObject2.put("device_model", this.f52350b.f52359f);
                jSONObject2.put("screen_height", this.f52350b.f52360g);
                jSONObject2.put("screen_width", this.f52350b.f52361h);
                jSONObject2.put("mac", this.f52350b.f52362i);
                jSONObject.put("device", jSONObject2);
                jSONObject3.put("coord_type", this.f52351c.f52365a);
                jSONObject3.put("latitude", this.f52351c.f52366b);
                jSONObject3.put("longitude", this.f52351c.f52367c);
                jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
                jSONObject4.put("network", this.f52352d.f52363a);
                jSONObject4.put("operator", this.f52352d.f52364b);
                jSONObject.put("network", jSONObject4);
                jSONObject.put("data", this.f52353e);
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
