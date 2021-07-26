package d.a.d.e.p;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Field f41979a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f41980b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Handler f41981a;

        public a(Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41981a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    super.dispatchMessage(message);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                try {
                    if (this.f41981a != null) {
                        this.f41981a.handleMessage(message);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-402035041, "Ld/a/d/e/p/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-402035041, "Ld/a/d/e/p/u;");
                return;
            }
        }
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f41979a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f41979a.getType().getDeclaredField("mHandler");
                f41980b = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Toast toast) {
        Object obj;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, toast) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 28 || f41979a == null || f41980b == null || (obj = f41979a.get(toast)) == null || (handler = (Handler) f41980b.get(obj)) == null) {
                    return;
                }
                f41980b.set(obj, new a(handler));
            } catch (Exception unused) {
            }
        }
    }
}
