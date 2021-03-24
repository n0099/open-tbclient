package d.b.i0.c3.q0;

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
import d.b.b.e.p.k;
import d.b.h0.r.q.i1;
import d.b.h0.s.c.f0;
import d.b.i0.c3.y;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements NewWriteModel.g {

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f53574a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53575b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f53576c;

    /* renamed from: d  reason: collision with root package name */
    public String f53577d;

    /* renamed from: e  reason: collision with root package name */
    public String f53578e;

    /* renamed from: f  reason: collision with root package name */
    public String f53579f;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f53580a = new a();
    }

    public static a f() {
        d.b.i0.c3.q0.b.a("AsyncWriteHelper.getInstance()");
        return b.f53580a;
    }

    public void a() {
        d.b.i0.c3.q0.b.a("AsyncWriteHelper.cancelLoadData()");
        this.f53574a.cancelLoadData();
    }

    public boolean b() {
        d.b.i0.c3.q0.b.a("AsyncWriteHelper.checkImageNum = " + this.f53574a.Q());
        return this.f53574a.Q();
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
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
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
            c.l(postWriteCallBackData, f0Var, writeData, antiData);
        }
        this.f53575b = false;
    }

    public final void d() {
        FileHelper.deleteFileOrDir(new File(d.b.i0.p3.c.f58889c));
    }

    public BdUniqueId e() {
        return this.f53576c;
    }

    public String g() {
        return this.f53577d;
    }

    public String h() {
        return this.f53578e;
    }

    public String i() {
        return this.f53579f;
    }

    public WriteData j() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.getWriteData = ");
        sb.append(this.f53574a.T() == null ? StringUtil.NULL_STRING : this.f53574a.T().toDraftString());
        d.b.i0.c3.q0.b.a(sb.toString());
        return this.f53574a.T();
    }

    public void k(@NonNull TbPageContextSupport tbPageContextSupport) {
        d.b.i0.c3.q0.b.a("AsyncWriteHelper.initWriteStatus()");
        this.f53574a.e0(tbPageContextSupport.getPageContext());
        this.f53574a.f0(null);
        this.f53574a.Z(false);
    }

    public boolean l() {
        return this.f53575b;
    }

    public void m() {
        d.b.i0.c3.q0.b.a("AsyncWriteHelper.onWriteActClose()");
        this.f53574a.e0(null);
        this.f53574a.setSpanGroupManager(null);
    }

    public final void n(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    public void o(BdUniqueId bdUniqueId) {
        this.f53576c = bdUniqueId;
    }

    public void p(boolean z) {
        d.b.i0.c3.q0.b.a("AsyncWriteHelper.setHasImage = " + z);
        this.f53574a.Z(z);
    }

    public void q(String str) {
        this.f53577d = str;
    }

    public void r(String str) {
        this.f53578e = str;
    }

    public void s(String str) {
        this.f53579f = str;
    }

    public void t(SpanGroupManager spanGroupManager) {
        d.b.i0.c3.q0.b.a("AsyncWriteHelper.setSpanGroupManager()");
        this.f53574a.U();
        this.f53574a.setSpanGroupManager(spanGroupManager);
    }

    public void u(WriteData writeData) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.setWriteData = ");
        sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
        d.b.i0.c3.q0.b.a(sb.toString());
        this.f53574a.f0(writeData);
    }

    public boolean v() {
        d.b.i0.c3.q0.b.a("AsyncWriteHelper.startPostWrite()");
        this.f53574a.U();
        boolean g0 = this.f53574a.g0();
        this.f53575b = g0;
        return g0;
    }

    public a() {
        this.f53575b = false;
        this.f53576c = null;
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f53574a = newWriteModel;
        newWriteModel.d0(this);
    }
}
