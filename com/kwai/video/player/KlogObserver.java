package com.kwai.video.player;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface KlogObserver {
    public static final int kLevelAll = 0;
    public static final int kLevelDebug = 0;
    public static final int kLevelError = 3;
    public static final int kLevelInfo = 1;
    public static final int kLevelNone = 4;
    public static final int kLevelWarn = 2;

    /* loaded from: classes7.dex */
    public static class KlogParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String filePath;
        public boolean isConsoleEnable;
        public boolean isFileEnable;
        public KlogObserver logCb;
        public int logLevel;
        public int maxFileNum;
        public int maxFileSize;
        public long nativeLogFunctionPtr;

        public KlogParam() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.logLevel = 0;
            this.isConsoleEnable = true;
            this.isFileEnable = false;
            this.maxFileSize = 5242880;
            this.maxFileNum = 3;
            this.logCb = null;
            this.nativeLogFunctionPtr = 0L;
        }
    }

    void onLog(int i2, byte[] bArr);
}
