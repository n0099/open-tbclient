package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.dx;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
/* loaded from: classes8.dex */
public class fs extends gd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fn a;

    /* renamed from: a  reason: collision with other field name */
    public fo f386a;

    /* renamed from: a  reason: collision with other field name */
    public Thread f387a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f388a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs(XMPushService xMPushService, fx fxVar) {
        super(xMPushService, fxVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, fxVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((XMPushService) objArr2[0], (fx) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private fl a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            fr frVar = new fr();
            if (z) {
                frVar.a("1");
            }
            byte[] m329a = fj.m329a();
            if (m329a != null) {
                dx.j jVar = new dx.j();
                jVar.a(a.a(m329a));
                frVar.a(jVar.m298a(), (String) null);
            }
            return frVar;
        }
        return (fl) invokeZ.objValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                this.a = new fn(((gd) this).f416a.getInputStream(), this, ((fw) this).f401a);
                this.f386a = new fo(((gd) this).f416a.getOutputStream(), this);
                ft ftVar = new ft(this, "Blob Reader (" + ((fw) this).b + SmallTailInfo.EMOTION_SUFFIX);
                this.f387a = ftVar;
                ftVar.start();
            } catch (Exception e) {
                throw new gh("Error to init reader and writer", e);
            }
        }
    }

    @Override // com.xiaomi.push.gd, com.xiaomi.push.fw
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                h();
                this.f386a.a();
            }
        }
    }

    @Override // com.xiaomi.push.gd
    public synchronized void a(int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, exc) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.b();
                    this.a = null;
                }
                if (this.f386a != null) {
                    try {
                        this.f386a.b();
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                    this.f386a = null;
                }
                this.f388a = null;
                super.a(i, exc);
            }
        }
    }

    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flVar) == null) || flVar == null) {
            return;
        }
        if (flVar.m333a()) {
            com.xiaomi.channel.commonutils.logger.b.m84a("[Slim] RCV blob chid=" + flVar.a() + "; id=" + flVar.e() + "; errCode=" + flVar.b() + "; err=" + flVar.m337c());
        }
        if (flVar.a() == 0) {
            if ("PING".equals(flVar.m330a())) {
                com.xiaomi.channel.commonutils.logger.b.m84a("[Slim] RCV ping id=" + flVar.e());
                g();
            } else if ("CLOSE".equals(flVar.m330a())) {
                c(13, null);
            }
        }
        for (fw.a aVar : ((fw) this).f405a.values()) {
            aVar.a(flVar);
        }
    }

    @Override // com.xiaomi.push.fw
    @Deprecated
    public void a(gn gnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gnVar) == null) {
            b(fl.a(gnVar, (String) null));
        }
    }

    @Override // com.xiaomi.push.fw
    public synchronized void a(bg.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            synchronized (this) {
                fk.a(bVar, c(), this);
            }
        }
    }

    @Override // com.xiaomi.push.fw
    public synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            synchronized (this) {
                fk.a(str, str2, this);
            }
        }
    }

    @Override // com.xiaomi.push.gd
    /* renamed from: a  reason: collision with other method in class */
    public void mo343a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (this.f386a == null) {
                throw new gh("The BlobWriter is null.");
            }
            fl a = a(z);
            com.xiaomi.channel.commonutils.logger.b.m84a("[Slim] SND ping id=" + a.e());
            b(a);
            f();
        }
    }

    @Override // com.xiaomi.push.gd, com.xiaomi.push.fw
    public void a(fl[] flVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, flVarArr) == null) {
            for (fl flVar : flVarArr) {
                b(flVar);
            }
        }
    }

    @Override // com.xiaomi.push.gd, com.xiaomi.push.fw
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.gd, com.xiaomi.push.fw
    public synchronized byte[] a() {
        InterceptResult invokeV;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                if (this.f388a == null && !TextUtils.isEmpty(((fw) this).f402a)) {
                    String m643a = com.xiaomi.push.service.bv.m643a();
                    this.f388a = com.xiaomi.push.service.bp.a(((fw) this).f402a.getBytes(), (((fw) this).f402a.substring(((fw) this).f402a.length() / 2) + m643a.substring(m643a.length() / 2)).getBytes());
                }
                bArr = this.f388a;
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.xiaomi.push.fw
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, flVar) == null) {
            fo foVar = this.f386a;
            if (foVar == null) {
                throw new gh("the writer is null.");
            }
            try {
                int a = foVar.a(flVar);
                ((fw) this).d = SystemClock.elapsedRealtime();
                String f = flVar.f();
                if (!TextUtils.isEmpty(f)) {
                    hb.a(((fw) this).f401a, f, a, false, true, System.currentTimeMillis());
                }
                for (fw.a aVar : ((fw) this).f408b.values()) {
                    aVar.a(flVar);
                }
            } catch (Exception e) {
                throw new gh(e);
            }
        }
    }

    public void b(gn gnVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, gnVar) == null) || gnVar == null) {
            return;
        }
        for (fw.a aVar : ((fw) this).f405a.values()) {
            aVar.a(gnVar);
        }
    }
}
