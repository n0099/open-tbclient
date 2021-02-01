package com.bytedance.tea.crash;

import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public enum c {
    LAUNCH(Config.LAUNCH),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");
    
    private String j;

    c(String str) {
        this.j = str;
    }

    public String a() {
        return this.j;
    }
}
