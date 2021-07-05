package d.a.s0.x3.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.w.e;
import d.a.r0.w.m;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends d.a.r0.w.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.x3.c.a f69478e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f69479f;

        public a(b bVar, d.a.s0.x3.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69479f = bVar;
            this.f69478e = aVar;
        }

        @Override // d.a.r0.w.b
        public void onAction(d.a.r0.w.a aVar) {
            d.a.s0.x3.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f69478e) == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f56766a;
            if (i2 == 4) {
                this.f69478e.v((String) aVar.f56768c);
            } else if (i2 == 7) {
                this.f69478e.m().showToast(R.string.over_limit_tip);
            } else if (i2 != 8) {
            } else {
                this.f69478e.z();
                if (this.f69479f.f(this.f69478e.m(), 11001)) {
                    this.f69478e.p();
                }
            }
        }
    }

    public b() {
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

    @Override // d.a.r0.w.c
    public e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new d.a.s0.x3.c.a(editorTools);
        }
        return (e) invokeL.objValue;
    }

    @Override // d.a.r0.w.c
    public void c(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof d.a.s0.x3.c.a)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (d.a.s0.x3.c.a) eVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(8, aVar);
        }
    }

    @Override // d.a.r0.w.c
    public void d(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        m n = a2.n(5);
        if (n != null) {
            n.f(false);
            n.f56775d = 0;
        }
        a2.d(new c(a2.getContext()));
        a2.f();
        a2.A(new d.a.r0.w.a(35, 5, Boolean.FALSE));
        a2.o();
    }

    public final boolean f(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
