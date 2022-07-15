package com.repackage;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public final class az2 extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public final float b;
    public final WheelView3d c;

    public az2(WheelView3d wheelView3d, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = wheelView3d;
        this.b = f;
        this.a = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == 2.1474836E9f) {
                if (Math.abs(this.b) > 2000.0f) {
                    this.a = this.b <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.a = this.b;
                }
            }
            if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
                this.c.b();
                this.c.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView3d wheelView3d = this.c;
            float f = (int) (this.a / 100.0f);
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f);
            if (!this.c.i()) {
                float itemHeight = this.c.getItemHeight();
                float f2 = (-this.c.getInitPosition()) * itemHeight;
                float itemsCount = ((this.c.getItemsCount() - 1) - this.c.getInitPosition()) * itemHeight;
                double d = itemHeight * 0.25d;
                if (this.c.getTotalScrollY() - d < f2) {
                    f2 = this.c.getTotalScrollY() + f;
                } else if (this.c.getTotalScrollY() + d > itemsCount) {
                    itemsCount = this.c.getTotalScrollY() + f;
                }
                if (this.c.getTotalScrollY() <= f2) {
                    this.a = 40.0f;
                    this.c.setTotalScrollY((int) f2);
                } else if (this.c.getTotalScrollY() >= itemsCount) {
                    this.c.setTotalScrollY((int) itemsCount);
                    this.a = -40.0f;
                }
            }
            float f3 = this.a;
            if (f3 < 0.0f) {
                this.a = f3 + 20.0f;
            } else {
                this.a = f3 - 20.0f;
            }
            this.c.getHandler().sendEmptyMessage(1000);
        }
    }
}
