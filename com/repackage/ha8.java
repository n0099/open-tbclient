package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public interface ha8 {
    eo<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    ca8 b();

    x98 c();

    eo<?, ?> d(ga8 ga8Var, BdUniqueId bdUniqueId);

    void e();

    List<AdvertAppInfo> f();

    eo<?, ?> g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController h(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    ea8 i();

    void j(AdvertAppInfo advertAppInfo);

    void k(HashMap<String, String> hashMap, Context context);
}
