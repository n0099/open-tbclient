package com.idlefish.flutterboost;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.flutter.base.util.OpenNative;
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
/* loaded from: classes6.dex */
public class FlutterBoostPlugin implements FlutterPlugin {
    public static final Set<ActionAfterRegistered> sActions = new HashSet();
    public static FlutterBoostPlugin sInstance;
    public final Map<String, Set<EventListener>> mEventListeners;
    public final Set<MethodChannel.MethodCallHandler> mMethodCallHandlers;
    public final MethodChannel mMethodChannel;
    public final EventListener splashEventListener;

    /* loaded from: classes6.dex */
    public interface ActionAfterRegistered {
        void onChannelRegistered(FlutterBoostPlugin flutterBoostPlugin);
    }

    /* loaded from: classes6.dex */
    public class BoostMethodHandler implements MethodChannel.MethodCallHandler {
        public BoostMethodHandler(FlutterBoostPlugin flutterBoostPlugin) {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
            char c2;
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
                    final String str2 = (String) methodCall.argument("url");
                    flutterViewContainerManager.openContainer(str2, (Map) methodCall.argument("urlParams"), (Map) methodCall.argument("exts"), new FlutterViewContainerManager.OnResult() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.BoostMethodHandler.1
                        @Override // com.idlefish.flutterboost.FlutterViewContainerManager.OnResult
                        public void onResult(Map<String, Object> map) {
                            MethodChannel.Result result2 = result;
                            if (result2 != null) {
                                result2.success(BoostMethodHandler.this.parseNativeResult(str2, map));
                            }
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
                    hashMap.put("errorCode", Integer.valueOf(postWriteCallBackData.getErrorCode()));
                    hashMap.put("errorMsg", postWriteCallBackData.getErrorString());
                }
                return hashMap;
            } else {
                return map;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface EventListener {
        void onEvent(String str, Map map);
    }

    public FlutterBoostPlugin() {
        this.mMethodCallHandlers = new HashSet();
        this.mEventListeners = new HashMap();
        this.splashEventListener = new EventListener(this) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.2
            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                char c2;
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
        };
        this.mMethodChannel = null;
    }

    public static FlutterBoostPlugin singleton() {
        return sInstance;
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

    public void addMethodCallHandler(MethodChannel.MethodCallHandler methodCallHandler) {
        synchronized (this.mMethodCallHandlers) {
            this.mMethodCallHandlers.add(methodCallHandler);
        }
    }

    public void invokeMethod(final String str, Serializable serializable) {
        invokeMethod(str, serializable, new MethodChannel.Result(this) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.4
            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void error(String str2, @Nullable String str3, @Nullable Object obj) {
                Debuger.exception("invoke method " + str + " error:" + str2 + " | " + str3);
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void notImplemented() {
                Debuger.exception("invoke method " + str + " notImplemented");
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void success(@Nullable Object obj) {
            }
        });
    }

    public void invokeMethodUnsafe(final String str, Serializable serializable) {
        invokeMethod(str, serializable, new MethodChannel.Result(this) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.3
            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void error(String str2, @Nullable String str3, @Nullable Object obj) {
                Debuger.log("invoke method " + str + " error:" + str2 + " | " + str3);
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void notImplemented() {
                Debuger.log("invoke method " + str + " notImplemented");
            }

            @Override // io.flutter.plugin.common.MethodChannel.Result
            public void success(@Nullable Object obj) {
            }
        });
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

    public void invokeMethod(String str, Serializable serializable, MethodChannel.Result result) {
        if ("__event__".equals(str)) {
            Debuger.exception("method name should not be __event__");
        }
        this.mMethodChannel.invokeMethod(str, serializable, result);
    }

    public FlutterBoostPlugin(BinaryMessenger binaryMessenger) {
        this.mMethodCallHandlers = new HashSet();
        this.mEventListeners = new HashMap();
        this.splashEventListener = new EventListener(this) { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.2
            @Override // com.idlefish.flutterboost.FlutterBoostPlugin.EventListener
            public void onEvent(String str, Map map) {
                char c2;
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
        };
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter_boost");
        this.mMethodChannel = methodChannel;
        methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.idlefish.flutterboost.FlutterBoostPlugin.1
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                Object[] array;
                Object[] array2;
                int i = 0;
                if (!methodCall.method.equals("__event__")) {
                    synchronized (FlutterBoostPlugin.this.mMethodCallHandlers) {
                        array = FlutterBoostPlugin.this.mMethodCallHandlers.toArray();
                    }
                    int length = array.length;
                    while (i < length) {
                        ((MethodChannel.MethodCallHandler) array[i]).onMethodCall(methodCall, result);
                        i++;
                    }
                    return;
                }
                String str = (String) methodCall.argument("name");
                Map map = (Map) methodCall.argument("arguments");
                synchronized (FlutterBoostPlugin.this.mEventListeners) {
                    Set set = (Set) FlutterBoostPlugin.this.mEventListeners.get(str);
                    array2 = set != null ? set.toArray() : null;
                }
                if (array2 != null) {
                    int length2 = array2.length;
                    while (i < length2) {
                        ((EventListener) array2[i]).onEvent(str, map);
                        i++;
                    }
                }
            }
        });
        addEventListener("dataInitFinish", this.splashEventListener);
        addEventListener("pageLifeCycle", this.splashEventListener);
        addMethodCallHandler(new BoostMethodHandler(this));
    }
}
