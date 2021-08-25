package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class au {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f73743a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f73744b;

    /* renamed from: c  reason: collision with root package name */
    public Point f73745c;

    /* renamed from: d  reason: collision with root package name */
    public View f73746d;

    public au(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73745c = new Point();
        this.f73743a = new Rect();
        this.f73744b = new Rect();
        this.f73746d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f73746d.getGlobalVisibleRect(this.f73743a, this.f73745c);
            Point point = this.f73745c;
            if (point.x == 0 && point.y == 0 && this.f73743a.height() == this.f73746d.getHeight() && this.f73744b.height() != 0 && Math.abs(this.f73743a.top - this.f73744b.top) > this.f73746d.getHeight() / 2) {
                this.f73743a.set(this.f73744b);
            }
            this.f73744b.set(this.f73743a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
