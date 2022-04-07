package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.repackage.al8;
import java.util.HashMap;
import java.util.List;
import tbclient.App;
/* loaded from: classes5.dex */
public interface ca8 {
    ho<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    x98 b();

    App c(App app, Cmatch cmatch);

    void d(boolean z, String str, String str2, String str3, String str4, List<al8.c> list, String str5);

    r98 e();

    ho<?, ?> f(ba8 ba8Var, BdUniqueId bdUniqueId);

    void g();

    List<AdvertAppInfo> h();

    void i(AdvertAppInfo advertAppInfo, Context context);

    ho<?, ?> j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController k(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    ti8 l();

    void m(boolean z, String str, String str2, String str3, List<al8.c> list, String str4);

    z98 n();

    void o(AdvertAppInfo advertAppInfo);

    void p(HashMap<String, String> hashMap, Context context);
}
