package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class z15 extends uz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public String b;
    public String c;
    public boolean d;
    public DataModel<?> e;

    /* loaded from: classes7.dex */
    public class a implements tz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x15 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ z15 c;

        public a(z15 z15Var, x15 x15Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z15Var, x15Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z15Var;
            this.a = x15Var;
            this.b = editorTools;
        }

        @Override // com.repackage.tz4
        public void onAction(sz4 sz4Var) {
            x15 x15Var;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, sz4Var) == null) || (x15Var = this.a) == null || x15Var.a() == null || sz4Var == null) {
                return;
            }
            int i = sz4Var.a;
            if (i == 4) {
                this.a.m0(sz4Var.c.toString());
                Object obj = sz4Var.c;
                if (obj instanceof SpanGroupManager) {
                    this.a.q0((SpanGroupManager) obj);
                }
                this.c.d = false;
            } else if (i == 5) {
                if (this.b.u()) {
                    return;
                }
                TiebaStatic.eventStat(this.b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i == 7) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d0e);
                this.c.d = true;
            } else if (i == 8) {
                if (this.c.k(this.a.getContext(), 11001)) {
                    this.a.L(null, null);
                }
            } else if (i == 10) {
                Object obj2 = sz4Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.t0((VoiceData.VoiceModel) obj2);
                    this.a.z(true, null);
                }
            } else if (i == 11) {
                this.a.t0(null);
            } else if (i == 18) {
                boolean h = ys4.k().h("key_post_thread_has_request_location", false);
                if (sz4Var.c != null) {
                    if (h) {
                        this.a.Q();
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
                this.a.a().A(new sz4(2, 7, null));
                zh8.a().f(true);
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            } else if (i == 29) {
                this.a.a().A(new sz4(2, 19, null));
                this.a.a().A(new sz4(1, 2, null));
                this.a.m();
            } else if (i == 32) {
                this.a.a().A(new sz4(1, 11, null));
            } else if (i == 36) {
                if (this.c.k(this.a.getContext(), 11040)) {
                    this.a.Z();
                }
            } else if (i != 43) {
                switch (i) {
                    case 14:
                        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.y().toJsonString(), true, true);
                        if (!StringUtils.isNull(this.c.c, true)) {
                            albumFloatActivityConfig.getIntent().putExtra("from", this.c.c);
                        }
                        if (this.c.a != null && !StringUtils.isNull(this.c.a.getId(), true)) {
                            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.c.a.getId());
                        }
                        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                        if (t15.a().b() == 1) {
                            albumFloatActivityConfig.setRequestFrom(2);
                            if (this.a.y() != null) {
                                this.a.y().setMaxImagesAllowed(1);
                            }
                        } else if (this.a.y() != null) {
                            this.a.y().setMaxImagesAllowed(9);
                        }
                        li.x(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                        return;
                    case 15:
                        int intValue = ((Integer) sz4Var.c).intValue();
                        if (this.a.y() != null && this.a.y().getChosedFiles() != null && (size = this.a.y().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.y(), intValue)));
                            return;
                        }
                        return;
                    case 16:
                        if (this.c.d) {
                            this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0d0e);
                        }
                        if (this.c.k(this.a.getContext(), 11025)) {
                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                            if (this.a.x() != null) {
                                atListActivityConfig.setSelectedAtList(this.a.x().u());
                            }
                            if (this.c.e != null) {
                                atListActivityConfig.setFromTid(this.c.e.B());
                                atListActivityConfig.setFromFid(this.c.e.getForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            if (this.c.e != null) {
                                statisticItem.addParam("tid", this.c.e.B());
                                statisticItem.addParam("fid", this.c.e.getForumId());
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (sb5.c(this.a.getContext(), true, false)) {
            } else {
                HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                if (this.c.a != null) {
                    hotSelectActivityConfig.setForumExtra(jg.g(this.c.a.getId(), 0L), this.c.a.getFirst_class(), this.c.a.getSecond_class());
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
            }
        }
    }

    public z15() {
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
        this.b = null;
        this.c = null;
        this.d = false;
    }

    @Override // com.repackage.uz4
    public wz4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            editorTools.setMoreButtonAtEnd(true);
            x15 x15Var = new x15(editorTools);
            x15Var.j0(this.e);
            return x15Var;
        }
        return (wz4) invokeL.objValue;
    }

    @Override // com.repackage.uz4
    public void c(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz4Var) == null) && (wz4Var instanceof x15)) {
            EditorTools a2 = wz4Var.a();
            a aVar = new a(this, (x15) wz4Var, a2);
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
            a2.setActionListener(27, aVar);
            a2.setActionListener(29, aVar);
            a2.setActionListener(36, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(43, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // com.repackage.uz4
    public void d(wz4 wz4Var) {
        CustomResponsedMessage runTask;
        e05 e05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wz4Var) == null) {
            EditorTools a2 = wz4Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.d(new q05(a2.getContext(), 1));
            if (ui8.a() && yf8.a(this.b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), e05.class)) != null && (e05Var = (e05) runTask.getData()) != null) {
                e05Var.l = 2;
                a2.d(e05Var);
            }
            g05 g05Var = new g05(a2.getContext(), 4);
            g05Var.i = false;
            a2.d(g05Var);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), e05.class);
            if (runTask2 != null && runTask2.getData() != null) {
                e05 e05Var2 = (e05) runTask2.getData();
                e05Var2.l = 6;
                a2.d(e05Var2);
            }
            a2.d(new y15(a2.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), e05.class);
            if (runTask3 != null && runTask3.getData() != null) {
                e05 e05Var3 = (e05) runTask3.getData();
                e05Var3.l = 7;
                a2.d(e05Var3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.d(new m05(a2.getContext(), 5));
            }
            a2.h(arrayList);
            e05 n = a2.n(5);
            if (n != null) {
                n.l = 3;
            }
            a2.f();
        }
    }

    public final boolean k(TbPageContext<?> tbPageContext, int i) {
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

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (ForumData) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public DataModel<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (DataModel) invokeV.objValue;
    }

    public void o(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.c = str;
        }
    }

    public void r(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.e = dataModel;
        }
    }
}
