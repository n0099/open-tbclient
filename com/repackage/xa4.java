package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xa4 extends o94<db4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xa4(String str, d84 d84Var, ob4 ob4Var) {
        super(d84Var, ob4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, d84Var, ob4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d84) objArr2[0], (ob4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    @Override // com.repackage.o94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o94
    /* renamed from: v */
    public boolean f(db4 db4Var) {
        InterceptResult invokeL;
        List<i94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, db4Var)) == null) {
            if (db4Var == null) {
                return false;
            }
            if (db4Var.a == null && (((list = db4Var.b) == null || list.isEmpty()) && db4Var.d == null && db4Var.f == null && db4Var.e == null)) {
                return false;
            }
            h94 h94Var = db4Var.a;
            if (h94Var == null || h94Var.a()) {
                List<i94> list2 = db4Var.b;
                if (list2 != null) {
                    for (i94 i94Var : list2) {
                        if (!i94Var.a()) {
                            return false;
                        }
                    }
                }
                f94 f94Var = db4Var.d;
                if (f94Var == null || f94Var.a()) {
                    d94 d94Var = db4Var.f;
                    if (d94Var == null || d94Var.a()) {
                        PMSAppInfo pMSAppInfo = db4Var.e;
                        return pMSAppInfo == null || pMSAppInfo.checkValid();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o94
    /* renamed from: w */
    public boolean s(db4 db4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, db4Var, i)) == null) {
            if (db4Var != null) {
                r(db4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o94
    /* renamed from: x */
    public c94 t(db4 db4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, db4Var)) == null) {
            this.a.F();
            qd4 qd4Var = new qd4();
            o(db4Var.a, qd4Var);
            p(db4Var.b, qd4Var);
            n(g(db4Var.c), qd4Var);
            m(db4Var.d, qd4Var);
            l(db4Var.f, qd4Var);
            r(db4Var.e);
            if (qd4Var.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(qd4Var);
            t94.b(db4Var, this.a);
            return null;
        }
        return (c94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o94
    /* renamed from: y */
    public db4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? pd4.g(this.d, jSONObject) : (db4) invokeL.objValue;
    }
}
