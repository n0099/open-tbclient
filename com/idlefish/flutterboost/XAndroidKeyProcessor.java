package com.idlefish.flutterboost;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
/* loaded from: classes12.dex */
public class XAndroidKeyProcessor {
    private int combiningCharacter;
    @NonNull
    private final KeyEventChannel keyEventChannel;
    @NonNull
    private final XTextInputPlugin textInputPlugin;

    public XAndroidKeyProcessor(@NonNull KeyEventChannel keyEventChannel, @NonNull XTextInputPlugin xTextInputPlugin) {
        this.keyEventChannel = keyEventChannel;
        this.textInputPlugin = xTextInputPlugin;
    }

    public void onKeyUp(@NonNull KeyEvent keyEvent) {
        this.keyEventChannel.keyUp(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())));
    }

    public void onKeyDown(@NonNull KeyEvent keyEvent) {
        if (this.textInputPlugin.getLastInputConnection() != null && this.textInputPlugin.getInputMethodManager().isAcceptingText()) {
            this.textInputPlugin.getLastInputConnection().sendKeyEvent(keyEvent);
        }
        this.keyEventChannel.keyDown(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())));
    }

    @Nullable
    private Character applyCombiningCharacterToBaseCharacter(int i) {
        if (i == 0) {
            return null;
        }
        Character valueOf = Character.valueOf((char) i);
        if ((Integer.MIN_VALUE & i) != 0) {
            int i2 = Integer.MAX_VALUE & i;
            if (this.combiningCharacter != 0) {
                this.combiningCharacter = KeyCharacterMap.getDeadChar(this.combiningCharacter, i2);
                return valueOf;
            }
            this.combiningCharacter = i2;
            return valueOf;
        } else if (this.combiningCharacter != 0) {
            int deadChar = KeyCharacterMap.getDeadChar(this.combiningCharacter, i);
            if (deadChar > 0) {
                valueOf = Character.valueOf((char) deadChar);
            }
            this.combiningCharacter = 0;
            return valueOf;
        } else {
            return valueOf;
        }
    }
}
