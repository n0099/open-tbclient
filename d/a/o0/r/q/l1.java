package d.a.o0.r.q;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f52717a;

    /* renamed from: b  reason: collision with root package name */
    public String f52718b;

    /* renamed from: c  reason: collision with root package name */
    public String f52719c;

    /* renamed from: d  reason: collision with root package name */
    public String f52720d;

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
        this.f52717a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f52718b = intent.getStringExtra("recom_source");
        this.f52719c = intent.getStringExtra("recom_abtag");
        this.f52720d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.f52717a = b2Var.U0;
        this.f52718b = b2Var.T0;
        this.f52719c = b2Var.V0;
        this.f52720d = b2Var.W0;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f52717a);
        intent.putExtra("recom_source", this.f52718b);
        intent.putExtra("recom_abtag", this.f52719c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f52720d);
    }

    public void d(d.a.p0.n2.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null) {
            return;
        }
        oVar.f60815g = this.f52717a;
        oVar.f60814f = this.f52718b;
        oVar.l = this.f52719c;
        oVar.o = this.f52720d;
    }
}
