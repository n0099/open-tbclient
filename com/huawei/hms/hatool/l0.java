package com.huawei.hms.hatool;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class l0 implements n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public List<q> d;

    public l0(List<q> list, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g0.a(b.i(), "backup_event", u0.a(this.a, this.c, this.b));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            List<q> list = this.d;
            if (list == null || list.size() == 0) {
                y.d("hmsSdk", "failed events is empty");
                return;
            }
            if (q0.a(b.i(), "cached_v2_1", b.k() * 1048576)) {
                y.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.b);
                return;
            }
            String a = u0.a(this.a, this.c);
            List<q> list2 = w.b(b.i(), "cached_v2_1", a).get(a);
            if (list2 != null && list2.size() != 0) {
                this.d.addAll(list2);
            }
            JSONArray jSONArray = new JSONArray();
            for (q qVar : this.d) {
                try {
                    jSONArray.put(qVar.d());
                } catch (JSONException unused) {
                    y.e("hmsSdk", "event to json error");
                }
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2.length() > b.h() * 1048576) {
                y.e("hmsSdk", "this failed data is too long,can not writing it");
                this.d = null;
                return;
            }
            y.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.b);
            g0.b(b.i(), "cached_v2_1", a, jSONArray2);
            a();
        }
    }
}
