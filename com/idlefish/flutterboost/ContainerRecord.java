package com.idlefish.flutterboost;

import android.content.Intent;
import com.baidu.tbadk.switchs.FlutterAttachSwitch;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ContainerRecord implements IContainerRecord {
    private final IFlutterViewContainer mContainer;
    private final FlutterViewContainerManager mManager;
    private final String mUniqueId;
    private int mState = 0;
    private MethodChannelProxy mProxy = new MethodChannelProxy();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContainerRecord(FlutterViewContainerManager flutterViewContainerManager, IFlutterViewContainer iFlutterViewContainer) {
        Map containerUrlParams = iFlutterViewContainer.getContainerUrlParams();
        if (containerUrlParams != null && containerUrlParams.containsKey("__container_uniqueId_key__")) {
            this.mUniqueId = String.valueOf(containerUrlParams.get("__container_uniqueId_key__"));
        } else {
            this.mUniqueId = genUniqueId(this);
        }
        this.mManager = flutterViewContainerManager;
        this.mContainer = iFlutterViewContainer;
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerRecord
    public String uniqueId() {
        return this.mUniqueId;
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerRecord
    public IFlutterViewContainer getContainer() {
        return this.mContainer;
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerRecord
    public int getState() {
        return this.mState;
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onCreate() {
        Utils.assertCallOnMainThread();
        if (this.mState != 0) {
            Debuger.exception("state error");
        }
        this.mState = 1;
        this.mProxy.create();
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onAppear() {
        Utils.assertCallOnMainThread();
        if (this.mState != 1 && this.mState != 3) {
            Debuger.exception("state error");
        }
        this.mState = 2;
        this.mManager.pushRecord(this);
        if (FlutterAttachSwitch.isOn()) {
            IContainerRecord peekShowRecord = this.mManager.peekShowRecord();
            if (peekShowRecord != null && this != peekShowRecord && peekShowRecord.getContainer().getBoostFlutterView().isAttachedToFlutterEngine()) {
                peekShowRecord.getContainer().getBoostFlutterView().onDetach();
            }
            if (this != peekShowRecord) {
                this.mManager.pushShowRecord(this);
            }
        }
        this.mProxy.appear();
        this.mContainer.getBoostFlutterView().onAttach();
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onDisappear() {
        Utils.assertCallOnMainThread();
        if (this.mState != 2) {
            Debuger.exception("state error");
        }
        this.mState = 3;
        this.mProxy.disappear();
        if (getContainer().getContextActivity().isFinishing()) {
            this.mProxy.destroy();
        }
        if (!FlutterAttachSwitch.isOn()) {
            this.mContainer.getBoostFlutterView().onDetach();
        }
        this.mManager.popRecord(this);
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onDestroy() {
        Utils.assertCallOnMainThread();
        if (this.mState != 3) {
            Debuger.exception("state error");
        }
        this.mState = 4;
        this.mProxy.destroy();
        if (FlutterAttachSwitch.isOn()) {
            this.mContainer.getBoostFlutterView().onDetach();
            if (this == this.mManager.peekShowRecord()) {
                this.mManager.popShowRecord();
            } else {
                this.mManager.removeShowRecord(this);
            }
            IContainerRecord peekShowRecord = this.mManager.peekShowRecord();
            if (peekShowRecord != null && !peekShowRecord.getContainer().getBoostFlutterView().isAttachedToFlutterEngine()) {
                peekShowRecord.getContainer().getBoostFlutterView().onAttach();
            }
        }
        this.mManager.removeRecord(this);
        this.mManager.setContainerResult(this, -1, -1, null);
        if (!this.mManager.hasContainerAppear()) {
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onBackPressed() {
        Utils.assertCallOnMainThread();
        if (this.mState == 0 || this.mState == 4) {
            Debuger.exception("state error");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "backPressedCallback");
        hashMap.put("name", this.mContainer.getContainerUrl());
        hashMap.put("uniqueId", this.mUniqueId);
        FlutterBoostPlugin channel = FlutterBoost.instance().channel();
        if (channel != null) {
            channel.sendEvent("lifecycle", hashMap);
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onNewIntent(Intent intent) {
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onContainerResult(int i, int i2, Map<String, Object> map) {
        this.mManager.setContainerResult(this, i, i2, map);
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onTrimMemory(int i) {
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onLowMemory() {
    }

    /* loaded from: classes6.dex */
    private class MethodChannelProxy {
        private int mState;

        private MethodChannelProxy() {
            this.mState = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void create() {
            if (this.mState == 0) {
                invokeChannelUnsafe("didInitPageContainer", ContainerRecord.this.mContainer.getContainerUrl(), ContainerRecord.this.mContainer.getContainerUrlParams(), ContainerRecord.this.mUniqueId);
                this.mState = 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appear() {
            invokeChannelUnsafe("didShowPageContainer", ContainerRecord.this.mContainer.getContainerUrl(), ContainerRecord.this.mContainer.getContainerUrlParams(), ContainerRecord.this.mUniqueId);
            this.mState = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void disappear() {
            if (this.mState < 3) {
                invokeChannel("didDisappearPageContainer", ContainerRecord.this.mContainer.getContainerUrl(), ContainerRecord.this.mContainer.getContainerUrlParams(), ContainerRecord.this.mUniqueId);
                this.mState = 3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            if (this.mState < 4) {
                invokeChannel("willDeallocPageContainer", ContainerRecord.this.mContainer.getContainerUrl(), ContainerRecord.this.mContainer.getContainerUrlParams(), ContainerRecord.this.mUniqueId);
                this.mState = 4;
            }
        }

        public void invokeChannel(String str, String str2, Map map, String str3) {
            HashMap hashMap = new HashMap();
            hashMap.put("pageName", str2);
            hashMap.put("params", map);
            hashMap.put("uniqueId", str3);
            FlutterBoostPlugin channel = FlutterBoost.instance().channel();
            if (channel != null) {
                channel.invokeMethod(str, hashMap);
            }
        }

        public void invokeChannelUnsafe(String str, String str2, Map map, String str3) {
            HashMap hashMap = new HashMap();
            hashMap.put("pageName", str2);
            hashMap.put("params", map);
            hashMap.put("uniqueId", str3);
            FlutterBoostPlugin channel = FlutterBoost.instance().channel();
            if (channel != null) {
                channel.invokeMethodUnsafe(str, hashMap);
            }
        }
    }

    public static String genUniqueId(Object obj) {
        return System.currentTimeMillis() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + obj.hashCode();
    }
}
