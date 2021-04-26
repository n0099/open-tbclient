package com.idlefish.flutterboost;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.switchs.FlutterCrabReportEnableSwitch;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import d.a.j0.i3.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
/* loaded from: classes6.dex */
public class FlutterViewContainerManager implements IContainerManager {
    public final Map<IFlutterViewContainer, IContainerRecord> mRecordMap = new LinkedHashMap();
    public final Set<ContainerRef> mRefs = new HashSet();
    public final Stack<IContainerRecord> mRecordStack = new Stack<>();
    public final Stack<IContainerRecord> mShowRecord = new Stack<>();
    public final Map<String, OnResult> mOnResults = new HashMap();

    /* loaded from: classes6.dex */
    public static class ContainerRef {
        public final WeakReference<IFlutterViewContainer> container;
        public final String uniqueId;

        public ContainerRef(String str, IFlutterViewContainer iFlutterViewContainer) {
            this.uniqueId = str;
            this.container = new WeakReference<>(iFlutterViewContainer);
        }
    }

    /* loaded from: classes6.dex */
    public interface OnResult {
        void onResult(Map<String, Object> map);
    }

    public IContainerRecord closeContainer(String str, Map<String, Object> map, Map<String, Object> map2) {
        IContainerRecord iContainerRecord;
        Iterator<Map.Entry<IFlutterViewContainer, IContainerRecord>> it = this.mRecordMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                iContainerRecord = null;
                break;
            }
            Map.Entry<IFlutterViewContainer, IContainerRecord> next = it.next();
            if (TextUtils.equals(str, next.getValue().uniqueId())) {
                iContainerRecord = next.getValue();
                break;
            }
        }
        if (iContainerRecord == null) {
            Debuger.exception("closeContainer can not find uniqueId:" + str);
        }
        FlutterBoost.instance().platform().closeContainer(iContainerRecord, map, map2);
        return iContainerRecord;
    }

    public IFlutterViewContainer findContainerById(String str) {
        IFlutterViewContainer iFlutterViewContainer;
        Iterator<Map.Entry<IFlutterViewContainer, IContainerRecord>> it = this.mRecordMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                iFlutterViewContainer = null;
                break;
            }
            Map.Entry<IFlutterViewContainer, IContainerRecord> next = it.next();
            if (TextUtils.equals(str, next.getValue().uniqueId())) {
                iFlutterViewContainer = next.getKey();
                break;
            }
        }
        if (iFlutterViewContainer == null) {
            for (ContainerRef containerRef : this.mRefs) {
                if (TextUtils.equals(str, containerRef.uniqueId)) {
                    return containerRef.container.get();
                }
            }
        }
        return iFlutterViewContainer;
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerManager
    public IOperateSyncer generateSyncer(IFlutterViewContainer iFlutterViewContainer) {
        Utils.assertCallOnMainThread();
        ContainerRecord containerRecord = new ContainerRecord(this, iFlutterViewContainer);
        if (this.mRecordMap.put(iFlutterViewContainer, containerRecord) != null) {
            Debuger.exception("container:" + iFlutterViewContainer.getContainerUrl() + " already exists!");
        }
        this.mRefs.add(new ContainerRef(containerRecord.uniqueId(), iFlutterViewContainer));
        return containerRecord;
    }

    public IContainerRecord getCurrentTopRecord() {
        if (this.mRecordStack.isEmpty()) {
            return null;
        }
        return this.mRecordStack.peek();
    }

    public IContainerRecord getLastGenerateRecord() {
        Collection<IContainerRecord> values = this.mRecordMap.values();
        if (values.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(values);
        return (IContainerRecord) arrayList.get(arrayList.size() - 1);
    }

    public boolean hasContainerAppear() {
        for (Map.Entry<IFlutterViewContainer, IContainerRecord> entry : this.mRecordMap.entrySet()) {
            if (entry.getValue().getState() == 2) {
                return true;
            }
        }
        return false;
    }

    public void logShowRecord() {
        Stack<IContainerRecord> stack;
        if (!FlutterCrabReportEnableSwitch.isOn() || (stack = this.mShowRecord) == null || stack.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.mShowRecord.size(); i2++) {
            IContainerRecord iContainerRecord = this.mShowRecord.get(i2);
            if (iContainerRecord != null && iContainerRecord.getContainer() != null) {
                stringBuffer.append("--" + iContainerRecord.getContainer().getContainerUrl() + "_" + iContainerRecord.creatTime());
            }
        }
        a.getInstance().setOpenFlutterPage(stringBuffer.toString());
    }

    public void onShownContainerChanged(String str, String str2) {
        Utils.assertCallOnMainThread();
        IFlutterViewContainer iFlutterViewContainer = null;
        IFlutterViewContainer iFlutterViewContainer2 = null;
        for (Map.Entry<IFlutterViewContainer, IContainerRecord> entry : this.mRecordMap.entrySet()) {
            if (TextUtils.equals(str, entry.getValue().uniqueId())) {
                iFlutterViewContainer = entry.getKey();
            }
            if (TextUtils.equals(str2, entry.getValue().uniqueId())) {
                iFlutterViewContainer2 = entry.getKey();
            }
            if (iFlutterViewContainer != null && iFlutterViewContainer2 != null) {
                break;
            }
        }
        if (iFlutterViewContainer2 != null) {
            iFlutterViewContainer2.onContainerShown();
        }
        if (iFlutterViewContainer != null) {
            iFlutterViewContainer.onContainerHidden();
        }
    }

    public void openContainer(String str, Map<String, Object> map, Map<String, Object> map2, OnResult onResult) {
        Context currentActivity = FlutterBoost.instance().currentActivity();
        if (currentActivity == null) {
            currentActivity = FlutterBoost.instance().platform().getApplication();
        }
        Context context = currentActivity;
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> map3 = map;
        Object remove = map3.remove("requestCode");
        int intValue = remove != null ? Integer.valueOf(String.valueOf(remove)).intValue() : 0;
        map3.put("__container_uniqueId_key__", ContainerRecord.genUniqueId(str));
        IContainerRecord currentTopRecord = getCurrentTopRecord();
        if (onResult != null && currentTopRecord != null) {
            this.mOnResults.put(currentTopRecord.uniqueId(), onResult);
        }
        FlutterBoost.instance().platform().openContainer(context, str, map3, intValue, map2);
    }

    public IContainerRecord peekShowRecord() {
        if (this.mShowRecord.isEmpty()) {
            return null;
        }
        return this.mShowRecord.peek();
    }

    public void popRecord(IContainerRecord iContainerRecord) {
        if (!this.mRecordStack.empty() && this.mRecordStack.peek() == iContainerRecord) {
            this.mRecordStack.pop();
        }
    }

    public IContainerRecord popShowRecord() {
        if (this.mShowRecord.isEmpty()) {
            return null;
        }
        return this.mShowRecord.pop();
    }

    public void pushRecord(IContainerRecord iContainerRecord) {
        if (!this.mRecordMap.containsValue(iContainerRecord)) {
            Debuger.exception("invalid record!");
        }
        this.mRecordStack.push(iContainerRecord);
    }

    public void pushShowRecord(IContainerRecord iContainerRecord) {
        this.mShowRecord.push(iContainerRecord);
    }

    public void removeRecord(IContainerRecord iContainerRecord) {
        this.mRecordStack.remove(iContainerRecord);
        this.mRecordMap.remove(iContainerRecord.getContainer());
    }

    public void removeShowRecord(IContainerRecord iContainerRecord) {
        this.mShowRecord.remove(iContainerRecord);
    }

    public void setContainerResult(IContainerRecord iContainerRecord, int i2, int i3, Map<String, Object> map) {
        if (findContainerById(iContainerRecord.uniqueId()) == null) {
            Debuger.exception("setContainerResult error, url=" + iContainerRecord.getContainer().getContainerUrl());
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("_requestCode__", Integer.valueOf(i2));
        map.put("_resultCode__", Integer.valueOf(i3));
        OnResult remove = this.mOnResults.remove(iContainerRecord.uniqueId());
        if (remove != null) {
            remove.onResult(map);
        }
    }
}
