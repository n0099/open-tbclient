package com.idlefish.flutterboost;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.flutter.util.OpenNative;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
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
/* loaded from: classes15.dex */
public class FlutterBoostPlugin implements FlutterPlugin {
    private static final Set<ActionAfterRegistered> sActions = new HashSet();
    private static FlutterBoostPlugin sInstance;
    private final Map<String, Set<EventListener>> mEventListeners;
    private final Set<MethodChannel.MethodCallHandler> mMethodCallHandlers;
    private final MethodChannel mMethodChannel;
    private final EventListener splashEventListener;

    /* loaded from: classes15.dex */
    public interface ActionAfterRegistered {
        void onChannelRegistered(FlutterBoostPlugin flutterBoostPlugin);
    }

    /* loaded from: classes15.dex */
    public interface EventListener {
        void onEvent(String str, Map map);
    }

    public static FlutterBoostPlugin singleton() {
        return sInstance;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        sInstance = new FlutterBoostPlugin(flutterPluginBinding.getBinaryMessenger());
        for (ActionAfterRegistered actionAfterRegistered : sActions) {
            actionAfterRegistered.onChannelRegistered(sInstance);
        }
        sActions.clear();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public FlutterBoostPlugin() {
        this.mMethodCallHandlers = new HashSet();
        this.mEventListeners = new HashMap();
        this.splashEventListener = new EventListener() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.2
            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -263576197:
                        if (str.equals("pageLifeCycle")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -253456115:
                        if (str.equals("dataInitFinish")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        FlutterBoost.instance().isReady = true;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921459));
                        return;
                    case 1:
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921478, map));
                        return;
                    default:
                        return;
                }
            }
        };
        this.mMethodChannel = null;
    }

    private FlutterBoostPlugin(BinaryMessenger binaryMessenger) {
        this.mMethodCallHandlers = new HashSet();
        this.mEventListeners = new HashMap();
        this.splashEventListener = new EventListener() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.2
            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -263576197:
                        if (str.equals("pageLifeCycle")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -253456115:
                        if (str.equals("dataInitFinish")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        FlutterBoost.instance().isReady = true;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921459));
                        return;
                    case 1:
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921478, map));
                        return;
                    default:
                        return;
                }
            }
        };
        this.mMethodChannel = new MethodChannel(binaryMessenger, "flutter_boost");
        this.mMethodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.1
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                Object[] array;
                if (!methodCall.method.equals("__event__")) {
                    synchronized (FlutterBoostPlugin.this.mMethodCallHandlers) {
                        array = FlutterBoostPlugin.this.mMethodCallHandlers.toArray();
                    }
                    for (Object obj : array) {
                        ((MethodChannel.MethodCallHandler) obj).onMethodCall(methodCall, result);
                    }
                    return;
                }
                String str = (String) methodCall.argument("name");
                Map map = (Map) methodCall.argument("arguments");
                EventListener[] eventListenerArr = null;
                synchronized (FlutterBoostPlugin.this.mEventListeners) {
                    Set set = (Set) FlutterBoostPlugin.this.mEventListeners.get(str);
                    if (set != null) {
                        eventListenerArr = set.toArray();
                    }
                }
                if (eventListenerArr != null) {
                    for (EventListener eventListener : eventListenerArr) {
                        eventListener.onEvent(str, map);
                    }
                }
            }
        });
        addEventListener("dataInitFinish", this.splashEventListener);
        addEventListener("pageLifeCycle", this.splashEventListener);
        addMethodCallHandler(new BoostMethodHandler());
    }

    public void invokeMethodUnsafe(final String str, Serializable serializable) {
        invokeMethod(str, serializable, new MethodChannel.Result() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.3
            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void success(@Nullable Object obj) {
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void error(String str2, @Nullable String str3, @Nullable Object obj) {
                Debuger.log("invoke method " + str + " error:" + str2 + " | " + str3);
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void notImplemented() {
                Debuger.log("invoke method " + str + " notImplemented");
            }
        });
    }

    public void invokeMethod(final String str, Serializable serializable) {
        invokeMethod(str, serializable, new MethodChannel.Result() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.4
            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void success(@Nullable Object obj) {
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void error(String str2, @Nullable String str3, @Nullable Object obj) {
                Debuger.exception("invoke method " + str + " error:" + str2 + " | " + str3);
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void notImplemented() {
                Debuger.exception("invoke method " + str + " notImplemented");
            }
        });
    }

    public void invokeMethod(String str, Serializable serializable, MethodChannel.Result result) {
        if ("__event__".equals(str)) {
            Debuger.exception("method name should not be __event__");
        }
        this.mMethodChannel.invokeMethod(str, serializable, result);
    }

    public void addMethodCallHandler(MethodChannel.MethodCallHandler methodCallHandler) {
        synchronized (this.mMethodCallHandlers) {
            this.mMethodCallHandlers.add(methodCallHandler);
        }
    }

    public void addEventListener(String str, EventListener eventListener) {
        synchronized (this.mEventListeners) {
            Set<EventListener> set = this.mEventListeners.get(str);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(eventListener);
            this.mEventListeners.put(str, set);
        }
    }

    public void removeEventListener(EventListener eventListener) {
        synchronized (this.mEventListeners) {
            for (Set<EventListener> set : this.mEventListeners.values()) {
                set.remove(eventListener);
            }
        }
    }

    public void sendEvent(String str, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("arguments", map);
        this.mMethodChannel.invokeMethod("__event__", hashMap);
    }

    /* loaded from: classes15.dex */
    class BoostMethodHandler implements MethodChannel.MethodCallHandler {
        BoostMethodHandler() {
        }

        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
            FlutterViewContainerManager flutterViewContainerManager = (FlutterViewContainerManager) FlutterBoost.instance().containerManager();
            String str = methodCall.method;
            char c = 65535;
            switch (str.hashCode()) {
                case -1224756544:
                    if (str.equals("disablePopGesture")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1037220475:
                    if (str.equals("onShownContainerChanged")) {
                        c = 3;
                        break;
                    }
                    break;
                case -504772615:
                    if (str.equals("openPage")) {
                        c = 1;
                        break;
                    }
                    break;
                case -482608985:
                    if (str.equals("closePage")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1791664180:
                    if (str.equals("pageOnStart")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1882486492:
                    if (str.equals("swipeBackControl")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
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
                        return;
                    } catch (Throwable th) {
                        result.error("no flutter page found!", th.getMessage(), Log.getStackTraceString(th));
                        return;
                    }
                case 1:
                    try {
                        final String str2 = (String) methodCall.argument("url");
                        flutterViewContainerManager.openContainer(str2, (Map) methodCall.argument("urlParams"), (Map) methodCall.argument("exts"), new FlutterViewContainerManager.OnResult() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.BoostMethodHandler.1
                            @Override // com.idlefish.flutterboost.FlutterViewContainerManager.OnResult
                            public void onResult(Map<String, Object> map) {
                                if (result != null) {
                                    result.success(BoostMethodHandler.this.parseNativeResult(str2, map));
                                }
                            }
                        });
                        return;
                    } catch (Throwable th2) {
                        result.error("open page error", th2.getMessage(), Log.getStackTraceString(th2));
                        return;
                    }
                case 2:
                    try {
                        flutterViewContainerManager.closeContainer((String) methodCall.argument("uniqueId"), (Map) methodCall.argument("result"), (Map) methodCall.argument("exts"));
                        result.success(true);
                        return;
                    } catch (Throwable th3) {
                        result.error("close page error", th3.getMessage(), Log.getStackTraceString(th3));
                        return;
                    }
                case 3:
                    try {
                        flutterViewContainerManager.onShownContainerChanged((String) methodCall.argument("newName"), (String) methodCall.argument("oldName"));
                        result.success(true);
                        return;
                    } catch (Throwable th4) {
                        result.error("onShownContainerChanged", th4.getMessage(), Log.getStackTraceString(th4));
                        return;
                    }
                case 4:
                    try {
                        boolean booleanValue = ((Boolean) methodCall.arguments).booleanValue();
                        IFlutterViewContainer container = flutterViewContainerManager.getLastGenerateRecord().getContainer();
                        if (container != null) {
                            container.setSwipeBackEnable(!booleanValue);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 5:
                    try {
                        int intValue = ((Integer) methodCall.arguments).intValue();
                        IFlutterViewContainer container2 = flutterViewContainerManager.getLastGenerateRecord().getContainer();
                        if (container2 != null) {
                            container2.swipeBackControl(intValue);
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                default:
                    result.notImplemented();
                    return;
            }
        }

        public Map<String, Object> parseNativeResult(String str, Map<String, Object> map) {
            HashMap hashMap = new HashMap();
            if (str.contains(OpenNative.kNativePageKeyEditProfile)) {
                if (map.containsKey("data") && (map.get("data") instanceof PersonChangeData)) {
                    hashMap.put("intro", ((PersonChangeData) map.get("data")).getIntro());
                }
                return hashMap;
            } else if (str.contains(OpenNative.kNativePageKeyItemEvaluatePage)) {
                if (map.containsKey("post_write_callback_data") && (map.get("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) map.get("post_write_callback_data");
                    hashMap.put(TiebaInitialize.LogFields.ERROR_CODE, Integer.valueOf(postWriteCallBackData.getErrorCode()));
                    hashMap.put(TiebaInitialize.LogFields.ERROR_MESSAGE, postWriteCallBackData.getErrorString());
                }
                return hashMap;
            } else {
                return map;
            }
        }
    }
}
