package com.kwai.filedownloader.download;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.utils.g;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.c;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadHttpException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadPoolExecutor auN;
    public transient /* synthetic */ FieldHolder $fh;
    public final d auA;
    public final int auB;
    public final com.kwai.filedownloader.c.c auC;
    public final com.kwai.filedownloader.c.b auD;
    public final boolean auE;
    public final boolean auF;
    public final y auG;
    public boolean auH;
    public int auI;
    public final boolean auJ;
    public final ArrayList<c> auK;
    public e auL;
    public boolean auM;
    public boolean auO;
    public boolean auP;
    public boolean auQ;
    public final AtomicBoolean auR;
    public volatile boolean auS;
    public volatile Exception auT;
    public String auU;
    public long auV;
    public long auW;
    public long auX;
    public long auY;
    public final com.kwai.filedownloader.a.a aux;
    public volatile boolean hw;

    /* loaded from: classes8.dex */
    public class DiscardSafely extends Throwable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4243896780616180062L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadLaunchRunnable this$0;

        public DiscardSafely(DownloadLaunchRunnable downloadLaunchRunnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadLaunchRunnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = downloadLaunchRunnable;
        }
    }

    /* loaded from: classes8.dex */
    public class RetryDirectly extends Throwable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4127585119566978768L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadLaunchRunnable this$0;

        public RetryDirectly(DownloadLaunchRunnable downloadLaunchRunnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadLaunchRunnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = downloadLaunchRunnable;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwai.filedownloader.c.c auC;
        public y auG;
        public Integer auZ;
        public com.kwai.filedownloader.c.b auj;
        public Integer ava;
        public Boolean avb;
        public Boolean avc;
        public Integer avd;

        public a() {
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

        public final DownloadLaunchRunnable DF() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.auC == null || this.auG == null || this.auZ == null || this.ava == null || this.avb == null || this.avc == null || this.avd == null) {
                    throw new IllegalArgumentException();
                }
                return new DownloadLaunchRunnable(this.auC, this.auj, this.auG, this.auZ.intValue(), this.ava.intValue(), this.avb.booleanValue(), this.avc.booleanValue(), this.avd.intValue(), (byte) 0);
            }
            return (DownloadLaunchRunnable) invokeV.objValue;
        }

        public final a a(y yVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yVar)) == null) {
                this.auG = yVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool)) == null) {
                this.avb = bool;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, num)) == null) {
                this.auZ = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(com.kwai.filedownloader.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.auj = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bool)) == null) {
                this.avc = bool;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, num)) == null) {
                this.ava = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, num)) == null) {
                this.avd = num;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a e(com.kwai.filedownloader.c.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
                this.auC = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-912615623, "Lcom/kwai/filedownloader/download/DownloadLaunchRunnable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-912615623, "Lcom/kwai/filedownloader/download/DownloadLaunchRunnable;");
                return;
            }
        }
        auN = com.kwai.filedownloader.e.b.eC("ConnectionBlock");
    }

    public DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar, yVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.auB = 5;
        this.auK = new ArrayList<>(5);
        this.auV = 0L;
        this.auW = 0L;
        this.auX = 0L;
        this.auY = 0L;
        this.auR = new AtomicBoolean(true);
        this.hw = false;
        this.auH = false;
        this.auC = cVar;
        this.auD = bVar;
        this.auE = z;
        this.auF = z2;
        this.aux = b.Dp().Dr();
        this.auJ = b.Dp().Dt();
        this.auG = yVar;
        this.auI = i3;
        this.auA = new d(cVar, i3, i, i2);
    }

    public /* synthetic */ DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3, byte b) {
        this(cVar, bVar, yVar, i, i2, z, z2, i3);
    }

    private boolean DA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? (!this.auO || this.auC.Eo() > 1) && this.auP && this.auJ && !this.auQ : invokeV.booleanValue;
    }

    private void DC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (this.auF && !com.kwai.filedownloader.e.f.eJ("android.permission.ACCESS_NETWORK_STATE")) {
                throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.h("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.auC.getId()), "android.permission.ACCESS_NETWORK_STATE"));
            }
            if (this.auF && com.kwai.filedownloader.e.f.EQ()) {
                throw new FileDownloadNetworkPolicyException();
            }
        }
    }

    private void DD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            int id = this.auC.getId();
            if (this.auC.BW()) {
                String targetFilePath = this.auC.getTargetFilePath();
                int ad = com.kwai.filedownloader.e.f.ad(this.auC.getUrl(), targetFilePath);
                if (com.kwai.filedownloader.e.c.a(id, targetFilePath, this.auE, false)) {
                    this.aux.cg(id);
                    this.aux.cf(id);
                    throw new DiscardSafely(this);
                }
                com.kwai.filedownloader.c.c cd = this.aux.cd(ad);
                if (cd != null) {
                    if (com.kwai.filedownloader.e.c.a(id, cd, this.auG, false)) {
                        this.aux.cg(id);
                        this.aux.cf(id);
                        throw new DiscardSafely(this);
                    }
                    List<com.kwai.filedownloader.c.a> ce = this.aux.ce(ad);
                    this.aux.cg(ad);
                    this.aux.cf(ad);
                    com.kwai.filedownloader.e.f.eN(this.auC.getTargetFilePath());
                    if (com.kwai.filedownloader.e.f.b(ad, cd)) {
                        this.auC.Z(cd.Em());
                        this.auC.ab(cd.getTotal());
                        this.auC.ez(cd.En());
                        this.auC.cw(cd.Eo());
                        this.aux.b(this.auC);
                        if (ce != null) {
                            for (com.kwai.filedownloader.c.a aVar : ce) {
                                aVar.setId(id);
                                this.aux.a(aVar);
                            }
                        }
                        throw new RetryDirectly(this);
                    }
                }
                if (com.kwai.filedownloader.e.c.a(id, this.auC.Em(), this.auC.DE(), targetFilePath, this.auG)) {
                    this.aux.cg(id);
                    this.aux.cf(id);
                    throw new DiscardSafely(this);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.kwai.filedownloader.download.a F(List<com.kwai.filedownloader.c.a> list) {
        InterceptResult invokeL;
        long Em;
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, list)) == null) {
            int Eo = this.auC.Eo();
            String DE = this.auC.DE();
            String targetFilePath = this.auC.getTargetFilePath();
            boolean z2 = Eo > 1;
            if ((!z2 || this.auJ) && com.kwai.filedownloader.e.f.b(this.auC.getId(), this.auC)) {
                if (!this.auJ) {
                    Em = new File(DE).length();
                } else if (!z2) {
                    Em = this.auC.Em();
                } else if (Eo == list.size()) {
                    Em = com.kwai.filedownloader.c.a.G(list);
                }
                j = Em;
                this.auC.Z(j);
                z = j > 0;
                this.auO = z;
                if (!z) {
                    this.aux.cf(this.auC.getId());
                    com.kwai.filedownloader.e.f.ae(targetFilePath, DE);
                }
                return new com.kwai.filedownloader.download.a(0L, j, 0L, this.auC.getTotal() - j);
            }
            j = 0;
            this.auC.Z(j);
            if (j > 0) {
            }
            this.auO = z;
            if (!z) {
            }
            return new com.kwai.filedownloader.download.a(0L, j, 0L, this.auC.getTotal() - j);
        }
        return (com.kwai.filedownloader.download.a) invokeL.objValue;
    }

    private void a(int i, List<com.kwai.filedownloader.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, this, i, list) == null) {
            if (i <= 1 || list.size() != i) {
                throw new IllegalArgumentException();
            }
            c(list, this.auC.getTotal());
        }
    }

    private void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65544, this, j, str) == null) {
            com.kwai.filedownloader.d.a aVar = null;
            if (j != -1) {
                try {
                    aVar = com.kwai.filedownloader.e.f.eL(this.auC.DE());
                    long length = new File(str).length();
                    long j2 = j - length;
                    long availableBytes = g.getAvailableBytes(str);
                    if (availableBytes < j2) {
                        throw new FileDownloadOutOfSpaceException(availableBytes, j2, length);
                    }
                    if (!com.kwai.filedownloader.e.e.EL().awR) {
                        aVar.setLength(j);
                    }
                } finally {
                    if (0 != 0) {
                        aVar.close();
                    }
                }
            }
        }
    }

    private void a(com.kwai.filedownloader.download.a aVar, com.kwai.filedownloader.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, aVar, bVar) == null) {
            if (!this.auP) {
                this.auC.Z(0L);
                aVar = new com.kwai.filedownloader.download.a(0L, 0L, aVar.aus, aVar.contentLength);
            }
            e.a aVar2 = new e.a();
            aVar2.b(this).cp(this.auC.getId()).co(-1).bD(this.auF).d(bVar).c(aVar).ex(this.auC.DE());
            this.auC.cw(1);
            this.aux.x(this.auC.getId(), 1);
            this.auL = aVar2.DT();
            if (!this.hw) {
                this.auL.run();
                return;
            }
            this.auC.e((byte) -2);
            this.auL.pause();
        }
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwai.filedownloader.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, this, map, connectTask, bVar) == null) {
            int id = this.auC.getId();
            int responseCode = bVar.getResponseCode();
            this.auP = responseCode == 206 || responseCode == 1;
            boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
            String En = this.auC.En();
            String a2 = com.kwai.filedownloader.e.f.a(id, bVar);
            if (!(responseCode == 412 || !(En == null || En.equals(a2) || (!z && !this.auP)) || ((responseCode == 201 && connectTask.Dl()) || (responseCode == 416 && this.auC.Em() > 0)))) {
                this.auU = connectTask.Dm();
                if (!this.auP && !z) {
                    throw new FileDownloadHttpException(responseCode, map, bVar.V());
                }
                long b = com.kwai.filedownloader.e.f.b(id, bVar);
                String a3 = this.auC.BW() ? com.kwai.filedownloader.e.f.a(bVar, this.auC.getUrl()) : null;
                boolean z2 = b == -1;
                this.auQ = z2;
                this.auA.a(this.auO && this.auP, !z2 ? this.auC.Em() + b : b, a2, a3);
                return;
            }
            if (this.auO) {
                com.kwai.filedownloader.e.d.f(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), En, a2, Integer.valueOf(responseCode));
            }
            this.aux.cf(this.auC.getId());
            com.kwai.filedownloader.e.f.ae(this.auC.getTargetFilePath(), this.auC.DE());
            this.auO = false;
            if (En != 0 && En.equals(a2)) {
                com.kwai.filedownloader.e.d.f(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", En, a2, Integer.valueOf(responseCode), Integer.valueOf(id));
                a2 = null;
            }
            this.auC.Z(0L);
            this.auC.ab(0L);
            this.auC.ez(a2);
            this.auC.Ep();
            this.aux.a(id, this.auC.En(), this.auC.Em(), this.auC.getTotal(), this.auC.Eo());
            throw new RetryDirectly(this);
        }
    }

    private void c(List<com.kwai.filedownloader.c.a> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, this, list, j) == null) {
            int id = this.auC.getId();
            String En = this.auC.En();
            String str = this.auU;
            if (str == null) {
                str = this.auC.getUrl();
            }
            String DE = this.auC.DE();
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
            }
            boolean z = this.auO;
            long j2 = 0;
            long j3 = 0;
            for (com.kwai.filedownloader.c.a aVar : list) {
                long Ei = aVar.Ej() == j2 ? j - aVar.Ei() : (aVar.Ej() - aVar.Ei()) + 1;
                j3 += aVar.Ei() - aVar.getStartOffset();
                if (Ei != j2) {
                    c DG = new c.a().cm(id).d(Integer.valueOf(aVar.getIndex())).a(this).eu(str).ev(z ? En : null).c(this.auD).bB(this.auF).b(new com.kwai.filedownloader.download.a(aVar.getStartOffset(), aVar.Ei(), aVar.Ej(), Ei)).ew(DE).DG();
                    if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "enable multiple connection: %s", aVar);
                    }
                    this.auK.add(DG);
                } else if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
                }
                j2 = 0;
            }
            if (j3 != this.auC.Em()) {
                com.kwai.filedownloader.e.d.f(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.auC.Em()), Long.valueOf(j3));
                this.auC.Z(j3);
            }
            ArrayList arrayList = new ArrayList(this.auK.size());
            Iterator<c> it = this.auK.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (this.hw) {
                    next.pause();
                } else {
                    arrayList.add(Executors.callable(next));
                }
            }
            if (this.hw) {
                this.auC.e((byte) -2);
                return;
            }
            List<Future> invokeAll = auN.invokeAll(arrayList);
            if (com.kwai.filedownloader.e.d.awL) {
                for (Future future : invokeAll) {
                    com.kwai.filedownloader.e.d.e(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
                }
            }
        }
    }

    private void d(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            long j2 = j / i;
            int id = this.auC.getId();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            long j3 = 0;
            while (i2 < i) {
                long j4 = i2 == i + (-1) ? 0L : (j3 + j2) - 1;
                com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
                aVar.setId(id);
                aVar.setIndex(i2);
                aVar.setStartOffset(j3);
                aVar.X(j3);
                aVar.Y(j4);
                arrayList.add(aVar);
                this.aux.a(aVar);
                j3 += j2;
                i2++;
            }
            this.auC.cw(i);
            this.aux.x(id, i);
            c(arrayList, j);
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final void DB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.aux.c(this.auC.getId(), this.auC.Em());
        }
    }

    public final String DE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.auC.DE() : (String) invokeV.objValue;
    }

    public final void Dz() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.auC.Eo() > 1) {
                List<com.kwai.filedownloader.c.a> ce = this.aux.ce(this.auC.getId());
                if (this.auC.Eo() == ce.size()) {
                    this.auC.Z(com.kwai.filedownloader.c.a.G(ce));
                } else {
                    this.auC.Z(0L);
                    this.aux.cf(this.auC.getId());
                }
            }
            this.auA.DI();
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final void a(c cVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (this.hw) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.auC.getId()));
                    return;
                }
                return;
            }
            int i = cVar == null ? -1 : cVar.avh;
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.auC.getTotal()));
            }
            if (!this.auM) {
                synchronized (this.auK) {
                    this.auK.remove(cVar);
                }
            } else if (j == 0 || j2 == this.auC.getTotal()) {
            } else {
                com.kwai.filedownloader.e.d.c(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.auC.getTotal()), Integer.valueOf(this.auC.getId()));
            }
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final void a(Exception exc, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, exc, j) == null) {
            if (this.hw) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.auC.getId()));
                    return;
                }
                return;
            }
            int i = this.auI;
            int i2 = i - 1;
            this.auI = i2;
            if (i < 0) {
                com.kwai.filedownloader.e.d.c(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.auC.getId()));
            }
            this.auA.a(exc, this.auI, j);
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final boolean d(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, exc)) == null) {
            if (exc instanceof FileDownloadHttpException) {
                int code = ((FileDownloadHttpException) exc).getCode();
                if (this.auM && code == 416 && !this.auH) {
                    com.kwai.filedownloader.e.f.ae(this.auC.getTargetFilePath(), this.auC.DE());
                    this.auH = true;
                    return true;
                }
            }
            return this.auI > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.download.f
    public final void e(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
            this.auS = true;
            this.auT = exc;
            if (this.hw) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.auC.getId()));
                    return;
                }
                return;
            }
            Iterator it = ((ArrayList) this.auK.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.CP();
                }
            }
        }
    }

    public final int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.auC.getId() : invokeV.intValue;
    }

    public final boolean isAlive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.auR.get() || this.auA.isAlive() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.download.f
    public final void onProgress(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j) == null) || this.hw) {
            return;
        }
        this.auA.onProgress(j);
    }

    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.hw = true;
            e eVar = this.auL;
            if (eVar != null) {
                eVar.pause();
            }
            Iterator it = ((ArrayList) this.auK.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.pause();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e5, code lost:
        d(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ea, code lost:
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01eb, code lost:
        if (r9 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ed, code lost:
        r9.W();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0203, code lost:
        throw new java.lang.IllegalAccessException(com.kwai.filedownloader.e.f.h("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a3, code lost:
        if (com.kwai.filedownloader.e.d.awL == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a5, code lost:
        com.kwai.filedownloader.e.d.e(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.auC.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
        r19.auA.DH();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
        if (r19.hw == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c2, code lost:
        if (r19.auS == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
        r19.auA.DM();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cc, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0124, code lost:
        if (r19.hw == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0126, code lost:
        r19.auC.e((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012b, code lost:
        if (r9 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012d, code lost:
        r9.W();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0130, code lost:
        r19.auA.DH();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0137, code lost:
        if (r19.hw == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013d, code lost:
        if (r19.auS == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0141, code lost:
        r19.auA.DM();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0149, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014c, code lost:
        DD();
        r14 = r19.auC.getTotal();
        a(r14, r19.auC.DE());
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
        if (DA() == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0166, code lost:
        if (r19.auO == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0168, code lost:
        r10 = r19.auC.Eo();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0171, code lost:
        r17 = r14;
        r10 = com.kwai.filedownloader.download.b.Dp().a(r19.auC.getId(), r19.auC.getUrl(), r19.auC.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0191, code lost:
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
        if (r10 <= 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0198, code lost:
        if (r19.hw == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019a, code lost:
        r19.auC.e((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019f, code lost:
        if (r9 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a1, code lost:
        r9.W();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a4, code lost:
        r19.auA.DH();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ab, code lost:
        if (r19.hw == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b1, code lost:
        if (r19.auS == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b5, code lost:
        r19.auA.DM();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01bd, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
        if (r10 != 1) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c2, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c4, code lost:
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c5, code lost:
        r19.auM = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c7, code lost:
        if (r11 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c9, code lost:
        a(r8.Dn(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d1, code lost:
        if (r9 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
        r9.W();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01d7, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d8, code lost:
        r19.auA.DK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01df, code lost:
        if (r19.auO == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e1, code lost:
        a(r10, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:155:0x025e A[Catch: all -> 0x021b, TryCatch #24 {all -> 0x021b, blocks: (B:48:0x00d3, B:97:0x01d8, B:99:0x01e1, B:100:0x01e5, B:153:0x0258, B:155:0x025e, B:158:0x0266, B:126:0x021e), top: B:206:0x0258 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0271 A[Catch: all -> 0x0291, TryCatch #23 {all -> 0x0291, blocks: (B:5:0x0009, B:8:0x0018, B:10:0x0020, B:12:0x0024, B:13:0x0036, B:27:0x0094, B:29:0x0098, B:30:0x009d, B:32:0x00a1, B:34:0x00a5, B:45:0x00ce, B:53:0x012d, B:76:0x01a1, B:103:0x01ed, B:162:0x0271, B:163:0x0274, B:130:0x022d, B:128:0x0226, B:160:0x026b), top: B:205:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0266 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        IOException iOException;
        Exception exc;
        Throwable th;
        ConnectTask Do;
        com.kwai.filedownloader.kwai.b Dk;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                Process.setThreadPriority(10);
                if (this.auC.Ca() != 1) {
                    if (this.auC.Ca() != -2) {
                        e(new RuntimeException(com.kwai.filedownloader.e.f.h("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.auC.getId()), Byte.valueOf(this.auC.Ca()), (byte) 1)));
                    } else if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.auC.getId()));
                    }
                    this.auA.DH();
                    if (!this.hw) {
                        if (!this.auS) {
                            try {
                                this.auA.DM();
                            } catch (IOException e) {
                                iOException = e;
                                this.auA.f(iOException);
                                this.auR.set(false);
                            }
                        }
                        this.auA.f(this.auT);
                    }
                    this.auA.DL();
                } else {
                    if (!this.hw) {
                        this.auA.DJ();
                    }
                    while (true) {
                        if (!this.hw) {
                            if (this.aux == null) {
                                break;
                            }
                            com.kwai.filedownloader.kwai.b bVar = null;
                            try {
                                DC();
                                List<com.kwai.filedownloader.c.a> ce = this.aux.ce(this.auC.getId());
                                Do = new ConnectTask.a().cl(this.auC.getId()).er(this.auC.getUrl()).es(this.auC.En()).a(this.auD).a(F(ce)).Do();
                                Dk = Do.Dk();
                            } catch (DiscardSafely unused) {
                            } catch (RetryDirectly unused2) {
                            } catch (FileDownloadGiveUpRetryException e2) {
                                e = e2;
                                exc = e;
                                try {
                                    if (d(exc)) {
                                        e(exc);
                                        if (bVar != null) {
                                            bVar.W();
                                        }
                                        this.auA.DH();
                                        if (!this.hw) {
                                            if (!this.auS) {
                                                try {
                                                    this.auA.DM();
                                                } catch (IOException e3) {
                                                    iOException = e3;
                                                    this.auA.f(iOException);
                                                    this.auR.set(false);
                                                }
                                                this.auR.set(false);
                                            }
                                            this.auA.f(this.auT);
                                            this.auR.set(false);
                                        }
                                        this.auA.DL();
                                        this.auR.set(false);
                                    }
                                    a(exc, 0L);
                                    if (bVar != null) {
                                        bVar.W();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (bVar != null) {
                                        bVar.W();
                                    }
                                    throw th;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                exc = e;
                                if (d(exc)) {
                                }
                            } catch (IllegalAccessException e5) {
                                e = e5;
                                exc = e;
                                if (d(exc)) {
                                }
                            } catch (IllegalArgumentException e6) {
                                e = e6;
                                exc = e;
                                if (d(exc)) {
                                }
                            } catch (InterruptedException e7) {
                                e = e7;
                                exc = e;
                                if (d(exc)) {
                                }
                            } catch (NullPointerException e8) {
                                e = e8;
                                exc = e;
                                if (d(exc)) {
                                }
                            }
                            try {
                                a(Do.getRequestHeader(), Do, Dk);
                                break;
                            } catch (DiscardSafely unused3) {
                                bVar = Dk;
                                if (bVar != null) {
                                    bVar.W();
                                }
                                this.auA.DH();
                                if (!this.hw) {
                                    if (!this.auS) {
                                        try {
                                            this.auA.DM();
                                        } catch (IOException e9) {
                                            iOException = e9;
                                            this.auA.f(iOException);
                                            this.auR.set(false);
                                        }
                                        this.auR.set(false);
                                    }
                                    this.auA.f(this.auT);
                                    this.auR.set(false);
                                }
                                this.auA.DL();
                                this.auR.set(false);
                            } catch (RetryDirectly unused4) {
                                bVar = Dk;
                                this.auC.e((byte) 5);
                                if (bVar != null) {
                                    bVar.W();
                                }
                            } catch (FileDownloadGiveUpRetryException e10) {
                                e = e10;
                                exc = e;
                                bVar = Dk;
                                if (d(exc)) {
                                }
                            } catch (IOException e11) {
                                e = e11;
                                exc = e;
                                bVar = Dk;
                                if (d(exc)) {
                                }
                            } catch (IllegalAccessException e12) {
                                e = e12;
                                exc = e;
                                bVar = Dk;
                                if (d(exc)) {
                                }
                            } catch (IllegalArgumentException e13) {
                                e = e13;
                                exc = e;
                                bVar = Dk;
                                if (d(exc)) {
                                }
                            } catch (InterruptedException e14) {
                                e = e14;
                                exc = e;
                                bVar = Dk;
                                if (d(exc)) {
                                }
                            } catch (NullPointerException e15) {
                                e = e15;
                                exc = e;
                                bVar = Dk;
                                if (d(exc)) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bVar = Dk;
                                if (bVar != null) {
                                }
                                throw th;
                            }
                        } else {
                            break;
                        }
                    }
                    this.auA.f(this.auT);
                }
                this.auR.set(false);
            } catch (Throwable th4) {
                this.auA.DH();
                if (this.hw) {
                    this.auA.DL();
                } else if (this.auS) {
                    this.auA.f(this.auT);
                } else {
                    try {
                        this.auA.DM();
                    } catch (IOException e16) {
                        this.auA.f(e16);
                    }
                }
                this.auR.set(false);
                throw th4;
            }
        }
    }
}
