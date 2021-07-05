package d.a.r0.r.q;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f56001a;

    /* renamed from: b  reason: collision with root package name */
    public String f56002b;

    /* renamed from: c  reason: collision with root package name */
    public String f56003c;

    /* renamed from: d  reason: collision with root package name */
    public String f56004d;

    public l1() {
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

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        this.f56001a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f56002b = intent.getStringExtra("recom_source");
        this.f56003c = intent.getStringExtra("recom_abtag");
        this.f56004d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.f56001a = b2Var.U0;
        this.f56002b = b2Var.T0;
        this.f56003c = b2Var.V0;
        this.f56004d = b2Var.W0;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f56001a);
        intent.putExtra("recom_source", this.f56002b);
        intent.putExtra("recom_abtag", this.f56003c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f56004d);
    }

    public void d(d.a.s0.n2.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null) {
            return;
        }
        oVar.f64049g = this.f56001a;
        oVar.f64048f = this.f56002b;
        oVar.l = this.f56003c;
        oVar.o = this.f56004d;
    }
}
