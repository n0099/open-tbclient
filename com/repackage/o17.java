package com.repackage;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class o17 extends l15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes6.dex */
    public class a implements k15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n17 a;
        public final /* synthetic */ o17 b;

        public a(o17 o17Var, n17 n17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o17Var, n17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o17Var;
            this.a = n17Var;
        }

        @Override // com.repackage.k15
        public void C(j15 j15Var) {
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) || j15Var == null) {
                return;
            }
            int i = j15Var.a;
            if (i == 4 || i == 6) {
                this.a.G((String) j15Var.c);
                this.b.a = false;
            } else if (i == 7) {
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d07);
                this.b.a = true;
            } else if (i == 8) {
                if (this.b.g(this.a.getContext(), 11001)) {
                    this.a.x();
                    TiebaStatic.log(new StatisticItem("c13363").param("topic_id", String.valueOf(this.a.r())));
                }
            } else if (i != 14) {
                if (i != 15) {
                    return;
                }
                int intValue = ((Integer) j15Var.c).intValue();
                if (this.a.q() != null && this.a.q().getChosedFiles() != null && (size = this.a.q().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.q(), intValue)));
                }
            } else {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getContext().getPageActivity(), this.a.q().toJsonString(), true, true);
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                if (j35.a().b() == 1) {
                    albumActivityConfig.setRequestFrom(4);
                    if (this.a.q() != null) {
                        this.a.q().setMaxImagesAllowed(1);
                    }
                } else if (this.a.q() != null) {
                    this.a.q().setMaxImagesAllowed(10);
                }
                pi.x(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public o17() {
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
            editorTools.setIsFromPb(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            return new n17(editorTools);
        }
        return (n15) invokeL.objValue;
    }

    @Override // com.repackage.l15
    public void c(n15 n15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n15Var) == null) || n15Var == null) {
            return;
        }
        EditorTools a2 = n15Var.a();
        a aVar = new a(this, (n17) n15Var);
        a2.setActionListener(5, aVar);
        a2.setActionListener(4, aVar);
        a2.setActionListener(6, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(14, aVar);
        a2.setActionListener(15, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(32, aVar);
        a2.setActionListener(45, aVar);
    }

    @Override // com.repackage.l15
    public void d(n15 n15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n15Var) == null) {
            EditorTools a2 = n15Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.h(arrayList);
            u15 n = a2.n(5);
            if (n != null) {
                n.e(false);
                n.l = 1;
            }
            a2.d(new g25(a2.getContext(), 3));
            p17 p17Var = new p17(a2.getContext());
            if (p17Var.g() != null) {
                p17Var.g().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
            }
            a2.d(p17Var);
            a2.f();
            a2.A(new j15(35, 5, Boolean.FALSE));
            a2.q();
        }
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
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
