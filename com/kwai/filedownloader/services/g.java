package com.kwai.filedownloader.services;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import com.kwai.filedownloader.y;
import java.util.List;
/* loaded from: classes7.dex */
public final class g implements y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwai.filedownloader.a.a awA;
    public final h awB;

    public g() {
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
        com.kwai.filedownloader.download.b Dp = com.kwai.filedownloader.download.b.Dp();
        this.awA = Dp.Dr();
        this.awB = new h(Dp.Ds());
    }

    private boolean cB(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) ? a(this.awA.cd(i)) : invokeI.booleanValue;
    }

    public final void DW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.awA.clear();
        }
    }

    public final void EE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            List<Integer> EH = this.awB.EH();
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "pause all tasks %d", Integer.valueOf(EH.size()));
            }
            for (Integer num : EH) {
                bW(num.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.y
    public final boolean a(com.kwai.filedownloader.c.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            boolean cD = this.awB.cD(cVar.getId());
            if (com.kwai.filedownloader.c.d.cy(cVar.Ca())) {
                if (!cD) {
                    return false;
                }
            } else if (!cD) {
                com.kwai.filedownloader.e.d.c(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.Ca()));
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean ab(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? cB(com.kwai.filedownloader.e.f.ad(str, str2)) : invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0184 A[Catch: all -> 0x01cf, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0014, B:9:0x0026, B:12:0x0035, B:14:0x0045, B:16:0x004f, B:18:0x0053, B:19:0x0066, B:23:0x0073, B:25:0x0079, B:27:0x007d, B:31:0x008e, B:33:0x0097, B:35:0x00a0, B:37:0x00a4, B:42:0x00b7, B:45:0x00c0, B:47:0x00c9, B:49:0x00d8, B:51:0x00dc, B:53:0x00ed, B:57:0x00fb, B:59:0x0102, B:61:0x0109, B:63:0x010f, B:65:0x0116, B:67:0x011c, B:69:0x0122, B:71:0x013c, B:72:0x0140, B:74:0x0146, B:83:0x0184, B:84:0x0189, B:75:0x0155, B:77:0x015f, B:79:0x0165, B:80:0x016a, B:46:0x00c5, B:32:0x0093), top: B:93:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        com.kwai.filedownloader.c.c cVar;
        List<com.kwai.filedownloader.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)}) == null) {
            synchronized (this) {
                boolean z4 = false;
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
                }
                int k = com.kwai.filedownloader.e.f.k(str, str2, z);
                com.kwai.filedownloader.c.c cd = this.awA.cd(k);
                if (z || cd != null) {
                    cVar = cd;
                    list = null;
                } else {
                    int k2 = com.kwai.filedownloader.e.f.k(str, com.kwai.filedownloader.e.f.eH(str2), true);
                    com.kwai.filedownloader.c.c cd2 = this.awA.cd(k2);
                    if (cd2 == null || !str2.equals(cd2.getTargetFilePath())) {
                        list = null;
                    } else {
                        if (com.kwai.filedownloader.e.d.awL) {
                            com.kwai.filedownloader.e.d.e(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(k), Integer.valueOf(k2));
                        }
                        list = this.awA.ce(k2);
                    }
                    cVar = cd2;
                }
                if (com.kwai.filedownloader.e.c.a(k, cVar, (y) this, true)) {
                    if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "has already started download %d", Integer.valueOf(k));
                    }
                    return;
                }
                String targetFilePath = cVar != null ? cVar.getTargetFilePath() : com.kwai.filedownloader.e.f.a(str2, z, (String) null);
                if (com.kwai.filedownloader.e.c.a(k, targetFilePath, z2, true)) {
                    if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "has already completed downloading %d", Integer.valueOf(k));
                    }
                    return;
                }
                if (com.kwai.filedownloader.e.c.a(k, cVar != null ? cVar.Em() : 0L, cVar != null ? cVar.DE() : com.kwai.filedownloader.e.f.eF(targetFilePath), targetFilePath, this)) {
                    if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(k), targetFilePath);
                        if (cVar != null) {
                            this.awA.cg(k);
                            this.awA.cf(k);
                        }
                    }
                    return;
                }
                if (cVar == null || !(cVar.Ca() == -2 || cVar.Ca() == -1 || cVar.Ca() == 1 || cVar.Ca() == 6 || cVar.Ca() == 2)) {
                    if (cVar == null) {
                        cVar = new com.kwai.filedownloader.c.c();
                    }
                    cVar.setUrl(str);
                    cVar.d(str2, z);
                    cVar.setId(k);
                    cVar.Z(0L);
                    cVar.ab(0L);
                    cVar.e((byte) 1);
                    cVar.cw(1);
                } else if (cVar.getId() == k) {
                    if (!TextUtils.equals(str, cVar.getUrl())) {
                        cVar.setUrl(str);
                    }
                    if (z4) {
                        this.awA.b(cVar);
                    }
                    this.awB.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).a(Integer.valueOf(i2)).b(Integer.valueOf(i)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i3)).DF());
                } else {
                    this.awA.cg(cVar.getId());
                    this.awA.cf(cVar.getId());
                    cVar.setId(k);
                    cVar.d(str2, z);
                    if (list != null) {
                        for (com.kwai.filedownloader.c.a aVar : list) {
                            aVar.setId(k);
                            this.awA.a(aVar);
                        }
                    }
                }
                z4 = true;
                if (z4) {
                }
                this.awB.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).a(Integer.valueOf(i2)).b(Integer.valueOf(i)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).c(Integer.valueOf(i3)).DF());
            }
        }
    }

    public final boolean bW(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "request pause the task %d", Integer.valueOf(i));
            }
            com.kwai.filedownloader.c.c cd = this.awA.cd(i);
            if (cd == null) {
                return false;
            }
            cd.e((byte) -2);
            this.awB.cancel(i);
            return true;
        }
        return invokeI.booleanValue;
    }

    public final byte bX(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            com.kwai.filedownloader.c.c cd = this.awA.cd(i);
            if (cd == null) {
                return (byte) 0;
            }
            return cd.Ca();
        }
        return invokeI.byteValue;
    }

    public final boolean bY(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i == 0) {
                com.kwai.filedownloader.e.d.f(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
                return false;
            } else if (cB(i)) {
                com.kwai.filedownloader.e.d.f(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
                return false;
            } else {
                this.awA.cg(i);
                this.awA.cf(i);
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public final long cC(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            com.kwai.filedownloader.c.c cd = this.awA.cd(i);
            if (cd == null) {
                return 0L;
            }
            int Eo = cd.Eo();
            if (Eo <= 1) {
                return cd.Em();
            }
            List<com.kwai.filedownloader.c.a> ce = this.awA.ce(i);
            if (ce == null || ce.size() != Eo) {
                return 0L;
            }
            return com.kwai.filedownloader.c.a.G(ce);
        }
        return invokeI.longValue;
    }

    public final synchronized boolean cq(int i) {
        InterceptResult invokeI;
        boolean cq;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            synchronized (this) {
                cq = this.awB.cq(i);
            }
            return cq;
        }
        return invokeI.booleanValue;
    }

    public final long cs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            com.kwai.filedownloader.c.c cd = this.awA.cd(i);
            if (cd == null) {
                return 0L;
            }
            return cd.getTotal();
        }
        return invokeI.longValue;
    }

    public final boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.awB.EG() <= 0 : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.y
    public final int p(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) ? this.awB.p(str, i) : invokeLI.intValue;
    }
}
