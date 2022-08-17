package com.repackage;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class iw7 extends j25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbEditorData.ThreadData a;
    public i25 b;
    public boolean c;
    public boolean d;

    /* loaded from: classes6.dex */
    public class a implements i25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw7 a;
        public final /* synthetic */ iw7 b;

        public a(iw7 iw7Var, hw7 hw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw7Var, hw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iw7Var;
            this.a = hw7Var;
        }

        @Override // com.repackage.i25
        public void A(h25 h25Var) {
            hw7 hw7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) || (hw7Var = this.a) == null || hw7Var.a() == null || h25Var == null) {
                return;
            }
            if (this.b.b != null) {
                this.b.b.A(h25Var);
            }
            int i = h25Var.a;
            if (i == 18) {
                if (h25Var.c != null) {
                    this.a.l();
                    return;
                }
                int f = this.a.f();
                if (f == 0) {
                    this.a.k();
                } else if (f != 2) {
                } else {
                    this.a.h();
                }
            } else if (i == 20) {
                yl8.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 32) {
                this.a.a().A(new h25(1, 11, null));
            } else if (i == 36) {
                if (this.b.h(this.a.getContext().getPageContext(), 11040)) {
                    this.a.m();
                }
            } else if (i == 43 && !ie5.c(this.a.getContext().getPageContext(), true, false)) {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.b.a != null) {
                    hotSelectActivityConfig.setForumExtra(og.g(this.b.a.getForumId(), 0L), this.b.a.getFirstDir(), this.b.a.getSecondDir());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    public iw7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = false;
    }

    @Override // com.repackage.j25
    public l25 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            if (this.c) {
                editorTools.setBarLauncherType(2);
            } else if (this.d) {
                editorTools.setBarLauncherType(5);
            } else {
                editorTools.setBarLauncherType(3);
            }
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.C(true);
            return new hw7(editorTools);
        }
        return (l25) invokeL.objValue;
    }

    @Override // com.repackage.j25
    public void c(l25 l25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l25Var) == null) && (l25Var instanceof hw7)) {
            EditorTools a2 = l25Var.a();
            a aVar = new a(this, (hw7) l25Var);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(24, aVar);
            a2.setActionListener(3, aVar);
            a2.setActionListener(18, aVar);
            a2.setActionListener(20, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(43, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // com.repackage.j25
    public void d(l25 l25Var) {
        CustomResponsedMessage runTask;
        s25 s25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l25Var) == null) {
            EditorTools a2 = l25Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.c) {
                arrayList.add(10);
                a2.d(new d35(a2.getContext(), 1));
            }
            if (!this.d) {
                arrayList.add(6);
                arrayList.add(9);
                PbEditorData.ThreadData threadData = this.a;
                String forumName = threadData != null ? threadData.getForumName() : "";
                if (tm8.a() && zj8.a(forumName, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), s25.class)) != null && (s25Var = (s25) runTask.getData()) != null) {
                    s25Var.l = 2;
                    a2.d(s25Var);
                }
                a2.d(new u25(a2.getContext(), 4));
                if (!this.c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), s25.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        s25 s25Var2 = (s25) runTask2.getData();
                        s25Var2.l = 6;
                        a2.d(s25Var2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), s25.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        s25 s25Var3 = (s25) runTask3.getData();
                        s25Var3.l = 7;
                        a2.d(s25Var3);
                    }
                }
                if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.c) {
                    a2.d(new b35(a2.getContext(), 5));
                }
            }
            if (!this.c && !this.d) {
                arrayList.add(8);
            }
            a2.h(arrayList);
            s25 n = a2.n(5);
            if (n != null) {
                n.l = 3;
                if (this.c || this.d) {
                    n.e(false);
                }
            }
            a2.f();
            if (this.c || this.d) {
                a2.A(new h25(35, 5, Boolean.FALSE));
            }
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i) {
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

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.d = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.c = z;
        }
    }

    public void k(i25 i25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i25Var) == null) {
            this.b = i25Var;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.a = threadData;
        }
    }
}
