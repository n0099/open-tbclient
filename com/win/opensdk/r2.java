package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes8.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CircleProgressbar circleProgressbar;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.removeCallbacks(this);
            int ordinal = this.a.i.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    circleProgressbar = this.a;
                    i = circleProgressbar.h - 1;
                }
                CircleProgressbar circleProgressbar2 = this.a;
                i2 = circleProgressbar2.h;
                i3 = 100;
                if (i2 < 0 && i2 <= 100) {
                    y yVar = circleProgressbar2.l;
                    if (yVar != null) {
                        yVar.a(circleProgressbar2.m, i2);
                    }
                    this.a.invalidate();
                    CircleProgressbar circleProgressbar3 = this.a;
                    circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.j / 100);
                    return;
                }
                CircleProgressbar circleProgressbar4 = this.a;
                i4 = circleProgressbar4.h;
                if (i4 <= 100) {
                    if (i4 < 0) {
                        i3 = 0;
                    } else {
                        i3 = i4;
                    }
                }
                circleProgressbar4.h = i3;
            }
            circleProgressbar = this.a;
            i = circleProgressbar.h + 1;
            circleProgressbar.h = i;
            CircleProgressbar circleProgressbar22 = this.a;
            i2 = circleProgressbar22.h;
            i3 = 100;
            if (i2 < 0) {
            }
            CircleProgressbar circleProgressbar42 = this.a;
            i4 = circleProgressbar42.h;
            if (i4 <= 100) {
            }
            circleProgressbar42.h = i3;
        }
    }
}
