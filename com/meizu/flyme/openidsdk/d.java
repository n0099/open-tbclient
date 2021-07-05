package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.h.b.a.a;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r0 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        r1 = true;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || context == null || intent == null) {
            return;
        }
        boolean z = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        d.h.b.a.d.e("shouldUpdateId, notifyFlag : " + intExtra);
        if (intExtra != 1) {
            if (intExtra == 2) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra != null) {
                    z = stringArrayListExtra.contains(context.getPackageName());
                }
            }
        }
        if (z) {
            a g2 = d.h.b.a.d.b().g(intent.getStringExtra("openIdType"));
            if (g2 == null) {
                return;
            }
            g2.e();
        }
    }
}
