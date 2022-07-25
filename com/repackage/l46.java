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
public class l46 implements kg<ym> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a65 a;

    public l46() {
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
        this.a = a65.b;
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
    @Override // com.repackage.kg
    /* renamed from: b */
    public ym getFromLocal(String str, String str2, int i, int i2, hg hgVar, Object... objArr) {
        InterceptResult invokeCommon;
        ym ymVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), hgVar, objArr})) == null) {
            ym ymVar2 = null;
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
            ArrayList<c25> i3 = q46.k().i();
            if ((q46.k().q(valueOf2) || q46.k().r(valueOf2)) && valueOf3.booleanValue() && !new File(q46.k().g(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (q46.k().o(valueOf2) && valueOf3.booleanValue()) {
                String g = q46.k().g(valueOf2, true);
                String h = q46.k().h(valueOf2);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf3.booleanValue()) {
                String g2 = q46.k().g(valueOf2, true);
                Iterator<c25> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c25 next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            ymVar2 = next.n(valueOf2);
                        } else {
                            ymVar2 = e(next.f(), g2, hgVar);
                        }
                    }
                }
                return (ymVar2 != null || valueOf == null) ? ymVar2 : e(valueOf, g2, hgVar);
            }
            String g3 = q46.k().g(valueOf2, false);
            if (booleanValue && q46.k().o(valueOf2)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<c25> it2 = i3.iterator();
            ym ymVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    ymVar = ymVar3;
                    break;
                }
                c25 next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        ymVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f2 = f(next2.f(), g3, hgVar);
                        if (f2 == null) {
                            return null;
                        }
                        ymVar = new ym(f2, false, valueOf2);
                    }
                }
            }
            return (ymVar != null || valueOf == null || (f = f(valueOf, g3, hgVar)) == null) ? ymVar : new ym(f, false, valueOf2);
        }
        return (ym) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kg
    /* renamed from: c */
    public ym getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? m45.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (ym) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kg
    /* renamed from: d */
    public ym getFromRemote(String str, String str2, int i, int i2, hg hgVar, Object... objArr) {
        InterceptResult invokeCommon;
        ym ymVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), hgVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
                String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
                Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
                String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
                if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                    od5.g(l46.class.getSimpleName(), valueOf4);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = q46.k().g(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                wb wbVar = new wb(str3, g, DiskFileOperate.Action.WRITE);
                                wbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                wbVar.setSubFolder(false);
                                wbVar.setSavedCache(false);
                                wbVar.setSdCard(false);
                                wbVar.setData(downloadImageBytes);
                                ub.f().call(wbVar);
                                if (hgVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(wbVar);
                                    hgVar.a = diskCancelWorker;
                                }
                                Iterator<c25> it = q46.k().i().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        ymVar = null;
                                        break;
                                    }
                                    c25 next = it.next();
                                    if (next.m(valueOf2)) {
                                        ymVar = e(next.f(), g, hgVar);
                                        break;
                                    }
                                }
                                if (ymVar == null && valueOf != null) {
                                    ymVar = e(valueOf, g, hgVar);
                                }
                                if (ymVar == null) {
                                    return null;
                                }
                            } else {
                                m45.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                ym ymVar2 = new ym(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                ymVar2.y(needCache);
                                if (needCache) {
                                    yb ybVar = new yb(str3, g, DiskFileOperate.Action.WRITE);
                                    ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    ybVar.setSubFolder(false);
                                    ybVar.setData(downloadImageBytes);
                                    ybVar.setSavedCache(false);
                                    ybVar.setSdCard(false);
                                    ybVar.setGif(valueOf3.booleanValue());
                                    ub.f().a(ybVar);
                                    if (hgVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(ybVar);
                                        hgVar.a = diskCancelWorker2;
                                    }
                                }
                                ymVar = ymVar2;
                            }
                            return ymVar;
                        }
                    }
                }
            }
            return null;
        }
        return (ym) invokeCommon.objValue;
    }

    public ym e(String str, String str2, hg hgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, hgVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, hgVar);
                if (f == null) {
                    return null;
                }
                return new ym(f, false, str2);
            }
            byte[] bArr = new byte[0];
            wb wbVar = new wb(str3, str2, DiskFileOperate.Action.READ);
            wbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            wbVar.setSubFolder(false);
            wbVar.setIsFormatData(false);
            wbVar.setSavedCache(false);
            wbVar.setSdCard(false);
            wbVar.setLock(bArr);
            if (hgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(wbVar);
                hgVar.a = diskCancelWorker;
            }
            if (ub.f().a(wbVar)) {
                int i = ni.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (wbVar.isSuccess()) {
                    wbVar.formatData(wbVar.getData());
                    return new ym(wbVar.a());
                }
                return null;
            }
            return null;
        }
        return (ym) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, hg hgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, hgVar)) == null) {
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
            if (hgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                hgVar.a = diskCancelWorker;
            }
            if (ub.f().a(diskEmotionOperate)) {
                int i = ni.H() ? 300 : 2000;
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
        q46 k;
        String g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (g = (k = q46.k()).g(str, true)) == null) {
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

    @Override // com.repackage.kg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.kg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.kg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? an4.c().g() : invokeV.booleanValue;
    }

    @Override // com.repackage.kg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof ym)) {
            ym ymVar = (ym) obj;
            if (ymVar.u()) {
                ymVar.A(i);
                ymVar.z(i2);
                m45.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), ymVar);
            }
        }
    }
}
