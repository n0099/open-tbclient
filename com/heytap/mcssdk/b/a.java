package com.heytap.mcssdk.b;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.utils.e;
import com.heytap.mcssdk.utils.f;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "Heytap PUSH";
    public static final String b = "System Default Channel";
    public static final int c = 3;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
    @TargetApi(26)
    public boolean a(Context context, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65537, this, context, str, str2, i)) == null) {
            if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
                return false;
            }
            notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i));
            return true;
        }
        return invokeLLLI.booleanValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        f.a(new Runnable(this, context) { // from class: com.heytap.mcssdk.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ a b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = this;
                this.a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || e.f().a()) {
                    return;
                }
                String string = this.a.getString(R.string.obfuscated_res_0x7f0f160a);
                if (TextUtils.isEmpty(string)) {
                    string = a.b;
                }
                e.f().a(this.b.a(this.a, a.a, string, 3));
            }
        });
    }
}
