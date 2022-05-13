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
/* loaded from: classes5.dex */
public class b46 implements hg<co> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b46() {
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
    @Override // com.repackage.hg
    /* renamed from: b */
    public co getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        co coVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            co coVar2 = null;
            if (objArr == null || objArr.length != 4) {
                return null;
            }
            String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
            String valueOf2 = objArr[1] != null ? String.valueOf(objArr[1]) : "";
            Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
            if (valueOf == null || valueOf2 == null || valueOf3 == null) {
                return null;
            }
            ArrayList<p15> i3 = g46.j().i();
            if (g46.j().n(valueOf2) && valueOf3.booleanValue() && !new File(g46.j().g(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (g46.j().m(valueOf2) && valueOf3.booleanValue()) {
                String g = g46.j().g(valueOf2, true);
                String h = g46.j().h(valueOf2);
                if (!new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.emotions/" + h + "/" + g).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf3.booleanValue()) {
                String g2 = g46.j().g(valueOf2, true);
                Iterator<p15> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    p15 next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            coVar2 = next.n(valueOf2);
                        } else {
                            coVar2 = e(next.f(), g2, egVar);
                        }
                    }
                }
                return (coVar2 != null || valueOf == null) ? coVar2 : e(valueOf, g2, egVar);
            }
            String g3 = g46.j().g(valueOf2, false);
            if (booleanValue && g46.j().m(valueOf2)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<p15> it2 = i3.iterator();
            co coVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    coVar = coVar3;
                    break;
                }
                p15 next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        coVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f2 = f(next2.f(), g3, egVar);
                        if (f2 == null) {
                            return null;
                        }
                        coVar = new co(f2, false, valueOf2);
                    }
                }
            }
            return (coVar != null || valueOf == null || (f = f(valueOf, g3, egVar)) == null) ? coVar : new co(f, false, valueOf2);
        }
        return (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hg
    /* renamed from: c */
    public co getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? y35.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hg
    /* renamed from: d */
    public co getFromRemote(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        co coVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
                String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
                Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
                String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
                if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                    dd5.g(b46.class.getSimpleName(), valueOf4);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = g46.j().g(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                tb tbVar = new tb(str3, g, DiskFileOperate.Action.WRITE);
                                tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                tbVar.setSubFolder(false);
                                tbVar.setSavedCache(false);
                                tbVar.setSdCard(false);
                                tbVar.setData(downloadImageBytes);
                                rb.f().call(tbVar);
                                if (egVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(tbVar);
                                    egVar.a = diskCancelWorker;
                                }
                                Iterator<p15> it = g46.j().i().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        coVar = null;
                                        break;
                                    }
                                    p15 next = it.next();
                                    if (next.m(valueOf2)) {
                                        coVar = e(next.f(), g, egVar);
                                        break;
                                    }
                                }
                                if (coVar == null && valueOf != null) {
                                    coVar = e(valueOf, g, egVar);
                                }
                                if (coVar == null) {
                                    return null;
                                }
                            } else {
                                y35.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                co coVar2 = new co(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                coVar2.y(needCache);
                                if (needCache) {
                                    vb vbVar = new vb(str3, g, DiskFileOperate.Action.WRITE);
                                    vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    vbVar.setSubFolder(false);
                                    vbVar.setData(downloadImageBytes);
                                    vbVar.setSavedCache(false);
                                    vbVar.setSdCard(false);
                                    vbVar.setGif(valueOf3.booleanValue());
                                    rb.f().a(vbVar);
                                    if (egVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(vbVar);
                                        egVar.a = diskCancelWorker2;
                                    }
                                }
                                coVar = coVar2;
                            }
                            return coVar;
                        }
                    }
                }
            }
            return null;
        }
        return (co) invokeCommon.objValue;
    }

    public co e(String str, String str2, eg egVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, egVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, egVar);
                if (f == null) {
                    return null;
                }
                return new co(f, false, str2);
            }
            byte[] bArr = new byte[0];
            tb tbVar = new tb(str3, str2, DiskFileOperate.Action.READ);
            tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            tbVar.setSubFolder(false);
            tbVar.setIsFormatData(false);
            tbVar.setSavedCache(false);
            tbVar.setSdCard(false);
            tbVar.setLock(bArr);
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(tbVar);
                egVar.a = diskCancelWorker;
            }
            if (rb.f().a(tbVar)) {
                int i = ki.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (tbVar.isSuccess()) {
                    tbVar.formatData(tbVar.getData());
                    return new co(tbVar.a());
                }
                return null;
            }
            return null;
        }
        return (co) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, eg egVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, egVar)) == null) {
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
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                egVar.a = diskCancelWorker;
            }
            if (rb.f().a(diskEmotionOperate)) {
                int i = ki.H() ? 300 : 2000;
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

    @Override // com.repackage.hg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.hg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.hg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ln4.c().g() : invokeV.booleanValue;
    }

    @Override // com.repackage.hg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof co)) {
            co coVar = (co) obj;
            if (coVar.u()) {
                coVar.A(i);
                coVar.z(i2);
                y35.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), coVar);
            }
        }
    }
}
