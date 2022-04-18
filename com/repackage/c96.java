package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class c96 implements d05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c96() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.d05
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) || i == 3) {
            return;
        }
        try {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.repackage.d05
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
            MessageManager.getInstance().runTask(2004603, (Class) null);
            try {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.d05
    public boolean onFileDownloaded(DownloadData downloadData) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(downloadData.getPath());
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int g = y86.c().g(downloadData.getId(), fileInputStream);
                EmotionGroupData j = e96.k().j(downloadData.getId());
                if (j == null) {
                    if (g == 0) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            BdLog.detailException(e2);
                        }
                        return false;
                    }
                    j = new EmotionGroupData();
                    j.setBytesLength((int) downloadData.getSize());
                    j.setBytesReceived((int) downloadData.getLength());
                    j.setDownloadUrl(downloadData.getUrl());
                    j.setGroupId(downloadData.getId());
                    j.setEmotionsCount(g);
                    j.setHeight(downloadData.getHeight());
                    j.setWidth(downloadData.getWidth());
                    j.setDownloadTime(System.currentTimeMillis());
                    j.setGroupDesc(downloadData.getDescription());
                    j.setGroupName(downloadData.getName());
                    j.setStatus(1);
                    e96.k().e(j);
                }
                e96.k().f(downloadData.getStatusMsg(), j);
                downloadData.setStatusMsg(null);
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    BdLog.detailException(e3);
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                BdLog.detailException(e);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        BdLog.detailException(e5);
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        BdLog.detailException(e6);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.d05
    public void onFileUpdateProgress(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || downloadData == null) {
            return;
        }
        d96.f().i(downloadData);
    }

    @Override // com.repackage.d05
    public boolean onPreDownload(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            EmotionGroupData j = e96.k().j(downloadData.getId());
            if (j == null || !z86.d(downloadData.getId())) {
                return true;
            }
            e96.k().f(downloadData.getStatusMsg(), j);
            downloadData.setStatusMsg(null);
            return false;
        }
        return invokeL.booleanValue;
    }
}
