package com.kwad.sdk.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.utils.ao;
/* loaded from: classes5.dex */
public class DrawDownloadProgressBar extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f10013a;

    /* renamed from: b  reason: collision with root package name */
    private TextProgressBar f10014b;
    private View c;

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
        this.f10013a = context;
        inflate(this.f10013a, R.layout.ksad_draw_download_bar, this);
        this.f10014b = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        this.c = findViewById(R.id.ksad_download_progress_cover);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public void a(String str, int i) {
        if (i == 0 || i == getMax()) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        this.f10014b.a(str, i);
    }

    public int getMax() {
        return this.f10014b.getMax();
    }

    public void setTextColor(int i) {
        this.f10014b.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.f10014b.setTextDimen(ao.a(getContext(), i));
    }
}
