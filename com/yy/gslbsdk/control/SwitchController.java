package com.yy.gslbsdk.control;

import android.preference.PreferenceManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class SwitchController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HTTPS_LEVEL_CLOSE_SWITCH = -1;
    public static final int HTTPS_LEVEL_OPEN_SWITCH = 1;
    public static final String SHARED_KEY = "gslb_switch";
    public static final int SWITCH_CLOSE = -1;
    public static final int SWITCH_OPEN = 1;
    public static final int SWITCH_UNKNOWN = 0;
    public static final String TAG = "SwitchController";
    public static SwitchController sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean mInit;
    public AtomicInteger mSwitchCache;
    public AtomicInteger mSwitchHttp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-378544339, "Lcom/yy/gslbsdk/control/SwitchController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-378544339, "Lcom/yy/gslbsdk/control/SwitchController;");
        }
    }

    public SwitchController() {
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
        this.mSwitchCache = new AtomicInteger(0);
        this.mSwitchHttp = new AtomicInteger(0);
        this.mInit = new AtomicBoolean(false);
    }

    public static SwitchController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new SwitchController();
            }
            return sInstance;
        }
        return (SwitchController) invokeV.objValue;
    }

    private boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mInit.get()) {
                return true;
            }
            synchronized (this.mInit) {
                if (this.mInit.get()) {
                    return true;
                }
                if (readCache()) {
                    this.mInit.set(true);
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean readCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                int i2 = PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT).getInt(SHARED_KEY, 1);
                if (i2 == 0 || i2 == 1 || i2 == -1) {
                    this.mSwitchCache.compareAndSet(0, i2);
                    return true;
                }
                LogTools.printWarning(TAG, String.format(Locale.US, "SwitchController readCache, switchCache is illegal. switchCache: %d", Integer.valueOf(i2)));
                return false;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean writeCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i2 = this.mSwitchHttp.get();
            if (i2 != 0 && i2 != 1 && i2 != -1) {
                LogTools.printWarning(TAG, String.format(Locale.US, "SwitchController writeCache, switchHttp is illegal. switchCache: %d", Integer.valueOf(i2)));
                return false;
            } else if (i2 == 0) {
                return false;
            } else {
                try {
                    PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT).edit().putInt(SHARED_KEY, i2).apply();
                    return true;
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public boolean deal(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == -1) {
                this.mSwitchHttp.compareAndSet(0, -1);
            } else {
                this.mSwitchHttp.compareAndSet(0, 1);
            }
            return writeCache();
        }
        return invokeI.booleanValue;
    }

    public boolean switchGslb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (init()) {
                int i2 = this.mSwitchHttp.get();
                int i3 = this.mSwitchCache.get();
                return i2 != 0 ? i2 == 1 : i3 == 0 || i3 == 1;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
