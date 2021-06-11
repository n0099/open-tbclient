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
import com.baidu.tbadk.core.util.StringHelper;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.comment.f;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class CommentAdItemView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f32657a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32658b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32659c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f32660d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32661e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f32662f;

    /* loaded from: classes6.dex */
    public static class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f32670a;

        /* renamed from: b  reason: collision with root package name */
        public int f32671b;

        public a(View.OnClickListener onClickListener, int i2) {
            this.f32670a = onClickListener;
            this.f32671b = i2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f32670a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i2 = this.f32671b;
            textPaint.linkColor = i2;
            textPaint.setColor(i2);
            textPaint.setUnderlineText(false);
        }
    }

    public CommentAdItemView(Context context) {
        super(context);
        this.f32662f = new ArrayList();
        a();
    }

    public CommentAdItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32662f = new ArrayList();
        a();
    }

    public CommentAdItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f32662f = new ArrayList();
        a();
    }

    private void a() {
        com.kwad.sdk.core.d.a.a("CommentAdItemView", "initView");
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_ad_item, (ViewGroup) this, true);
        this.f32658b = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
        this.f32659c = (ImageView) findViewById(R.id.ksad_photo_comment_item_flag_img);
        this.f32657a = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
        this.f32660d = relativeLayout;
        this.f32661e = (TextView) relativeLayout.findViewById(R.id.ksad_photo_comment_item_comment);
        this.f32658b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentAdItemView.this.a(49);
            }
        });
        this.f32657a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentAdItemView.this.a(47);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        for (f fVar : this.f32662f) {
            fVar.a(i2);
        }
    }

    public void a(AdTemplate adTemplate, @Nullable List<f> list) {
        if (adTemplate == null) {
            return;
        }
        if (list != null) {
            this.f32662f = list;
        }
        setAuthorIcon(c.q(adTemplate));
        setName(c.v(adTemplate));
        a(c.x(adTemplate), com.kwad.sdk.core.response.b.a.x(c.j(adTemplate)));
        this.f32659c.setVisibility(0);
    }

    public void a(final String str, final String str2) {
        this.f32661e.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.3
            @Override // java.lang.Runnable
            public void run() {
                int length;
                CommentAdItemView.this.f32661e.setText(str);
                String str3 = str;
                CommentAdItemView.this.requestLayout();
                Layout layout = CommentAdItemView.this.f32661e.getLayout();
                if ((layout != null ? layout.getLineCount() : 0) >= 4) {
                    String charSequence = CommentAdItemView.this.f32661e.getText().toString();
                    String str4 = "";
                    for (int i2 = 0; i2 < 4; i2++) {
                        int lineStart = layout.getLineStart(i2);
                        int lineEnd = layout.getLineEnd(i2);
                        str4 = str4 + charSequence.substring(lineStart, lineEnd);
                    }
                    if (((str4.length() - str2.length()) - 3) - 3 > 0) {
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
                com.kwad.sdk.core.view.c a2 = new com.kwad.sdk.core.view.c(drawable, "${ad}").a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                int i3 = length3 + 5;
                spannableStringBuilder.setSpan(a2, length3, i3, 33);
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(new a(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.3.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CommentAdItemView.this.a(8);
                    }
                }, Color.parseColor("#18407D")), i3, str2.length() + i3, 33);
                CommentAdItemView.this.f32661e.setMovementMethod(LinkMovementMethod.getInstance());
                CommentAdItemView.this.f32661e.setText(spannableStringBuilder);
            }
        });
    }

    public void setAuthorIcon(String str) {
        com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f32658b);
    }

    public void setName(String str) {
        this.f32657a.setText(str);
    }
}
