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
public class d66 implements lg<zm> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w65 a;

    public d66() {
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
        this.a = w65.b;
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
    @Override // com.repackage.lg
    /* renamed from: b */
    public zm getFromLocal(String str, String str2, int i, int i2, ig igVar, Object... objArr) {
        InterceptResult invokeCommon;
        zm zmVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), igVar, objArr})) == null) {
            zm zmVar2 = null;
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
            ArrayList<z25> i3 = i66.k().i();
            if ((i66.k().q(valueOf2) || i66.k().r(valueOf2)) && valueOf3.booleanValue() && !new File(i66.k().g(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (i66.k().o(valueOf2) && valueOf3.booleanValue()) {
                String g = i66.k().g(valueOf2, true);
                String h = i66.k().h(valueOf2);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf3.booleanValue()) {
                String g2 = i66.k().g(valueOf2, true);
                Iterator<z25> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    z25 next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            zmVar2 = next.n(valueOf2);
                        } else {
                            zmVar2 = e(next.f(), g2, igVar);
                        }
                    }
                }
                return (zmVar2 != null || valueOf == null) ? zmVar2 : e(valueOf, g2, igVar);
            }
            String g3 = i66.k().g(valueOf2, false);
            if (booleanValue && i66.k().o(valueOf2)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<z25> it2 = i3.iterator();
            zm zmVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    zmVar = zmVar3;
                    break;
                }
                z25 next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        zmVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f2 = f(next2.f(), g3, igVar);
                        if (f2 == null) {
                            return null;
                        }
                        zmVar = new zm(f2, false, valueOf2);
                    }
                }
            }
            return (zmVar != null || valueOf == null || (f = f(valueOf, g3, igVar)) == null) ? zmVar : new zm(f, false, valueOf2);
        }
        return (zm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.lg
    /* renamed from: c */
    public zm getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? i55.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (zm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.lg
    /* renamed from: d */
    public zm getFromRemote(String str, String str2, int i, int i2, ig igVar, Object... objArr) {
        InterceptResult invokeCommon;
        zm zmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), igVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
                String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
                Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
                String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
                if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                    ne5.g(d66.class.getSimpleName(), valueOf4);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = i66.k().g(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                xb xbVar = new xb(str3, g, DiskFileOperate.Action.WRITE);
                                xbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                xbVar.setSubFolder(false);
                                xbVar.setSavedCache(false);
                                xbVar.setSdCard(false);
                                xbVar.setData(downloadImageBytes);
                                vb.f().call(xbVar);
                                if (igVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(xbVar);
                                    igVar.a = diskCancelWorker;
                                }
                                Iterator<z25> it = i66.k().i().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        zmVar = null;
                                        break;
                                    }
                                    z25 next = it.next();
                                    if (next.m(valueOf2)) {
                                        zmVar = e(next.f(), g, igVar);
                                        break;
                                    }
                                }
                                if (zmVar == null && valueOf != null) {
                                    zmVar = e(valueOf, g, igVar);
                                }
                                if (zmVar == null) {
                                    return null;
                                }
                            } else {
                                i55.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                zm zmVar2 = new zm(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                zmVar2.y(needCache);
                                if (needCache) {
                                    zb zbVar = new zb(str3, g, DiskFileOperate.Action.WRITE);
                                    zbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    zbVar.setSubFolder(false);
                                    zbVar.setData(downloadImageBytes);
                                    zbVar.setSavedCache(false);
                                    zbVar.setSdCard(false);
                                    zbVar.setGif(valueOf3.booleanValue());
                                    vb.f().a(zbVar);
                                    if (igVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(zbVar);
                                        igVar.a = diskCancelWorker2;
                                    }
                                }
                                zmVar = zmVar2;
                            }
                            return zmVar;
                        }
                    }
                }
            }
            return null;
        }
        return (zm) invokeCommon.objValue;
    }

    public zm e(String str, String str2, ig igVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, igVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, igVar);
                if (f == null) {
                    return null;
                }
                return new zm(f, false, str2);
            }
            byte[] bArr = new byte[0];
            xb xbVar = new xb(str3, str2, DiskFileOperate.Action.READ);
            xbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            xbVar.setSubFolder(false);
            xbVar.setIsFormatData(false);
            xbVar.setSavedCache(false);
            xbVar.setSdCard(false);
            xbVar.setLock(bArr);
            if (igVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(xbVar);
                igVar.a = diskCancelWorker;
            }
            if (vb.f().a(xbVar)) {
                int i = oi.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (xbVar.isSuccess()) {
                    xbVar.formatData(xbVar.getData());
                    return new zm(xbVar.a());
                }
                return null;
            }
            return null;
        }
        return (zm) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, ig igVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, igVar)) == null) {
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
            if (igVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                igVar.a = diskCancelWorker;
            }
            if (vb.f().a(diskEmotionOperate)) {
                int i = oi.H() ? 300 : 2000;
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
        i66 k;
        String g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (g = (k = i66.k()).g(str, true)) == null) {
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

    @Override // com.repackage.lg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.lg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.lg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? rn4.c().g() : invokeV.booleanValue;
    }

    @Override // com.repackage.lg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof zm)) {
            zm zmVar = (zm) obj;
            if (zmVar.u()) {
                zmVar.A(i);
                zmVar.z(i2);
                i55.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), zmVar);
            }
        }
    }
}
