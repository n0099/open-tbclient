package com.kwad.sdk.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class DrawDownloadProgressBar extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f33203a;

    /* renamed from: b  reason: collision with root package name */
    public TextProgressBar f33204b;

    /* renamed from: c  reason: collision with root package name */
    public View f33205c;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        a(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f33203a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.f33204b = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View findViewById = findViewById(R.id.ksad_download_progress_cover);
        this.f33205c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public void a(String str, int i2) {
        View view;
        int i3;
        if (i2 == 0 || i2 == getMax()) {
            view = this.f33205c;
            i3 = 0;
        } else {
            view = this.f33205c;
            i3 = 8;
        }
        view.setVisibility(i3);
        this.f33204b.a(str, i2);
    }

    public int getMax() {
        return this.f33204b.getMax();
    }

    public void setTextColor(int i2) {
        this.f33204b.setTextColor(i2);
    }

    public void setTextSize(int i2) {
        this.f33204b.setTextDimen(an.a(getContext(), i2));
    }
}
