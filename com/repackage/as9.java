package com.repackage;

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
/* loaded from: classes5.dex */
public class as9 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ hs9 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as9(hs9 hs9Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hs9Var, looper};
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
        this.a = hs9Var;
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
                rr9 a = vr9.a(this.a.a);
                try {
                    a.b = vr9.d("ps", new zr9(this.a.b));
                    a.k("co", 2002);
                    a.l("msg", str);
                } catch (JSONException unused) {
                }
                a.m();
                context = this.a.a;
                wr9.a(context, Uri.parse(str));
            } catch (Exception unused2) {
            }
        }
    }
}
