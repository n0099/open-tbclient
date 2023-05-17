package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class f2 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ h2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(h2 h2Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h2Var, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h2Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i = message.what;
            try {
                if (i != 11) {
                    if (i == 12) {
                        str = (String) message.obj;
                        context = this.a.a;
                    }
                }
                str = (String) message.obj;
                d1 a = e1.a(this.a.a);
                try {
                    a.b = e1.a("ps", new f1(this.a.b));
                    a.a("co", 2002);
                    a.a("msg", str);
                } catch (JSONException unused) {
                }
                a.a();
                context = this.a.a;
                e2.a(context, Uri.parse(str));
            } catch (Exception unused2) {
            }
        }
    }
}
