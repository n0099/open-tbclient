package com.kwad.framework.filedownloader.exception;

import com.kwad.framework.filedownloader.f.f;
/* loaded from: classes10.dex */
public class PathConflictException extends IllegalAccessException {
    public final int mAnotherSamePathTaskId;
    public final String mDownloadingConflictPath;
    public final String mTargetFilePath;

    public PathConflictException(int i, String str, String str2) {
        super(f.b("There is an another running task(%d) with the same downloading path(%s), because of they are with the same target-file-path(%s), so if the current task is started, the path of the file is sure to be written by multiple tasks, it is wrong, then you receive this exception to avoid such conflict.", Integer.valueOf(i), str, str2));
        this.mAnotherSamePathTaskId = i;
        this.mDownloadingConflictPath = str;
        this.mTargetFilePath = str2;
    }

    public int getAnotherSamePathTaskId() {
        return this.mAnotherSamePathTaskId;
    }

    public String getDownloadingConflictPath() {
        return this.mDownloadingConflictPath;
    }

    public String getTargetFilePath() {
        return this.mTargetFilePath;
    }
}
