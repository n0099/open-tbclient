package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.t;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class HmsMessageService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";
    public transient /* synthetic */ FieldHolder $fh;
    public final Messenger a;

    public void onDeletedMessages() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void onMessageDelivered(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, exc) == null) {
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, remoteMessage) == null) {
        }
    }

    public void onMessageSent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    public void onNewToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    public void onNewToken(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, bundle) == null) {
        }
    }

    public void onSendError(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, exc) == null) {
        }
    }

    public void onTokenError(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, exc) == null) {
        }
    }

    public void onTokenError(Exception exc, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, exc, bundle) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements t.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HmsMessageService a;

        public a(HmsMessageService hmsMessageService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hmsMessageService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hmsMessageService;
        }

        public /* synthetic */ a(HmsMessageService hmsMessageService, com.huawei.hms.push.a aVar) {
            this(hmsMessageService);
        }

        @Override // com.huawei.hms.push.t.a
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (message == null) {
                    HMSLog.e("HmsMessageService", "receive message is null");
                    return;
                }
                HMSLog.i("HmsMessageService", "handle message start...");
                Bundle data = Message.obtain(message).getData();
                if (data != null) {
                    Intent intent = new Intent();
                    intent.putExtras(data);
                    intent.putExtra(RemoteMessageConst.INPUT_TYPE, data.getInt(RemoteMessageConst.INPUT_TYPE, -1));
                    this.a.handleIntentMessage(intent);
                }
            }
        }
    }

    public HmsMessageService() {
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
        this.a = new Messenger(new t(new a(this, null)));
    }

    public final Bundle a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("message_id", intent.getStringExtra("message_id"));
            bundle.putByteArray(RemoteMessageConst.MSGBODY, intent.getByteArrayExtra(RemoteMessageConst.MSGBODY));
            bundle.putString(RemoteMessageConst.DEVICE_TOKEN, intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN));
            if (intent.getIntExtra(RemoteMessageConst.INPUT_TYPE, -1) == 1) {
                bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final synchronized void a(Intent intent, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, bundle, str) == null) {
            synchronized (this) {
                String stringExtra = intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN);
                a(stringExtra, str);
                Context applicationContext = getApplicationContext();
                boolean z = !TextUtils.isEmpty(BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
                if (bundle.isEmpty() && z) {
                    HMSLog.i("HmsMessageService", "onNewToken to host app.");
                    onNewToken(stringExtra);
                    BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
                }
                if (TextUtils.isEmpty(str)) {
                    String[] subjectIds = BaseUtils.getSubjectIds(applicationContext);
                    if (subjectIds != null && subjectIds.length != 0) {
                        for (int i = 0; i < subjectIds.length; i++) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(SUBJECT_ID, subjectIds[i]);
                            HMSLog.i("HmsMessageService", "onNewToken to sub app, subjectId:" + subjectIds[i]);
                            onNewToken(stringExtra, bundle2);
                            a(stringExtra, subjectIds[i]);
                        }
                        BaseUtils.clearSubjectIds(applicationContext);
                    }
                    HMSLog.i("HmsMessageService", "onNewToken to host app with bundle.");
                    bundle.putString("belongId", intent.getStringExtra("belongId"));
                    onNewToken(stringExtra, bundle);
                    return;
                }
                HMSLog.i("HmsMessageService", "onNewToken to sub app, subjectId:" + str);
                onNewToken(stringExtra, bundle);
            }
        }
    }

    public final synchronized void a(Intent intent, Bundle bundle, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, intent, bundle, str, i) == null) {
            synchronized (this) {
                Context applicationContext = getApplicationContext();
                boolean z = !TextUtils.isEmpty(BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
                if (bundle.isEmpty() && z) {
                    HMSLog.i("HmsMessageService", "onTokenError to host app.");
                    onTokenError(new BaseException(i));
                    BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
                }
                if (TextUtils.isEmpty(str)) {
                    String[] subjectIds = BaseUtils.getSubjectIds(applicationContext);
                    if (subjectIds != null && subjectIds.length != 0) {
                        for (int i2 = 0; i2 < subjectIds.length; i2++) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(SUBJECT_ID, subjectIds[i2]);
                            HMSLog.i("HmsMessageService", "onTokenError to sub app, subjectId:" + subjectIds[i2]);
                            onTokenError(new BaseException(i), bundle2);
                        }
                        BaseUtils.clearSubjectIds(applicationContext);
                    }
                    HMSLog.i("HmsMessageService", "onTokenError to host app with bundle.");
                    onTokenError(new BaseException(i), bundle);
                    return;
                }
                HMSLog.i("HmsMessageService", "onTokenError to sub app, subjectId:" + str);
                onTokenError(new BaseException(i), bundle);
            }
        }
    }

    public final void a(Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, intent, str) == null) {
            int intExtra = intent.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode());
            a(PushNaming.GETTOKEN_ASYNC_RSP, str, intExtra);
            String stringExtra = intent.getStringExtra("subjectId");
            String stringExtra2 = intent.getStringExtra("message_proxy_type");
            HMSLog.i("HmsMessageService", "doOnNewToken:transactionId = " + str + " , internalCode = " + intExtra + ",subjectId:" + stringExtra + ",proxyType:" + stringExtra2);
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(stringExtra)) {
                bundle.putString(SUBJECT_ID, stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra2)) {
                bundle.putString(PROXY_TYPE, stringExtra2);
            }
            if (intExtra == ErrorEnum.SUCCESS.getInternalCode()) {
                HMSLog.i("HmsMessageService", "Apply token OnNewToken, subId: " + stringExtra);
                a(intent, bundle, stringExtra);
                return;
            }
            HMSLog.i("HmsMessageService", "Apply token failed, subId: " + stringExtra);
            a(intent, bundle, stringExtra, intExtra);
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Context applicationContext = getApplicationContext();
        if (!str.equals(BaseUtils.getLocalToken(applicationContext, str2))) {
            HMSLog.i("HmsMessageService", "receive a token, refresh the local token");
            BaseUtils.saveToken(applicationContext, str2, str);
            return;
        }
        BaseUtils.reportAaidToken(applicationContext, str);
    }

    public final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            HMSLog.i("HmsMessageService", "onMessageSent, message id:" + str2 + ", transactionId: " + str);
            a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, ErrorEnum.SUCCESS.getInternalCode());
            onMessageSent(str2);
        }
    }

    public final void a(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, str, str2, i) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = StringUtil.NULL_STRING;
            }
            PushBiUtil.reportExit(getApplicationContext(), str, str2, i);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048596, this, intent, i, i2)) == null) {
            HMSLog.i("HmsMessageService", "start to command , startId = " + i2);
            handleIntentMessage(intent);
            return 2;
        }
        return invokeLII.intValue;
    }

    public final void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            HMSLog.i("HmsMessageService", "parse batch response.");
            String stringExtra = intent.getStringExtra("batchMsgbody");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(stringExtra);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("transactionId");
                    String optString2 = jSONObject.optString("msgId");
                    int optInt = jSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
                    if (ErrorEnum.SUCCESS.getInternalCode() == optInt) {
                        b(optString, optString2);
                    } else {
                        b(optString, optString2, optInt);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("HmsMessageService", "parse batch response failed.");
            }
        }
    }

    public final void b(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i) == null) {
            HMSLog.i("HmsMessageService", "onSendError, message id:" + str2 + " error:" + i + ", transactionId: " + str);
            a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, i);
            onSendError(str2, new SendException(i));
        }
    }

    public void doMsgReceived(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            onMessageReceived(new RemoteMessage(a(intent)));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, intent)) == null) {
            HMSLog.i("HmsMessageService", "start to bind");
            return this.a.getBinder();
        }
        return (IBinder) invokeL.objValue;
    }

    public void handleIntentMessage(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            if (intent == null) {
                HMSLog.e("HmsMessageService", "receive message is null");
                return;
            }
            try {
                String stringExtra = intent.getStringExtra("message_id");
                String stringExtra2 = intent.getStringExtra("message_type");
                String stringExtra3 = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
                if ("new_token".equals(stringExtra2)) {
                    HMSLog.i("HmsMessageService", "onNewToken");
                    a(intent, stringExtra3);
                } else if ("received_message".equals(stringExtra2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onMessageReceived, message id:");
                    sb.append(stringExtra);
                    HMSLog.i("HmsMessageService", sb.toString());
                    a(PushNaming.RECEIVE_MSG_RSP, stringExtra, ErrorEnum.SUCCESS.getInternalCode());
                    doMsgReceived(intent);
                } else if ("sent_message".equals(stringExtra2)) {
                    b(stringExtra3, stringExtra);
                } else if ("send_error".equals(stringExtra2)) {
                    b(stringExtra3, stringExtra, intent.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
                } else if (AccountConstants.LOGIN_TYPE_NATIVE_SRC_DELIVERY.equals(stringExtra2)) {
                    int intExtra = intent.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onMessageDelivery, message id:");
                    sb2.append(stringExtra);
                    sb2.append(", status:");
                    sb2.append(intExtra);
                    sb2.append(", transactionId: ");
                    sb2.append(stringExtra3);
                    HMSLog.i("HmsMessageService", sb2.toString());
                    a(PushNaming.UPSEND_RECEIPT, stringExtra3, intExtra);
                    onMessageDelivered(stringExtra, new SendException(intExtra));
                } else if ("server_deleted_message".equals(stringExtra2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("delete message, message id:");
                    sb3.append(stringExtra);
                    HMSLog.i("HmsMessageService", sb3.toString());
                    onDeletedMessages();
                } else if ("batchSent".equals(stringExtra2)) {
                    b(intent);
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Receive unknown message: ");
                    sb4.append(stringExtra2);
                    HMSLog.e("HmsMessageService", sb4.toString());
                }
            } catch (RuntimeException e) {
                HMSLog.e("HmsMessageService", "handle intent RuntimeException: " + e.getMessage());
            } catch (Exception e2) {
                HMSLog.e("HmsMessageService", "handle intent exception: " + e2.getMessage());
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            HMSLog.i("HmsMessageService", "start to destroy");
            super.onDestroy();
        }
    }
}
