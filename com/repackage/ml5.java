package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes6.dex */
public interface ml5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || um4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(tl4 tl4Var);

    String f();

    void show();
}
