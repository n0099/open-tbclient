package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes6.dex */
public class J1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CircleProgressbar f39387a;

    public J1(CircleProgressbar circleProgressbar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {circleProgressbar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39387a = circleProgressbar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CircleProgressbar circleProgressbar;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39387a.removeCallbacks(this);
            int ordinal = this.f39387a.f39683i.ordinal();
            if (ordinal == 0) {
                circleProgressbar = this.f39387a;
                i2 = circleProgressbar.f39682h + 1;
            } else {
                if (ordinal == 1) {
                    circleProgressbar = this.f39387a;
                    i2 = circleProgressbar.f39682h - 1;
                }
                CircleProgressbar circleProgressbar2 = this.f39387a;
                i3 = circleProgressbar2.f39682h;
                if (i3 < 0 && i3 <= 100) {
                    l lVar = circleProgressbar2.l;
                    if (lVar != null) {
                        lVar.a(circleProgressbar2.m, i3);
                    }
                    this.f39387a.invalidate();
                    CircleProgressbar circleProgressbar3 = this.f39387a;
                    circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.j / 100);
                    return;
                }
                CircleProgressbar circleProgressbar4 = this.f39387a;
                int i4 = circleProgressbar4.f39682h;
                circleProgressbar4.f39682h = i4 <= 100 ? i4 < 0 ? 0 : i4 : 100;
            }
            circleProgressbar.f39682h = i2;
            CircleProgressbar circleProgressbar22 = this.f39387a;
            i3 = circleProgressbar22.f39682h;
            if (i3 < 0) {
            }
            CircleProgressbar circleProgressbar42 = this.f39387a;
            int i42 = circleProgressbar42.f39682h;
            circleProgressbar42.f39682h = i42 <= 100 ? i42 < 0 ? 0 : i42 : 100;
        }
    }
}
