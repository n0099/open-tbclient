package d.a.r0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public final class a extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f55109e;

    /* renamed from: f  reason: collision with root package name */
    public final float f55110f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f55111g;

    public a(WheelView wheelView, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView, Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55111g = wheelView;
        this.f55110f = f2;
        this.f55109e = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f55109e == 2.1474836E9f) {
                if (Math.abs(this.f55110f) > 2000.0f) {
                    this.f55109e = this.f55110f <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.f55109e = this.f55110f;
                }
            }
            if (Math.abs(this.f55109e) >= 0.0f && Math.abs(this.f55109e) <= 20.0f) {
                this.f55111g.b();
                this.f55111g.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView wheelView = this.f55111g;
            float f2 = (int) (this.f55109e / 100.0f);
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.f55111g.i()) {
                float itemHeight = this.f55111g.getItemHeight();
                float f3 = (-this.f55111g.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f55111g.getItemsCount() - 1) - this.f55111g.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f55111g.getTotalScrollY() - d2 < f3) {
                    f3 = this.f55111g.getTotalScrollY() + f2;
                } else if (this.f55111g.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f55111g.getTotalScrollY() + f2;
                }
                if (this.f55111g.getTotalScrollY() <= f3) {
                    this.f55109e = 40.0f;
                    this.f55111g.setTotalScrollY((int) f3);
                } else if (this.f55111g.getTotalScrollY() >= itemsCount) {
                    this.f55111g.setTotalScrollY((int) itemsCount);
                    this.f55109e = -40.0f;
                }
            }
            float f4 = this.f55109e;
            if (f4 < 0.0f) {
                this.f55109e = f4 + 20.0f;
            } else {
                this.f55109e = f4 - 20.0f;
            }
            this.f55111g.getHandler().sendEmptyMessage(1000);
        }
    }
}
