package d.a.p0.w2.b0;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes8.dex */
public interface b extends IAdBaseAsyncController {
    void b(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo);

    int c();

    boolean d(@NonNull String str);

    View e(@NonNull String str);

    void g(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z);

    void h(@NonNull String str);

    void i(@NonNull AdvertAppInfo advertAppInfo);

    boolean j();

    void k(String str);

    void onDestroy();
}
