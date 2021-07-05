package com.kwad.sdk.core.download;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class DOWNLOADSTAUS {
    public static final /* synthetic */ DOWNLOADSTAUS[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DOWNLOADSTAUS CANCELLED;
    public static final DOWNLOADSTAUS DELETED;
    public static final DOWNLOADSTAUS DOWNLOADING;
    public static final DOWNLOADSTAUS FAILED;
    public static final DOWNLOADSTAUS FINISHED;
    public static final DOWNLOADSTAUS INSTALL;
    public static final DOWNLOADSTAUS INSTALLING;
    public static final DOWNLOADSTAUS INSTALL_FAILED;
    public static final DOWNLOADSTAUS INSTALL_FINSHED;
    public static final DOWNLOADSTAUS PAUSED;
    public static final DOWNLOADSTAUS PROGRESS;
    public static final DOWNLOADSTAUS START;
    public static final DOWNLOADSTAUS UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public int status;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(697248823, "Lcom/kwad/sdk/core/download/DOWNLOADSTAUS;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(697248823, "Lcom/kwad/sdk/core/download/DOWNLOADSTAUS;");
                return;
            }
        }
        UNKNOWN = new DOWNLOADSTAUS(RomUtils.UNKNOWN, 0, 0);
        START = new DOWNLOADSTAUS("START", 1, 1);
        DOWNLOADING = new DOWNLOADSTAUS(AdDownloadApkUtils.DL_STATUS_DOWNLOADING, 2, 2);
        PROGRESS = new DOWNLOADSTAUS("PROGRESS", 3, 3);
        PAUSED = new DOWNLOADSTAUS("PAUSED", 4, 4);
        CANCELLED = new DOWNLOADSTAUS("CANCELLED", 5, 5);
        DELETED = new DOWNLOADSTAUS("DELETED", 6, 6);
        FAILED = new DOWNLOADSTAUS("FAILED", 7, 7);
        FINISHED = new DOWNLOADSTAUS("FINISHED", 8, 8);
        INSTALL = new DOWNLOADSTAUS("INSTALL", 9, 9);
        INSTALLING = new DOWNLOADSTAUS("INSTALLING", 10, 10);
        INSTALL_FAILED = new DOWNLOADSTAUS("INSTALL_FAILED", 11, 11);
        DOWNLOADSTAUS downloadstaus = new DOWNLOADSTAUS("INSTALL_FINSHED", 12, 12);
        INSTALL_FINSHED = downloadstaus;
        $VALUES = new DOWNLOADSTAUS[]{UNKNOWN, START, DOWNLOADING, PROGRESS, PAUSED, CANCELLED, DELETED, FAILED, FINISHED, INSTALL, INSTALLING, INSTALL_FAILED, downloadstaus};
    }

    public DOWNLOADSTAUS(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.status = i3;
    }

    public static DOWNLOADSTAUS valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DOWNLOADSTAUS) Enum.valueOf(DOWNLOADSTAUS.class, str) : (DOWNLOADSTAUS) invokeL.objValue;
    }

    public static DOWNLOADSTAUS[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DOWNLOADSTAUS[]) $VALUES.clone() : (DOWNLOADSTAUS[]) invokeV.objValue;
    }
}
