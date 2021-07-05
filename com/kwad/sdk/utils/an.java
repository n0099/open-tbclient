package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class an {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f39369a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f39370b;

    /* renamed from: c  reason: collision with root package name */
    public Point f39371c;

    /* renamed from: d  reason: collision with root package name */
    public View f39372d;

    public an(View view) {
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
        this.f39371c = new Point();
        this.f39369a = new Rect();
        this.f39370b = new Rect();
        this.f39372d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f39372d.getGlobalVisibleRect(this.f39369a, this.f39371c);
            Point point = this.f39371c;
            if (point.x == 0 && point.y == 0 && this.f39369a.height() == this.f39372d.getHeight() && this.f39370b.height() != 0 && Math.abs(this.f39369a.top - this.f39370b.top) > this.f39372d.getHeight() / 2) {
                this.f39369a.set(this.f39370b);
            }
            this.f39370b.set(this.f39369a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
