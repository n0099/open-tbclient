package com.kwad.sdk.contentalliance.detail.ad.presenter.comment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.comment.f;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CommentAdItemView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f8372a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8373b;
    private ImageView c;
    private RelativeLayout d;
    private TextView e;
    private List<f> f;

    /* loaded from: classes3.dex */
    private static class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        private View.OnClickListener f8380a;

        /* renamed from: b  reason: collision with root package name */
        private int f8381b;

        public a(View.OnClickListener onClickListener, int i) {
            this.f8380a = onClickListener;
            this.f8381b = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.f8380a != null) {
                this.f8380a.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.linkColor = this.f8381b;
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    public CommentAdItemView(Context context) {
        super(context);
        this.f = new ArrayList();
        a();
    }

    public CommentAdItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new ArrayList();
        a();
    }

    public CommentAdItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new ArrayList();
        a();
    }

    private void a() {
        com.kwad.sdk.core.d.a.a("CommentAdItemView", "initView");
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_ad_item, (ViewGroup) this, true);
        this.f8373b = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
        this.c = (ImageView) findViewById(R.id.ksad_photo_comment_item_flag_img);
        this.f8372a = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
        this.d = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
        this.e = (TextView) this.d.findViewById(R.id.ksad_photo_comment_item_comment);
        this.f8373b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentAdItemView.this.a(49);
            }
        });
        this.f8372a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentAdItemView.this.a(47);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        for (f fVar : this.f) {
            fVar.a(i);
        }
    }

    public void a(AdTemplate adTemplate, @Nullable List<f> list) {
        if (adTemplate == null) {
            return;
        }
        if (list != null) {
            this.f = list;
        }
        setAuthorIcon(c.q(adTemplate));
        setName(c.v(adTemplate));
        a(c.x(adTemplate), com.kwad.sdk.core.response.b.a.x(c.j(adTemplate)));
        this.c.setVisibility(0);
    }

    protected void a(final String str, final String str2) {
        this.e.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.3
            @Override // java.lang.Runnable
            public void run() {
                int length;
                CommentAdItemView.this.e.setText(str);
                String str3 = str;
                CommentAdItemView.this.requestLayout();
                Layout layout = CommentAdItemView.this.e.getLayout();
                if ((layout != null ? layout.getLineCount() : 0) >= 4) {
                    String str4 = "";
                    String charSequence = CommentAdItemView.this.e.getText().toString();
                    for (int i = 0; i < 4; i++) {
                        str4 = str4 + charSequence.substring(layout.getLineStart(i), layout.getLineEnd(i));
                    }
                    if (((str4.length() - str2.length()) - 3) - StringHelper.STRING_MORE.length() > 0) {
                        str3 = str4.substring(0, length) + StringHelper.STRING_MORE;
                    }
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int length2 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str3);
                spannableStringBuilder.setSpan(new a(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CommentAdItemView.this.a(48);
                    }
                }, Color.parseColor("#131924")), length2, str3.length() + length2, 33);
                spannableStringBuilder.append((CharSequence) " ");
                int length3 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) "${ad}");
                Drawable drawable = CommentAdItemView.this.getContext().getResources().getDrawable(R.drawable.ksad_photo_comment_ad_item_link_img);
                spannableStringBuilder.setSpan(new com.kwad.sdk.core.view.c(drawable, "${ad}").a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()), length3, "${ad}".length() + length3, 33);
                int length4 = length3 + "${ad}".length();
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(new a(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.3.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CommentAdItemView.this.a(8);
                    }
                }, Color.parseColor("#18407D")), length4, str2.length() + length4, 33);
                CommentAdItemView.this.e.setMovementMethod(LinkMovementMethod.getInstance());
                CommentAdItemView.this.e.setText(spannableStringBuilder);
            }
        });
    }

    public void setAuthorIcon(String str) {
        com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f8373b);
    }

    public void setName(String str) {
        this.f8372a.setText(str);
    }
}
