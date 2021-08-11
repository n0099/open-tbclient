package com.idlefish.flutterboost;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.flutter.base.util.OpenNative;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterViewContainerManager;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class FlutterBoostPlugin implements FlutterPlugin {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<ActionAfterRegistered> sActions;
    public static FlutterBoostPlugin sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Set<EventListener>> mEventListeners;
    public final Set<MethodChannel.MethodCallHandler> mMethodCallHandlers;
    public final MethodChannel mMethodChannel;
    public final EventListener splashEventListener;

    /* loaded from: classes10.dex */
    public interface ActionAfterRegistered {
        void onChannelRegistered(FlutterBoostPlugin flutterBoostPlugin);
    }

    /* loaded from: classes10.dex */
    public class BoostMethodHandler implements MethodChannel.MethodCallHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BoostMethodHandler(FlutterBoostPlugin flutterBoostPlugin) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterBoostPlugin};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, methodCall, result) == null) {
                FlutterViewContainerManager flutterViewContainerManager = (FlutterViewContainerManager) FlutterBoost.instance().containerManager();
                String str = methodCall.method;
                switch (str.hashCode()) {
                    case -1224756544:
                        if (str.equals("disablePopGesture")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1037220475:
                        if (str.equals("onShownContainerChanged")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -504772615:
                        if (str.equals("openPage")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -482608985:
                        if (str.equals("closePage")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1791664180:
                        if (str.equals("pageOnStart")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1882486492:
                        if (str.equals("swipeBackControl")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    HashMap hashMap = new HashMap();
                    try {
                        IContainerRecord currentTopRecord = flutterViewContainerManager.getCurrentTopRecord();
                        if (currentTopRecord != null) {
                            hashMap.put("name", currentTopRecord.getContainer().getContainerUrl());
                            hashMap.put("params", currentTopRecord.getContainer().getContainerUrlParams());
                            hashMap.put("uniqueId", currentTopRecord.uniqueId());
                        }
                        result.success(hashMap);
                        FlutterBoost.instance().setFlutterPostFrameCallTime(new Date().getTime());
                    } catch (Throwable th) {
                        result.error("no flutter page found!", th.getMessage(), Log.getStackTraceString(th));
                    }
                } else if (c2 == 1) {
                    try {
                        String str2 = (String) methodCall.argument("url");
                        flutterViewContainerManager.openContainer(str2, (Map) methodCall.argument("urlParams"), (Map) methodCall.argument("exts"), new FlutterViewContainerManager.OnResult(this, result, str2) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.BoostMethodHandler.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ BoostMethodHandler this$1;
                            public final /* synthetic */ MethodChannel.Result val$result;
                            public final /* synthetic */ String val$url;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, result, str2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$result = result;
                                this.val$url = str2;
                            }

                            @Override // com.idlefish.flutterboost.FlutterViewContainerManager.OnResult
                            public void onResult(Map<String, Object> map) {
                                MethodChannel.Result result2;
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, map) == null) || (result2 = this.val$result) == null) {
                                    return;
                                }
                                result2.success(this.this$1.parseNativeResult(this.val$url, map));
                            }
                        });
                    } catch (Throwable th2) {
                        result.error("open page error", th2.getMessage(), Log.getStackTraceString(th2));
                    }
                } else if (c2 == 2) {
                    try {
                        flutterViewContainerManager.closeContainer((String) methodCall.argument("uniqueId"), (Map) methodCall.argument("result"), (Map) methodCall.argument("exts"));
                        result.success(Boolean.TRUE);
                    } catch (Throwable th3) {
                        result.error("close page error", th3.getMessage(), Log.getStackTraceString(th3));
                    }
                } else if (c2 == 3) {
                    try {
                        flutterViewContainerManager.onShownContainerChanged((String) methodCall.argument("newName"), (String) methodCall.argument("oldName"));
                        result.success(Boolean.TRUE);
                    } catch (Throwable th4) {
                        result.error("onShownContainerChanged", th4.getMessage(), Log.getStackTraceString(th4));
                    }
                } else if (c2 == 4) {
                    try {
                        boolean booleanValue = ((Boolean) methodCall.arguments).booleanValue();
                        IFlutterViewContainer container = flutterViewContainerManager.getLastGenerateRecord().getContainer();
                        if (container != null) {
                            container.setSwipeBackEnable(booleanValue ? false : true);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (c2 != 5) {
                    result.notImplemented();
                } else {
                    try {
                        int intValue = ((Integer) methodCall.arguments).intValue();
                        IFlutterViewContainer container2 = flutterViewContainerManager.getLastGenerateRecord().getContainer();
                        if (container2 != null) {
                            container2.swipeBackControl(intValue);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }

        public Map<String, Object> parseNativeResult(String str, Map<String, Object> map) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map)) == null) {
                HashMap hashMap = new HashMap();
                if (str.contains(OpenNative.kNativePageKeyEditProfile)) {
                    if (map.containsKey("data") && (map.get("data") instanceof PersonChangeData)) {
                        hashMap.put("intro", ((PersonChangeData) map.get("data")).getIntro());
                    }
                    return hashMap;
                } else if (str.contains(OpenNative.kNativePageKeyItemEvaluatePage)) {
                    if (map.containsKey("post_write_callback_data") && (map.get("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) map.get("post_write_callback_data");
                        hashMap.put("errorCode", Integer.valueOf(postWriteCallBackData.getErrorCode()));
                        hashMap.put("errorMsg", postWriteCallBackData.getErrorString());
                    }
                    return hashMap;
                } else {
                    return map;
                }
            }
            return (Map) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface EventListener {
        void onEvent(String str, Map map);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-133316350, "Lcom/idlefish/flutterboost/FlutterBoostPlugin;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-133316350, "Lcom/idlefish/flutterboost/FlutterBoostPlugin;");
                return;
            }
        }
        sActions = new HashSet();
    }

    public FlutterBoostPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMethodCallHandlers = new HashSet();
        this.mEventListeners = new HashMap();
        this.splashEventListener = new EventListener(this) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                    }
                }
            }

            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                char c2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, map) == null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -263576197) {
                        if (hashCode == -253456115 && str.equals("dataInitFinish")) {
                            c2 = 0;
                        }
                        c2 = 65535;
                    } else {
                        if (str.equals("pageLifeCycle")) {
                            c2 = 1;
                        }
                        c2 = 65535;
                    }
                    if (c2 == 0) {
                        FlutterBoost.instance().isReady = true;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921459));
                    } else if (c2 != 1) {
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921478, map));
                    }
                }
            }
        };
        this.mMethodChannel = null;
    }

    public static FlutterBoostPlugin singleton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? sInstance : (FlutterBoostPlugin) invokeV.objValue;
    }

    public void addEventListener(String str, EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, eventListener) == null) {
            synchronized (this.mEventListeners) {
                Set<EventListener> set = this.mEventListeners.get(str);
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(eventListener);
                this.mEventListeners.put(str, set);
            }
        }
    }

    public void addMethodCallHandler(MethodChannel.MethodCallHandler methodCallHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, methodCallHandler) == null) {
            synchronized (this.mMethodCallHandlers) {
                this.mMethodCallHandlers.add(methodCallHandler);
            }
        }
    }

    public void invokeMethod(String str, Serializable serializable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, serializable) == null) {
            invokeMethod(str, serializable, new MethodChannel.Result(this, str) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$name;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$name = str;
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void error(String str2, @Nullable String str3, @Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str2, str3, obj) == null) {
                        Debuger.exception("invoke method " + this.val$name + " error:" + str2 + " | " + str3);
                    }
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void notImplemented() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Debuger.exception("invoke method " + this.val$name + " notImplemented");
                    }
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void success(@Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    }
                }
            });
        }
    }

    public void invokeMethodUnsafe(String str, Serializable serializable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, serializable) == null) {
            invokeMethod(str, serializable, new MethodChannel.Result(this, str) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$name;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$name = str;
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void error(String str2, @Nullable String str3, @Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str2, str3, obj) == null) {
                        Debuger.log("invoke method " + this.val$name + " error:" + str2 + " | " + str3);
                    }
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void notImplemented() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Debuger.log("invoke method " + this.val$name + " notImplemented");
                    }
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void success(@Nullable Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    }
                }
            });
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flutterPluginBinding) == null) {
            sInstance = new FlutterBoostPlugin(flutterPluginBinding.getBinaryMessenger());
            for (ActionAfterRegistered actionAfterRegistered : sActions) {
                actionAfterRegistered.onChannelRegistered(sInstance);
            }
            sActions.clear();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, flutterPluginBinding) == null) {
        }
    }

    public void removeEventListener(EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eventListener) == null) {
            synchronized (this.mEventListeners) {
                for (Set<EventListener> set : this.mEventListeners.values()) {
                    set.remove(eventListener);
                }
            }
        }
    }

    public void sendEvent(String str, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, map) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("arguments", map);
            this.mMethodChannel.invokeMethod("__event__", hashMap);
        }
    }

    public void invokeMethod(String str, Serializable serializable, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, serializable, result) == null) {
            if ("__event__".equals(str)) {
                Debuger.exception("method name should not be __event__");
            }
            this.mMethodChannel.invokeMethod(str, serializable, result);
        }
    }

    public FlutterBoostPlugin(BinaryMessenger binaryMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binaryMessenger};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMethodCallHandlers = new HashSet();
        this.mEventListeners = new HashMap();
        this.splashEventListener = new EventListener(this) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                    }
                }
            }

            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                char c2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, map) == null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -263576197) {
                        if (hashCode == -253456115 && str.equals("dataInitFinish")) {
                            c2 = 0;
                        }
                        c2 = 65535;
                    } else {
                        if (str.equals("pageLifeCycle")) {
                            c2 = 1;
                        }
                        c2 = 65535;
                    }
                    if (c2 == 0) {
                        FlutterBoost.instance().isReady = true;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921459));
                    } else if (c2 != 1) {
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921478, map));
                    }
                }
            }
        };
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter_boost");
        this.mMethodChannel = methodChannel;
        methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler(this) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterBoostPlugin this$0;

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

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                Object[] array;
                Object[] array2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, methodCall, result) == null) {
                    int i4 = 0;
                    if (!methodCall.method.equals("__event__")) {
                        synchronized (this.this$0.mMethodCallHandlers) {
                            array = this.this$0.mMethodCallHandlers.toArray();
                        }
                        int length = array.length;
                        while (i4 < length) {
                            ((MethodChannel.MethodCallHandler) array[i4]).onMethodCall(methodCall, result);
                            i4++;
                        }
                        return;
                    }
                    String str = (String) methodCall.argument("name");
                    Map map = (Map) methodCall.argument("arguments");
                    synchronized (this.this$0.mEventListeners) {
                        Set set = (Set) this.this$0.mEventListeners.get(str);
                        array2 = set != null ? set.toArray() : null;
                    }
                    if (array2 != null) {
                        int length2 = array2.length;
                        while (i4 < length2) {
                            ((EventListener) array2[i4]).onEvent(str, map);
                            i4++;
                        }
                    }
                }
            }
        });
        addEventListener("dataInitFinish", this.splashEventListener);
        addEventListener("pageLifeCycle", this.splashEventListener);
        addMethodCallHandler(new BoostMethodHandler(this));
    }
}
