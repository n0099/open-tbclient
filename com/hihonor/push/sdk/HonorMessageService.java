package com.hihonor.push.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.tieba.eua;
import com.baidu.tieba.jta;
import com.baidu.tieba.kta;
import com.baidu.tieba.lta;
import com.baidu.tieba.qta;
import com.baidu.tieba.rta;
import com.baidu.tieba.sta;
import com.baidu.tieba.tua;
import com.baidu.tieba.xua;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.sdk.HonorMessageService;
import com.hihonor.push.sdk.common.data.DownMsgType;
import org.json.JSONException;
/* loaded from: classes8.dex */
public abstract class HonorMessageService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int c = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public final Messenger b;

    public void onMessageReceived(jta jtaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jtaVar) == null) {
        }
    }

    public void onNewToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HonorMessageService a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HonorMessageService honorMessageService, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {honorMessageService, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = honorMessageService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Log.i("HonorMessageService", "handle message for broadcast.");
                Bundle data = message.getData();
                if (data != null) {
                    Intent intent = new Intent();
                    intent.putExtras(data);
                    HonorMessageService honorMessageService = this.a;
                    int i = HonorMessageService.c;
                    honorMessageService.a(intent);
                }
            }
        }
    }

    public HonorMessageService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this, Looper.getMainLooper());
        this.a = aVar;
        this.b = new Messenger(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(eua euaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, euaVar) == null) {
            if (euaVar.f()) {
                jta jtaVar = (jta) euaVar.d();
                if (jtaVar != null) {
                    Log.i("HonorMessageService", "onMessageReceived. msgId is " + jtaVar.b());
                    onMessageReceived(jtaVar);
                    return;
                }
                Log.i("HonorMessageService", "parse remote data failed.");
                return;
            }
            boolean z = euaVar.c() instanceof JSONException;
        }
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            try {
                if (TextUtils.equals(intent.getStringExtra(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY), DownMsgType.RECEIVE_TOKEN)) {
                    String stringExtra = intent.getStringExtra("push_token");
                    Context a2 = sta.e.a();
                    qta qtaVar = qta.b;
                    if (!TextUtils.equals(stringExtra, qtaVar.c(a2))) {
                        qtaVar.b(a2, stringExtra);
                    }
                    Log.i("HonorMessageService", "onNewToken");
                    onNewToken(stringExtra);
                } else {
                    b(intent);
                }
                Log.i("HonorMessageService", "dispatch message end.");
            } catch (Exception e) {
                String str = "dispatch message error. " + e.getMessage();
            }
        }
    }

    public final void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            Log.i("HonorMessageService", "parse remote data start.");
            eua c2 = lta.c(new kta(intent));
            tua tuaVar = new tua() { // from class: com.baidu.tieba.ata
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.tua
                public final void a(eua euaVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, euaVar) == null) {
                        HonorMessageService.this.a(euaVar);
                    }
                }
            };
            c2.getClass();
            c2.a(new rta(xua.c.a, tuaVar));
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            return this.b.getBinder();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, intent, i, i2)) == null) {
            super.onStartCommand(intent, i, i2);
            Log.i("HonorMessageService", "handle message for service.");
            a(intent);
            return 2;
        }
        return invokeLII.intValue;
    }
}
