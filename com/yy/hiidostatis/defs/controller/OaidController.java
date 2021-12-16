package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.core.JLibrary;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.supplier.IdSupplier;
import com.google.android.material.internal.ManufacturerUtils;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class OaidController {
    public static final /* synthetic */ OaidController[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final OaidController INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public OaidHelper oaidHelper;

    /* renamed from: com.yy.hiidostatis.defs.controller.OaidController$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public interface OaidInitListener {
        void initFinish(boolean z, String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1410972653, "Lcom/yy/hiidostatis/defs/controller/OaidController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1410972653, "Lcom/yy/hiidostatis/defs/controller/OaidController;");
                return;
            }
        }
        OaidController oaidController = new OaidController("INSTANCE", 0);
        INSTANCE = oaidController;
        $VALUES = new OaidController[]{oaidController};
    }

    public OaidController(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oaidHelper = new OaidHelper(this, null);
    }

    public static boolean ignore(Context context) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                str = ArdUtil.getSjp(context);
            } catch (Throwable th) {
                th.printStackTrace();
                str = null;
            }
            return (str != null && (str.trim().equalsIgnoreCase(ManufacturerUtils.SAMSUNG) || str.trim().equalsIgnoreCase("YUFLY"))) || Build.VERSION.SDK_INT < 28;
        }
        return invokeL.booleanValue;
    }

    public static void loadLib(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            try {
                if (ignore(context)) {
                    return;
                }
                JLibrary.InitEntry(context);
            } catch (Throwable unused) {
            }
        }
    }

    public static OaidController valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (OaidController) Enum.valueOf(OaidController.class, str) : (OaidController) invokeL.objValue;
    }

    public static OaidController[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (OaidController[]) $VALUES.clone() : (OaidController[]) invokeV.objValue;
    }

    public void addListener(OaidInitListener oaidInitListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oaidInitListener) == null) {
            this.oaidHelper.addListener(oaidInitListener);
        }
    }

    public void initOaidAsyn(Context context, OaidInitListener oaidInitListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, oaidInitListener) == null) {
            this.oaidHelper.initOaid(context, oaidInitListener);
        }
    }

    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.oaidHelper.isInit() : invokeV.booleanValue;
    }

    public String oaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.oaidHelper.getOaid() : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public final class OaidHelper {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long TIME_OUT = 20000;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int beginTime;
        public volatile boolean init;
        public List<OaidInitListener> listeners;
        public volatile String oaid;
        public final /* synthetic */ OaidController this$0;

        public OaidHelper(OaidController oaidController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oaidController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = oaidController;
            this.listeners = new ArrayList();
            this.oaid = "";
        }

        private int callFromReflect(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, context)) == null) ? MdidSdkHelper.InitSdk(context, true, new IIdentifierListener(this) { // from class: com.yy.hiidostatis.defs.controller.OaidController.OaidHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OaidHelper this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                public void OnSupport(boolean z, IdSupplier idSupplier) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, idSupplier) == null) {
                        try {
                            if (idSupplier == null) {
                                this.this$1.initFinish(false, "", "获取OAID失败");
                                if (idSupplier != null) {
                                    try {
                                        idSupplier.shutDown();
                                        return;
                                    } catch (Throwable th) {
                                        L.debug(this, th.getMessage(), new Object[0]);
                                        return;
                                    }
                                }
                                return;
                            }
                            this.this$1.initFinish(true, idSupplier.getOAID(), null);
                            if (idSupplier != null) {
                                try {
                                    idSupplier.shutDown();
                                } catch (Throwable th2) {
                                    L.debug(this, th2.getMessage(), new Object[0]);
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                L.debug(this, th3.getMessage(), new Object[0]);
                                this.this$1.initFinish(false, "", "获取OAID失败");
                                if (idSupplier != null) {
                                    try {
                                        idSupplier.shutDown();
                                    } catch (Throwable th4) {
                                        L.debug(this, th4.getMessage(), new Object[0]);
                                    }
                                }
                            } catch (Throwable th5) {
                                if (idSupplier != null) {
                                    try {
                                        idSupplier.shutDown();
                                    } catch (Throwable th6) {
                                        L.debug(this, th6.getMessage(), new Object[0]);
                                    }
                                }
                                throw th5;
                            }
                        }
                    }
                }
            }) : invokeL.intValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void initFinish(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                synchronized (this) {
                    boolean z2 = true;
                    if (this.init) {
                        if (z && ((this.oaid == null || this.oaid.isEmpty()) && str != null && !str.isEmpty())) {
                            this.oaid = str;
                        }
                        if (!z || str == null || str.isEmpty()) {
                            z2 = false;
                        }
                        noticeListener(z2, str, str2);
                        return;
                    }
                    if (str2 != null) {
                        str2.isEmpty();
                    }
                    this.init = true;
                    this.oaid = str;
                    if (!z || str == null || str.isEmpty()) {
                        z2 = false;
                    }
                    noticeListener(z2, str, str2);
                }
            }
        }

        private synchronized void noticeListener(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                synchronized (this) {
                    for (OaidInitListener oaidInitListener : this.listeners) {
                        oaidInitListener.initFinish(z, str, str2);
                    }
                    this.listeners.clear();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, this) == null) {
                ThreadPool.getPool().execute(new Runnable(this) { // from class: com.yy.hiidostatis.defs.controller.OaidController.OaidHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OaidHelper this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                            if (currentTimeMillis - this.this$1.beginTime >= 20 || currentTimeMillis - this.this$1.beginTime <= 0) {
                                if (this.this$1.init) {
                                    return;
                                }
                                this.this$1.initFinish(false, "", "获取OAID超时");
                                return;
                            }
                            String str = "定时器时间错误:" + this.this$1.beginTime + "-" + currentTimeMillis + "-" + (currentTimeMillis - this.this$1.beginTime);
                            this.this$1.timeOut();
                        }
                    }
                }, 20000L);
            }
        }

        public synchronized void addListener(OaidInitListener oaidInitListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oaidInitListener) == null) {
                synchronized (this) {
                    if (this.init) {
                        if (this.oaid != null && !this.oaid.isEmpty()) {
                            oaidInitListener.initFinish(true, this.oaid, null);
                        } else {
                            oaidInitListener.initFinish(false, "", null);
                        }
                        return;
                    }
                    this.listeners.add(oaidInitListener);
                }
            }
        }

        public String getOaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.oaid == null ? "" : this.oaid : (String) invokeV.objValue;
        }

        public void initOaid(Context context, OaidInitListener oaidInitListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, oaidInitListener) == null) {
                try {
                    if (OaidController.ignore(context)) {
                        this.init = true;
                        noticeListener(false, "", "ignore sjm");
                        return;
                    }
                    this.beginTime = (int) (System.currentTimeMillis() / 1000);
                    addListener(oaidInitListener);
                    timeOut();
                    int callFromReflect = callFromReflect(context);
                    if (callFromReflect == 1008612) {
                        throw new Exception("不支持的设备");
                    }
                    if (callFromReflect == 1008613) {
                        throw new Exception("加载配置文件出错");
                    }
                    if (callFromReflect == 1008611) {
                        throw new Exception("不支持的设备厂商");
                    }
                    if (callFromReflect != 1008614 && callFromReflect == 1008615) {
                        throw new Exception("反射调用出错");
                    }
                } catch (Throwable th) {
                    initFinish(false, "", th.getMessage());
                }
            }
        }

        public boolean isInit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.init : invokeV.booleanValue;
        }

        public /* synthetic */ OaidHelper(OaidController oaidController, AnonymousClass1 anonymousClass1) {
            this(oaidController);
        }
    }
}
