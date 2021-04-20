package com.kwad.sdk.contentalliance.detail.photo.f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class g extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f32655a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32656b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f32657c;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32655a = null;
        this.f32656b = null;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_comment_button_2, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_photo_comment_button);
        this.f32655a = imageView;
        b.a(imageView, new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.f32657c != null) {
                    g.this.f32657c.onClick(g.this);
                }
            }
        });
        this.f32656b = (TextView) findViewById(R.id.ksad_photo_comment_count_text);
    }

    public void setCommentCount(long j) {
        this.f32656b.setText(ag.a(j, "评论"));
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f32657c = onClickListener;
    }
}
