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
public class lv8 extends j25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes6.dex */
    public class a implements i25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;
        public final /* synthetic */ lv8 b;

        public a(lv8 lv8Var, kv8 kv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv8Var, kv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lv8Var;
            this.a = kv8Var;
        }

        @Override // com.repackage.i25
        public void A(h25 h25Var) {
            kv8 kv8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) || (kv8Var = this.a) == null || kv8Var.a() == null || h25Var == null) {
                return;
            }
            int i = h25Var.a;
            if (i == 4) {
                this.a.u((String) h25Var.c);
            } else if (i == 7) {
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d1a);
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

    public lv8() {
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

    @Override // com.repackage.j25
    public l25 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(R.color.CAM_X0207);
            return new kv8(editorTools);
        }
        return (l25) invokeL.objValue;
    }

    @Override // com.repackage.j25
    public void c(l25 l25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l25Var) == null) && (l25Var instanceof kv8)) {
            EditorTools a2 = l25Var.a();
            a aVar = new a(this, (kv8) l25Var);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(8, aVar);
        }
    }

    @Override // com.repackage.j25
    public void d(l25 l25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l25Var) == null) || l25Var == null) {
            return;
        }
        EditorTools a2 = l25Var.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.h(arrayList);
        s25 n = a2.n(5);
        if (n != null) {
            n.e(false);
            n.d = 0;
        }
        a2.d(new mv8(a2.getContext()));
        a2.f();
        a2.A(new h25(35, 5, Boolean.FALSE));
        a2.o();
    }

    public l25 g(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            this.a = bVar;
            return super.a(context);
        }
        return (l25) invokeLL.objValue;
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
