package d.a.q0.w2.b0;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import d.a.p0.b1.c;
/* loaded from: classes8.dex */
public interface b extends IAdBaseAsyncController {
    void b(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo);

    int c();

    boolean d(@NonNull String str);

    void e(@NonNull c cVar);

    View f(@NonNull String str);

    void h(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z);

    void i(@NonNull String str);

    void j(@NonNull AdvertAppInfo advertAppInfo);

    boolean k();

    void l(String str);

    void onDestroy();
}
