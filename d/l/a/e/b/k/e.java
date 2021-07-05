package d.l.a.e.b.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class e implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile Handler f74849e;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Looper f74850a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1342555908, "Ld/l/a/e/b/k/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1342555908, "Ld/l/a/e/b/k/e$a;");
                    return;
                }
            }
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            f74850a = handlerThread.getLooper();
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        long a();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74849e = new Handler(a.f74850a, this);
    }

    public static Looper a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f74850a : (Looper) invokeV.objValue;
    }

    public void b(b bVar, long j) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j) == null) || (handler = this.f74849e) == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = bVar;
        handler.sendMessageDelayed(obtain, j);
    }

    public void c() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.f74849e) == null) {
            return;
        }
        this.f74849e = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message)) == null) {
            if (message.what != 0) {
                return true;
            }
            try {
                b bVar = (b) message.obj;
                long a2 = bVar.a();
                if (a2 > 0) {
                    b(bVar, a2);
                    return true;
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
