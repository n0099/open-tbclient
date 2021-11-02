package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class DownloadShortInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long currentBytes;
    public int failStatus;
    public String fileName;
    public long id;
    public boolean onlyWifi;
    public int status;
    public long totalBytes;

    public DownloadShortInfo() {
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
        this.id = -1L;
        this.status = -1;
        this.totalBytes = -1L;
        this.currentBytes = -1L;
        this.failStatus = 0;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if ((obj instanceof DownloadShortInfo) && obj != null) {
                DownloadShortInfo downloadShortInfo = (DownloadShortInfo) obj;
                return ((this.id > downloadShortInfo.id ? 1 : (this.id == downloadShortInfo.id ? 0 : -1)) == 0) && (this.status == downloadShortInfo.status) && ((this.totalBytes > downloadShortInfo.totalBytes ? 1 : (this.totalBytes == downloadShortInfo.totalBytes ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.fileName) && TextUtils.isEmpty(downloadShortInfo.fileName)) || (!TextUtils.isEmpty(this.fileName) && !TextUtils.isEmpty(downloadShortInfo.fileName) && this.fileName.equals(downloadShortInfo.fileName)));
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Arrays.hashCode(new Object[]{Long.valueOf(this.id), Integer.valueOf(this.status), Long.valueOf(this.totalBytes), this.fileName}) : invokeV.intValue;
    }

    public void updateFromNewDownloadInfo(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.status = downloadInfo.getStatus();
        this.currentBytes = downloadInfo.getCurBytes();
        this.totalBytes = downloadInfo.getTotalBytes();
        this.fileName = downloadInfo.getTargetFilePath();
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException != null) {
            this.failStatus = failedException.getErrorCode();
        } else {
            this.failStatus = 0;
        }
        this.onlyWifi = downloadInfo.isOnlyWifi();
    }
}
