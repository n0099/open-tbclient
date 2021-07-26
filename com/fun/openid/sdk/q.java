package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q extends ContentObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f32982a;

    /* renamed from: b  reason: collision with root package name */
    public int f32983b;

    /* renamed from: c  reason: collision with root package name */
    public p f32984c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i2, String str) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVar, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32984c = pVar;
        this.f32983b = i2;
        this.f32982a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            p pVar = this.f32984c;
            if (pVar != null) {
                pVar.a(this.f32983b, this.f32982a);
            } else {
                Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
            }
        }
    }
}
