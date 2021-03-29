package d.b.i0.c2.k.e.y0.f;

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
import d.b.b.e.p.j;
import d.b.b.e.p.q;
import d.b.h0.s.c.f0;
import d.b.h0.w.w.c;
import d.b.i0.c2.h.e;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f52965a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f52966b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f52967c;

    /* renamed from: d  reason: collision with root package name */
    public c f52968d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f52969e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f52970f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f52971g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f52972h;
    public e i;
    public final NewWriteModel.g j = new b();

    /* renamed from: d.b.i0.c2.k.e.y0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1161a implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f52973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f52974b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f52975c;

        public C1161a(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
            this.f52973a = emotionImageData;
            this.f52974b = pbModel;
            this.f52975c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.b.h0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f49774a)) {
                return;
            }
            this.f52973a.setPicId(cVar.f49774a);
            a.this.l(this.f52973a, this.f52974b, this.f52975c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i, String str) {
            if (a.this.f52969e != null) {
                a.this.f52969e.callback(false, null, null, null, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NewWriteModel.g {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
            if (writeData == null) {
                writeData = a.this.f52966b.T();
            }
            if (z) {
                a.this.j();
            } else if (writeData != null && f0Var != null && !TextUtils.isEmpty(f0Var.d())) {
                writeData.setVcodeMD5(f0Var.b());
                writeData.setVcodeUrl(f0Var.c());
                writeData.setVcodeExtra(f0Var.a());
                if (d.b.h0.a1.a.b(f0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f52965a.getPageContext().getPageActivity(), 25017, writeData, false, f0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f52965a.getPageContext().getPageActivity(), writeData, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f52965a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
            }
            if (a.this.f52969e != null) {
                a.this.f52969e.callback(z, postWriteCallBackData, f0Var, writeData, antiData);
            }
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.f52965a = baseFragmentActivity;
        this.f52966b = new NewWriteModel(baseFragmentActivity);
        this.f52967c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        GetEmotionPidModel getEmotionPidModel = this.f52970f;
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
                    k(this.f52971g, this.f52972h, this.i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f52966b;
                WriteData T = newWriteModel != null ? newWriteModel.T() : null;
                j();
                NewWriteModel.g gVar = this.f52969e;
                if (gVar != null) {
                    gVar.callback(true, null, null, T, null);
                }
            }
        }
    }

    public final void j() {
        this.f52971g = null;
        this.i = null;
        this.f52972h = null;
        NewWriteModel newWriteModel = this.f52966b;
        if (newWriteModel != null) {
            newWriteModel.f0(null);
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        if (emotionImageData == null || eVar == null) {
            return;
        }
        this.f52971g = emotionImageData;
        this.f52972h = pbModel;
        this.i = eVar;
        if (!j.z()) {
            this.f52965a.showToast(R.string.neterror);
        } else if (g(this.f52965a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f52970f == null) {
                    this.f52970f = new GetEmotionPidModel();
                }
                c cVar = this.f52968d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f52970f.t(emotionImageData.getPicUrl(), new C1161a(emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f52968d;
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
        if (this.f52966b.T() == null && pbModel != null) {
            this.f52966b.f0(pbModel.t(null));
        }
        if (this.f52966b.T() == null) {
            return;
        }
        boolean z = true;
        if (eVar.L().k2()) {
            this.f52966b.T().setCanNoForum(true);
            if (eVar.l() != null) {
                this.f52966b.T().setVForumId(eVar.l().getId());
                this.f52966b.T().setVForumName(eVar.l().getName());
            }
        } else {
            this.f52966b.T().setCanNoForum(false);
            this.f52966b.T().setVForumId("");
            this.f52966b.T().setVForumName("");
        }
        WriteData T = this.f52966b.T();
        LocationModel locationModel = this.f52967c;
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
            this.f52966b.T().setContent(str);
        } else {
            this.f52966b.T().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f52966b.T().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f52966b.T().setMemeText(emotionImageData.getMemeText());
        }
        this.f52966b.d0(this.j);
        if (!this.f52966b.i0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        this.f52969e = gVar;
    }

    public void n(c cVar) {
        this.f52968d = cVar;
    }
}
