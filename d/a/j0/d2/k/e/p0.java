package d.a.j0.d2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.a.i0.r.q.e1;
/* loaded from: classes3.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52448a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52449b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f52450c;

    public p0(TbPageContext tbPageContext) {
        Uri uri;
        this.f52449b = false;
        this.f52448a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f52448a.getPageActivity().getIntent() == null || (uri = (Uri) this.f52448a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        e1 e1Var = new e1();
        this.f52450c = e1Var;
        e1Var.f49140a = uri.getQueryParameter("tid");
        this.f52450c.f49141b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || d.a.c.a.b.f().g() > 3) {
            return;
        }
        this.f52449b = true;
    }

    public void a(PbModel pbModel) {
        if (!this.f52449b || this.f52450c == null || pbModel == null || pbModel.y0() == null || pbModel.y0().l() == null) {
            return;
        }
        ForumData l = pbModel.y0().l();
        this.f52450c.f49142c = l.getFirst_class();
        this.f52450c.f49143d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f52450c);
        if (d.a.c.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
