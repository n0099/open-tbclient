package org.java_websocket;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.java_websocket.framing.Framedata;
/* loaded from: classes3.dex */
public interface WebSocket {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class READYSTATE {
        public static final /* synthetic */ READYSTATE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final READYSTATE CLOSED;
        public static final READYSTATE CLOSING;
        @Deprecated
        public static final READYSTATE CONNECTING;
        public static final READYSTATE NOT_YET_CONNECTED;
        public static final READYSTATE OPEN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1139480062, "Lorg/java_websocket/WebSocket$READYSTATE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1139480062, "Lorg/java_websocket/WebSocket$READYSTATE;");
                    return;
                }
            }
            NOT_YET_CONNECTED = new READYSTATE("NOT_YET_CONNECTED", 0);
            CONNECTING = new READYSTATE("CONNECTING", 1);
            OPEN = new READYSTATE("OPEN", 2);
            CLOSING = new READYSTATE("CLOSING", 3);
            READYSTATE readystate = new READYSTATE("CLOSED", 4);
            CLOSED = readystate;
            $VALUES = new READYSTATE[]{NOT_YET_CONNECTED, CONNECTING, OPEN, CLOSING, readystate};
        }

        public READYSTATE(String str, int i2) {
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

        public static READYSTATE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (READYSTATE) Enum.valueOf(READYSTATE.class, str) : (READYSTATE) invokeL.objValue;
        }

        public static READYSTATE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (READYSTATE[]) $VALUES.clone() : (READYSTATE[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Role {
        public static final /* synthetic */ Role[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Role CLIENT;
        public static final Role SERVER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-307374342, "Lorg/java_websocket/WebSocket$Role;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-307374342, "Lorg/java_websocket/WebSocket$Role;");
                    return;
                }
            }
            CLIENT = new Role("CLIENT", 0);
            Role role = new Role("SERVER", 1);
            SERVER = role;
            $VALUES = new Role[]{CLIENT, role};
        }

        public Role(String str, int i2) {
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

        public static Role valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Role) Enum.valueOf(Role.class, str) : (Role) invokeL.objValue;
        }

        public static Role[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Role[]) $VALUES.clone() : (Role[]) invokeV.objValue;
        }
    }

    void sendFrame(Framedata framedata);
}
