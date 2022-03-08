package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class KeyEventChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KeyEventChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BasicMessageChannel<Object> channel;

    /* loaded from: classes8.dex */
    public interface EventResponseHandler {
        void onFrameworkResponse(boolean z);
    }

    /* loaded from: classes8.dex */
    public static class FlutterKeyEvent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Character complexCharacter;
        public final KeyEvent event;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FlutterKeyEvent(@NonNull KeyEvent keyEvent) {
            this(keyEvent, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((KeyEvent) objArr2[0], (Character) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public FlutterKeyEvent(@NonNull KeyEvent keyEvent, @Nullable Character ch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyEvent, ch};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.event = keyEvent;
            this.complexCharacter = ch;
        }
    }

    public KeyEventChannel(@NonNull BinaryMessenger binaryMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binaryMessenger};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.channel = new BasicMessageChannel<>(binaryMessenger, "flutter/keyevent", JSONMessageCodec.INSTANCE);
    }

    public static /* synthetic */ void a(EventResponseHandler eventResponseHandler, Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e2) {
                Log.e(TAG, "Unable to unpack JSON message: " + e2);
            }
        }
        eventResponseHandler.onFrameworkResponse(z);
    }

    public static BasicMessageChannel.Reply<Object> createReplyHandler(@NonNull final EventResponseHandler eventResponseHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eventResponseHandler)) == null) ? new BasicMessageChannel.Reply() { // from class: g.a.a.b.c.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    KeyEventChannel.a(KeyEventChannel.EventResponseHandler.this, obj);
                }
            }
        } : (BasicMessageChannel.Reply) invokeL.objValue;
    }

    private Map<String, Object> encodeKeyEvent(@NonNull FlutterKeyEvent flutterKeyEvent, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, flutterKeyEvent, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", z ? "keyup" : "keydown");
            hashMap.put("keymap", "android");
            hashMap.put("flags", Integer.valueOf(flutterKeyEvent.event.getFlags()));
            int i3 = 0;
            hashMap.put("plainCodePoint", Integer.valueOf(flutterKeyEvent.event.getUnicodeChar(0)));
            hashMap.put("codePoint", Integer.valueOf(flutterKeyEvent.event.getUnicodeChar()));
            hashMap.put("keyCode", Integer.valueOf(flutterKeyEvent.event.getKeyCode()));
            hashMap.put("scanCode", Integer.valueOf(flutterKeyEvent.event.getScanCode()));
            hashMap.put("metaState", Integer.valueOf(flutterKeyEvent.event.getMetaState()));
            Character ch = flutterKeyEvent.complexCharacter;
            if (ch != null) {
                hashMap.put("character", ch.toString());
            }
            hashMap.put("source", Integer.valueOf(flutterKeyEvent.event.getSource()));
            InputDevice device = InputDevice.getDevice(flutterKeyEvent.event.getDeviceId());
            if (device == null || Build.VERSION.SDK_INT < 19) {
                i2 = 0;
            } else {
                i3 = device.getVendorId();
                i2 = device.getProductId();
            }
            hashMap.put("vendorId", Integer.valueOf(i3));
            hashMap.put("productId", Integer.valueOf(i2));
            hashMap.put("deviceId", Integer.valueOf(flutterKeyEvent.event.getDeviceId()));
            hashMap.put("repeatCount", Integer.valueOf(flutterKeyEvent.event.getRepeatCount()));
            return hashMap;
        }
        return (Map) invokeLZ.objValue;
    }

    public void sendFlutterKeyEvent(@NonNull FlutterKeyEvent flutterKeyEvent, boolean z, @NonNull EventResponseHandler eventResponseHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{flutterKeyEvent, Boolean.valueOf(z), eventResponseHandler}) == null) {
            this.channel.send(encodeKeyEvent(flutterKeyEvent, z), createReplyHandler(eventResponseHandler));
        }
    }
}
