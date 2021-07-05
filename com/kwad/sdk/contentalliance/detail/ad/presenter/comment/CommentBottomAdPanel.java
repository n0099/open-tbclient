package com.kwad.sdk.contentalliance.detail.ad.presenter.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseLinearLayout;
import com.kwad.sdk.core.view.e;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class CommentBottomAdPanel extends AdBaseLinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f34533a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34534b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34535c;

    /* renamed from: d  reason: collision with root package name */
    public View f34536d;

    /* renamed from: e  reason: collision with root package name */
    public View f34537e;

    /* renamed from: f  reason: collision with root package name */
    public View f34538f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f34539g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34540h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f34541i;
    public AdInfo j;
    @Nullable
    public b k;
    public List<a> l;
    public View.OnClickListener m;
    public KsAppDownloadListener n;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentBottomAdPanel(Context context) {
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
        this.l = new ArrayList();
        this.m = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentBottomAdPanel f34542a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34542a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f34542a.c();
                    com.kwad.sdk.core.report.b.l(this.f34542a.f34541i);
                }
            }
        };
        this.n = new c(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentBottomAdPanel f34543a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34543a = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    super.a(i4);
                    this.f34543a.b(true, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.a());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34543a.b(false, false);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.x(this.f34543a.j));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f34543a.b(false, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.a(this.f34543a.f34541i));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f34543a.b(false, false);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.x(this.f34543a.j));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f34543a.b(false, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.b());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    this.f34543a.b(true, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.b(i4));
                }
            }
        };
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentBottomAdPanel(Context context, @Nullable AttributeSet attributeSet) {
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
        this.l = new ArrayList();
        this.m = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentBottomAdPanel f34542a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34542a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f34542a.c();
                    com.kwad.sdk.core.report.b.l(this.f34542a.f34541i);
                }
            }
        };
        this.n = new c(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentBottomAdPanel f34543a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34543a = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    super.a(i4);
                    this.f34543a.b(true, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.a());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34543a.b(false, false);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.x(this.f34543a.j));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f34543a.b(false, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.a(this.f34543a.f34541i));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f34543a.b(false, false);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.x(this.f34543a.j));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f34543a.b(false, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.b());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    this.f34543a.b(true, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.b(i4));
                }
            }
        };
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentBottomAdPanel(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.l = new ArrayList();
        this.m = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentBottomAdPanel f34542a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34542a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f34542a.c();
                    com.kwad.sdk.core.report.b.l(this.f34542a.f34541i);
                }
            }
        };
        this.n = new c(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentBottomAdPanel f34543a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34543a = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i42) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i42) == null) {
                    super.a(i42);
                    this.f34543a.b(true, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.a());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34543a.b(false, false);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.x(this.f34543a.j));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f34543a.b(false, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.a(this.f34543a.f34541i));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f34543a.b(false, false);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.x(this.f34543a.j));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f34543a.b(false, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.b());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i42) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i42) == null) {
                    this.f34543a.b(true, true);
                    this.f34543a.f34535c.setText(com.kwad.sdk.core.response.b.a.b(i42));
                }
            }
        };
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            b.a(this.k, true);
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f34541i, new a.InterfaceC0426a(this, i2) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f34549a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CommentBottomAdPanel f34550b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34550b = this;
                    this.f34549a = i2;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("commentBottomAdPanel", "notifyAdContentClick onAdContentClick itemClickType:" + this.f34549a);
                        com.kwad.sdk.core.report.b.a(this.f34550b.f34541i, this.f34549a, this.f34550b.getTouchCoords());
                    }
                }
            }, this.k);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.d.a.a("commentBottomAdPanel", "initView");
            this.f34540h = com.kwad.sdk.core.config.c.D() == 1;
            LayoutInflater.from(getContext()).inflate(this.f34540h ? R.layout.ksad_comment_bottom_ad_panel_layout : R.layout.ksad_comment_bottom_ad_panel_layout_2, (ViewGroup) this, true);
            this.f34533a = (TextView) findViewById(R.id.kasd_comment_bottom_ad_author_name);
            this.f34534b = (TextView) findViewById(R.id.kasd_comment_bottom_ad_content);
            this.f34535c = (TextView) findViewById(R.id.kasd_comment_bottom_ad_link_btn);
            this.f34538f = findViewById(R.id.kasd_comment_bottom_ad_link_btn_layout);
            this.f34536d = findViewById(R.id.kasd_comment_bottom_ad_close_btn);
            View findViewById = findViewById(R.id.kasd_comment_bottom_ad_layout);
            this.f34537e = findViewById;
            findViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CommentBottomAdPanel f34544a;

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
                    this.f34544a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34544a.a(35);
                    }
                }
            });
            this.f34538f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CommentBottomAdPanel f34545a;

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
                    this.f34545a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34545a.a(34);
                    }
                }
            });
            this.f34533a.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CommentBottomAdPanel f34546a;

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
                    this.f34546a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34546a.a(90);
                    }
                }
            });
            this.f34534b.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CommentBottomAdPanel f34547a;

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
                    this.f34547a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f34547a.a(91);
                    }
                }
            });
            this.f34536d.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CommentBottomAdPanel f34548a;

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
                    this.f34548a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f34548a.m == null) {
                        return;
                    }
                    this.f34548a.m.onClick(view);
                }
            });
            if (this.f34540h) {
                e.a(this, -1, ao.a(getContext(), 6.0f), Color.parseColor("#14000000"), ao.a(getContext(), 4.0f), 0, 1);
            } else {
                e.a(this, getContext().getResources().getDrawable(R.drawable.ksad_comment_bottom_ad_bg));
            }
            setTranslationY(ao.a(getContext(), 80.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2) {
        TextView textView;
        ViewGroup.LayoutParams layoutParams;
        TextView textView2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (textView = this.f34535c) == null || (layoutParams = textView.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.width = this.f34540h ? ao.a(getContext(), 104.0f) : -2;
            layoutParams.height = -2;
            textView2 = this.f34535c;
            i2 = 10;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -2;
            textView2 = this.f34535c;
            i2 = 6;
        }
        textView2.setMaxEms(i2);
        this.f34535c.setSelected(z2);
        this.f34535c.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            for (a aVar : this.l) {
                aVar.a();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = this.k;
            if (bVar != null) {
                bVar.b(this.n);
            }
            this.l.clear();
        }
    }

    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.l.add(aVar);
        }
    }

    public void a(AdTemplate adTemplate, @Nullable b bVar) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Context context;
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adTemplate, bVar) == null) || adTemplate == null) {
            return;
        }
        this.f34541i = adTemplate;
        this.j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.k = bVar;
        this.f34534b.setText(com.kwad.sdk.core.response.b.c.x(adTemplate));
        this.f34533a.setText(com.kwad.sdk.core.response.b.c.v(adTemplate));
        b(false, false);
        this.f34535c.setText(com.kwad.sdk.core.response.b.a.x(com.kwad.sdk.core.response.b.c.j(adTemplate)));
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(this.n);
        }
        if (this.f34540h) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            context = getContext();
            f2 = 8.0f;
        } else {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            context = getContext();
            f2 = 0.0f;
        }
        int a2 = ao.a(context, f2);
        marginLayoutParams.setMargins(a2, a2, a2, a2);
        setLayoutParams(marginLayoutParams);
        invalidate();
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                setVisibility(8);
            }
            AnimatorSet animatorSet = this.f34539g;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.f34539g.removeAllListeners();
                this.f34539g.cancel();
            }
            this.f34539g = new AnimatorSet();
            int a2 = ao.a(getContext(), 80.0f);
            com.kwad.sdk.core.d.a.a("commentBottomAdPanel", "bottomViewAnimate + isShow : " + z);
            String name = View.TRANSLATION_Y.getName();
            float[] fArr = new float[1];
            fArr[0] = z ? 0.0f : a2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, name, fArr);
            ofFloat.setDuration(z ? 350L : 300L);
            this.f34539g.playTogether(ofFloat);
            this.f34539g.removeAllListeners();
            this.f34539g.addListener(new AnimatorListenerAdapter(this, z) { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f34551a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CommentBottomAdPanel f34552b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34552b = this;
                    this.f34551a = z;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationCancel(animator);
                        this.f34552b.setVisibility(this.f34551a ? 4 : 0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f34551a) {
                            return;
                        }
                        this.f34552b.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
                public void onAnimationPause(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        super.onAnimationPause(animator);
                        this.f34552b.setVisibility(this.f34551a ? 4 : 0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f34551a) {
                            this.f34552b.setVisibility(0);
                        }
                    }
                }
            });
            this.f34539g.start();
        }
    }

    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.l.remove(aVar);
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f34533a.setText(str);
        }
    }
}
