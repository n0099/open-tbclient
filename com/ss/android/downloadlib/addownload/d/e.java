package com.ss.android.downloadlib.addownload.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    private boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_mistake_click_interval_switch", 0) == 1 : invokeI.booleanValue;
    }

    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i2, c cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, cVar)) == null) {
            if (bVar != null && b(bVar.s())) {
                if (System.currentTimeMillis() - bVar.T() <= a(bVar.s())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "mistake_click");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    private long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_mistake_click_interval", 300) : invokeI.longValue;
    }
}
