package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.event.base.TKBaseEvent;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class AccessibilityChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AccessibilityChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BasicMessageChannel<Object> channel;
    @NonNull
    public final FlutterJNI flutterJNI;
    @Nullable
    public AccessibilityMessageHandler handler;
    public final BasicMessageChannel.MessageHandler<Object> parsingMessageHandler;

    /* loaded from: classes8.dex */
    public interface AccessibilityMessageHandler extends FlutterJNI.AccessibilityDelegate {
        void announce(@NonNull String str);

        void onLongPress(int i2);

        void onTap(int i2);

        void onTooltip(@NonNull String str);
    }

    public AccessibilityChannel(@NonNull DartExecutor dartExecutor, @NonNull FlutterJNI flutterJNI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dartExecutor, flutterJNI};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parsingMessageHandler = new BasicMessageChannel.MessageHandler<Object>(this) { // from class: io.flutter.embedding.engine.systemchannels.AccessibilityChannel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AccessibilityChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
            public void onMessage(@Nullable Object obj, @NonNull BasicMessageChannel.Reply<Object> reply) {
                String str;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, reply) == null) || this.this$0.handler == null) {
                    return;
                }
                HashMap hashMap = (HashMap) obj;
                String str2 = (String) hashMap.get("type");
                HashMap hashMap2 = (HashMap) hashMap.get("data");
                Log.v(AccessibilityChannel.TAG, "Received " + str2 + " message.");
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case -1140076541:
                        if (str2.equals("tooltip")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -649620375:
                        if (str2.equals("announce")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 114595:
                        if (str2.equals(TKBaseEvent.TK_CLICK_EVENT_NAME)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 114203431:
                        if (str2.equals(TKBaseEvent.TK_LONG_PRESS_EVENT_NAME)) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        this.this$0.handler.announce(str3);
                    }
                } else if (c2 == 1) {
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        this.this$0.handler.onTap(num.intValue());
                    }
                } else if (c2 == 2) {
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        this.this$0.handler.onLongPress(num2.intValue());
                    }
                } else if (c2 == 3 && (str = (String) hashMap2.get("message")) != null) {
                    this.this$0.handler.onTooltip(str);
                }
                reply.reply(null);
            }
        };
        BasicMessageChannel<Object> basicMessageChannel = new BasicMessageChannel<>(dartExecutor, "flutter/accessibility", StandardMessageCodec.INSTANCE);
        this.channel = basicMessageChannel;
        basicMessageChannel.setMessageHandler(this.parsingMessageHandler);
        this.flutterJNI = flutterJNI;
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, action) == null) {
            this.flutterJNI.dispatchSemanticsAction(i2, action);
        }
    }

    public void onAndroidAccessibilityDisabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.flutterJNI.setSemanticsEnabled(false);
        }
    }

    public void onAndroidAccessibilityEnabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.flutterJNI.setSemanticsEnabled(true);
        }
    }

    public void setAccessibilityFeatures(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.flutterJNI.setAccessibilityFeatures(i2);
        }
    }

    public void setAccessibilityMessageHandler(@Nullable AccessibilityMessageHandler accessibilityMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accessibilityMessageHandler) == null) {
            this.handler = accessibilityMessageHandler;
            this.flutterJNI.setAccessibilityDelegate(accessibilityMessageHandler);
        }
    }

    public void dispatchSemanticsAction(int i2, @NonNull AccessibilityBridge.Action action, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, action, obj) == null) {
            this.flutterJNI.dispatchSemanticsAction(i2, action, obj);
        }
    }
}
