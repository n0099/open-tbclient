package d.a.p0.w2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.Cmatch;
import d.a.p0.h3.j0.a;
import java.util.List;
import tbclient.App;
/* loaded from: classes8.dex */
public interface u {
    d.a.c.k.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    p b();

    App c(App app, Cmatch cmatch);

    void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5);

    l e();

    d.a.c.k.e.a<?, ?> f(t tVar, BdUniqueId bdUniqueId);

    void g();

    List<AdvertAppInfo> h();

    void i(AdvertAppInfo advertAppInfo, Context context);

    d.a.c.k.e.a<?, ?> j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController k(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    d.a.p0.f3.a l();

    void m(boolean z, String str, String str2, String str3, List<a.c> list, String str4);

    r n();
}
