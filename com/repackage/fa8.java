package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes6.dex */
public interface fa8 extends IAdBaseAsyncController {
    View b(@NonNull String str, boolean z);

    AdvertAppInfo d(@NonNull String str);

    void e(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo);

    boolean f(@NonNull String str);

    void g(@NonNull wc5 wc5Var);

    int getAdCount();

    void h(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z);

    void j(@NonNull String str);

    void k(@NonNull AdvertAppInfo advertAppInfo);

    void l();

    boolean n();

    void o(String str);

    void onDestroy();
}
