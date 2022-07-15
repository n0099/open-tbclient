package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class qx4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rx4> a;

    public qx4() {
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

    public void a(JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
            this.a = new ArrayList();
            try {
                if (jSONArray == null) {
                    xt4.k().y("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(xt4.k().q("key_index_tab_info_list", "[]"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    rx4 rx4Var = new rx4();
                    rx4 rx4Var2 = new rx4();
                    rx4Var.h(jSONArray.getJSONObject(i));
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        rx4Var2.h(jSONArray2.getJSONObject(i2));
                        if (rx4Var.c != null && rx4Var.c.equals(rx4Var2.c)) {
                            if (!TextUtils.isEmpty(rx4Var2.e) && rx4Var2.e.equals(rx4Var.e)) {
                                z = false;
                                rx4Var.f = z;
                            }
                            z = true;
                            rx4Var.f = z;
                        }
                    }
                    if (!rx4Var.e()) {
                        this.a.add(rx4Var);
                    }
                }
                xt4.k().y("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
