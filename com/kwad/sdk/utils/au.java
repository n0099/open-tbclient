package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class au {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f66659a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f66660b;

    /* renamed from: c  reason: collision with root package name */
    public Point f66661c;

    /* renamed from: d  reason: collision with root package name */
    public View f66662d;

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
        this.f66661c = new Point();
        this.f66659a = new Rect();
        this.f66660b = new Rect();
        this.f66662d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f66662d.getGlobalVisibleRect(this.f66659a, this.f66661c);
            Point point = this.f66661c;
            if (point.x == 0 && point.y == 0 && this.f66659a.height() == this.f66662d.getHeight() && this.f66660b.height() != 0 && Math.abs(this.f66659a.top - this.f66660b.top) > this.f66662d.getHeight() / 2) {
                this.f66659a.set(this.f66660b);
            }
            this.f66660b.set(this.f66659a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
