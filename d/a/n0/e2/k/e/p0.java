package d.a.n0.e2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.a.m0.r.q.e1;
/* loaded from: classes5.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57092a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57093b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f57094c;

    public p0(TbPageContext tbPageContext) {
        Uri uri;
        this.f57093b = false;
        this.f57092a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f57092a.getPageActivity().getIntent() == null || (uri = (Uri) this.f57092a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        e1 e1Var = new e1();
        this.f57094c = e1Var;
        e1Var.f53679a = uri.getQueryParameter("tid");
        this.f57094c.f53680b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || d.a.c.a.b.f().g() > 3) {
            return;
        }
        this.f57093b = true;
    }

    public void a(PbModel pbModel) {
        if (!this.f57093b || this.f57094c == null || pbModel == null || pbModel.C0() == null || pbModel.C0().l() == null) {
            return;
        }
        ForumData l = pbModel.C0().l();
        this.f57094c.f53681c = l.getFirst_class();
        this.f57094c.f53682d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f57094c);
        if (d.a.c.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
