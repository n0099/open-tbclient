package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class xr9 implements zr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xr9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.zr9
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, ns9 ns9Var, us9 us9Var) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webSocket, ns9Var, us9Var) == null) {
        }
    }

    @Override // com.repackage.zr9
    public vs9 onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, ns9 ns9Var) throws InvalidDataException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webSocket, draft, ns9Var)) == null) ? new rs9() : (vs9) invokeLLL.objValue;
    }

    @Override // com.repackage.zr9
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, ns9 ns9Var) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webSocket, ns9Var) == null) {
        }
    }

    @Deprecated
    public abstract void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata);

    @Override // com.repackage.zr9
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webSocket, framedata) == null) {
            webSocket.sendFrame(new ls9((ks9) framedata));
        }
    }

    @Override // com.repackage.zr9
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webSocket, framedata) == null) {
        }
    }
}
