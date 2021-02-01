package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.crash.utils.i;
import com.kwad.sdk.crash.utils.j;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class ExceptionMessage implements b, Serializable {
    private static final long serialVersionUID = -5338556142957298914L;
    public long mCurrentTimeStamp;
    public int mPid;
    public int mTid;
    public long mUsageTimeMills;
    public String mCrashDetail = "Unknown";
    public String mMemoryInfo = "Unknown";
    public String mDiskInfo = "Unknown";
    public String mProcessName = "Unknown";
    public int mExceptionType = 0;
    public String mCrashType = getTypeCommon();
    public String mThreadName = "Unknown";
    public String mIsAppOnForeground = "Unknown";
    public String mLogUUID = "Unknown";
    public String mVirtualApp = "Unknown";
    public String mCustomMsg = "Unknown";
    public String mThreadOverflow = "Unknown";
    public String mFdOverflow = "Unknown";
    public String mTaskId = "Unknown";
    public String mErrorMessage = "";
    public String mVersionCode = "Unknown";
    public boolean mVersionConflict = false;
    public String mAppVersionBeforeLastUpload = "Unknown";
    public String mJNIError = "";
    public String mGCInfo = "";
    public String mLockInfo = "";
    public String mMonitorInfo = "";
    public String mSlowLooper = "";
    public String mSlowOperation = "";
    public String mBuildConfigInfo = "";
    public String mAbi = "Unknown";

    public final String getTypeCommon() {
        return getTypePrefix() + "COMMON";
    }

    public final String getTypeFdOOM() {
        return getTypePrefix() + "FD_OOM";
    }

    public final String getTypeHeapOOM() {
        return getTypePrefix() + "HEAP_OOM";
    }

    protected abstract String getTypePrefix();

    public final String getTypeThreadOOM() {
        return getTypePrefix() + "THREAD_OOM";
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mCrashDetail = jSONObject.optString("mCrashDetail");
        this.mMemoryInfo = jSONObject.optString("mMemoryInfo");
        this.mDiskInfo = jSONObject.optString("mDiskInfo");
        this.mProcessName = jSONObject.optString("mProcessName");
        this.mCrashType = jSONObject.optString("mCrashType");
        this.mThreadName = jSONObject.optString("mThreadName");
        this.mIsAppOnForeground = jSONObject.optString("mIsAppOnForeground");
        this.mLogUUID = jSONObject.optString("mLogUUID");
        this.mVirtualApp = jSONObject.optString("mVirtualApp");
        this.mCustomMsg = jSONObject.optString("mCustomMsg");
        this.mThreadOverflow = jSONObject.optString("mThreadOverflow");
        this.mFdOverflow = jSONObject.optString("mFdOverflow");
        this.mTaskId = jSONObject.optString("mTaskId");
        this.mErrorMessage = jSONObject.optString("mErrorMessage");
        this.mCurrentTimeStamp = jSONObject.optLong("mCurrentTimeStamp");
        this.mUsageTimeMills = jSONObject.optLong("mUsageTimeMills");
        this.mPid = jSONObject.optInt("mPid");
        this.mTid = jSONObject.optInt("mTid");
        this.mVersionCode = jSONObject.optString("mVersionCode");
        this.mVersionConflict = jSONObject.optBoolean("mVersionConflict");
        this.mAppVersionBeforeLastUpload = jSONObject.optString("mAppVersionBeforeLastUpload");
        this.mJNIError = jSONObject.optString("mJNIError");
        this.mGCInfo = jSONObject.optString("mGCInfo");
        this.mLockInfo = jSONObject.optString("mLockInfo");
        this.mMonitorInfo = jSONObject.optString("mMonitorInfo");
        this.mSlowLooper = jSONObject.optString("mSlowLooper");
        this.mSlowOperation = jSONObject.optString("mSlowOperation");
        this.mBuildConfigInfo = jSONObject.optString("mBuildConfigInfo");
        this.mAbi = jSONObject.optString("mAbi");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "mCrashDetail", this.mCrashDetail);
        o.a(jSONObject, "mMemoryInfo", this.mMemoryInfo);
        o.a(jSONObject, "mDiskInfo", this.mDiskInfo);
        o.a(jSONObject, "mProcessName", this.mProcessName);
        o.a(jSONObject, "mCrashType", this.mCrashType);
        o.a(jSONObject, "mThreadName", this.mThreadName);
        o.a(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
        o.a(jSONObject, "mLogUUID", this.mLogUUID);
        o.a(jSONObject, "mVirtualApp", this.mVirtualApp);
        o.a(jSONObject, "mCustomMsg", this.mCustomMsg);
        o.a(jSONObject, "mThreadOverflow", this.mThreadOverflow);
        o.a(jSONObject, "mFdOverflow", this.mFdOverflow);
        o.a(jSONObject, "mTaskId", this.mTaskId);
        o.a(jSONObject, "mErrorMessage", this.mErrorMessage);
        o.a(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
        o.a(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
        o.a(jSONObject, "mPid", this.mPid);
        o.a(jSONObject, "mTid", this.mTid);
        o.a(jSONObject, "mVersionCode", this.mVersionCode);
        o.a(jSONObject, "mVersionConflict", this.mVersionConflict);
        o.a(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
        o.a(jSONObject, "mJNIError", this.mJNIError);
        o.a(jSONObject, "mGCInfo", this.mGCInfo);
        o.a(jSONObject, "mLockInfo", this.mLockInfo);
        o.a(jSONObject, "mMonitorInfo", this.mMonitorInfo);
        o.a(jSONObject, "mSlowLooper", this.mSlowLooper);
        o.a(jSONObject, "mSlowOperation", this.mSlowOperation);
        o.a(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
        o.a(jSONObject, "mAbi", this.mAbi);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("异常状态汇总:\n").append("UUID: ").append(this.mLogUUID).append("\n").append("CPU架构: ").append(this.mAbi).append("\n").append("异常进程: ").append(this.mProcessName).append(" (").append(this.mPid).append(")").append("\n").append("异常线程: ").append(this.mThreadName).append(" (").append(this.mTid).append(")").append("\n").append("异常类型: ").append(this.mCrashType).append("\n").append("应用多开环境: ").append(this.mVirtualApp).append("\n").append("TaskId: ").append(this.mTaskId).append("\n").append("mTid: ").append(this.mTid).append("\n").append("自定义信息: ").append(this.mCustomMsg).append("\n").append("前后台状态: ").append(this.mIsAppOnForeground).append("\n").append("异常发生时间: ").append(i.a(this.mCurrentTimeStamp)).append("\n").append("版本号: ").append(this.mVersionCode).append("\n").append("升级前版本号: ").append(this.mAppVersionBeforeLastUpload).append("\n").append("使用时长: ").append(j.a(this.mUsageTimeMills)).append("\n").append("异常详情: \n");
            if (this instanceof JavaExceptionMessage) {
                sb.append(this.mCrashDetail.replace("##", "\n\t").replace("#", "\n"));
            } else {
                sb.append(this.mCrashDetail);
            }
            sb.append("\n").append("磁盘详情: \n").append(this.mDiskInfo).append("\n");
            if (!TextUtils.isEmpty(this.mErrorMessage)) {
                sb.append("异常上报Debug: \n").append(this.mErrorMessage).append("\n");
            }
            if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                sb.append("BuildConfig信息: \n").append(this.mBuildConfigInfo).append("\n");
            }
            if (!TextUtils.isEmpty(this.mJNIError)) {
                sb.append("JNI异常: \n").append(this.mJNIError).append("\n");
            }
            if (!TextUtils.isEmpty(this.mGCInfo)) {
                sb.append("GC耗时: \n").append(this.mGCInfo).append("\n");
            }
            if (!TextUtils.isEmpty(this.mLockInfo)) {
                sb.append("锁耗时(dvm_lock_sample): \n").append(this.mLockInfo).append("\n");
            }
            if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                sb.append("锁耗时(monitor): \n").append(this.mMonitorInfo).append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowLooper)) {
                sb.append("Looper耗时: \n").append(this.mSlowLooper).append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowOperation)) {
                sb.append("AMS调度耗时: \n").append(this.mSlowOperation).append("\n");
            }
            sb.append("内存详情: \n").append(this.mMemoryInfo).append("\n");
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        return sb.substring(0);
    }
}
