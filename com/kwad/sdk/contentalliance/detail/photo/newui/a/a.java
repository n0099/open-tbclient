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
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.comment.a {

    /* renamed from: a  reason: collision with root package name */
    boolean f8536a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f8537b;
    private ImageView c;
    private ImageView d;
    private RelativeLayout e;
    private TextView f;
    private TextView g;
    private CommentLikeButton h;
    private b i;
    private CharSequence j;

    public a(Context context) {
        super(context);
        this.f8536a = false;
        a();
    }

    private void a() {
        com.kwad.sdk.core.d.a.a("CommentItemView2", "initView");
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_item_2, (ViewGroup) this, true);
        this.c = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
        this.d = (ImageView) findViewById(R.id.ksad_photo_comment_item_self_img);
        this.f8537b = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
        this.e = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
        this.g = (TextView) this.e.findViewById(R.id.ksad_photo_comment_item_comment);
        this.g.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.b();
                a.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.f = (TextView) this.e.findViewById(R.id.ksad_photo_comment_item_created_time);
        this.h = (CommentLikeButton) findViewById(R.id.ksad_photo_comment_item_like_frame);
    }

    private void a(PhotoComment photoComment) {
        if (photoComment == null) {
            return;
        }
        setName(photoComment.author_name);
        setAuthorIcon(photoComment.headurl);
        setCommentTime(photoComment.timestamp);
        a(ag.c(photoComment.content), photoComment.timestamp);
        boolean c = c.c(photoComment.photo_id, photoComment.comment_id);
        a(c ? 2 : 1, c ? photoComment.likedCount + 1 : photoComment.likedCount);
    }

    private void a(PhotoComment photoComment, long j) {
        if (photoComment != null) {
            if (j == photoComment.author_id) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    private SpannableStringBuilder b(String str, long j) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.g.measure(makeMeasureSpec, makeMeasureSpec);
        int width = this.g.getWidth() - ao.a(getContext(), 4.0f);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(ao.a(getContext(), 13.0f));
        float a2 = ao.a(getContext(), 6.0f) + textPaint.measureText("  " + ag.a(getContext(), j));
        float measureText = this.g.getPaint().measureText(str);
        float a3 = a2 + measureText + ao.a(getContext(), 4.0f);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int i = (((int) a3) / width) + 1;
        int i2 = ((int) a3) % width;
        int i3 = ((int) measureText) % width;
        if (!(((float) (width * 4)) - a3 > 0.0f) || i > 4 || i3 + a2 >= width || i2 >= width) {
            this.f.setVisibility(0);
        } else {
            spannableStringBuilder.append((CharSequence) "  ");
            spannableStringBuilder.append((CharSequence) ag.a(getContext(), j));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#888B90")), str.length(), spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), str.length(), spannableStringBuilder.length(), 17);
            this.f.setVisibility(8);
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
        if (this.f8536a) {
            setCommentText(this.j);
            return;
        }
        Layout layout = this.g.getLayout();
        if (layout == null || this.i == null || this.i.f8449a == null) {
            return;
        }
        int lineCount = layout.getLineCount();
        if (lineCount > 4 || layout.getEllipsisCount(lineCount - 1) != 0) {
            this.i.f = true;
            this.f.setVisibility(0);
        } else if (this.i.f) {
        } else {
            setCommentText(b(this.i.f8449a.content, this.i.f8449a.timestamp));
            this.g.setOnClickListener(null);
            this.f8536a = true;
        }
    }

    public void a(int i, long j) {
        this.h.a(i, j);
        this.h.setLikeStateListener(new CommentLikeButton.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.3
            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.a
            public void a(int i2) {
                if (a.this.i == null || a.this.i.f8449a == null) {
                    return;
                }
                if (i2 == 2) {
                    c.a(a.this.i.f8449a.photo_id, a.this.i.f8449a.comment_id);
                    e.b(a.this.i.f8450b, a.this.i.f8449a.comment_id);
                    return;
                }
                c.b(a.this.i.f8449a.photo_id, a.this.i.f8449a.comment_id);
                e.c(a.this.i.f8450b, a.this.i.f8449a.comment_id);
            }
        });
    }

    public void a(String str, long j) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.f.setVisibility(8);
        setCommentText(spannableStringBuilder);
        this.g.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b();
            }
        });
    }

    public void setAuthorIcon(String str) {
        KSImageLoader.loadAuthorCircleIcon(this.c, str);
    }

    void setCommentText(CharSequence charSequence) {
        this.j = charSequence;
        this.g.setText(charSequence);
    }

    public void setCommentTime(long j) {
        this.f.setText(ag.a(this.f.getContext(), j));
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.comment.a
    public void setData(@NonNull b bVar) {
        if (bVar == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("CommentItemView2", "bindCommentItemViewData commentHolderData=" + bVar + " commentPosition=" + bVar.e + " isCommentOpen=" + bVar.d);
        this.f8536a = false;
        this.i = bVar;
        if (this.i.d) {
            this.g.setMaxLines(Integer.MAX_VALUE);
        } else {
            this.g.setMaxLines(4);
        }
        a(this.i.f8449a);
        a(this.i.f8449a, d.o(com.kwad.sdk.core.response.b.c.k(bVar.f8450b)));
    }

    public void setName(String str) {
        this.f8537b.setText(str);
    }
}
