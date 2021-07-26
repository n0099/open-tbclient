package f.a.a.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.embedding.android.SplashScreen;
/* compiled from: SplashScreen.java */
/* loaded from: classes9.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"NewApi"})
    public static boolean $default$doesSplashViewRememberItsTransition(SplashScreen splashScreen) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, splashScreen)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public static Bundle $default$saveSplashScreenState(SplashScreen splashScreen) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, splashScreen)) == null) {
            return null;
        }
        return (Bundle) invokeL.objValue;
    }
}
