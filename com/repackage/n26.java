package com.repackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class n26 implements gg<um> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i45 a;

    public n26() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i45.b;
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
    @Override // com.repackage.gg
    /* renamed from: b */
    public um getFromLocal(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        um umVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            um umVar2 = null;
            if (objArr == null || objArr.length != 4) {
                return null;
            }
            String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
            String valueOf2 = objArr[1] != null ? String.valueOf(objArr[1]) : "";
            Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
            if (valueOf == null || valueOf2 == null || valueOf3 == null) {
                return null;
            }
            g(valueOf2);
            ArrayList<l05> i3 = s26.k().i();
            if ((s26.k().q(valueOf2) || s26.k().r(valueOf2)) && valueOf3.booleanValue() && !new File(s26.k().g(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (s26.k().o(valueOf2) && valueOf3.booleanValue()) {
                String g = s26.k().g(valueOf2, true);
                String h = s26.k().h(valueOf2);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf3.booleanValue()) {
                String g2 = s26.k().g(valueOf2, true);
                Iterator<l05> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    l05 next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            umVar2 = next.n(valueOf2);
                        } else {
                            umVar2 = e(next.f(), g2, dgVar);
                        }
                    }
                }
                return (umVar2 != null || valueOf == null) ? umVar2 : e(valueOf, g2, dgVar);
            }
            String g3 = s26.k().g(valueOf2, false);
            if (booleanValue && s26.k().o(valueOf2)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<l05> it2 = i3.iterator();
            um umVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    umVar = umVar3;
                    break;
                }
                l05 next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        umVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f2 = f(next2.f(), g3, dgVar);
                        if (f2 == null) {
                            return null;
                        }
                        umVar = new um(f2, false, valueOf2);
                    }
                }
            }
            return (umVar != null || valueOf == null || (f = f(valueOf, g3, dgVar)) == null) ? umVar : new um(f, false, valueOf2);
        }
        return (um) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gg
    /* renamed from: c */
    public um getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? u25.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (um) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gg
    /* renamed from: d */
    public um getFromRemote(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        um umVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
                String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
                Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
                String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
                if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                    xb5.g(n26.class.getSimpleName(), valueOf4);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = s26.k().g(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                tb tbVar = new tb(str3, g, DiskFileOperate.Action.WRITE);
                                tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                tbVar.setSubFolder(false);
                                tbVar.setSavedCache(false);
                                tbVar.setSdCard(false);
                                tbVar.setData(downloadImageBytes);
                                rb.f().call(tbVar);
                                if (dgVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(tbVar);
                                    dgVar.a = diskCancelWorker;
                                }
                                Iterator<l05> it = s26.k().i().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        umVar = null;
                                        break;
                                    }
                                    l05 next = it.next();
                                    if (next.m(valueOf2)) {
                                        umVar = e(next.f(), g, dgVar);
                                        break;
                                    }
                                }
                                if (umVar == null && valueOf != null) {
                                    umVar = e(valueOf, g, dgVar);
                                }
                                if (umVar == null) {
                                    return null;
                                }
                            } else {
                                u25.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                um umVar2 = new um(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                umVar2.y(needCache);
                                if (needCache) {
                                    vb vbVar = new vb(str3, g, DiskFileOperate.Action.WRITE);
                                    vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    vbVar.setSubFolder(false);
                                    vbVar.setData(downloadImageBytes);
                                    vbVar.setSavedCache(false);
                                    vbVar.setSdCard(false);
                                    vbVar.setGif(valueOf3.booleanValue());
                                    rb.f().a(vbVar);
                                    if (dgVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(vbVar);
                                        dgVar.a = diskCancelWorker2;
                                    }
                                }
                                umVar = umVar2;
                            }
                            return umVar;
                        }
                    }
                }
            }
            return null;
        }
        return (um) invokeCommon.objValue;
    }

    public um e(String str, String str2, dg dgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, dgVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, dgVar);
                if (f == null) {
                    return null;
                }
                return new um(f, false, str2);
            }
            byte[] bArr = new byte[0];
            tb tbVar = new tb(str3, str2, DiskFileOperate.Action.READ);
            tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            tbVar.setSubFolder(false);
            tbVar.setIsFormatData(false);
            tbVar.setSavedCache(false);
            tbVar.setSdCard(false);
            tbVar.setLock(bArr);
            if (dgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(tbVar);
                dgVar.a = diskCancelWorker;
            }
            if (rb.f().a(tbVar)) {
                int i = ji.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (tbVar.isSuccess()) {
                    tbVar.formatData(tbVar.getData());
                    return new um(tbVar.a());
                }
                return null;
            }
            return null;
        }
        return (um) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, dg dgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, dgVar)) == null) {
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
            if (dgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                dgVar.a = diskCancelWorker;
            }
            if (rb.f().a(diskEmotionOperate)) {
                int i = ji.H() ? 300 : 2000;
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

    public final void g(@NonNull String str) {
        s26 k;
        String g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (g = (k = s26.k()).g(str, true)) == null) {
            return;
        }
        boolean q = k.q(str);
        boolean r = k.r(str);
        String replace = g.replace(".gif", ".jpg");
        if (!q && !r) {
            g = this.a.e(k.h(str), g);
            replace = g.replace(".gif", ".jpg");
        }
        if (FileHelper.isGifImage(replace)) {
            FileHelper.renameTo(replace, g);
        }
    }

    @Override // com.repackage.gg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.gg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.gg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? am4.c().g() : invokeV.booleanValue;
    }

    @Override // com.repackage.gg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof um)) {
            um umVar = (um) obj;
            if (umVar.u()) {
                umVar.A(i);
                umVar.z(i2);
                u25.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), umVar);
            }
        }
    }
}
