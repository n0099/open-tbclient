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
public class gb7 extends n35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean K;
    public String L;
    public String M;
    public String N;
    public PermissionJudgePolicy O;

    /* loaded from: classes6.dex */
    public class a implements k15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb7 a;

        public a(gb7 gb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb7Var;
        }

        @Override // com.repackage.k15
        public void C(j15 j15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) {
                Object obj = j15Var.c;
                if ((obj instanceof lx4) && EmotionGroupType.isSendAsPic(((lx4) obj).getType())) {
                    if (this.a.O == null) {
                        this.a.O = new PermissionJudgePolicy();
                    }
                    this.a.O.clearRequestPermissionList();
                    this.a.O.appendRequestPermission(this.a.n.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.O.startRequestPermission(this.a.n.getPageActivity())) {
                        return;
                    }
                    this.a.h((lx4) j15Var.c);
                    this.a.z(false, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb7(EditorTools editorTools) {
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

    public WriteData E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = new WriteData();
            if (this.k != null) {
                if (this.z && !this.K) {
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
            if (!this.K) {
                writeData.setType(1);
            } else {
                writeData.setType(2);
                writeData.setFloor(this.L);
                writeData.setFloorNum(0);
                writeData.setReplyId(this.M);
                writeData.setRepostId(this.L);
            }
            return writeData;
        }
        return (WriteData) invokeV.objValue;
    }

    @Override // com.repackage.n35
    public void M(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, writeData) == null) {
            if (this.h.V() == null) {
                this.h.setWriteData(E0());
            }
            if (this.h.V() == null) {
                return;
            }
            this.h.setSpanGroupManager(this.d);
            this.h.V().setIsBJHPost(this.v);
            this.h.V().setWriteImagesInfo(this.b);
            boolean z = true;
            this.h.c0(this.b.size() > 0);
            WriteData V = this.h.V();
            LocationModel locationModel = this.g;
            V.setHasLocationData((locationModel == null || !locationModel.D()) ? false : false);
            if (str == null) {
                this.h.V().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.h.V().setVoice(this.e.getId());
                    this.h.V().setVoiceDuringTime(this.e.duration);
                } else {
                    this.h.V().setVoice(null);
                    this.h.V().setVoiceDuringTime(-1);
                }
            } else {
                this.h.V().setVoice(null);
                this.h.V().setVoiceDuringTime(-1);
            }
            if (!this.h.T()) {
                this.n.showToast(R.string.obfuscated_res_0x7f0f15d7);
                return;
            }
            k35 k35Var = this.y;
            if ((k35Var == null || !k35Var.a()) && !this.h.h0()) {
            }
        }
    }

    @Override // com.repackage.n35
    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            WriteData V = this.h.V();
            if (V == null) {
                V = new WriteData(this.K ? 2 : 1);
                V.setThreadId(str);
                V.setWriteImagesInfo(this.b);
            }
            if (!oi.isEmpty(this.N)) {
                V.setFromForumId(this.N);
            }
            V.setContent(this.c);
            V.setVoiceModel(this.e);
            if (this.K) {
                V.setReplyId(this.M);
                V.setThreadId(this.L);
                rh8.x(this.L, V);
                return;
            }
            rh8.w(str, V);
        }
    }

    @Override // com.repackage.n35
    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.K) {
                rh8.o(this.L, this);
            } else {
                rh8.n(str, this);
            }
        }
    }

    @Override // com.repackage.n35
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.K ? 1 : 0);
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
            threadData.setPostId(this.L);
            threadData.setThreadId(this.m);
            threadData.isBJH = this.v;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.o);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.n.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }
}
