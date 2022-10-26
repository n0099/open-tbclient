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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSwitchCache = new AtomicInteger(0);
        this.mSwitchHttp = new AtomicInteger(0);
        this.mInit = new AtomicBoolean(false);
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
                if (!readCache()) {
                    return false;
                }
                this.mInit.set(true);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean switchGslb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!init()) {
                return true;
            }
            int i = this.mSwitchHttp.get();
            int i2 = this.mSwitchCache.get();
            if (i != 0) {
                if (i == 1) {
                    return true;
                }
                return false;
            } else if (i2 == 0 || i2 == 1) {
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
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

    private boolean readCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                int i = PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT).getInt(SHARED_KEY, 1);
                if (i != 0 && i != 1 && i != -1) {
                    LogTools.printWarning(TAG, String.format(Locale.US, "SwitchController readCache, switchCache is illegal. switchCache: %d", Integer.valueOf(i)));
                    return false;
                }
                this.mSwitchCache.compareAndSet(0, i);
                return true;
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean writeCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i = this.mSwitchHttp.get();
            if (i != 0 && i != 1 && i != -1) {
                LogTools.printWarning(TAG, String.format(Locale.US, "SwitchController writeCache, switchHttp is illegal. switchCache: %d", Integer.valueOf(i)));
                return false;
            } else if (i == 0) {
                return false;
            } else {
                try {
                    PreferenceManager.getDefaultSharedPreferences(GlobalTools.APP_CONTEXT).edit().putInt(SHARED_KEY, i).apply();
                    return true;
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public boolean deal(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == -1) {
                this.mSwitchHttp.compareAndSet(0, -1);
            } else {
                this.mSwitchHttp.compareAndSet(0, 1);
            }
            return writeCache();
        }
        return invokeI.booleanValue;
    }
}
