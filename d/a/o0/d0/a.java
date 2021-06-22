package d.a.o0.d0;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import d.a.n0.r.s.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: d.a.o0.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1295a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f56226f;

        public C1295a(TbPageContext tbPageContext, int i2) {
            this.f56225e = tbPageContext;
            this.f56226f = i2;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.f56225e.getPageActivity(), true, this.f56226f)));
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements a.e {
        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public static void a(Intent intent, TbPageContext tbPageContext, int i2) {
        Uri uri;
        if (intent == null || !TbadkCoreApplication.isLogin() || (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("portrait");
        if (TbadkCoreApplication.getCurrentPortrait() == null || queryParameter == null || TbadkCoreApplication.getCurrentPortrait().contains(queryParameter)) {
            return;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(tbPageContext.getPageActivity());
        aVar.setContentViewSize(1);
        aVar.setMessage(tbPageContext.getString(R.string.account_not_the_same_as_pc));
        aVar.setPositiveButton(R.string.change_account, new C1295a(tbPageContext, i2));
        aVar.setNegativeButton(R.string.not_change_account, new b());
        aVar.create(tbPageContext).show();
    }
}
