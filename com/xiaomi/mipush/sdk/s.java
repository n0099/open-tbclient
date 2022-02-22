package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.iq;
/* loaded from: classes4.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T extends iq<T, ?>> void a(Context context, Config config) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, context, config) == null) || config == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", config.isEventUploadSwitchOpen());
        intent.putExtra("action_cr_event_frequency", config.getEventUploadFrequency());
        intent.putExtra("action_cr_perf_switch", config.isPerfUploadSwitchOpen());
        intent.putExtra("action_cr_perf_frequency", config.getPerfUploadFrequency());
        intent.putExtra("action_cr_event_en", config.isEventEncrypted());
        intent.putExtra("action_cr_max_file_size", config.getMaxFileLength());
        an.a(context).m166a(intent);
    }
}
