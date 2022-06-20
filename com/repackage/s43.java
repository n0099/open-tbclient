package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public final String b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public String g;
    public List<String> h;
    public final List<String> i;
    public int j;
    public String k;
    public String l;
    public String m;
    public a n;
    public JSONObject o;
    public String p;
    public String q;
    public String r;
    public List<s43> s;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public JSONArray f;

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
    }

    public s43(String str) {
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
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = -1;
        this.k = "";
        this.l = "";
        this.m = "";
        this.b = str;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (hd3.f("3.320.0")) {
                return str;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1456866260:
                    if (str.equals("scope.phoneContact")) {
                        c = 11;
                        break;
                    }
                    break;
                case -653473286:
                    if (str.equals("scope.userLocation")) {
                        c = 2;
                        break;
                    }
                    break;
                case -21617665:
                    if (str.equals("scope.camera")) {
                        c = 6;
                        break;
                    }
                    break;
                case 277279100:
                    if (str.equals("scope.mobile")) {
                        c = 1;
                        break;
                    }
                    break;
                case 411225387:
                    if (str.equals("scope.record")) {
                        c = 7;
                        break;
                    }
                    break;
                case 583039347:
                    if (str.equals("scope.userInfo")) {
                        c = 0;
                        break;
                    }
                    break;
                case 671518104:
                    if (str.equals("scope.calendar")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 986629481:
                    if (str.equals("scope.writePhotosAlbum")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1303164176:
                    if (str.equals("scope.faceVerify")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1326852849:
                    if (str.equals("scope.realNameInfo")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1555675269:
                    if (str.equals("scope.invoiceTitle")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1927763546:
                    if (str.equals("scope.address")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return "snsapi_userinfo";
                case 1:
                    return "mobile";
                case 2:
                    return "mapp_location";
                case 3:
                    return "mapp_images";
                case 4:
                    return "mapp_choose_address";
                case 5:
                    return "mapp_choose_invoice";
                case 6:
                    return PermissionProxy.SCOPE_ID_CAMERA;
                case 7:
                    return PermissionProxy.SCOPE_ID_RECORD;
                case '\b':
                    return "mapp_i_face_verify";
                case '\t':
                    return "ppcert";
                case '\n':
                    return "scope_calendar";
                case 11:
                    return "mapp_i_read_contacts";
                default:
                    return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (hd3.f("3.320.0")) {
                return str;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1994404663:
                    if (str.equals("scope_calendar")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1785599184:
                    if (str.equals(PermissionProxy.SCOPE_ID_CAMERA)) {
                        c = 6;
                        break;
                    }
                    break;
                case -1603097981:
                    if (str.equals("mapp_images")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1352756132:
                    if (str.equals(PermissionProxy.SCOPE_ID_RECORD)) {
                        c = 7;
                        break;
                    }
                    break;
                case -1074510320:
                    if (str.equals("mapp_choose_invoice")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1068855134:
                    if (str.equals("mobile")) {
                        c = 1;
                        break;
                    }
                    break;
                case -982018012:
                    if (str.equals("ppcert")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -977063690:
                    if (str.equals("snsapi_userinfo")) {
                        c = 0;
                        break;
                    }
                    break;
                case -218238720:
                    if (str.equals("mapp_location")) {
                        c = 2;
                        break;
                    }
                    break;
                case 112565975:
                    if (str.equals("mapp_choose_address")) {
                        c = 4;
                        break;
                    }
                    break;
                case 862108635:
                    if (str.equals("mapp_i_read_contacts")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1746078554:
                    if (str.equals("mapp_i_face_verify")) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return "scope.userInfo";
                case 1:
                    return "scope.mobile";
                case 2:
                    return "scope.userLocation";
                case 3:
                    return "scope.writePhotosAlbum";
                case 4:
                    return "scope.address";
                case 5:
                    return "scope.invoiceTitle";
                case 6:
                    return "scope.camera";
                case 7:
                    return "scope.record";
                case '\b':
                    return "scope.faceVerify";
                case '\t':
                    return "scope.realNameInfo";
                case '\n':
                    return "scope.calendar";
                case 11:
                    return "scope.phoneContact";
                default:
                    return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static s43 f(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, jSONObject)) == null) {
            s43 s43Var = new s43(str);
            s43Var.a = jSONObject;
            s43Var.c = jSONObject.optBoolean("permit", false);
            s43Var.d = jSONObject.optBoolean("forbidden", true);
            s43Var.e = jSONObject.optString("grade");
            s43Var.k = jSONObject.optString("type", "");
            s43Var.f = jSONObject.optString("name", "");
            s43Var.g = jSONObject.optString("short_name", "");
            jSONObject.optString("description", "");
            s43Var.j = jSONObject.optInt("tip_status", -1);
            s43Var.l = jSONObject.optString("explain", "");
            s43Var.m = jSONObject.optString("sub_explain", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("ext");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    s43Var.i.add(optJSONArray.optString(i));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("rule");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    s43Var.h.add(optJSONArray2.optString(i2));
                }
            }
            s43Var.o = jSONObject.optJSONObject(ImageViewerConfig.FROM_OTHER);
            s43Var.p = jSONObject.optString("plugin_app_name");
            s43Var.q = jSONObject.optString("plugin_icon_url");
            if (!jSONObject.has("forbidden")) {
                sw1.k("SwanAppUpdateManager", "scope:" + str + WebGLImageLoader.DATA_URL + jSONObject);
            }
            return s43Var;
        }
        return (s43) invokeLL.objValue;
    }

    public static s43 g(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("id", "");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            return f(optString, jSONObject);
        }
        return (s43) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j > 0 : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j != 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "1".equals(this.k) : invokeV.booleanValue;
    }

    public void h() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jSONObject = this.o) == null || jSONObject.keys() == null || !this.o.keys().hasNext()) {
            return;
        }
        a aVar = new a();
        this.n = aVar;
        aVar.a = this.o.optString("detail_text");
        this.n.c = this.o.optString("detail_url");
        this.n.b = this.o.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
        this.n.d = this.o.optString("keyword");
        this.n.e = this.o.optString("key_color");
        JSONObject optJSONObject = this.o.optJSONObject("developer_agreements");
        if (optJSONObject != null) {
            this.n.f = optJSONObject.optJSONArray("details");
        }
    }

    public void i(List<s43> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.s = list;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.b, Integer.valueOf(this.j)) : (String) invokeV.objValue;
    }
}
