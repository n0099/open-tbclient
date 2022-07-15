package com.repackage;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.rh8;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class r35 extends n15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public t35 c;
    public String d;
    public String e;
    public String f;
    public VoiceData.VoiceModel g;
    public NewWriteModel h;
    public SpanGroupManager i;
    public DataModel<?> j;
    public boolean k;
    public l35 l;
    public k35 m;
    public NewWriteModel.e n;
    public String o;
    public o35 p;
    public ThreadData q;
    public rh8.f r;
    public boolean s;
    public int t;
    public int u;
    public NewWriteModel.e v;
    public AntiHelper.k w;
    public View.OnClickListener x;

    /* loaded from: classes7.dex */
    public class a implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r35 a;

        public a(r35 r35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r35Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, fy4 fy4Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, fy4Var, writeData, antiData}) == null) {
                if (this.a.n != null) {
                    this.a.n.callback(z, postWriteCallBackData, fy4Var, writeData, antiData);
                }
                if (z) {
                    this.a.c = null;
                    this.a.d = null;
                    this.a.K(true);
                    this.a.q();
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z && this.a.q != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
                    statisticItem.param("tid", this.a.q.getId());
                    statisticItem.param("fid", this.a.q.getFid());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_type", 2);
                    p85 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.b.getPageActivity());
                    if (currentVisiblePageExtra != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                    }
                    if (this.a.u != 0) {
                        if (this.a.u != 1) {
                            if (this.a.u != 2) {
                                if (this.a.u != 3) {
                                    if (this.a.u != 4) {
                                        if (this.a.u != 5) {
                                            if (this.a.u == 6) {
                                                statisticItem.param("obj_locate", 7);
                                            }
                                        } else {
                                            statisticItem.param("obj_locate", 1);
                                        }
                                    } else {
                                        statisticItem.param("obj_locate", 3);
                                    }
                                } else {
                                    statisticItem.param("obj_locate", 2);
                                }
                            } else {
                                statisticItem.param("obj_locate", 5);
                            }
                        } else {
                            statisticItem.param("obj_locate", 4);
                        }
                    } else {
                        statisticItem.param("obj_locate", 6);
                    }
                    if (this.a.q.isVideoThreadType()) {
                        String content = writeData != null ? writeData.getContent() : "";
                        if (je5.d(content) > 40) {
                            content = je5.n(content, 40);
                        }
                        statisticItem.param(TiebaStatic.Params.POST_CONTENT, content);
                    }
                    TiebaStatic.log(statisticItem);
                }
                if (z && this.a.q != null) {
                    StatisticItem statisticItem2 = new StatisticItem("c14303");
                    statisticItem2.param("tid", this.a.q.getId());
                    statisticItem2.param("fid", this.a.q.getFid());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_type", 2);
                    if (this.a.u != 1) {
                        if (this.a.u != 2) {
                            if (this.a.u != 3) {
                                if (this.a.u == 4) {
                                    statisticItem2.param("obj_locate", 4);
                                }
                            } else {
                                statisticItem2.param("obj_locate", 3);
                            }
                        } else {
                            statisticItem2.param("obj_locate", 2);
                        }
                    } else {
                        statisticItem2.param("obj_locate", 1);
                    }
                    TiebaStatic.log(statisticItem2);
                }
                if (z) {
                    WriteData V = this.a.h.V();
                    this.a.h.setWriteData(null);
                    this.a.h.c0(false);
                    this.a.g = null;
                    if (V == null || V == null || V.getType() != 2) {
                        return;
                    }
                    this.a.j.L();
                } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                    if (fy4Var == null || writeData == null || StringUtils.isNull(fy4Var.c())) {
                        if (postWriteCallBackData != null && i == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.b.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else if (i == 238010 || dp8.d(i)) {
                            return;
                        } else {
                            this.a.getContext().showToast(str);
                            return;
                        }
                    }
                    writeData.setVcodeMD5(fy4Var.b());
                    writeData.setVcodeUrl(fy4Var.c());
                    writeData.setVcodeExtra(fy4Var.a());
                    if (this.a.q != null) {
                        writeData.setBaijiahaoData(this.a.q.getBaijiahaoData());
                    }
                    if (ve5.b(fy4Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, fy4Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                    }
                } else {
                    this.a.e0(i, str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(r35 r35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements rh8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r35 a;

        public c(r35 r35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r35Var;
        }

        @Override // com.repackage.rh8.f
        public void i0(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                    if (this.a.c == null) {
                        this.a.c = new t35();
                    }
                    this.a.c.a = writeData.getContent();
                    this.a.c.b = writeData.getSubPbReplyPrefix();
                    this.a.c.d = writeData.getPortrait();
                    this.a.c.e = writeData.getName();
                    r35 r35Var = this.a;
                    r35Var.L(r35Var.c);
                }
                if (this.a.r != null) {
                    this.a.r.i0(writeData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r35 a;

        public d(r35 r35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r35Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.o)) {
                return;
            }
            pi.O(this.a.getContext().getPageActivity(), this.a.o);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(r35 r35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r35(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.k = false;
        this.o = null;
        this.t = 0;
        this.u = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new d(this);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void B(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) || writeData == null) {
            return;
        }
        if (this.c == null) {
            this.c = new t35();
        }
        this.c.a = writeData.getContent();
        this.c.b = writeData.getSubPbReplyPrefix();
        this.c.d = writeData.getPortrait();
        this.c.e = writeData.getName();
        L(this.c);
    }

    public void C(int i, int i2, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i2 != -1) {
                if (i2 == 0 && i == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.e eVar = this.n;
                    if (eVar != null) {
                        eVar.callback(false, postWriteCallBackData2, null, this.h.V(), null);
                    }
                }
            } else if (i == 12005) {
                if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                    return;
                }
                J(parcelableArrayListExtra);
            } else if (i != 12006) {
            } else {
                if (a() != null) {
                    a().o();
                }
                q();
                K(true);
                WriteData V = this.h.V();
                this.h.setWriteData(null);
                this.h.c0(false);
                if (V == null || V == null || V.getType() != 2) {
                    return;
                }
                this.j.L();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            I();
            this.h.cancelLoadData();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void F() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.h.V() == null) {
                DataModel<?> dataModel = this.j;
                WriteData H = dataModel.H(dataModel.C());
                if (H != null && (threadData = this.q) != null) {
                    H.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.h.setWriteData(H);
            }
            if (this.h.V() == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            this.h.setSpanGroupManager(this.i);
            if (this.c != null) {
                this.h.V().setContent(this.c.a);
                this.h.V().setSubPbReplyPrefix(this.c.b);
                this.h.V().setPortrait(this.c.d);
                this.h.V().setName(this.c.e);
                if (this.q != null) {
                    this.h.V().setBaijiahaoData(this.q.getBaijiahaoData());
                }
            }
            this.h.V().setReplyId(this.d);
            if (this.e != null) {
                this.h.V().setRepostId(this.j.C());
            }
            if (this.f != null) {
                this.h.V().setReSubPostId(this.f);
            }
            VoiceData.VoiceModel voiceModel = this.g;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.h.V().setVoice(this.g.getId());
                    this.h.V().setVoiceDuringTime(this.g.duration);
                } else {
                    this.h.V().setVoice(null);
                    this.h.V().setVoiceDuringTime(-1);
                }
            } else {
                this.h.V().setVoice(null);
                this.h.V().setVoiceDuringTime(-1);
            }
            if (!this.h.T()) {
                getContext().showToast((int) R.string.obfuscated_res_0x7f0f15d7);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 12).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            k35 k35Var = this.m;
            if (k35Var != null && k35Var.a()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            l35 l35Var = this.l;
            if (l35Var != null) {
                l35Var.a();
            }
            s(this.h.V());
            r();
            if (!this.h.h0()) {
            }
        }
    }

    public void G(AntiData antiData) {
        q15 m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, antiData) == null) || antiData == null) {
            return;
        }
        String voice_message = antiData.getVoice_message();
        this.o = voice_message;
        if (StringUtils.isNull(voice_message) || a() == null || (m = a().m(6)) == null || TextUtils.isEmpty(this.o)) {
            return;
        }
        ((View) m).setOnClickListener(this.x);
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h.setWriteData(null);
            this.h.c0(false);
            this.g = null;
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WriteData writeData = new WriteData(2);
            t35 t35Var = this.c;
            if (t35Var != null) {
                writeData.setContent(t35Var.a);
                writeData.setPortrait(this.c.d);
                writeData.setName(this.c.e);
                writeData.setSubPbReplyPrefix(this.c.b);
            }
            writeData.setReplyId(this.d);
            writeData.setThreadId(this.e);
            rh8.x(this.e, writeData);
        }
    }

    public final void J(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new j15(17, 27, arrayList));
    }

    public final void K(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || a() == null) {
            return;
        }
        a().A(new j15(9, -1, Boolean.valueOf(z)));
    }

    public final void L(t35 t35Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, t35Var) == null) || a() == null) {
            return;
        }
        a().A(new j15(6, 27, t35Var));
    }

    public void M(k35 k35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, k35Var) == null) {
            this.m = k35Var;
        }
    }

    public void N(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.t = i;
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.u = i;
        }
    }

    public void Q(NewWriteModel.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void R(rh8.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            this.r = fVar;
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (this.c == null) {
                this.c = new t35();
            }
            this.c.a = str;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.e = str;
        }
    }

    public void U(l35 l35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, l35Var) == null) {
            this.l = l35Var;
        }
    }

    public void V(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fcb).replace("%s", str);
        t35 t35Var = this.c;
        if (t35Var != null) {
            if (TextUtils.isEmpty(t35Var.b) && TextUtils.isEmpty(this.c.a)) {
                l0(str, str2);
                return;
            } else if (!TextUtils.isEmpty(this.c.b) && this.c.b.equals(replace)) {
                g0(this.c);
                return;
            } else {
                l0(str, str2);
                return;
            }
        }
        l0(str, str2);
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.d = str;
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.k = z;
        }
    }

    public void Y(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, spanGroupManager) == null) {
            this.i = spanGroupManager;
        }
    }

    public void Z(t35 t35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, t35Var) == null) {
            this.c = t35Var;
        }
    }

    public void a0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dataModel) == null) {
            this.j = dataModel;
            if (dataModel != null) {
                this.e = dataModel.C();
            }
        }
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f = str;
        }
    }

    public void c0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, threadData) == null) {
            this.q = threadData;
            if (a() == null || this.q == null) {
                return;
            }
            a().setFid(this.q.getFid());
            a().setTid(this.q.getTid());
        }
    }

    public void d0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, voiceModel) == null) {
            this.g = voiceModel;
        }
    }

    public void e0(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                if (AntiHelper.w(this.b.getPageActivity(), str, i, this.w) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i != 230277 && i != 230278) {
                getContext().showToast(str);
            } else {
                j0(str);
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            X(true);
            a().k(false, false);
            a().x((View) a().m(5));
        }
    }

    public final void g0(t35 t35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, t35Var) == null) {
            X(true);
            a().j();
            L(t35Var);
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.b : (TbPageContext) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            X(true);
            a().j();
            a().x((View) a().m(2));
        }
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            cr4 cr4Var = new cr4(getContext().getPageActivity());
            cr4Var.setMessage(str);
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f099e, new e(this));
            cr4Var.create(getContext()).show();
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            X(true);
            a().j();
        }
    }

    public void l0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            X(true);
            a().j();
            if (str != null && str.length() != 0) {
                String replace = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0fcb).replace("%s", str);
                t35 t35Var = new t35();
                t35Var.b = replace;
                t35Var.d = str2;
                t35Var.e = str;
                L(t35Var);
            } else {
                t35 t35Var2 = new t35();
                t35Var2.a = "";
                L(t35Var2);
            }
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, str) == null) || StringUtils.isNull(str) || a() == null) {
            return;
        }
        a().A(new j15(45, 27, str));
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            rh8.x(this.e, null);
        }
    }

    public final void r() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.q == null || (dataModel = this.j) == null || !dataModel.J()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
        statisticItem.addParam("obj_locate", 2);
        if (this.q.isVideoWorksInfo()) {
            statisticItem.addParam("obj_type", 3);
        } else if (this.q.isVideoThreadType()) {
            statisticItem.addParam("obj_type", 2);
        } else {
            statisticItem.addParam("obj_type", 1);
        }
        statisticItem.addParam("tid", this.q.getTid());
        statisticItem.addParam(TiebaStatic.Params.FID_1, this.q.getFid());
        statisticItem.addParam(TiebaStatic.Params.FID_2, this.j.A());
        statisticItem.addParam("order_id", this.j.F());
        TiebaStatic.log(statisticItem);
        pk4.a(pk4.f, pk4.c, this.j.F(), this.j.G(), this.j.E(), this.j.B());
    }

    public void s(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, writeData) == null) || writeData == null) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i2 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i2++;
            }
            if (i2 > 0 && this.t > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_source", this.t);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i++;
            }
        }
        if (i <= 0 || this.t <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i);
        statisticItem2.param("obj_source", this.t);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public o35 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.p == null && a() != null) {
                this.p = (o35) a().n(27);
            }
            return this.p;
        }
        return (o35) invokeV.objValue;
    }

    public SpanGroupManager u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.i : (SpanGroupManager) invokeV.objValue;
    }

    public void v(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(1);
            t35 t35Var = this.c;
            if (t35Var != null) {
                pbEditorData.setContent(t35Var.a);
                pbEditorData.setSubPbReplyPrefix(this.c.b);
            }
            pbEditorData.setVoiceModel(this.g);
            pbEditorData.setThreadData(new PbEditorData.ThreadData());
            pbEditorData.setDisableVoiceMessage(this.o);
            pbEditorData.setOpenVoiceRecordButton(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.b.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            t35 t35Var = this.c;
            return (t35Var == null || oi.isEmpty(t35Var.a)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.g;
            return (voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || this.g.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            b0(null);
            X(false);
            a().o();
        }
    }

    public void z(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.h = newWriteModel;
        newWriteModel.e0(this.v);
        rh8.o(this.j.C(), new c(this));
    }
}
