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
/* loaded from: classes5.dex */
public abstract class ap9 implements cp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ap9() {
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

    @Override // com.repackage.cp9
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, qp9 qp9Var, xp9 xp9Var) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webSocket, qp9Var, xp9Var) == null) {
        }
    }

    @Override // com.repackage.cp9
    public yp9 onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, qp9 qp9Var) throws InvalidDataException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webSocket, draft, qp9Var)) == null) ? new up9() : (yp9) invokeLLL.objValue;
    }

    @Override // com.repackage.cp9
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, qp9 qp9Var) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webSocket, qp9Var) == null) {
        }
    }

    @Deprecated
    public abstract void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata);

    @Override // com.repackage.cp9
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webSocket, framedata) == null) {
            webSocket.sendFrame(new op9((np9) framedata));
        }
    }

    @Override // com.repackage.cp9
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webSocket, framedata) == null) {
        }
    }
}
