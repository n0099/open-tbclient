package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class au {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f36531a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f36532b;

    /* renamed from: c  reason: collision with root package name */
    public Point f36533c;

    /* renamed from: d  reason: collision with root package name */
    public View f36534d;

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
        this.f36533c = new Point();
        this.f36531a = new Rect();
        this.f36532b = new Rect();
        this.f36534d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f36534d.getGlobalVisibleRect(this.f36531a, this.f36533c);
            Point point = this.f36533c;
            if (point.x == 0 && point.y == 0 && this.f36531a.height() == this.f36534d.getHeight() && this.f36532b.height() != 0 && Math.abs(this.f36531a.top - this.f36532b.top) > this.f36534d.getHeight() / 2) {
                this.f36531a.set(this.f36532b);
            }
            this.f36532b.set(this.f36531a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
