package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes5.dex */
public interface el5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || em4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(bl4 bl4Var);

    String f();

    void show();
}
