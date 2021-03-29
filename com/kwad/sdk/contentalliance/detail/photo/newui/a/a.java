package com.kwad.sdk.contentalliance.detail.photo.newui.a;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.GlideException;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton;
import com.kwad.sdk.contentalliance.detail.photo.comment.b;
import com.kwad.sdk.contentalliance.detail.photo.comment.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.comment.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f32405a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32406b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32407c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f32408d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f32409e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32410f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32411g;

    /* renamed from: h  reason: collision with root package name */
    public CommentLikeButton f32412h;
    public b i;
    public CharSequence j;

    public a(Context context) {
        super(context);
        this.f32405a = false;
        a();
    }

    private void a() {
        com.kwad.sdk.core.d.a.a("CommentItemView2", "initView");
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_item_2, (ViewGroup) this, true);
        this.f32407c = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
        this.f32408d = (ImageView) findViewById(R.id.ksad_photo_comment_item_self_img);
        this.f32406b = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
        this.f32409e = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.ksad_photo_comment_item_comment);
        this.f32411g = textView;
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.b();
                a.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.f32410f = (TextView) this.f32409e.findViewById(R.id.ksad_photo_comment_item_created_time);
        this.f32412h = (CommentLikeButton) findViewById(R.id.ksad_photo_comment_item_like_frame);
    }

    private void a(PhotoComment photoComment) {
        if (photoComment == null) {
            return;
        }
        setName(photoComment.author_name);
        setAuthorIcon(photoComment.headurl);
        setCommentTime(photoComment.timestamp);
        a(ag.c(photoComment.content), photoComment.timestamp);
        boolean c2 = c.c(photoComment.photo_id, photoComment.comment_id);
        int i = c2 ? 2 : 1;
        long j = photoComment.likedCount;
        if (c2) {
            j++;
        }
        a(i, j);
    }

    private void a(PhotoComment photoComment, long j) {
        ImageView imageView;
        int i;
        if (photoComment != null) {
            if (j == photoComment.author_id) {
                imageView = this.f32408d;
                i = 0;
            } else {
                imageView = this.f32408d;
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    private SpannableStringBuilder b(String str, long j) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f32411g.measure(makeMeasureSpec, makeMeasureSpec);
        int width = this.f32411g.getWidth() - ao.a(getContext(), 4.0f);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(ao.a(getContext(), 13.0f));
        float measureText = textPaint.measureText(GlideException.IndentedAppendable.INDENT + ag.a(getContext(), j)) + ao.a(getContext(), 6.0f);
        float measureText2 = this.f32411g.getPaint().measureText(str);
        float a2 = measureText + measureText2 + ((float) ao.a(getContext(), 4.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int i = (int) a2;
        int i2 = (i / width) + 1;
        int i3 = i % width;
        int i4 = ((int) measureText2) % width;
        if (!(((float) (width * 4)) - a2 > 0.0f) || i2 > 4 || i4 + measureText >= width || i3 >= width) {
            this.f32410f.setVisibility(0);
        } else {
            spannableStringBuilder.append((CharSequence) GlideException.IndentedAppendable.INDENT);
            spannableStringBuilder.append((CharSequence) ag.a(getContext(), j));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#888B90")), str.length(), spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), str.length(), spannableStringBuilder.length(), 17);
            this.f32410f.setVisibility(8);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.i == null) {
            com.kwad.sdk.core.d.a.a("CommentItemView2", "layoutCommentSpan mCommentItemData == null");
        } else {
            c();
        }
    }

    private void c() {
        b bVar;
        if (this.f32405a) {
            setCommentText(this.j);
            return;
        }
        Layout layout = this.f32411g.getLayout();
        if (layout == null || (bVar = this.i) == null || bVar.f32240a == null) {
            return;
        }
        int lineCount = layout.getLineCount();
        if (lineCount > 4 || layout.getEllipsisCount(lineCount - 1) != 0) {
            this.i.f32245f = true;
            this.f32410f.setVisibility(0);
            return;
        }
        b bVar2 = this.i;
        if (bVar2.f32245f) {
            return;
        }
        PhotoComment photoComment = bVar2.f32240a;
        setCommentText(b(photoComment.content, photoComment.timestamp));
        this.f32411g.setOnClickListener(null);
        this.f32405a = true;
    }

    public void a(int i, long j) {
        this.f32412h.a(i, j);
        this.f32412h.setLikeStateListener(new CommentLikeButton.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.3
            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.a
            public void a(int i2) {
                if (a.this.i == null || a.this.i.f32240a == null) {
                    return;
                }
                if (i2 == 2) {
                    c.a(a.this.i.f32240a.photo_id, a.this.i.f32240a.comment_id);
                    e.b(a.this.i.f32241b, a.this.i.f32240a.comment_id);
                    return;
                }
                c.b(a.this.i.f32240a.photo_id, a.this.i.f32240a.comment_id);
                e.c(a.this.i.f32241b, a.this.i.f32240a.comment_id);
            }
        });
    }

    public void a(String str, long j) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.f32410f.setVisibility(8);
        setCommentText(spannableStringBuilder);
        this.f32411g.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b();
            }
        });
    }

    public void setAuthorIcon(String str) {
        KSImageLoader.loadAuthorCircleIcon(this.f32407c, str);
    }

    public void setCommentText(CharSequence charSequence) {
        this.j = charSequence;
        this.f32411g.setText(charSequence);
    }

    public void setCommentTime(long j) {
        TextView textView = this.f32410f;
        textView.setText(ag.a(textView.getContext(), j));
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.comment.a
    public void setData(@NonNull b bVar) {
        TextView textView;
        int i;
        if (bVar == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("CommentItemView2", "bindCommentItemViewData commentHolderData=" + bVar + " commentPosition=" + bVar.f32244e + " isCommentOpen=" + bVar.f32243d);
        this.f32405a = false;
        this.i = bVar;
        if (bVar.f32243d) {
            textView = this.f32411g;
            i = Integer.MAX_VALUE;
        } else {
            textView = this.f32411g;
            i = 4;
        }
        textView.setMaxLines(i);
        a(this.i.f32240a);
        a(this.i.f32240a, d.o(com.kwad.sdk.core.response.b.c.k(bVar.f32241b)));
    }

    public void setName(String str) {
        this.f32406b.setText(str);
    }
}
