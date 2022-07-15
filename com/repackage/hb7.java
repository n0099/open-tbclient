package com.repackage;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class hb7 extends l15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    /* loaded from: classes6.dex */
    public class a implements k15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb7 a;
        public final /* synthetic */ hb7 b;

        public a(hb7 hb7Var, gb7 gb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hb7Var, gb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hb7Var;
            this.a = gb7Var;
        }

        @Override // com.repackage.k15
        public void C(j15 j15Var) {
            gb7 gb7Var;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) || (gb7Var = this.a) == null || gb7Var.a() == null || j15Var == null) {
                return;
            }
            int i = j15Var.a;
            if (i == 4) {
                this.a.o0(j15Var.c.toString());
                Object obj = j15Var.c;
                if (obj instanceof SpanGroupManager) {
                    this.a.t0((SpanGroupManager) obj);
                }
                this.b.d = false;
            } else if (i == 18) {
                boolean h = xt4.k().h("key_post_thread_has_request_location", false);
                if (j15Var.c != null) {
                    if (h) {
                        this.a.R();
                        return;
                    }
                    return;
                }
                int t = this.a.t();
                if (t == 0) {
                    this.a.J(h);
                } else if (t != 2) {
                } else {
                    this.a.A();
                }
            } else if (i == 20) {
                this.a.a().A(new j15(2, 7, null));
                nj8.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 32) {
                this.a.a().A(new j15(1, 11, null));
            } else if (i == 36) {
                if (this.b.j(this.a.getContext(), 11040)) {
                    this.a.a0();
                }
            } else if (i == 7) {
                pi.N(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d07);
                this.b.d = true;
            } else if (i == 8) {
                if (this.b.j(this.a.getContext(), 11001)) {
                    this.a.M(null, null);
                }
            } else if (i == 10) {
                Object obj2 = j15Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.w0((VoiceData.VoiceModel) obj2);
                    this.a.z(true, null);
                }
            } else if (i != 11) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.b.b, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.b.b);
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (j35.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.a.y() != null) {
                                this.a.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.a.y() != null) {
                            this.a.y().setMaxImagesAllowed(9);
                        }
                        pi.x(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) j15Var.c).intValue();
                        if (this.a.y() != null && this.a.y().getChosedFiles() != null && (size = this.a.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.b.d) {
                            pi.N(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d07);
                        }
                        if (this.b.j(this.a.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                            if (this.a.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.a.x().u());
                            }
                            atListActivityConfig.setFromTid(this.b.c);
                            atListActivityConfig.setFromFid(this.b.b);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.addParam("tid", this.b.c);
                            statisticItem.addParam("fid", this.b.b);
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                this.a.w0(null);
            }
        }
    }

    public hb7() {
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
        this.d = false;
    }

    @Override // com.repackage.l15
    public n15 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(this.e ? 2 : 3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setHideBigEmotion(this.e);
            return new gb7(editorTools);
        }
        return (n15) invokeL.objValue;
    }

    @Override // com.repackage.l15
    public void c(n15 n15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n15Var) == null) && (n15Var instanceof gb7)) {
            EditorTools a2 = n15Var.a();
            a aVar = new a(this, (gb7) n15Var);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(16, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(18, aVar);
            a2.setActionListener(20, aVar);
            a2.setActionListener(10, aVar);
            a2.setActionListener(11, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
        }
    }

    @Override // com.repackage.l15
    public void d(n15 n15Var) {
        CustomResponsedMessage runTask;
        u15 u15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n15Var) == null) {
            EditorTools a2 = n15Var.a();
            if (ik8.a() && mh8.a(this.a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), u15.class)) != null && (u15Var = (u15) runTask.getData()) != null) {
                u15Var.l = 2;
                a2.d(u15Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.h(arrayList);
            u15 n = a2.n(5);
            if (n != null) {
                n.e(!this.e);
                n.f(!this.e);
                n.l = this.e ? 1 : 3;
            }
            w15 w15Var = new w15(a2.getContext(), 4);
            w15Var.i = false;
            a2.d(w15Var);
            if (!this.e) {
                a2.d(new g25(a2.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), u15.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    u15 u15Var2 = (u15) runTask2.getData();
                    u15Var2.l = 6;
                    a2.d(u15Var2);
                }
                a2.d(new o35(a2.getContext(), false, true, 12004));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), u15.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    u15 u15Var3 = (u15) runTask3.getData();
                    u15Var3.l = 7;
                    a2.d(u15Var3);
                }
                a2.d(new c25(a2.getContext(), 5));
            } else {
                a2.d(new o35(a2.getContext(), false, false, 12004));
            }
            a2.f();
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            if (p65.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.a = str;
            this.b = str2;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }
}
