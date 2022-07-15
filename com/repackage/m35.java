package com.repackage;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
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
public class m35 extends p35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements k15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n35 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ m35 c;

        public a(m35 m35Var, n35 n35Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m35Var, n35Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m35Var;
            this.a = n35Var;
            this.b = editorTools;
        }

        @Override // com.repackage.k15
        public void C(j15 j15Var) {
            n35 n35Var;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) || (n35Var = this.a) == null || n35Var.a() == null || j15Var == null) {
                return;
            }
            int i = j15Var.a;
            if (i == 4) {
                this.a.o0(j15Var.c.toString());
            } else if (i == 5) {
                if (this.b.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i == 7) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d07);
            } else if (i == 8) {
                if (this.c.k(this.a.getContext(), 11001)) {
                    this.a.M(null, null);
                }
            } else if (i != 14) {
                if (i != 15) {
                    return;
                }
                int intValue = ((Integer) j15Var.c).intValue();
                if (this.a.y() != null && this.a.y().getChosedFiles() != null && (size = this.a.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.y(), intValue)));
                }
            } else {
                if (this.a.y() != null) {
                    this.a.y().setMaxImagesAllowed(1);
                }
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getContext().getPageActivity(), this.a.y().toJsonString(), true, true);
                if (!StringUtils.isNull(this.c.m(), true)) {
                    albumActivityConfig.getIntent().putExtra("from", this.c.m());
                }
                if (this.c.l() != null && !StringUtils.isNull(this.c.l().getId(), true)) {
                    albumActivityConfig.getIntent().putExtra("forum_id", this.c.l().getId());
                }
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                pi.x(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public m35() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.repackage.p35, com.repackage.l15
    public n15 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            n35 n35Var = new n35(editorTools);
            n35Var.l0(n());
            n35Var.v = true;
            return n35Var;
        }
        return (n15) invokeL.objValue;
    }

    @Override // com.repackage.p35, com.repackage.l15
    public void c(n15 n15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n15Var) == null) && (n15Var instanceof n35)) {
            EditorTools a2 = n15Var.a();
            a aVar = new a(this, (n35) n15Var, a2);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // com.repackage.p35, com.repackage.l15
    public void d(n15 n15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n15Var) == null) {
            EditorTools a2 = n15Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.d(new g25(a2.getContext(), 1));
            a2.d(new o35(a2.getContext(), true, false, 12004));
            a2.h(arrayList);
            u15 n = a2.n(5);
            if (n != null) {
                n.l = 2;
                n.e(false);
            }
            a2.f();
            a2.A(new j15(35, 5, Boolean.FALSE));
        }
    }
}
