package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.constant.c;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
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

    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i, Intent intent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i, intent)) == null) {
            if (4103 == i || 4098 == i || 4108 == i) {
                BaseMode a = a(intent, i);
                com.heytap.mcssdk.f.a.a(context, c.a.b, (DataMessage) a);
                return a;
            }
            return null;
        }
        return (BaseMode) invokeLIL.objValue;
    }

    @Override // com.heytap.mcssdk.d.c
    public BaseMode a(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i)) == null) {
            try {
                DataMessage dataMessage = new DataMessage();
                dataMessage.setMessageID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("messageID")));
                dataMessage.setTaskID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("taskID")));
                dataMessage.setGlobalId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("globalID")));
                dataMessage.setAppPackage(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("appPackage")));
                dataMessage.setTitle(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("title")));
                dataMessage.setContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
                dataMessage.setDescription(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("description")));
                String d = com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.j));
                int i2 = 0;
                dataMessage.setNotifyID(TextUtils.isEmpty(d) ? 0 : Integer.parseInt(d));
                dataMessage.setMiniProgramPkg(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.w)));
                dataMessage.setMessageType(i);
                dataMessage.setEventId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("eventId")));
                dataMessage.setStatisticsExtra(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("statistics_extra")));
                String d2 = com.heytap.mcssdk.utils.b.d(intent.getStringExtra("data_extra"));
                dataMessage.setDataExtra(d2);
                String a = a(d2);
                if (!TextUtils.isEmpty(a)) {
                    i2 = Integer.parseInt(a);
                }
                dataMessage.setMsgCommand(i2);
                dataMessage.setBalanceTime(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.n)));
                dataMessage.setStartDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.s)));
                dataMessage.setEndDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.t)));
                dataMessage.setTimeRanges(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.o)));
                dataMessage.setRule(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("rule")));
                dataMessage.setForcedDelivery(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.q)));
                dataMessage.setDistinctContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.r)));
                dataMessage.setAppId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.u)));
                return dataMessage;
            } catch (Exception e) {
                com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage());
                return null;
            }
        }
        return (BaseMode) invokeLI.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return new JSONObject(str).optString(com.heytap.mcssdk.constant.b.v);
            } catch (JSONException e) {
                com.heytap.mcssdk.utils.d.b(e.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
