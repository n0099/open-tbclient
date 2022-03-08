package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes7.dex */
public final class MaterialCalendarGridView extends GridView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Calendar dayCompute;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialCalendarGridView(Context context) {
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

    private void gainFocus(int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, rect) == null) {
            if (i2 == 33) {
                setSelection(getAdapter2().lastPositionInMonth());
            } else if (i2 == 130) {
                setSelection(getAdapter2().firstPositionInMonth());
            } else {
                super.onFocusChanged(true, i2, rect);
            }
        }
    }

    public static int horizontalMidPoint(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) ? view.getLeft() + (view.getWidth() / 2) : invokeL.intValue;
    }

    public static boolean skipMonth(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, l, l2, l3, l4)) == null) ? l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue() : invokeLLLL.booleanValue;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            getAdapter2().notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas canvas) {
        int dayToPosition;
        int horizontalMidPoint;
        int dayToPosition2;
        int horizontalMidPoint2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            MaterialCalendarGridView materialCalendarGridView = this;
            super.onDraw(canvas);
            MonthAdapter adapter2 = getAdapter2();
            DateSelector<?> dateSelector = adapter2.dateSelector;
            CalendarStyle calendarStyle = adapter2.calendarStyle;
            Long item = adapter2.getItem(adapter2.firstPositionInMonth());
            Long item2 = adapter2.getItem(adapter2.lastPositionInMonth());
            for (Pair<Long, Long> pair : dateSelector.getSelectedRanges()) {
                Long l = pair.first;
                if (l != null) {
                    if (pair.second == null) {
                        continue;
                    } else {
                        long longValue = l.longValue();
                        long longValue2 = pair.second.longValue();
                        if (skipMonth(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                            return;
                        }
                        if (longValue < item.longValue()) {
                            dayToPosition = adapter2.firstPositionInMonth();
                            horizontalMidPoint = adapter2.isFirstInRow(dayToPosition) ? 0 : materialCalendarGridView.getChildAt(dayToPosition - 1).getRight();
                        } else {
                            materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                            dayToPosition = adapter2.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                            horizontalMidPoint = horizontalMidPoint(materialCalendarGridView.getChildAt(dayToPosition));
                        }
                        if (longValue2 > item2.longValue()) {
                            dayToPosition2 = Math.min(adapter2.lastPositionInMonth(), getChildCount() - 1);
                            if (adapter2.isLastInRow(dayToPosition2)) {
                                horizontalMidPoint2 = getWidth();
                            } else {
                                horizontalMidPoint2 = materialCalendarGridView.getChildAt(dayToPosition2).getRight();
                            }
                        } else {
                            materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                            dayToPosition2 = adapter2.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                            horizontalMidPoint2 = horizontalMidPoint(materialCalendarGridView.getChildAt(dayToPosition2));
                        }
                        int itemId = (int) adapter2.getItemId(dayToPosition);
                        int itemId2 = (int) adapter2.getItemId(dayToPosition2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = materialCalendarGridView.getChildAt(numColumns);
                            canvas.drawRect(numColumns > dayToPosition ? 0 : horizontalMidPoint, childAt.getTop() + calendarStyle.day.getTopInset(), dayToPosition2 > numColumns2 ? getWidth() : horizontalMidPoint2, childAt.getBottom() - calendarStyle.day.getBottomInset(), calendarStyle.rangeFill);
                            itemId++;
                            materialCalendarGridView = this;
                        }
                    }
                }
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            if (z) {
                gainFocus(i2, rect);
            } else {
                super.onFocusChanged(false, i2, rect);
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (super.onKeyDown(i2, keyEvent)) {
                if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().firstPositionInMonth()) {
                    return true;
                }
                if (19 == i2) {
                    setSelection(getAdapter2().firstPositionInMonth());
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 < getAdapter2().firstPositionInMonth()) {
                super.setSelection(getAdapter2().firstPositionInMonth());
            } else {
                super.setSelection(i2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, listAdapter) == null) {
            if (listAdapter instanceof MonthAdapter) {
                super.setAdapter(listAdapter);
                return;
            }
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
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
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat(this) { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MaterialCalendarGridView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view, accessibilityNodeInfoCompat) == null) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setCollectionInfo(null);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.android.material.datepicker.MonthAdapter' to match base method */
    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (MonthAdapter) super.getAdapter() : (MonthAdapter) invokeV.objValue;
    }
}
