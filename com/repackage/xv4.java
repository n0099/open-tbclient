package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xv4 implements jg<vv4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xv4() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jg
    /* renamed from: a */
    public vv4 getFromLocal(String str, String str2, int i, int i2, gg ggVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ggVar, objArr})) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            diskFileOperate.setSubFolder(false);
            diskFileOperate.setIsFormatData(false);
            if (ggVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskFileOperate);
                ggVar.a = diskCancelWorker;
            }
            diskFileOperate.call();
            if (diskFileOperate.isSuccess()) {
                String desPath = diskFileOperate.getDesPath();
                vv4 vv4Var = new vv4();
                vv4Var.a = str;
                vv4Var.b = desPath;
                return vv4Var;
            }
            return null;
        }
        return (vv4) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jg
    /* renamed from: b */
    public vv4 getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (vv4) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jg
    /* renamed from: c */
    public vv4 getFromRemote(String str, String str2, int i, int i2, gg ggVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ggVar, objArr})) == null) {
            int i3 = 1;
            String str3 = null;
            String valueOf = objArr.length == 1 ? String.valueOf(objArr[0]) : null;
            vv4 vv4Var = new vv4();
            WebClient webClient = new WebClient();
            if (ggVar != null) {
                ggVar.a = webClient;
            }
            String str4 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
            if (!TextUtils.isEmpty(valueOf)) {
                str4 = str4 + "&play_from=" + valueOf;
            }
            byte[] downloadCommonBytes = webClient.downloadCommonBytes(str4);
            if (!webClient.IsRequestSuccess()) {
                vv4Var.c = 3;
                vv4Var.d = gj.a(R.string.obfuscated_res_0x7f0f0c18);
                return vv4Var;
            } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
                vv4Var.c = 4;
                vv4Var.d = gj.a(R.string.obfuscated_res_0x7f0f1517);
                return vv4Var;
            } else {
                if (str == null) {
                    i3 = 5;
                } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
                    i3 = 6;
                } else {
                    DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                    diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                    diskFileOperate.setSubFolder(false);
                    diskFileOperate.setData(downloadCommonBytes);
                    if (ggVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(diskFileOperate);
                        ggVar.a = diskCancelWorker;
                    }
                    diskFileOperate.call();
                    if (diskFileOperate.isSuccess() && diskFileOperate.getFileInfo() != null) {
                        str3 = diskFileOperate.getFileInfo().getAbsolutePath();
                        i3 = 0;
                    } else if (FileHelper.getAvailableSize() < downloadCommonBytes.length) {
                        i3 = 2;
                    }
                }
                if (i3 == 0) {
                    vv4Var.b = str3;
                    vv4Var.a = str;
                } else {
                    vv4Var.c = i3;
                    vv4Var.d = vv4.a(i3);
                }
                return vv4Var;
            }
        }
        return (vv4) invokeCommon.objValue;
    }

    @Override // com.repackage.jg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.jg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.jg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.jg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
        }
    }
}
