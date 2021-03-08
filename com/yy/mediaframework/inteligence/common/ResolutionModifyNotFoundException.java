package com.yy.mediaframework.inteligence.common;

import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class ResolutionModifyNotFoundException extends Exception {
    public ResolutionModifyNotFoundException(int i, int i2, int i3) {
        super("Not found config " + i + Config.EVENT_HEAT_X + i2 + ", codeRate:" + i3);
    }
}
