package d.a.o0.a.y0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.o0.a.k;
import d.a.o0.a.y0.d;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class c<W extends d> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48910b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, a<W>> f48911a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(525661785, "Ld/a/o0/a/y0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(525661785, "Ld/a/o0/a/y0/c;");
                return;
            }
        }
        f48910b = k.f46335a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48911a = new HashMap<>();
    }

    public void a(a<W> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (f48910b) {
                Log.v("CommandDispatcher", aVar.b() + " command added to supported command list");
            }
            this.f48911a.put(aVar.b(), aVar);
        }
    }

    public void b(@Nullable ZeusPlugin.Command command, @Nullable W w) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command, w) == null) {
            if (command == null || TextUtils.isEmpty(command.what)) {
                if (f48910b) {
                    Log.e("CommandDispatcher", "command or command.what is null, haven't dispatched");
                }
            } else if (w == null) {
                if (f48910b) {
                    Log.e("CommandDispatcher", "inlineWidget is null, haven't dispatched");
                }
            } else {
                a<W> aVar = this.f48911a.get(command.what);
                if (aVar == null) {
                    if (f48910b) {
                        Log.e("CommandDispatcher", command.what + " command is not supported, haven't dispatched");
                        return;
                    }
                    return;
                }
                if (f48910b) {
                    Log.d("CommandDispatcher", command.what + " command dispatched");
                }
                aVar.a(command, w);
            }
        }
    }

    public void c(@Nullable ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            if (command != null && !TextUtils.isEmpty(command.what)) {
                a<W> aVar = this.f48911a.get(command.what);
                if (aVar == null) {
                    if (f48910b) {
                        Log.e("CommandDispatcher", command.what + " command is not supported, haven't mocked");
                        return;
                    }
                    return;
                }
                if (f48910b) {
                    Log.d("CommandDispatcher", command.what + " cached command return value processed");
                }
                aVar.c(command);
            } else if (f48910b) {
                Log.e("CommandDispatcher", "command or command.what is null, haven't mocked");
            }
        }
    }
}
