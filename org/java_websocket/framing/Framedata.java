package org.java_websocket.framing;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public interface Framedata {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class Opcode {
        public static final /* synthetic */ Opcode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Opcode BINARY;
        public static final Opcode CLOSING;
        public static final Opcode CONTINUOUS;
        public static final Opcode PING;
        public static final Opcode PONG;
        public static final Opcode TEXT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-824896851, "Lorg/java_websocket/framing/Framedata$Opcode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-824896851, "Lorg/java_websocket/framing/Framedata$Opcode;");
                    return;
                }
            }
            CONTINUOUS = new Opcode("CONTINUOUS", 0);
            TEXT = new Opcode("TEXT", 1);
            BINARY = new Opcode("BINARY", 2);
            PING = new Opcode("PING", 3);
            PONG = new Opcode("PONG", 4);
            Opcode opcode = new Opcode("CLOSING", 5);
            CLOSING = opcode;
            $VALUES = new Opcode[]{CONTINUOUS, TEXT, BINARY, PING, PONG, opcode};
        }

        public Opcode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Opcode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Opcode) Enum.valueOf(Opcode.class, str) : (Opcode) invokeL.objValue;
        }

        public static Opcode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Opcode[]) $VALUES.clone() : (Opcode[]) invokeV.objValue;
        }
    }

    ByteBuffer a();

    boolean b();

    boolean c();

    Opcode d();

    boolean e();

    boolean f();
}
