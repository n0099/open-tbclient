package com.kwad.components.ad.reward.i;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes5.dex */
public class r extends x implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView a;
    public KSCornerButton b;
    public KsConvertButton c;
    public View d;
    public TextView e;
    public ImageView f;
    public TextView g;
    @Nullable
    public TextView h;
    @Nullable
    public KsAppTagsView i;
    public a j;
    @LayoutRes
    public int k;
    public boolean l;

    /* loaded from: classes5.dex */
    public interface a {
        void b();

        void c();

        void d();

        void l_();
    }

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = R.layout.obfuscated_res_0x7f0d044d;
        this.l = true;
    }

    private void a(int i) {
        KSCornerButton kSCornerButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65537, this, i) == null) || (kSCornerButton = this.b) == null || this.c == null) {
            return;
        }
        if (i == 1) {
            kSCornerButton.getCornerConf().e(true);
            this.c.getCornerConf().e(true);
            this.d.setVisibility(0);
        } else if (i == 2) {
            kSCornerButton.getCornerConf().a(true).d(true).c(false).b(false);
            this.c.getCornerConf().a(false).d(false).c(true).b(true);
            this.d.setVisibility(8);
        }
        this.b.postInvalidate();
        this.c.postInvalidate();
    }

    public final void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            super.a(viewGroup, c(), d());
            b(this.m);
            ViewGroup viewGroup2 = this.m;
            if (viewGroup2 != null) {
                viewGroup2.setOnClickListener(this);
                this.b.setOnClickListener(this);
                this.c.setOnClickListener(this);
            }
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.j = aVar;
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) {
            super.a(wVar);
            a(com.kwad.components.ad.reward.model.a.a(wVar, this.l));
        }
    }

    public void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || this.b == null) {
            return;
        }
        a(aVar.n());
        this.a.a(aVar.j());
        this.e.setText(aVar.b());
        this.g.setText(aVar.c());
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setText(aVar.c());
            if (TextUtils.isEmpty(aVar.c())) {
                i2 = 8;
            } else if (aVar.m()) {
                i2 = 8;
                i = 0;
                this.g.setVisibility(i2);
                textView = this.h;
            } else {
                i2 = 0;
            }
            i = 8;
            this.g.setVisibility(i2);
            textView = this.h;
        } else {
            textView = this.g;
            i = TextUtils.isEmpty(aVar.c()) ? 8 : 0;
        }
        textView.setVisibility(i);
        KsAppTagsView ksAppTagsView = this.i;
        if (ksAppTagsView != null) {
            ksAppTagsView.a(aVar.l(), this.k);
            this.i.setVisibility(aVar.m() ? 8 : 0);
        }
        this.c.a(aVar.k(), aVar.j());
        KSImageLoader.loadAppIcon(this.f, aVar.a(), aVar.j(), 12);
    }

    public void b(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        this.a = (KsLogoView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091167);
        this.f = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091164);
        this.e = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091169);
        this.i = (KsAppTagsView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09116a);
        this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091162);
        this.h = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091163);
        this.b = (KSCornerButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f091166);
        this.c = (KsConvertButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f09115f);
        this.d = viewGroup.findViewById(R.id.obfuscated_res_0x7f091168);
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.id.obfuscated_res_0x7f091161 : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.id.obfuscated_res_0x7f091160 : invokeV.intValue;
    }

    public final void e() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (viewGroup = this.m) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        a aVar = this.j;
        if (aVar != null) {
            aVar.l_();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2.equals(this.b)) {
                a aVar2 = this.j;
                if (aVar2 != null) {
                    aVar2.b();
                }
            } else if (view2.equals(this.c)) {
                a aVar3 = this.j;
                if (aVar3 != null) {
                    aVar3.c();
                }
            } else if (!view2.equals(this.m) || (aVar = this.j) == null) {
            } else {
                aVar.d();
            }
        }
    }
}
