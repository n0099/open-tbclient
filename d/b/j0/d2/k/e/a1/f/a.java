package d.b.j0.d2.k.e.a1.f;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.b.c.e.p.j;
import d.b.c.e.p.q;
import d.b.i0.s.c.h0;
import d.b.i0.w.w.c;
import d.b.j0.d2.h.e;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f54413a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f54414b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f54415c;

    /* renamed from: d  reason: collision with root package name */
    public c f54416d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f54417e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f54418f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f54419g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f54420h;
    public e i;
    public final NewWriteModel.g j = new b();

    /* renamed from: d.b.j0.d2.k.e.a1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1231a implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f54421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f54422b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f54423c;

        public C1231a(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
            this.f54421a = emotionImageData;
            this.f54422b = pbModel;
            this.f54423c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.b.i0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f50503a)) {
                return;
            }
            this.f54421a.setPicId(cVar.f50503a);
            a.this.l(this.f54421a, this.f54422b, this.f54423c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i, String str) {
            if (a.this.f54417e != null) {
                a.this.f54417e.callback(false, null, null, null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NewWriteModel.g {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            if (writeData == null) {
                writeData = a.this.f54414b.T();
            }
            if (z) {
                a.this.j();
            } else if (writeData != null && h0Var != null && !TextUtils.isEmpty(h0Var.d())) {
                writeData.setVcodeMD5(h0Var.b());
                writeData.setVcodeUrl(h0Var.c());
                writeData.setVcodeExtra(h0Var.a());
                if (d.b.i0.a1.a.b(h0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f54413a.getPageContext().getPageActivity(), 25017, writeData, false, h0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f54413a.getPageContext().getPageActivity(), writeData, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f54413a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
            }
            if (a.this.f54417e != null) {
                a.this.f54417e.callback(z, postWriteCallBackData, h0Var, writeData, antiData);
            }
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.f54413a = baseFragmentActivity;
        this.f54414b = new NewWriteModel(baseFragmentActivity);
        this.f54415c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        GetEmotionPidModel getEmotionPidModel = this.f54418f;
        if (getEmotionPidModel != null) {
            getEmotionPidModel.cancelLoadData();
            return true;
        }
        return true;
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public final String h(String str) {
        return "@" + str + " ";
    }

    public void i(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 25017) {
                if (i == 11042) {
                    k(this.f54419g, this.f54420h, this.i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f54414b;
                WriteData T = newWriteModel != null ? newWriteModel.T() : null;
                j();
                NewWriteModel.g gVar = this.f54417e;
                if (gVar != null) {
                    gVar.callback(true, null, null, T, null);
                }
            }
        }
    }

    public final void j() {
        this.f54419g = null;
        this.i = null;
        this.f54420h = null;
        NewWriteModel newWriteModel = this.f54414b;
        if (newWriteModel != null) {
            newWriteModel.f0(null);
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        if (emotionImageData == null || eVar == null) {
            return;
        }
        this.f54419g = emotionImageData;
        this.f54420h = pbModel;
        this.i = eVar;
        if (!j.z()) {
            this.f54413a.showToast(R.string.neterror);
        } else if (g(this.f54413a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f54418f == null) {
                    this.f54418f = new GetEmotionPidModel();
                }
                c cVar = this.f54416d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f54418f.t(emotionImageData.getPicUrl(), new C1231a(emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f54416d;
            if (cVar2 != null) {
                cVar2.a();
            }
            l(emotionImageData, pbModel, eVar);
        }
    }

    public final void l(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        if (emotionImageData == null || eVar == null) {
            return;
        }
        if (this.f54414b.T() == null && pbModel != null) {
            this.f54414b.f0(pbModel.t(null));
        }
        if (this.f54414b.T() == null) {
            return;
        }
        boolean z = true;
        if (eVar.L().l2()) {
            this.f54414b.T().setCanNoForum(true);
            if (eVar.l() != null) {
                this.f54414b.T().setVForumId(eVar.l().getId());
                this.f54414b.T().setVForumName(eVar.l().getName());
            }
        } else {
            this.f54414b.T().setCanNoForum(false);
            this.f54414b.T().setVForumId("");
            this.f54414b.T().setVForumName("");
        }
        WriteData T = this.f54414b.T();
        LocationModel locationModel = this.f54415c;
        T.setHasLocationData((locationModel == null || !locationModel.v()) ? false : false);
        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String str = SmallTailInfo.EMOTION_PREFIX + sb.toString() + q.c(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
        if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
            this.f54414b.T().setContent(str);
        } else {
            this.f54414b.T().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f54414b.T().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f54414b.T().setMemeText(emotionImageData.getMemeText());
        }
        this.f54414b.d0(this.j);
        if (!this.f54414b.i0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        this.f54417e = gVar;
    }

    public void n(c cVar) {
        this.f54416d = cVar;
    }
}
