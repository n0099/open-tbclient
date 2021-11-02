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
    public Rect f66660a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f66661b;

    /* renamed from: c  reason: collision with root package name */
    public Point f66662c;

    /* renamed from: d  reason: collision with root package name */
    public View f66663d;

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
        this.f66662c = new Point();
        this.f66660a = new Rect();
        this.f66661b = new Rect();
        this.f66663d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f66663d.getGlobalVisibleRect(this.f66660a, this.f66662c);
            Point point = this.f66662c;
            if (point.x == 0 && point.y == 0 && this.f66660a.height() == this.f66663d.getHeight() && this.f66661b.height() != 0 && Math.abs(this.f66660a.top - this.f66661b.top) > this.f66663d.getHeight() / 2) {
                this.f66660a.set(this.f66661b);
            }
            this.f66661b.set(this.f66660a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
