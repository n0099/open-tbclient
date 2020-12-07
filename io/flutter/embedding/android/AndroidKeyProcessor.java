package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.editing.TextInputPlugin;
/* loaded from: classes9.dex */
public class AndroidKeyProcessor {
    private int combiningCharacter;
    private final KeyEventChannel keyEventChannel;
    private final TextInputPlugin textInputPlugin;

    public AndroidKeyProcessor(KeyEventChannel keyEventChannel, TextInputPlugin textInputPlugin) {
        this.keyEventChannel = keyEventChannel;
        this.textInputPlugin = textInputPlugin;
    }

    public void onKeyUp(KeyEvent keyEvent) {
        this.keyEventChannel.keyUp(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())));
    }

    public void onKeyDown(KeyEvent keyEvent) {
        if (this.textInputPlugin.getLastInputConnection() != null && this.textInputPlugin.getInputMethodManager().isAcceptingText()) {
            this.textInputPlugin.getLastInputConnection().sendKeyEvent(keyEvent);
        }
        this.keyEventChannel.keyDown(new KeyEventChannel.FlutterKeyEvent(keyEvent, applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar())));
    }

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
