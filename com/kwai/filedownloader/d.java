package com.kwai.filedownloader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.s;
import com.kwai.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class d implements a.c, x, x.a, x.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object asJ;
    public t asN;
    public final a asO;
    public volatile byte asP;
    public volatile long asQ;
    public Throwable asR;
    public final s.b asS;
    public final s.a asT;
    public long asU;
    public long asV;
    public int asW;
    public boolean asX;
    public boolean asY;
    public String asZ;
    public boolean ata;

    /* loaded from: classes8.dex */
    public interface a {
        com.kwai.filedownloader.c.b Cv();

        a.InterfaceC0625a Cw();

        ArrayList<Object> Cx();

        void ep(String str);
    }

    public d(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.asP = (byte) 0;
        this.asR = null;
        this.ata = false;
        this.asJ = obj;
        this.asO = aVar;
        b bVar = new b();
        this.asS = bVar;
        this.asT = bVar;
        this.asN = new k(aVar.Cw(), this);
    }

    private void c(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(65537, this, b) == null) {
            this.asP = b;
            this.asQ = System.currentTimeMillis();
        }
    }

    private void e(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, messageSnapshot) == null) {
            com.kwai.filedownloader.a Ci = this.asO.Cw().Ci();
            byte Ca = messageSnapshot.Ca();
            c(Ca);
            this.asX = messageSnapshot.Cg();
            if (Ca == -4) {
                this.asS.reset();
                int bS = h.CG().bS(Ci.getId());
                if (bS + ((bS > 1 || !Ci.BW()) ? 0 : h.CG().bS(com.kwai.filedownloader.e.f.ad(Ci.getUrl(), Ci.getTargetFilePath()))) <= 1) {
                    byte bX = n.CR().bX(Ci.getId());
                    com.kwai.filedownloader.e.d.f(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(Ci.getId()), Integer.valueOf(bX));
                    if (com.kwai.filedownloader.c.d.cz(bX)) {
                        c((byte) 1);
                        this.asV = messageSnapshot.Eb();
                        long Ed = messageSnapshot.Ed();
                        this.asU = Ed;
                        this.asS.start(Ed);
                        this.asN.f(((MessageSnapshot.a) messageSnapshot).Ef());
                        return;
                    }
                }
                h.CG().a(this.asO.Cw(), messageSnapshot);
            } else if (Ca == -3) {
                this.ata = messageSnapshot.Ec();
                this.asU = messageSnapshot.Eb();
                this.asV = messageSnapshot.Eb();
                h.CG().a(this.asO.Cw(), messageSnapshot);
            } else if (Ca == -1) {
                this.asR = messageSnapshot.Ee();
                this.asU = messageSnapshot.Ed();
                h.CG().a(this.asO.Cw(), messageSnapshot);
            } else if (Ca == 1) {
                this.asU = messageSnapshot.Ed();
                this.asV = messageSnapshot.Eb();
                this.asN.f(messageSnapshot);
            } else if (Ca == 2) {
                this.asV = messageSnapshot.Eb();
                this.asY = messageSnapshot.DR();
                this.asZ = messageSnapshot.getEtag();
                String fileName = messageSnapshot.getFileName();
                if (fileName != null) {
                    if (Ci.getFilename() != null) {
                        com.kwai.filedownloader.e.d.f(this, "already has mFilename[%s], but assign mFilename[%s] again", Ci.getFilename(), fileName);
                    }
                    this.asO.ep(fileName);
                }
                this.asS.start(this.asU);
                this.asN.h(messageSnapshot);
            } else if (Ca == 3) {
                this.asU = messageSnapshot.Ed();
                this.asS.U(messageSnapshot.Ed());
                this.asN.i(messageSnapshot);
            } else if (Ca != 5) {
                if (Ca != 6) {
                    return;
                }
                this.asN.g(messageSnapshot);
            } else {
                this.asU = messageSnapshot.Ed();
                this.asR = messageSnapshot.Ee();
                this.asW = messageSnapshot.Ce();
                this.asS.reset();
                this.asN.k(messageSnapshot);
            }
        }
    }

    private int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.asO.Cw().Ci().getId() : invokeV.intValue;
    }

    private void prepare() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwai.filedownloader.a Ci = this.asO.Cw().Ci();
            if (Ci.getPath() == null) {
                Ci.en(com.kwai.filedownloader.e.f.eD(Ci.getUrl()));
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "save Path is null to %s", Ci.getPath());
                }
            }
            if (Ci.BW()) {
                file = new File(Ci.getPath());
            } else {
                String eH = com.kwai.filedownloader.e.f.eH(Ci.getPath());
                if (eH == null) {
                    throw new InvalidParameterException(com.kwai.filedownloader.e.f.h("the provided mPath[%s] is invalid, can't find its directory", Ci.getPath()));
                }
                file = new File(eH);
            }
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                throw new IOException(com.kwai.filedownloader.e.f.h("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
            }
        }
    }

    @Override // com.kwai.filedownloader.x
    public final long CA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.asU : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x
    public final byte Ca() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.asP : invokeV.byteValue;
    }

    @Override // com.kwai.filedownloader.x
    public final Throwable Cc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.asR : (Throwable) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.x
    public final int Ce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.asW : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.x
    public final boolean Cg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.asX : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.c
    public final void Cr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.g(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(Ca()));
            }
            this.asS.end(this.asU);
            if (this.asO.Cx() != null) {
                ArrayList arrayList = (ArrayList) this.asO.Cx().clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i);
                }
            }
            r.CZ().Dd().e(this.asO.Cw());
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public final t Cy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.asN : (t) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.x
    public final void Cz() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.asJ) {
                if (this.asP != 0) {
                    com.kwai.filedownloader.e.d.f(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.asP));
                    return;
                }
                c((byte) 10);
                a.InterfaceC0625a Cw = this.asO.Cw();
                com.kwai.filedownloader.a Ci = Cw.Ci();
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.g(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", Ci.getUrl(), Ci.getPath(), Ci.BX(), Ci.getTag());
                }
                try {
                    prepare();
                    z = true;
                } catch (Throwable th) {
                    h.CG().b(Cw);
                    h.CG().a(Cw, n(th));
                    z = false;
                }
                if (z) {
                    q.CX().a(this);
                }
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.g(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, messageSnapshot)) == null) {
            if (com.kwai.filedownloader.c.d.y(Ca(), messageSnapshot.Ca())) {
                e(messageSnapshot);
                return true;
            }
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.asP), Byte.valueOf(Ca()), Integer.valueOf(getId()));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, messageSnapshot)) == null) {
            byte Ca = Ca();
            byte Ca2 = messageSnapshot.Ca();
            if (-2 == Ca && com.kwai.filedownloader.c.d.cz(Ca2)) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
                }
                return true;
            } else if (com.kwai.filedownloader.c.d.z(Ca, Ca2)) {
                e(messageSnapshot);
                return true;
            } else {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.asP), Byte.valueOf(Ca()), Integer.valueOf(getId()));
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, messageSnapshot)) == null) {
            if (com.kwai.filedownloader.c.d.f(this.asO.Cw().Ci())) {
                e(messageSnapshot);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, messageSnapshot)) == null) {
            if (this.asO.Cw().Ci().BW() && messageSnapshot.Ca() == -4 && Ca() == 2) {
                e(messageSnapshot);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public final void free() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.asP));
            }
            c((byte) 0);
        }
    }

    @Override // com.kwai.filedownloader.s.a
    public final int getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.asT.getSpeed() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.x
    public final long getStatusUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.asQ : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x
    public final long getTotalBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.asV : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.x.a
    public final MessageSnapshot n(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, th)) == null) {
            c((byte) -1);
            this.asR = th;
            return com.kwai.filedownloader.message.f.a(getId(), CA(), th);
        }
        return (MessageSnapshot) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a.c
    public final void onBegin() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && com.kwai.filedownloader.e.d.awL) {
            com.kwai.filedownloader.e.d.g(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(Ca()));
        }
    }

    @Override // com.kwai.filedownloader.x
    public final boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (com.kwai.filedownloader.c.d.cy(Ca())) {
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(Ca()), Integer.valueOf(this.asO.Cw().Ci().getId()));
                }
                return false;
            }
            c((byte) -2);
            a.InterfaceC0625a Cw = this.asO.Cw();
            com.kwai.filedownloader.a Ci = Cw.Ci();
            q.CX().b(this);
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
            }
            r.CZ();
            if (r.Db()) {
                n.CR().bW(Ci.getId());
            } else if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(Ci.getId()));
            }
            h.CG().b(Cw);
            h.CG().a(Cw, com.kwai.filedownloader.message.f.e(Ci));
            r.CZ().Dd().e(Cw);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.x
    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.asR = null;
            this.asZ = null;
            this.asY = false;
            this.asW = 0;
            this.ata = false;
            this.asX = false;
            this.asU = 0L;
            this.asV = 0L;
            this.asS.reset();
            if (com.kwai.filedownloader.c.d.cy(this.asP)) {
                this.asN.CP();
                this.asN = new k(this.asO.Cw(), this);
            } else {
                this.asN.b(this.asO.Cw(), this);
            }
            c((byte) 0);
        }
    }

    @Override // com.kwai.filedownloader.x.b
    public final void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.asP != 10) {
                com.kwai.filedownloader.e.d.f(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.asP));
                return;
            }
            a.InterfaceC0625a Cw = this.asO.Cw();
            com.kwai.filedownloader.a Ci = Cw.Ci();
            v Dd = r.CZ().Dd();
            try {
                if (Dd.f(Cw)) {
                    return;
                }
                synchronized (this.asJ) {
                    if (this.asP != 10) {
                        com.kwai.filedownloader.e.d.f(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.asP));
                        return;
                    }
                    c(Constants.GZIP_CAST_TYPE);
                    h.CG().b(Cw);
                    if (com.kwai.filedownloader.e.c.a(Ci.getId(), Ci.getTargetFilePath(), Ci.Cb(), true)) {
                        return;
                    }
                    boolean a2 = n.CR().a(Ci.getUrl(), Ci.getPath(), Ci.BW(), Ci.BU(), Ci.BV(), Ci.Cd(), Ci.Cb(), this.asO.Cv(), Ci.Ch());
                    if (this.asP == -2) {
                        com.kwai.filedownloader.e.d.f(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                        if (a2) {
                            n.CR().bW(getId());
                        }
                    } else if (a2) {
                        Dd.e(Cw);
                    } else if (Dd.f(Cw)) {
                    } else {
                        MessageSnapshot n = n(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                        if (h.CG().a(Cw)) {
                            Dd.e(Cw);
                            h.CG().b(Cw);
                        }
                        h.CG().a(Cw, n);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                h.CG().a(Cw, n(th));
            }
        }
    }
}
