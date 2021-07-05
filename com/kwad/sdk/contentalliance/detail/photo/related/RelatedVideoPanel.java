package com.kwad.sdk.contentalliance.detail.photo.related;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.widget.KSHalfPageLoadingView;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class RelatedVideoPanel extends LinearLayout implements View.OnClickListener, com.kwad.sdk.contentalliance.a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f34901a;

    /* renamed from: b  reason: collision with root package name */
    public View f34902b;

    /* renamed from: c  reason: collision with root package name */
    public View f34903c;

    /* renamed from: d  reason: collision with root package name */
    public KSHalfPageLoadingView f34904d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f34905e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f34906f;

    /* renamed from: g  reason: collision with root package name */
    public b f34907g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f34908h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> f34909i;
    public a j;
    public AdTemplate k;
    public SceneImpl l;
    public boolean m;
    public KSPageLoadingView.a n;
    public f o;
    public RecyclerView.OnScrollListener p;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelatedVideoPanel(Context context) {
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
        this.f34901a = new Handler();
        this.n = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34911a;

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
                this.f34911a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34911a.f34909i == null) {
                    return;
                }
                this.f34911a.f34909i.k();
            }
        };
        this.o = new g(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34912a;

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
                this.f34912a = this;
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                    this.f34912a.f34904d.a();
                    if (z) {
                        if (this.f34912a.f34907g.i()) {
                            if (com.kwad.sdk.core.network.f.f36364g.k == i4) {
                                this.f34912a.f34904d.e();
                            } else if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                                this.f34912a.f34904d.c();
                            } else {
                                this.f34912a.f34904d.d();
                            }
                        }
                    } else if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                        p.a(this.f34912a.getContext());
                    } else if (com.kwad.sdk.core.network.f.f36364g.k != i4) {
                        p.b(this.f34912a.getContext());
                    }
                    this.f34912a.f34905e.a(this.f34912a.f34909i.j());
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    if (!z) {
                        this.f34912a.f34905e.a();
                    } else if (this.f34912a.f34907g.i()) {
                        this.f34912a.f34904d.b();
                    }
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    this.f34912a.i();
                    this.f34912a.f34904d.a();
                    if (z) {
                        if (this.f34912a.f34907g.i()) {
                            this.f34912a.f34904d.d();
                        } else if (!this.f34912a.f34908h.d(this.f34912a.f34905e)) {
                            this.f34912a.f34908h.c(this.f34912a.f34905e);
                        }
                    }
                    this.f34912a.f34905e.a(this.f34912a.f34909i.j());
                }
            }
        };
        this.p = new RecyclerView.OnScrollListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34913a;

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
                this.f34913a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i4) == null) {
                    super.onScrollStateChanged(recyclerView, i4);
                    if (i4 == 1) {
                        this.f34913a.j();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    if (i4 > 0 || i5 > 0) {
                        this.f34913a.j();
                    }
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelatedVideoPanel(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f34901a = new Handler();
        this.n = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34911a;

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
                this.f34911a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34911a.f34909i == null) {
                    return;
                }
                this.f34911a.f34909i.k();
            }
        };
        this.o = new g(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34912a;

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
                this.f34912a = this;
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                    this.f34912a.f34904d.a();
                    if (z) {
                        if (this.f34912a.f34907g.i()) {
                            if (com.kwad.sdk.core.network.f.f36364g.k == i4) {
                                this.f34912a.f34904d.e();
                            } else if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                                this.f34912a.f34904d.c();
                            } else {
                                this.f34912a.f34904d.d();
                            }
                        }
                    } else if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                        p.a(this.f34912a.getContext());
                    } else if (com.kwad.sdk.core.network.f.f36364g.k != i4) {
                        p.b(this.f34912a.getContext());
                    }
                    this.f34912a.f34905e.a(this.f34912a.f34909i.j());
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    if (!z) {
                        this.f34912a.f34905e.a();
                    } else if (this.f34912a.f34907g.i()) {
                        this.f34912a.f34904d.b();
                    }
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    this.f34912a.i();
                    this.f34912a.f34904d.a();
                    if (z) {
                        if (this.f34912a.f34907g.i()) {
                            this.f34912a.f34904d.d();
                        } else if (!this.f34912a.f34908h.d(this.f34912a.f34905e)) {
                            this.f34912a.f34908h.c(this.f34912a.f34905e);
                        }
                    }
                    this.f34912a.f34905e.a(this.f34912a.f34909i.j());
                }
            }
        };
        this.p = new RecyclerView.OnScrollListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34913a;

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
                this.f34913a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i4) == null) {
                    super.onScrollStateChanged(recyclerView, i4);
                    if (i4 == 1) {
                        this.f34913a.j();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    if (i4 > 0 || i5 > 0) {
                        this.f34913a.j();
                    }
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelatedVideoPanel(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f34901a = new Handler();
        this.n = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34911a;

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
                this.f34911a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34911a.f34909i == null) {
                    return;
                }
                this.f34911a.f34909i.k();
            }
        };
        this.o = new g(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34912a;

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
                this.f34912a = this;
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i42, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i42), str}) == null) {
                    this.f34912a.f34904d.a();
                    if (z) {
                        if (this.f34912a.f34907g.i()) {
                            if (com.kwad.sdk.core.network.f.f36364g.k == i42) {
                                this.f34912a.f34904d.e();
                            } else if (com.kwad.sdk.core.network.f.f36358a.k == i42) {
                                this.f34912a.f34904d.c();
                            } else {
                                this.f34912a.f34904d.d();
                            }
                        }
                    } else if (com.kwad.sdk.core.network.f.f36358a.k == i42) {
                        p.a(this.f34912a.getContext());
                    } else if (com.kwad.sdk.core.network.f.f36364g.k != i42) {
                        p.b(this.f34912a.getContext());
                    }
                    this.f34912a.f34905e.a(this.f34912a.f34909i.j());
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    if (!z) {
                        this.f34912a.f34905e.a();
                    } else if (this.f34912a.f34907g.i()) {
                        this.f34912a.f34904d.b();
                    }
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    this.f34912a.i();
                    this.f34912a.f34904d.a();
                    if (z) {
                        if (this.f34912a.f34907g.i()) {
                            this.f34912a.f34904d.d();
                        } else if (!this.f34912a.f34908h.d(this.f34912a.f34905e)) {
                            this.f34912a.f34908h.c(this.f34912a.f34905e);
                        }
                    }
                    this.f34912a.f34905e.a(this.f34912a.f34909i.j());
                }
            }
        };
        this.p = new RecyclerView.OnScrollListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RelatedVideoPanel f34913a;

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
                this.f34913a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i42) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i42) == null) {
                    super.onScrollStateChanged(recyclerView, i42);
                    if (i42 == 1) {
                        this.f34913a.j();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i42, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i42, i5) == null) {
                    super.onScrolled(recyclerView, i42, i5);
                    if (i42 > 0 || i5 > 0) {
                        this.f34913a.j();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65540, this, i2) == null) {
            e.a(this.l, i2);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            View findViewById = findViewById(R.id.ksad_related_space);
            this.f34902b = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = findViewById(R.id.ksad_related_close_button);
            this.f34903c = findViewById2;
            findViewById2.setOnClickListener(this);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ksad_related_recycler_view);
            this.f34906f = recyclerView;
            recyclerView.setItemAnimator(null);
            this.f34906f.addItemDecoration(new d(2, ao.a(getContext(), R.dimen.ksad_content_related_video_item_padding)));
            this.f34904d = (KSHalfPageLoadingView) findViewById(R.id.ksad_page_loading);
            this.f34905e = new com.kwad.sdk.contentalliance.widget.d(getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.m) {
            return;
        }
        this.m = true;
        e.q(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            RecyclerView.LayoutManager layoutManager = this.f34906f.getLayoutManager();
            if (layoutManager.getChildCount() <= 0 || !k()) {
                return;
            }
            if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.f34907g.getItemCount() - 6 || this.f34907g.j()) {
                return;
            }
            this.f34909i.m();
        }
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.f34909i;
            return (cVar == null || cVar.f() == null || this.f34909i.f().isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setFocusableInTouchMode(false);
            clearFocus();
            setOnKeyListener(null);
            setVisibility(8);
            a aVar = this.j;
            if (aVar != null) {
                aVar.b();
            }
            this.f34904d.a();
            this.f34904d.setRetryClickListener(null);
            b();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void a(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) && i2 == 1000 && i3 == -1) {
            int intExtra = intent.getIntExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", 0);
            com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.f34909i;
            if (cVar != null) {
                cVar.k();
                this.f34901a.postDelayed(new Runnable(this, intExtra) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f34914a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ RelatedVideoPanel f34915b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(intExtra)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34915b = this;
                        this.f34914a = intExtra;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f34915b.f34906f.scrollToPosition(this.f34914a);
                        }
                    }
                }, 100L);
            }
        }
    }

    public void a(KsFragment ksFragment, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ksFragment, adTemplate) == null) {
            this.k = adTemplate;
            this.l = adTemplate.mAdScene;
            this.f34909i = new c(adTemplate);
            this.f34906f.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
            b bVar = new b(ksFragment, this.f34906f, this.k);
            this.f34907g = bVar;
            bVar.a(this.f34909i.g());
            this.f34907g.a(this.f34909i);
            com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(this.f34907g);
            this.f34908h = dVar;
            dVar.a(this.f34906f);
            this.f34906f.setAdapter(this.f34908h);
            this.f34906f.addOnScrollListener(this.p);
            this.f34909i.a(this.o);
            this.f34909i.k();
            this.f34904d.setRetryClickListener(this.n);
            setVisibility(0);
            setFocusableInTouchMode(true);
            requestFocus();
            setOnKeyListener(new View.OnKeyListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RelatedVideoPanel f34910a;

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
                    this.f34910a = this;
                }

                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                        if (keyEvent.getAction() == 1 && i2 == 4) {
                            this.f34910a.a();
                            this.f34910a.a(5);
                            return true;
                        }
                        return false;
                    }
                    return invokeLIL.booleanValue;
                }
            });
            a aVar = this.j;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = false;
            this.f34901a.removeCallbacksAndMessages(null);
            this.f34906f.setLayoutManager(null);
            this.f34906f.setAdapter(null);
            b bVar = this.f34907g;
            if (bVar != null) {
                bVar.k();
                this.f34907g = null;
            }
            com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.f34909i;
            if (cVar != null) {
                cVar.h();
            }
            this.j = null;
            com.kwad.sdk.contentalliance.detail.photo.related.a.a().e();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            boolean z = true;
            if (action != 0) {
                if (action == 1 || action == 3) {
                    parent = getParent();
                    z = false;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            parent = getParent();
            parent.requestDisallowInterceptTouchEvent(z);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (view == this.f34902b) {
                a();
                i2 = 3;
            } else if (view != this.f34903c) {
                return;
            } else {
                a();
                i2 = 1;
            }
            a(i2);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onFinishInflate();
            h();
        }
    }

    public void setRelatedPanelListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.j = aVar;
        }
    }
}
