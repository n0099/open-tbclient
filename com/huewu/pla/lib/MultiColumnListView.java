package com.huewu.pla.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_ListView;
/* loaded from: classes8.dex */
public class MultiColumnListView extends PLA_ListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_COLUMN_NUMBER = 2;
    public static final String TAG = "MultiColumnListView";
    public transient /* synthetic */ FieldHolder $fh;
    public d loadMoreListener;
    public boolean loadingMoreComplete;
    public int mColumnDiv;
    public int mColumnNumber;
    public int mColumnPaddingLeft;
    public int mColumnPaddingRight;
    public b[] mColumns;
    public b mFixedColumn;
    public Rect mFrameRect;
    public ParcelableSparseIntArray mItems;
    public PLA_AbsListView.e scroller;

    /* loaded from: classes8.dex */
    public interface d {
        void a();
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int modifyFlingInitialVelocity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements PLA_AbsListView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ MultiColumnListView b;

        public a(MultiColumnListView multiColumnListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiColumnListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = multiColumnListView;
            this.a = 0;
        }

        @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
        public void onScroll(PLA_AbsListView pLA_AbsListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, pLA_AbsListView, i, i2, i3) == null) {
                this.a = (i + i2) - 2;
            }
        }

        @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
        public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pLA_AbsListView, i) == null) {
                int count = this.b.getAdapter().getCount() - 2;
                if (i == 0 && this.a == count && this.b.loadingMoreComplete) {
                    this.b.loadMoreListener.a();
                    this.b.loadingMoreComplete = false;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public final /* synthetic */ MultiColumnListView f;

        public b(MultiColumnListView multiColumnListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiColumnListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = multiColumnListView;
            this.d = 0;
            this.e = 0;
            this.a = i;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d = 0;
                this.e = 0;
            }
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.d = 0;
                this.e = h();
            }
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int childCount = this.f.getChildCount();
                int i = Integer.MIN_VALUE;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f.getChildAt(i2);
                    if ((childAt.getLeft() == this.c || this.f.isFixedView(childAt)) && i < childAt.getBottom()) {
                        i = childAt.getBottom();
                    }
                }
                if (i == Integer.MIN_VALUE) {
                    return this.e;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int childCount = this.f.getChildCount();
                int i = Integer.MAX_VALUE;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f.getChildAt(i2);
                    if (childAt.getLeft() == this.c || this.f.isFixedView(childAt)) {
                        i = Math.min(i, childAt.getTop());
                    }
                }
                if (i == Integer.MAX_VALUE) {
                    return this.d;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || i == 0) {
                return;
            }
            int childCount = this.f.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f.getChildAt(i2);
                if (childAt.getLeft() == this.c || this.f.isFixedView(childAt)) {
                    childAt.offsetTopAndBottom(i);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiColumnListView g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MultiColumnListView multiColumnListView) {
            super(multiColumnListView, Integer.MAX_VALUE);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiColumnListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MultiColumnListView) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = multiColumnListView;
        }

        @Override // com.huewu.pla.lib.MultiColumnListView.b
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.g.getScrollChildBottom();
            }
            return invokeV.intValue;
        }

        @Override // com.huewu.pla.lib.MultiColumnListView.b
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.g.getScrollChildTop();
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiColumnListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mColumnNumber = 2;
        this.mColumns = null;
        this.mFixedColumn = null;
        this.mItems = new ParcelableSparseIntArray();
        this.mColumnPaddingLeft = 0;
        this.mColumnPaddingRight = 0;
        this.mColumnDiv = 0;
        this.mFrameRect = new Rect();
        this.loadingMoreComplete = true;
        this.scroller = new a(this);
        init(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiColumnListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mColumnNumber = 2;
        this.mColumns = null;
        this.mFixedColumn = null;
        this.mItems = new ParcelableSparseIntArray();
        this.mColumnPaddingLeft = 0;
        this.mColumnPaddingRight = 0;
        this.mColumnDiv = 0;
        this.mFrameRect = new Rect();
        this.loadingMoreComplete = true;
        this.scroller = new a(this);
        init(attributeSet);
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int measuredWidth = getMeasuredWidth();
            Rect rect = this.mListPadding;
            int i3 = (((((measuredWidth - rect.left) - rect.right) - this.mColumnPaddingLeft) - this.mColumnPaddingRight) - this.mColumnDiv) / this.mColumnNumber;
            for (int i4 = 0; i4 < this.mColumnNumber; i4++) {
                this.mColumns[i4].b = i3;
                if (i4 == 0) {
                    this.mColumns[i4].c = this.mListPadding.left + this.mColumnPaddingLeft + (i3 * i4);
                } else {
                    this.mColumns[i4].c = this.mListPadding.left + this.mColumnPaddingLeft + this.mColumnDiv + (i3 * i4);
                }
            }
            this.mFixedColumn.c = this.mListPadding.left;
            this.mFixedColumn.b = getMeasuredWidth();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiColumnListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mColumnNumber = 2;
        this.mColumns = null;
        this.mFixedColumn = null;
        this.mItems = new ParcelableSparseIntArray();
        this.mColumnPaddingLeft = 0;
        this.mColumnPaddingRight = 0;
        this.mColumnDiv = 0;
        this.mFrameRect = new Rect();
        this.loadingMoreComplete = true;
        this.scroller = new a(this);
        init(attributeSet);
    }

    private int getColumnLeft(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
            int i2 = this.mItems.get(i, -1);
            if (i2 == -1) {
                return 0;
            }
            return this.mColumns[i2].e();
        }
        return invokeI.intValue;
    }

    private int getColumnWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) {
            int i2 = this.mItems.get(i, -1);
            if (i2 == -1) {
                return 0;
            }
            return this.mColumns[i2].f();
        }
        return invokeI.intValue;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            if (this.mAdapter.getItemViewType(i) == -2) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemLeft(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (isHeaderOrFooterPosition(i)) {
                return this.mFixedColumn.e();
            }
            return getColumnLeft(i);
        }
        return invokeI.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void onLayoutSync(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            for (b bVar : this.mColumns) {
                bVar.j();
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void onLayoutSyncFinished(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            for (b bVar : this.mColumns) {
                bVar.c();
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, parcelable) == null) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                this.mItems = (ParcelableSparseIntArray) bundle.getParcelable("items");
                parcelable = bundle.getParcelable("instanceState");
            }
            super.onRestoreInstanceState(parcelable);
        }
    }

    public void setColumnDiv(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.mColumnDiv = i;
        }
    }

    public void setColumnPaddingLeft(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mColumnPaddingLeft = i;
        }
    }

    public void setColumnPaddingRight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.mColumnPaddingRight = i;
        }
    }

    public void setOnLoadMoreListener(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) && dVar != null) {
            this.loadMoreListener = dVar;
            setOnScrollListener(this.scroller);
        }
    }

    private b getNextColumn(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            int i2 = this.mItems.get(i, -1);
            if (i2 != -1) {
                return this.mColumns[i2];
            }
            int max = Math.max(0, Math.max(0, i - getHeaderViewsCount()));
            if (max < this.mColumnNumber) {
                return this.mColumns[max];
            }
            if (z) {
                return gettBottomColumn();
            }
            return getTopColumn();
        }
        return (b) invokeCommon.objValue;
    }

    private b getTopColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            b[] bVarArr = this.mColumns;
            b bVar = bVarArr[0];
            for (b bVar2 : bVarArr) {
                if (bVar.h() > bVar2.h()) {
                    bVar = bVar2;
                }
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    private b gettBottomColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            b[] bVarArr = this.mColumns;
            b bVar = bVarArr[0];
            for (b bVar2 : bVarArr) {
                if (bVar.d() > bVar2.d()) {
                    bVar = bVar2;
                }
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public void clearItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mItems.clear();
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFillChildBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = Integer.MAX_VALUE;
            for (b bVar : this.mColumns) {
                int d2 = bVar.d();
                if (i > d2) {
                    i = d2;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFillChildTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = Integer.MIN_VALUE;
            for (b bVar : this.mColumns) {
                i = Math.max(i, bVar.h());
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getScrollChildBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = Integer.MIN_VALUE;
            for (b bVar : this.mColumns) {
                int d2 = bVar.d();
                if (i < d2) {
                    i = d2;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getScrollChildTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = Integer.MAX_VALUE;
            for (b bVar : this.mColumns) {
                int h = bVar.h();
                if (i > h) {
                    i = h;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void onLoadMoreComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.loadingMoreComplete = true;
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("instanceState", super.onSaveInstanceState());
            bundle.putParcelable("items", this.mItems);
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    private void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, attributeSet) == null) {
            getWindowVisibleDisplayFrame(this.mFrameRect);
            if (attributeSet == null) {
                this.mColumnNumber = 2;
            } else {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, vq5.MultiColumnListView);
                int integer = obtainStyledAttributes.getInteger(3, -1);
                int integer2 = obtainStyledAttributes.getInteger(0, -1);
                if (this.mFrameRect.width() > this.mFrameRect.height() && integer != -1) {
                    this.mColumnNumber = integer;
                } else if (integer2 != -1) {
                    this.mColumnNumber = integer2;
                } else {
                    this.mColumnNumber = 2;
                }
                this.mColumnPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(1, 0);
                this.mColumnPaddingRight = obtainStyledAttributes.getDimensionPixelSize(2, 0);
                obtainStyledAttributes.recycle();
            }
            this.mColumns = new b[this.mColumnNumber];
            for (int i = 0; i < this.mColumnNumber; i++) {
                this.mColumns[i] = new b(this, i);
            }
            this.mFixedColumn = new c(this);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemBottom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (isHeaderOrFooterPosition(i)) {
                return this.mFixedColumn.h();
            }
            int i2 = this.mItems.get(i, -1);
            if (i2 == -1) {
                return getFillChildTop();
            }
            return this.mColumns[i2].h();
        }
        return invokeI.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemTop(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (isHeaderOrFooterPosition(i)) {
                return this.mFixedColumn.d();
            }
            int i2 = this.mItems.get(i, -1);
            if (i2 == -1) {
                return getFillChildBottom();
            }
            return this.mColumns[i2].d();
        }
        return invokeI.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onAdjustChildViews(boolean z) {
        b[] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (!z && firstVisiblePosition == 0) {
                int h = this.mColumns[0].h();
                for (b bVar : this.mColumns) {
                    bVar.i(h - bVar.h());
                }
            }
            super.onAdjustChildViews(z);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onItemAddedToList(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.onItemAddedToList(i, z);
            if (!isHeaderOrFooterPosition(i)) {
                this.mItems.append(i, getNextColumn(z, i).g());
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onMeasureChild(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048592, this, view2, i, i2, i3) == null) {
            if (isFixedView(view2)) {
                view2.measure(i2, i3);
            } else {
                view2.measure(getColumnWidth(i) | 1073741824, i3);
            }
        }
    }
}
