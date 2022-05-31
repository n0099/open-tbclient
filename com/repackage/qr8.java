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
/* loaded from: classes6.dex */
public class qr8 extends uz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes6.dex */
    public class a implements tz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr8 a;
        public final /* synthetic */ qr8 b;

        public a(qr8 qr8Var, pr8 pr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr8Var, pr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qr8Var;
            this.a = pr8Var;
        }

        @Override // com.repackage.tz4
        public void onAction(sz4 sz4Var) {
            pr8 pr8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, sz4Var) == null) || (pr8Var = this.a) == null || pr8Var.a() == null || sz4Var == null) {
                return;
            }
            int i = sz4Var.a;
            if (i == 4) {
                this.a.u((String) sz4Var.c);
            } else if (i == 7) {
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d0e);
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

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str);
    }

    public qr8() {
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

    @Override // com.repackage.uz4
    public wz4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new pr8(editorTools);
        }
        return (wz4) invokeL.objValue;
    }

    @Override // com.repackage.uz4
    public void c(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz4Var) == null) && (wz4Var instanceof pr8)) {
            EditorTools a2 = wz4Var.a();
            a aVar = new a(this, (pr8) wz4Var);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(8, aVar);
        }
    }

    @Override // com.repackage.uz4
    public void d(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wz4Var) == null) || wz4Var == null) {
            return;
        }
        EditorTools a2 = wz4Var.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        e05 n = a2.n(5);
        if (n != null) {
            n.e(false);
            n.d = 0;
        }
        a2.d(new rr8(a2.getContext()));
        a2.f();
        a2.A(new sz4(35, 5, Boolean.FALSE));
        a2.o();
    }

    public wz4 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (wz4) invokeLL.objValue;
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
