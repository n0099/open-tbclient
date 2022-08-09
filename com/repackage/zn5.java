package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes7.dex */
public interface zn5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || ln4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(im4 im4Var);

    String f();

    void show();
}
