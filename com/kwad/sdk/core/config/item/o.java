package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.ReportInfo;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends b<List<ReportInfo>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o() {
        super("reportItems", d());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static ArrayList<ReportInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ArrayList<ReportInfo> arrayList = new ArrayList<>();
            arrayList.add(new ReportInfo(1, "违法违规"));
            arrayList.add(new ReportInfo(2, "色情低俗"));
            arrayList.add(new ReportInfo(3, "作者举报"));
            arrayList.add(new ReportInfo(4, "封面党"));
            arrayList.add(new ReportInfo(5, "不适合未成年"));
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            List<ReportInfo> a = a();
            if (ae.a(a)) {
                JSONArray jSONArray = new JSONArray();
                for (ReportInfo reportInfo : a) {
                    jSONArray.put(reportInfo.toJson());
                }
                editor.putString("reportItems", jSONArray.toString());
            }
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            try {
                String string = sharedPreferences.getString("reportItems", "");
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                            ReportInfo reportInfo = new ReportInfo();
                            reportInfo.parseJson(optJSONObject);
                            arrayList.add(reportInfo);
                        }
                        if (arrayList.size() > 0) {
                            a((o) arrayList);
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            a((o) c());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("reportItems")) != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        ReportInfo reportInfo = new ReportInfo();
                        reportInfo.parseJson(optJSONObject);
                        arrayList.add(reportInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    a((o) arrayList);
                    return;
                }
            }
            a((o) c());
        }
    }
}
