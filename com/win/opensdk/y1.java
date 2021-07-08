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
/* loaded from: classes6.dex */
public class y1 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A1 f39724a;

    public y1(A1 a1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39724a = a1;
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
                        context = this.f39724a.f39321a;
                    }
                }
                str = (String) message.obj;
                w0 a2 = x0.a(this.f39724a.f39321a);
                try {
                    a2.f39697b = x0.a("ps", new y0(this.f39724a.f39322b));
                    a2.a("co", 2002);
                    a2.a("msg", str);
                } catch (JSONException unused) {
                }
                a2.a();
                context = this.f39724a.f39321a;
                x1.a(context, Uri.parse(str));
            } catch (Exception unused2) {
            }
        }
    }
}
