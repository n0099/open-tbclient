package com.kwad.sdk.contentalliance.detail.photo.f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
/* loaded from: classes5.dex */
public class e extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f8815a;

    /* renamed from: b  reason: collision with root package name */
    private View.OnClickListener f8816b;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8815a = null;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_more_button_2, (ViewGroup) this, true);
        this.f8815a = (ImageView) findViewById(R.id.ksad_photo_more_button);
        b.a(this.f8815a, new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f8816b != null) {
                    e.this.f8816b.onClick(e.this);
                }
            }
        });
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f8816b = onClickListener;
    }
}
