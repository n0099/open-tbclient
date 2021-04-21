package d.b.j0.s2;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.j0.d3.j0.a;
import java.util.List;
import tbclient.App;
/* loaded from: classes4.dex */
public interface u {
    d.b.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    p b();

    App c(App app, Cmatch cmatch);

    void d(AdvertAppInfo advertAppInfo, Context context);

    void e(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5);

    d.b.c.j.e.a<?, ?> f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    j g();

    k h(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2);

    l i();

    d.b.c.j.e.a<?, ?> j(t tVar, BdUniqueId bdUniqueId);

    d.b.j0.b3.a k();

    void l(boolean z, String str, String str2, String str3, List<a.c> list, String str4);

    r m();

    void n();

    List<AppData> o();
}
