package d.a.p0.s.q;

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
    public String f53381a;

    /* renamed from: b  reason: collision with root package name */
    public String f53382b;

    /* renamed from: c  reason: collision with root package name */
    public String f53383c;

    /* renamed from: d  reason: collision with root package name */
    public String f53384d;

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
        this.f53381a = intent.getStringExtra(TiebaStatic.Params.RECOM_WEIGHT);
        this.f53382b = intent.getStringExtra("recom_source");
        this.f53383c = intent.getStringExtra("recom_abtag");
        this.f53384d = intent.getStringExtra(TiebaStatic.Params.RECOM_EXTRA);
    }

    public void b(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.f53381a = b2Var.U0;
        this.f53382b = b2Var.T0;
        this.f53383c = b2Var.V0;
        this.f53384d = b2Var.W0;
    }

    public void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) || intent == null) {
            return;
        }
        intent.putExtra(TiebaStatic.Params.RECOM_WEIGHT, this.f53381a);
        intent.putExtra("recom_source", this.f53382b);
        intent.putExtra("recom_abtag", this.f53383c);
        intent.putExtra(TiebaStatic.Params.RECOM_EXTRA, this.f53384d);
    }

    public void d(d.a.q0.n2.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null) {
            return;
        }
        oVar.f61429g = this.f53381a;
        oVar.f61428f = this.f53382b;
        oVar.l = this.f53383c;
        oVar.o = this.f53384d;
    }
}
