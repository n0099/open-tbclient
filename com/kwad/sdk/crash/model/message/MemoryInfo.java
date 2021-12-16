package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MemoryInfo implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4944913077323984734L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ThreadInfo> mAllThreads;
    public int mAvailableMB;
    public int mFdCount;
    public List<String> mFds;
    public int mJavaHeapLimitMB;
    public int mJavaHeapMB;
    public List<ThreadInfo> mJavaThreads;
    public List<ThreadInfo> mNativeThreads;
    public int mPssMB;
    public int mRssMB;
    public int mThreadsCount;
    public int mTotalMB;
    public int mVssMB;

    public MemoryInfo() {
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
        this.mFds = new ArrayList();
        this.mJavaThreads = new ArrayList();
        this.mNativeThreads = new ArrayList();
        this.mAllThreads = new ArrayList();
    }

    public MemoryInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFds = new ArrayList();
        this.mJavaThreads = new ArrayList();
        this.mNativeThreads = new ArrayList();
        this.mAllThreads = new ArrayList();
        try {
            if (TextUtils.isEmpty(str) || "Unknown".equals(str)) {
                return;
            }
            parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.mTotalMB = jSONObject.optInt("mTotalMB");
        this.mAvailableMB = jSONObject.optInt("mAvailableMB");
        this.mJavaHeapLimitMB = jSONObject.optInt("mJavaHeapLimitMB");
        this.mJavaHeapMB = jSONObject.optInt("mJavaHeapMB");
        this.mVssMB = jSONObject.optInt("mVssMB");
        this.mRssMB = jSONObject.optInt("mRssMB");
        this.mPssMB = jSONObject.optInt("mPssMB");
        this.mThreadsCount = jSONObject.optInt("mThreadsCount");
        this.mFdCount = jSONObject.optInt("mFdCount");
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("mFds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (optString != null && !optString.isEmpty()) {
                        this.mFds.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mJavaThreads");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject != null) {
                        ThreadInfo threadInfo = new ThreadInfo();
                        threadInfo.parseJson(optJSONObject);
                        this.mJavaThreads.add(threadInfo);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("mNativeThreads");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i4);
                    if (optJSONObject2 != null) {
                        ThreadInfo threadInfo2 = new ThreadInfo();
                        threadInfo2.parseJson(optJSONObject2);
                        this.mNativeThreads.add(threadInfo2);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("mAllThreads");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                return;
            }
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i5);
                if (optJSONObject3 != null) {
                    ThreadInfo threadInfo3 = new ThreadInfo();
                    threadInfo3.parseJson(optJSONObject3);
                    this.mAllThreads.add(threadInfo3);
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "mTotalMB", this.mTotalMB);
            t.a(jSONObject, "mAvailableMB", this.mAvailableMB);
            t.a(jSONObject, "mJavaHeapLimitMB", this.mJavaHeapLimitMB);
            t.a(jSONObject, "mJavaHeapMB", this.mJavaHeapMB);
            t.a(jSONObject, "mVssMB", this.mVssMB);
            t.a(jSONObject, "mRssMB", this.mRssMB);
            t.a(jSONObject, "mPssMB", this.mPssMB);
            t.a(jSONObject, "mThreadsCount", this.mThreadsCount);
            t.a(jSONObject, "mFdCount", this.mFdCount);
            t.a(jSONObject, "mFds", this.mFds);
            t.a(jSONObject, "mJavaThreads", this.mJavaThreads);
            t.a(jSONObject, "mNativeThreads", this.mNativeThreads);
            t.a(jSONObject, "mAllThreads", this.mAllThreads);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t总RAM容量: ");
            sb.append(this.mTotalMB);
            sb.append(" (MB)\n");
            sb.append("\t剩余RAM容量: ");
            sb.append(this.mAvailableMB);
            sb.append(" (MB)\n");
            sb.append("\t本进程Java堆上限: ");
            sb.append(this.mJavaHeapLimitMB);
            sb.append(" (MB)\n");
            sb.append("\t本进程Java堆已使用: ");
            sb.append(this.mJavaHeapMB);
            sb.append(" (MB)\n");
            sb.append("\t虚拟地址空间已使用Vss: ");
            sb.append(this.mVssMB);
            sb.append(" (MB)\n");
            sb.append("\t实际空间使用量(包含共享库) Rss: ");
            sb.append(this.mRssMB);
            sb.append(" (MB)\n");
            sb.append("\t实际空间使用量(共享库已经均摊)(高内存杀进程的依据）Pss: ");
            sb.append(this.mPssMB);
            sb.append(" (MB)\n");
            sb.append("\t打开文件描述符数: ");
            sb.append(this.mFdCount);
            sb.append(StringUtils.LF);
            if (this.mFds.size() > 0) {
                sb.append("\t文件描述符详情: \n");
                for (String str : this.mFds) {
                    sb.append(TrackUI.SEPERATOR);
                    sb.append(str);
                    sb.append(StringUtils.LF);
                }
            }
            sb.append("\t正在运行线程数: ");
            sb.append(this.mThreadsCount);
            sb.append("\tJava: ");
            sb.append(this.mJavaThreads.size());
            sb.append("\tNative: ");
            sb.append(this.mThreadsCount - this.mJavaThreads.size());
            sb.append("\n\n");
            if (this.mAllThreads.size() > 0) {
                sb.append("\t全部线程名: \n");
                for (ThreadInfo threadInfo : this.mAllThreads) {
                    sb.append(TrackUI.SEPERATOR);
                    sb.append(threadInfo.mName);
                    sb.append(StringUtils.LF);
                }
            }
            if (this.mJavaThreads.size() > 0) {
                sb.append("Java线程堆栈: \n");
                for (ThreadInfo threadInfo2 : this.mJavaThreads) {
                    sb.append(threadInfo2.mName);
                    sb.append(StringUtils.LF);
                    sb.append(threadInfo2.mTrace.replace("#", StringUtils.LF));
                    sb.append(StringUtils.LF);
                }
            }
            if (this.mNativeThreads.size() > 0) {
                sb.append("\tNative线程堆栈: \n");
                for (ThreadInfo threadInfo3 : this.mNativeThreads) {
                    sb.append(TrackUI.SEPERATOR);
                    sb.append(threadInfo3.mName);
                    sb.append("\t(tid=");
                    sb.append(threadInfo3.mTid);
                    sb.append(", index=");
                    sb.append(threadInfo3.mIndex);
                    sb.append("):\n");
                    sb.append(threadInfo3.mTrace);
                }
            }
            return sb.substring(0);
        }
        return (String) invokeV.objValue;
    }
}
