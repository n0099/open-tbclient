package com.kwai.filedownloader;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.d;
import com.kwai.filedownloader.x;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class c implements com.kwai.filedownloader.a, a.InterfaceC0645a, d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object asA;
    public int asB;
    public boolean asC;
    public boolean asD;
    public int asE;
    public int asF;
    public boolean asG;
    public volatile int asH;
    public boolean asI;
    public final Object asJ;
    public final Object asK;
    public volatile boolean asL;
    public final x asr;
    public final x.a ass;
    public int ast;
    public ArrayList<Object> asu;
    public String asv;
    public String asw;
    public boolean asx;
    public com.kwai.filedownloader.c.b asy;
    public i asz;
    public final String mUrl;

    /* loaded from: classes8.dex */
    public static final class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c asM;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.asM = cVar;
            c.a(cVar, true);
        }

        public /* synthetic */ a(c cVar, byte b) {
            this(cVar);
        }

        @Override // com.kwai.filedownloader.a.b
        public final int Cq() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int id = this.asM.getId();
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(this, "add the task[%d] to the queue", Integer.valueOf(id));
                }
                h.CG().c(this.asM);
                return id;
            }
            return invokeV.intValue;
        }
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.asB = 0;
        this.asC = false;
        this.asD = false;
        this.asE = 100;
        this.asF = 10;
        this.asG = false;
        this.asH = 0;
        this.asI = false;
        this.asK = new Object();
        this.asL = false;
        this.mUrl = str;
        Object obj = new Object();
        this.asJ = obj;
        d dVar = new d(this, obj);
        this.asr = dVar;
        this.ass = dVar;
    }

    private boolean Cs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.asr.Ca() != 0 : invokeV.booleanValue;
    }

    private int Ct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (!Cs()) {
                if (!BT()) {
                    Cl();
                }
                this.asr.Cz();
                return getId();
            } else if (isRunning()) {
                throw new IllegalStateException(com.kwai.filedownloader.e.f.h("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            } else {
                throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.asr.toString());
            }
        }
        return invokeV.intValue;
    }

    private void Cu() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.asy == null) {
            synchronized (this.asK) {
                if (this.asy == null) {
                    this.asy = new com.kwai.filedownloader.c.b();
                }
            }
        }
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.asI = true;
        return true;
    }

    @Override // com.kwai.filedownloader.a
    public final a.b BR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this, (byte) 0) : (a.b) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean BS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (isRunning()) {
                com.kwai.filedownloader.e.d.f(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
                return false;
            }
            this.asH = 0;
            this.asI = false;
            this.asL = false;
            this.asr.reset();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean BT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.asH != 0 : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int BU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.asE : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int BV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.asF : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean BW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.asx : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final i BX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.asz : (i) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final long BY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.asr.CA() : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.a
    public final long BZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.asr.getTotalBytes() : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.a
    public final byte Ca() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.asr.Ca() : invokeV.byteValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Cb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.asG : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final Throwable Cc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.asr.Cc() : (Throwable) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int Cd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.asB : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int Ce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.asr.Ce() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Cf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.asC : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Cg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.asr.Cg() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Ch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.asD : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final com.kwai.filedownloader.a Ci() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (com.kwai.filedownloader.a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final x.a Cj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.ass : (x.a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final int Ck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.asH : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final void Cl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.asH = BX() != null ? BX().hashCode() : hashCode();
        }
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final boolean Cm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.asL : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final void Cn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.asL = true;
        }
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final void Co() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Ct();
        }
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final boolean Cp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ArrayList<Object> arrayList = this.asu;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.d.a
    public final com.kwai.filedownloader.c.b Cv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.asy : (com.kwai.filedownloader.c.b) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.d.a
    public final a.InterfaceC0645a Cw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this : (a.InterfaceC0645a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.d.a
    public final ArrayList<Object> Cx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.asu : (ArrayList) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a Y(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            Cu();
            this.asy.aa(str, str2);
            return this;
        }
        return (com.kwai.filedownloader.a) invokeLL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a a(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, iVar)) == null) {
            this.asz = iVar;
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "setListener %s", iVar);
            }
            return this;
        }
        return (com.kwai.filedownloader.a) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bA(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            this.asD = z;
            return this;
        }
        return (com.kwai.filedownloader.a) invokeZ.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bQ(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            this.asB = 3;
            return this;
        }
        return (com.kwai.filedownloader.a) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final boolean bR(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) ? getId() == i : invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a by(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            this.asG = true;
            return this;
        }
        return (com.kwai.filedownloader.a) invokeZ.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bz(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
            this.asC = true;
            return this;
        }
        return (com.kwai.filedownloader.a) invokeZ.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a c(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048611, this, str, z)) == null) {
            this.asv = str;
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "setPath %s", str);
            }
            this.asx = z;
            this.asw = z ? null : new File(str).getName();
            return this;
        }
        return (com.kwai.filedownloader.a) invokeLZ.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean cancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? pause() : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a en(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) ? c(str, false) : (com.kwai.filedownloader.a) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a eo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (this.asy == null) {
                synchronized (this.asK) {
                    if (this.asy == null) {
                        return this;
                    }
                }
            }
            this.asy.ey(str);
            return this;
        }
        return (com.kwai.filedownloader.a) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.d.a
    public final void ep(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.asw = str;
        }
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final void free() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.asr.free();
            if (h.CG().a(this)) {
                this.asL = false;
            }
        }
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, obj)) == null) {
            this.asA = obj;
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "setTag %s", obj);
            }
            return this;
        }
        return (com.kwai.filedownloader.a) invokeL.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final String getFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.asw : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            int i = this.ast;
            if (i != 0) {
                return i;
            }
            if (TextUtils.isEmpty(this.asv) || TextUtils.isEmpty(this.mUrl)) {
                return 0;
            }
            int k = com.kwai.filedownloader.e.f.k(this.mUrl, this.asv, this.asx);
            this.ast = k;
            return k;
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public final String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.asv : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.asr.CA() > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) this.asr.CA();
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int getSmallFileTotalBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.asr.getTotalBytes() > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) this.asr.getTotalBytes();
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.asr.getSpeed() : invokeV.intValue;
    }

    @Override // com.kwai.filedownloader.a
    public final long getStatusUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.asr.getStatusUpdateTime() : invokeV.longValue;
    }

    @Override // com.kwai.filedownloader.a
    public final Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.asA : invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final String getTargetFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? com.kwai.filedownloader.e.f.a(getPath(), BW(), getFilename()) : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a
    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0645a
    public final boolean isOver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? com.kwai.filedownloader.c.d.cy(Ca()) : invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (r.CZ().Dd().d(this)) {
                return true;
            }
            return com.kwai.filedownloader.c.d.cz(Ca());
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean pause() {
        InterceptResult invokeV;
        boolean pause;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            synchronized (this.asJ) {
                pause = this.asr.pause();
            }
            return pause;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.filedownloader.a
    public final int start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.asI) {
                throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
            }
            return Ct();
        }
        return invokeV.intValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? com.kwai.filedownloader.e.f.h("%d@%s", Integer.valueOf(getId()), super.toString()) : (String) invokeV.objValue;
    }
}
