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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.comment.f;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class CommentAdItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f34518a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34519b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34520c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f34521d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34522e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f34523f;

    /* loaded from: classes7.dex */
    public static class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f34531a;

        /* renamed from: b  reason: collision with root package name */
        public int f34532b;

        public a(View.OnClickListener onClickListener, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onClickListener, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34531a = onClickListener;
            this.f34532b = i2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f34531a) == null) {
                return;
            }
            onClickListener.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                int i2 = this.f34532b;
                textPaint.linkColor = i2;
                textPaint.setColor(i2);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentAdItemView(Context context) {
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
        this.f34523f = new ArrayList();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentAdItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34523f = new ArrayList();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentAdItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f34523f = new ArrayList();
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            com.kwad.sdk.core.d.a.a("CommentAdItemView", "initView");
            LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_ad_item, (ViewGroup) this, true);
            this.f34519b = (ImageView) findViewById(R.id.ksad_photo_comment_item_avatar);
            this.f34520c = (ImageView) findViewById(R.id.ksad_photo_comment_item_flag_img);
            this.f34518a = (TextView) findViewById(R.id.ksad_photo_comment_item_name);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ksad_photo_comment_item_content_frame);
            this.f34521d = relativeLayout;
            this.f34522e = (TextView) relativeLayout.findViewById(R.id.ksad_photo_comment_item_comment);
            this.f34519b.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CommentAdItemView f34524a;

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
                    this.f34524a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34524a.a(49);
                    }
                }
            });
            this.f34518a.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CommentAdItemView f34525a;

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
                    this.f34525a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34525a.a(47);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            for (f fVar : this.f34523f) {
                fVar.a(i2);
            }
        }
    }

    public void a(AdTemplate adTemplate, @Nullable List<f> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, adTemplate, list) == null) || adTemplate == null) {
            return;
        }
        if (list != null) {
            this.f34523f = list;
        }
        setAuthorIcon(c.q(adTemplate));
        setName(c.v(adTemplate));
        a(c.x(adTemplate), com.kwad.sdk.core.response.b.a.x(c.j(adTemplate)));
        this.f34520c.setVisibility(0);
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.f34522e.post(new Runnable(this, str, str2) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f34526a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f34527b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ CommentAdItemView f34528c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34528c = this;
                    this.f34526a = str;
                    this.f34527b = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int length;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f34528c.f34522e.setText(this.f34526a);
                        String str3 = this.f34526a;
                        this.f34528c.requestLayout();
                        Layout layout = this.f34528c.f34522e.getLayout();
                        if ((layout != null ? layout.getLineCount() : 0) >= 4) {
                            String charSequence = this.f34528c.f34522e.getText().toString();
                            String str4 = "";
                            for (int i2 = 0; i2 < 4; i2++) {
                                int lineStart = layout.getLineStart(i2);
                                int lineEnd = layout.getLineEnd(i2);
                                str4 = str4 + charSequence.substring(lineStart, lineEnd);
                            }
                            if (((str4.length() - this.f34527b.length()) - 3) - 3 > 0) {
                                str3 = str4.substring(0, length) + StringHelper.STRING_MORE;
                            }
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        int length2 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) str3);
                        spannableStringBuilder.setSpan(new a(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f34529a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f34529a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                    this.f34529a.f34528c.a(48);
                                }
                            }
                        }, Color.parseColor("#131924")), length2, str3.length() + length2, 33);
                        spannableStringBuilder.append((CharSequence) " ");
                        int length3 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) "${ad}");
                        Drawable drawable = this.f34528c.getContext().getResources().getDrawable(R.drawable.ksad_photo_comment_ad_item_link_img);
                        com.kwad.sdk.core.view.c a2 = new com.kwad.sdk.core.view.c(drawable, "${ad}").a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        int i3 = length3 + 5;
                        spannableStringBuilder.setSpan(a2, length3, i3, 33);
                        spannableStringBuilder.append((CharSequence) this.f34527b);
                        spannableStringBuilder.setSpan(new a(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f34530a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f34530a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                    this.f34530a.f34528c.a(8);
                                }
                            }
                        }, Color.parseColor("#18407D")), i3, this.f34527b.length() + i3, 33);
                        this.f34528c.f34522e.setMovementMethod(LinkMovementMethod.getInstance());
                        this.f34528c.f34522e.setText(spannableStringBuilder);
                    }
                }
            });
        }
    }

    public void setAuthorIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f34519b);
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f34518a.setText(str);
        }
    }
}
