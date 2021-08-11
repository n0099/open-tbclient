package com.idlefish.flutterboost;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
/* loaded from: classes10.dex */
public class XAndroidKeyProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int combiningCharacter;
    @NonNull
    public final KeyEventChannel keyEventChannel;
    @NonNull
    public final XTextInputPlugin textInputPlugin;

    public XAndroidKeyProcessor(@NonNull KeyEventChannel keyEventChannel, @NonNull XTextInputPlugin xTextInputPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {keyEventChannel, xTextInputPlugin};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.keyEventChannel = keyEventChannel;
        this.textInputPlugin = xTextInputPlugin;
    }

    @Nullable
    public final Character applyCombiningCharacterToBaseCharacter(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            Character valueOf = Character.valueOf((char) i2);
            if ((Integer.MIN_VALUE & i2) != 0) {
                int i3 = i2 & Integer.MAX_VALUE;
                int i4 = this.combiningCharacter;
                if (i4 != 0) {
                    this.combiningCharacter = KeyCharacterMap.getDeadChar(i4, i3);
                } else {
                    this.combiningCharacter = i3;
                }
            } else {
                int i5 = this.combiningCharacter;
                if (i5 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i5, i2);
                    if (deadChar > 0) {
                        valueOf = Character.valueOf((char) deadChar);
                    }
                    this.combiningCharacter = 0;
                }
            }
            return valueOf;
        }
        return (Character) invokeI.objValue;
    }

    public void onKeyDown(@NonNull KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent) == null) {
            if (this.textInputPlugin.getLastInputConnection() != null && this.textInputPlugin.getInputMethodManager().isAcceptingText()) {
                this.textInputPlugin.getLastInputConnection().sendKeyEvent(keyEvent);
            }
            this.keyEventChannel.keyDown(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())));
        }
    }

    public void onKeyUp(@NonNull KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keyEvent) == null) {
            this.keyEventChannel.keyUp(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())));
        }
    }
}
