package d.a.k0.s2;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.Cmatch;
import d.a.k0.d3.j0.a;
import java.util.List;
import tbclient.App;
/* loaded from: classes5.dex */
public interface v {
    d.a.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    q b();

    App c(App app, Cmatch cmatch);

    void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5);

    k e();

    l f(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2);

    m g();

    d.a.c.j.e.a<?, ?> h(u uVar, BdUniqueId bdUniqueId);

    void i();

    List<AdvertAppInfo> j();

    void k(AdvertAppInfo advertAppInfo, Context context);

    d.a.c.j.e.a<?, ?> l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    d.a.k0.b3.a m();

    void n(boolean z, String str, String str2, String str3, List<a.c> list, String str4);

    s o();
}
