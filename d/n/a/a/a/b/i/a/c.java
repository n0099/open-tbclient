package d.n.a.a.a.b.i.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class c extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Context f75113a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper, Context context) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, looper, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75113a = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        Object obj2;
        String h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 666) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    h2 = b.h(this.f75113a, data.getInt("type"), data.getString("appid"));
                    String unused = b.f75109h = h2;
                }
                obj = b.f75106e;
                synchronized (obj) {
                    obj2 = b.f75106e;
                    obj2.notify();
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }
}
