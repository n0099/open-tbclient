package d.b.i0.f1.k;

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
import d.b.b.e.p.k;
import d.b.h0.s.c.t;
import d.b.h0.w.w.e;
import d.b.i0.c3.y;
/* loaded from: classes3.dex */
public class a extends e {
    public boolean N;
    public String O;
    public String P;
    public String Q;
    public PermissionJudgePolicy R;

    /* renamed from: d.b.i0.f1.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1248a implements d.b.h0.w.b {
        public C1248a() {
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            Object obj = aVar.f51526c;
            if (obj instanceof t) {
                if (((t) obj).e() == EmotionGroupType.BIG_EMOTION || ((t) aVar.f51526c).e() == EmotionGroupType.USER_COLLECT) {
                    if (a.this.R == null) {
                        a.this.R = new PermissionJudgePolicy();
                    }
                    a.this.R.clearRequestPermissionList();
                    a.this.R.appendRequestPermission(a.this.r.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (a.this.R.startRequestPermission(a.this.r.getPageActivity())) {
                        return;
                    }
                    a.this.h((t) aVar.f51526c);
                    a.this.z(false, null);
                }
            }
        }
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        editorTools.setActionListener(24, new C1248a());
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

    @Override // d.b.h0.w.w.e
    public void L(String str, WriteData writeData) {
        if (this.l.T() == null) {
            this.l.f0(A0());
        }
        if (this.l.T() == null) {
            return;
        }
        this.l.setSpanGroupManager(this.f51579h);
        this.l.T().setIsBJHPost(this.z);
        this.l.T().setWriteImagesInfo(this.f51577f);
        boolean z = true;
        this.l.Z(this.f51577f.size() > 0);
        WriteData T = this.l.T();
        LocationModel locationModel = this.k;
        T.setHasLocationData((locationModel == null || !locationModel.v()) ? false : false);
        if (str == null) {
            this.l.T().setContent(this.f51578g);
        }
        VoiceData$VoiceModel voiceData$VoiceModel = this.i;
        if (voiceData$VoiceModel != null) {
            if (voiceData$VoiceModel.getId() != null) {
                this.l.T().setVoice(this.i.getId());
                this.l.T().setVoiceDuringTime(this.i.duration);
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
        d.b.h0.w.w.b bVar = this.C;
        if ((bVar == null || !bVar.a()) && !this.l.i0()) {
        }
    }

    @Override // d.b.h0.w.w.e
    public void U(String str) {
        WriteData T = this.l.T();
        if (T == null) {
            T = new WriteData(this.N ? 2 : 1);
            T.setThreadId(str);
            T.setWriteImagesInfo(this.f51577f);
        }
        if (!k.isEmpty(this.Q)) {
            T.setFromForumId(this.Q);
        }
        T.setContent(this.f51578g);
        T.setVoiceModel(this.i);
        if (this.N) {
            T.setReplyId(this.P);
            T.setThreadId(this.O);
            y.q(this.O, T);
            return;
        }
        y.p(str, T);
    }

    @Override // d.b.h0.w.w.e
    public void s(String str) {
        if (this.N) {
            y.j(this.O, this);
        } else {
            y.i(str, this);
        }
    }

    @Override // d.b.h0.w.w.e
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.N ? 1 : 0);
        pbEditorData.setContent(this.f51578g);
        pbEditorData.setWriteImagesInfo(this.f51577f);
        pbEditorData.setVoiceModel(this.i);
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
