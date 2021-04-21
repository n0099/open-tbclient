package d.b.j0.d3.q0;

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
import d.b.c.e.p.k;
import d.b.i0.r.q.i1;
import d.b.i0.s.c.h0;
import d.b.j0.d3.y;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements NewWriteModel.g {

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f55440a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55441b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f55442c;

    /* renamed from: d  reason: collision with root package name */
    public String f55443d;

    /* renamed from: e  reason: collision with root package name */
    public String f55444e;

    /* renamed from: f  reason: collision with root package name */
    public String f55445f;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f55446a = new a();
    }

    public static a f() {
        d.b.j0.d3.q0.b.a("AsyncWriteHelper.getInstance()");
        return b.f55446a;
    }

    public void a() {
        d.b.j0.d3.q0.b.a("AsyncWriteHelper.cancelLoadData()");
        this.f55440a.cancelLoadData();
    }

    public boolean b() {
        d.b.j0.d3.q0.b.a("AsyncWriteHelper.checkImageNum = " + this.f55440a.Q());
        return this.f55440a.Q();
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
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
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
            c.l(postWriteCallBackData, h0Var, writeData, antiData);
        }
        this.f55441b = false;
    }

    public final void d() {
        FileHelper.deleteFileOrDir(new File(d.b.j0.q3.c.f60979c));
    }

    public BdUniqueId e() {
        return this.f55442c;
    }

    public String g() {
        return this.f55443d;
    }

    public String h() {
        return this.f55444e;
    }

    public String i() {
        return this.f55445f;
    }

    public WriteData j() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.getWriteData = ");
        sb.append(this.f55440a.T() == null ? StringUtil.NULL_STRING : this.f55440a.T().toDraftString());
        d.b.j0.d3.q0.b.a(sb.toString());
        return this.f55440a.T();
    }

    public void k(@NonNull TbPageContextSupport tbPageContextSupport) {
        d.b.j0.d3.q0.b.a("AsyncWriteHelper.initWriteStatus()");
        this.f55440a.e0(tbPageContextSupport.getPageContext());
        this.f55440a.f0(null);
        this.f55440a.Z(false);
    }

    public boolean l() {
        return this.f55441b;
    }

    public void m() {
        d.b.j0.d3.q0.b.a("AsyncWriteHelper.onWriteActClose()");
        this.f55440a.e0(null);
        this.f55440a.setSpanGroupManager(null);
    }

    public final void n(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    public void o(BdUniqueId bdUniqueId) {
        this.f55442c = bdUniqueId;
    }

    public void p(boolean z) {
        d.b.j0.d3.q0.b.a("AsyncWriteHelper.setHasImage = " + z);
        this.f55440a.Z(z);
    }

    public void q(String str) {
        this.f55443d = str;
    }

    public void r(String str) {
        this.f55444e = str;
    }

    public void s(String str) {
        this.f55445f = str;
    }

    public void t(SpanGroupManager spanGroupManager) {
        d.b.j0.d3.q0.b.a("AsyncWriteHelper.setSpanGroupManager()");
        this.f55440a.U();
        this.f55440a.setSpanGroupManager(spanGroupManager);
    }

    public void u(WriteData writeData) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.setWriteData = ");
        sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
        d.b.j0.d3.q0.b.a(sb.toString());
        this.f55440a.f0(writeData);
    }

    public boolean v() {
        d.b.j0.d3.q0.b.a("AsyncWriteHelper.startPostWrite()");
        this.f55440a.U();
        boolean g0 = this.f55440a.g0();
        this.f55441b = g0;
        return g0;
    }

    public a() {
        this.f55441b = false;
        this.f55442c = null;
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f55440a = newWriteModel;
        newWriteModel.d0(this);
    }
}
