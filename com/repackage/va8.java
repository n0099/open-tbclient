package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes7.dex */
public interface va8 extends IAdBaseAsyncController {
    View b(@NonNull String str, boolean z);

    AdvertAppInfo e(@NonNull String str);

    void f(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo);

    boolean g(@NonNull String str);

    int getAdCount();

    void h(@NonNull vb5 vb5Var);

    void j(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z);

    void l(@NonNull String str);

    void m(@NonNull AdvertAppInfo advertAppInfo);

    void n();

    void onDestroy();

    boolean p();

    void q(String str);
}
