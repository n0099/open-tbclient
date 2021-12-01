package com.kwad.sdk.core.download.kwai;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes2.dex */
public class g extends com.kwad.sdk.widget.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public String f57430b;

    /* renamed from: c  reason: collision with root package name */
    public String f57431c;

    /* renamed from: d  reason: collision with root package name */
    public int f57432d;

    /* renamed from: e  reason: collision with root package name */
    public String f57433e;

    /* renamed from: f  reason: collision with root package name */
    public int f57434f;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public b f57435b;

        /* renamed from: c  reason: collision with root package name */
        public String f57436c;

        /* renamed from: d  reason: collision with root package name */
        public String f57437d;

        /* renamed from: e  reason: collision with root package name */
        public int f57438e;

        /* renamed from: f  reason: collision with root package name */
        public String f57439f;

        /* renamed from: g  reason: collision with root package name */
        public int f57440g;

        public a(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        public a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.f57435b = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f57436c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public com.kwad.sdk.widget.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new g(this) : (com.kwad.sdk.widget.a) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar) {
        super(aVar.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
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
        a(aVar);
    }

    private View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            View inflate = LayoutInflater.from(Wrapper.wrapContextIfNeed(getContext())).inflate(R.layout.ksad_no_title_common_dialog_content_layout, (ViewGroup) null, false);
            inflate.findViewById(R.id.ksad_no_title_common_dialog_layout).setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.download.kwai.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.a.a == null) {
                        return;
                    }
                    this.a.a.c(this.a);
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.ksad_no_title_common_positive_btn);
            if (!TextUtils.isEmpty(this.f57431c)) {
                textView.setText(this.f57431c);
            }
            textView.setTextColor(this.f57432d);
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.download.kwai.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.a.a == null) {
                        return;
                    }
                    this.a.a.a(this.a);
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_no_title_common_negative_btn);
            if (!TextUtils.isEmpty(this.f57433e)) {
                textView2.setText(this.f57433e);
            }
            textView2.setTextColor(this.f57434f);
            textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.download.kwai.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.a.a == null) {
                        return;
                    }
                    this.a.a.b(this.a);
                }
            });
            ((TextView) inflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.f57430b);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            if (aVar.a instanceof Activity) {
                setOwnerActivity((Activity) aVar.a);
            }
            this.a = aVar.f57435b;
            this.f57430b = aVar.f57436c;
            this.f57431c = !TextUtils.isEmpty(aVar.f57437d) ? aVar.f57437d : aVar.a.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
            this.f57432d = aVar.f57438e != 0 ? aVar.f57438e : aVar.a.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
            this.f57433e = !TextUtils.isEmpty(aVar.f57439f) ? aVar.f57439f : aVar.a.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
            this.f57434f = aVar.f57440g != 0 ? aVar.f57440g : aVar.a.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(a());
            setCanceledOnTouchOutside(true);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        }
    }
}
