package com.repackage;

import android.view.View;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class it8 implements View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ it8 a = new it8();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ it8() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? VideoAttentionListPageFragment.u1(view2) : invokeL.booleanValue;
    }
}
