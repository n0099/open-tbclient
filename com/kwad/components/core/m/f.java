package com.kwad.components.core.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.bg;
/* loaded from: classes8.dex */
public final class f implements bg.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a IV;
    public BroadcastReceiver IW;
    public Handler mHandler;
    public String targetPackage;

    /* loaded from: classes8.dex */
    public interface a {
        void gW();
    }

    public f(String str) {
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
        this.IW = new BroadcastReceiver(this) { // from class: com.kwad.components.core.m.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f IX;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.IX = this;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) {
                    String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    Message obtainMessage = this.IX.mHandler.obtainMessage(242);
                    obtainMessage.obj = schemeSpecificPart;
                    obtainMessage.sendToTarget();
                }
            }
        };
        this.targetPackage = str;
        this.mHandler = new bg(this);
    }

    public final void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) || context == null) {
            return;
        }
        this.IV = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        try {
            context.registerReceiver(this.IW, intentFilter);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        Object obj;
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 242 && (obj = message.obj) != null && obj.equals(this.targetPackage) && (aVar = this.IV) != null) {
            aVar.gW();
        }
    }

    public final void au(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            if (context != null) {
                try {
                    context.unregisterReceiver(this.IW);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }
            this.IV = null;
        }
    }

    public final void aw(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.targetPackage = str;
        }
    }
}
