package d.a.k0.g1.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.k;
import d.a.j0.s.c.v;
import d.a.j0.w.w.e;
import d.a.k0.d3.y;
/* loaded from: classes4.dex */
public class b extends e {
    public boolean N;
    public String O;
    public String P;
    public String Q;
    public PermissionJudgePolicy R;

    /* loaded from: classes4.dex */
    public class a implements d.a.j0.w.b {
        public a() {
        }

        @Override // d.a.j0.w.b
        public void onAction(d.a.j0.w.a aVar) {
            Object obj = aVar.f50770c;
            if (obj instanceof v) {
                if (((v) obj).e() == EmotionGroupType.BIG_EMOTION || ((v) aVar.f50770c).e() == EmotionGroupType.USER_COLLECT) {
                    if (b.this.R == null) {
                        b.this.R = new PermissionJudgePolicy();
                    }
                    b.this.R.clearRequestPermissionList();
                    b.this.R.appendRequestPermission(b.this.r.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (b.this.R.startRequestPermission(b.this.r.getPageActivity())) {
                        return;
                    }
                    b.this.h((v) aVar.f50770c);
                    b.this.z(false, null);
                }
            }
        }
    }

    public b(EditorTools editorTools) {
        super(editorTools);
        editorTools.setActionListener(24, new a());
    }

    public WriteData A0() {
        WriteData writeData = new WriteData();
        if (this.o != null) {
            if (this.D && !this.N) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.o.getId());
                writeData.setVForumName(this.o.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.o.getId());
                writeData.setForumName(this.o.getName());
            }
        }
        writeData.setThreadId(this.q);
        if (!this.N) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.O);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.P);
            writeData.setRepostId(this.O);
        }
        return writeData;
    }

    @Override // d.a.j0.w.w.e
    public void L(String str, WriteData writeData) {
        if (this.l.T() == null) {
            this.l.f0(A0());
        }
        if (this.l.T() == null) {
            return;
        }
        this.l.setSpanGroupManager(this.f50825h);
        this.l.T().setIsBJHPost(this.z);
        this.l.T().setWriteImagesInfo(this.f50823f);
        boolean z = true;
        this.l.Z(this.f50823f.size() > 0);
        WriteData T = this.l.T();
        LocationModel locationModel = this.k;
        T.setHasLocationData((locationModel == null || !locationModel.v()) ? false : false);
        if (str == null) {
            this.l.T().setContent(this.f50824g);
        }
        VoiceData$VoiceModel voiceData$VoiceModel = this.f50826i;
        if (voiceData$VoiceModel != null) {
            if (voiceData$VoiceModel.getId() != null) {
                this.l.T().setVoice(this.f50826i.getId());
                this.l.T().setVoiceDuringTime(this.f50826i.duration);
            } else {
                this.l.T().setVoice(null);
                this.l.T().setVoiceDuringTime(-1);
            }
        } else {
            this.l.T().setVoice(null);
            this.l.T().setVoiceDuringTime(-1);
        }
        if (!this.l.Q()) {
            this.r.showToast(R.string.write_img_limit);
            return;
        }
        d.a.j0.w.w.b bVar = this.C;
        if ((bVar == null || !bVar.a()) && !this.l.i0()) {
        }
    }

    @Override // d.a.j0.w.w.e
    public void U(String str) {
        WriteData T = this.l.T();
        if (T == null) {
            T = new WriteData(this.N ? 2 : 1);
            T.setThreadId(str);
            T.setWriteImagesInfo(this.f50823f);
        }
        if (!k.isEmpty(this.Q)) {
            T.setFromForumId(this.Q);
        }
        T.setContent(this.f50824g);
        T.setVoiceModel(this.f50826i);
        if (this.N) {
            T.setReplyId(this.P);
            T.setThreadId(this.O);
            y.q(this.O, T);
            return;
        }
        y.p(str, T);
    }

    @Override // d.a.j0.w.w.e
    public void s(String str) {
        if (this.N) {
            y.j(this.O, this);
        } else {
            y.i(str, this);
        }
    }

    @Override // d.a.j0.w.w.e
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.N ? 1 : 0);
        pbEditorData.setContent(this.f50824g);
        pbEditorData.setWriteImagesInfo(this.f50823f);
        pbEditorData.setVoiceModel(this.f50826i);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        ForumData forumData = this.o;
        if (forumData != null) {
            threadData.setForumId(forumData.getId());
            threadData.setForumName(this.o.getName());
            threadData.setFirstDir(this.o.getFirst_class());
            threadData.setSecondDir(this.o.getSecond_class());
        }
        threadData.setAuthorId(this.v);
        threadData.setAuthorName(this.t);
        threadData.setAuthorNameShow(this.u);
        threadData.setPostId(this.O);
        threadData.setThreadId(this.q);
        threadData.isBJH = this.z;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.s);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.r.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }
}
