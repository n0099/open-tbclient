package com.kwai.video.hodor;

import com.baidubce.services.bos.BosClientConfiguration;
/* loaded from: classes4.dex */
public interface KlogObserver {
    public static final int kLevelAll = 0;
    public static final int kLevelDebug = 0;
    public static final int kLevelError = 3;
    public static final int kLevelInfo = 1;
    public static final int kLevelNone = 4;
    public static final int kLevelWarn = 2;

    /* loaded from: classes4.dex */
    public static class KlogParam {
        public String filePath;
        public int logLevel = 0;
        public boolean isConsoleEnable = true;
        public boolean isFileEnable = false;
        public int maxFileSize = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
        public int maxFileNum = 3;
        public KlogObserver logCb = null;
        public long nativeLogFunctionPtr = 0;
    }

    void onLog(int i, byte[] bArr);
}
