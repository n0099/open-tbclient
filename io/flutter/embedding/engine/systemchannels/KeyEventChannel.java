package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class KeyEventChannel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BasicMessageChannel<Object> channel;

    /* loaded from: classes3.dex */
    public static class FlutterKeyEvent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FlutterKeyEvent(@NonNull KeyEvent keyEvent) {
            this(keyEvent, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyEvent};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((KeyEvent) objArr2[0], (Character) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FlutterKeyEvent(@NonNull KeyEvent keyEvent, @Nullable Character ch) {
            this(keyEvent.getDeviceId(), keyEvent.getFlags(), keyEvent.getUnicodeChar(0), keyEvent.getUnicodeChar(), keyEvent.getKeyCode(), ch, keyEvent.getScanCode(), keyEvent.getMetaState(), keyEvent.getSource(), keyEvent.getRepeatCount());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {keyEvent, ch};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), (Character) objArr2[5], ((Integer) objArr2[6]).intValue(), ((Integer) objArr2[7]).intValue(), ((Integer) objArr2[8]).intValue(), ((Integer) objArr2[9]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public FlutterKeyEvent(int i2, int i3, int i4, int i5, int i6, @Nullable Character ch, int i7, int i8, int i9, int i10) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), ch, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i11 = newInitContext.flag;
                if ((i11 & 1) != 0) {
                    int i12 = i11 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dartExecutor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.channel = new BasicMessageChannel<>(dartExecutor, "flutter/keyevent", JSONMessageCodec.INSTANCE);
    }

    private void encodeKeyEvent(@NonNull FlutterKeyEvent flutterKeyEvent, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, flutterKeyEvent, map) == null) {
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
    }

    public void keyDown(@NonNull FlutterKeyEvent flutterKeyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterKeyEvent) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "keydown");
            hashMap.put("keymap", "android");
            encodeKeyEvent(flutterKeyEvent, hashMap);
            this.channel.send(hashMap);
        }
    }

    public void keyUp(@NonNull FlutterKeyEvent flutterKeyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterKeyEvent) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "keyup");
            hashMap.put("keymap", "android");
            encodeKeyEvent(flutterKeyEvent, hashMap);
            this.channel.send(hashMap);
        }
    }
}
