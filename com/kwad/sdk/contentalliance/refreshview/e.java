package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class e extends RefreshLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f.a()) {
            setRefreshInitialOffset((-ao.a(context)) - ao.a(context, 30.0f));
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_shoot_refresh_view, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.ksad_slide_shoot_refresh_view);
            this.f35419d = findViewById;
            findViewById.setVisibility(8);
            View view = this.f35419d;
            if (!(view instanceof d)) {
                throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
            }
            this.f35420e = (d) view;
        }
    }

    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) || e()) {
            return;
        }
        super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public View b(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(getContext()) : (b) invokeV.objValue;
    }

    public void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) || e()) {
            return;
        }
        super.onTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
