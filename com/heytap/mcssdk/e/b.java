package com.heytap.mcssdk.e;

import android.app.NotificationManager;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, DataMessage dataMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, dataMessage) == null) {
            if (context == null) {
                d.b("context is null");
                return;
            }
            d.b("Receive revokeMessage  extra : " + dataMessage.getStatisticsExtra() + "notifyId :" + dataMessage.getNotifyID() + "messageId : " + dataMessage.getTaskID());
            ((NotificationManager) context.getSystemService("notification")).cancel(dataMessage.getNotifyID());
            b(context, dataMessage);
        }
    }

    private void b(Context context, DataMessage dataMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, dataMessage) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(dataMessage);
            hashMap.put(dataMessage.getEventId(), arrayList);
            StatisticUtils.statisticEvent(context, hashMap);
        }
    }

    @Override // com.heytap.mcssdk.e.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, context, baseMode, iDataMessageCallBackService) == null) && baseMode != null && baseMode.getType() == 4103) {
            DataMessage dataMessage = (DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                f.b(new Runnable(this, dataMessage, context, iDataMessageCallBackService) { // from class: com.heytap.mcssdk.e.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DataMessage a;
                    public final /* synthetic */ Context b;
                    public final /* synthetic */ IDataMessageCallBackService c;
                    public final /* synthetic */ b d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, dataMessage, context, iDataMessageCallBackService};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.d = this;
                        this.a = dataMessage;
                        this.b = context;
                        this.c = iDataMessageCallBackService;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.a.getMsgCommand() == 1) {
                                this.d.a(this.b, this.a);
                            } else {
                                this.c.processMessage(this.b, this.a);
                            }
                        }
                    }
                });
            }
        }
    }
}
