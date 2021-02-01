package com.yy.mediaframework;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class Passthrough {
    public static final int DATA_USE_PTS_STRATEGY = 1;
    public static final int PASSTHROUGH_LIVESDK_TO_VIDEOLIB = 1;
    public static final int PASSTHROUGH_LIVESDK_TO_YYCLOUD = 4;
    public static final int PASSTHROUGH_VIDEOLIB_TO_LIVESDK = 2;
    public static final int PASSTHROUGH_VIDEOLIB_TO_YYCLOUD = 3;

    /* loaded from: classes4.dex */
    public interface DataType {
        public static final int UPLOAD_TO_HIIDO = 1;
    }

    /* loaded from: classes4.dex */
    public static class METUseNewPtsStrategy extends HashMap<String, Object> {
        public static final String ptsStrategyKey = "DATA_USE_NEW_PTS_STRATEGY";
    }
}
