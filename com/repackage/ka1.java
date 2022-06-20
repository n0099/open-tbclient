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
import com.repackage.d01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ka1 {
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

        public static void a(JSONObject jSONObject, ka1 ka1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ka1Var) == null) {
                try {
                    ka1Var.a = jSONObject.optInt("advisible");
                    ka1Var.b = jSONObject.optString("id");
                    ka1Var.c = jSONObject.optString("ukey");
                    ka1Var.d = jSONObject.optString("extra");
                    ka1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    ka1Var.f = jSONObject.optInt("type");
                    ka1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    ka1Var.o = jSONObject.optString("action");
                    ka1Var.p = jSONObject.optString("action_cmd");
                    ka1Var.l = jSONObject.optString("flag_name");
                    ka1Var.m = jSONObject.optInt("logo_type");
                    ka1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (ka1Var.i()) {
                        b.a(jSONObject, ka1Var);
                    } else {
                        c.a(jSONObject, ka1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        ka1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            ka1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        ka1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            ka1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    ka1Var.s = jSONObject.optLong("start");
                    ka1Var.t = jSONObject.optLong("end");
                    ka1Var.u = jSONObject.optInt("expose_interval");
                    ka1Var.v = jSONObject.optInt("expose_times");
                    ka1Var.w = jSONObject.optInt("preload_type");
                    ka1Var.z = jSONObject.optString("click_float_lottie_url");
                    ka1Var.A = jSONObject.optInt("float_bar_show", 1);
                    ka1Var.B = jSONObject.optInt("click_float_opt", 1);
                    ka1Var.C = jSONObject.optString("style_desc");
                    ka1Var.x = jSONObject.optInt("curRate");
                    ka1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    ka1Var.F = jSONObject.optInt("ad_sort");
                    ka1Var.G = jSONObject.optInt("gesture_lottie_type");
                    ka1Var.H = jSONObject.optString("gesture_lottie_url");
                    ka1Var.I = jSONObject.optInt("gesture_lottie_sensitivity");
                    int optInt = jSONObject.optInt("is_topview", 0);
                    ka1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        ka1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        ka1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ka1 ka1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ka1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    ka1Var.a = optJSONObject.optInt("advisible", 1);
                    ka1Var.b = optJSONObject.optString("id");
                    ka1Var.c = optJSONObject.optString("ukey");
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
                                    ka1Var.d = optString2;
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
                        ka1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            ka1Var.f = optJSONObject5.optInt("type");
                            ka1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                            ka1Var.o = optJSONObject5.optString("action");
                            ka1Var.p = optJSONObject5.optString("action_cmd");
                            ka1Var.l = optJSONObject5.optString("flag_name");
                            ka1Var.m = optJSONObject5.optInt("logo_type");
                            ka1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            ka1Var.z = optJSONObject5.optString("click_float_lottie_url");
                            ka1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                            ka1Var.F = optJSONObject5.optInt("ad_sort");
                            ka1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                            ka1Var.H = optJSONObject5.optString("gesture_lottie_url");
                            ka1Var.I = optJSONObject5.optInt("gesture_lottie_sensitivity");
                            ka1Var.J = optJSONObject5.optInt("is_topview", 0);
                            if (ka1Var.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), ka1Var);
                            } else {
                                c.a(optJSONObject5, ka1Var);
                            }
                            ka1Var.L = optJSONObject5.optJSONObject("animation_data");
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            ka1Var.q = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                ka1Var.q[i2] = optJSONArray6.optString(i2);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            ka1Var.r = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                ka1Var.r[i3] = optJSONArray7.optString(i3);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            ka1Var.s = jSONObject2.optLong("start");
                            ka1Var.t = jSONObject2.optLong("end");
                            ka1Var.u = optJSONObject6.optInt("expose_interval");
                            ka1Var.v = optJSONObject6.optInt("expose_times");
                            ka1Var.w = optJSONObject6.optInt("preload_type");
                            ka1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                            ka1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                            ka1Var.C = optJSONObject6.optString("style_desc");
                        }
                        JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                        if (ka1Var.J != 1 || optJSONObject7 == null) {
                            return;
                        }
                        JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                        if (optJSONObject8 == null) {
                            ka1Var.J = 0;
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        lx0.f(jSONObject3, "click_float_lottie_url", ka1Var.z);
                        lx0.d(jSONObject3, "click_float_opt", ka1Var.B);
                        lx0.d(jSONObject3, "float_bar_show", ka1Var.A);
                        lx0.g(jSONObject3, "switch", true);
                        lx0.f(jSONObject3, "style_desc", ka1Var.C);
                        lx0.d(jSONObject3, "countdown", ka1Var.n);
                        lx0.f(jSONObject3, "source_path", ia1.q(ka1Var.g));
                        lx0.f(optJSONObject8, "topview", jSONObject3);
                        ka1Var.K = optJSONObject7;
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, ka1 ka1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, ka1Var) == null) {
                try {
                    jSONObject.put("advisible", ka1Var.a);
                    jSONObject.put("id", ka1Var.b);
                    jSONObject.put("ukey", ka1Var.c);
                    jSONObject.put("extra", ka1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, ka1Var.e);
                    jSONObject.put("type", ka1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, ka1Var.k);
                    jSONObject.put("action", ka1Var.o);
                    jSONObject.put("action_cmd", ka1Var.p);
                    jSONObject.put("flag_name", ka1Var.l);
                    jSONObject.put("logo_type", ka1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, ka1Var.n);
                    jSONObject.put("start", ka1Var.s);
                    jSONObject.put("end", ka1Var.t);
                    jSONObject.put("expose_times", ka1Var.v);
                    jSONObject.put("expose_interval", ka1Var.u);
                    jSONObject.put("preload_type", ka1Var.w);
                    jSONObject.put("curRate", ka1Var.x);
                    jSONObject.put("click_float_lottie_url", ka1Var.z);
                    jSONObject.put("float_bar_show", ka1Var.A);
                    jSONObject.put("click_float_opt", ka1Var.B);
                    jSONObject.put("style_desc", ka1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, ka1Var.E);
                    jSONObject.put("ad_sort", ka1Var.F);
                    jSONObject.put("gesture_lottie_type", ka1Var.G);
                    jSONObject.put("gesture_lottie_url", ka1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", ka1Var.I);
                    jSONObject.put("is_topview", ka1Var.J);
                    if (ka1Var.J == 1 && ka1Var.K != null) {
                        jSONObject.put("topview_data", ka1Var.K);
                    }
                    if (ka1Var.L != null) {
                        jSONObject.put("animation_data", ka1Var.L);
                    }
                    if (ka1Var.q != null) {
                        if (d01.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(ka1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(ka1Var.q)));
                        }
                    }
                    if (ka1Var.r != null) {
                        if (d01.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(ka1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(ka1Var.r)));
                        }
                    }
                    if (ka1Var.i()) {
                        b.b(jSONObject, ka1Var);
                    } else {
                        c.b(jSONObject, ka1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(ka1 ka1Var, ka1 ka1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, ka1Var, ka1Var2) == null) {
                ka1Var.a = ka1Var2.a;
                ka1Var.b = ka1Var2.b;
                ka1Var.c = ka1Var2.c;
                ka1Var.d = ka1Var2.d;
                ka1Var.e = ka1Var2.e;
                ka1Var.f = ka1Var2.f;
                ka1Var.g = ka1Var2.g;
                ka1Var.h = ka1Var2.h;
                ka1Var.i = ka1Var2.i;
                ka1Var.j = ka1Var2.j;
                ka1Var.k = ka1Var2.k;
                ka1Var.l = ka1Var2.l;
                ka1Var.m = ka1Var2.m;
                ka1Var.n = ka1Var2.n;
                ka1Var.o = ka1Var2.o;
                ka1Var.p = ka1Var2.p;
                ka1Var.q = ka1Var2.q;
                ka1Var.r = ka1Var2.r;
                ka1Var.s = ka1Var2.s;
                ka1Var.t = ka1Var2.t;
                ka1Var.u = ka1Var2.u;
                ka1Var.v = ka1Var2.v;
                ka1Var.x = ka1Var2.x;
                ka1Var.z = ka1Var2.z;
                ka1Var.A = ka1Var2.A;
                ka1Var.B = ka1Var2.B;
                ka1Var.C = ka1Var2.C;
                ka1Var.E = ka1Var2.E;
                ka1Var.F = ka1Var2.F;
                ka1Var.G = ka1Var2.G;
                ka1Var.H = ka1Var2.H;
                ka1Var.I = ka1Var2.I;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ka1 ka1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ka1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                ka1Var.g = jSONObject.optString("url");
                ka1Var.h = jSONObject.optInt("width");
                ka1Var.i = jSONObject.optInt("height");
                ka1Var.j = jSONObject.optString("imageMd5");
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, ka1 ka1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ka1Var) == null) {
                try {
                    jSONObject.put("url", ka1Var.g);
                    jSONObject.put("imageMd5", ka1Var.j);
                    jSONObject.put("width", ka1Var.h);
                    jSONObject.put("height", ka1Var.i);
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

        public static void a(JSONObject jSONObject, ka1 ka1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ka1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                ka1Var.g = jSONObject.optString("url");
                ka1Var.h = jSONObject.optInt("width");
                ka1Var.i = jSONObject.optInt("height");
                ka1Var.j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, ka1 ka1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ka1Var) == null) {
                try {
                    jSONObject.put("url", ka1Var.g);
                    jSONObject.put(PackageTable.MD5, ka1Var.j);
                    jSONObject.put("width", ka1Var.h);
                    jSONObject.put("height", ka1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ka1() {
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

    public static boolean a(ka1 ka1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ka1Var)) == null) {
            if (TextUtils.isEmpty(ka1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(ka1Var.g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > ka1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(ka1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static ka1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ka1 ka1Var = new ka1();
            try {
                a.a(jSONObject, ka1Var);
            } catch (Exception unused) {
            }
            return ka1Var;
        }
        return (ka1) invokeL.objValue;
    }

    public static ka1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                ka1 ka1Var = new ka1();
                a.b(jSONObject, ka1Var);
                return ka1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ka1) invokeL.objValue;
    }

    public static List<ka1> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        ka1 c2;
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

    public static void l(ka1 ka1Var, ka1 ka1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ka1Var, ka1Var2) == null) {
            a.d(ka1Var, ka1Var2);
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
