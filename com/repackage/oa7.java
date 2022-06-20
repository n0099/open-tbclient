package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class oa7 extends m25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean J;
    public String K;
    public String L;
    public String M;
    public PermissionJudgePolicy N;

    /* loaded from: classes6.dex */
    public class a implements i05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa7 a;

        public a(oa7 oa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oa7Var;
        }

        @Override // com.repackage.i05
        public void C(h05 h05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h05Var) == null) {
                Object obj = h05Var.c;
                if ((obj instanceof nw4) && EmotionGroupType.isSendAsPic(((nw4) obj).getType())) {
                    if (this.a.N == null) {
                        this.a.N = new PermissionJudgePolicy();
                    }
                    this.a.N.clearRequestPermissionList();
                    this.a.N.appendRequestPermission(this.a.n.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.N.startRequestPermission(this.a.n.getPageActivity())) {
                        return;
                    }
                    this.a.h((nw4) h05Var.c);
                    this.a.z(false, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oa7(EditorTools editorTools) {
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
        editorTools.setActionListener(24, new a(this));
    }

    public WriteData C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = new WriteData();
            if (this.k != null) {
                if (this.z && !this.J) {
                    writeData.setCanNoForum(true);
                    writeData.setVForumId(this.k.getId());
                    writeData.setVForumName(this.k.getName());
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setCanNoForum(false);
                    writeData.setVForumId("");
                    writeData.setVForumName("");
                    writeData.setForumId(this.k.getId());
                    writeData.setForumName(this.k.getName());
                }
            }
            writeData.setThreadId(this.m);
            if (!this.J) {
                writeData.setType(1);
            } else {
                writeData.setType(2);
                writeData.setFloor(this.K);
                writeData.setFloorNum(0);
                writeData.setReplyId(this.L);
                writeData.setRepostId(this.K);
            }
            return writeData;
        }
        return (WriteData) invokeV.objValue;
    }

    @Override // com.repackage.m25
    public void L(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, writeData) == null) {
            if (this.h.T() == null) {
                this.h.setWriteData(C0());
            }
            if (this.h.T() == null) {
                return;
            }
            this.h.setSpanGroupManager(this.d);
            this.h.T().setIsBJHPost(this.v);
            this.h.T().setWriteImagesInfo(this.b);
            boolean z = true;
            this.h.a0(this.b.size() > 0);
            WriteData T = this.h.T();
            LocationModel locationModel = this.g;
            T.setHasLocationData((locationModel == null || !locationModel.C()) ? false : false);
            if (str == null) {
                this.h.T().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.h.T().setVoice(this.e.getId());
                    this.h.T().setVoiceDuringTime(this.e.duration);
                } else {
                    this.h.T().setVoice(null);
                    this.h.T().setVoiceDuringTime(-1);
                }
            } else {
                this.h.T().setVoice(null);
                this.h.T().setVoiceDuringTime(-1);
            }
            if (!this.h.R()) {
                this.n.showToast(R.string.obfuscated_res_0x7f0f15d3);
                return;
            }
            j25 j25Var = this.y;
            if ((j25Var == null || !j25Var.a()) && !this.h.f0()) {
            }
        }
    }

    @Override // com.repackage.m25
    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            WriteData T = this.h.T();
            if (T == null) {
                T = new WriteData(this.J ? 2 : 1);
                T.setThreadId(str);
                T.setWriteImagesInfo(this.b);
            }
            if (!oi.isEmpty(this.M)) {
                T.setFromForumId(this.M);
            }
            T.setContent(this.c);
            T.setVoiceModel(this.e);
            if (this.J) {
                T.setReplyId(this.L);
                T.setThreadId(this.K);
                wg8.x(this.K, T);
                return;
            }
            wg8.w(str, T);
        }
    }

    @Override // com.repackage.m25
    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.J) {
                wg8.o(this.K, this);
            } else {
                wg8.n(str, this);
            }
        }
    }

    @Override // com.repackage.m25
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.J ? 1 : 0);
            pbEditorData.setContent(this.c);
            pbEditorData.setWriteImagesInfo(this.b);
            pbEditorData.setVoiceModel(this.e);
            PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
            ForumData forumData = this.k;
            if (forumData != null) {
                threadData.setForumId(forumData.getId());
                threadData.setForumName(this.k.getName());
                threadData.setFirstDir(this.k.getFirst_class());
                threadData.setSecondDir(this.k.getSecond_class());
            }
            threadData.setAuthorId(this.r);
            threadData.setAuthorName(this.p);
            threadData.setAuthorNameShow(this.q);
            threadData.setPostId(this.K);
            threadData.setThreadId(this.m);
            threadData.isBJH = this.v;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.o);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.n.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }
}
