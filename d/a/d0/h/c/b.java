package d.a.d0.h.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d0.c.a.h;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes8.dex */
public class b extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45299a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f45300b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, CountDownLatch countDownLatch) {
        super(Looper.getMainLooper());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, countDownLatch};
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
        this.f45299a = context;
        this.f45300b = countDownLatch;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            h.a().c();
            try {
                new WebView(this.f45299a);
            } catch (Exception unused) {
            }
            this.f45300b.countDown();
        }
    }
}
