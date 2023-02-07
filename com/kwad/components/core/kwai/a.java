package com.kwad.components.core.kwai;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ImageView CO;
    @Nullable
    public ImageView CP;
    @Nullable
    public InterfaceC0603a CQ;
    @Nullable
    public TextView mTitle;
    public ViewGroup pV;

    /* renamed from: com.kwad.components.core.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0603a {
        void r(View view2);

        void s(View view2);
    }

    public a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911cb);
        this.pV = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mTitle = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f0911c8);
            this.CO = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f0911c9);
            ImageView imageView = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f0911ca);
            this.CP = imageView;
            imageView.setOnClickListener(this);
            this.CO.setOnClickListener(this);
        }
    }

    public final void a(@Nullable InterfaceC0603a interfaceC0603a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0603a) == null) {
            this.CQ = interfaceC0603a;
        }
    }

    public final void a(b bVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || this.pV == null || (textView = this.mTitle) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }

    @MainThread
    public final void ag(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (imageView = this.CP) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    @MainThread
    public final void ah(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (imageView = this.CO) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || this.CQ == null) {
            return;
        }
        if (view2.equals(this.CP)) {
            this.CQ.s(view2);
        } else if (view2.equals(this.CO)) {
            this.CQ.r(view2);
        }
    }
}
