package d.a.o0.a.z1.a.e.d;

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
    public int f49165e;

    /* renamed from: f  reason: collision with root package name */
    public int f49166f;

    /* renamed from: g  reason: collision with root package name */
    public int f49167g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f49168h;

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
        this.f49168h = wheelView3d;
        this.f49167g = i2;
        this.f49165e = Integer.MAX_VALUE;
        this.f49166f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f49165e == Integer.MAX_VALUE) {
                this.f49165e = this.f49167g;
            }
            int i2 = this.f49165e;
            int i3 = (int) (i2 * 0.1f);
            this.f49166f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f49166f = -1;
                } else {
                    this.f49166f = 1;
                }
            }
            if (Math.abs(this.f49165e) <= 1) {
                this.f49168h.b();
                this.f49168h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.f49168h;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f49166f);
            if (!this.f49168h.i()) {
                float itemHeight = this.f49168h.getItemHeight();
                float itemsCount = ((this.f49168h.getItemsCount() - 1) - this.f49168h.getInitPosition()) * itemHeight;
                if (this.f49168h.getTotalScrollY() <= (-this.f49168h.getInitPosition()) * itemHeight || this.f49168h.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.f49168h;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f49166f);
                    this.f49168h.b();
                    this.f49168h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f49168h.getHandler().sendEmptyMessage(1000);
            this.f49165e -= this.f49166f;
        }
    }
}
