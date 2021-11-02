package com.kwad.sdk.collector;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
@Keep
/* loaded from: classes2.dex */
public class AppStatusNative {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AppStatusNative() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static native String[] analyseTaskGetPathSuffixSet(com.kwad.sdk.collector.model.jni.a aVar);

    public static native long analyseTaskGetRunningInfo(com.kwad.sdk.collector.model.jni.a aVar);

    public static native long analyseTaskGetStartTime(com.kwad.sdk.collector.model.jni.a aVar);

    public static native long[] analysis(long[] jArr, String str);

    public static native long appRunningInfoGetGranularity(com.kwad.sdk.collector.model.jni.b bVar);

    public static native long appRunningInfoGetLastRunningTime(com.kwad.sdk.collector.model.jni.b bVar);

    public static native String appRunningInfoGetName(com.kwad.sdk.collector.model.jni.b bVar);

    public static native String appRunningInfoGetPackageName(com.kwad.sdk.collector.model.jni.b bVar);

    public static native void appRunningInfoSetLastRunningTime(com.kwad.sdk.collector.model.jni.b bVar, long j);

    public static native long nativeCreateAnalyseTask(long j, String[] strArr, long j2);

    public static native long nativeCreateAppRunningInfo(long j, @NonNull String str, @NonNull String str2);

    public static native long nativeCreateRulesTarget();

    public static native long nativeCreateUploadEntry();

    public static native void nativeDeleteAnalyseTask(long j);

    public static native void nativeDeleteAppRunningInfo(long j);

    public static native void nativeDeleteRulesTarget(long j);

    public static native void nativeDeleteUploadEntry(long j);

    public static native long[] nativeGetUploadEntry(long[] jArr, long j, String str);

    public static native String rulesTargetGetPackageName(RulesTargetNative rulesTargetNative);

    public static native String[] rulesTargetGetPaths(RulesTargetNative rulesTargetNative);

    public static native void rulesTargetSetPackageName(RulesTargetNative rulesTargetNative, String str);

    public static native void rulesTargetSetPaths(RulesTargetNative rulesTargetNative, String[] strArr);

    public static native String uploadEntryGetOriginFilePath(com.kwad.sdk.collector.model.jni.c cVar);

    public static native String uploadEntryGetPackageName(com.kwad.sdk.collector.model.jni.c cVar);

    public static native void uploadEntrySetOriginFilePath(com.kwad.sdk.collector.model.jni.c cVar, String str);

    public static native void uploadEntrySetPackageName(com.kwad.sdk.collector.model.jni.c cVar, String str);
}
