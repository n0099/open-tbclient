package com.repackage;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DiskEmotionOperate;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class y36 implements jg<fo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y36() {
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

    public final String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(z ? "_gif" : "");
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jg
    /* renamed from: b */
    public fo getFromLocal(String str, String str2, int i, int i2, gg ggVar, Object... objArr) {
        InterceptResult invokeCommon;
        fo foVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ggVar, objArr})) == null) {
            fo foVar2 = null;
            if (objArr == null || objArr.length != 4) {
                return null;
            }
            String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
            String valueOf2 = objArr[1] != null ? String.valueOf(objArr[1]) : "";
            Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
            if (valueOf == null || valueOf2 == null || valueOf3 == null) {
                return null;
            }
            ArrayList<a15> i3 = d46.j().i();
            if (d46.j().n(valueOf2) && valueOf3.booleanValue() && !new File(d46.j().g(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (d46.j().m(valueOf2) && valueOf3.booleanValue()) {
                String g = d46.j().g(valueOf2, true);
                String h = d46.j().h(valueOf2);
                if (!new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.emotions/" + h + "/" + g).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf3.booleanValue()) {
                String g2 = d46.j().g(valueOf2, true);
                Iterator<a15> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a15 next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            foVar2 = next.n(valueOf2);
                        } else {
                            foVar2 = e(next.f(), g2, ggVar);
                        }
                    }
                }
                return (foVar2 != null || valueOf == null) ? foVar2 : e(valueOf, g2, ggVar);
            }
            String g3 = d46.j().g(valueOf2, false);
            if (booleanValue && d46.j().m(valueOf2)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<a15> it2 = i3.iterator();
            fo foVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    foVar = foVar3;
                    break;
                }
                a15 next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        foVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f2 = f(next2.f(), g3, ggVar);
                        if (f2 == null) {
                            return null;
                        }
                        foVar = new fo(f2, false, valueOf2);
                    }
                }
            }
            return (foVar != null || valueOf == null || (f = f(valueOf, g3, ggVar)) == null) ? foVar : new fo(f, false, valueOf2);
        }
        return (fo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jg
    /* renamed from: c */
    public fo getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? h35.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (fo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jg
    /* renamed from: d */
    public fo getFromRemote(String str, String str2, int i, int i2, gg ggVar, Object... objArr) {
        InterceptResult invokeCommon;
        fo foVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ggVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
                String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
                Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
                String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
                if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = d46.j().g(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                tb tbVar = new tb(str3, g, DiskFileOperate.Action.WRITE);
                                tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                tbVar.setSubFolder(false);
                                tbVar.setSavedCache(false);
                                tbVar.setSdCard(false);
                                tbVar.setData(downloadImageBytes);
                                rb.f().call(tbVar);
                                if (ggVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(tbVar);
                                    ggVar.a = diskCancelWorker;
                                }
                                Iterator<a15> it = d46.j().i().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        foVar = null;
                                        break;
                                    }
                                    a15 next = it.next();
                                    if (next.m(valueOf2)) {
                                        foVar = e(next.f(), g, ggVar);
                                        break;
                                    }
                                }
                                if (foVar == null && valueOf != null) {
                                    foVar = e(valueOf, g, ggVar);
                                }
                                if (foVar == null) {
                                    return null;
                                }
                            } else {
                                h35.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                fo foVar2 = new fo(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                foVar2.y(needCache);
                                if (needCache) {
                                    vb vbVar = new vb(str3, g, DiskFileOperate.Action.WRITE);
                                    vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    vbVar.setSubFolder(false);
                                    vbVar.setData(downloadImageBytes);
                                    vbVar.setSavedCache(false);
                                    vbVar.setSdCard(false);
                                    vbVar.setGif(valueOf3.booleanValue());
                                    rb.f().a(vbVar);
                                    if (ggVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(vbVar);
                                        ggVar.a = diskCancelWorker2;
                                    }
                                }
                                foVar = foVar2;
                            }
                            return foVar;
                        }
                    }
                }
            }
            return null;
        }
        return (fo) invokeCommon.objValue;
    }

    public fo e(String str, String str2, gg ggVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, ggVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, ggVar);
                if (f == null) {
                    return null;
                }
                return new fo(f, false, str2);
            }
            byte[] bArr = new byte[0];
            tb tbVar = new tb(str3, str2, DiskFileOperate.Action.READ);
            tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            tbVar.setSubFolder(false);
            tbVar.setIsFormatData(false);
            tbVar.setSavedCache(false);
            tbVar.setSdCard(false);
            tbVar.setLock(bArr);
            if (ggVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(tbVar);
                ggVar.a = diskCancelWorker;
            }
            if (rb.f().a(tbVar)) {
                int i = mi.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (tbVar.isSuccess()) {
                    tbVar.formatData(tbVar.getData());
                    return new fo(tbVar.a());
                }
                return null;
            }
            return null;
        }
        return (fo) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, gg ggVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, ggVar)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(".emotions/");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            byte[] bArr = new byte[0];
            DiskEmotionOperate diskEmotionOperate = new DiskEmotionOperate(sb.toString(), str2, DiskFileOperate.Action.READ);
            diskEmotionOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            diskEmotionOperate.setSubFolder(false);
            diskEmotionOperate.setIsFormatData(false);
            diskEmotionOperate.setSavedCache(false);
            diskEmotionOperate.setSdCard(false);
            diskEmotionOperate.setLock(bArr);
            if (ggVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                ggVar.a = diskCancelWorker;
            }
            if (rb.f().a(diskEmotionOperate)) {
                int i = mi.H() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (diskEmotionOperate.isSuccess()) {
                    diskEmotionOperate.formatData(diskEmotionOperate.getData());
                    return diskEmotionOperate.getBitmap();
                }
                return null;
            }
            return null;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    @Override // com.repackage.jg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.jg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.jg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? cn4.c().g() : invokeV.booleanValue;
    }

    @Override // com.repackage.jg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof fo)) {
            fo foVar = (fo) obj;
            if (foVar.u()) {
                foVar.A(i);
                foVar.z(i2);
                h35.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), foVar);
            }
        }
    }
}
