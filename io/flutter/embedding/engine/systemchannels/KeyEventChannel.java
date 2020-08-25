package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class KeyEventChannel {
    @NonNull
    public final BasicMessageChannel<Object> channel;

    public KeyEventChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, "flutter/keyevent", JSONMessageCodec.INSTANCE);
    }

    public void keyUp(@NonNull FlutterKeyEvent flutterKeyEvent) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keyup");
        hashMap.put("keymap", "android");
        encodeKeyEvent(flutterKeyEvent, hashMap);
        this.channel.send(hashMap);
    }

    public void keyDown(@NonNull FlutterKeyEvent flutterKeyEvent) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keydown");
        hashMap.put("keymap", "android");
        encodeKeyEvent(flutterKeyEvent, hashMap);
        this.channel.send(hashMap);
    }

    private void encodeKeyEvent(@NonNull FlutterKeyEvent flutterKeyEvent, @NonNull Map<String, Object> map) {
        map.put("flags", Integer.valueOf(flutterKeyEvent.flags));
        map.put("plainCodePoint", Integer.valueOf(flutterKeyEvent.plainCodePoint));
        map.put("codePoint", Integer.valueOf(flutterKeyEvent.codePoint));
        map.put("keyCode", Integer.valueOf(flutterKeyEvent.keyCode));
        map.put("scanCode", Integer.valueOf(flutterKeyEvent.scanCode));
        map.put("metaState", Integer.valueOf(flutterKeyEvent.metaState));
        if (flutterKeyEvent.complexCharacter != null) {
            map.put("character", flutterKeyEvent.complexCharacter.toString());
        }
        map.put("source", Integer.valueOf(flutterKeyEvent.source));
        map.put("vendorId", Integer.valueOf(flutterKeyEvent.vendorId));
        map.put("productId", Integer.valueOf(flutterKeyEvent.productId));
        map.put("deviceId", Integer.valueOf(flutterKeyEvent.deviceId));
        map.put("repeatCount", Integer.valueOf(flutterKeyEvent.repeatCount));
    }

    /* loaded from: classes19.dex */
    public static class FlutterKeyEvent {
        public final int codePoint;
        @Nullable
        public final Character complexCharacter;
        public final int deviceId;
        public final int flags;
        public final int keyCode;
        public final int metaState;
        public final int plainCodePoint;
        public final int productId;
        public final int repeatCount;
        public final int scanCode;
        public final int source;
        public final int vendorId;

        public FlutterKeyEvent(@NonNull KeyEvent keyEvent) {
            this(keyEvent, null);
        }

        public FlutterKeyEvent(@NonNull KeyEvent keyEvent, @Nullable Character ch) {
            this(keyEvent.getDeviceId(), keyEvent.getFlags(), keyEvent.getUnicodeChar(0), keyEvent.getUnicodeChar(), keyEvent.getKeyCode(), ch, keyEvent.getScanCode(), keyEvent.getMetaState(), keyEvent.getSource(), keyEvent.getRepeatCount());
        }

        public FlutterKeyEvent(int i, int i2, int i3, int i4, int i5, @Nullable Character ch, int i6, int i7, int i8, int i9) {
            this.deviceId = i;
            this.flags = i2;
            this.plainCodePoint = i3;
            this.codePoint = i4;
            this.keyCode = i5;
            this.complexCharacter = ch;
            this.scanCode = i6;
            this.metaState = i7;
            this.source = i8;
            this.repeatCount = i9;
            InputDevice device = InputDevice.getDevice(i);
            if (device != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.vendorId = device.getVendorId();
                    this.productId = device.getProductId();
                    return;
                }
                this.vendorId = 0;
                this.productId = 0;
                return;
            }
            this.vendorId = 0;
            this.productId = 0;
        }
    }
}
