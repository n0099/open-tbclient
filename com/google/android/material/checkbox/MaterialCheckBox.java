package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
import com.baidu.tieba.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes9.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    public static final int DEF_STYLE_RES = 2131755895;
    public static final int[][] ENABLED_CHECKED_STATES = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    @Nullable
    public ColorStateList materialThemeColorsTintList;
    public boolean useMaterialThemeColors;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040138);
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialCheckBox, i, DEF_STYLE_RES, new int[0]);
        if (obtainStyledAttributes.hasValue(0)) {
            CompoundButtonCompat.setButtonTintList(this, MaterialResources.getColorStateList(context2, obtainStyledAttributes, 0));
        }
        this.useMaterialThemeColors = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            int color = MaterialColors.getColor(this, R.attr.obfuscated_res_0x7f04017b);
            int color2 = MaterialColors.getColor(this, R.attr.obfuscated_res_0x7f040190);
            int color3 = MaterialColors.getColor(this, R.attr.obfuscated_res_0x7f040189);
            iArr[0] = MaterialColors.layer(color2, color, 1.0f);
            iArr[1] = MaterialColors.layer(color2, color3, 0.54f);
            iArr[2] = MaterialColors.layer(color2, color3, 0.38f);
            iArr[3] = MaterialColors.layer(color2, color3, 0.38f);
            this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }
}
