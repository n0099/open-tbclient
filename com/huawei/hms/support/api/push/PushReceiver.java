package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.f;
import com.huawei.hms.push.h;
import com.huawei.hms.push.s;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.v;
import com.huawei.hms.push.w;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class PushReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public Intent b;

        public a(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = intent;
        }

        public /* synthetic */ a(Context context, Intent intent, f fVar) {
            this(context, intent);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                intent.setPackage(this.b.getPackage());
                try {
                    JSONObject b = PushReceiver.b(this.b);
                    String string = JsonUtil.getString(b, "moduleName", "");
                    int i = JsonUtil.getInt(b, "msgType", 0);
                    int i2 = JsonUtil.getInt(b, "status", 0);
                    if (ErrorEnum.SUCCESS.getInternalCode() != i2) {
                        i2 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                    }
                    Bundle bundle = new Bundle();
                    if ("Push".equals(string) && i == 1) {
                        bundle.putString("message_type", AccountConstants.LOGIN_TYPE_NATIVE_SRC_DELIVERY);
                        bundle.putString("message_id", JsonUtil.getString(b, "msgId", ""));
                        bundle.putInt("error", i2);
                        bundle.putString(CommonCode.MapKey.TRANSACTION_ID, JsonUtil.getString(b, "transactionId", ""));
                    } else {
                        if (this.b.getExtras() != null) {
                            bundle.putAll(this.b.getExtras());
                        }
                        bundle.putString("message_type", "received_message");
                        bundle.putString("message_id", this.b.getStringExtra("msgIdStr"));
                        bundle.putByteArray(RemoteMessageConst.MSGBODY, this.b.getByteArrayExtra("msg_data"));
                        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, w.a(this.b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN)));
                        bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
                        bundle.putString("message_proxy_type", this.b.getStringExtra("message_proxy_type"));
                    }
                    if (new h().a(this.a, bundle, intent)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("receive ");
                        sb.append(this.b.getAction());
                        sb.append(" and start service success");
                        HMSLog.i("PushReceiver", sb.toString());
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("receive ");
                    sb2.append(this.b.getAction());
                    sb2.append(" and start service failed");
                    HMSLog.e("PushReceiver", sb2.toString());
                } catch (RuntimeException unused) {
                    HMSLog.e("PushReceiver", "handle push message occur exception.");
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public Intent b;

        public b(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = intent;
        }

        public /* synthetic */ b(Context context, Intent intent, f fVar) {
            this(context, intent);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    byte[] byteArrayExtra = this.b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                    if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("receive a push token: ");
                        sb.append(this.a.getPackageName());
                        HMSLog.i("PushReceiver", sb.toString());
                        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                        intent.setPackage(this.b.getPackage());
                        Bundle bundle = new Bundle();
                        bundle.putString("message_type", "new_token");
                        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, w.a(byteArrayExtra));
                        bundle.putString(CommonCode.MapKey.TRANSACTION_ID, this.b.getStringExtra(CommonCode.MapKey.TRANSACTION_ID));
                        bundle.putString("subjectId", this.b.getStringExtra("subjectId"));
                        bundle.putInt("error", this.b.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
                        bundle.putString("belongId", this.b.getStringExtra("belongId"));
                        if (!new h().a(this.a, bundle, intent)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("receive ");
                            sb2.append(this.b.getAction());
                            sb2.append(" and start service failed");
                            HMSLog.e("PushReceiver", sb2.toString());
                            return;
                        }
                        return;
                    }
                    HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
                } catch (RejectedExecutionException unused) {
                    HMSLog.e("PushReceiver", "execute task error");
                } catch (Exception unused2) {
                    HMSLog.e("PushReceiver", "handle push token error");
                }
            }
        }
    }

    public PushReceiver() {
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

    public static JSONObject b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            if (jSONObject != null) {
                return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject != null) {
                return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            try {
                return new JSONObject(w.a(bArr));
            } catch (JSONException unused) {
                HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject b(Intent intent) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, intent)) == null) {
            JSONObject a2 = a(intent.getByteArrayExtra("msg_data"));
            JSONObject a3 = a(a2);
            String string = JsonUtil.getString(a3, "data", null);
            if (s.a(a3, b(a3), string)) {
                return a2;
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            try {
                if (intent.hasExtra("msg_data")) {
                    v.a().execute(new a(context, intent, null));
                } else {
                    HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
                }
            } catch (RuntimeException unused) {
                HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
            } catch (Exception unused2) {
                HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
            }
        }
    }

    public final void b(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent) == null) {
            try {
                if (intent.hasExtra(RemoteMessageConst.DEVICE_TOKEN)) {
                    v.a().execute(new b(context, intent, null));
                } else {
                    HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
                }
            } catch (RuntimeException unused) {
                HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
            } catch (Exception unused2) {
                HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) && intent != null && context != null) {
            HMSLog.i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                    b(context, intent);
                } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                    a(context, intent);
                } else {
                    HMSLog.i("PushReceiver", "message can't be recognised.");
                }
            } catch (Exception unused) {
                HMSLog.e("PushReceiver", "intent has some error");
            }
        }
    }
}
