package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.hcc;
import com.baidu.tieba.icc;
import com.baidu.tieba.kcc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class HmsMessaging {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";
    public static final Pattern a;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public HuaweiApi<Api.ApiOptions.NoOptions> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1062365185, "Lcom/huawei/hms/push/HmsMessaging;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1062365185, "Lcom/huawei/hms/push/HmsMessaging;");
                return;
            }
        }
        a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    }

    public boolean isAutoInitEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return AutoInitHelper.isAutoInitEnabled(this.b);
        }
        return invokeV.booleanValue;
    }

    public HmsMessaging(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(context);
        this.b = context;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        InterceptResult invokeL;
        HmsMessaging hmsMessaging;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (HmsMessaging.class) {
                hmsMessaging = new HmsMessaging(context);
            }
            return hmsMessaging;
        }
        return (HmsMessaging) invokeL.objValue;
    }

    public void send(RemoteMessage remoteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, remoteMessage) == null) {
            if (ProxyCenter.getProxy() == null) {
                HMSLog.i("HmsMessaging", "send upstream message");
                a(remoteMessage);
                return;
            }
            HMSLog.e("HmsMessaging", "Operation(send) unsupported");
            throw new UnsupportedOperationException("Operation(send) unsupported");
        }
    }

    public void setAutoInitEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            AutoInitHelper.setAutoInitEnabled(this.b, z);
        }
    }

    public hcc<Void> subscribe(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            HMSLog.i("HmsMessaging", "invoke subscribe");
            return a(str, "Sub");
        }
        return (hcc) invokeL.objValue;
    }

    public hcc<Void> unsubscribe(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            HMSLog.i("HmsMessaging", "invoke unsubscribe");
            return a(str, "UnSub");
        }
        return (hcc) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r6v16. Raw type applied. Possible types: com.baidu.tieba.hcc<TResult>, com.baidu.tieba.hcc<java.lang.Void> */
    /* JADX DEBUG: Type inference failed for r6v18. Raw type applied. Possible types: com.baidu.tieba.hcc<TResult>, com.baidu.tieba.hcc<java.lang.Void> */
    public final hcc<Void> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String reportEntry = PushBiUtil.reportEntry(this.b, PushNaming.SUBSCRIBE);
            if (str != null && a.matcher(str).matches()) {
                if (ProxyCenter.getProxy() != null) {
                    HMSLog.i("HmsMessaging", "use proxy subscribe.");
                    if (TextUtils.equals(str2, "Sub")) {
                        return ProxyCenter.getProxy().subscribe(this.b, str, reportEntry);
                    }
                    return ProxyCenter.getProxy().unsubscribe(this.b, str, reportEntry);
                }
                try {
                    ErrorEnum a2 = d.a(this.b);
                    if (a2 == ErrorEnum.SUCCESS) {
                        if (NetWorkUtil.getNetworkType(this.b) != 0) {
                            SubscribeReq subscribeReq = new SubscribeReq(this.b, str2, str);
                            subscribeReq.setToken(BaseUtils.getLocalToken(this.b, null));
                            if (s.b()) {
                                return this.c.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                            }
                            return this.c.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                        }
                        HMSLog.e("HmsMessaging", "no network");
                        throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
                    }
                    throw a2.toApiException();
                } catch (ApiException e) {
                    icc iccVar = new icc();
                    iccVar.c(e);
                    PushBiUtil.reportExit(this.b, PushNaming.SUBSCRIBE, reportEntry, e.getStatusCode());
                    return iccVar.b();
                } catch (Exception unused) {
                    icc iccVar2 = new icc();
                    iccVar2.c(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                    PushBiUtil.reportExit(this.b, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
                    return iccVar2.b();
                }
            }
            PushBiUtil.reportExit(this.b, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        }
        return (hcc) invokeLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r10v2. Raw type applied. Possible types: com.baidu.tieba.hcc<TResult>, com.baidu.tieba.hcc<java.lang.Void> */
    public final hcc<Void> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            String reportEntry = PushBiUtil.reportEntry(this.b, PushNaming.SET_NOTIFY_FLAG);
            if (s.d(this.b) && !s.b()) {
                if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
                    HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
                    icc iccVar = new icc();
                    iccVar.c(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
                    PushBiUtil.reportExit(this.b, PushNaming.SET_NOTIFY_FLAG, reportEntry, ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED);
                    return iccVar.b();
                } else if (s.b(this.b) < 90101310) {
                    HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
                    Context context = this.b;
                    Intent putExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(context, this.b.getPackageName() + "#" + z));
                    putExtra.setPackage("android");
                    return kcc.b(new IntentCallable(this.b, putExtra, reportEntry));
                } else {
                    HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
                    new PushPreferences(this.b, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
                    Uri parse = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + this.b.getPackageName() + ".huawei.push.provider/push_notify_flag" + ActivityChooserModel.HISTORY_FILE_EXTENSION);
                    Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
                    intent.putExtra("type", "enalbeFlag");
                    intent.putExtra("pkgName", this.b.getPackageName());
                    intent.putExtra("url", parse);
                    intent.setPackage("android");
                    return kcc.b(new IntentCallable(this.b, intent, reportEntry));
                }
            }
            HMSLog.i("HmsMessaging", "turn on/off with AIDL");
            EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
            enableNotifyReq.setPackageName(this.b.getPackageName());
            enableNotifyReq.setEnable(z);
            return this.c.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), reportEntry));
        }
        return (hcc) invokeZ.objValue;
    }

    public final void a(RemoteMessage remoteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, remoteMessage) == null) {
            String reportEntry = PushBiUtil.reportEntry(this.b, PushNaming.UPSEND_MSG);
            ErrorEnum a2 = d.a(this.b);
            if (a2 == ErrorEnum.SUCCESS) {
                if (!TextUtils.isEmpty(remoteMessage.getTo())) {
                    if (!TextUtils.isEmpty(remoteMessage.getMessageId())) {
                        if (!TextUtils.isEmpty(remoteMessage.getData())) {
                            UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
                            upSendMsgReq.setPackageName(this.b.getPackageName());
                            upSendMsgReq.setMessageId(remoteMessage.getMessageId());
                            upSendMsgReq.setTo(remoteMessage.getTo());
                            upSendMsgReq.setData(remoteMessage.getData());
                            upSendMsgReq.setMessageType(remoteMessage.getMessageType());
                            upSendMsgReq.setTtl(remoteMessage.getTtl());
                            upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
                            upSendMsgReq.setSendMode(remoteMessage.getSendMode());
                            upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
                            if (s.b()) {
                                this.c.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), reportEntry));
                                return;
                            } else {
                                a(upSendMsgReq, reportEntry);
                                return;
                            }
                        }
                        HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
                        PushBiUtil.reportExit(this.b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                        throw new IllegalArgumentException("Mandatory parameter 'data' missing");
                    }
                    HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
                    PushBiUtil.reportExit(this.b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                    throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
                }
                HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
                PushBiUtil.reportExit(this.b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                throw new IllegalArgumentException("Mandatory parameter 'to' missing");
            }
            HMSLog.e("HmsMessaging", "Message sent failed:" + a2.getExternalCode() + ':' + a2.getMessage());
            PushBiUtil.reportExit(this.b, PushNaming.UPSEND_MSG, reportEntry, a2);
            throw new UnsupportedOperationException(a2.getMessage());
        }
    }

    public final void a(UpSendMsgReq upSendMsgReq, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, upSendMsgReq, str) == null) {
            upSendMsgReq.setToken(BaseUtils.getLocalToken(this.b, null));
            try {
                this.c.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
            } catch (Exception e) {
                if (e.getCause() instanceof ApiException) {
                    PushBiUtil.reportExit(this.b, PushNaming.UPSEND_MSG, str, ((ApiException) e.getCause()).getStatusCode());
                } else {
                    PushBiUtil.reportExit(this.b, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
                }
            }
        }
    }

    public hcc<Void> turnOffPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (ProxyCenter.getProxy() != null) {
                HMSLog.i("HmsMessaging", "turn off for proxy");
                return ProxyCenter.getProxy().turnOff(this.b, null);
            }
            HMSLog.i("HmsMessaging", "invoke turnOffPush");
            return a(false);
        }
        return (hcc) invokeV.objValue;
    }

    public hcc<Void> turnOnPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (ProxyCenter.getProxy() != null) {
                HMSLog.i("HmsMessaging", "turn on for proxy");
                return ProxyCenter.getProxy().turnOn(this.b, null);
            }
            HMSLog.i("HmsMessaging", "invoke turnOnPush");
            return a(true);
        }
        return (hcc) invokeV.objValue;
    }
}
