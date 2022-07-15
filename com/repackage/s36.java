package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ItemManage.DataRes;
import tbclient.ManageInfo;
/* loaded from: classes7.dex */
public class s36 implements u75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<j36> a;
    public List<j36> b;
    public Integer c;

    public s36() {
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
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = 0;
    }

    public void a(s36 s36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s36Var) == null) {
            this.a.addAll(s36Var.a);
            this.b = s36Var.b;
            this.c = s36Var.c;
        }
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            for (ManageInfo manageInfo : dataRes.manage_list) {
                this.a.add(j36.c(manageInfo));
            }
            for (ManageInfo manageInfo2 : dataRes.manage_recomm_list) {
                this.b.add(j36.c(manageInfo2));
            }
            this.c = dataRes.has_more;
        }
    }

    @Override // com.repackage.u75
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // com.repackage.u75
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
        }
    }
}
