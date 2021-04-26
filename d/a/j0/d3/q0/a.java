package d.a.j0.d3.q0;

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
import d.a.i0.r.q.i1;
import d.a.i0.s.c.h0;
import d.a.j0.d3.y;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements NewWriteModel.g {

    /* renamed from: a  reason: collision with root package name */
    public final NewWriteModel f53284a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53285b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f53286c;

    /* renamed from: d  reason: collision with root package name */
    public String f53287d;

    /* renamed from: e  reason: collision with root package name */
    public String f53288e;

    /* renamed from: f  reason: collision with root package name */
    public String f53289f;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f53290a = new a();
    }

    public static a f() {
        d.a.j0.d3.q0.b.a("AsyncWriteHelper.getInstance()");
        return b.f53290a;
    }

    public void a() {
        d.a.j0.d3.q0.b.a("AsyncWriteHelper.cancelLoadData()");
        this.f53284a.cancelLoadData();
    }

    public boolean b() {
        d.a.j0.d3.q0.b.a("AsyncWriteHelper.checkImageNum = " + this.f53284a.Q());
        return this.f53284a.Q();
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
        this.f53285b = false;
    }

    public final void d() {
        FileHelper.deleteFileOrDir(new File(d.a.j0.q3.c.f59109c));
    }

    public BdUniqueId e() {
        return this.f53286c;
    }

    public String g() {
        return this.f53287d;
    }

    public String h() {
        return this.f53288e;
    }

    public String i() {
        return this.f53289f;
    }

    public WriteData j() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.getWriteData = ");
        sb.append(this.f53284a.T() == null ? StringUtil.NULL_STRING : this.f53284a.T().toDraftString());
        d.a.j0.d3.q0.b.a(sb.toString());
        return this.f53284a.T();
    }

    public void k(@NonNull TbPageContextSupport tbPageContextSupport) {
        d.a.j0.d3.q0.b.a("AsyncWriteHelper.initWriteStatus()");
        this.f53284a.e0(tbPageContextSupport.getPageContext());
        this.f53284a.f0(null);
        this.f53284a.Z(false);
    }

    public boolean l() {
        return this.f53285b;
    }

    public void m() {
        d.a.j0.d3.q0.b.a("AsyncWriteHelper.onWriteActClose()");
        this.f53284a.e0(null);
        this.f53284a.setSpanGroupManager(null);
    }

    public final void n(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    public void o(BdUniqueId bdUniqueId) {
        this.f53286c = bdUniqueId;
    }

    public void p(boolean z) {
        d.a.j0.d3.q0.b.a("AsyncWriteHelper.setHasImage = " + z);
        this.f53284a.Z(z);
    }

    public void q(String str) {
        this.f53287d = str;
    }

    public void r(String str) {
        this.f53288e = str;
    }

    public void s(String str) {
        this.f53289f = str;
    }

    public void t(SpanGroupManager spanGroupManager) {
        d.a.j0.d3.q0.b.a("AsyncWriteHelper.setSpanGroupManager()");
        this.f53284a.U();
        this.f53284a.setSpanGroupManager(spanGroupManager);
    }

    public void u(WriteData writeData) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncWriteHelper.setWriteData = ");
        sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
        d.a.j0.d3.q0.b.a(sb.toString());
        this.f53284a.f0(writeData);
    }

    public boolean v() {
        d.a.j0.d3.q0.b.a("AsyncWriteHelper.startPostWrite()");
        this.f53284a.U();
        boolean g0 = this.f53284a.g0();
        this.f53285b = g0;
        return g0;
    }

    public a() {
        this.f53285b = false;
        this.f53286c = null;
        NewWriteModel newWriteModel = new NewWriteModel();
        this.f53284a = newWriteModel;
        newWriteModel.d0(this);
    }
}
