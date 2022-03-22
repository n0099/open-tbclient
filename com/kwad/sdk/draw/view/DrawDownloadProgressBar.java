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
/* loaded from: classes7.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextProgressBar f40365b;

    /* renamed from: c  reason: collision with root package name */
    public View f40366c;

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
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0430, this);
        this.f40365b = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091073);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091074);
        this.f40366c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public void a(String str, int i) {
        View view;
        int i2;
        if (i == 0 || i == getMax()) {
            view = this.f40366c;
            i2 = 0;
        } else {
            view = this.f40366c;
            i2 = 8;
        }
        view.setVisibility(i2);
        this.f40365b.a(str, i);
    }

    public int getMax() {
        return this.f40365b.getMax();
    }

    public void setTextColor(int i) {
        this.f40365b.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.f40365b.setTextDimen(a.a(getContext(), i));
    }
}
