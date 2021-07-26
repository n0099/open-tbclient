package d.a.o0.h.d0;

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
import d.a.o0.a.k;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50417c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f50418d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GameRecorderController f50419a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50420b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871140857, "Ld/a/o0/h/d0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871140857, "Ld/a/o0/h/d0/g;");
                return;
            }
        }
        f50417c = k.f46335a;
        f50418d = null;
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
            if (f50418d == null) {
                synchronized (g.class) {
                    if (f50418d == null) {
                        f50418d = new g();
                    }
                }
            }
            return f50418d;
        }
        return (g) invokeV.objValue;
    }

    @NonNull
    public GameRecorderController b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f50417c) {
                Log.i("GameRecorderManager", "getRecorderController:" + this.f50419a);
            }
            GameRecorderController gameRecorderController = this.f50419a;
            return gameRecorderController == null ? GameRecorderController.j() : gameRecorderController;
        }
        return (GameRecorderController) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (f50417c) {
                Log.i("GameRecorderManager", "isGamePause:" + this.f50420b);
            }
            return this.f50420b;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f50420b = true;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f50420b = false;
        }
    }

    public void f(GameRecorderController gameRecorderController) {
        GameRecorderController gameRecorderController2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gameRecorderController) == null) && (gameRecorderController2 = this.f50419a) != null && gameRecorderController2 == gameRecorderController) {
            gameRecorderController2.p();
            this.f50419a = null;
        }
    }

    public void g(GameRecorderController gameRecorderController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gameRecorderController) == null) {
            GameRecorderController gameRecorderController2 = this.f50419a;
            if (gameRecorderController2 != null && gameRecorderController2 != gameRecorderController) {
                gameRecorderController2.p();
            }
            this.f50419a = gameRecorderController;
        }
    }
}
