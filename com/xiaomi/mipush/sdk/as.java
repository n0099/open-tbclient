package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class as implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ao a;

    public as(ao aoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aoVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            synchronized (this.a) {
                this.a.f779a = new Messenger(iBinder);
                this.a.c = false;
                list = this.a.f782a;
                for (Message message : list) {
                    try {
                        messenger = this.a.f779a;
                        messenger.send(message);
                    } catch (RemoteException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                list2 = this.a.f782a;
                list2.clear();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            this.a.f779a = null;
            this.a.c = false;
        }
    }
}
