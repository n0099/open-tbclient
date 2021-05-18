package d.a.k0.d2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.a.j0.r.q.e1;
/* loaded from: classes5.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53147a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53148b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f53149c;

    public p0(TbPageContext tbPageContext) {
        Uri uri;
        this.f53148b = false;
        this.f53147a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f53147a.getPageActivity().getIntent() == null || (uri = (Uri) this.f53147a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        e1 e1Var = new e1();
        this.f53149c = e1Var;
        e1Var.f49959a = uri.getQueryParameter("tid");
        this.f53149c.f49960b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || d.a.c.a.b.f().g() > 3) {
            return;
        }
        this.f53148b = true;
    }

    public void a(PbModel pbModel) {
        if (!this.f53148b || this.f53149c == null || pbModel == null || pbModel.y0() == null || pbModel.y0().l() == null) {
            return;
        }
        ForumData l = pbModel.y0().l();
        this.f53149c.f49961c = l.getFirst_class();
        this.f53149c.f49962d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f53149c);
        if (d.a.c.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
