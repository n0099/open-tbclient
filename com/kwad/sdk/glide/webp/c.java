package com.kwad.sdk.glide.webp;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f38370a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38371b;

    /* renamed from: c  reason: collision with root package name */
    public final int f38372c;

    /* renamed from: d  reason: collision with root package name */
    public final int f38373d;

    /* renamed from: e  reason: collision with root package name */
    public final int f38374e;

    /* renamed from: f  reason: collision with root package name */
    public final int f38375f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f38376g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f38377h;

    public c(int i2, WebpFrame webpFrame) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), webpFrame};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38370a = i2;
        this.f38371b = webpFrame.getXOffest();
        this.f38372c = webpFrame.getYOffest();
        this.f38373d = webpFrame.getWidth();
        this.f38374e = webpFrame.getHeight();
        this.f38375f = webpFrame.getDurationMs();
        this.f38376g = webpFrame.isBlendWithPreviousFrame();
        this.f38377h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "frameNumber=" + this.f38370a + ", xOffset=" + this.f38371b + ", yOffset=" + this.f38372c + ", width=" + this.f38373d + ", height=" + this.f38374e + ", duration=" + this.f38375f + ", blendPreviousFrame=" + this.f38376g + ", disposeBackgroundColor=" + this.f38377h;
        }
        return (String) invokeV.objValue;
    }
}
