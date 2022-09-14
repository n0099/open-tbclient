package rx;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class Emitter$BackpressureMode {
    public static final /* synthetic */ Emitter$BackpressureMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Emitter$BackpressureMode BUFFER;
    public static final Emitter$BackpressureMode DROP;
    public static final Emitter$BackpressureMode ERROR;
    public static final Emitter$BackpressureMode LATEST;
    public static final Emitter$BackpressureMode NONE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1511728633, "Lrx/Emitter$BackpressureMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1511728633, "Lrx/Emitter$BackpressureMode;");
                return;
            }
        }
        NONE = new Emitter$BackpressureMode(HlsPlaylistParser.METHOD_NONE, 0);
        ERROR = new Emitter$BackpressureMode("ERROR", 1);
        BUFFER = new Emitter$BackpressureMode("BUFFER", 2);
        DROP = new Emitter$BackpressureMode("DROP", 3);
        Emitter$BackpressureMode emitter$BackpressureMode = new Emitter$BackpressureMode("LATEST", 4);
        LATEST = emitter$BackpressureMode;
        $VALUES = new Emitter$BackpressureMode[]{NONE, ERROR, BUFFER, DROP, emitter$BackpressureMode};
    }

    public Emitter$BackpressureMode(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Emitter$BackpressureMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Emitter$BackpressureMode) Enum.valueOf(Emitter$BackpressureMode.class, str) : (Emitter$BackpressureMode) invokeL.objValue;
    }

    public static Emitter$BackpressureMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Emitter$BackpressureMode[]) $VALUES.clone() : (Emitter$BackpressureMode[]) invokeV.objValue;
    }
}
