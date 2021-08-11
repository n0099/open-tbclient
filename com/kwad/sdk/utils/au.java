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
    public Rect f73543a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f73544b;

    /* renamed from: c  reason: collision with root package name */
    public Point f73545c;

    /* renamed from: d  reason: collision with root package name */
    public View f73546d;

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
        this.f73545c = new Point();
        this.f73543a = new Rect();
        this.f73544b = new Rect();
        this.f73546d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f73546d.getGlobalVisibleRect(this.f73543a, this.f73545c);
            Point point = this.f73545c;
            if (point.x == 0 && point.y == 0 && this.f73543a.height() == this.f73546d.getHeight() && this.f73544b.height() != 0 && Math.abs(this.f73543a.top - this.f73544b.top) > this.f73546d.getHeight() / 2) {
                this.f73543a.set(this.f73544b);
            }
            this.f73544b.set(this.f73543a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
