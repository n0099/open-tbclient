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
import com.baidu.tieba.eea;
import com.baidu.tieba.jda;
import com.baidu.tieba.kda;
import com.baidu.tieba.lda;
import com.baidu.tieba.qda;
import com.baidu.tieba.rda;
import com.baidu.tieba.sda;
import com.baidu.tieba.tea;
import com.baidu.tieba.xea;
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

    public void onMessageReceived(jda jdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jdaVar) == null) {
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
    public void a(eea eeaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, eeaVar) == null) {
            if (eeaVar.f()) {
                jda jdaVar = (jda) eeaVar.d();
                if (jdaVar != null) {
                    Log.i("HonorMessageService", "onMessageReceived. msgId is " + jdaVar.b());
                    onMessageReceived(jdaVar);
                    return;
                }
                Log.i("HonorMessageService", "parse remote data failed.");
                return;
            }
            boolean z = eeaVar.c() instanceof JSONException;
        }
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            try {
                if (TextUtils.equals(intent.getStringExtra(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY), DownMsgType.RECEIVE_TOKEN)) {
                    String stringExtra = intent.getStringExtra("push_token");
                    Context a2 = sda.e.a();
                    qda qdaVar = qda.b;
                    if (!TextUtils.equals(stringExtra, qdaVar.c(a2))) {
                        qdaVar.b(a2, stringExtra);
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
            eea c2 = lda.c(new kda(intent));
            tea teaVar = new tea() { // from class: com.baidu.tieba.ada
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.tea
                public final void a(eea eeaVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eeaVar) == null) {
                        HonorMessageService.this.a(eeaVar);
                    }
                }
            };
            c2.getClass();
            c2.a(new rda(xea.c.a, teaVar));
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
