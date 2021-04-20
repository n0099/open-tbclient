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
/* loaded from: classes6.dex */
public class DrawDownloadProgressBar extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f34892a;

    /* renamed from: b  reason: collision with root package name */
    public TextProgressBar f34893b;

    /* renamed from: c  reason: collision with root package name */
    public View f34894c;

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
        this.f34892a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.f34893b = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View findViewById = findViewById(R.id.ksad_download_progress_cover);
        this.f34894c = findViewById;
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
            view = this.f34894c;
            i2 = 0;
        } else {
            view = this.f34894c;
            i2 = 8;
        }
        view.setVisibility(i2);
        this.f34893b.a(str, i);
    }

    public int getMax() {
        return this.f34893b.getMax();
    }

    public void setTextColor(int i) {
        this.f34893b.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.f34893b.setTextDimen(ao.a(getContext(), i));
    }
}
