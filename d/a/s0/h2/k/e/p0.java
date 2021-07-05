package d.a.s0.h2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.f1;
/* loaded from: classes9.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60631a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60632b;

    /* renamed from: c  reason: collision with root package name */
    public f1 f60633c;

    public p0(TbPageContext tbPageContext) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60632b = false;
        this.f60631a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f60631a.getPageActivity().getIntent() == null || (uri = (Uri) this.f60631a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        f1 f1Var = new f1();
        this.f60633c = f1Var;
        f1Var.f55941a = uri.getQueryParameter("tid");
        this.f60633c.f55942b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || d.a.c.a.b.f().g() > 3) {
            return;
        }
        this.f60632b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f60632b || this.f60633c == null || pbModel == null || pbModel.D0() == null || pbModel.D0().m() == null) {
            return;
        }
        ForumData m = pbModel.D0().m();
        this.f60633c.f55943c = m.getFirst_class();
        this.f60633c.f55944d = m.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f60633c);
        if (d.a.c.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
