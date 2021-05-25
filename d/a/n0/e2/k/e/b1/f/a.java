package d.a.n0.e2.k.e.b1.f;

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
import d.a.m0.s.c.i0;
import d.a.m0.w.w.c;
import d.a.n0.e2.h.e;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f53161a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f53162b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f53163c;

    /* renamed from: d  reason: collision with root package name */
    public c f53164d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f53165e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f53166f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f53167g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f53168h;

    /* renamed from: i  reason: collision with root package name */
    public e f53169i;
    public final NewWriteModel.g j = new b();

    /* renamed from: d.a.n0.e2.k.e.b1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1261a implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f53170a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f53171b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f53172c;

        public C1261a(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
            this.f53170a = emotionImageData;
            this.f53171b = pbModel;
            this.f53172c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.a.m0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f48910a)) {
                return;
            }
            this.f53170a.setPicId(cVar.f48910a);
            a.this.l(this.f53170a, this.f53171b, this.f53172c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            if (a.this.f53165e != null) {
                a.this.f53165e.callback(false, null, null, null, null);
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
                writeData = a.this.f53162b.T();
            }
            if (z) {
                a.this.j();
            } else if (writeData != null && i0Var != null && !TextUtils.isEmpty(i0Var.d())) {
                writeData.setVcodeMD5(i0Var.b());
                writeData.setVcodeUrl(i0Var.c());
                writeData.setVcodeExtra(i0Var.a());
                if (d.a.m0.a1.a.b(i0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.f53161a.getPageContext().getPageActivity(), 25017, writeData, false, i0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.f53161a.getPageContext().getPageActivity(), writeData, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.f53161a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
            }
            if (a.this.f53165e != null) {
                a.this.f53165e.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
            }
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.f53161a = baseFragmentActivity;
        this.f53162b = new NewWriteModel(baseFragmentActivity);
        this.f53163c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        GetEmotionPidModel getEmotionPidModel = this.f53166f;
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
                    k(this.f53167g, this.f53168h, this.f53169i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f53162b;
                WriteData T = newWriteModel != null ? newWriteModel.T() : null;
                j();
                NewWriteModel.g gVar = this.f53165e;
                if (gVar != null) {
                    gVar.callback(true, null, null, T, null);
                }
            }
        }
    }

    public final void j() {
        this.f53167g = null;
        this.f53169i = null;
        this.f53168h = null;
        NewWriteModel newWriteModel = this.f53162b;
        if (newWriteModel != null) {
            newWriteModel.f0(null);
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        if (emotionImageData == null || eVar == null) {
            return;
        }
        this.f53167g = emotionImageData;
        this.f53168h = pbModel;
        this.f53169i = eVar;
        if (!j.z()) {
            this.f53161a.showToast(R.string.neterror);
        } else if (g(this.f53161a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f53166f == null) {
                    this.f53166f = new GetEmotionPidModel();
                }
                c cVar = this.f53164d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f53166f.t(emotionImageData.getPicUrl(), new C1261a(emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f53164d;
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
        if (this.f53162b.T() == null && pbModel != null) {
            this.f53162b.f0(pbModel.t(null));
        }
        if (this.f53162b.T() == null) {
            return;
        }
        boolean z = true;
        if (eVar.L().n2()) {
            this.f53162b.T().setCanNoForum(true);
            if (eVar.l() != null) {
                this.f53162b.T().setVForumId(eVar.l().getId());
                this.f53162b.T().setVForumName(eVar.l().getName());
            }
        } else {
            this.f53162b.T().setCanNoForum(false);
            this.f53162b.T().setVForumId("");
            this.f53162b.T().setVForumName("");
        }
        WriteData T = this.f53162b.T();
        LocationModel locationModel = this.f53163c;
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
            this.f53162b.T().setContent(str);
        } else {
            this.f53162b.T().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f53162b.T().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f53162b.T().setMemeText(emotionImageData.getMemeText());
        }
        this.f53162b.d0(this.j);
        if (!this.f53162b.i0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        this.f53165e = gVar;
    }

    public void n(c cVar) {
        this.f53164d = cVar;
    }
}
