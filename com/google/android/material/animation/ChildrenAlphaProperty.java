package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    public ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    @NonNull
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f = (Float) viewGroup.getTag(R.id.obfuscated_res_0x7f0917d9);
        if (f != null) {
            return f;
        }
        return Float.valueOf(1.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f) {
        float floatValue = f.floatValue();
        viewGroup.setTag(R.id.obfuscated_res_0x7f0917d9, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(floatValue);
        }
    }
}
