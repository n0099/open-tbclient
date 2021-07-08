package d.a.n0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48661e;

    /* renamed from: f  reason: collision with root package name */
    public int f48662f;

    /* renamed from: g  reason: collision with root package name */
    public int f48663g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f48664h;

    public c(WheelView3d wheelView3d, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48664h = wheelView3d;
        this.f48663g = i2;
        this.f48661e = Integer.MAX_VALUE;
        this.f48662f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f48661e == Integer.MAX_VALUE) {
                this.f48661e = this.f48663g;
            }
            int i2 = this.f48661e;
            int i3 = (int) (i2 * 0.1f);
            this.f48662f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f48662f = -1;
                } else {
                    this.f48662f = 1;
                }
            }
            if (Math.abs(this.f48661e) <= 1) {
                this.f48664h.b();
                this.f48664h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.f48664h;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f48662f);
            if (!this.f48664h.i()) {
                float itemHeight = this.f48664h.getItemHeight();
                float itemsCount = ((this.f48664h.getItemsCount() - 1) - this.f48664h.getInitPosition()) * itemHeight;
                if (this.f48664h.getTotalScrollY() <= (-this.f48664h.getInitPosition()) * itemHeight || this.f48664h.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.f48664h;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f48662f);
                    this.f48664h.b();
                    this.f48664h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f48664h.getHandler().sendEmptyMessage(1000);
            this.f48661e -= this.f48662f;
        }
    }
}
