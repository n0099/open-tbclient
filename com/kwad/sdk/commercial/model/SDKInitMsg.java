package com.kwad.sdk.commercial.model;

import android.content.Context;
import android.os.Looper;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.utils.an;
import java.io.Serializable;
@KsJson
/* loaded from: classes5.dex */
public class SDKInitMsg extends a implements Serializable {
    public static final int CHILD_PROCESS = 2;
    public static final int FAIL = 2;
    public static final int FINISH = 1;
    public static final int MAIN_PROCESS = 1;
    public static final int MAIN_THREAD = 1;
    public static final int START = 0;
    public static final int WORK_THREAD = 2;
    public static final long serialVersionUID = 368743526206619387L;
    public String errorReason;
    public int initCount;
    public int initProcess;
    public int initStatus;
    public int initThread;
    public long launchIntervalTime;
    public double ratioCount;
    public long totalDurationTime;

    public SDKInitMsg(Context context) {
        this.initProcess = an.isInMainProcess(context) ? 1 : 2;
        this.initThread = Looper.getMainLooper() != Looper.myLooper() ? 2 : 1;
    }

    public SDKInitMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public SDKInitMsg setInitCount(int i) {
        this.initCount = i;
        return this;
    }

    public SDKInitMsg setInitStatus(int i) {
        this.initStatus = i;
        return this;
    }

    public SDKInitMsg setLaunchIntervalTime(long j) {
        this.launchIntervalTime = j;
        return this;
    }

    public SDKInitMsg setRatioCount(double d) {
        this.ratioCount = d;
        return this;
    }

    public SDKInitMsg setTotalDurationTime(long j) {
        this.totalDurationTime = j;
        return this;
    }
}
