package com.google.ar.core;

import android.os.Bundle;
import c.i.c.a.l;
import c.i.c.a.m;
import c.i.c.a.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public final class x extends com.google.a.b.a.a.a.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f56553b;

    public x(q qVar, AtomicBoolean atomicBoolean) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar, atomicBoolean};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56553b = qVar;
        this.a = atomicBoolean;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) || this.a.getAndSet(true)) {
            return;
        }
        int i2 = bundle.getInt("error.code", -100);
        int i3 = bundle.getInt("install.status", 0);
        if (i3 == 4) {
            this.f56553b.f30978f.a(p.f56551c);
        } else if (i2 != 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("requestInstall = ");
            sb.append(i2);
            sb.append(", launching fullscreen.");
            sb.toString();
            q qVar = this.f56553b;
            l lVar = qVar.f30979g;
            l.n(qVar.f30977e, qVar.f30978f);
        } else if (bundle.containsKey("resolution.intent")) {
            q qVar2 = this.f56553b;
            l lVar2 = qVar2.f30979g;
            l.b(qVar2.f30977e, bundle, qVar2.f30978f);
        } else if (i3 != 10) {
            switch (i3) {
                case 1:
                case 2:
                case 3:
                    this.f56553b.f30978f.a(p.a);
                    return;
                case 4:
                    this.f56553b.f30978f.a(p.f56551c);
                    return;
                case 5:
                    this.f56553b.f30978f.b(new FatalException("Unexpected FAILED install status without error."));
                    return;
                case 6:
                    this.f56553b.f30978f.a(p.f56550b);
                    return;
                default:
                    m mVar = this.f56553b.f30978f;
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Unexpected install status: ");
                    sb2.append(i3);
                    mVar.b(new FatalException(sb2.toString()));
                    return;
            }
        } else {
            this.f56553b.f30978f.b(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
        }
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
        }
    }
}
