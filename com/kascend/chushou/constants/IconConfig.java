package com.kascend.chushou.constants;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class IconConfig {
    public static final int TYPE_GUESS = 3;
    public static final int TYPE_PRIVILEGE = 5;
    public static final int TYPE_SHOP = 4;
    public static final int TYPE_TASK = 2;
    public Config payConfig = new Config();
    public Config giftConfig = new Config();
    public Config bangConfig = new Config();
    public List<ConfigDetail> configs = new ArrayList();

    /* loaded from: classes4.dex */
    public static class Config {
        public int type;
        public boolean display = true;
        public String icon = "";
        public String notifyIcon = "";
        public String name = "";
    }
}
