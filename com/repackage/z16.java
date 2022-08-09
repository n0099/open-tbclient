package com.repackage;

import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
/* loaded from: classes7.dex */
public interface z16 {

    /* loaded from: classes7.dex */
    public interface a {
        void onProgress(long j);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a(String str);

        boolean b();
    }

    boolean a(QmFilterItem qmFilterItem);

    boolean b(QmStickerItem qmStickerItem);

    boolean c();

    boolean d();

    wy5 e();

    ty5 f();

    boolean onDestroy();

    boolean onPause();

    boolean onResume();

    boolean startRecord();

    boolean stopRecord();
}
