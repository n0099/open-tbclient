package d.a.o0.e3.q0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.a.c.e.p.k;
import d.a.n0.r.q.i1;
import d.a.n0.s.c.i0;
import d.a.o0.e3.y;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements NewWriteModel.g {

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f58018a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58019b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f58020c;

    /* renamed from: d  reason: collision with root package name */
    public String f58021d;

    /* renamed from: e  reason: collision with root package name */
    public String f58022e;

    /* renamed from: f  reason: collision with root package name */
    public String f58023f;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58024a = new a();
    }

    public static a f() {
        d.a.o0.e3.q0.b.a("AsyncWriteHelper.getInstance()");
        return b.f58024a;
    }

    public void a() {
        d.a.o0.e3.q0.b.a("AsyncWriteHelper.cancelLoadData()");
        this.f58018a.cancelLoadData();
    }

    public boolean b() {
        d.a.o0.e3.q0.b.a("AsyncWriteHelper.checkImageNum = " + this.f58018a.U());
        return this.f58018a.U();
    }

    public final void c() {
        WriteData j = j();
        if (j == null) {
            return;
        }
        if (j.getType() != 0 && j.getType() != 9 && j.getType() != 11) {
            if (j.getType() == 1) {
                y.p(j.getThreadId(), null);
            }
        } else if (j.isEvaluate()) {
            y.m(j.getItem_id(), null);
        } else if (TextUtils.isEmpty(j.getTopicId())) {
            y.o(j.getForumId(), j, true);
        } else {
            y.r(j.getTopicId(), null);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
        if (writeData == null) {
            return;
        }
        if (z) {
            i1.g(writeData, 100).e(true);
            if ((!k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                c.n(postWriteCallBackData);
            } else {
                c.m(postWriteCallBackData);
            }
            c();
            d();
            n(postWriteCallBackData);
            if (!k.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!k.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            i1.g(writeData, 100).e(false);
        } else {
            i1.g(writeData, 100).e(false);
            c.l(postWriteCallBackData, i0Var, writeData, antiData);
        }
        NewWriteModel newWriteModel = this.f58018a;
        if (newWriteModel != null) {
            newWriteModel.j0(null);
        }
        this.f58019b = false;
    }

    public final void d() {
        FileHelper.deleteFileOrDir(new File(d.a.o0.r3.c.f63811c));
    }

    public BdUniqueId e() {
        return this.f58020c;
    }

    public String g() {
        return this.f58021d;
    }

    public String h() {
        return this.f58022e;
    }

    public String i() {
        return this.f58023f;
    }

    public WriteData j() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.getWriteData = ");
        sb.append(this.f58018a.X() == null ? StringUtil.NULL_STRING : this.f58018a.X().toDraftString());
        d.a.o0.e3.q0.b.a(sb.toString());
        return this.f58018a.X();
    }

    public void k(@NonNull TbPageContextSupport tbPageContextSupport) {
        d.a.o0.e3.q0.b.a("AsyncWriteHelper.initWriteStatus()");
        this.f58018a.i0(tbPageContextSupport.getPageContext());
        this.f58018a.j0(null);
        this.f58018a.d0(false);
    }

    public boolean l() {
        return this.f58019b;
    }

    public void m() {
        d.a.o0.e3.q0.b.a("AsyncWriteHelper.onWriteActClose()");
        this.f58018a.i0(null);
        this.f58018a.setSpanGroupManager(null);
    }

    public final void n(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    public void o(BdUniqueId bdUniqueId) {
        this.f58020c = bdUniqueId;
    }

    public void p(boolean z) {
        d.a.o0.e3.q0.b.a("AsyncWriteHelper.setHasImage = " + z);
        this.f58018a.d0(z);
    }

    public void q(String str) {
        this.f58021d = str;
    }

    public void r(String str) {
        this.f58022e = str;
    }

    public void s(String str) {
        this.f58023f = str;
    }

    public void t(SpanGroupManager spanGroupManager) {
        d.a.o0.e3.q0.b.a("AsyncWriteHelper.setSpanGroupManager()");
        this.f58018a.Y();
        this.f58018a.setSpanGroupManager(spanGroupManager);
    }

    public void u(WriteData writeData) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.setWriteData = ");
        sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
        d.a.o0.e3.q0.b.a(sb.toString());
        this.f58018a.j0(writeData);
    }

    public boolean v() {
        d.a.o0.e3.q0.b.a("AsyncWriteHelper.startPostWrite()");
        this.f58018a.Y();
        boolean k0 = this.f58018a.k0();
        this.f58019b = k0;
        return k0;
    }

    public a() {
        this.f58019b = false;
        this.f58020c = null;
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f58018a = newWriteModel;
        newWriteModel.h0(this);
    }
}
