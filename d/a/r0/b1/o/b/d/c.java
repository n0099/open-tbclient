package d.a.r0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55113e;

    /* renamed from: f  reason: collision with root package name */
    public int f55114f;

    /* renamed from: g  reason: collision with root package name */
    public int f55115g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f55116h;

    public c(WheelView wheelView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55116h = wheelView;
        this.f55115g = i2;
        this.f55113e = Integer.MAX_VALUE;
        this.f55114f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f55113e == Integer.MAX_VALUE) {
                this.f55113e = this.f55115g;
            }
            int i2 = this.f55113e;
            int i3 = (int) (i2 * 0.1f);
            this.f55114f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f55114f = -1;
                } else {
                    this.f55114f = 1;
                }
            }
            if (Math.abs(this.f55113e) <= 1) {
                this.f55116h.b();
                this.f55116h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f55116h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f55114f);
            if (!this.f55116h.i()) {
                float itemHeight = this.f55116h.getItemHeight();
                float itemsCount = ((this.f55116h.getItemsCount() - 1) - this.f55116h.getInitPosition()) * itemHeight;
                if (this.f55116h.getTotalScrollY() <= (-this.f55116h.getInitPosition()) * itemHeight || this.f55116h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f55116h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f55114f);
                    this.f55116h.b();
                    this.f55116h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f55116h.getHandler().sendEmptyMessage(1000);
            this.f55113e -= this.f55114f;
        }
    }
}
