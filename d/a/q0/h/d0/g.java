package d.a.q0.h.d0;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f53215c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f53216d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f53217a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53218b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2030799429, "Ld/a/q0/h/d0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2030799429, "Ld/a/q0/h/d0/g;");
                return;
            }
        }
        f53215c = k.f49133a;
        f53216d = null;
    }

    public g() {
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

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f53216d == null) {
                synchronized (g.class) {
                    if (f53216d == null) {
                        f53216d = new g();
                    }
                }
            }
            return f53216d;
        }
        return (g) invokeV.objValue;
    }

    @NonNull
    public GameRecorderController b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f53215c) {
                Log.i("GameRecorderManager", "getRecorderController:" + this.f53217a);
            }
            GameRecorderController gameRecorderController = this.f53217a;
            return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
        }
        return (GameRecorderController) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (f53215c) {
                Log.i("GameRecorderManager", "isGamePause:" + this.f53218b);
            }
            return this.f53218b;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f53218b = true;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f53218b = false;
        }
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gameRecorderController) == null) && (gameRecorderController2 = this.f53217a) != null && gameRecorderController2 == gameRecorderController) {
            gameRecorderController2.p();
            this.f53217a = null;
        }
    }

    public void g(GameRecorderController gameRecorderController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gameRecorderController) == null) {
            GameRecorderController gameRecorderController2 = this.f53217a;
            if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
                gameRecorderController2.p();
            }
            this.f53217a = gameRecorderController;
        }
    }
}
