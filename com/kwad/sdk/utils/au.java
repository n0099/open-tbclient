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
    public Rect f74242a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f74243b;

    /* renamed from: c  reason: collision with root package name */
    public Point f74244c;

    /* renamed from: d  reason: collision with root package name */
    public View f74245d;

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
        this.f74244c = new Point();
        this.f74242a = new Rect();
        this.f74243b = new Rect();
        this.f74245d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f74245d.getGlobalVisibleRect(this.f74242a, this.f74244c);
            Point point = this.f74244c;
            if (point.x == 0 && point.y == 0 && this.f74242a.height() == this.f74245d.getHeight() && this.f74243b.height() != 0 && Math.abs(this.f74242a.top - this.f74243b.top) > this.f74245d.getHeight() / 2) {
                this.f74242a.set(this.f74243b);
            }
            this.f74243b.set(this.f74242a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
