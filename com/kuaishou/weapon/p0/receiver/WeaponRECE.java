package com.kuaishou.weapon.p0.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.C0303;
import com.kuaishou.weapon.p0.C0358;
import com.kuaishou.weapon.p0.C0360;
import com.kuaishou.weapon.p0.C0362;
import com.kuaishou.weapon.p0.C0364;
import com.kuaishou.weapon.p0.C0366;
import com.kuaishou.weapon.p0.C0368;
import com.kuaishou.weapon.p0.C0370;
import com.kuaishou.weapon.p0.C0372;
/* loaded from: classes5.dex */
public class WeaponRECE extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.weapon.p0.receiver.WeaponRECE$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0290 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ Intent f5;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ Context f6;

        /* renamed from: ʽ  reason: contains not printable characters */
        public final /* synthetic */ WeaponRECE f7;

        public RunnableC0290(WeaponRECE weaponRECE, Intent intent, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weaponRECE, intent, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7 = weaponRECE;
            this.f5 = intent;
            this.f6 = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String action = this.f5.getAction();
                if (!TextUtils.isEmpty(action) && action.equals(C0303.f38)) {
                    C0366.m378(this.f6).m379(0, 0);
                    C0370.m384(this.f6).m385(0);
                    C0362.m372(this.f6).m373(0);
                    C0364.m375(this.f6).m376();
                    C0372.m387(this.f6).m388();
                    C0360.m369(this.f6).m370(0);
                    C0368.m381(this.f6).m382(0);
                }
            }
        }
    }

    public WeaponRECE() {
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            try {
                C0358.m366().m367(new RunnableC0290(this, intent, context));
            } catch (Throwable unused) {
            }
        }
    }
}
