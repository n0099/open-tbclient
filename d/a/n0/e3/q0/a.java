package d.a.n0.e3.q0;

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
import d.a.m0.r.q.i1;
import d.a.m0.s.c.i0;
import d.a.n0.e3.y;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements NewWriteModel.g {

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f54204a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54205b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f54206c;

    /* renamed from: d  reason: collision with root package name */
    public String f54207d;

    /* renamed from: e  reason: collision with root package name */
    public String f54208e;

    /* renamed from: f  reason: collision with root package name */
    public String f54209f;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f54210a = new a();
    }

    public static a f() {
        d.a.n0.e3.q0.b.a("AsyncWriteHelper.getInstance()");
        return b.f54210a;
    }

    public void a() {
        d.a.n0.e3.q0.b.a("AsyncWriteHelper.cancelLoadData()");
        this.f54204a.cancelLoadData();
    }

    public boolean b() {
        d.a.n0.e3.q0.b.a("AsyncWriteHelper.checkImageNum = " + this.f54204a.Q());
        return this.f54204a.Q();
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
        NewWriteModel newWriteModel = this.f54204a;
        if (newWriteModel != null) {
            newWriteModel.f0(null);
        }
        this.f54205b = false;
    }

    public final void d() {
        FileHelper.deleteFileOrDir(new File(d.a.n0.r3.c.f59995c));
    }

    public BdUniqueId e() {
        return this.f54206c;
    }

    public String g() {
        return this.f54207d;
    }

    public String h() {
        return this.f54208e;
    }

    public String i() {
        return this.f54209f;
    }

    public WriteData j() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.getWriteData = ");
        sb.append(this.f54204a.T() == null ? StringUtil.NULL_STRING : this.f54204a.T().toDraftString());
        d.a.n0.e3.q0.b.a(sb.toString());
        return this.f54204a.T();
    }

    public void k(@NonNull TbPageContextSupport tbPageContextSupport) {
        d.a.n0.e3.q0.b.a("AsyncWriteHelper.initWriteStatus()");
        this.f54204a.e0(tbPageContextSupport.getPageContext());
        this.f54204a.f0(null);
        this.f54204a.Z(false);
    }

    public boolean l() {
        return this.f54205b;
    }

    public void m() {
        d.a.n0.e3.q0.b.a("AsyncWriteHelper.onWriteActClose()");
        this.f54204a.e0(null);
        this.f54204a.setSpanGroupManager(null);
    }

    public final void n(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    public void o(BdUniqueId bdUniqueId) {
        this.f54206c = bdUniqueId;
    }

    public void p(boolean z) {
        d.a.n0.e3.q0.b.a("AsyncWriteHelper.setHasImage = " + z);
        this.f54204a.Z(z);
    }

    public void q(String str) {
        this.f54207d = str;
    }

    public void r(String str) {
        this.f54208e = str;
    }

    public void s(String str) {
        this.f54209f = str;
    }

    public void t(SpanGroupManager spanGroupManager) {
        d.a.n0.e3.q0.b.a("AsyncWriteHelper.setSpanGroupManager()");
        this.f54204a.U();
        this.f54204a.setSpanGroupManager(spanGroupManager);
    }

    public void u(WriteData writeData) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.setWriteData = ");
        sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
        d.a.n0.e3.q0.b.a(sb.toString());
        this.f54204a.f0(writeData);
    }

    public boolean v() {
        d.a.n0.e3.q0.b.a("AsyncWriteHelper.startPostWrite()");
        this.f54204a.U();
        boolean g0 = this.f54204a.g0();
        this.f54205b = g0;
        return g0;
    }

    public a() {
        this.f54205b = false;
        this.f54206c = null;
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f54204a = newWriteModel;
        newWriteModel.d0(this);
    }
}
