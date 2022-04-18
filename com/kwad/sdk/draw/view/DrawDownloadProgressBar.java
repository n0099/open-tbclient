package com.kwad.sdk.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.a.kwai.a;
import com.kwad.sdk.core.page.widget.TextProgressBar;
/* loaded from: classes5.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    public Context a;
    public TextProgressBar b;
    public View c;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        a(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d042b, this);
        this.b = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09106d);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09106e);
        this.c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public void a(String str, int i) {
        View view2;
        int i2;
        if (i == 0 || i == getMax()) {
            view2 = this.c;
            i2 = 0;
        } else {
            view2 = this.c;
            i2 = 8;
        }
        view2.setVisibility(i2);
        this.b.a(str, i);
    }

    public int getMax() {
        return this.b.getMax();
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.b.setTextDimen(a.a(getContext(), i));
    }
}
