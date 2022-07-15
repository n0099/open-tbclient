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
/* loaded from: classes5.dex */
public final class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    @Nullable
    public TextView b;
    @Nullable
    public ImageView c;
    @Nullable
    public ImageView d;
    @Nullable
    public InterfaceC0513a e;

    /* renamed from: com.kwad.components.core.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0513a {
        void a(View view2);

        void b(View view2);
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
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f09107b);
        this.a = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091078);
            this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091079);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09107a);
            this.d = imageView;
            imageView.setOnClickListener(this);
            this.c.setOnClickListener(this);
        }
    }

    public final void a(@Nullable InterfaceC0513a interfaceC0513a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0513a) == null) {
            this.e = interfaceC0513a;
        }
    }

    public final void a(b bVar) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || this.a == null || (textView = this.b) == null) {
            return;
        }
        textView.setText(bVar.a());
    }

    @MainThread
    public final void a(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (imageView = this.d) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    @MainThread
    public final void b(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (imageView = this.c) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || this.e == null) {
            return;
        }
        if (view2.equals(this.d)) {
            this.e.b(view2);
        } else if (view2.equals(this.c)) {
            this.e.a(view2);
        }
    }
}
