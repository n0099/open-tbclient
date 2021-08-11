package com.idlefish.flutterboost;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.n3.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.FlutterCrabReportEnableSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public class FlutterViewContainerManager implements IContainerManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, OnResult> mOnResults;
    public final Map<IFlutterViewContainer, IContainerRecord> mRecordMap;
    public final Stack<IContainerRecord> mRecordStack;
    public final Set<ContainerRef> mRefs;
    public final Stack<IContainerRecord> mShowRecord;

    /* loaded from: classes10.dex */
    public static class ContainerRef {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<IFlutterViewContainer> container;
        public final String uniqueId;

        public ContainerRef(String str, IFlutterViewContainer iFlutterViewContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, iFlutterViewContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uniqueId = str;
            this.container = new WeakReference<>(iFlutterViewContainer);
        }
    }

    /* loaded from: classes10.dex */
    public interface OnResult {
        void onResult(Map<String, Object> map);
    }

    public FlutterViewContainerManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRecordMap = new LinkedHashMap();
        this.mRefs = new HashSet();
        this.mRecordStack = new Stack<>();
        this.mShowRecord = new Stack<>();
        this.mOnResults = new HashMap();
    }

    public IContainerRecord closeContainer(String str, Map<String, Object> map, Map<String, Object> map2) {
        InterceptResult invokeLLL;
        IContainerRecord iContainerRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, map, map2)) == null) {
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
        return (IContainerRecord) invokeLLL.objValue;
    }

    public IFlutterViewContainer findContainerById(String str) {
        InterceptResult invokeL;
        IFlutterViewContainer iFlutterViewContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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
        return (IFlutterViewContainer) invokeL.objValue;
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerManager
    public IOperateSyncer generateSyncer(IFlutterViewContainer iFlutterViewContainer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iFlutterViewContainer)) == null) {
            Utils.assertCallOnMainThread();
            ContainerRecord containerRecord = new ContainerRecord(this, iFlutterViewContainer);
            if (this.mRecordMap.put(iFlutterViewContainer, containerRecord) != null) {
                Debuger.exception("container:" + iFlutterViewContainer.getContainerUrl() + " already exists!");
            }
            this.mRefs.add(new ContainerRef(containerRecord.uniqueId(), iFlutterViewContainer));
            return containerRecord;
        }
        return (IOperateSyncer) invokeL.objValue;
    }

    public IContainerRecord getCurrentTopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mRecordStack.isEmpty()) {
                return null;
            }
            return this.mRecordStack.peek();
        }
        return (IContainerRecord) invokeV.objValue;
    }

    public IContainerRecord getLastGenerateRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Collection<IContainerRecord> values = this.mRecordMap.values();
            if (values.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(values);
            return (IContainerRecord) arrayList.get(arrayList.size() - 1);
        }
        return (IContainerRecord) invokeV.objValue;
    }

    public boolean hasContainerAppear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            for (Map.Entry<IFlutterViewContainer, IContainerRecord> entry : this.mRecordMap.entrySet()) {
                if (entry.getValue().getState() == 2) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void logShowRecord() {
        Stack<IContainerRecord> stack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || !FlutterCrabReportEnableSwitch.isOn() || (stack = this.mShowRecord) == null || stack.size() <= 0) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
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
    }

    public void openContainer(String str, Map<String, Object> map, Map<String, Object> map2, OnResult onResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, map, map2, onResult) == null) {
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
    }

    public IContainerRecord peekShowRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mShowRecord.isEmpty()) {
                return null;
            }
            return this.mShowRecord.peek();
        }
        return (IContainerRecord) invokeV.objValue;
    }

    public void popRecord(IContainerRecord iContainerRecord) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, iContainerRecord) == null) && !this.mRecordStack.empty() && this.mRecordStack.peek() == iContainerRecord) {
            this.mRecordStack.pop();
        }
    }

    public IContainerRecord popShowRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mShowRecord.isEmpty()) {
                return null;
            }
            return this.mShowRecord.pop();
        }
        return (IContainerRecord) invokeV.objValue;
    }

    public void pushRecord(IContainerRecord iContainerRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iContainerRecord) == null) {
            if (!this.mRecordMap.containsValue(iContainerRecord)) {
                Debuger.exception("invalid record!");
            }
            this.mRecordStack.push(iContainerRecord);
        }
    }

    public void pushShowRecord(IContainerRecord iContainerRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iContainerRecord) == null) {
            this.mShowRecord.push(iContainerRecord);
        }
    }

    public void removeRecord(IContainerRecord iContainerRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iContainerRecord) == null) {
            this.mRecordStack.remove(iContainerRecord);
            this.mRecordMap.remove(iContainerRecord.getContainer());
        }
    }

    public void removeShowRecord(IContainerRecord iContainerRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iContainerRecord) == null) {
            this.mShowRecord.remove(iContainerRecord);
        }
    }

    public void setContainerResult(IContainerRecord iContainerRecord, int i2, int i3, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{iContainerRecord, Integer.valueOf(i2), Integer.valueOf(i3), map}) == null) {
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
}
