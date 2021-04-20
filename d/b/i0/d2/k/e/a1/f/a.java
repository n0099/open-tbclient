package d.b.i0.d2.k.e.a1.f;

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
import d.b.h0.s.c.h0;
import d.b.h0.w.w.c;
import d.b.i0.d2.h.e;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f53992a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f53993b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f53994c;

    /* renamed from: d  reason: collision with root package name */
    public c f53995d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f53996e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f53997f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f53998g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f53999h;
    public e i;
    public final NewWriteModel.g j = new b();

    /* renamed from: d.b.i0.d2.k.e.a1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1208a implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f54000a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f54001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f54002c;

        public C1208a(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
            this.f54000a = emotionImageData;
            this.f54001b = pbModel;
            this.f54002c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.b.h0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f50167a)) {
                return;
            }
            this.f54000a.setPicId(cVar.f50167a);
            a.this.l(this.f54000a, this.f54001b, this.f54002c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i, String str) {
            if (a.this.f53996e != null) {
                a.this.f53996e.callback(false, null, null, null, null);
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
                writeData = a.this.f53993b.T();
            }
            if (z) {
                a.this.j();
            } else if (writeData != null && h0Var != null && !TextUtils.isEmpty(h0Var.d())) {
                writeData.setVcodeMD5(h0Var.b());
                writeData.setVcodeUrl(h0Var.c());
                writeData.setVcodeExtra(h0Var.a());
                if (d.b.h0.a1.a.b(h0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f53992a.getPageContext().getPageActivity(), 25017, writeData, false, h0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f53992a.getPageContext().getPageActivity(), writeData, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f53992a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
            }
            if (a.this.f53996e != null) {
                a.this.f53996e.callback(z, postWriteCallBackData, h0Var, writeData, antiData);
            }
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.f53992a = baseFragmentActivity;
        this.f53993b = new NewWriteModel(baseFragmentActivity);
        this.f53994c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        GetEmotionPidModel getEmotionPidModel = this.f53997f;
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
                    k(this.f53998g, this.f53999h, this.i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f53993b;
                WriteData T = newWriteModel != null ? newWriteModel.T() : null;
                j();
                NewWriteModel.g gVar = this.f53996e;
                if (gVar != null) {
                    gVar.callback(true, null, null, T, null);
                }
            }
        }
    }

    public final void j() {
        this.f53998g = null;
        this.i = null;
        this.f53999h = null;
        NewWriteModel newWriteModel = this.f53993b;
        if (newWriteModel != null) {
            newWriteModel.f0(null);
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        if (emotionImageData == null || eVar == null) {
            return;
        }
        this.f53998g = emotionImageData;
        this.f53999h = pbModel;
        this.i = eVar;
        if (!j.z()) {
            this.f53992a.showToast(R.string.neterror);
        } else if (g(this.f53992a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f53997f == null) {
                    this.f53997f = new GetEmotionPidModel();
                }
                c cVar = this.f53995d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f53997f.t(emotionImageData.getPicUrl(), new C1208a(emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f53995d;
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
        if (this.f53993b.T() == null && pbModel != null) {
            this.f53993b.f0(pbModel.t(null));
        }
        if (this.f53993b.T() == null) {
            return;
        }
        boolean z = true;
        if (eVar.L().l2()) {
            this.f53993b.T().setCanNoForum(true);
            if (eVar.l() != null) {
                this.f53993b.T().setVForumId(eVar.l().getId());
                this.f53993b.T().setVForumName(eVar.l().getName());
            }
        } else {
            this.f53993b.T().setCanNoForum(false);
            this.f53993b.T().setVForumId("");
            this.f53993b.T().setVForumName("");
        }
        WriteData T = this.f53993b.T();
        LocationModel locationModel = this.f53994c;
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
            this.f53993b.T().setContent(str);
        } else {
            this.f53993b.T().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f53993b.T().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f53993b.T().setMemeText(emotionImageData.getMemeText());
        }
        this.f53993b.d0(this.j);
        if (!this.f53993b.i0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        this.f53996e = gVar;
    }

    public void n(c cVar) {
        this.f53995d = cVar;
    }
}
