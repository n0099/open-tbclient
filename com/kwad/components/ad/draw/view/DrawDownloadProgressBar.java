package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.d.a.a;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    public TextProgressBar dh;
    public View di;
    public Context mContext;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04c2, this);
        this.dh = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091355);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091356);
        this.di = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public void setTextColor(int i) {
        this.dh.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.dh.setTextDimen(a.a(getContext(), i));
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public final void e(String str, int i) {
        if (i != 0 && i != getMax()) {
            this.di.setVisibility(8);
        } else {
            this.di.setVisibility(0);
        }
        this.dh.e(str, i);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    public int getMax() {
        return this.dh.getMax();
    }
}
