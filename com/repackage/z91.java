package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.repackage.zz0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public String C;
    public int D;
    public int E;
    public int F;
    public int G;
    public String H;
    public int I;
    public int J;
    public JSONObject K;
    public JSONObject L;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String[] q;
    public String[] r;
    public long s;
    public long t;
    public int u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public String z;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, z91 z91Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, z91Var) == null) {
                try {
                    z91Var.a = jSONObject.optInt("advisible");
                    z91Var.b = jSONObject.optString("id");
                    z91Var.c = jSONObject.optString("ukey");
                    z91Var.d = jSONObject.optString("extra");
                    z91Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    z91Var.f = jSONObject.optInt("type");
                    z91Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    z91Var.o = jSONObject.optString("action");
                    z91Var.p = jSONObject.optString("action_cmd");
                    z91Var.l = jSONObject.optString("flag_name");
                    z91Var.m = jSONObject.optInt("logo_type");
                    z91Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (z91Var.i()) {
                        b.a(jSONObject, z91Var);
                    } else {
                        c.a(jSONObject, z91Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        z91Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            z91Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        z91Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            z91Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    z91Var.s = jSONObject.optLong("start");
                    z91Var.t = jSONObject.optLong("end");
                    z91Var.u = jSONObject.optInt("expose_interval");
                    z91Var.v = jSONObject.optInt("expose_times");
                    z91Var.w = jSONObject.optInt("preload_type");
                    z91Var.z = jSONObject.optString("click_float_lottie_url");
                    z91Var.A = jSONObject.optInt("float_bar_show", 1);
                    z91Var.B = jSONObject.optInt("click_float_opt", 1);
                    z91Var.C = jSONObject.optString("style_desc");
                    z91Var.x = jSONObject.optInt("curRate");
                    z91Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    z91Var.F = jSONObject.optInt("ad_sort");
                    z91Var.G = jSONObject.optInt("gesture_lottie_type");
                    z91Var.H = jSONObject.optString("gesture_lottie_url");
                    z91Var.I = jSONObject.optInt("gesture_lottie_sensitivity");
                    int optInt = jSONObject.optInt("is_topview", 0);
                    z91Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        z91Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        z91Var.L = jSONObject.optJSONObject("animation_data");
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, z91 z91Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, z91Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    z91Var.a = optJSONObject.optInt("advisible", 1);
                    z91Var.b = optJSONObject.optString("id");
                    z91Var.c = optJSONObject.optString("ukey");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("extra");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= optJSONArray2.length()) {
                                break;
                            }
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i);
                            if (optJSONObject3 != null) {
                                String optString = optJSONObject3.optString("k");
                                String optString2 = optJSONObject3.optString("v");
                                if (!TextUtils.isEmpty(optString2) && TextUtils.equals("extraParam", optString)) {
                                    z91Var.d = optString2;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("material");
                    if (optJSONArray3 == null || (optJSONObject2 = optJSONArray3.optJSONObject(0)) == null) {
                        return;
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("info");
                    if (optJSONArray4 == null) {
                        String optString3 = optJSONObject2.optString("info");
                        if (!TextUtils.isEmpty(optString3)) {
                            optJSONArray4 = new JSONArray(optString3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        JSONObject optJSONObject4 = optJSONArray4.optJSONObject(0);
                        z91Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            z91Var.f = optJSONObject5.optInt("type");
                            z91Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                            z91Var.o = optJSONObject5.optString("action");
                            z91Var.p = optJSONObject5.optString("action_cmd");
                            z91Var.l = optJSONObject5.optString("flag_name");
                            z91Var.m = optJSONObject5.optInt("logo_type");
                            z91Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            z91Var.z = optJSONObject5.optString("click_float_lottie_url");
                            z91Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                            z91Var.F = optJSONObject5.optInt("ad_sort");
                            z91Var.G = optJSONObject5.optInt("gesture_lottie_type");
                            z91Var.H = optJSONObject5.optString("gesture_lottie_url");
                            z91Var.I = optJSONObject5.optInt("gesture_lottie_sensitivity");
                            z91Var.J = optJSONObject5.optInt("is_topview", 0);
                            if (z91Var.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), z91Var);
                            } else {
                                c.a(optJSONObject5, z91Var);
                            }
                            z91Var.L = optJSONObject5.optJSONObject("animation_data");
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            z91Var.q = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                z91Var.q[i2] = optJSONArray6.optString(i2);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            z91Var.r = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                z91Var.r[i3] = optJSONArray7.optString(i3);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            z91Var.s = jSONObject2.optLong("start");
                            z91Var.t = jSONObject2.optLong("end");
                            z91Var.u = optJSONObject6.optInt("expose_interval");
                            z91Var.v = optJSONObject6.optInt("expose_times");
                            z91Var.w = optJSONObject6.optInt("preload_type");
                            z91Var.A = optJSONObject6.optInt("float_bar_show", 1);
                            z91Var.B = optJSONObject6.optInt("click_float_opt", 1);
                            z91Var.C = optJSONObject6.optString("style_desc");
                        }
                        JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                        if (z91Var.J != 1 || optJSONObject7 == null) {
                            return;
                        }
                        JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                        if (optJSONObject8 == null) {
                            z91Var.J = 0;
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        hx0.f(jSONObject3, "click_float_lottie_url", z91Var.z);
                        hx0.d(jSONObject3, "click_float_opt", z91Var.B);
                        hx0.d(jSONObject3, "float_bar_show", z91Var.A);
                        hx0.g(jSONObject3, "switch", true);
                        hx0.f(jSONObject3, "style_desc", z91Var.C);
                        hx0.d(jSONObject3, "countdown", z91Var.n);
                        hx0.f(jSONObject3, "source_path", x91.q(z91Var.g));
                        hx0.f(optJSONObject8, "topview", jSONObject3);
                        z91Var.K = optJSONObject7;
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, z91 z91Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, z91Var) == null) {
                try {
                    jSONObject.put("advisible", z91Var.a);
                    jSONObject.put("id", z91Var.b);
                    jSONObject.put("ukey", z91Var.c);
                    jSONObject.put("extra", z91Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, z91Var.e);
                    jSONObject.put("type", z91Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, z91Var.k);
                    jSONObject.put("action", z91Var.o);
                    jSONObject.put("action_cmd", z91Var.p);
                    jSONObject.put("flag_name", z91Var.l);
                    jSONObject.put("logo_type", z91Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, z91Var.n);
                    jSONObject.put("start", z91Var.s);
                    jSONObject.put("end", z91Var.t);
                    jSONObject.put("expose_times", z91Var.v);
                    jSONObject.put("expose_interval", z91Var.u);
                    jSONObject.put("preload_type", z91Var.w);
                    jSONObject.put("curRate", z91Var.x);
                    jSONObject.put("click_float_lottie_url", z91Var.z);
                    jSONObject.put("float_bar_show", z91Var.A);
                    jSONObject.put("click_float_opt", z91Var.B);
                    jSONObject.put("style_desc", z91Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, z91Var.E);
                    jSONObject.put("ad_sort", z91Var.F);
                    jSONObject.put("gesture_lottie_type", z91Var.G);
                    jSONObject.put("gesture_lottie_url", z91Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", z91Var.I);
                    jSONObject.put("is_topview", z91Var.J);
                    if (z91Var.J == 1 && z91Var.K != null) {
                        jSONObject.put("topview_data", z91Var.K);
                    }
                    if (z91Var.L != null) {
                        jSONObject.put("animation_data", z91Var.L);
                    }
                    if (z91Var.q != null) {
                        if (zz0.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(z91Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(z91Var.q)));
                        }
                    }
                    if (z91Var.r != null) {
                        if (zz0.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(z91Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(z91Var.r)));
                        }
                    }
                    if (z91Var.i()) {
                        b.b(jSONObject, z91Var);
                    } else {
                        c.b(jSONObject, z91Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(z91 z91Var, z91 z91Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, z91Var, z91Var2) == null) {
                z91Var.a = z91Var2.a;
                z91Var.b = z91Var2.b;
                z91Var.c = z91Var2.c;
                z91Var.d = z91Var2.d;
                z91Var.e = z91Var2.e;
                z91Var.f = z91Var2.f;
                z91Var.g = z91Var2.g;
                z91Var.h = z91Var2.h;
                z91Var.i = z91Var2.i;
                z91Var.j = z91Var2.j;
                z91Var.k = z91Var2.k;
                z91Var.l = z91Var2.l;
                z91Var.m = z91Var2.m;
                z91Var.n = z91Var2.n;
                z91Var.o = z91Var2.o;
                z91Var.p = z91Var2.p;
                z91Var.q = z91Var2.q;
                z91Var.r = z91Var2.r;
                z91Var.s = z91Var2.s;
                z91Var.t = z91Var2.t;
                z91Var.u = z91Var2.u;
                z91Var.v = z91Var2.v;
                z91Var.x = z91Var2.x;
                z91Var.z = z91Var2.z;
                z91Var.A = z91Var2.A;
                z91Var.B = z91Var2.B;
                z91Var.C = z91Var2.C;
                z91Var.E = z91Var2.E;
                z91Var.F = z91Var2.F;
                z91Var.G = z91Var2.G;
                z91Var.H = z91Var2.H;
                z91Var.I = z91Var2.I;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, z91 z91Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, z91Var) == null) || jSONObject == null) {
                return;
            }
            try {
                z91Var.g = jSONObject.optString("url");
                z91Var.h = jSONObject.optInt("width");
                z91Var.i = jSONObject.optInt("height");
                z91Var.j = jSONObject.optString("imageMd5");
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, z91 z91Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, z91Var) == null) {
                try {
                    jSONObject.put("url", z91Var.g);
                    jSONObject.put("imageMd5", z91Var.j);
                    jSONObject.put("width", z91Var.h);
                    jSONObject.put("height", z91Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, z91 z91Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, z91Var) == null) || jSONObject == null) {
                return;
            }
            try {
                z91Var.g = jSONObject.optString("url");
                z91Var.h = jSONObject.optInt("width");
                z91Var.i = jSONObject.optInt("height");
                z91Var.j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, z91 z91Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, z91Var) == null) {
                try {
                    jSONObject.put("url", z91Var.g);
                    jSONObject.put(PackageTable.MD5, z91Var.j);
                    jSONObject.put("width", z91Var.h);
                    jSONObject.put("height", z91Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public z91() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = 0;
        this.y = false;
    }

    public static boolean a(z91 z91Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, z91Var)) == null) {
            if (TextUtils.isEmpty(z91Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(z91Var.g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > z91Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(z91Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static z91 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            z91 z91Var = new z91();
            try {
                a.a(jSONObject, z91Var);
            } catch (Exception unused) {
            }
            return z91Var;
        }
        return (z91) invokeL.objValue;
    }

    public static z91 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                z91 z91Var = new z91();
                a.b(jSONObject, z91Var);
                return z91Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (z91) invokeL.objValue;
    }

    public static List<z91> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        z91 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    c2 = c((JSONObject) jSONArray.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (c2 == null) {
                    break;
                }
                if (c2.a != 0 && a(c2)) {
                    arrayList.add(c2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void l(z91 z91Var, z91 z91Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, z91Var, z91Var2) == null) {
            a.d(z91Var, z91Var2);
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.C)) {
                try {
                    return new JSONObject(this.C);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new JSONObject();
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.equals(this.e, "splash_image") ? "image" : TextUtils.equals(this.e, "splash_video") ? "video" : "" : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.E == 3 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f == 1 : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.E;
            return i == 0 || i == 1 || i == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(this.e, "splash_image") : invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            a.c(jSONObject, this);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
