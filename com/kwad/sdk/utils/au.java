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
    public Rect f73923a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f73924b;

    /* renamed from: c  reason: collision with root package name */
    public Point f73925c;

    /* renamed from: d  reason: collision with root package name */
    public View f73926d;

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
        this.f73925c = new Point();
        this.f73923a = new Rect();
        this.f73924b = new Rect();
        this.f73926d = view;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean globalVisibleRect = this.f73926d.getGlobalVisibleRect(this.f73923a, this.f73925c);
            Point point = this.f73925c;
            if (point.x == 0 && point.y == 0 && this.f73923a.height() == this.f73926d.getHeight() && this.f73924b.height() != 0 && Math.abs(this.f73923a.top - this.f73924b.top) > this.f73926d.getHeight() / 2) {
                this.f73923a.set(this.f73924b);
            }
            this.f73924b.set(this.f73923a);
            return globalVisibleRect;
        }
        return invokeV.booleanValue;
    }
}
