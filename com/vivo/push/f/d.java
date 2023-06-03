package com.vivo.push.f;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.ui.ImageViewPressedEffectHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class d extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.vivo.push.o oVar) {
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x00df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0 A[Catch: Exception -> 0x0172, TryCatch #0 {Exception -> 0x0172, blocks: (B:20:0x00b5, B:22:0x00bc, B:24:0x00c6, B:26:0x00d2, B:32:0x00e0, B:47:0x0165, B:33:0x00f1, B:35:0x0104, B:37:0x010e, B:38:0x011e, B:40:0x0124, B:41:0x012b, B:43:0x014b, B:45:0x014f), top: B:57:0x00b5 }] */
    @Override // com.vivo.push.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.vivo.push.o oVar) {
        Intent intent;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            com.vivo.push.b.p pVar = (com.vivo.push.b.p) oVar;
            if (pVar == null) {
                com.vivo.push.util.u.d("NotifyInnerClientTask", "current onNotifyArrivedCommand is null");
                return;
            }
            InsideNotificationItem f = pVar.f();
            if (f == null) {
                com.vivo.push.util.u.d("NotifyInnerClientTask", "current notification item is null");
                return;
            }
            UPSNotificationMessage a = com.vivo.push.util.v.a(f);
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
                String a2 = com.vivo.push.d.a.a().e().a();
                if (!TextUtils.isEmpty(a2)) {
                    hashMap.put("remoteAppId", a2);
                }
                xVar.a(hashMap);
                com.vivo.push.e.a().a(xVar);
                com.vivo.push.util.u.d("NotifyInnerClientTask", "notification is clicked by skip type[" + a.getSkipType() + PreferencesUtil.RIGHT_MOUNT);
                com.vivo.push.util.u.d("NotifyInnerClientTask", "notification is clicked by skip content[" + a.getSkipContent() + PreferencesUtil.RIGHT_MOUNT);
                try {
                    if (a.getSkipType() == 2) {
                        String skipContent = a.getSkipContent();
                        if (!TextUtils.isEmpty(skipContent)) {
                            String lowerCase = skipContent.toLowerCase();
                            if (lowerCase.startsWith("http://") || lowerCase.startsWith("https://")) {
                                z = true;
                                if (z) {
                                    return;
                                }
                                intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(skipContent));
                                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    } else {
                        intent = new Intent(pVar.g());
                        if (!TextUtils.isEmpty(pVar.h()) && !TextUtils.isEmpty(pVar.i())) {
                            intent.setComponent(new ComponentName(pVar.h(), pVar.i()));
                        }
                        if (pVar.j() != null) {
                            intent.setData(pVar.j());
                        }
                        intent.setSelector(null);
                        intent.setPackage(this.a.getPackageName());
                        intent.addFlags(ImageViewPressedEffectHelper.DEFAULT_PRESSED_MASK_LAYER_COLOR);
                        ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.a.getPackageManager(), 65536);
                        if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                            com.vivo.push.util.u.a("NotifyInnerClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                            return;
                        }
                    }
                    intent.putExtras(pVar.k());
                    this.a.startActivity(intent);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            com.vivo.push.util.u.a("NotifyInnerClientTask", "notify is " + a + " ; isMatch is " + equals);
        }
    }
}
