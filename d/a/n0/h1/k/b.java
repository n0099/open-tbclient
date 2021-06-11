package d.a.n0.h1.k;

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
import d.a.m0.s.c.v;
import d.a.m0.w.w.e;
import d.a.n0.e3.y;
/* loaded from: classes4.dex */
public class b extends e {
    public boolean N;
    public String O;
    public String P;
    public String Q;
    public PermissionJudgePolicy R;

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.w.b {
        public a() {
        }

        @Override // d.a.m0.w.b
        public void onAction(d.a.m0.w.a aVar) {
            Object obj = aVar.f54520c;
            if (obj instanceof v) {
                if (((v) obj).f() == EmotionGroupType.BIG_EMOTION || ((v) aVar.f54520c).f() == EmotionGroupType.USER_COLLECT) {
                    if (b.this.R == null) {
                        b.this.R = new PermissionJudgePolicy();
                    }
                    b.this.R.clearRequestPermissionList();
                    b.this.R.appendRequestPermission(b.this.r.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (b.this.R.startRequestPermission(b.this.r.getPageActivity())) {
                        return;
                    }
                    b.this.h((v) aVar.f54520c);
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

    @Override // d.a.m0.w.w.e
    public void L(String str, WriteData writeData) {
        if (this.l.X() == null) {
            this.l.j0(A0());
        }
        if (this.l.X() == null) {
            return;
        }
        this.l.setSpanGroupManager(this.f54575h);
        this.l.X().setIsBJHPost(this.z);
        this.l.X().setWriteImagesInfo(this.f54573f);
        boolean z = true;
        this.l.d0(this.f54573f.size() > 0);
        WriteData X = this.l.X();
        LocationModel locationModel = this.k;
        X.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
        if (str == null) {
            this.l.X().setContent(this.f54574g);
        }
        VoiceData$VoiceModel voiceData$VoiceModel = this.f54576i;
        if (voiceData$VoiceModel != null) {
            if (voiceData$VoiceModel.getId() != null) {
                this.l.X().setVoice(this.f54576i.getId());
                this.l.X().setVoiceDuringTime(this.f54576i.duration);
            } else {
                this.l.X().setVoice(null);
                this.l.X().setVoiceDuringTime(-1);
            }
        } else {
            this.l.X().setVoice(null);
            this.l.X().setVoiceDuringTime(-1);
        }
        if (!this.l.U()) {
            this.r.showToast(R.string.write_img_limit);
            return;
        }
        d.a.m0.w.w.b bVar = this.C;
        if ((bVar == null || !bVar.a()) && !this.l.m0()) {
        }
    }

    @Override // d.a.m0.w.w.e
    public void U(String str) {
        WriteData X = this.l.X();
        if (X == null) {
            X = new WriteData(this.N ? 2 : 1);
            X.setThreadId(str);
            X.setWriteImagesInfo(this.f54573f);
        }
        if (!k.isEmpty(this.Q)) {
            X.setFromForumId(this.Q);
        }
        X.setContent(this.f54574g);
        X.setVoiceModel(this.f54576i);
        if (this.N) {
            X.setReplyId(this.P);
            X.setThreadId(this.O);
            y.q(this.O, X);
            return;
        }
        y.p(str, X);
    }

    @Override // d.a.m0.w.w.e
    public void s(String str) {
        if (this.N) {
            y.j(this.O, this);
        } else {
            y.i(str, this);
        }
    }

    @Override // d.a.m0.w.w.e
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.N ? 1 : 0);
        pbEditorData.setContent(this.f54574g);
        pbEditorData.setWriteImagesInfo(this.f54573f);
        pbEditorData.setVoiceModel(this.f54576i);
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
