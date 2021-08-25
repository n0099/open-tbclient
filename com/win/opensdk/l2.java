package com.win.opensdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes10.dex */
public class l2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CircleProgressbar f76916a;

    public l2(CircleProgressbar circleProgressbar) {
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
        this.f76916a = circleProgressbar;
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
            this.f76916a.removeCallbacks(this);
            int ordinal = this.f76916a.f77015i.ordinal();
            if (ordinal == 0) {
                circleProgressbar = this.f76916a;
                i2 = circleProgressbar.f77014h + 1;
            } else {
                if (ordinal == 1) {
                    circleProgressbar = this.f76916a;
                    i2 = circleProgressbar.f77014h - 1;
                }
                CircleProgressbar circleProgressbar2 = this.f76916a;
                i3 = circleProgressbar2.f77014h;
                if (i3 < 0 && i3 <= 100) {
                    z zVar = circleProgressbar2.l;
                    if (zVar != null) {
                        zVar.a(circleProgressbar2.m, i3);
                    }
                    this.f76916a.invalidate();
                    CircleProgressbar circleProgressbar3 = this.f76916a;
                    circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.f77016j / 100);
                    return;
                }
                CircleProgressbar circleProgressbar4 = this.f76916a;
                int i4 = circleProgressbar4.f77014h;
                circleProgressbar4.f77014h = i4 <= 100 ? i4 < 0 ? 0 : i4 : 100;
            }
            circleProgressbar.f77014h = i2;
            CircleProgressbar circleProgressbar22 = this.f76916a;
            i3 = circleProgressbar22.f77014h;
            if (i3 < 0) {
            }
            CircleProgressbar circleProgressbar42 = this.f76916a;
            int i42 = circleProgressbar42.f77014h;
            circleProgressbar42.f77014h = i42 <= 100 ? i42 < 0 ? 0 : i42 : 100;
        }
    }
}
