package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes7.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
    public static /* synthetic */ Interceptable $ic;
    @AttrRes
    public static final int DEF_STYLE_ATTR;
    @StyleRes
    public static final int DEF_STYLE_RES;
    @AttrRes
    public static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Drawable background;
    @NonNull
    @Dimension
    public final Rect backgroundInsets;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-606213406, "Lcom/google/android/material/dialog/MaterialAlertDialogBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-606213406, "Lcom/google/android/material/dialog/MaterialAlertDialogBuilder;");
                return;
            }
        }
        DEF_STYLE_ATTR = R.attr.alertDialogStyle;
        DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;
        MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialAlertDialogBuilder(@NonNull Context context) {
        this(context, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static Context createMaterialAlertDialogThemedContext(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
            Context wrap = MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
            return materialAlertDialogThemeOverlay == 0 ? wrap : new ContextThemeWrapper(wrap, materialAlertDialogThemeOverlay);
        }
        return (Context) invokeL.objValue;
    }

    public static int getMaterialAlertDialogThemeOverlay(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            TypedValue resolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
            if (resolve == null) {
                return 0;
            }
            return resolve.data;
        }
        return invokeL.intValue;
    }

    public static int getOverridingThemeResId(@NonNull Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2)) == null) ? i2 == 0 ? getMaterialAlertDialogThemeOverlay(context) : i2 : invokeLI.intValue;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public AlertDialog create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlertDialog create = super.create();
            Window window = create.getWindow();
            View decorView = window.getDecorView();
            Drawable drawable = this.background;
            if (drawable instanceof MaterialShapeDrawable) {
                ((MaterialShapeDrawable) drawable).setElevation(ViewCompat.getElevation(decorView));
            }
            window.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
            decorView.setOnTouchListener(new InsetDialogOnTouchListener(create, this.backgroundInsets));
            return create;
        }
        return (AlertDialog) invokeV.objValue;
    }

    @Nullable
    public Drawable getBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.background : (Drawable) invokeV.objValue;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackground(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, drawable)) == null) {
            this.background = drawable;
            return this;
        }
        return (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetBottom(@Px int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.backgroundInsets.bottom = i2;
            return this;
        }
        return (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetEnd(@Px int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
                this.backgroundInsets.left = i2;
            } else {
                this.backgroundInsets.right = i2;
            }
            return this;
        }
        return (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetStart(@Px int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
                this.backgroundInsets.right = i2;
            } else {
                this.backgroundInsets.left = i2;
            }
            return this;
        }
        return (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetTop(@Px int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.backgroundInsets.top = i2;
            return this;
        }
        return (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialAlertDialogBuilder(@NonNull Context context, int i2) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, DEF_STYLE_ATTR, DEF_STYLE_RES);
        int color = MaterialColors.getColor(context2, R.attr.colorSurface, MaterialAlertDialogBuilder.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setAdapter(@Nullable ListAdapter listAdapter, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, listAdapter, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener) : (MaterialAlertDialogBuilder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCancelable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) ? (MaterialAlertDialogBuilder) super.setCancelable(z) : (MaterialAlertDialogBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCursor(@Nullable Cursor cursor, @Nullable DialogInterface.OnClickListener onClickListener, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, cursor, onClickListener, str)) == null) ? (MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str) : (MaterialAlertDialogBuilder) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCustomTitle(@Nullable View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view)) == null) ? (MaterialAlertDialogBuilder) super.setCustomTitle(view) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIconAttribute(@AttrRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? (MaterialAlertDialogBuilder) super.setIconAttribute(i2) : (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButtonIcon(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, drawable)) == null) ? (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButtonIcon(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, drawable)) == null) ? (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, onCancelListener)) == null) ? (MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, onDismissListener)) == null) ? (MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, onItemSelectedListener)) == null) ? (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnKeyListener(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, onKeyListener)) == null) ? (MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButtonIcon(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, drawable)) == null) ? (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? (MaterialAlertDialogBuilder) super.setIcon(i2) : (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@ArrayRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048599, this, i2, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setItems(i2, onClickListener) : (MaterialAlertDialogBuilder) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) ? (MaterialAlertDialogBuilder) super.setMessage(i2) : (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i2, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setNegativeButton(i2, onClickListener) : (MaterialAlertDialogBuilder) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048619, this, i2, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setNeutralButton(i2, onClickListener) : (MaterialAlertDialogBuilder) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048633, this, i2, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setPositiveButton(i2, onClickListener) : (MaterialAlertDialogBuilder) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048647, this, i2)) == null) ? (MaterialAlertDialogBuilder) super.setTitle(i2) : (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i2)) == null) ? (MaterialAlertDialogBuilder) super.setView(i2) : (MaterialAlertDialogBuilder) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, drawable)) == null) ? (MaterialAlertDialogBuilder) super.setIcon(drawable) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@Nullable CharSequence[] charSequenceArr, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, charSequenceArr, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener) : (MaterialAlertDialogBuilder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@Nullable CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, charSequence)) == null) ? (MaterialAlertDialogBuilder) super.setMessage(charSequence) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@ArrayRes int i2, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048608, this, i2, zArr, onMultiChoiceClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setMultiChoiceItems(i2, zArr, onMultiChoiceClickListener) : (MaterialAlertDialogBuilder) invokeILL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048614, this, charSequence, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener) : (MaterialAlertDialogBuilder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, charSequence, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener) : (MaterialAlertDialogBuilder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, charSequence, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener) : (MaterialAlertDialogBuilder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, charSequence)) == null) ? (MaterialAlertDialogBuilder) super.setTitle(charSequence) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(@Nullable View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, view)) == null) ? (MaterialAlertDialogBuilder) super.setView(view) : (MaterialAlertDialogBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable CharSequence[] charSequenceArr, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, charSequenceArr, zArr, onMultiChoiceClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener) : (MaterialAlertDialogBuilder) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@ArrayRes int i2, int i3, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048641, this, i2, i3, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setSingleChoiceItems(i2, i3, onClickListener) : (MaterialAlertDialogBuilder) invokeIIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable Cursor cursor, @NonNull String str, @NonNull String str2, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048609, this, cursor, str, str2, onMultiChoiceClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener) : (MaterialAlertDialogBuilder) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable Cursor cursor, int i2, @NonNull String str, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048642, this, cursor, i2, str, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i2, str, onClickListener) : (MaterialAlertDialogBuilder) invokeLILL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable CharSequence[] charSequenceArr, int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048644, this, charSequenceArr, i2, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i2, onClickListener) : (MaterialAlertDialogBuilder) invokeLIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable ListAdapter listAdapter, int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048643, this, listAdapter, i2, onClickListener)) == null) ? (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i2, onClickListener) : (MaterialAlertDialogBuilder) invokeLIL.objValue;
    }
}
