package com.repackage;

import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes7.dex */
public interface ua8 extends IAdBaseAsyncController {
    @Nullable
    AdvertAppInfo d(@Nullable vb5 vb5Var);

    u98 i(ViewStub viewStub, TbPageContext tbPageContext);

    void onDestroy();
}
