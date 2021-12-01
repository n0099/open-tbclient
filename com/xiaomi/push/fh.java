package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.du;
import com.xiaomi.push.fl;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes3.dex */
public class fh extends fs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fc a;

    /* renamed from: a  reason: collision with other field name */
    public fd f386a;

    /* renamed from: a  reason: collision with other field name */
    public Thread f387a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f388a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh(XMPushService xMPushService, fm fmVar) {
        super(xMPushService, fmVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, fmVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((XMPushService) objArr2[0], (fm) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private fa a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            fg fgVar = new fg();
            if (z) {
                fgVar.a("1");
            }
            byte[] m421a = gz.m421a();
            if (m421a != null) {
                du.j jVar = new du.j();
                jVar.a(a.a(m421a));
                fgVar.a(jVar.m333a(), (String) null);
            }
            return fgVar;
        }
        return (fa) invokeZ.objValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                this.a = new fc(((fs) this).f416a.getInputStream(), this);
                this.f386a = new fd(((fs) this).f416a.getOutputStream(), this);
                fi fiVar = new fi(this, "Blob Reader (" + ((fl) this).f62885b + SmallTailInfo.EMOTION_SUFFIX);
                this.f387a = fiVar;
                fiVar.start();
            } catch (Exception e2) {
                throw new fw("Error to init reader and writer", e2);
            }
        }
    }

    @Override // com.xiaomi.push.fs, com.xiaomi.push.fl
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                h();
                this.f386a.a();
            }
        }
    }

    @Override // com.xiaomi.push.fs
    public synchronized void a(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, exc) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.b();
                    this.a = null;
                }
                if (this.f386a != null) {
                    try {
                        this.f386a.b();
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                    this.f386a = null;
                }
                this.f388a = null;
                super.a(i2, exc);
            }
        }
    }

    public void a(fa faVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faVar) == null) || faVar == null) {
            return;
        }
        if (faVar.m357a()) {
            com.xiaomi.channel.commonutils.logger.b.m122a("[Slim] RCV blob chid=" + faVar.a() + "; id=" + faVar.e() + "; errCode=" + faVar.b() + "; err=" + faVar.m361c());
        }
        if (faVar.a() == 0) {
            if ("PING".equals(faVar.m354a())) {
                com.xiaomi.channel.commonutils.logger.b.m122a("[Slim] RCV ping id=" + faVar.e());
                g();
            } else if ("CLOSE".equals(faVar.m354a())) {
                c(13, null);
            }
        }
        for (fl.a aVar : ((fl) this).f405a.values()) {
            aVar.a(faVar);
        }
    }

    @Override // com.xiaomi.push.fl
    @Deprecated
    public void a(gc gcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gcVar) == null) {
            b(fa.a(gcVar, (String) null));
        }
    }

    @Override // com.xiaomi.push.fl
    public synchronized void a(av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            synchronized (this) {
                ez.a(bVar, c(), this);
            }
        }
    }

    @Override // com.xiaomi.push.fl
    public synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            synchronized (this) {
                ez.a(str, str2, this);
            }
        }
    }

    @Override // com.xiaomi.push.fs
    /* renamed from: a  reason: collision with other method in class */
    public void mo367a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (this.f386a == null) {
                throw new fw("The BlobWriter is null.");
            }
            fa a = a(z);
            com.xiaomi.channel.commonutils.logger.b.m122a("[Slim] SND ping id=" + a.e());
            b(a);
            f();
        }
    }

    @Override // com.xiaomi.push.fs, com.xiaomi.push.fl
    public void a(fa[] faVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, faVarArr) == null) {
            for (fa faVar : faVarArr) {
                b(faVar);
            }
        }
    }

    @Override // com.xiaomi.push.fs, com.xiaomi.push.fl
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.fs, com.xiaomi.push.fl
    public synchronized byte[] a() {
        InterceptResult invokeV;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                if (this.f388a == null && !TextUtils.isEmpty(((fl) this).f402a)) {
                    String m664a = com.xiaomi.push.service.bi.m664a();
                    this.f388a = com.xiaomi.push.service.be.a(((fl) this).f402a.getBytes(), (((fl) this).f402a.substring(((fl) this).f402a.length() / 2) + m664a.substring(m664a.length() / 2)).getBytes());
                }
                bArr = this.f388a;
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.xiaomi.push.fl
    public void b(fa faVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, faVar) == null) {
            fd fdVar = this.f386a;
            if (fdVar == null) {
                throw new fw("the writer is null.");
            }
            try {
                int a = fdVar.a(faVar);
                ((fl) this).f62887d = System.currentTimeMillis();
                String f2 = faVar.f();
                if (!TextUtils.isEmpty(f2)) {
                    gq.a(((fl) this).f401a, f2, a, false, true, System.currentTimeMillis());
                }
                for (fl.a aVar : ((fl) this).f408b.values()) {
                    aVar.a(faVar);
                }
            } catch (Exception e2) {
                throw new fw(e2);
            }
        }
    }

    public void b(gc gcVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, gcVar) == null) || gcVar == null) {
            return;
        }
        for (fl.a aVar : ((fl) this).f405a.values()) {
            aVar.a(gcVar);
        }
    }
}
