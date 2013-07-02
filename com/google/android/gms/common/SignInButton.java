package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.internal.aa;
import com.google.android.gms.internal.x;
import com.google.android.gms.internal.z;
/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {
    private int a;
    private int b;
    private View c;
    private View.OnClickListener d;

    private static Button a(Context context, int i, int i2) {
        aa aaVar = new aa(context);
        aaVar.a(context.getResources(), i, i2);
        return aaVar;
    }

    private void a(Context context) {
        if (this.c != null) {
            removeView(this.c);
        }
        try {
            this.c = z.a(context, this.a, this.b);
        } catch (z.a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.c = a(context, this.a, this.b);
        }
        addView(this.c);
        this.c.setEnabled(isEnabled());
        this.c.setOnClickListener(this);
    }

    public void a(int i, int i2) {
        boolean z = true;
        x.a(i >= 0 && i < 3, "Unknown button size " + i);
        if (i2 < 0 || i2 >= 2) {
            z = false;
        }
        x.a(z, "Unknown color scheme " + i2);
        this.a = i;
        this.b = i2;
        a(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d == null || view != this.c) {
            return;
        }
        this.d.onClick(this);
    }

    public void setColorScheme(int i) {
        a(this.a, i);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.c.setEnabled(z);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
        if (this.c != null) {
            this.c.setOnClickListener(this);
        }
    }

    public void setSize(int i) {
        a(i, this.b);
    }
}
