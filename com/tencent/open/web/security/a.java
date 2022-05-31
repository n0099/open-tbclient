package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.log.SLog;
/* loaded from: classes7.dex */
public class a extends InputConnectionWrapper {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static boolean b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(786661325, "Lcom/tencent/open/web/security/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(786661325, "Lcom/tencent/open/web/security/a;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputConnection, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((InputConnection) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, charSequence, i)) == null) {
            c = true;
            a = charSequence.toString();
            SLog.v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
            return super.commitText(charSequence, i);
        }
        return invokeLI.booleanValue;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 0) {
                SLog.i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
                a = String.valueOf((char) keyEvent.getUnicodeChar());
                c = true;
                SLog.d("openSDK_LOG.CaptureInputConnection", "s: " + a);
            }
            SLog.d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + a);
            return super.sendKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, charSequence, i)) == null) {
            c = true;
            a = charSequence.toString();
            SLog.v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
            return super.setComposingText(charSequence, i);
        }
        return invokeLI.booleanValue;
    }
}
