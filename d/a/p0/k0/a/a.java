package d.a.p0.k0.a;

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
import d.a.c.e.a.d;
import d.a.c.e.l.b;
import d.a.c.e.l.e;
import d.a.c.e.p.j;
import d.a.o0.r.k;
import d.a.o0.w.p.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class a implements e<d.a.c.k.d.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
    @Override // d.a.c.e.l.e
    /* renamed from: b */
    public d.a.c.k.d.a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        d.a.c.k.d.a aVar;
        Bitmap f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            d.a.c.k.d.a aVar2 = null;
            if (objArr == null || objArr.length != 4) {
                return null;
            }
            String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
            String valueOf2 = objArr[1] != null ? String.valueOf(objArr[1]) : "";
            Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
            if (valueOf == null || valueOf2 == null || valueOf3 == null) {
                return null;
            }
            ArrayList<c> h2 = d.a.p0.k0.b.e.i().h();
            if (d.a.p0.k0.b.e.i().m(valueOf2) && valueOf3.booleanValue() && !new File(d.a.p0.k0.b.e.i().f(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (d.a.p0.k0.b.e.i().l(valueOf2) && valueOf3.booleanValue()) {
                String f3 = d.a.p0.k0.b.e.i().f(valueOf2, true);
                String g2 = d.a.p0.k0.b.e.i().g(valueOf2);
                if (!new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.emotions/" + g2 + "/" + f3).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = g2;
            }
            if (valueOf3.booleanValue()) {
                String f4 = d.a.p0.k0.b.e.i().f(valueOf2, true);
                Iterator<c> it = h2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            aVar2 = next.n(valueOf2);
                        } else {
                            aVar2 = e(next.f(), f4, bVar);
                        }
                    }
                }
                return (aVar2 != null || valueOf == null) ? aVar2 : e(valueOf, f4, bVar);
            }
            String f5 = d.a.p0.k0.b.e.i().f(valueOf2, false);
            if (booleanValue && d.a.p0.k0.b.e.i().l(valueOf2)) {
                f5 = f5.replaceFirst("s_", "d_");
            }
            Iterator<c> it2 = h2.iterator();
            d.a.c.k.d.a aVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    aVar = aVar3;
                    break;
                }
                c next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        aVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f6 = f(next2.f(), f5, bVar);
                        if (f6 == null) {
                            return null;
                        }
                        aVar = new d.a.c.k.d.a(f6, false, valueOf2);
                    }
                }
            }
            return (aVar != null || valueOf == null || (f2 = f(valueOf, f5, bVar)) == null) ? aVar : new d.a.c.k.d.a(f2, false, valueOf2);
        }
        return (d.a.c.k.d.a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.e.l.e
    /* renamed from: c */
    public d.a.c.k.d.a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), objArr})) == null) ? d.a.o0.a0.c.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (d.a.c.k.d.a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.e.l.e
    /* renamed from: d */
    public d.a.c.k.d.a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        d.a.c.k.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
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
                            String f2 = d.a.p0.k0.b.e.i().f(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                d.a.c.e.a.f.a aVar2 = new d.a.c.e.a.f.a(str3, f2, DiskFileOperate.Action.WRITE);
                                aVar2.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                aVar2.setSubFolder(false);
                                aVar2.setSavedCache(false);
                                aVar2.setSdCard(false);
                                aVar2.setData(downloadImageBytes);
                                d.g().d(aVar2);
                                if (bVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(aVar2);
                                    bVar.f41276a = diskCancelWorker;
                                }
                                Iterator<c> it = d.a.p0.k0.b.e.i().h().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        aVar = null;
                                        break;
                                    }
                                    c next = it.next();
                                    if (next.m(valueOf2)) {
                                        aVar = e(next.f(), f2, bVar);
                                        break;
                                    }
                                }
                                if (aVar == null && valueOf != null) {
                                    aVar = e(valueOf, f2, bVar);
                                }
                                if (aVar == null) {
                                    return null;
                                }
                            } else {
                                d.a.o0.a0.c.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i2, i3);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                d.a.c.k.d.a aVar3 = new d.a.c.k.d.a(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                aVar3.y(needCache);
                                if (needCache) {
                                    d.a.c.e.a.f.c cVar = new d.a.c.e.a.f.c(str3, f2, DiskFileOperate.Action.WRITE);
                                    cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    cVar.setSubFolder(false);
                                    cVar.setData(downloadImageBytes);
                                    cVar.setSavedCache(false);
                                    cVar.setSdCard(false);
                                    cVar.setGif(valueOf3.booleanValue());
                                    d.g().a(cVar);
                                    if (bVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(cVar);
                                        bVar.f41276a = diskCancelWorker2;
                                    }
                                }
                                aVar = aVar3;
                            }
                            return aVar;
                        }
                    }
                }
            }
            return null;
        }
        return (d.a.c.k.d.a) invokeCommon.objValue;
    }

    public d.a.c.k.d.a e(String str, String str2, b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, bVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f2 = f(str, str2, bVar);
                if (f2 == null) {
                    return null;
                }
                return new d.a.c.k.d.a(f2, false, str2);
            }
            byte[] bArr = new byte[0];
            d.a.c.e.a.f.a aVar = new d.a.c.e.a.f.a(str3, str2, DiskFileOperate.Action.READ);
            aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar.setSubFolder(false);
            aVar.setIsFormatData(false);
            aVar.setSavedCache(false);
            aVar.setSdCard(false);
            aVar.setLock(bArr);
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(aVar);
                bVar.f41276a = diskCancelWorker;
            }
            if (d.g().a(aVar)) {
                int i2 = j.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i2);
                    } catch (InterruptedException e2) {
                        BdLog.detailException(e2);
                    }
                }
                if (aVar.isSuccess()) {
                    aVar.formatData(aVar.getData());
                    return new d.a.c.k.d.a(aVar.a());
                }
                return null;
            }
            return null;
        }
        return (d.a.c.k.d.a) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, bVar)) == null) {
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
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                bVar.f41276a = diskCancelWorker;
            }
            if (d.g().a(diskEmotionOperate)) {
                int i2 = j.H() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i2);
                    } catch (InterruptedException e2) {
                        BdLog.detailException(e2);
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

    @Override // d.a.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // d.a.c.e.l.e
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.c.e.l.e
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? k.c().g() : invokeV.booleanValue;
    }

    @Override // d.a.c.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i2), Integer.valueOf(i3), objArr}) == null) && obj != null && (obj instanceof d.a.c.k.d.a)) {
            d.a.c.k.d.a aVar = (d.a.c.k.d.a) obj;
            if (aVar.u()) {
                aVar.A(i2);
                aVar.z(i3);
                d.a.o0.a0.c.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), aVar);
            }
        }
    }
}
