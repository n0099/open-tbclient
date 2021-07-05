package com.kwad.sdk.contentalliance.detail.photo.related;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f34933a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34934b;

    /* renamed from: c  reason: collision with root package name */
    public final int f34935c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34936d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(int i2, int i3) {
        this(i2, 0, 0, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34936d = i2;
        this.f34933a = i3;
        this.f34934b = i4;
        this.f34935c = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            int itemCount = recyclerView.getAdapter().getItemCount();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
            int i2 = this.f34935c;
            rect.left = i2 / 2;
            rect.right = i2 / 2;
            rect.top = i2;
            rect.bottom = 0;
            if (spanIndex == 0) {
                rect.left = this.f34934b;
            } else if (spanIndex == this.f34936d - 1) {
                rect.right = this.f34934b;
            }
            boolean z = childAdapterPosition < this.f34936d;
            int i3 = this.f34936d;
            boolean z2 = (itemCount - 1) / i3 == childAdapterPosition / i3;
            if (z) {
                rect.top = this.f34933a;
            } else if (z2) {
                rect.bottom = this.f34933a;
            }
        }
    }
}
