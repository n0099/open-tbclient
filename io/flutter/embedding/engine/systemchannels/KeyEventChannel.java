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
/* loaded from: classes7.dex */
public class KeyEventChannel {
    @NonNull
    public final BasicMessageChannel<Object> channel;

    /* loaded from: classes7.dex */
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

        public FlutterKeyEvent(int i2, int i3, int i4, int i5, int i6, @Nullable Character ch, int i7, int i8, int i9, int i10) {
            this.deviceId = i2;
            this.flags = i3;
            this.plainCodePoint = i4;
            this.codePoint = i5;
            this.keyCode = i6;
            this.complexCharacter = ch;
            this.scanCode = i7;
            this.metaState = i8;
            this.source = i9;
            this.repeatCount = i10;
            InputDevice device = InputDevice.getDevice(i2);
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

    public KeyEventChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, "flutter/keyevent", JSONMessageCodec.INSTANCE);
    }

    private void encodeKeyEvent(@NonNull FlutterKeyEvent flutterKeyEvent, @NonNull Map<String, Object> map) {
        map.put("flags", Integer.valueOf(flutterKeyEvent.flags));
        map.put("plainCodePoint", Integer.valueOf(flutterKeyEvent.plainCodePoint));
        map.put("codePoint", Integer.valueOf(flutterKeyEvent.codePoint));
        map.put("keyCode", Integer.valueOf(flutterKeyEvent.keyCode));
        map.put("scanCode", Integer.valueOf(flutterKeyEvent.scanCode));
        map.put("metaState", Integer.valueOf(flutterKeyEvent.metaState));
        Character ch = flutterKeyEvent.complexCharacter;
        if (ch != null) {
            map.put("character", ch.toString());
        }
        map.put("source", Integer.valueOf(flutterKeyEvent.source));
        map.put("vendorId", Integer.valueOf(flutterKeyEvent.vendorId));
        map.put("productId", Integer.valueOf(flutterKeyEvent.productId));
        map.put("deviceId", Integer.valueOf(flutterKeyEvent.deviceId));
        map.put("repeatCount", Integer.valueOf(flutterKeyEvent.repeatCount));
    }

    public void keyDown(@NonNull FlutterKeyEvent flutterKeyEvent) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keydown");
        hashMap.put("keymap", "android");
        encodeKeyEvent(flutterKeyEvent, hashMap);
        this.channel.send(hashMap);
    }

    public void keyUp(@NonNull FlutterKeyEvent flutterKeyEvent) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keyup");
        hashMap.put("keymap", "android");
        encodeKeyEvent(flutterKeyEvent, hashMap);
        this.channel.send(hashMap);
    }
}
