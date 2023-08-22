package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.b.kwai.a;
/* loaded from: classes10.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    public TextProgressBar bZ;
    public View ca;
    public Context mContext;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        E(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        E(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        E(context);
    }

    private void E(Context context) {
        this.mContext = context;
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0498, this);
        this.bZ = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f0912c3);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0912c4);
        this.ca = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void f(String str, int i) {
        View view2;
        int i2;
        if (i == 0 || i == getMax()) {
            view2 = this.ca;
            i2 = 0;
        } else {
            view2 = this.ca;
            i2 = 8;
        }
        view2.setVisibility(i2);
        this.bZ.f(str, i);
    }

    public int getMax() {
        return this.bZ.getMax();
    }

    public void setTextColor(int i) {
        this.bZ.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.bZ.setTextDimen(a.a(getContext(), i));
    }
}
