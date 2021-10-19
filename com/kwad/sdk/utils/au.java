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
    public Rect f74277a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f74278b;

    /* renamed from: c  reason: collision with root package name */
    public Point f74279c;

    /* renamed from: d  reason: collision with root package name */
    public View f74280d;

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
        this.f74279c = new Point();
        this.f74277a = new Rect();
        this.f74278b = new Rect();
        this.f74280d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f74280d.getGlobalVisibleRect(this.f74277a, this.f74279c);
            Point point = this.f74279c;
            if (point.x == 0 && point.y == 0 && this.f74277a.height() == this.f74280d.getHeight() && this.f74278b.height() != 0 && Math.abs(this.f74277a.top - this.f74278b.top) > this.f74280d.getHeight() / 2) {
                this.f74277a.set(this.f74278b);
            }
            this.f74278b.set(this.f74277a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
