package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
/* loaded from: classes8.dex */
public class KeyChannelResponder implements KeyboardManager.Responder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KeyChannelResponder";
    public transient /* synthetic */ FieldHolder $fh;
    public int combiningCharacter;
    @NonNull
    public final KeyEventChannel keyEventChannel;

    public KeyChannelResponder(@NonNull KeyEventChannel keyEventChannel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {keyEventChannel};
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
    }

    public Character applyCombiningCharacterToBaseCharacter(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            char c2 = (char) i2;
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
                        c2 = (char) deadChar;
                    }
                    this.combiningCharacter = 0;
                }
            }
            return Character.valueOf(c2);
        }
        return (Character) invokeI.objValue;
    }

    @Override // io.flutter.embedding.android.KeyboardManager.Responder
    public void handleEvent(@NonNull KeyEvent keyEvent, @NonNull final KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent, onKeyEventHandledCallback) == null) {
            int action = keyEvent.getAction();
            if (action != 0 && action != 1) {
                onKeyEventHandledCallback.onKeyEventHandled(Boolean.FALSE);
            } else {
                this.keyEventChannel.sendFlutterKeyEvent(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())), action != 0, new KeyEventChannel.EventResponseHandler() { // from class: g.a.a.a.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.embedding.engine.systemchannels.KeyEventChannel.EventResponseHandler
                    public final void onFrameworkResponse(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            KeyboardManager.Responder.OnKeyEventHandledCallback.this.onKeyEventHandled(Boolean.valueOf(z));
                        }
                    }
                });
            }
        }
    }
}
