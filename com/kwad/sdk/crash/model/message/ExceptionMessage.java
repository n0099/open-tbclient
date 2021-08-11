package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.kwad.sdk.core.b;
import com.kwad.sdk.crash.utils.i;
import com.kwad.sdk.crash.utils.j;
import com.kwad.sdk.utils.q;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class ExceptionMessage implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5338556142957298914L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAbi;
    public String mAppVersionBeforeLastUpload;
    public String mBuildConfigInfo;
    public String mCrashDetail;
    public String mCrashType;
    public long mCurrentTimeStamp;
    public String mCustomMsg;
    public String mDiskInfo;
    public String mErrorMessage;
    public int mExceptionType;
    public String mFdOverflow;
    public String mGCInfo;
    public String mIsAppOnForeground;
    public String mJNIError;
    public String mLockInfo;
    public String mLogUUID;
    public String mMemoryInfo;
    public String mMonitorInfo;
    public int mPid;
    public String mProcessName;
    public String mSlowLooper;
    public String mSlowOperation;
    public String mTaskId;
    public String mThreadName;
    public String mThreadOverflow;
    public int mTid;
    public long mUsageTimeMills;
    public String mVersionCode;
    public boolean mVersionConflict;
    public String mVirtualApp;

    public ExceptionMessage() {
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
        this.mCrashDetail = "Unknown";
        this.mMemoryInfo = "Unknown";
        this.mDiskInfo = "Unknown";
        this.mProcessName = "Unknown";
        this.mExceptionType = 0;
        this.mCrashType = getTypeCommon();
        this.mThreadName = "Unknown";
        this.mIsAppOnForeground = "Unknown";
        this.mLogUUID = "Unknown";
        this.mVirtualApp = "Unknown";
        this.mCustomMsg = "Unknown";
        this.mThreadOverflow = "Unknown";
        this.mFdOverflow = "Unknown";
        this.mTaskId = "Unknown";
        this.mErrorMessage = "";
        this.mVersionCode = "Unknown";
        this.mVersionConflict = false;
        this.mAppVersionBeforeLastUpload = "Unknown";
        this.mJNIError = "";
        this.mGCInfo = "";
        this.mLockInfo = "";
        this.mMonitorInfo = "";
        this.mSlowLooper = "";
        this.mSlowOperation = "";
        this.mBuildConfigInfo = "";
        this.mAbi = "Unknown";
    }

    public final String getTypeCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getTypePrefix() + "COMMON";
        }
        return (String) invokeV.objValue;
    }

    public final String getTypeFdOOM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getTypePrefix() + "FD_OOM";
        }
        return (String) invokeV.objValue;
    }

    public final String getTypeHeapOOM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getTypePrefix() + "HEAP_OOM";
        }
        return (String) invokeV.objValue;
    }

    public abstract String getTypePrefix();

    public final String getTypeThreadOOM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getTypePrefix() + "THREAD_OOM";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "mCrashDetail", this.mCrashDetail);
            q.a(jSONObject, "mMemoryInfo", this.mMemoryInfo);
            q.a(jSONObject, "mDiskInfo", this.mDiskInfo);
            q.a(jSONObject, "mProcessName", this.mProcessName);
            q.a(jSONObject, "mCrashType", this.mCrashType);
            q.a(jSONObject, "mThreadName", this.mThreadName);
            q.a(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
            q.a(jSONObject, "mLogUUID", this.mLogUUID);
            q.a(jSONObject, "mVirtualApp", this.mVirtualApp);
            q.a(jSONObject, "mCustomMsg", this.mCustomMsg);
            q.a(jSONObject, "mThreadOverflow", this.mThreadOverflow);
            q.a(jSONObject, "mFdOverflow", this.mFdOverflow);
            q.a(jSONObject, "mTaskId", this.mTaskId);
            q.a(jSONObject, "mErrorMessage", this.mErrorMessage);
            q.a(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
            q.a(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
            q.a(jSONObject, "mPid", this.mPid);
            q.a(jSONObject, "mTid", this.mTid);
            q.a(jSONObject, "mVersionCode", this.mVersionCode);
            q.a(jSONObject, "mVersionConflict", this.mVersionConflict);
            q.a(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
            q.a(jSONObject, "mJNIError", this.mJNIError);
            q.a(jSONObject, "mGCInfo", this.mGCInfo);
            q.a(jSONObject, "mLockInfo", this.mLockInfo);
            q.a(jSONObject, "mMonitorInfo", this.mMonitorInfo);
            q.a(jSONObject, "mSlowLooper", this.mSlowLooper);
            q.a(jSONObject, "mSlowOperation", this.mSlowOperation);
            q.a(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
            q.a(jSONObject, "mAbi", this.mAbi);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("异常状态汇总:\n");
                sb.append("UUID: ");
                sb.append(this.mLogUUID);
                sb.append(StringUtils.LF);
                sb.append("CPU架构: ");
                sb.append(this.mAbi);
                sb.append(StringUtils.LF);
                sb.append("异常进程: ");
                sb.append(this.mProcessName);
                sb.append(" (");
                sb.append(this.mPid);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append(StringUtils.LF);
                sb.append("异常线程: ");
                sb.append(this.mThreadName);
                sb.append(" (");
                sb.append(this.mTid);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append(StringUtils.LF);
                sb.append("异常类型: ");
                sb.append(this.mCrashType);
                sb.append(StringUtils.LF);
                sb.append("应用多开环境: ");
                sb.append(this.mVirtualApp);
                sb.append(StringUtils.LF);
                sb.append("TaskId: ");
                sb.append(this.mTaskId);
                sb.append(StringUtils.LF);
                sb.append("mTid: ");
                sb.append(this.mTid);
                sb.append(StringUtils.LF);
                sb.append("自定义信息: ");
                sb.append(this.mCustomMsg);
                sb.append(StringUtils.LF);
                sb.append("前后台状态: ");
                sb.append(this.mIsAppOnForeground);
                sb.append(StringUtils.LF);
                sb.append("异常发生时间: ");
                sb.append(i.a(this.mCurrentTimeStamp));
                sb.append(StringUtils.LF);
                sb.append("版本号: ");
                sb.append(this.mVersionCode);
                sb.append(StringUtils.LF);
                sb.append("升级前版本号: ");
                sb.append(this.mAppVersionBeforeLastUpload);
                sb.append(StringUtils.LF);
                sb.append("使用时长: ");
                sb.append(j.a(this.mUsageTimeMills));
                sb.append(StringUtils.LF);
                sb.append("异常详情: \n");
                sb.append(this instanceof JavaExceptionMessage ? this.mCrashDetail.replace(SevenZipUtils.FILE_SEP, "\n\t").replace("#", StringUtils.LF) : this.mCrashDetail);
                sb.append(StringUtils.LF);
                sb.append("磁盘详情: \n");
                sb.append(this.mDiskInfo);
                sb.append(StringUtils.LF);
                if (!TextUtils.isEmpty(this.mErrorMessage)) {
                    sb.append("异常上报Debug: \n");
                    sb.append(this.mErrorMessage);
                    sb.append(StringUtils.LF);
                }
                if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                    sb.append("BuildConfig信息: \n");
                    sb.append(this.mBuildConfigInfo);
                    sb.append(StringUtils.LF);
                }
                if (!TextUtils.isEmpty(this.mJNIError)) {
                    sb.append("JNI异常: \n");
                    sb.append(this.mJNIError);
                    sb.append(StringUtils.LF);
                }
                if (!TextUtils.isEmpty(this.mGCInfo)) {
                    sb.append("GC耗时: \n");
                    sb.append(this.mGCInfo);
                    sb.append(StringUtils.LF);
                }
                if (!TextUtils.isEmpty(this.mLockInfo)) {
                    sb.append("锁耗时(dvm_lock_sample): \n");
                    sb.append(this.mLockInfo);
                    sb.append(StringUtils.LF);
                }
                if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                    sb.append("锁耗时(monitor): \n");
                    sb.append(this.mMonitorInfo);
                    sb.append(StringUtils.LF);
                }
                if (!TextUtils.isEmpty(this.mSlowLooper)) {
                    sb.append("Looper耗时: \n");
                    sb.append(this.mSlowLooper);
                    sb.append(StringUtils.LF);
                }
                if (!TextUtils.isEmpty(this.mSlowOperation)) {
                    sb.append("AMS调度耗时: \n");
                    sb.append(this.mSlowOperation);
                    sb.append(StringUtils.LF);
                }
                sb.append("内存详情: \n");
                sb.append(this.mMemoryInfo);
                sb.append(StringUtils.LF);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
            return sb.substring(0);
        }
        return (String) invokeV.objValue;
    }
}
