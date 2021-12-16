package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f60215b;

    /* renamed from: c  reason: collision with root package name */
    public Point f60216c;

    /* renamed from: d  reason: collision with root package name */
    public View f60217d;

    public ba(View view) {
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
        this.f60216c = new Point();
        this.a = new Rect();
        this.f60215b = new Rect();
        this.f60217d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f60217d.getGlobalVisibleRect(this.a, this.f60216c);
            Point point = this.f60216c;
            if (point.x == 0 && point.y == 0 && this.a.height() == this.f60217d.getHeight() && this.f60215b.height() != 0 && Math.abs(this.a.top - this.f60215b.top) > this.f60217d.getHeight() / 2) {
                this.a.set(this.f60215b);
            }
            this.f60215b.set(this.a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
