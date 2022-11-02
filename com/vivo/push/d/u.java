package com.vivo.push.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class u extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((com.vivo.push.o) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, uPSNotificationMessage) == null) {
            com.vivo.push.m.c(new w(this, uPSNotificationMessage));
        }
    }

    public static Intent b(Intent intent, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, intent, map)) == null) {
            if (map != null && map.entrySet() != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && entry.getKey() != null) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
            }
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        Intent parseUri;
        String str;
        String packageName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            com.vivo.push.b.p pVar = (com.vivo.push.b.p) oVar;
            InsideNotificationItem f = pVar.f();
            if (f == null) {
                com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
                return;
            }
            UPSNotificationMessage a = com.vivo.push.util.q.a(f);
            boolean equals = this.a.getPackageName().equals(pVar.d());
            if (equals) {
                NotifyAdapterUtil.cancelNotify(this.a);
            }
            if (equals) {
                com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("type", "2");
                hashMap.put("messageID", String.valueOf(pVar.e()));
                hashMap.put(Constants.PARAM_PLATFORM, this.a.getPackageName());
                Context context = this.a;
                String b = com.vivo.push.util.z.b(context, context.getPackageName());
                if (!TextUtils.isEmpty(b)) {
                    hashMap.put("remoteAppId", b);
                }
                xVar.a(hashMap);
                com.vivo.push.e.a().a(xVar);
                com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a.getSkipType() + PreferencesUtil.RIGHT_MOUNT);
                int skipType = a.getSkipType();
                boolean z = true;
                if (skipType != 1) {
                    if (skipType != 2) {
                        if (skipType != 3) {
                            if (skipType != 4) {
                                com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a.getSkipType());
                                return;
                            }
                            String skipContent = a.getSkipContent();
                            try {
                                parseUri = Intent.parseUri(skipContent, 1);
                                str = parseUri.getPackage();
                            } catch (Exception e) {
                                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(skipContent)), e);
                            }
                            if (!TextUtils.isEmpty(str) && !this.a.getPackageName().equals(str)) {
                                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                                return;
                            }
                            if (parseUri.getComponent() == null) {
                                packageName = null;
                            } else {
                                packageName = parseUri.getComponent().getPackageName();
                            }
                            if (!TextUtils.isEmpty(packageName) && !this.a.getPackageName().equals(packageName)) {
                                com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                                return;
                            }
                            parseUri.setSelector(null);
                            parseUri.setPackage(this.a.getPackageName());
                            parseUri.addFlags(335544320);
                            b(parseUri, a.getParams());
                            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.a.getPackageManager(), 65536);
                            if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                                com.vivo.push.util.p.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
                                return;
                            }
                            this.a.startActivity(parseUri);
                            a(a);
                            return;
                        }
                        a(a);
                        return;
                    }
                    String skipContent2 = a.getSkipContent();
                    if (!skipContent2.startsWith("http://") && !skipContent2.startsWith("https://")) {
                        z = false;
                    }
                    if (z) {
                        Uri parse = Uri.parse(skipContent2);
                        Intent intent = new Intent("android.intent.action.VIEW", parse);
                        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        b(intent, a.getParams());
                        try {
                            this.a.startActivity(intent);
                        } catch (Exception unused) {
                            com.vivo.push.util.p.a("OnNotificationClickTask", "startActivity error : ".concat(String.valueOf(parse)));
                        }
                    } else {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "url not legal");
                    }
                    a(a);
                    return;
                }
                new Thread(new v(this, this.a, a.getParams())).start();
                a(a);
                return;
            }
            com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a + " ; isMatch is " + equals);
        }
    }
}
