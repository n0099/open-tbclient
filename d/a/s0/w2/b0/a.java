package d.a.s0.w2.b0;

import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import d.a.r0.z0.c;
import d.a.s0.w2.n;
/* loaded from: classes9.dex */
public interface a extends IAdBaseAsyncController {
    @Nullable
    AdvertAppInfo a(@Nullable c cVar);

    n b(ViewStub viewStub, TbPageContext tbPageContext);

    void onDestroy();
}
