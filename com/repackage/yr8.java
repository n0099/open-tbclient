package com.repackage;

import android.graphics.Bitmap;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes7.dex */
public interface yr8 {
    void clearFinalVideoPath();

    void finishPage();

    void onCheckUegFail(String str);

    void onCheckUegSuccess();

    void onGetCoverBitmap(Bitmap bitmap);

    void onNext();

    void onSave();

    void onSaveCover(String str);

    void setPendantData(List<PendantData> list);
}
