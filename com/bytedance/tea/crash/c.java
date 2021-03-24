package com.bytedance.tea.crash;

import com.baidu.mobstat.Config;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteHelper;
/* loaded from: classes6.dex */
public enum c {
    LAUNCH(Config.LAUNCH),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK(BreakpointSQLiteHelper.BLOCK_TABLE_NAME),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");
    
    public String j;

    c(String str) {
        this.j = str;
    }

    public String a() {
        return this.j;
    }
}
