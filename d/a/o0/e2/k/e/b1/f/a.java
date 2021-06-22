package d.a.o0.e2.k.e.b1.f;

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
import d.a.n0.s.c.i0;
import d.a.n0.w.w.c;
import d.a.o0.e2.h.e;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f56975a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f56976b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f56977c;

    /* renamed from: d  reason: collision with root package name */
    public c f56978d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f56979e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f56980f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f56981g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f56982h;

    /* renamed from: i  reason: collision with root package name */
    public e f56983i;
    public final NewWriteModel.g j = new b();

    /* renamed from: d.a.o0.e2.k.e.b1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1321a implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f56984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f56985b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f56986c;

        public C1321a(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
            this.f56984a = emotionImageData;
            this.f56985b = pbModel;
            this.f56986c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.a.n0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f52691a)) {
                return;
            }
            this.f56984a.setPicId(cVar.f52691a);
            a.this.l(this.f56984a, this.f56985b, this.f56986c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            if (a.this.f56979e != null) {
                a.this.f56979e.callback(false, null, null, null, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NewWriteModel.g {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            if (writeData == null) {
                writeData = a.this.f56976b.X();
            }
            if (z) {
                a.this.j();
            } else if (writeData != null && i0Var != null && !TextUtils.isEmpty(i0Var.d())) {
                writeData.setVcodeMD5(i0Var.b());
                writeData.setVcodeUrl(i0Var.c());
                writeData.setVcodeExtra(i0Var.a());
                if (d.a.n0.a1.a.b(i0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f56975a.getPageContext().getPageActivity(), 25017, writeData, false, i0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f56975a.getPageContext().getPageActivity(), writeData, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f56975a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
            }
            if (a.this.f56979e != null) {
                a.this.f56979e.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
            }
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.f56975a = baseFragmentActivity;
        this.f56976b = new NewWriteModel(baseFragmentActivity);
        this.f56977c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        GetEmotionPidModel getEmotionPidModel = this.f56980f;
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
                    k(this.f56981g, this.f56982h, this.f56983i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f56976b;
                WriteData X = newWriteModel != null ? newWriteModel.X() : null;
                j();
                NewWriteModel.g gVar = this.f56979e;
                if (gVar != null) {
                    gVar.callback(true, null, null, X, null);
                }
            }
        }
    }

    public final void j() {
        this.f56981g = null;
        this.f56983i = null;
        this.f56982h = null;
        NewWriteModel newWriteModel = this.f56976b;
        if (newWriteModel != null) {
            newWriteModel.j0(null);
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        if (emotionImageData == null || eVar == null) {
            return;
        }
        this.f56981g = emotionImageData;
        this.f56982h = pbModel;
        this.f56983i = eVar;
        if (!j.z()) {
            this.f56975a.showToast(R.string.neterror);
        } else if (g(this.f56975a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f56980f == null) {
                    this.f56980f = new GetEmotionPidModel();
                }
                c cVar = this.f56978d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f56980f.x(emotionImageData.getPicUrl(), new C1321a(emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f56978d;
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
        if (this.f56976b.X() == null && pbModel != null) {
            this.f56976b.j0(pbModel.x(null));
        }
        if (this.f56976b.X() == null) {
            return;
        }
        boolean z = true;
        if (eVar.L().o2()) {
            this.f56976b.X().setCanNoForum(true);
            if (eVar.l() != null) {
                this.f56976b.X().setVForumId(eVar.l().getId());
                this.f56976b.X().setVForumName(eVar.l().getName());
            }
        } else {
            this.f56976b.X().setCanNoForum(false);
            this.f56976b.X().setVForumId("");
            this.f56976b.X().setVForumName("");
        }
        WriteData X = this.f56976b.X();
        LocationModel locationModel = this.f56977c;
        X.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String str = SmallTailInfo.EMOTION_PREFIX + sb.toString() + q.c(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
        if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
            this.f56976b.X().setContent(str);
        } else {
            this.f56976b.X().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f56976b.X().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f56976b.X().setMemeText(emotionImageData.getMemeText());
        }
        this.f56976b.h0(this.j);
        if (!this.f56976b.m0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        this.f56979e = gVar;
    }

    public void n(c cVar) {
        this.f56978d = cVar;
    }
}
