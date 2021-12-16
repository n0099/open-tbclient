package io.flutter.embedding.android;

import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.plugin.editing.TextInputPlugin;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class KeyboardManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KeyboardManager";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final HashSet<KeyEvent> redispatchedEvents;
    @NonNull
    public final Responder[] responders;
    @NonNull
    public final TextInputPlugin textInputPlugin;
    public final View view;

    /* renamed from: io.flutter.embedding.android.KeyboardManager$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class PerEventCallbackBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isEventHandled;
        @NonNull
        public final KeyEvent keyEvent;
        public final /* synthetic */ KeyboardManager this$0;
        public int unrepliedCount;

        public PerEventCallbackBuilder(@NonNull KeyboardManager keyboardManager, KeyEvent keyEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyboardManager, keyEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = keyboardManager;
            this.unrepliedCount = this.this$0.responders.length;
            this.isEventHandled = false;
            this.keyEvent = keyEvent;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Callback(this, null) : (Responder.OnKeyEventHandledCallback) invokeV.objValue;
        }

        /* loaded from: classes4.dex */
        public class Callback implements Responder.OnKeyEventHandledCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean isCalled;
            public final /* synthetic */ PerEventCallbackBuilder this$1;

            public Callback(PerEventCallbackBuilder perEventCallbackBuilder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {perEventCallbackBuilder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = perEventCallbackBuilder;
                this.isCalled = false;
            }

            @Override // io.flutter.embedding.android.KeyboardManager.Responder.OnKeyEventHandledCallback
            public void onKeyEventHandled(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    if (!this.isCalled) {
                        this.isCalled = true;
                        PerEventCallbackBuilder perEventCallbackBuilder = this.this$1;
                        perEventCallbackBuilder.unrepliedCount--;
                        perEventCallbackBuilder.isEventHandled = bool.booleanValue() | perEventCallbackBuilder.isEventHandled;
                        PerEventCallbackBuilder perEventCallbackBuilder2 = this.this$1;
                        if (perEventCallbackBuilder2.unrepliedCount != 0 || perEventCallbackBuilder2.isEventHandled) {
                            return;
                        }
                        perEventCallbackBuilder2.this$0.onUnhandled(perEventCallbackBuilder2.keyEvent);
                        return;
                    }
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
            }

            public /* synthetic */ Callback(PerEventCallbackBuilder perEventCallbackBuilder, AnonymousClass1 anonymousClass1) {
                this(perEventCallbackBuilder);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface Responder {

        /* loaded from: classes4.dex */
        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(Boolean bool);
        }

        void handleEvent(@NonNull KeyEvent keyEvent, @NonNull OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public KeyboardManager(View view, @NonNull TextInputPlugin textInputPlugin, Responder[] responderArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, textInputPlugin, responderArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.redispatchedEvents = new HashSet<>();
        this.view = view;
        this.textInputPlugin = textInputPlugin;
        this.responders = responderArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnhandled(@NonNull KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, keyEvent) == null) || this.textInputPlugin.handleKeyEvent(keyEvent) || this.view == null) {
            return;
        }
        this.redispatchedEvents.add(keyEvent);
        this.view.getRootView().dispatchKeyEvent(keyEvent);
        if (this.redispatchedEvents.remove(keyEvent)) {
            Log.w(TAG, "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }

    public void destroy() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (size = this.redispatchedEvents.size()) <= 0) {
            return;
        }
        Log.w(TAG, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
    }

    public boolean handleEvent(@NonNull KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
            if (this.redispatchedEvents.remove(keyEvent)) {
                return false;
            }
            if (this.responders.length > 0) {
                PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(this, keyEvent);
                for (Responder responder : this.responders) {
                    responder.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
                }
                return true;
            }
            onUnhandled(keyEvent);
            return true;
        }
        return invokeL.booleanValue;
    }
}
