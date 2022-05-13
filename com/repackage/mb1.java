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
import com.repackage.m11;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mb1 {
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

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, mb1 mb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, mb1Var) == null) {
                try {
                    mb1Var.a = jSONObject.optInt("advisible");
                    mb1Var.b = jSONObject.optString("id");
                    mb1Var.c = jSONObject.optString("ukey");
                    mb1Var.d = jSONObject.optString("extra");
                    mb1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    mb1Var.f = jSONObject.optInt("type");
                    mb1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    mb1Var.o = jSONObject.optString("action");
                    mb1Var.p = jSONObject.optString("action_cmd");
                    mb1Var.l = jSONObject.optString("flag_name");
                    mb1Var.m = jSONObject.optInt("logo_type");
                    mb1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (mb1Var.i()) {
                        b.a(jSONObject, mb1Var);
                    } else {
                        c.a(jSONObject, mb1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        mb1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            mb1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        mb1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            mb1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    mb1Var.s = jSONObject.optLong("start");
                    mb1Var.t = jSONObject.optLong("end");
                    mb1Var.u = jSONObject.optInt("expose_interval");
                    mb1Var.v = jSONObject.optInt("expose_times");
                    mb1Var.w = jSONObject.optInt("preload_type");
                    mb1Var.z = jSONObject.optString("click_float_lottie_url");
                    mb1Var.A = jSONObject.optInt("float_bar_show", 1);
                    mb1Var.B = jSONObject.optInt("click_float_opt", 1);
                    mb1Var.C = jSONObject.optString("style_desc");
                    mb1Var.x = jSONObject.optInt("curRate");
                    mb1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    mb1Var.F = jSONObject.optInt("ad_sort");
                    mb1Var.G = jSONObject.optInt("gesture_lottie_type");
                    mb1Var.H = jSONObject.optString("gesture_lottie_url");
                    mb1Var.I = jSONObject.optInt("gesture_lottie_sensitivity");
                    int optInt = jSONObject.optInt("is_topview", 0);
                    mb1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        mb1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        mb1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, mb1 mb1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, mb1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    mb1Var.a = optJSONObject.optInt("advisible", 1);
                    mb1Var.b = optJSONObject.optString("id");
                    mb1Var.c = optJSONObject.optString("ukey");
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
                                    mb1Var.d = optString2;
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
                        mb1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            mb1Var.f = optJSONObject5.optInt("type");
                            mb1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                            mb1Var.o = optJSONObject5.optString("action");
                            mb1Var.p = optJSONObject5.optString("action_cmd");
                            mb1Var.l = optJSONObject5.optString("flag_name");
                            mb1Var.m = optJSONObject5.optInt("logo_type");
                            mb1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            mb1Var.z = optJSONObject5.optString("click_float_lottie_url");
                            mb1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                            mb1Var.F = optJSONObject5.optInt("ad_sort");
                            mb1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                            mb1Var.H = optJSONObject5.optString("gesture_lottie_url");
                            mb1Var.I = optJSONObject5.optInt("gesture_lottie_sensitivity");
                            mb1Var.J = optJSONObject5.optInt("is_topview", 0);
                            if (mb1Var.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), mb1Var);
                            } else {
                                c.a(optJSONObject5, mb1Var);
                            }
                            mb1Var.L = optJSONObject5.optJSONObject("animation_data");
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            mb1Var.q = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                mb1Var.q[i2] = optJSONArray6.optString(i2);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            mb1Var.r = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                mb1Var.r[i3] = optJSONArray7.optString(i3);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            mb1Var.s = jSONObject2.optLong("start");
                            mb1Var.t = jSONObject2.optLong("end");
                            mb1Var.u = optJSONObject6.optInt("expose_interval");
                            mb1Var.v = optJSONObject6.optInt("expose_times");
                            mb1Var.w = optJSONObject6.optInt("preload_type");
                            mb1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                            mb1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                            mb1Var.C = optJSONObject6.optString("style_desc");
                        }
                        JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                        if (mb1Var.J != 1 || optJSONObject7 == null) {
                            return;
                        }
                        JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                        if (optJSONObject8 == null) {
                            mb1Var.J = 0;
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        uy0.f(jSONObject3, "click_float_lottie_url", mb1Var.z);
                        uy0.d(jSONObject3, "click_float_opt", mb1Var.B);
                        uy0.d(jSONObject3, "float_bar_show", mb1Var.A);
                        uy0.g(jSONObject3, "switch", true);
                        uy0.f(jSONObject3, "style_desc", mb1Var.C);
                        uy0.d(jSONObject3, "countdown", mb1Var.n);
                        uy0.f(jSONObject3, "source_path", kb1.q(mb1Var.g));
                        uy0.f(optJSONObject8, "topview", jSONObject3);
                        mb1Var.K = optJSONObject7;
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, mb1 mb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, mb1Var) == null) {
                try {
                    jSONObject.put("advisible", mb1Var.a);
                    jSONObject.put("id", mb1Var.b);
                    jSONObject.put("ukey", mb1Var.c);
                    jSONObject.put("extra", mb1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, mb1Var.e);
                    jSONObject.put("type", mb1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, mb1Var.k);
                    jSONObject.put("action", mb1Var.o);
                    jSONObject.put("action_cmd", mb1Var.p);
                    jSONObject.put("flag_name", mb1Var.l);
                    jSONObject.put("logo_type", mb1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, mb1Var.n);
                    jSONObject.put("start", mb1Var.s);
                    jSONObject.put("end", mb1Var.t);
                    jSONObject.put("expose_times", mb1Var.v);
                    jSONObject.put("expose_interval", mb1Var.u);
                    jSONObject.put("preload_type", mb1Var.w);
                    jSONObject.put("curRate", mb1Var.x);
                    jSONObject.put("click_float_lottie_url", mb1Var.z);
                    jSONObject.put("float_bar_show", mb1Var.A);
                    jSONObject.put("click_float_opt", mb1Var.B);
                    jSONObject.put("style_desc", mb1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, mb1Var.E);
                    jSONObject.put("ad_sort", mb1Var.F);
                    jSONObject.put("gesture_lottie_type", mb1Var.G);
                    jSONObject.put("gesture_lottie_url", mb1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", mb1Var.I);
                    jSONObject.put("is_topview", mb1Var.J);
                    if (mb1Var.J == 1 && mb1Var.K != null) {
                        jSONObject.put("topview_data", mb1Var.K);
                    }
                    if (mb1Var.L != null) {
                        jSONObject.put("animation_data", mb1Var.L);
                    }
                    if (mb1Var.q != null) {
                        if (m11.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(mb1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(mb1Var.q)));
                        }
                    }
                    if (mb1Var.r != null) {
                        if (m11.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(mb1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(mb1Var.r)));
                        }
                    }
                    if (mb1Var.i()) {
                        b.b(jSONObject, mb1Var);
                    } else {
                        c.b(jSONObject, mb1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(mb1 mb1Var, mb1 mb1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, mb1Var, mb1Var2) == null) {
                mb1Var.a = mb1Var2.a;
                mb1Var.b = mb1Var2.b;
                mb1Var.c = mb1Var2.c;
                mb1Var.d = mb1Var2.d;
                mb1Var.e = mb1Var2.e;
                mb1Var.f = mb1Var2.f;
                mb1Var.g = mb1Var2.g;
                mb1Var.h = mb1Var2.h;
                mb1Var.i = mb1Var2.i;
                mb1Var.j = mb1Var2.j;
                mb1Var.k = mb1Var2.k;
                mb1Var.l = mb1Var2.l;
                mb1Var.m = mb1Var2.m;
                mb1Var.n = mb1Var2.n;
                mb1Var.o = mb1Var2.o;
                mb1Var.p = mb1Var2.p;
                mb1Var.q = mb1Var2.q;
                mb1Var.r = mb1Var2.r;
                mb1Var.s = mb1Var2.s;
                mb1Var.t = mb1Var2.t;
                mb1Var.u = mb1Var2.u;
                mb1Var.v = mb1Var2.v;
                mb1Var.x = mb1Var2.x;
                mb1Var.z = mb1Var2.z;
                mb1Var.A = mb1Var2.A;
                mb1Var.B = mb1Var2.B;
                mb1Var.C = mb1Var2.C;
                mb1Var.E = mb1Var2.E;
                mb1Var.F = mb1Var2.F;
                mb1Var.G = mb1Var2.G;
                mb1Var.H = mb1Var2.H;
                mb1Var.I = mb1Var2.I;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, mb1 mb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, mb1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                mb1Var.g = jSONObject.optString("url");
                mb1Var.h = jSONObject.optInt("width");
                mb1Var.i = jSONObject.optInt("height");
                mb1Var.j = jSONObject.optString("imageMd5");
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, mb1 mb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, mb1Var) == null) {
                try {
                    jSONObject.put("url", mb1Var.g);
                    jSONObject.put("imageMd5", mb1Var.j);
                    jSONObject.put("width", mb1Var.h);
                    jSONObject.put("height", mb1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, mb1 mb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, mb1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                mb1Var.g = jSONObject.optString("url");
                mb1Var.h = jSONObject.optInt("width");
                mb1Var.i = jSONObject.optInt("height");
                mb1Var.j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, mb1 mb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, mb1Var) == null) {
                try {
                    jSONObject.put("url", mb1Var.g);
                    jSONObject.put(PackageTable.MD5, mb1Var.j);
                    jSONObject.put("width", mb1Var.h);
                    jSONObject.put("height", mb1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public mb1() {
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

    public static boolean a(mb1 mb1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mb1Var)) == null) {
            if (TextUtils.isEmpty(mb1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(mb1Var.g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > mb1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(mb1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static mb1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            mb1 mb1Var = new mb1();
            try {
                a.a(jSONObject, mb1Var);
            } catch (Exception unused) {
            }
            return mb1Var;
        }
        return (mb1) invokeL.objValue;
    }

    public static mb1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                mb1 mb1Var = new mb1();
                a.b(jSONObject, mb1Var);
                return mb1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (mb1) invokeL.objValue;
    }

    public static List<mb1> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        mb1 c2;
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

    public static void l(mb1 mb1Var, mb1 mb1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, mb1Var, mb1Var2) == null) {
            a.d(mb1Var, mb1Var2);
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
