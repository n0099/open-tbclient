package d.a.k0.d2.k.e.a1.f;

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
import d.a.c.e.p.j;
import d.a.c.e.p.q;
import d.a.j0.s.c.h0;
import d.a.j0.w.w.c;
import d.a.k0.d2.h.e;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f52904a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f52905b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f52906c;

    /* renamed from: d  reason: collision with root package name */
    public c f52907d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f52908e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f52909f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f52910g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f52911h;

    /* renamed from: i  reason: collision with root package name */
    public e f52912i;
    public final NewWriteModel.g j = new b();

    /* renamed from: d.a.k0.d2.k.e.a1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1242a implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f52913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f52914b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f52915c;

        public C1242a(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
            this.f52913a = emotionImageData;
            this.f52914b = pbModel;
            this.f52915c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.a.j0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f48885a)) {
                return;
            }
            this.f52913a.setPicId(cVar.f48885a);
            a.this.l(this.f52913a, this.f52914b, this.f52915c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            if (a.this.f52908e != null) {
                a.this.f52908e.callback(false, null, null, null, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NewWriteModel.g {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            if (writeData == null) {
                writeData = a.this.f52905b.T();
            }
            if (z) {
                a.this.j();
            } else if (writeData != null && h0Var != null && !TextUtils.isEmpty(h0Var.d())) {
                writeData.setVcodeMD5(h0Var.b());
                writeData.setVcodeUrl(h0Var.c());
                writeData.setVcodeExtra(h0Var.a());
                if (d.a.j0.a1.a.b(h0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f52904a.getPageContext().getPageActivity(), 25017, writeData, false, h0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f52904a.getPageContext().getPageActivity(), writeData, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f52904a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
            }
            if (a.this.f52908e != null) {
                a.this.f52908e.callback(z, postWriteCallBackData, h0Var, writeData, antiData);
            }
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.f52904a = baseFragmentActivity;
        this.f52905b = new NewWriteModel(baseFragmentActivity);
        this.f52906c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        GetEmotionPidModel getEmotionPidModel = this.f52909f;
        if (getEmotionPidModel != null) {
            getEmotionPidModel.cancelLoadData();
            return true;
        }
        return true;
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }

    public final String h(String str) {
        return "@" + str + " ";
    }

    public void i(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            if (i2 != 25017) {
                if (i2 == 11042) {
                    k(this.f52910g, this.f52911h, this.f52912i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f52905b;
                WriteData T = newWriteModel != null ? newWriteModel.T() : null;
                j();
                NewWriteModel.g gVar = this.f52908e;
                if (gVar != null) {
                    gVar.callback(true, null, null, T, null);
                }
            }
        }
    }

    public final void j() {
        this.f52910g = null;
        this.f52912i = null;
        this.f52911h = null;
        NewWriteModel newWriteModel = this.f52905b;
        if (newWriteModel != null) {
            newWriteModel.f0(null);
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        if (emotionImageData == null || eVar == null) {
            return;
        }
        this.f52910g = emotionImageData;
        this.f52911h = pbModel;
        this.f52912i = eVar;
        if (!j.z()) {
            this.f52904a.showToast(R.string.neterror);
        } else if (g(this.f52904a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f52909f == null) {
                    this.f52909f = new GetEmotionPidModel();
                }
                c cVar = this.f52907d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f52909f.t(emotionImageData.getPicUrl(), new C1242a(emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f52907d;
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
        if (this.f52905b.T() == null && pbModel != null) {
            this.f52905b.f0(pbModel.t(null));
        }
        if (this.f52905b.T() == null) {
            return;
        }
        boolean z = true;
        if (eVar.L().m2()) {
            this.f52905b.T().setCanNoForum(true);
            if (eVar.l() != null) {
                this.f52905b.T().setVForumId(eVar.l().getId());
                this.f52905b.T().setVForumName(eVar.l().getName());
            }
        } else {
            this.f52905b.T().setCanNoForum(false);
            this.f52905b.T().setVForumId("");
            this.f52905b.T().setVForumName("");
        }
        WriteData T = this.f52905b.T();
        LocationModel locationModel = this.f52906c;
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
            this.f52905b.T().setContent(str);
        } else {
            this.f52905b.T().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f52905b.T().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f52905b.T().setMemeText(emotionImageData.getMemeText());
        }
        this.f52905b.d0(this.j);
        if (!this.f52905b.i0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        this.f52908e = gVar;
    }

    public void n(c cVar) {
        this.f52907d = cVar;
    }
}
