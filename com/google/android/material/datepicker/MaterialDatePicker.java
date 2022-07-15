package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes4.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    public static final Object CANCEL_BUTTON_TAG;
    public static final Object CONFIRM_BUTTON_TAG;
    public static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    public static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    public static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    public static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    public static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    public static final Object TOGGLE_BUTTON_TAG;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MaterialShapeDrawable background;
    public MaterialCalendar<S> calendar;
    @Nullable
    public CalendarConstraints calendarConstraints;
    public Button confirmButton;
    @Nullable
    public DateSelector<S> dateSelector;
    public boolean fullscreen;
    public TextView headerSelectionText;
    public CheckableImageButton headerToggleButton;
    public int inputMode;
    public final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners;
    public final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners;
    public final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners;
    public final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners;
    @StyleRes
    public int overrideThemeResId;
    public PickerFragment<S> pickerFragment;
    public CharSequence titleText;
    @StringRes
    public int titleTextResId;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes4.dex */
    public @interface InputMode {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-328593071, "Lcom/google/android/material/datepicker/MaterialDatePicker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-328593071, "Lcom/google/android/material/datepicker/MaterialDatePicker;");
                return;
            }
        }
        CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
        CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
        TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    }

    public MaterialDatePicker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.onPositiveButtonClickListeners = new LinkedHashSet<>();
        this.onNegativeButtonClickListeners = new LinkedHashSet<>();
        this.onCancelListeners = new LinkedHashSet<>();
        this.onDismissListeners = new LinkedHashSet<>();
    }

    @NonNull
    public static Drawable createHeaderToggleDrawable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, R.drawable.obfuscated_res_0x7f080cd8));
            stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.obfuscated_res_0x7f080cda));
            return stateListDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public static int getDialogPickerHeight(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070470) + resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070471) + resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07046f) + resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070460) + (MonthAdapter.MAXIMUM_WEEKS * resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07045b)) + ((MonthAdapter.MAXIMUM_WEEKS - 1) * resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07046e)) + resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070458);
        }
        return invokeL.intValue;
    }

    public static int getPaddedPickerWidth(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            Resources resources = context.getResources();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070459);
            int i = Month.current().daysInWeek;
            return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07045f) * i) + ((i - 1) * resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07046d));
        }
        return invokeL.intValue;
    }

    private int getThemeResId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, context)) == null) {
            int i = this.overrideThemeResId;
            return i != 0 ? i : this.dateSelector.getDefaultThemeResId(context);
        }
        return invokeL.intValue;
    }

    private void initHeaderToggle(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
            this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(context));
            this.headerToggleButton.setChecked(this.inputMode != 0);
            ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
            updateToggleContentDescription(this.headerToggleButton);
            this.headerToggleButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialDatePicker this$0;

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
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.confirmButton.setEnabled(this.this$0.dateSelector.isSelectionComplete());
                        this.this$0.headerToggleButton.toggle();
                        MaterialDatePicker materialDatePicker = this.this$0;
                        materialDatePicker.updateToggleContentDescription(materialDatePicker.headerToggleButton);
                        this.this$0.startPickerFragment();
                    }
                }
            });
        }
    }

    public static boolean isFullscreen(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.obfuscated_res_0x7f04045b, MaterialCalendar.class.getCanonicalName()), new int[]{16843277});
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            return z;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static <S> MaterialDatePicker<S> newInstance(@NonNull Builder<S> builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, builder)) == null) {
            MaterialDatePicker<S> materialDatePicker = new MaterialDatePicker<>();
            Bundle bundle = new Bundle();
            bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
            bundle.putParcelable("DATE_SELECTOR_KEY", builder.dateSelector);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.calendarConstraints);
            bundle.putInt(TITLE_TEXT_RES_ID_KEY, builder.titleTextResId);
            bundle.putCharSequence(TITLE_TEXT_KEY, builder.titleText);
            bundle.putInt(INPUT_MODE_KEY, builder.inputMode);
            materialDatePicker.setArguments(bundle);
            return materialDatePicker;
        }
        return (MaterialDatePicker) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPickerFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.calendar = MaterialCalendar.newInstance(this.dateSelector, getThemeResId(requireContext()), this.calendarConstraints);
            this.pickerFragment = this.headerToggleButton.isChecked() ? MaterialTextInputPicker.newInstance(this.dateSelector, this.calendarConstraints) : this.calendar;
            updateHeader();
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.obfuscated_res_0x7f0914d1, this.pickerFragment);
            beginTransaction.commitNow();
            this.pickerFragment.addOnSelectionChangedListener(new OnSelectionChangedListener<S>(this) { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialDatePicker this$0;

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

                @Override // com.google.android.material.datepicker.OnSelectionChangedListener
                public void onIncompleteSelectionChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.confirmButton.setEnabled(false);
                    }
                }

                @Override // com.google.android.material.datepicker.OnSelectionChangedListener
                public void onSelectionChanged(S s) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s) == null) {
                        this.this$0.updateHeader();
                        this.this$0.confirmButton.setEnabled(this.this$0.dateSelector.isSelectionComplete());
                    }
                }
            });
        }
    }

    public static long thisMonthInUtcMilliseconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? Month.current().timeInMillis : invokeV.longValue;
    }

    public static long todayInUtcMilliseconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? UtcDates.getTodayCalendar().getTimeInMillis() : invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            String headerText = getHeaderText();
            this.headerSelectionText.setContentDescription(String.format(getString(R.string.obfuscated_res_0x7f0f0af5), headerText));
            this.headerSelectionText.setText(headerText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToggleContentDescription(@NonNull CheckableImageButton checkableImageButton) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, checkableImageButton) == null) {
            if (this.headerToggleButton.isChecked()) {
                string = checkableImageButton.getContext().getString(R.string.obfuscated_res_0x7f0f0b0e);
            } else {
                string = checkableImageButton.getContext().getString(R.string.obfuscated_res_0x7f0f0b10);
            }
            this.headerToggleButton.setContentDescription(string);
        }
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) ? this.onCancelListeners.add(onCancelListener) : invokeL.booleanValue;
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onDismissListener)) == null) ? this.onDismissListeners.add(onDismissListener) : invokeL.booleanValue;
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener)) == null) ? this.onNegativeButtonClickListeners.add(onClickListener) : invokeL.booleanValue;
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, materialPickerOnPositiveButtonClickListener)) == null) ? this.onPositiveButtonClickListeners.add(materialPickerOnPositiveButtonClickListener) : invokeL.booleanValue;
    }

    public void clearOnCancelListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.onCancelListeners.clear();
        }
    }

    public void clearOnDismissListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.onDismissListeners.clear();
        }
    }

    public void clearOnNegativeButtonClickListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.onNegativeButtonClickListeners.clear();
        }
    }

    public void clearOnPositiveButtonClickListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.onPositiveButtonClickListeners.clear();
        }
    }

    public String getHeaderText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.dateSelector.getSelectionDisplayString(getContext()) : (String) invokeV.objValue;
    }

    @Nullable
    public final S getSelection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.dateSelector.getSelection() : (S) invokeV.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dialogInterface) == null) {
            Iterator<DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
            while (it.hasNext()) {
                it.next().onCancel(dialogInterface);
            }
            super.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle == null) {
                bundle = getArguments();
            }
            this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID);
            this.dateSelector = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
            this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
            this.titleTextResId = bundle.getInt(TITLE_TEXT_RES_ID_KEY);
            this.titleText = bundle.getCharSequence(TITLE_TEXT_KEY);
            this.inputMode = bundle.getInt(INPUT_MODE_KEY);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bundle)) == null) {
            Dialog dialog = new Dialog(requireContext(), getThemeResId(requireContext()));
            Context context = dialog.getContext();
            this.fullscreen = isFullscreen(context);
            int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.obfuscated_res_0x7f040171, MaterialDatePicker.class.getCanonicalName());
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.obfuscated_res_0x7f04045b, R.style.obfuscated_res_0x7f100362);
            this.background = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            this.background.setFillColor(ColorStateList.valueOf(resolveOrThrow));
            this.background.setElevation(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
            return dialog;
        }
        return (Dialog) invokeL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(this.fullscreen ? R.layout.obfuscated_res_0x7f0d057e : R.layout.obfuscated_res_0x7f0d057d, viewGroup);
            Context context = inflate.getContext();
            if (this.fullscreen) {
                inflate.findViewById(R.id.obfuscated_res_0x7f0914d1).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
            } else {
                View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0914d2);
                View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f0914d1);
                findViewById.setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
                findViewById2.setMinimumHeight(getDialogPickerHeight(requireContext()));
            }
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914dd);
            this.headerSelectionText = textView;
            ViewCompat.setAccessibilityLiveRegion(textView, 1);
            this.headerToggleButton = (CheckableImageButton) inflate.findViewById(R.id.obfuscated_res_0x7f0914df);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914e3);
            CharSequence charSequence = this.titleText;
            if (charSequence != null) {
                textView2.setText(charSequence);
            } else {
                textView2.setText(this.titleTextResId);
            }
            initHeaderToggle(context);
            this.confirmButton = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f090693);
            if (this.dateSelector.isSelectionComplete()) {
                this.confirmButton.setEnabled(true);
            } else {
                this.confirmButton.setEnabled(false);
            }
            this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
            this.confirmButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialDatePicker this$0;

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

                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        Iterator it = this.this$0.onPositiveButtonClickListeners.iterator();
                        while (it.hasNext()) {
                            ((MaterialPickerOnPositiveButtonClickListener) it.next()).onPositiveButtonClick(this.this$0.getSelection());
                        }
                        this.this$0.dismiss();
                    }
                }
            });
            Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f09046f);
            button.setTag(CANCEL_BUTTON_TAG);
            button.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialDatePicker this$0;

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
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        Iterator it = this.this$0.onNegativeButtonClickListeners.iterator();
                        while (it.hasNext()) {
                            ((View.OnClickListener) it.next()).onClick(view2);
                        }
                        this.this$0.dismiss();
                    }
                }
            });
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dialogInterface) == null) {
            Iterator<DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
            while (it.hasNext()) {
                it.next().onDismiss(dialogInterface);
            }
            ViewGroup viewGroup = (ViewGroup) getView();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            super.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
            bundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
            CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.calendarConstraints);
            if (this.calendar.getCurrentMonth() != null) {
                builder.setOpenAt(this.calendar.getCurrentMonth().timeInMillis);
            }
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.build());
            bundle.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
            bundle.putCharSequence(TITLE_TEXT_KEY, this.titleText);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onStart();
            Window window = requireDialog().getWindow();
            if (this.fullscreen) {
                window.setLayout(-1, -1);
                window.setBackgroundDrawable(this.background);
            } else {
                window.setLayout(-2, -2);
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070461);
                Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
                window.setBackgroundDrawable(new InsetDrawable((Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
                window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
            }
            startPickerFragment();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.pickerFragment.clearOnSelectionChangedListeners();
            super.onStop();
        }
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, onCancelListener)) == null) ? this.onCancelListeners.remove(onCancelListener) : invokeL.booleanValue;
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, onDismissListener)) == null) ? this.onDismissListeners.remove(onDismissListener) : invokeL.booleanValue;
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, onClickListener)) == null) ? this.onNegativeButtonClickListeners.remove(onClickListener) : invokeL.booleanValue;
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, materialPickerOnPositiveButtonClickListener)) == null) ? this.onPositiveButtonClickListeners.remove(materialPickerOnPositiveButtonClickListener) : invokeL.booleanValue;
    }

    /* loaded from: classes4.dex */
    public static final class Builder<S> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CalendarConstraints calendarConstraints;
        public final DateSelector<S> dateSelector;
        public int inputMode;
        public int overrideThemeResId;
        @Nullable
        public S selection;
        public CharSequence titleText;
        public int titleTextResId;

        public Builder(DateSelector<S> dateSelector) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dateSelector};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.overrideThemeResId = 0;
            this.titleTextResId = 0;
            this.titleText = null;
            this.selection = null;
            this.inputMode = 0;
            this.dateSelector = dateSelector;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> dateSelector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dateSelector)) == null) ? new Builder<>(dateSelector) : (Builder) invokeL.objValue;
        }

        @NonNull
        public static Builder<Long> datePicker() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new Builder<>(new SingleDateSelector()) : (Builder) invokeV.objValue;
        }

        @NonNull
        public static Builder<Pair<Long, Long>> dateRangePicker() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new Builder<>(new RangeDateSelector()) : (Builder) invokeV.objValue;
        }

        @NonNull
        public MaterialDatePicker<S> build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.calendarConstraints == null) {
                    this.calendarConstraints = new CalendarConstraints.Builder().build();
                }
                if (this.titleTextResId == 0) {
                    this.titleTextResId = this.dateSelector.getDefaultTitleResId();
                }
                S s = this.selection;
                if (s != null) {
                    this.dateSelector.setSelection(s);
                }
                return MaterialDatePicker.newInstance(this);
            }
            return (MaterialDatePicker) invokeV.objValue;
        }

        @NonNull
        public Builder<S> setCalendarConstraints(CalendarConstraints calendarConstraints) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, calendarConstraints)) == null) {
                this.calendarConstraints = calendarConstraints;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder<S> setInputMode(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.inputMode = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder<S> setSelection(S s) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, s)) == null) {
                this.selection = s;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder<S> setTheme(@StyleRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.overrideThemeResId = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder<S> setTitleText(@StringRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.titleTextResId = i;
                this.titleText = null;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder<S> setTitleText(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, charSequence)) == null) {
                this.titleText = charSequence;
                this.titleTextResId = 0;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }
}
