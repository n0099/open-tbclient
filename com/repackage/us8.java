package com.repackage;

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
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class us8 extends l15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes7.dex */
    public class a implements k15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts8 a;
        public final /* synthetic */ us8 b;

        public a(us8 us8Var, ts8 ts8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us8Var, ts8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = us8Var;
            this.a = ts8Var;
        }

        @Override // com.repackage.k15
        public void C(j15 j15Var) {
            ts8 ts8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) || (ts8Var = this.a) == null || ts8Var.a() == null || j15Var == null) {
                return;
            }
            int i = j15Var.a;
            if (i == 4) {
                this.a.u((String) j15Var.c);
            } else if (i == 7) {
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d07);
            } else if (i != 8) {
            } else {
                this.a.y();
                if (this.b.h(this.a.getContext(), 25066)) {
                    this.a.o();
                    if (this.b.a != null) {
                        this.b.a.a(this.a.l());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(String str);
    }

    public us8() {
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

    @Override // com.repackage.l15
    public n15 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new ts8(editorTools);
        }
        return (n15) invokeL.objValue;
    }

    @Override // com.repackage.l15
    public void c(n15 n15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n15Var) == null) && (n15Var instanceof ts8)) {
            EditorTools a2 = n15Var.a();
            a aVar = new a(this, (ts8) n15Var);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(8, aVar);
        }
    }

    @Override // com.repackage.l15
    public void d(n15 n15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n15Var) == null) || n15Var == null) {
            return;
        }
        EditorTools a2 = n15Var.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        u15 n = a2.n(5);
        if (n != null) {
            n.e(false);
            n.d = 0;
        }
        a2.d(new vs8(a2.getContext()));
        a2.f();
        a2.A(new j15(35, 5, Boolean.FALSE));
        a2.o();
    }

    public n15 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (n15) invokeLL.objValue;
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
