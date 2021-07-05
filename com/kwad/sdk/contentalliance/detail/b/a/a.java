package com.kwad.sdk.contentalliance.detail.b.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.c;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.TouchHandleFrameLayout;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TouchHandleFrameLayout f34556b;

    /* renamed from: c  reason: collision with root package name */
    public GestureDetector.OnGestureListener f34557c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34558d;

    /* renamed from: e  reason: collision with root package name */
    public int f34559e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f34556b = (TouchHandleFrameLayout) l();
            c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.f34559e = cVar.f34582i;
            this.f34558d = cVar.j;
            GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener(this) { // from class: com.kwad.sdk.contentalliance.detail.b.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34560a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34560a = this;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                        return false;
                    }
                    return invokeL.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, motionEvent) == null) {
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, motionEvent)) == null) {
                        e.h(this.f34560a.f34558d);
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            };
            this.f34557c = onGestureListener;
            this.f34556b.setOnGestureListener(onGestureListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f34556b.setOnGestureListener(null);
        }
    }
}
