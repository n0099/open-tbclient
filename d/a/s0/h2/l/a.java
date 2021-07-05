package d.a.s0.h2.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h2.l.b.c;
import d.a.s0.h2.l.b.d;
import d.a.s0.h2.l.b.f;
import d.a.s0.h2.l.b.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d> f60891a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60891a = new ArrayList<>();
    }

    public ArrayList<d> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60891a : (ArrayList) invokeV.objValue;
    }

    public final boolean b(ExcContent excContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, excContent)) == null) {
            long longValue = excContent.type.longValue();
            return longValue == 2 || longValue == 0 || longValue == 1;
        }
        return invokeL.booleanValue;
    }

    public void c(TbPageContext<?> tbPageContext, List<ExcContent> list) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        loop0: while (true) {
            gVar = null;
            for (ExcContent excContent : list) {
                if (excContent != null && excContent.type != null) {
                    if (b(excContent)) {
                        c a2 = f.a(tbPageContext, excContent);
                        if (a2 == null) {
                            continue;
                        } else if (a2.a()) {
                            if (gVar != null) {
                                this.f60891a.add(gVar);
                            }
                            this.f60891a.add(a2);
                        } else {
                            if (gVar == null) {
                                gVar = new g();
                            }
                            gVar.c(a2.b());
                        }
                    } else {
                        if (gVar != null) {
                            this.f60891a.add(gVar);
                        }
                        this.f60891a.add(f.b(excContent));
                    }
                }
            }
            break loop0;
        }
        if (gVar != null) {
            this.f60891a.add(gVar);
        }
    }
}
