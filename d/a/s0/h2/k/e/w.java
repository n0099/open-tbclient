package d.a.s0.h2.k.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
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
/* loaded from: classes9.dex */
public class w extends d.a.r0.w.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbEditorData.ThreadData f60763a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.r0.w.b f60764b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60765c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60766d;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f60767e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ w f60768f;

        public a(w wVar, v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60768f = wVar;
            this.f60767e = vVar;
        }

        @Override // d.a.r0.w.b
        public void onAction(d.a.r0.w.a aVar) {
            v vVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (vVar = this.f60767e) == null || vVar.a() == null || aVar == null) {
                return;
            }
            if (this.f60768f.f60764b != null) {
                this.f60768f.f60764b.onAction(aVar);
            }
            int i2 = aVar.f56766a;
            if (i2 == 16) {
                if (this.f60768f.h(this.f60767e.f().getPageContext(), 11025)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f60767e.f().getActivity(), 12004, true)));
                }
            } else if (i2 == 18) {
                if (aVar.f56768c != null) {
                    this.f60767e.m();
                    return;
                }
                int g2 = this.f60767e.g();
                if (g2 == 0) {
                    this.f60767e.l();
                } else if (g2 != 2) {
                } else {
                    this.f60767e.i();
                }
            } else if (i2 == 20) {
                d.a.s0.h3.m0.b.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i2 == 32) {
                this.f60767e.a().A(new d.a.r0.w.a(1, 11, null));
            } else if (i2 == 36) {
                if (this.f60768f.h(this.f60767e.f().getPageContext(), 11040)) {
                    this.f60767e.n();
                }
            } else if (i2 == 43 && !d.a.r0.p0.b.c(this.f60767e.f().getPageContext(), true, false)) {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.f60767e.f().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.f60768f.f60763a != null) {
                    hotSelectActivityConfig.setForumExtra(d.a.c.e.m.b.f(this.f60768f.f60763a.getForumId(), 0L), this.f60768f.f60763a.getFirstDir(), this.f60768f.f60763a.getSecondDir());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    public w() {
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
        this.f60765c = false;
        this.f60766d = false;
    }

    @Override // d.a.r0.w.c
    public d.a.r0.w.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            if (this.f60765c) {
                editorTools.setBarLauncherType(2);
            } else if (this.f60766d) {
                editorTools.setBarLauncherType(5);
            } else {
                editorTools.setBarLauncherType(3);
            }
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(true);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.C(true);
            return new v(editorTools);
        }
        return (d.a.r0.w.e) invokeL.objValue;
    }

    @Override // d.a.r0.w.c
    public void c(d.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof v)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (v) eVar);
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

    @Override // d.a.r0.w.c
    public void d(d.a.r0.w.e eVar) {
        CustomResponsedMessage runTask;
        d.a.r0.w.m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            if (!this.f60765c) {
                arrayList.add(10);
                a2.d(new d.a.r0.w.r.d(a2.getContext(), 1));
            }
            if (!this.f60766d) {
                arrayList.add(6);
                arrayList.add(9);
                PbEditorData.ThreadData threadData = this.f60763a;
                String forumName = threadData != null ? threadData.getForumName() : "";
                if (d.a.s0.h3.p0.c.a() && d.a.s0.h3.u.a(forumName, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), d.a.r0.w.m.class)) != null && (mVar = (d.a.r0.w.m) runTask.getData()) != null) {
                    mVar.j = 2;
                    a2.d(mVar);
                }
                a2.d(new d.a.r0.w.o.a(a2.getContext(), 4));
                if (!this.f60765c) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), d.a.r0.w.m.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        d.a.r0.w.m mVar2 = (d.a.r0.w.m) runTask2.getData();
                        mVar2.j = 6;
                        a2.d(mVar2);
                    }
                    CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), d.a.r0.w.m.class);
                    if (runTask3 != null && runTask3.getData() != null) {
                        d.a.r0.w.m mVar3 = (d.a.r0.w.m) runTask3.getData();
                        mVar3.j = 7;
                        a2.d(mVar3);
                    }
                }
                if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName()) && !this.f60765c) {
                    a2.d(new d.a.r0.w.q.a(a2.getContext(), 5));
                }
            }
            if (!this.f60765c && !this.f60766d) {
                arrayList.add(8);
            }
            a2.h(arrayList);
            d.a.r0.w.m n = a2.n(5);
            if (n != null) {
                n.j = 3;
                if (this.f60766d) {
                    n.f(false);
                }
            }
            a2.f();
            if (this.f60765c || this.f60766d) {
                a2.A(new d.a.r0.w.a(35, 5, Boolean.FALSE));
            }
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i2) {
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

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f60766d = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f60765c = z;
        }
    }

    public void k(d.a.r0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f60764b = bVar;
        }
    }

    public void l(PbEditorData.ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.f60763a = threadData;
        }
    }
}
