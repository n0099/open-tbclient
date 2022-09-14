package com.kwad.components.ad.reward.k;

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
/* loaded from: classes7.dex */
public class p extends v implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;
    public TextView li;
    public ImageView ll;
    public TextView nH;
    @Nullable
    public KsAppTagsView uu;
    public KSCornerButton vX;
    public KsConvertButton vY;
    public View vZ;
    @Nullable
    public TextView wa;
    public a wb;
    @LayoutRes
    public int wc;
    public boolean wd;

    /* loaded from: classes7.dex */
    public interface a {
        void hs();

        void ht();

        void hu();

        void hv();
    }

    public p() {
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
        this.wc = R.layout.obfuscated_res_0x7f0d0455;
        this.wd = true;
    }

    private void T(int i) {
        KSCornerButton kSCornerButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65537, this, i) == null) || (kSCornerButton = this.vX) == null || this.vY == null) {
            return;
        }
        if (i == 1) {
            kSCornerButton.getCornerConf().bx(true);
            this.vY.getCornerConf().bx(true);
            this.vZ.setVisibility(0);
        } else if (i == 2) {
            kSCornerButton.getCornerConf().bt(true).bw(true).bv(false).bu(false);
            this.vY.getCornerConf().bt(false).bw(false).bv(true).bu(true);
            this.vZ.setVisibility(8);
        }
        this.vX.postInvalidate();
        this.vY.postInvalidate();
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.wb = aVar;
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uVar) == null) {
            super.a(uVar);
            a(com.kwad.components.ad.reward.model.a.a(uVar, this.wd));
        }
    }

    public void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null || this.vX == null) {
            return;
        }
        T(aVar.gD());
        this.bq.T(aVar.gA());
        this.li.setText(aVar.getTitle());
        this.nH.setText(aVar.fO());
        TextView textView2 = this.wa;
        if (textView2 != null) {
            textView2.setText(aVar.fO());
            if (TextUtils.isEmpty(aVar.fO())) {
                i2 = 8;
            } else if (aVar.gC()) {
                i2 = 8;
                i = 0;
                this.nH.setVisibility(i2);
                textView = this.wa;
            } else {
                i2 = 0;
            }
            i = 8;
            this.nH.setVisibility(i2);
            textView = this.wa;
        } else {
            textView = this.nH;
            i = TextUtils.isEmpty(aVar.fO()) ? 8 : 0;
        }
        textView.setVisibility(i);
        KsAppTagsView ksAppTagsView = this.uu;
        if (ksAppTagsView != null) {
            ksAppTagsView.c(aVar.gB(), this.wc);
            this.uu.setVisibility(aVar.gC() ? 8 : 0);
        }
        this.vY.a(aVar.getApkDownloadHelper(), aVar.gA());
        KSImageLoader.loadAppIcon(this.ll, aVar.eL(), aVar.gA(), 12);
    }

    public final void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            super.a(viewGroup, jb(), jc());
            g(this.pV);
            ViewGroup viewGroup2 = this.pV;
            if (viewGroup2 != null) {
                viewGroup2.setOnClickListener(this);
                this.vX.setOnClickListener(this);
                this.vY.setOnClickListener(this);
            }
        }
    }

    public void g(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        this.bq = (KsLogoView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911bb);
        this.ll = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911b8);
        this.li = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911bd);
        this.uu = (KsAppTagsView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911be);
        this.nH = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911b6);
        this.wa = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911b7);
        this.vX = (KSCornerButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911ba);
        this.vY = (KsConvertButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911b3);
        this.vZ = viewGroup.findViewById(R.id.obfuscated_res_0x7f0911bc);
    }

    public int jb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.id.obfuscated_res_0x7f0911b5 : invokeV.intValue;
    }

    public int jc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.id.obfuscated_res_0x7f0911b4 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (view2.equals(this.vX)) {
                a aVar2 = this.wb;
                if (aVar2 != null) {
                    aVar2.ht();
                }
            } else if (view2.equals(this.vY)) {
                a aVar3 = this.wb;
                if (aVar3 != null) {
                    aVar3.hu();
                }
            } else if (!view2.equals(this.pV) || (aVar = this.wb) == null) {
            } else {
                aVar.hv();
            }
        }
    }

    public final void show() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewGroup = this.pV) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        a aVar = this.wb;
        if (aVar != null) {
            aVar.hs();
        }
    }
}
