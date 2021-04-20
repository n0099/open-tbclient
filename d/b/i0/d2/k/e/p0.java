package d.b.i0.d2.k.e;

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
/* loaded from: classes3.dex */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54218a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54219b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f54220c;

    public p0(TbPageContext tbPageContext) {
        Uri uri;
        this.f54219b = false;
        this.f54218a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f54218a.getPageActivity().getIntent() == null || (uri = (Uri) this.f54218a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        e1 e1Var = new e1();
        this.f54220c = e1Var;
        e1Var.f51178a = uri.getQueryParameter("tid");
        this.f54220c.f51179b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || d.b.c.a.b.f().g() > 3) {
            return;
        }
        this.f54219b = true;
    }

    public void a(PbModel pbModel) {
        if (!this.f54219b || this.f54220c == null || pbModel == null || pbModel.y0() == null || pbModel.y0().l() == null) {
            return;
        }
        ForumData l = pbModel.y0().l();
        this.f54220c.f51180c = l.getFirst_class();
        this.f54220c.f51181d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f54220c);
        if (d.b.c.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
