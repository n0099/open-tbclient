package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class a2 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c2 f76568a;

    public a2(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76568a = c2Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i2 = message.what;
            try {
                if (i2 != 11) {
                    if (i2 == 12) {
                        str = (String) message.obj;
                        context = this.f76568a.f76612a;
                    }
                }
                str = (String) message.obj;
                Y0 a2 = Z0.a(this.f76568a.f76612a);
                try {
                    a2.f76554b = Z0.a("ps", new a1(this.f76568a.f76613b));
                    a2.a("co", 2002);
                    a2.a("msg", str);
                } catch (JSONException unused) {
                }
                a2.a();
                context = this.f76568a.f76612a;
                Z1.a(context, Uri.parse(str));
            } catch (Exception unused2) {
            }
        }
    }
}
