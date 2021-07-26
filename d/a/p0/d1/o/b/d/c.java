package d.a.p0.d1.o.b.d;

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
    public int f52481e;

    /* renamed from: f  reason: collision with root package name */
    public int f52482f;

    /* renamed from: g  reason: collision with root package name */
    public int f52483g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f52484h;

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
        this.f52484h = wheelView;
        this.f52483g = i2;
        this.f52481e = Integer.MAX_VALUE;
        this.f52482f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f52481e == Integer.MAX_VALUE) {
                this.f52481e = this.f52483g;
            }
            int i2 = this.f52481e;
            int i3 = (int) (i2 * 0.1f);
            this.f52482f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f52482f = -1;
                } else {
                    this.f52482f = 1;
                }
            }
            if (Math.abs(this.f52481e) <= 1) {
                this.f52484h.b();
                this.f52484h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f52484h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f52482f);
            if (!this.f52484h.i()) {
                float itemHeight = this.f52484h.getItemHeight();
                float itemsCount = ((this.f52484h.getItemsCount() - 1) - this.f52484h.getInitPosition()) * itemHeight;
                if (this.f52484h.getTotalScrollY() <= (-this.f52484h.getInitPosition()) * itemHeight || this.f52484h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f52484h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f52482f);
                    this.f52484h.b();
                    this.f52484h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f52484h.getHandler().sendEmptyMessage(1000);
            this.f52481e -= this.f52482f;
        }
    }
}
