package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes6.dex */
public interface nl5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || fn4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(em4 em4Var);

    String f();

    void show();
}
