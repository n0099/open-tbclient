package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.kwad.sdk.core.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.crash.utils.i;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class ExceptionMessage implements b, Serializable {
    public static final long serialVersionUID = -5338556142957298914L;
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
    public String mDumpsys = "";
    public int mCrashSource = 0;

    public static final String getSdkCrashVersionName(String str, int i) {
        return str + "-" + i;
    }

    public static final String getSdkVersionNameSuffix(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "-car" : "-pct" : "-ec" : "-ct" : "-ad";
    }

    public String getReportMsg() {
        return "UUID=" + this.mLogUUID + ",crashTime=" + h.a(this.mCurrentTimeStamp) + ",customMsg=" + this.mCustomMsg;
    }

    public final String getTypeCommon() {
        return getTypePrefix() + "COMMON";
    }

    public final String getTypeFdOOM() {
        return getTypePrefix() + "FD_OOM";
    }

    public final String getTypeHeapOOM() {
        return getTypePrefix() + "HEAP_OOM";
    }

    public abstract String getTypePrefix();

    public final String getTypeThreadOOM() {
        return getTypePrefix() + "THREAD_OOM";
    }

    @Override // com.kwad.sdk.core.b
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
        this.mDumpsys = jSONObject.optString("mDumpsys");
        this.mCrashSource = jSONObject.optInt("mCrashSource");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "mCrashDetail", this.mCrashDetail);
        r.a(jSONObject, "mMemoryInfo", this.mMemoryInfo);
        r.a(jSONObject, "mDiskInfo", this.mDiskInfo);
        r.a(jSONObject, "mProcessName", this.mProcessName);
        r.a(jSONObject, "mCrashType", this.mCrashType);
        r.a(jSONObject, "mThreadName", this.mThreadName);
        r.a(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
        r.a(jSONObject, "mLogUUID", this.mLogUUID);
        r.a(jSONObject, "mVirtualApp", this.mVirtualApp);
        r.a(jSONObject, "mCustomMsg", this.mCustomMsg);
        r.a(jSONObject, "mThreadOverflow", this.mThreadOverflow);
        r.a(jSONObject, "mFdOverflow", this.mFdOverflow);
        r.a(jSONObject, "mTaskId", this.mTaskId);
        r.a(jSONObject, "mErrorMessage", this.mErrorMessage);
        r.a(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
        r.a(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
        r.a(jSONObject, "mPid", this.mPid);
        r.a(jSONObject, "mTid", this.mTid);
        r.a(jSONObject, "mVersionCode", this.mVersionCode);
        r.a(jSONObject, "mVersionConflict", this.mVersionConflict);
        r.a(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
        r.a(jSONObject, "mJNIError", this.mJNIError);
        r.a(jSONObject, "mGCInfo", this.mGCInfo);
        r.a(jSONObject, "mLockInfo", this.mLockInfo);
        r.a(jSONObject, "mMonitorInfo", this.mMonitorInfo);
        r.a(jSONObject, "mSlowLooper", this.mSlowLooper);
        r.a(jSONObject, "mSlowOperation", this.mSlowOperation);
        r.a(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
        r.a(jSONObject, "mAbi", this.mAbi);
        r.a(jSONObject, "mDumpsys", this.mDumpsys);
        r.a(jSONObject, "mCrashSource", this.mCrashSource);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("异常状态汇总:\nUUID: ");
            sb.append(this.mLogUUID);
            sb.append("\nCPU架构: ");
            sb.append(this.mAbi);
            sb.append("\n异常进程: ");
            sb.append(this.mProcessName);
            sb.append(" (");
            sb.append(this.mPid);
            sb.append(")\n");
            sb.append("异常线程: ");
            sb.append(this.mThreadName);
            sb.append(" (");
            sb.append(this.mTid);
            sb.append(")\n");
            sb.append("异常类型: ");
            sb.append(this.mCrashType);
            sb.append("\n应用多开环境: ");
            sb.append(this.mVirtualApp);
            sb.append("\nTaskId: ");
            sb.append(this.mTaskId);
            sb.append("\nmTid: ");
            sb.append(this.mTid);
            sb.append("\n自定义信息: ");
            sb.append(this.mCustomMsg);
            sb.append("\n前后台状态: ");
            sb.append(this.mIsAppOnForeground);
            sb.append("\n异常发生时间: ");
            sb.append(h.a(this.mCurrentTimeStamp));
            sb.append("\n版本号: ");
            sb.append(this.mVersionCode);
            sb.append("\n升级前版本号: ");
            sb.append(this.mAppVersionBeforeLastUpload);
            sb.append("\n使用时长: ");
            sb.append(i.a(this.mUsageTimeMills));
            sb.append("\n异常详情: \n");
            sb.append(this instanceof JavaExceptionMessage ? this.mCrashDetail.replace(SevenZipUtils.FILE_SEP, "\n\t").replace("#", "\n") : this.mCrashDetail);
            sb.append("\n磁盘详情: \n");
            sb.append(this.mDiskInfo);
            sb.append("\n");
            if (!TextUtils.isEmpty(this.mErrorMessage)) {
                sb.append("异常上报Debug: \n");
                sb.append(this.mErrorMessage);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                sb.append("BuildConfig信息: \n");
                sb.append(this.mBuildConfigInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mJNIError)) {
                sb.append("JNI异常: \n");
                sb.append(this.mJNIError);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mGCInfo)) {
                sb.append("GC耗时: \n");
                sb.append(this.mGCInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mLockInfo)) {
                sb.append("锁耗时(dvm_lock_sample): \n");
                sb.append(this.mLockInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                sb.append("锁耗时(monitor): \n");
                sb.append(this.mMonitorInfo);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowLooper)) {
                sb.append("Looper耗时: \n");
                sb.append(this.mSlowLooper);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowOperation)) {
                sb.append("AMS调度耗时: \n");
                sb.append(this.mSlowOperation);
                sb.append("\n");
            }
            sb.append("内存详情: \n");
            sb.append(this.mMemoryInfo);
            sb.append("\n");
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
        }
        return sb.substring(0);
    }
}
