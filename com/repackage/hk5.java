package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes6.dex */
public interface hk5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || ul4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(rk4 rk4Var);

    String f();

    void show();
}
