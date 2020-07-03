package com.idlefish.flutterboost;

import android.support.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.idlefish.flutterboost.FlutterViewContainerManager;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class FlutterBoostPlugin {
    private static final Set<ActionAfterRegistered> sActions = new HashSet();
    private static FlutterBoostPlugin sInstance;
    private final MethodChannel mMethodChannel;
    private final Set<MethodChannel.MethodCallHandler> mMethodCallHandlers = new HashSet();
    private final Map<String, Set<EventListener>> mEventListeners = new HashMap();
    private final EventListener splashEventListener = new EventListener() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.2
        @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
        public void onEvent(String str, Map map) {
            char c = 65535;
            switch (str.hashCode()) {
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
                default:
                    return;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface ActionAfterRegistered {
        void onChannelRegistered(FlutterBoostPlugin flutterBoostPlugin);
    }

    /* loaded from: classes6.dex */
    public interface EventListener {
        void onEvent(String str, Map map);
    }

    public static FlutterBoostPlugin singleton() {
        return sInstance;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        sInstance = new FlutterBoostPlugin(registrar);
        for (ActionAfterRegistered actionAfterRegistered : sActions) {
            actionAfterRegistered.onChannelRegistered(sInstance);
        }
        sActions.clear();
    }

    private FlutterBoostPlugin(PluginRegistry.Registrar registrar) {
        this.mMethodChannel = new MethodChannel(registrar.messenger(), "flutter_boost");
        this.mMethodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.1
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
        addMethodCallHandler(new BoostMethodHandler());
    }

    public void invokeMethodUnsafe(final String str, Serializable serializable) {
        invokeMethod(str, serializable, new MethodChannel.Result() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.3
            public void success(@Nullable Object obj) {
            }

            public void error(String str2, @Nullable String str3, @Nullable Object obj) {
                Debuger.log("invoke method " + str + " error:" + str2 + " | " + str3);
            }

            public void notImplemented() {
                Debuger.log("invoke method " + str + " notImplemented");
            }
        });
    }

    public void invokeMethod(final String str, Serializable serializable) {
        invokeMethod(str, serializable, new MethodChannel.Result() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.4
            public void success(@Nullable Object obj) {
            }

            public void error(String str2, @Nullable String str3, @Nullable Object obj) {
                Debuger.exception("invoke method " + str + " error:" + str2 + " | " + str3);
            }

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

    public void sendEvent(String str, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("arguments", map);
        this.mMethodChannel.invokeMethod("__event__", hashMap);
    }

    /* loaded from: classes6.dex */
    class BoostMethodHandler implements MethodChannel.MethodCallHandler {
        BoostMethodHandler() {
        }

        public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
            FlutterViewContainerManager flutterViewContainerManager = (FlutterViewContainerManager) FlutterBoost.instance().containerManager();
            String str = methodCall.method;
            char c = 65535;
            switch (str.hashCode()) {
                case -2029879373:
                    if (str.equals("closeFlutterPage")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1224756544:
                    if (str.equals("disablePopGesture")) {
                        c = 6;
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
                case 1964912673:
                    if (str.equals("openFlutterPage")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    HashMap hashMap = new HashMap();
                    try {
                        IContainerRecord currentTopRecord = flutterViewContainerManager.getCurrentTopRecord();
                        IContainerRecord lastGenerateRecord = currentTopRecord == null ? flutterViewContainerManager.getLastGenerateRecord() : currentTopRecord;
                        if (lastGenerateRecord != null) {
                            hashMap.put("name", lastGenerateRecord.getContainer().getContainerUrl());
                            hashMap.put("params", lastGenerateRecord.getContainer().getContainerUrlParams());
                            hashMap.put("uniqueId", lastGenerateRecord.uniqueId());
                        }
                        result.success(hashMap);
                        FlutterBoost.instance().setFlutterPostFrameCallTime(new Date().getTime());
                        return;
                    } catch (Throwable th) {
                        result.error("no flutter page found!", th.getMessage(), th);
                        return;
                    }
                case 1:
                    try {
                        flutterViewContainerManager.openContainer((String) methodCall.argument("url"), (Map) methodCall.argument("urlParams"), (Map) methodCall.argument("exts"), new FlutterViewContainerManager.OnResult() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.BoostMethodHandler.1
                            @Override // com.idlefish.flutterboost.FlutterViewContainerManager.OnResult
                            public void onResult(Map<String, Object> map) {
                                if (result != null) {
                                    result.success(map);
                                }
                            }
                        });
                        return;
                    } catch (Throwable th2) {
                        result.error("open page error", th2.getMessage(), th2);
                        return;
                    }
                case 2:
                    try {
                        flutterViewContainerManager.closeContainer((String) methodCall.argument("uniqueId"), (Map) methodCall.argument("result"), (Map) methodCall.argument("exts"));
                        result.success(true);
                        return;
                    } catch (Throwable th3) {
                        result.error("close page error", th3.getMessage(), th3);
                        return;
                    }
                case 3:
                    try {
                        flutterViewContainerManager.onShownContainerChanged((String) methodCall.argument("newName"), (String) methodCall.argument("oldName"));
                        result.success(true);
                        return;
                    } catch (Throwable th4) {
                        result.error("onShownContainerChanged", th4.getMessage(), th4);
                        return;
                    }
                case 4:
                    String str2 = (String) methodCall.argument("uniqueId");
                    return;
                case 5:
                    String str3 = (String) methodCall.argument("uniqueId");
                    String str4 = (String) methodCall.argument("flutterUniqueId");
                    return;
                case 6:
                    boolean booleanValue = ((Boolean) methodCall.arguments).booleanValue();
                    IFlutterViewContainer container = flutterViewContainerManager.getLastGenerateRecord().getContainer();
                    if (container != null) {
                        container.setSwipeBackEnable(!booleanValue);
                        return;
                    }
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        }
    }
}
