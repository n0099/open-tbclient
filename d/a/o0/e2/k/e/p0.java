package d.a.o0.e2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.a.n0.r.q.e1;
/* loaded from: classes5.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57217a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57218b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f57219c;

    public p0(TbPageContext tbPageContext) {
        Uri uri;
        this.f57218b = false;
        this.f57217a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f57217a.getPageActivity().getIntent() == null || (uri = (Uri) this.f57217a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        e1 e1Var = new e1();
        this.f57219c = e1Var;
        e1Var.f53786a = uri.getQueryParameter("tid");
        this.f57219c.f53787b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || d.a.c.a.b.f().g() > 3) {
            return;
        }
        this.f57218b = true;
    }

    public void a(PbModel pbModel) {
        if (!this.f57218b || this.f57219c == null || pbModel == null || pbModel.C0() == null || pbModel.C0().l() == null) {
            return;
        }
        ForumData l = pbModel.C0().l();
        this.f57219c.f53788c = l.getFirst_class();
        this.f57219c.f53789d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f57219c);
        if (d.a.c.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
