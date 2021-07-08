package com.yy.hiidostatis.defs.monitor;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ScreenMonitor {
    public static final /* synthetic */ ScreenMonitor[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ScreenMonitor instance;
    public transient /* synthetic */ FieldHolder $fh;
    public int click;
    public long lastClickTime;
    public int slide;
    public float x1;
    public float x2;
    public float y1;
    public float y2;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-750602192, "Lcom/yy/hiidostatis/defs/monitor/ScreenMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-750602192, "Lcom/yy/hiidostatis/defs/monitor/ScreenMonitor;");
                return;
            }
        }
        ScreenMonitor screenMonitor = new ScreenMonitor(Transition.MATCH_INSTANCE_STR, 0);
        instance = screenMonitor;
        $VALUES = new ScreenMonitor[]{screenMonitor};
    }

    public ScreenMonitor(String str, int i2) {
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
        this.x1 = 0.0f;
        this.x2 = 0.0f;
        this.y1 = 0.0f;
        this.y2 = 0.0f;
        this.slide = 0;
        this.click = 0;
        this.lastClickTime = 0L;
    }

    private void clickCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.lastClickTime;
            if (j == 0 || currentTimeMillis - j > 200) {
                this.click++;
            }
            this.lastClickTime = currentTimeMillis;
        }
    }

    private void slideCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.slide++;
        }
    }

    public static ScreenMonitor valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (ScreenMonitor) Enum.valueOf(ScreenMonitor.class, str) : (ScreenMonitor) invokeL.objValue;
    }

    public static ScreenMonitor[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (ScreenMonitor[]) $VALUES.clone() : (ScreenMonitor[]) invokeV.objValue;
    }

    public int getClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.click : invokeV.intValue;
    }

    public int getSlide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.slide : invokeV.intValue;
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
            if (motionEvent.getAction() == 0) {
                clickCount();
                this.x1 = motionEvent.getX();
                this.y1 = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                this.x2 = motionEvent.getX();
                float y = motionEvent.getY();
                this.y2 = y;
                float f2 = this.y1;
                if (f2 - y > 50.0f) {
                    slideCount();
                } else if (y - f2 > 50.0f) {
                    slideCount();
                } else {
                    float f3 = this.x1;
                    float f4 = this.x2;
                    if (f3 - f4 > 50.0f) {
                        slideCount();
                    } else if (f4 - f3 > 50.0f) {
                        slideCount();
                    }
                }
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.slide = 0;
            this.click = 0;
        }
    }
}
