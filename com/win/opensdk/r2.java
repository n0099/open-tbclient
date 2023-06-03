package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes10.dex */
public class r2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ CircleProgressbar a;

    public r2(CircleProgressbar circleProgressbar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {circleProgressbar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = circleProgressbar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.removeCallbacks(this);
            int ordinal = this.a.i.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    this.a.h--;
                }
            } else {
                this.a.h++;
            }
            CircleProgressbar circleProgressbar = this.a;
            int i = circleProgressbar.h;
            int i2 = 100;
            if (i >= 0 && i <= 100) {
                y yVar = circleProgressbar.l;
                if (yVar != null) {
                    yVar.a(circleProgressbar.m, i);
                }
                this.a.invalidate();
                CircleProgressbar circleProgressbar2 = this.a;
                circleProgressbar2.postDelayed(circleProgressbar2.n, circleProgressbar2.j / 100);
                return;
            }
            CircleProgressbar circleProgressbar3 = this.a;
            int i3 = circleProgressbar3.h;
            if (i3 <= 100) {
                if (i3 < 0) {
                    i2 = 0;
                } else {
                    i2 = i3;
                }
            }
            circleProgressbar3.h = i2;
        }
    }
}
