package com.idlefish.flutterboost;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
/* loaded from: classes6.dex */
public class XAndroidKeyProcessor {
    public int combiningCharacter;
    @NonNull
    public final KeyEventChannel keyEventChannel;
    @NonNull
    public final XTextInputPlugin textInputPlugin;

    public XAndroidKeyProcessor(@NonNull KeyEventChannel keyEventChannel, @NonNull XTextInputPlugin xTextInputPlugin) {
        this.keyEventChannel = keyEventChannel;
        this.textInputPlugin = xTextInputPlugin;
    }

    @Nullable
    public final Character applyCombiningCharacterToBaseCharacter(int i2) {
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

    public void onKeyDown(@NonNull KeyEvent keyEvent) {
        if (this.textInputPlugin.getLastInputConnection() != null && this.textInputPlugin.getInputMethodManager().isAcceptingText()) {
            this.textInputPlugin.getLastInputConnection().sendKeyEvent(keyEvent);
        }
        this.keyEventChannel.keyDown(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())));
    }

    public void onKeyUp(@NonNull KeyEvent keyEvent) {
        this.keyEventChannel.keyUp(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())));
    }
}
