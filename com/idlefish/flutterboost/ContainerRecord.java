package com.idlefish.flutterboost;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.FlutterAttachSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class ContainerRecord implements IContainerRecord {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IFlutterViewContainer mContainer;
    public final long mCreatTime;
    public final FlutterViewContainerManager mManager;
    public MethodChannelProxy mProxy;
    public int mState;
    public final String mUniqueId;

    /* renamed from: com.idlefish.flutterboost.ContainerRecord$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public ContainerRecord(FlutterViewContainerManager flutterViewContainerManager, IFlutterViewContainer iFlutterViewContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterViewContainerManager, iFlutterViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mState = 0;
        this.mProxy = new MethodChannelProxy(this, null);
        Map<String, Object> containerUrlParams = iFlutterViewContainer.getContainerUrlParams();
        if (containerUrlParams != null && containerUrlParams.containsKey("__container_uniqueId_key__")) {
            this.mUniqueId = String.valueOf(containerUrlParams.get("__container_uniqueId_key__"));
        } else {
            this.mUniqueId = genUniqueId(this);
        }
        this.mManager = flutterViewContainerManager;
        this.mContainer = iFlutterViewContainer;
        this.mCreatTime = System.currentTimeMillis();
    }

    public static String genUniqueId(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            return System.currentTimeMillis() + "-" + obj.hashCode();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerRecord
    public long creatTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCreatTime : invokeV.longValue;
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerRecord
    public IFlutterViewContainer getContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContainer : (IFlutterViewContainer) invokeV.objValue;
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerRecord
    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mState : invokeV.intValue;
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onAppear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Utils.assertCallOnMainThread();
            int i2 = this.mState;
            if (i2 != 1 && i2 != 3) {
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
                this.mManager.logShowRecord();
            }
            this.mProxy.appear();
            this.mContainer.getBoostFlutterView().onAttach();
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Utils.assertCallOnMainThread();
            int i2 = this.mState;
            if (i2 == 0 || i2 == 4) {
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
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onContainerResult(int i2, int i3, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, map) == null) {
            this.mManager.setContainerResult(this, i2, i3, map);
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Utils.assertCallOnMainThread();
            if (this.mState != 0) {
                Debuger.exception("state error");
            }
            this.mState = 1;
            this.mProxy.create();
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Utils.assertCallOnMainThread();
            int i2 = this.mState;
            if (i2 != 3 && i2 != 1) {
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
                this.mManager.logShowRecord();
            }
            this.mManager.removeRecord(this);
            this.mManager.setContainerResult(this, -1, -1, null);
            this.mManager.hasContainerAppear();
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onDisappear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i2, strArr, iArr) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IOperateSyncer
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.interfaces.IContainerRecord
    public String uniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mUniqueId : (String) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public class MethodChannelProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mState;
        public final /* synthetic */ ContainerRecord this$0;

        public MethodChannelProxy(ContainerRecord containerRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {containerRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = containerRecord;
            this.mState = 0;
        }

        public final void appear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                invokeChannelUnsafe("didShowPageContainer", this.this$0.mContainer.getContainerUrl(), this.this$0.mContainer.getContainerUrlParams(), this.this$0.mUniqueId);
                this.mState = 2;
            }
        }

        public final void create() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mState == 0) {
                invokeChannelUnsafe("didInitPageContainer", this.this$0.mContainer.getContainerUrl(), this.this$0.mContainer.getContainerUrlParams(), this.this$0.mUniqueId);
                this.mState = 1;
            }
        }

        public final void destroy() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.mState >= 4) {
                return;
            }
            invokeChannel("willDeallocPageContainer", this.this$0.mContainer.getContainerUrl(), this.this$0.mContainer.getContainerUrlParams(), this.this$0.mUniqueId);
            this.mState = 4;
        }

        public final void disappear() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mState >= 3) {
                return;
            }
            invokeChannel("didDisappearPageContainer", this.this$0.mContainer.getContainerUrl(), this.this$0.mContainer.getContainerUrlParams(), this.this$0.mUniqueId);
            this.mState = 3;
        }

        public void invokeChannel(String str, String str2, Map map, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, map, str3) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pageName", str2);
                hashMap.put("params", map);
                hashMap.put("uniqueId", str3);
                FlutterBoostPlugin channel = FlutterBoost.instance().channel();
                if (channel != null) {
                    channel.invokeMethod(str, hashMap);
                }
            }
        }

        public void invokeChannelUnsafe(String str, String str2, Map map, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, map, str3) == null) {
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

        public /* synthetic */ MethodChannelProxy(ContainerRecord containerRecord, AnonymousClass1 anonymousClass1) {
            this(containerRecord);
        }
    }
}
