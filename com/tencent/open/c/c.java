package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a.f;
import com.tencent.open.web.security.SecureJsInterface;
/* loaded from: classes7.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41959a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KeyEvent f41960b;

    /* renamed from: c  reason: collision with root package name */
    public com.tencent.open.web.security.a f41961c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        int unicodeChar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            f.b("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f41959a);
            if (!f41959a) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 4) {
                    if (keyCode != 66) {
                        if (keyCode != 67) {
                            if (keyEvent.getUnicodeChar() == 0) {
                                return super.dispatchKeyEvent(keyEvent);
                            }
                            if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                                KeyEvent keyEvent2 = new KeyEvent(0, 17);
                                this.f41960b = keyEvent2;
                                return super.dispatchKeyEvent(keyEvent2);
                            }
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        com.tencent.open.web.security.a.f42027b = true;
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    return super.dispatchKeyEvent(keyEvent);
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorInfo)) == null) {
            f.c("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            f.a("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
            if (onCreateInputConnection != null) {
                f41959a = true;
                com.tencent.open.web.security.a aVar = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
                this.f41961c = aVar;
                return aVar;
            }
            f41959a = false;
            return onCreateInputConnection;
        }
        return (InputConnection) invokeL.objValue;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        int unicodeChar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, keyEvent)) == null) {
            f.b("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f41959a);
            if (!f41959a) {
                return super.onKeyDown(i2, keyEvent);
            }
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 4) {
                    if (keyCode != 66) {
                        if (keyCode != 67) {
                            if (keyEvent.getUnicodeChar() == 0) {
                                return super.onKeyDown(i2, keyEvent);
                            }
                            if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                                KeyEvent keyEvent2 = new KeyEvent(0, 17);
                                this.f41960b = keyEvent2;
                                return super.onKeyDown(keyEvent2.getKeyCode(), this.f41960b);
                            }
                            return super.onKeyDown(i2, keyEvent);
                        }
                        com.tencent.open.web.security.a.f42027b = true;
                        return super.onKeyDown(i2, keyEvent);
                    }
                    return super.onKeyDown(i2, keyEvent);
                }
                return super.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
