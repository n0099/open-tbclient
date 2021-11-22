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
    public Rect f67572a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f67573b;

    /* renamed from: c  reason: collision with root package name */
    public Point f67574c;

    /* renamed from: d  reason: collision with root package name */
    public View f67575d;

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
        this.f67574c = new Point();
        this.f67572a = new Rect();
        this.f67573b = new Rect();
        this.f67575d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f67575d.getGlobalVisibleRect(this.f67572a, this.f67574c);
            Point point = this.f67574c;
            if (point.x == 0 && point.y == 0 && this.f67572a.height() == this.f67575d.getHeight() && this.f67573b.height() != 0 && Math.abs(this.f67572a.top - this.f67573b.top) > this.f67575d.getHeight() / 2) {
                this.f67572a.set(this.f67573b);
            }
            this.f67573b.set(this.f67572a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
