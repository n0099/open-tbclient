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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.comment.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f34839a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34840b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34841c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f34842d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f34843e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34844f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34845g;

    /* renamed from: h  reason: collision with root package name */
    public CommentLikeButton f34846h;

    /* renamed from: i  reason: collision with root package name */
    public b f34847i;
    public CharSequence j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34839a = false;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            com.kwad.sdk.core.d.a.a("CommentItemView2", "initView");
            LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_item_2, (ViewGroup) this, true);
            this.f34841c = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
            this.f34842d = (ImageView) findViewById(R.id.ksad_photo_comment_item_self_img);
            this.f34840b = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
            this.f34843e = relativeLayout;
            TextView textView = (TextView) relativeLayout.findViewById(R.id.ksad_photo_comment_item_comment);
            this.f34845g = textView;
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34848a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34848a = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f34848a.b();
                        this.f34848a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
            this.f34844f = (TextView) this.f34843e.findViewById(R.id.ksad_photo_comment_item_created_time);
            this.f34846h = (CommentLikeButton) findViewById(R.id.ksad_photo_comment_item_like_frame);
        }
    }

    private void a(PhotoComment photoComment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, photoComment) == null) || photoComment == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65540, this, photoComment, j) == null) || photoComment == null) {
            return;
        }
        if (j == photoComment.author_id) {
            imageView = this.f34842d;
            i2 = 0;
        } else {
            imageView = this.f34842d;
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    private SpannableStringBuilder b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, this, str, j)) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.f34845g.measure(makeMeasureSpec, makeMeasureSpec);
            int width = this.f34845g.getWidth() - ao.a(getContext(), 4.0f);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(ao.a(getContext(), 13.0f));
            float measureText = textPaint.measureText(GlideException.IndentedAppendable.INDENT + ag.a(getContext(), j)) + ao.a(getContext(), 6.0f);
            float measureText2 = this.f34845g.getPaint().measureText(str);
            float a2 = measureText + measureText2 + ((float) ao.a(getContext(), 4.0f));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            int i2 = (int) a2;
            int i3 = (i2 / width) + 1;
            int i4 = i2 % width;
            int i5 = ((int) measureText2) % width;
            if (!(((float) (width * 4)) - a2 > 0.0f) || i3 > 4 || i5 + measureText >= width || i4 >= width) {
                this.f34844f.setVisibility(0);
            } else {
                spannableStringBuilder.append((CharSequence) GlideException.IndentedAppendable.INDENT);
                spannableStringBuilder.append((CharSequence) ag.a(getContext(), j));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#888B90")), str.length(), spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), str.length(), spannableStringBuilder.length(), 17);
                this.f34844f.setVisibility(8);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.f34847i == null) {
                com.kwad.sdk.core.d.a.a("CommentItemView2", "layoutCommentSpan mCommentItemData == null");
            } else {
                c();
            }
        }
    }

    private void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.f34839a) {
                setCommentText(this.j);
                return;
            }
            Layout layout = this.f34845g.getLayout();
            if (layout == null || (bVar = this.f34847i) == null || bVar.f34669a == null) {
                return;
            }
            int lineCount = layout.getLineCount();
            if (lineCount > 4 || layout.getEllipsisCount(lineCount - 1) != 0) {
                this.f34847i.f34674f = true;
                this.f34844f.setVisibility(0);
                return;
            }
            b bVar2 = this.f34847i;
            if (bVar2.f34674f) {
                return;
            }
            PhotoComment photoComment = bVar2.f34669a;
            setCommentText(b(photoComment.content, photoComment.timestamp));
            this.f34845g.setOnClickListener(null);
            this.f34839a = true;
        }
    }

    public void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f34846h.a(i2, j);
            this.f34846h.setLikeStateListener(new CommentLikeButton.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34850a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34850a = this;
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.a
                public void a(int i3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) || this.f34850a.f34847i == null || this.f34850a.f34847i.f34669a == null) {
                        return;
                    }
                    if (i3 == 2) {
                        c.a(this.f34850a.f34847i.f34669a.photo_id, this.f34850a.f34847i.f34669a.comment_id);
                        e.b(this.f34850a.f34847i.f34670b, this.f34850a.f34847i.f34669a.comment_id);
                        return;
                    }
                    c.b(this.f34850a.f34847i.f34669a.photo_id, this.f34850a.f34847i.f34669a.comment_id);
                    e.c(this.f34850a.f34847i.f34670b, this.f34850a.f34847i.f34669a.comment_id);
                }
            });
        }
    }

    public void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            this.f34844f.setVisibility(8);
            setCommentText(spannableStringBuilder);
            this.f34845g.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34849a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34849a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f34849a.b();
                    }
                }
            });
        }
    }

    public void setAuthorIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            KSImageLoader.loadAuthorCircleIcon(this.f34841c, str);
        }
    }

    public void setCommentText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            this.j = charSequence;
            this.f34845g.setText(charSequence);
        }
    }

    public void setCommentTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            TextView textView = this.f34844f;
            textView.setText(ag.a(textView.getContext(), j));
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.comment.a
    public void setData(@NonNull b bVar) {
        TextView textView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || bVar == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("CommentItemView2", "bindCommentItemViewData commentHolderData=" + bVar + " commentPosition=" + bVar.f34673e + " isCommentOpen=" + bVar.f34672d);
        this.f34839a = false;
        this.f34847i = bVar;
        if (bVar.f34672d) {
            textView = this.f34845g;
            i2 = Integer.MAX_VALUE;
        } else {
            textView = this.f34845g;
            i2 = 4;
        }
        textView.setMaxLines(i2);
        a(this.f34847i.f34669a);
        a(this.f34847i.f34669a, d.o(com.kwad.sdk.core.response.b.c.k(bVar.f34670b)));
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f34840b.setText(str);
        }
    }
}
