package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class qw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(vw0 mpdModel, JSONArray clarityUrlList) {
        ArrayList<rw0> a;
        rw0 rw0Var;
        ArrayList<Object> d;
        ArrayList<rw0> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, mpdModel, clarityUrlList) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(clarityUrlList, "clarityUrlList");
            ww0 b = mpdModel.b();
            if (b == null || (a = b.a()) == null) {
                return;
            }
            ww0 b2 = mpdModel.b();
            if (!(((b2 == null || (a2 = b2.a()) == null) ? 0 : a2.size()) > 0)) {
                a = null;
            }
            if (a == null || (rw0Var = a.get(0)) == null || (d = rw0Var.d()) == null) {
                return;
            }
            int size = d.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = new JSONObject();
                Object obj = d.get(i);
                if (!(obj instanceof xw0)) {
                    obj = null;
                }
                xw0 xw0Var = (xw0) obj;
                if (xw0Var != null) {
                    jSONObject.put("key", xw0Var.g());
                    jSONObject.put("rank", xw0Var.j());
                    jSONObject.put("title", xw0Var.k());
                    jSONObject.put("url", xw0Var.l());
                    jSONObject.put("width", xw0Var.m());
                    jSONObject.put("height", xw0Var.f());
                    jSONObject.put("download_url", xw0Var.d());
                    jSONObject.put("airPlay_url", xx0.a(new String[]{xw0Var.a(), xw0Var.d(), xw0Var.l()}));
                    jSONObject.put("videoBps", xw0Var.b());
                    jSONObject.put("vodMoovSize", xw0Var.h());
                    jSONObject.put("video_clarity_score", xw0Var.c());
                    jSONObject.put("prefetch_size", xw0Var.i());
                    Boolean b3 = rw0Var.b();
                    jSONObject.put("gopAlign", b3 != null ? b3.booleanValue() : xw0Var.e());
                    clarityUrlList.put(jSONObject);
                }
            }
        }
    }

    public static final void b(vw0 mpdModel, JSONObject mpdJson) {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        int i;
        JSONArray optJSONArray2;
        JSONArray jSONArray2;
        int i2;
        JSONArray jSONArray3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, mpdModel, mpdJson) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(mpdJson, "mpdJson");
            JSONObject optJSONObject = mpdJson.optJSONObject("video");
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("adaptation_set")) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            int i4 = 0;
            while (i4 < length) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                if (optJSONObject2 == null || (optJSONArray2 = optJSONObject2.optJSONArray("representation_list")) == null) {
                    jSONArray = optJSONArray;
                    i = length;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = optJSONArray2.length();
                    int i5 = 0;
                    while (i5 < length2) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                        if (optJSONObject3 != null) {
                            jSONArray2 = optJSONArray;
                            jSONArray3 = optJSONArray2;
                            i3 = length2;
                            i2 = length;
                            arrayList2.add(new xw0(optJSONObject3.optString("key"), optJSONObject3.optInt("rank"), optJSONObject3.optString("title"), optJSONObject3.optString("url"), optJSONObject3.optString("download_url"), optJSONObject3.optString("airPlay_url"), optJSONObject3.optInt("bps"), optJSONObject3.optInt("width"), optJSONObject3.optInt("height"), optJSONObject3.optDouble("size"), optJSONObject3.optInt("moov_size"), optJSONObject3.optDouble("clarity_score", -1.0d), optJSONObject3.optInt("prefetch_size", 0), optJSONObject3.optBoolean("frm_align")));
                        } else {
                            jSONArray2 = optJSONArray;
                            i2 = length;
                            jSONArray3 = optJSONArray2;
                            i3 = length2;
                        }
                        i5++;
                        optJSONArray2 = jSONArray3;
                        optJSONArray = jSONArray2;
                        length2 = i3;
                        length = i2;
                    }
                    jSONArray = optJSONArray;
                    i = length;
                    arrayList.add(new rw0(arrayList2, optJSONObject2.optString("type"), optJSONObject2.has("frm_align") ? Boolean.valueOf(optJSONObject2.optBoolean("frm_align")) : null, optJSONObject2.optString("pre"), optJSONObject2.optString("suf"), optJSONObject2.optString("codecs")));
                }
                i4++;
                optJSONArray = jSONArray;
                length = i;
            }
            mpdModel.f(new ww0(arrayList, null, null, null, null, 30, null));
        }
    }
}
