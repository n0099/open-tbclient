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
    public TbPageContext f53403a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53404b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f53405c;

    public p0(TbPageContext tbPageContext) {
        Uri uri;
        this.f53404b = false;
        this.f53403a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f53403a.getPageActivity().getIntent() == null || (uri = (Uri) this.f53403a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        e1 e1Var = new e1();
        this.f53405c = e1Var;
        e1Var.f50003a = uri.getQueryParameter("tid");
        this.f53405c.f50004b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || d.a.c.a.b.f().g() > 3) {
            return;
        }
        this.f53404b = true;
    }

    public void a(PbModel pbModel) {
        if (!this.f53404b || this.f53405c == null || pbModel == null || pbModel.y0() == null || pbModel.y0().l() == null) {
            return;
        }
        ForumData l = pbModel.y0().l();
        this.f53405c.f50005c = l.getFirst_class();
        this.f53405c.f50006d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f53405c);
        if (d.a.c.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
