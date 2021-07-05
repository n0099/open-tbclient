package com.kwad.sdk.contentalliance.profile.tabvideo;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f35371a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35372b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35373c;

    public a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35371a = i2;
        this.f35372b = i3;
        this.f35373c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            int itemCount = recyclerView.getAdapter().getItemCount();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition % this.f35371a == 0) {
                rect.left = 0;
            } else {
                rect.left = this.f35372b / 2;
            }
            int i2 = this.f35371a;
            if (childAdapterPosition % i2 == i2 - 1) {
                rect.right = 0;
            } else {
                rect.right = this.f35372b / 2;
            }
            if (childAdapterPosition < this.f35371a) {
                rect.top = 0;
            } else {
                rect.top = this.f35373c / 2;
            }
            if (childAdapterPosition >= itemCount || childAdapterPosition <= itemCount - this.f35371a) {
                rect.bottom = this.f35373c / 2;
            } else {
                rect.bottom = 0;
            }
        }
    }
}
