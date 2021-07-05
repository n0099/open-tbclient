package d.a.s0.w2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.Cmatch;
import d.a.s0.h3.j0.a;
import java.util.List;
import tbclient.App;
/* loaded from: classes9.dex */
public interface u {
    d.a.c.k.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    p b();

    App c(App app, Cmatch cmatch);

    void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5);

    k e(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2);

    l f();

    d.a.c.k.e.a<?, ?> g(t tVar, BdUniqueId bdUniqueId);

    void h();

    List<AdvertAppInfo> i();

    void j(AdvertAppInfo advertAppInfo, Context context);

    d.a.c.k.e.a<?, ?> k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController l(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    d.a.s0.f3.a m();

    void n(boolean z, String str, String str2, String str3, List<a.c> list, String str4);

    r o();
}
