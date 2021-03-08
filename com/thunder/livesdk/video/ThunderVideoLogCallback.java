package com.thunder.livesdk.video;

import com.thunder.livesdk.log.ThunderLog;
import com.yy.mediaframework.utils.ILog;
/* loaded from: classes6.dex */
public class ThunderVideoLogCallback implements ILog, com.yy.videoplayer.utils.ILog {

    /* loaded from: classes6.dex */
    private static class SingletonHolder {
        private static final ThunderVideoLogCallback INSTANCE = new ThunderVideoLogCallback();

        private SingletonHolder() {
        }
    }

    public static ThunderVideoLogCallback sharedInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override // com.yy.mediaframework.utils.ILog, com.yy.videoplayer.utils.ILog
    public void verbose(String str, String str2) {
        ThunderLog.logM(0, 102, str, str2);
    }

    @Override // com.yy.mediaframework.utils.ILog, com.yy.videoplayer.utils.ILog
    public void debug(String str, String str2) {
        ThunderLog.logM(1, 102, str, str2);
    }

    @Override // com.yy.mediaframework.utils.ILog, com.yy.videoplayer.utils.ILog
    public void info(String str, String str2) {
        ThunderLog.logM(2, 102, str, str2);
    }

    @Override // com.yy.mediaframework.utils.ILog, com.yy.videoplayer.utils.ILog
    public void warn(String str, String str2) {
        ThunderLog.logM(3, 102, str, str2);
    }

    @Override // com.yy.mediaframework.utils.ILog, com.yy.videoplayer.utils.ILog
    public void error(String str, String str2) {
        ThunderLog.logM(4, 102, str, str2);
    }

    @Override // com.yy.mediaframework.utils.ILog, com.yy.videoplayer.utils.ILog
    public void error(String str, String str2, Throwable th) {
    }
}
