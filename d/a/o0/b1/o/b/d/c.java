package d.a.o0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
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
    public int f51818e;

    /* renamed from: f  reason: collision with root package name */
    public int f51819f;

    /* renamed from: g  reason: collision with root package name */
    public int f51820g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f51821h;

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
        this.f51821h = wheelView;
        this.f51820g = i2;
        this.f51818e = Integer.MAX_VALUE;
        this.f51819f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f51818e == Integer.MAX_VALUE) {
                this.f51818e = this.f51820g;
            }
            int i2 = this.f51818e;
            int i3 = (int) (i2 * 0.1f);
            this.f51819f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f51819f = -1;
                } else {
                    this.f51819f = 1;
                }
            }
            if (Math.abs(this.f51818e) <= 1) {
                this.f51821h.b();
                this.f51821h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f51821h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f51819f);
            if (!this.f51821h.i()) {
                float itemHeight = this.f51821h.getItemHeight();
                float itemsCount = ((this.f51821h.getItemsCount() - 1) - this.f51821h.getInitPosition()) * itemHeight;
                if (this.f51821h.getTotalScrollY() <= (-this.f51821h.getInitPosition()) * itemHeight || this.f51821h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f51821h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f51819f);
                    this.f51821h.b();
                    this.f51821h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f51821h.getHandler().sendEmptyMessage(1000);
            this.f51818e -= this.f51819f;
        }
    }
}
