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
import com.repackage.c11;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public int C;
    public int D;
    public int E;
    public int F;
    public String G;
    public int H;
    public int I;
    public JSONObject J;
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
    public String[] p;
    public String[] q;
    public long r;
    public long s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public String y;
    public int z;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, bb1 bb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, bb1Var) == null) {
                try {
                    bb1Var.a = jSONObject.optInt("advisible");
                    bb1Var.b = jSONObject.optString("id");
                    bb1Var.c = jSONObject.optString("ukey");
                    bb1Var.d = jSONObject.optString("extra");
                    bb1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    bb1Var.f = jSONObject.optInt("type");
                    bb1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    bb1Var.o = jSONObject.optString("action");
                    bb1Var.l = jSONObject.optString("flag_name");
                    bb1Var.m = jSONObject.optInt("logo_type");
                    bb1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (bb1Var.i()) {
                        b.a(jSONObject, bb1Var);
                    } else {
                        c.a(jSONObject, bb1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        bb1Var.p = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            bb1Var.p[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        bb1Var.q = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            bb1Var.q[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    bb1Var.r = jSONObject.optLong("start");
                    bb1Var.s = jSONObject.optLong("end");
                    bb1Var.t = jSONObject.optInt("expose_interval");
                    bb1Var.u = jSONObject.optInt("expose_times");
                    bb1Var.v = jSONObject.optInt("preload_type");
                    bb1Var.y = jSONObject.optString("click_float_lottie_url");
                    bb1Var.z = jSONObject.optInt("float_bar_show", 1);
                    bb1Var.A = jSONObject.optInt("click_float_opt", 1);
                    bb1Var.B = jSONObject.optString("style_desc");
                    bb1Var.w = jSONObject.optInt("curRate");
                    bb1Var.D = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    bb1Var.E = jSONObject.optInt("ad_sort");
                    bb1Var.F = jSONObject.optInt("gesture_lottie_type");
                    bb1Var.G = jSONObject.optString("gesture_lottie_url");
                    bb1Var.H = jSONObject.optInt("gesture_lottie_sensitivity");
                    int optInt = jSONObject.optInt("is_topview", 0);
                    bb1Var.I = optInt;
                    if (optInt != 1 || jSONObject.optJSONObject("topview_data") == null) {
                        return;
                    }
                    bb1Var.J = jSONObject.optJSONObject("topview_data");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, bb1 bb1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, bb1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    bb1Var.a = optJSONObject.optInt("advisible", 1);
                    bb1Var.b = optJSONObject.optString("id");
                    bb1Var.c = optJSONObject.optString("ukey");
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
                                    bb1Var.d = optString2;
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
                        bb1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            bb1Var.f = optJSONObject5.optInt("type");
                            bb1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                            bb1Var.o = optJSONObject5.optString("action");
                            bb1Var.l = optJSONObject5.optString("flag_name");
                            bb1Var.m = optJSONObject5.optInt("logo_type");
                            bb1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            bb1Var.y = optJSONObject5.optString("click_float_lottie_url");
                            bb1Var.D = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                            bb1Var.E = optJSONObject5.optInt("ad_sort");
                            bb1Var.F = optJSONObject5.optInt("gesture_lottie_type");
                            bb1Var.G = optJSONObject5.optString("gesture_lottie_url");
                            bb1Var.H = optJSONObject5.optInt("gesture_lottie_sensitivity");
                            bb1Var.I = optJSONObject5.optInt("is_topview", 0);
                            if (bb1Var.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), bb1Var);
                            } else {
                                c.a(optJSONObject5, bb1Var);
                            }
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            bb1Var.p = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                bb1Var.p[i2] = optJSONArray6.optString(i2);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            bb1Var.q = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                bb1Var.q[i3] = optJSONArray7.optString(i3);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            bb1Var.r = jSONObject2.optLong("start");
                            bb1Var.s = jSONObject2.optLong("end");
                            bb1Var.t = optJSONObject6.optInt("expose_interval");
                            bb1Var.u = optJSONObject6.optInt("expose_times");
                            bb1Var.v = optJSONObject6.optInt("preload_type");
                            bb1Var.z = optJSONObject6.optInt("float_bar_show", 1);
                            bb1Var.A = optJSONObject6.optInt("click_float_opt", 1);
                            bb1Var.B = optJSONObject6.optString("style_desc");
                        }
                        JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                        if (bb1Var.I != 1 || optJSONObject7 == null) {
                            return;
                        }
                        JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                        if (optJSONObject8 == null) {
                            bb1Var.I = 0;
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        uy0.f(jSONObject3, "click_float_lottie_url", bb1Var.y);
                        uy0.d(jSONObject3, "click_float_opt", bb1Var.A);
                        uy0.d(jSONObject3, "float_bar_show", bb1Var.z);
                        uy0.g(jSONObject3, "switch", true);
                        uy0.f(jSONObject3, "style_desc", bb1Var.B);
                        uy0.d(jSONObject3, "countdown", bb1Var.n);
                        uy0.f(jSONObject3, "source_path", za1.q(bb1Var.g));
                        uy0.f(optJSONObject8, "topview", jSONObject3);
                        bb1Var.J = optJSONObject7;
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, bb1 bb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, bb1Var) == null) {
                try {
                    jSONObject.put("advisible", bb1Var.a);
                    jSONObject.put("id", bb1Var.b);
                    jSONObject.put("ukey", bb1Var.c);
                    jSONObject.put("extra", bb1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, bb1Var.e);
                    jSONObject.put("type", bb1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, bb1Var.k);
                    jSONObject.put("action", bb1Var.o);
                    jSONObject.put("flag_name", bb1Var.l);
                    jSONObject.put("logo_type", bb1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, bb1Var.n);
                    jSONObject.put("start", bb1Var.r);
                    jSONObject.put("end", bb1Var.s);
                    jSONObject.put("expose_times", bb1Var.u);
                    jSONObject.put("expose_interval", bb1Var.t);
                    jSONObject.put("preload_type", bb1Var.v);
                    jSONObject.put("curRate", bb1Var.w);
                    jSONObject.put("click_float_lottie_url", bb1Var.y);
                    jSONObject.put("float_bar_show", bb1Var.z);
                    jSONObject.put("click_float_opt", bb1Var.A);
                    jSONObject.put("style_desc", bb1Var.B);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, bb1Var.D);
                    jSONObject.put("ad_sort", bb1Var.E);
                    jSONObject.put("gesture_lottie_type", bb1Var.F);
                    jSONObject.put("gesture_lottie_url", bb1Var.G);
                    jSONObject.put("gesture_lottie_sensitivity", bb1Var.H);
                    jSONObject.put("is_topview", bb1Var.I);
                    if (bb1Var.I == 1 && bb1Var.J != null) {
                        jSONObject.put("topview_data", bb1Var.J);
                    }
                    if (bb1Var.p != null) {
                        if (c11.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(bb1Var.p));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(bb1Var.p)));
                        }
                    }
                    if (bb1Var.q != null) {
                        if (c11.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(bb1Var.q));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(bb1Var.q)));
                        }
                    }
                    if (bb1Var.i()) {
                        b.b(jSONObject, bb1Var);
                    } else {
                        c.b(jSONObject, bb1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(bb1 bb1Var, bb1 bb1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, bb1Var, bb1Var2) == null) {
                bb1Var.a = bb1Var2.a;
                bb1Var.b = bb1Var2.b;
                bb1Var.c = bb1Var2.c;
                bb1Var.d = bb1Var2.d;
                bb1Var.e = bb1Var2.e;
                bb1Var.f = bb1Var2.f;
                bb1Var.g = bb1Var2.g;
                bb1Var.h = bb1Var2.h;
                bb1Var.i = bb1Var2.i;
                bb1Var.j = bb1Var2.j;
                bb1Var.k = bb1Var2.k;
                bb1Var.l = bb1Var2.l;
                bb1Var.m = bb1Var2.m;
                bb1Var.n = bb1Var2.n;
                bb1Var.o = bb1Var2.o;
                bb1Var.p = bb1Var2.p;
                bb1Var.q = bb1Var2.q;
                bb1Var.r = bb1Var2.r;
                bb1Var.s = bb1Var2.s;
                bb1Var.t = bb1Var2.t;
                bb1Var.u = bb1Var2.u;
                bb1Var.w = bb1Var2.w;
                bb1Var.y = bb1Var2.y;
                bb1Var.z = bb1Var2.z;
                bb1Var.A = bb1Var2.A;
                bb1Var.B = bb1Var2.B;
                bb1Var.D = bb1Var2.D;
                bb1Var.E = bb1Var2.E;
                bb1Var.F = bb1Var2.F;
                bb1Var.G = bb1Var2.G;
                bb1Var.H = bb1Var2.H;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, bb1 bb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, bb1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                bb1Var.g = jSONObject.optString("url");
                bb1Var.h = jSONObject.optInt("width");
                bb1Var.i = jSONObject.optInt("height");
                bb1Var.j = jSONObject.optString("imageMd5");
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, bb1 bb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, bb1Var) == null) {
                try {
                    jSONObject.put("url", bb1Var.g);
                    jSONObject.put("imageMd5", bb1Var.j);
                    jSONObject.put("width", bb1Var.h);
                    jSONObject.put("height", bb1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, bb1 bb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, bb1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                bb1Var.g = jSONObject.optString("url");
                bb1Var.h = jSONObject.optInt("width");
                bb1Var.i = jSONObject.optInt("height");
                bb1Var.j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, bb1 bb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, bb1Var) == null) {
                try {
                    jSONObject.put("url", bb1Var.g);
                    jSONObject.put(PackageTable.MD5, bb1Var.j);
                    jSONObject.put("width", bb1Var.h);
                    jSONObject.put("height", bb1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public bb1() {
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
        this.w = 0;
        this.x = false;
    }

    public static boolean a(bb1 bb1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bb1Var)) == null) {
            if (TextUtils.isEmpty(bb1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(bb1Var.g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > bb1Var.s) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(bb1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static bb1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            bb1 bb1Var = new bb1();
            try {
                a.a(jSONObject, bb1Var);
            } catch (Exception unused) {
            }
            return bb1Var;
        }
        return (bb1) invokeL.objValue;
    }

    public static bb1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                bb1 bb1Var = new bb1();
                a.b(jSONObject, bb1Var);
                return bb1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (bb1) invokeL.objValue;
    }

    public static List<bb1> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        bb1 c2;
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

    public static void l(bb1 bb1Var, bb1 bb1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bb1Var, bb1Var2) == null) {
            a.d(bb1Var, bb1Var2);
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.B)) {
                try {
                    return new JSONObject(this.B);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.D == 3 : invokeV.booleanValue;
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
            int i = this.D;
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
