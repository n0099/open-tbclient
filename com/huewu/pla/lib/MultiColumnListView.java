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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_ListView;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class a implements PLA_AbsListView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f63720a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MultiColumnListView f63721b;

        public a(MultiColumnListView multiColumnListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiColumnListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63721b = multiColumnListView;
            this.f63720a = 0;
        }

        @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
        public void onScroll(PLA_AbsListView pLA_AbsListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, pLA_AbsListView, i2, i3, i4) == null) {
                this.f63720a = (i2 + i3) - 2;
            }
        }

        @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
        public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pLA_AbsListView, i2) == null) {
                int count = this.f63721b.getAdapter().getCount() - 2;
                if (i2 == 0 && this.f63720a == count && this.f63721b.loadingMoreComplete) {
                    this.f63721b.loadMoreListener.a();
                    this.f63721b.loadingMoreComplete = false;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f63722a;

        /* renamed from: b  reason: collision with root package name */
        public int f63723b;

        /* renamed from: c  reason: collision with root package name */
        public int f63724c;

        /* renamed from: d  reason: collision with root package name */
        public int f63725d;

        /* renamed from: e  reason: collision with root package name */
        public int f63726e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MultiColumnListView f63727f;

        public b(MultiColumnListView multiColumnListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiColumnListView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63727f = multiColumnListView;
            this.f63725d = 0;
            this.f63726e = 0;
            this.f63722a = i2;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63725d = 0;
                this.f63726e = 0;
            }
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int childCount = this.f63727f.getChildCount();
                int i2 = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.f63727f.getChildAt(i3);
                    if ((childAt.getLeft() == this.f63724c || this.f63727f.isFixedView(childAt)) && i2 < childAt.getBottom()) {
                        i2 = childAt.getBottom();
                    }
                }
                return i2 == Integer.MIN_VALUE ? this.f63726e : i2;
            }
            return invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63724c : invokeV.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63723b : invokeV.intValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63722a : invokeV.intValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int childCount = this.f63727f.getChildCount();
                int i2 = Integer.MAX_VALUE;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.f63727f.getChildAt(i3);
                    if (childAt.getLeft() == this.f63724c || this.f63727f.isFixedView(childAt)) {
                        i2 = Math.min(i2, childAt.getTop());
                    }
                }
                return i2 == Integer.MAX_VALUE ? this.f63725d : i2;
            }
            return invokeV.intValue;
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 == 0) {
                return;
            }
            int childCount = this.f63727f.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f63727f.getChildAt(i3);
                if (childAt.getLeft() == this.f63724c || this.f63727f.isFixedView(childAt)) {
                    childAt.offsetTopAndBottom(i2);
                }
            }
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f63725d = 0;
                this.f63726e = h();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ MultiColumnListView f63728g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MultiColumnListView multiColumnListView) {
            super(multiColumnListView, Integer.MAX_VALUE);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiColumnListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MultiColumnListView) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63728g = multiColumnListView;
        }

        @Override // com.huewu.pla.lib.MultiColumnListView.b
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63728g.getScrollChildBottom() : invokeV.intValue;
        }

        @Override // com.huewu.pla.lib.MultiColumnListView.b
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63728g.getScrollChildTop() : invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private int getColumnLeft(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            int i3 = this.mItems.get(i2, -1);
            if (i3 == -1) {
                return 0;
            }
            return this.mColumns[i3].e();
        }
        return invokeI.intValue;
    }

    private int getColumnWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
            int i3 = this.mItems.get(i2, -1);
            if (i3 == -1) {
                return 0;
            }
            return this.mColumns[i3].f();
        }
        return invokeI.intValue;
    }

    private b getNextColumn(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            int i3 = this.mItems.get(i2, -1);
            if (i3 != -1) {
                return this.mColumns[i3];
            }
            int max = Math.max(0, Math.max(0, i2 - getHeaderViewsCount()));
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

    private void init(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, attributeSet) == null) {
            getWindowVisibleDisplayFrame(this.mFrameRect);
            if (attributeSet == null) {
                this.mColumnNumber = 2;
            } else {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MultiColumnListView);
                int integer = obtainStyledAttributes.getInteger(R$styleable.MultiColumnListView_plaLandscapeColumnNumber, -1);
                int integer2 = obtainStyledAttributes.getInteger(R$styleable.MultiColumnListView_plaColumnNumber, -1);
                if (this.mFrameRect.width() > this.mFrameRect.height() && integer != -1) {
                    this.mColumnNumber = integer;
                } else if (integer2 != -1) {
                    this.mColumnNumber = integer2;
                } else {
                    this.mColumnNumber = 2;
                }
                this.mColumnPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColumnListView_plaColumnPaddingLeft, 0);
                this.mColumnPaddingRight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColumnListView_plaColumnPaddingRight, 0);
                obtainStyledAttributes.recycle();
            }
            this.mColumns = new b[this.mColumnNumber];
            for (int i2 = 0; i2 < this.mColumnNumber; i2++) {
                this.mColumns[i2] = new b(this, i2);
            }
            this.mFixedColumn = new c(this);
        }
    }

    private boolean isHeaderOrFooterPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) ? this.mAdapter.getItemViewType(i2) == -2 : invokeI.booleanValue;
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
            int i2 = Integer.MAX_VALUE;
            for (b bVar : this.mColumns) {
                int d2 = bVar.d();
                if (i2 > d2) {
                    i2 = d2;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getFillChildTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = Integer.MIN_VALUE;
            for (b bVar : this.mColumns) {
                i2 = Math.max(i2, bVar.h());
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemBottom(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (isHeaderOrFooterPosition(i2)) {
                return this.mFixedColumn.h();
            }
            int i3 = this.mItems.get(i2, -1);
            if (i3 == -1) {
                return getFillChildTop();
            }
            return this.mColumns[i3].h();
        }
        return invokeI.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemLeft(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (isHeaderOrFooterPosition(i2)) {
                return this.mFixedColumn.e();
            }
            return getColumnLeft(i2);
        }
        return invokeI.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public int getItemTop(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (isHeaderOrFooterPosition(i2)) {
                return this.mFixedColumn.d();
            }
            int i3 = this.mItems.get(i2, -1);
            if (i3 == -1) {
                return getFillChildBottom();
            }
            return this.mColumns[i3].d();
        }
        return invokeI.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getScrollChildBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = Integer.MIN_VALUE;
            for (b bVar : this.mColumns) {
                int d2 = bVar.d();
                if (i2 < d2) {
                    i2 = d2;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int getScrollChildTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = Integer.MAX_VALUE;
            for (b bVar : this.mColumns) {
                int h2 = bVar.h();
                if (i2 > h2) {
                    i2 = h2;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public int modifyFlingInitialVelocity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onAdjustChildViews(boolean z) {
        b[] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (!z && firstVisiblePosition == 0) {
                int h2 = this.mColumns[0].h();
                for (b bVar : this.mColumns) {
                    bVar.i(h2 - bVar.h());
                }
            }
            super.onAdjustChildViews(z);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onItemAddedToList(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.onItemAddedToList(i2, z);
            if (isHeaderOrFooterPosition(i2)) {
                return;
            }
            this.mItems.append(i2, getNextColumn(z, i2).g());
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, com.huewu.pla.lib.internal.PLA_AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void onLayoutSync(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            for (b bVar : this.mColumns) {
                bVar.j();
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void onLayoutSyncFinished(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            for (b bVar : this.mColumns) {
                bVar.c();
            }
        }
    }

    public void onLoadMoreComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.loadingMoreComplete = true;
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int measuredWidth = getMeasuredWidth();
            Rect rect = this.mListPadding;
            int i4 = (((((measuredWidth - rect.left) - rect.right) - this.mColumnPaddingLeft) - this.mColumnPaddingRight) - this.mColumnDiv) / this.mColumnNumber;
            for (int i5 = 0; i5 < this.mColumnNumber; i5++) {
                this.mColumns[i5].f63723b = i4;
                if (i5 == 0) {
                    this.mColumns[i5].f63724c = this.mListPadding.left + this.mColumnPaddingLeft + (i4 * i5);
                } else {
                    this.mColumns[i5].f63724c = this.mListPadding.left + this.mColumnPaddingLeft + this.mColumnDiv + (i4 * i5);
                }
            }
            this.mFixedColumn.f63724c = this.mListPadding.left;
            this.mFixedColumn.f63723b = getMeasuredWidth();
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void onMeasureChild(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048592, this, view, i2, i3, i4) == null) {
            if (isFixedView(view)) {
                view.measure(i3, i4);
            } else {
                view.measure(getColumnWidth(i2) | 1073741824, i4);
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

    public void setColumnDiv(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mColumnDiv = i2;
        }
    }

    public void setColumnPaddingLeft(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mColumnPaddingLeft = i2;
        }
    }

    public void setColumnPaddingRight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mColumnPaddingRight = i2;
        }
    }

    public void setOnLoadMoreListener(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) || dVar == null) {
            return;
        }
        this.loadMoreListener = dVar;
        setOnScrollListener(this.scroller);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiColumnListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
}
