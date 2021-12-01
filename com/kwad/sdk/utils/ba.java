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
public class ba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f59634b;

    /* renamed from: c  reason: collision with root package name */
    public Point f59635c;

    /* renamed from: d  reason: collision with root package name */
    public View f59636d;

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
        this.f59635c = new Point();
        this.a = new Rect();
        this.f59634b = new Rect();
        this.f59636d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f59636d.getGlobalVisibleRect(this.a, this.f59635c);
            Point point = this.f59635c;
            if (point.x == 0 && point.y == 0 && this.a.height() == this.f59636d.getHeight() && this.f59634b.height() != 0 && Math.abs(this.a.top - this.f59634b.top) > this.f59636d.getHeight() / 2) {
                this.a.set(this.f59634b);
            }
            this.f59634b.set(this.a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
