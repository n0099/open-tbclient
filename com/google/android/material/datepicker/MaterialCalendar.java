package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    public static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    public static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    @VisibleForTesting
    public static final Object MONTHS_VIEW_GROUP_TAG;
    @VisibleForTesting
    public static final Object NAVIGATION_NEXT_TAG;
    @VisibleForTesting
    public static final Object NAVIGATION_PREV_TAG;
    @VisibleForTesting
    public static final Object SELECTOR_TOGGLE_TAG;
    public static final int SMOOTH_SCROLL_MAX = 3;
    public static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public CalendarConstraints calendarConstraints;
    public CalendarSelector calendarSelector;
    public CalendarStyle calendarStyle;
    @Nullable
    public Month current;
    @Nullable
    public DateSelector<S> dateSelector;
    public View dayFrame;
    public RecyclerView recyclerView;
    public int themeResId;
    public View yearFrame;
    public RecyclerView yearSelector;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class CalendarSelector {
        public static final /* synthetic */ CalendarSelector[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CalendarSelector DAY;
        public static final CalendarSelector YEAR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2132645094, "Lcom/google/android/material/datepicker/MaterialCalendar$CalendarSelector;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2132645094, "Lcom/google/android/material/datepicker/MaterialCalendar$CalendarSelector;");
                    return;
                }
            }
            DAY = new CalendarSelector("DAY", 0);
            CalendarSelector calendarSelector = new CalendarSelector("YEAR", 1);
            YEAR = calendarSelector;
            $VALUES = new CalendarSelector[]{DAY, calendarSelector};
        }

        public CalendarSelector(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CalendarSelector valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CalendarSelector) Enum.valueOf(CalendarSelector.class, str) : (CalendarSelector) invokeL.objValue;
        }

        public static CalendarSelector[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CalendarSelector[]) $VALUES.clone() : (CalendarSelector[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface OnDayClickListener {
        void onDayClick(long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(844128431, "Lcom/google/android/material/datepicker/MaterialCalendar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(844128431, "Lcom/google/android/material/datepicker/MaterialCalendar;");
                return;
            }
        }
        MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
        NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
        NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
        SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    }

    public MaterialCalendar() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void addActionsToMonthNavigation(@NonNull View view2, @NonNull MonthsPagerAdapter monthsPagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, view2, monthsPagerAdapter) == null) {
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.obfuscated_res_0x7f091404);
            materialButton.setTag(SELECTOR_TOGGLE_TAG);
            ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view3, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    String string;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view3, accessibilityNodeInfoCompat) == null) {
                        super.onInitializeAccessibilityNodeInfo(view3, accessibilityNodeInfoCompat);
                        if (this.this$0.dayFrame.getVisibility() == 0) {
                            string = this.this$0.getString(R.string.obfuscated_res_0x7f0f0b1d);
                        } else {
                            string = this.this$0.getString(R.string.obfuscated_res_0x7f0f0b1b);
                        }
                        accessibilityNodeInfoCompat.setHintText(string);
                    }
                }
            });
            MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.obfuscated_res_0x7f091406);
            materialButton2.setTag(NAVIGATION_PREV_TAG);
            MaterialButton materialButton3 = (MaterialButton) view2.findViewById(R.id.obfuscated_res_0x7f091405);
            materialButton3.setTag(NAVIGATION_NEXT_TAG);
            this.yearFrame = view2.findViewById(R.id.obfuscated_res_0x7f09143c);
            this.dayFrame = view2.findViewById(R.id.obfuscated_res_0x7f091435);
            setSelector(CalendarSelector.DAY);
            materialButton.setText(this.current.getLongName());
            this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this, monthsPagerAdapter, materialButton) { // from class: com.google.android.material.datepicker.MaterialCalendar.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;
                public final /* synthetic */ MaterialButton val$monthDropSelect;
                public final /* synthetic */ MonthsPagerAdapter val$monthsPagerAdapter;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, monthsPagerAdapter, materialButton};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$monthsPagerAdapter = monthsPagerAdapter;
                    this.val$monthDropSelect = materialButton;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                        CharSequence text = this.val$monthDropSelect.getText();
                        if (Build.VERSION.SDK_INT >= 16) {
                            recyclerView.announceForAccessibility(text);
                        } else {
                            recyclerView.sendAccessibilityEvent(2048);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                    int findLastVisibleItemPosition;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                        if (i < 0) {
                            findLastVisibleItemPosition = this.this$0.getLayoutManager().findFirstVisibleItemPosition();
                        } else {
                            findLastVisibleItemPosition = this.this$0.getLayoutManager().findLastVisibleItemPosition();
                        }
                        this.this$0.current = this.val$monthsPagerAdapter.getPageMonth(findLastVisibleItemPosition);
                        this.val$monthDropSelect.setText(this.val$monthsPagerAdapter.getPageTitle(findLastVisibleItemPosition));
                    }
                }
            });
            materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        this.this$0.toggleVisibleSelector();
                    }
                }
            });
            materialButton3.setOnClickListener(new View.OnClickListener(this, monthsPagerAdapter) { // from class: com.google.android.material.datepicker.MaterialCalendar.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;
                public final /* synthetic */ MonthsPagerAdapter val$monthsPagerAdapter;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, monthsPagerAdapter};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$monthsPagerAdapter = monthsPagerAdapter;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    int findFirstVisibleItemPosition;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) || (findFirstVisibleItemPosition = this.this$0.getLayoutManager().findFirstVisibleItemPosition() + 1) >= this.this$0.recyclerView.getAdapter().getItemCount()) {
                        return;
                    }
                    this.this$0.setCurrentMonth(this.val$monthsPagerAdapter.getPageMonth(findFirstVisibleItemPosition));
                }
            });
            materialButton2.setOnClickListener(new View.OnClickListener(this, monthsPagerAdapter) { // from class: com.google.android.material.datepicker.MaterialCalendar.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;
                public final /* synthetic */ MonthsPagerAdapter val$monthsPagerAdapter;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, monthsPagerAdapter};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$monthsPagerAdapter = monthsPagerAdapter;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    int findLastVisibleItemPosition;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) || this.this$0.getLayoutManager().findLastVisibleItemPosition() - 1 < 0) {
                        return;
                    }
                    this.this$0.setCurrentMonth(this.val$monthsPagerAdapter.getPageMonth(findLastVisibleItemPosition));
                }
            });
        }
    }

    @NonNull
    private RecyclerView.ItemDecoration createItemDecoration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? new RecyclerView.ItemDecoration(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Calendar endItem;
            public final Calendar startItem;
            public final /* synthetic */ MaterialCalendar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.startItem = UtcDates.getUtcCalendar();
                this.endItem = UtcDates.getUtcCalendar();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                int width;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLLL(1048576, this, canvas, recyclerView, state) == null) && (recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                    YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    for (Pair<Long, Long> pair : this.this$0.dateSelector.getSelectedRanges()) {
                        Long l = pair.first;
                        if (l != null && pair.second != null) {
                            this.startItem.setTimeInMillis(l.longValue());
                            this.endItem.setTimeInMillis(pair.second.longValue());
                            int positionForYear = yearGridAdapter.getPositionForYear(this.startItem.get(1));
                            int positionForYear2 = yearGridAdapter.getPositionForYear(this.endItem.get(1));
                            View findViewByPosition = gridLayoutManager.findViewByPosition(positionForYear);
                            View findViewByPosition2 = gridLayoutManager.findViewByPosition(positionForYear2);
                            int spanCount = positionForYear / gridLayoutManager.getSpanCount();
                            int spanCount2 = positionForYear2 / gridLayoutManager.getSpanCount();
                            int i = spanCount;
                            while (i <= spanCount2) {
                                View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i);
                                if (findViewByPosition3 != null) {
                                    int top = findViewByPosition3.getTop() + this.this$0.calendarStyle.year.getTopInset();
                                    int bottom = findViewByPosition3.getBottom() - this.this$0.calendarStyle.year.getBottomInset();
                                    int left = i == spanCount ? findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2) : 0;
                                    if (i == spanCount2) {
                                        width = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                    } else {
                                        width = recyclerView.getWidth();
                                    }
                                    canvas.drawRect(left, top, width, bottom, this.this$0.calendarStyle.rangeFill);
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        } : (RecyclerView.ItemDecoration) invokeV.objValue;
    }

    @Px
    public static int getDayHeight(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07040c) : invokeL.intValue;
    }

    @NonNull
    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> dateSelector, int i, @NonNull CalendarConstraints calendarConstraints) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65548, null, dateSelector, i, calendarConstraints)) == null) {
            MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
            Bundle bundle = new Bundle();
            bundle.putInt(THEME_RES_ID_KEY, i);
            bundle.putParcelable(GRID_SELECTOR_KEY, dateSelector);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
            bundle.putParcelable(CURRENT_MONTH_KEY, calendarConstraints.getOpenAt());
            materialCalendar.setArguments(bundle);
            return materialCalendar;
        }
        return (MaterialCalendar) invokeLIL.objValue;
    }

    private void postSmoothRecyclerViewScroll(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i) == null) {
            this.recyclerView.post(new Runnable(this, i) { // from class: com.google.android.material.datepicker.MaterialCalendar.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;
                public final /* synthetic */ int val$position;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$position = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.recyclerView.smoothScrollToPosition(this.val$position);
                    }
                }
            });
        }
    }

    @Nullable
    public CalendarConstraints getCalendarConstraints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.calendarConstraints : (CalendarConstraints) invokeV.objValue;
    }

    public CalendarStyle getCalendarStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.calendarStyle : (CalendarStyle) invokeV.objValue;
    }

    @Nullable
    public Month getCurrentMonth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.current : (Month) invokeV.objValue;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    @Nullable
    public DateSelector<S> getDateSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.dateSelector : (DateSelector) invokeV.objValue;
    }

    @NonNull
    public LinearLayoutManager getLayoutManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (LinearLayoutManager) this.recyclerView.getLayoutManager() : (LinearLayoutManager) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle == null) {
                bundle = getArguments();
            }
            this.themeResId = bundle.getInt(THEME_RES_ID_KEY);
            this.dateSelector = (DateSelector) bundle.getParcelable(GRID_SELECTOR_KEY);
            this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
            this.current = (Month) bundle.getParcelable(CURRENT_MONTH_KEY);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
            this.calendarStyle = new CalendarStyle(contextThemeWrapper);
            LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
            Month start = this.calendarConstraints.getStart();
            if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
                i = R.layout.obfuscated_res_0x7f0d0561;
                i2 = 1;
            } else {
                i = R.layout.obfuscated_res_0x7f0d055c;
                i2 = 0;
            }
            View inflate = cloneInContext.inflate(i, viewGroup, false);
            GridView gridView = (GridView) inflate.findViewById(R.id.obfuscated_res_0x7f091436);
            ViewCompat.setAccessibilityDelegate(gridView, new AccessibilityDelegateCompat(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, accessibilityNodeInfoCompat) == null) {
                        super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.setCollectionInfo(null);
                    }
                }
            });
            gridView.setAdapter((ListAdapter) new DaysOfWeekAdapter());
            gridView.setNumColumns(start.daysInWeek);
            gridView.setEnabled(false);
            this.recyclerView = (RecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f091439);
            this.recyclerView.setLayoutManager(new SmoothCalendarLayoutManager(this, getContext(), i2, false, i2) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;
                public final /* synthetic */ int val$orientation;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, i2, r12);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r10, Integer.valueOf(i2), Boolean.valueOf(r12), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$orientation = i2;
                }

                @Override // androidx.recyclerview.widget.LinearLayoutManager
                public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, state, iArr) == null) {
                        if (this.val$orientation == 0) {
                            iArr[0] = this.this$0.recyclerView.getWidth();
                            iArr[1] = this.this$0.recyclerView.getWidth();
                            return;
                        }
                        iArr[0] = this.this$0.recyclerView.getHeight();
                        iArr[1] = this.this$0.recyclerView.getHeight();
                    }
                }
            });
            this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
            MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new OnDayClickListener(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCalendar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
                public void onDayClick(long j) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) && this.this$0.calendarConstraints.getDateValidator().isValid(j)) {
                        this.this$0.dateSelector.select(j);
                        Iterator<OnSelectionChangedListener<S>> it = this.this$0.onSelectionChangedListeners.iterator();
                        while (it.hasNext()) {
                            it.next().onSelectionChanged((S) this.this$0.dateSelector.getSelection());
                        }
                        this.this$0.recyclerView.getAdapter().notifyDataSetChanged();
                        if (this.this$0.yearSelector != null) {
                            this.this$0.yearSelector.getAdapter().notifyDataSetChanged();
                        }
                    }
                }
            });
            this.recyclerView.setAdapter(monthsPagerAdapter);
            int integer = contextThemeWrapper.getResources().getInteger(R.integer.obfuscated_res_0x7f0a0015);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f09143c);
            this.yearSelector = recyclerView;
            if (recyclerView != null) {
                recyclerView.setHasFixedSize(true);
                this.yearSelector.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
                this.yearSelector.setAdapter(new YearGridAdapter(this));
                this.yearSelector.addItemDecoration(createItemDecoration());
            }
            if (inflate.findViewById(R.id.obfuscated_res_0x7f091404) != null) {
                addActionsToMonthNavigation(inflate, monthsPagerAdapter);
            }
            if (!MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
                new LinearSnapHelper().attachToRecyclerView(this.recyclerView);
            }
            this.recyclerView.scrollToPosition(monthsPagerAdapter.getPosition(this.current));
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(THEME_RES_ID_KEY, this.themeResId);
            bundle.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
            bundle.putParcelable(CURRENT_MONTH_KEY, this.current);
        }
    }

    public void setCurrentMonth(Month month) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, month) == null) {
            MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
            int position = monthsPagerAdapter.getPosition(month);
            int position2 = position - monthsPagerAdapter.getPosition(this.current);
            boolean z = Math.abs(position2) > 3;
            boolean z2 = position2 > 0;
            this.current = month;
            if (z && z2) {
                this.recyclerView.scrollToPosition(position - 3);
                postSmoothRecyclerViewScroll(position);
            } else if (z) {
                this.recyclerView.scrollToPosition(position + 3);
                postSmoothRecyclerViewScroll(position);
            } else {
                postSmoothRecyclerViewScroll(position);
            }
        }
    }

    public void setSelector(CalendarSelector calendarSelector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, calendarSelector) == null) {
            this.calendarSelector = calendarSelector;
            if (calendarSelector == CalendarSelector.YEAR) {
                this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
                this.yearFrame.setVisibility(0);
                this.dayFrame.setVisibility(8);
            } else if (calendarSelector == CalendarSelector.DAY) {
                this.yearFrame.setVisibility(8);
                this.dayFrame.setVisibility(0);
                setCurrentMonth(this.current);
            }
        }
    }

    public void toggleVisibleSelector() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            CalendarSelector calendarSelector = this.calendarSelector;
            if (calendarSelector == CalendarSelector.YEAR) {
                setSelector(CalendarSelector.DAY);
            } else if (calendarSelector == CalendarSelector.DAY) {
                setSelector(CalendarSelector.YEAR);
            }
        }
    }
}
