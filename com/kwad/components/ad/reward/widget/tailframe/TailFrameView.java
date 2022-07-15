package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TailFrameView extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.widget.tailframe.a a;
    public l b;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(R.layout.obfuscated_res_0x7f0d047b);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, jSONObject, bVar) == null) {
                super.a(adTemplate, jSONObject, bVar);
                KSImageLoader.loadImage(this.d, com.kwad.sdk.core.response.a.a.k(this.b), this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView f;
        public ImageView g;
        public ImageView h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(R.layout.obfuscated_res_0x7f0d047c);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                KSImageLoader.loadImage(this.f, com.kwad.sdk.core.response.a.a.k(this.b), this.a);
                KSImageLoader.loadImage(this.g, com.kwad.sdk.core.response.a.a.k(this.b), this.a);
                KSImageLoader.loadImage(this.h, com.kwad.sdk.core.response.a.a.k(this.b), this.a);
            }
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                super.a(context);
                this.f = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0911e5);
                this.g = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0911e6);
                this.h = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0911e7);
            }
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, jSONObject, bVar) == null) {
                super.a(adTemplate, jSONObject, bVar);
                d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(R.layout.obfuscated_res_0x7f0d047d);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                AdInfo.AdMaterialInfo.MaterialFeature Q = com.kwad.sdk.core.response.a.a.Q(this.b);
                int i = Q.width;
                int i2 = Q.height;
                int c = com.kwad.sdk.b.kwai.a.c(this.c.getContext());
                ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
                layoutParams.width = c;
                layoutParams.height = (int) (c * (i2 / i));
                KSImageLoader.loadImage(this.d, Q.coverUrl, this.a);
            }
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                super.a(context);
                this.f = this.c.findViewById(R.id.obfuscated_res_0x7f09238e);
            }
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, jSONObject, bVar) == null) {
                super.a(adTemplate, jSONObject, bVar);
                if (com.kwad.sdk.core.response.a.d.q(this.a)) {
                    this.f.setVisibility(8);
                    this.e.setVisibility(8);
                    View view2 = this.c;
                    view2.setBackgroundColor(ContextCompat.getColor(view2.getContext(), R.color.obfuscated_res_0x7f060765));
                }
                d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d() {
            super(R.layout.obfuscated_res_0x7f0d047e);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, jSONObject, bVar) == null) {
                super.a(adTemplate, jSONObject, bVar);
                if (com.kwad.sdk.core.response.a.d.q(this.a)) {
                    View view2 = this.c;
                    view2.setBackgroundColor(ContextCompat.getColor(view2.getContext(), R.color.obfuscated_res_0x7f060765));
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                }
                KSImageLoader.loadImage(this.d, com.kwad.sdk.core.response.a.a.k(this.b), this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailFrameView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailFrameView(@NonNull Context context, View view2) {
        super(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    private void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a == null) {
            this.a = z ? z2 ? new d() : new c() : z2 ? new b() : new a();
        }
    }

    public final void a(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            a(z, z2);
            this.a.a(context);
            this.a.a(z, z2);
            addView(this.a.a(), -1, -1);
        }
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.a.a(this.b);
            com.kwad.components.ad.reward.widget.tailframe.a aVar = this.a;
            l lVar = this.b;
            aVar.a(lVar.g, lVar.e, bVar);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.c();
        }
    }

    public final void d() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.b();
    }

    public void setCallerContext(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lVar) == null) {
            this.b = lVar;
        }
    }
}
