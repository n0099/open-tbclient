package d.b.i0.c2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.main.PbModel;
import d.b.h0.r.q.e1;
/* loaded from: classes4.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52732a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52733b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f52734c;

    public n0(TbPageContext tbPageContext) {
        Uri uri;
        this.f52733b = false;
        this.f52732a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f52732a.getPageActivity().getIntent() == null || (uri = (Uri) this.f52732a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        e1 e1Var = new e1();
        this.f52734c = e1Var;
        e1Var.f50770a = uri.getQueryParameter("tid");
        this.f52734c.f50771b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || d.b.b.a.b.f().g() > 3) {
            return;
        }
        this.f52733b = true;
    }

    public void a(PbModel pbModel) {
        if (!this.f52733b || this.f52734c == null || pbModel == null || pbModel.y0() == null || pbModel.y0().l() == null) {
            return;
        }
        ForumData l = pbModel.y0().l();
        this.f52734c.f50772c = l.getFirst_class();
        this.f52734c.f50773d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f52734c);
        if (d.b.b.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
