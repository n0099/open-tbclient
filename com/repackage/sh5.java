package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bl5;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class sh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bl5 a;
    public ih5 b;
    public TbPageContext c;

    /* loaded from: classes7.dex */
    public class a implements bl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sh5 a;

        public a(sh5 sh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sh5Var;
        }

        @Override // com.repackage.bl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.a.b != null) {
                    this.a.b.g(JsonArrayToString);
                    this.a.b.e();
                }
            }
        }
    }

    public sh5(TbPageContext tbPageContext, ih5 ih5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ih5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ih5Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bl5 bl5Var = this.a;
            if (bl5Var != null) {
                bl5Var.u();
                this.a.v();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        ih5 ih5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (ih5Var = this.b) == null || ih5Var.b() == null || this.c == null) {
            return;
        }
        al5 al5Var = new al5(this.b.b().f(), this.b.b().e(), this.b.b().d());
        al5Var.i(this.b.b().b(), this.b.b().c());
        al5Var.h(this.b.b().a());
        al5Var.j(this.b.b().j());
        UserData i2 = this.b.b().i();
        TbPageContext tbPageContext = this.c;
        this.a = new bl5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), al5Var, i2);
        cq4 cq4Var = new cq4();
        cq4Var.j(this.b.b().h());
        this.a.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04bf), this.c.getString(R.string.obfuscated_res_0x7f0f04c0), this.c.getString(R.string.obfuscated_res_0x7f0f04c1), this.c.getString(R.string.obfuscated_res_0x7f0f04c2), this.c.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.a.D(cq4Var);
        this.a.F(new a(this));
        this.a.G((i == 2 || i == 1) ? "5" : i == 3 ? "6" : "0");
    }
}
