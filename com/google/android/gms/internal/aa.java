package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.R;
/* loaded from: classes.dex */
public final class aa extends Button {
    public aa(Context context) {
        this(context, null);
    }

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private int a(int i, int i2, int i3) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void a(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void b(Resources resources, int i, int i2) {
        int a;
        switch (i) {
            case 0:
            case 1:
                a = a(i2, R.drawable.common_signin_btn_text_dark, R.drawable.common_signin_btn_text_light);
                break;
            case 2:
                a = a(i2, R.drawable.common_signin_btn_icon_dark, R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (a == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(a));
    }

    private void c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(a(i2, R.color.common_signin_btn_text_dark, R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(R.string.common_signin_button_text_long));
                return;
            case 2:
                setText((CharSequence) null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    public void a(Resources resources, int i, int i2) {
        boolean z = true;
        x.a(i >= 0 && i < 3, "Unknown button size " + i);
        if (i2 < 0 || i2 >= 2) {
            z = false;
        }
        x.a(z, "Unknown color scheme " + i2);
        a(resources);
        b(resources, i, i2);
        c(resources, i, i2);
    }
}
