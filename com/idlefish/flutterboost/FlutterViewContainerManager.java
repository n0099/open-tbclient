package com.idlefish.flutterboost;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.switchs.FlutterCrabReportEnableSwitch;
import com.baidu.tieba.u.a;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
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
/* loaded from: classes19.dex */
public class FlutterViewContainerManager implements IContainerManager {
    private final Map<IFlutterViewContainer, IContainerRecord> mRecordMap = new LinkedHashMap();
    private final Set<ContainerRef> mRefs = new HashSet();
    private final Stack<IContainerRecord> mRecordStack = new Stack<>();
    public final Stack<IContainerRecord> mShowRecord = new Stack<>();
    private final Map<String, OnResult> mOnResults = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public interface OnResult {
        void onResult(Map<String, Object> map);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushShowRecord(IContainerRecord iContainerRecord) {
        this.mShowRecord.push(iContainerRecord);
    }

    public IContainerRecord peekShowRecord() {
        if (this.mShowRecord.isEmpty()) {
            return null;
        }
        return this.mShowRecord.peek();
    }

    public IContainerRecord popShowRecord() {
        if (this.mShowRecord.isEmpty()) {
            return null;
        }
        return this.mShowRecord.pop();
    }

    public void logShowRecord() {
        if (FlutterCrabReportEnableSwitch.isOn() && this.mShowRecord != null && this.mShowRecord.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mShowRecord.size()) {
                    IContainerRecord iContainerRecord = this.mShowRecord.get(i2);
                    if (iContainerRecord != null && iContainerRecord.getContainer() != null) {
                        stringBuffer.append("--" + iContainerRecord.getContainer().getContainerUrl() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + iContainerRecord.creatTime());
                    }
                    i = i2 + 1;
                } else {
                    a.getInstance().setOpenFlutterPage(stringBuffer.toString());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeShowRecord(IContainerRecord iContainerRecord) {
        this.mShowRecord.remove(iContainerRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushRecord(IContainerRecord iContainerRecord) {
        if (!this.mRecordMap.containsValue(iContainerRecord)) {
            Debuger.exception("invalid record!");
        }
        this.mRecordStack.push(iContainerRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popRecord(IContainerRecord iContainerRecord) {
        if (!this.mRecordStack.empty() && this.mRecordStack.peek() == iContainerRecord) {
            this.mRecordStack.pop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeRecord(IContainerRecord iContainerRecord) {
        this.mRecordStack.remove(iContainerRecord);
        this.mRecordMap.remove(iContainerRecord.getContainer());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContainerResult(IContainerRecord iContainerRecord, int i, int i2, Map<String, Object> map) {
        if (findContainerById(iContainerRecord.uniqueId()) == null) {
            Debuger.exception("setContainerResult error, url=" + iContainerRecord.getContainer().getContainerUrl());
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("_requestCode__", Integer.valueOf(i));
        map.put("_resultCode__", Integer.valueOf(i2));
        OnResult remove = this.mOnResults.remove(iContainerRecord.uniqueId());
        if (remove != null) {
            remove.onResult(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openContainer(String str, Map<String, Object> map, Map<String, Object> map2, OnResult onResult) {
        Context currentActivity = FlutterBoost.instance().currentActivity();
        if (currentActivity == null) {
            currentActivity = FlutterBoost.instance().platform().getApplication();
        }
        Map<String, Object> hashMap = map == null ? new HashMap<>() : map;
        int i = 0;
        Object remove = hashMap.remove(GroupInfoActivityConfig.REQUEST_CODE);
        if (remove != null) {
            i = Integer.valueOf(String.valueOf(remove)).intValue();
        }
        hashMap.put("__container_uniqueId_key__", ContainerRecord.genUniqueId(str));
        IContainerRecord currentTopRecord = getCurrentTopRecord();
        if (onResult != null && currentTopRecord != null) {
            this.mOnResults.put(currentTopRecord.uniqueId(), onResult);
        }
        FlutterBoost.instance().platform().openContainer(currentActivity, str, hashMap, i, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onShownContainerChanged(String str, String str2) {
        IFlutterViewContainer iFlutterViewContainer;
        Utils.assertCallOnMainThread();
        Iterator<Map.Entry<IFlutterViewContainer, IContainerRecord>> it = this.mRecordMap.entrySet().iterator();
        IFlutterViewContainer iFlutterViewContainer2 = null;
        IFlutterViewContainer iFlutterViewContainer3 = null;
        while (true) {
            if (!it.hasNext()) {
                iFlutterViewContainer = iFlutterViewContainer2;
                break;
            }
            Map.Entry<IFlutterViewContainer, IContainerRecord> next = it.next();
            if (TextUtils.equals(str, next.getValue().uniqueId())) {
                iFlutterViewContainer3 = next.getKey();
            }
            iFlutterViewContainer = TextUtils.equals(str2, next.getValue().uniqueId()) ? next.getKey() : iFlutterViewContainer2;
            if (iFlutterViewContainer3 != null && iFlutterViewContainer != null) {
                break;
            }
            iFlutterViewContainer2 = iFlutterViewContainer;
        }
        if (iFlutterViewContainer != null) {
            iFlutterViewContainer.onContainerShown();
        }
        if (iFlutterViewContainer3 != null) {
            iFlutterViewContainer3.onContainerHidden();
        }
    }

    public boolean hasContainerAppear() {
        for (Map.Entry<IFlutterViewContainer, IContainerRecord> entry : this.mRecordMap.entrySet()) {
            if (entry.getValue().getState() == 2) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes19.dex */
    public static class ContainerRef {
        public final WeakReference<IFlutterViewContainer> container;
        public final String uniqueId;

        ContainerRef(String str, IFlutterViewContainer iFlutterViewContainer) {
            this.uniqueId = str;
            this.container = new WeakReference<>(iFlutterViewContainer);
        }
    }
}
