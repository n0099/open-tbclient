package d.a.n0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public final class a extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f48657e;

    /* renamed from: f  reason: collision with root package name */
    public final float f48658f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f48659g;

    public a(WheelView3d wheelView3d, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48659g = wheelView3d;
        this.f48658f = f2;
        this.f48657e = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f48657e == 2.1474836E9f) {
                if (Math.abs(this.f48658f) > 2000.0f) {
                    this.f48657e = this.f48658f <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.f48657e = this.f48658f;
                }
            }
            if (Math.abs(this.f48657e) >= 0.0f && Math.abs(this.f48657e) <= 20.0f) {
                this.f48659g.b();
                this.f48659g.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView3d wheelView3d = this.f48659g;
            float f2 = (int) (this.f48657e / 100.0f);
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
            if (!this.f48659g.i()) {
                float itemHeight = this.f48659g.getItemHeight();
                float f3 = (-this.f48659g.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f48659g.getItemsCount() - 1) - this.f48659g.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f48659g.getTotalScrollY() - d2 < f3) {
                    f3 = this.f48659g.getTotalScrollY() + f2;
                } else if (this.f48659g.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f48659g.getTotalScrollY() + f2;
                }
                if (this.f48659g.getTotalScrollY() <= f3) {
                    this.f48657e = 40.0f;
                    this.f48659g.setTotalScrollY((int) f3);
                } else if (this.f48659g.getTotalScrollY() >= itemsCount) {
                    this.f48659g.setTotalScrollY((int) itemsCount);
                    this.f48657e = -40.0f;
                }
            }
            float f4 = this.f48657e;
            if (f4 < 0.0f) {
                this.f48657e = f4 + 20.0f;
            } else {
                this.f48657e = f4 - 20.0f;
            }
            this.f48659g.getHandler().sendEmptyMessage(1000);
        }
    }
}
