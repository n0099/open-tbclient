package com.kwai.video.cache;
/* loaded from: classes5.dex */
public interface CacheSessionListener {
    public static final int STOP_REASON_BYTE_RANGE_INVALID = 7;
    public static final int STOP_REASON_CANCELLED = 2;
    public static final int STOP_REASON_CONTENT_LENGTH_INVALID = 6;
    public static final int STOP_REASON_END = 9;
    public static final int STOP_REASON_FAILED = 3;
    public static final int STOP_REASON_FINISHED = 1;
    public static final int STOP_REASON_NO_CONTENT_LENGTH = 5;
    public static final int STOP_REASON_RESOLVE_HOST_FAIL = 8;
    public static final int STOP_REASON_TIMEOUT = 4;
    public static final int STOP_REASON_UNKNOWN = 0;
    public static final int STOP_REASON_UNNET = -1;

    /* loaded from: classes5.dex */
    public static class Util {
        public static boolean needRetryOnThisStopReasonCode(int i) {
            switch (i) {
                case 1:
                case 2:
                    return false;
                default:
                    return true;
            }
        }

        public static String stopReasonToString(int i) {
            return AcCallBackInfo.stopReasonToString(i);
        }
    }

    void onDownloadPaused();

    void onDownloadProgress(long j, long j2);

    void onDownloadResumed();

    void onDownloadStarted(long j, String str, String str2, String str3, int i, long j2);

    void onDownloadStopped(int i, long j, long j2, String str, int i2, String str2, String str3, String str4, String str5);

    void onSessionClosed(int i, long j, long j2, long j3, String str, boolean z);

    void onSessionStart(String str, long j, long j2, long j3);
}
