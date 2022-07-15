package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes6.dex */
public interface hm5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || tm4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(ql4 ql4Var);

    String f();

    void show();
}
