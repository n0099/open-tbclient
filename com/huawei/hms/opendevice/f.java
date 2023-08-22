package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
/* loaded from: classes10.dex */
public class f implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                int internalCode = ErrorEnum.SUCCESS.getInternalCode();
                ApiException apiException = null;
                try {
                    str = HmsInstanceId.getInstance(this.a).getToken(Util.getAppId(this.a), null);
                } catch (ApiException e) {
                    e = e;
                    str = null;
                }
                try {
                    HMSLog.i("AutoInit", "Push init succeed");
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                } catch (ApiException e2) {
                    e = e2;
                    apiException = e;
                    internalCode = apiException.getStatusCode();
                    HMSLog.e("AutoInit", "new Push init failed");
                    applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
                    if (applicationInfo.metaData == null) {
                    }
                    HMSLog.i("AutoInit", "push kit sdk not exists");
                }
                try {
                    applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
                    if (applicationInfo.metaData == null && applicationInfo.metaData.getString("com.huawei.hms.client.service.name:push") != null) {
                        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                        intent.setPackage(this.a.getPackageName());
                        Bundle bundle = new Bundle();
                        bundle.putString("message_type", "new_token");
                        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, str);
                        bundle.putInt("error", internalCode);
                        if (apiException != null) {
                            bundle.putSerializable("exception_key", apiException);
                        }
                        if (!new h().a(this.a, bundle, intent)) {
                            HMSLog.e("AutoInit", "start service failed");
                            return;
                        }
                        return;
                    }
                    HMSLog.i("AutoInit", "push kit sdk not exists");
                } catch (PackageManager.NameNotFoundException unused) {
                    HMSLog.i("AutoInit", "push kit sdk not exists");
                }
            } catch (Exception e3) {
                HMSLog.e("AutoInit", "Push init failed", e3);
            }
        }
    }
}
