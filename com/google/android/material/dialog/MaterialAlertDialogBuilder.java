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
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes6.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
    @AttrRes
    public static final int DEF_STYLE_ATTR = R.attr.alertDialogStyle;
    @StyleRes
    public static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;
    @AttrRes
    public static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;
    @Nullable
    public Drawable background;
    @NonNull
    @Dimension
    public final Rect backgroundInsets;

    public MaterialAlertDialogBuilder(@NonNull Context context) {
        this(context, 0);
    }

    public static Context createMaterialAlertDialogThemedContext(@NonNull Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        Context wrap = MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        return materialAlertDialogThemeOverlay == 0 ? wrap : new ContextThemeWrapper(wrap, materialAlertDialogThemeOverlay);
    }

    public static int getMaterialAlertDialogThemeOverlay(@NonNull Context context) {
        TypedValue resolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    public static int getOverridingThemeResId(@NonNull Context context, int i2) {
        return i2 == 0 ? getMaterialAlertDialogThemeOverlay(context) : i2;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public AlertDialog create() {
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

    @Nullable
    public Drawable getBackground() {
        return this.background;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackground(@Nullable Drawable drawable) {
        this.background = drawable;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetBottom(@Px int i2) {
        this.backgroundInsets.bottom = i2;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetEnd(@Px int i2) {
        if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.left = i2;
        } else {
            this.backgroundInsets.right = i2;
        }
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetStart(@Px int i2) {
        if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.right = i2;
        } else {
            this.backgroundInsets.left = i2;
        }
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetTop(@Px int i2) {
        this.backgroundInsets.top = i2;
        return this;
    }

    public MaterialAlertDialogBuilder(@NonNull Context context, int i2) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i2));
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
        return (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCancelable(boolean z) {
        return (MaterialAlertDialogBuilder) super.setCancelable(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCursor(@Nullable Cursor cursor, @Nullable DialogInterface.OnClickListener onClickListener, @NonNull String str) {
        return (MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCustomTitle(@Nullable View view) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIconAttribute(@AttrRes int i2) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnKeyListener(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@DrawableRes int i2) {
        return (MaterialAlertDialogBuilder) super.setIcon(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@ArrayRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(i2, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@StringRes int i2) {
        return (MaterialAlertDialogBuilder) super.setMessage(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i2, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(i2, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i2, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@StringRes int i2) {
        return (MaterialAlertDialogBuilder) super.setTitle(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(int i2) {
        return (MaterialAlertDialogBuilder) super.setView(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@Nullable CharSequence[] charSequenceArr, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@Nullable CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@ArrayRes int i2, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(i2, zArr, onMultiChoiceClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(@Nullable View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable CharSequence[] charSequenceArr, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@ArrayRes int i2, int i3, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(i2, i3, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable Cursor cursor, @NonNull String str, @NonNull String str2, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable Cursor cursor, int i2, @NonNull String str, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i2, str, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable CharSequence[] charSequenceArr, int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i2, onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable ListAdapter listAdapter, int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i2, onClickListener);
    }
}
