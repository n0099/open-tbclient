package com.kwai.player;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KwaiDisplayHdrCapabilitiesDetector {
    public static /* synthetic */ Interceptable $ic;
    public static KwaiDisplayHdrCapabilitiesDetector sHdrCapabilitiesUtil;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public float mDesiredMaxAverageLuminance;
    public float mDesiredMaxLuminance;
    public float mDesiredMinLuminance;
    public DisplayManager mDisplayManager;
    public Display.HdrCapabilities mHdrCapabilities;
    public String mHdrTypes;
    public boolean misInited;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(477394986, "Lcom/kwai/player/KwaiDisplayHdrCapabilitiesDetector;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(477394986, "Lcom/kwai/player/KwaiDisplayHdrCapabilitiesDetector;");
        }
    }

    public KwaiDisplayHdrCapabilitiesDetector() {
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
        this.mHdrTypes = "";
        this.misInited = false;
    }

    public static synchronized KwaiDisplayHdrCapabilitiesDetector getInstance() {
        InterceptResult invokeV;
        KwaiDisplayHdrCapabilitiesDetector kwaiDisplayHdrCapabilitiesDetector;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (KwaiDisplayHdrCapabilitiesDetector.class) {
                if (sHdrCapabilitiesUtil == null) {
                    sHdrCapabilitiesUtil = new KwaiDisplayHdrCapabilitiesDetector();
                }
                kwaiDisplayHdrCapabilitiesDetector = sHdrCapabilitiesUtil;
            }
            return kwaiDisplayHdrCapabilitiesDetector;
        }
        return (KwaiDisplayHdrCapabilitiesDetector) invokeV.objValue;
    }

    public String getHdrCapabilitiesTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHdrTypes : (String) invokeV.objValue;
    }

    public float getHdrMaxAverageLuminance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDesiredMaxAverageLuminance : invokeV.floatValue;
    }

    public float getHdrMaxLuminance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDesiredMaxLuminance : invokeV.floatValue;
    }

    public float getHdrMinLuminance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDesiredMinLuminance : invokeV.floatValue;
    }

    @RequiresApi(api = 24)
    public synchronized void init(Context context) {
        int[] supportedHdrTypes;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            synchronized (this) {
                if (this.misInited) {
                    return;
                }
                this.mContext = context;
                DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
                this.mDisplayManager = displayManager;
                Display.HdrCapabilities hdrCapabilities = displayManager.getDisplay(0).getHdrCapabilities();
                this.mHdrCapabilities = hdrCapabilities;
                for (int i2 : hdrCapabilities.getSupportedHdrTypes()) {
                    if (i2 == 1) {
                        str = this.mHdrTypes + "HDR_TYPE_DOLBY_VISION,";
                    } else if (i2 == 2) {
                        str = this.mHdrTypes + "HDR_TYPE_HDR10,";
                    } else if (i2 == 3) {
                        str = this.mHdrTypes + "HDR_TYPE_HLG";
                    }
                    this.mHdrTypes = str;
                }
                this.mDesiredMaxAverageLuminance = this.mHdrCapabilities.getDesiredMaxAverageLuminance();
                this.mDesiredMaxLuminance = this.mHdrCapabilities.getDesiredMaxLuminance();
                this.mDesiredMinLuminance = this.mHdrCapabilities.getDesiredMinLuminance();
                this.misInited = true;
            }
        }
    }
}
