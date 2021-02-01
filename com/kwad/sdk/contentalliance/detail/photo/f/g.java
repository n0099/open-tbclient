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
/* loaded from: classes3.dex */
public class g extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f8520a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f8521b;
    private View.OnClickListener c;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8520a = null;
        this.f8521b = null;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_comment_button_2, (ViewGroup) this, true);
        this.f8520a = (ImageView) findViewById(R.id.ksad_photo_comment_button);
        b.a(this.f8520a, new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.c != null) {
                    g.this.c.onClick(g.this);
                }
            }
        });
        this.f8521b = (TextView) findViewById(R.id.ksad_photo_comment_count_text);
    }

    public void setCommentCount(long j) {
        this.f8521b.setText(ag.a(j, "评论"));
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.c = onClickListener;
    }
}
