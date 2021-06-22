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
    public boolean f33076a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33077b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33078c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33079d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f33080e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33081f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33082g;

    /* renamed from: h  reason: collision with root package name */
    public CommentLikeButton f33083h;

    /* renamed from: i  reason: collision with root package name */
    public b f33084i;
    public CharSequence j;

    public a(Context context) {
        super(context);
        this.f33076a = false;
        a();
    }

    private void a() {
        com.kwad.sdk.core.d.a.a("CommentItemView2", "initView");
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_item_2, (ViewGroup) this, true);
        this.f33078c = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
        this.f33079d = (ImageView) findViewById(R.id.ksad_photo_comment_item_self_img);
        this.f33077b = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
        this.f33080e = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.ksad_photo_comment_item_comment);
        this.f33082g = textView;
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.b();
                a.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.f33081f = (TextView) this.f33080e.findViewById(R.id.ksad_photo_comment_item_created_time);
        this.f33083h = (CommentLikeButton) findViewById(R.id.ksad_photo_comment_item_like_frame);
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
        int i2 = c2 ? 2 : 1;
        long j = photoComment.likedCount;
        if (c2) {
            j++;
        }
        a(i2, j);
    }

    private void a(PhotoComment photoComment, long j) {
        ImageView imageView;
        int i2;
        if (photoComment != null) {
            if (j == photoComment.author_id) {
                imageView = this.f33079d;
                i2 = 0;
            } else {
                imageView = this.f33079d;
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    private SpannableStringBuilder b(String str, long j) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f33082g.measure(makeMeasureSpec, makeMeasureSpec);
        int width = this.f33082g.getWidth() - ao.a(getContext(), 4.0f);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(ao.a(getContext(), 13.0f));
        float measureText = textPaint.measureText(GlideException.IndentedAppendable.INDENT + ag.a(getContext(), j)) + ao.a(getContext(), 6.0f);
        float measureText2 = this.f33082g.getPaint().measureText(str);
        float a2 = measureText + measureText2 + ((float) ao.a(getContext(), 4.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int i2 = (int) a2;
        int i3 = (i2 / width) + 1;
        int i4 = i2 % width;
        int i5 = ((int) measureText2) % width;
        if (!(((float) (width * 4)) - a2 > 0.0f) || i3 > 4 || i5 + measureText >= width || i4 >= width) {
            this.f33081f.setVisibility(0);
        } else {
            spannableStringBuilder.append((CharSequence) GlideException.IndentedAppendable.INDENT);
            spannableStringBuilder.append((CharSequence) ag.a(getContext(), j));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#888B90")), str.length(), spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), str.length(), spannableStringBuilder.length(), 17);
            this.f33081f.setVisibility(8);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f33084i == null) {
            com.kwad.sdk.core.d.a.a("CommentItemView2", "layoutCommentSpan mCommentItemData == null");
        } else {
            c();
        }
    }

    private void c() {
        b bVar;
        if (this.f33076a) {
            setCommentText(this.j);
            return;
        }
        Layout layout = this.f33082g.getLayout();
        if (layout == null || (bVar = this.f33084i) == null || bVar.f32906a == null) {
            return;
        }
        int lineCount = layout.getLineCount();
        if (lineCount > 4 || layout.getEllipsisCount(lineCount - 1) != 0) {
            this.f33084i.f32911f = true;
            this.f33081f.setVisibility(0);
            return;
        }
        b bVar2 = this.f33084i;
        if (bVar2.f32911f) {
            return;
        }
        PhotoComment photoComment = bVar2.f32906a;
        setCommentText(b(photoComment.content, photoComment.timestamp));
        this.f33082g.setOnClickListener(null);
        this.f33076a = true;
    }

    public void a(int i2, long j) {
        this.f33083h.a(i2, j);
        this.f33083h.setLikeStateListener(new CommentLikeButton.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.3
            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.a
            public void a(int i3) {
                if (a.this.f33084i == null || a.this.f33084i.f32906a == null) {
                    return;
                }
                if (i3 == 2) {
                    c.a(a.this.f33084i.f32906a.photo_id, a.this.f33084i.f32906a.comment_id);
                    e.b(a.this.f33084i.f32907b, a.this.f33084i.f32906a.comment_id);
                    return;
                }
                c.b(a.this.f33084i.f32906a.photo_id, a.this.f33084i.f32906a.comment_id);
                e.c(a.this.f33084i.f32907b, a.this.f33084i.f32906a.comment_id);
            }
        });
    }

    public void a(String str, long j) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.f33081f.setVisibility(8);
        setCommentText(spannableStringBuilder);
        this.f33082g.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b();
            }
        });
    }

    public void setAuthorIcon(String str) {
        KSImageLoader.loadAuthorCircleIcon(this.f33078c, str);
    }

    public void setCommentText(CharSequence charSequence) {
        this.j = charSequence;
        this.f33082g.setText(charSequence);
    }

    public void setCommentTime(long j) {
        TextView textView = this.f33081f;
        textView.setText(ag.a(textView.getContext(), j));
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.comment.a
    public void setData(@NonNull b bVar) {
        TextView textView;
        int i2;
        if (bVar == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("CommentItemView2", "bindCommentItemViewData commentHolderData=" + bVar + " commentPosition=" + bVar.f32910e + " isCommentOpen=" + bVar.f32909d);
        this.f33076a = false;
        this.f33084i = bVar;
        if (bVar.f32909d) {
            textView = this.f33082g;
            i2 = Integer.MAX_VALUE;
        } else {
            textView = this.f33082g;
            i2 = 4;
        }
        textView.setMaxLines(i2);
        a(this.f33084i.f32906a);
        a(this.f33084i.f32906a, d.o(com.kwad.sdk.core.response.b.c.k(bVar.f32907b)));
    }

    public void setName(String str) {
        this.f33077b.setText(str);
    }
}
