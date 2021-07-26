package d.a.o0.a.y0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes7.dex */
public abstract class a<W extends d> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48901a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(525661723, "Ld/a/o0/a/y0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(525661723, "Ld/a/o0/a/y0/a;");
                return;
            }
        }
        f48901a = k.f46335a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public abstract void a(@NonNull ZeusPlugin.Command command, @NonNull W w);

    @NonNull
    public abstract String b();

    public void c(@NonNull ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
        }
    }

    public void d(@NonNull W w, @Nullable String str, @Nullable String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{w, str, str2, Boolean.valueOf(z)}) == null) && f48901a) {
            String str3 = ("【" + w.j0() + "-" + w.hashCode() + "】\t") + "【" + str + "】";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + "\t【" + str2 + "】";
            }
            if (z) {
                d.a.o0.a.e0.d.g("【InlineCommand】", str3);
            } else {
                Log.v("【InlineCommand】", str3);
            }
        }
    }
}
