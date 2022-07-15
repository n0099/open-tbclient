package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.b;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
/* loaded from: classes5.dex */
public class ActionBarAppPortrait extends LinearLayout implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public AppScoreView d;
    public TextView e;
    public TextProgressBar f;
    public View g;
    public AdTemplate h;
    public AdInfo i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0470, this);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff5);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff9);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff1);
            this.d = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f090ff8);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff4);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f090ff3);
            this.f = textProgressBar;
            textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
            this.f.setTextColor(-1);
            this.g = findViewById(R.id.obfuscated_res_0x7f09102c);
        }
    }

    private void a(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, view2, z) == null) {
            com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(this.h).a(this.k).a(view2 == this.f).a(view2 == this.g ? 1 : 2).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ActionBarAppPortrait b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = z;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.b.j == null) {
                        return;
                    }
                    this.b.j.a(this.a);
                }
            }));
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String D = com.kwad.sdk.core.response.a.a.D(this.i);
            boolean z = !TextUtils.isEmpty(D);
            float E = com.kwad.sdk.core.response.a.a.E(this.i);
            boolean z2 = E >= 3.0f;
            if (z && z2) {
                ((LinearLayout.LayoutParams) this.b.getLayoutParams()).bottomMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 1.0f);
                ((LinearLayout.LayoutParams) this.d.getLayoutParams()).bottomMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 1.0f);
                this.e.setText(D);
                this.e.setVisibility(0);
                this.d.setVisibility(0);
                this.d.setScore(E);
                this.c.setVisibility(8);
            } else if (z) {
                this.e.setText(D);
                this.e.setVisibility(0);
                this.d.setVisibility(8);
                this.c.setVisibility(8);
            } else if (z2) {
                this.e.setVisibility(8);
                this.d.setScore(E);
                this.d.setVisibility(0);
                this.c.setVisibility(8);
            } else {
                this.c.setText(com.kwad.sdk.core.response.a.a.z(this.i));
                this.e.setVisibility(8);
                this.d.setVisibility(8);
                this.c.setVisibility(0);
            }
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.l == null) {
                this.l = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ActionBarAppPortrait a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.core.download.kwai.a
                    public final void a(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            this.a.f.a(com.kwad.sdk.core.response.a.a.b(i), i);
                            this.a.g.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.a.f.a(com.kwad.sdk.core.response.a.a.H(this.a.i), 0);
                            this.a.g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.a.f.a(com.kwad.sdk.core.response.a.a.a(this.a.h), 0);
                            this.a.g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.a.f.a(com.kwad.sdk.core.response.a.a.H(this.a.i), 0);
                            this.a.g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.a.f.a(com.kwad.sdk.core.response.a.a.n(this.a.i), 0);
                            this.a.g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                            this.a.f.a(com.kwad.sdk.core.response.a.a.a(i), i);
                            this.a.g.setVisibility(8);
                        }
                    }
                };
            }
            return this.l;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, bVar, aVar) == null) {
            this.h = adTemplate;
            AdInfo i = d.i(adTemplate);
            this.i = i;
            this.j = aVar;
            this.k = bVar;
            KSImageLoader.loadAppIcon(this.a, com.kwad.sdk.core.response.a.a.aE(i), adTemplate, 12);
            this.b.setText(com.kwad.sdk.core.response.a.a.aC(this.i));
            b();
            this.f.a(com.kwad.sdk.core.response.a.a.H(this.i), 0);
            b bVar2 = this.k;
            if (bVar2 != null) {
                bVar2.a(getAppDownloadListener());
            }
            setClickable(true);
            new f(this, this);
            new f(this.g, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            a(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && com.kwad.sdk.core.response.a.c.d(this.h)) {
            a(view2, false);
        }
    }
}
