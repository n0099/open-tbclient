package d.b.i0.r2;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.c3.j0.a;
import java.util.List;
import tbclient.App;
/* loaded from: classes5.dex */
public interface r {
    d.b.b.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    m b();

    App c(App app, Cmatch cmatch);

    void d(AdvertAppInfo advertAppInfo, Context context);

    void e(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5);

    d.b.b.j.e.a<?, ?> f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    i g(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2);

    j h();

    d.b.b.j.e.a<?, ?> i(q qVar, BdUniqueId bdUniqueId);

    d.b.i0.a3.a j();

    void k(boolean z, String str, String str2, String str3, List<a.c> list, String str4);

    o l();

    void m();

    List<AppData> n();
}
