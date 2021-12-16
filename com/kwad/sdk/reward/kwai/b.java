package com.kwad.sdk.reward.kwai;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.h.e;
import com.kwad.sdk.reward.kwai.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.reward.kwai.a a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f59568b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f59569c;

    /* renamed from: d  reason: collision with root package name */
    public a f59570d;

    /* loaded from: classes3.dex */
    public interface a {
        void b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, activity, adTemplate, aVar, iArr) == null) || adTemplate == null || activity == null) {
            return;
        }
        String jSONObject = adTemplate.toJson().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", jSONObject);
        bundle.putIntArray("key_end_location", iArr);
        b bVar = new b();
        bVar.a(aVar);
        bVar.setArguments(bundle);
        bVar.show(activity.getFragmentManager(), "rewardCoupon");
    }

    @Override // com.kwad.sdk.h.e
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            getDialog().requestWindowFeature(1);
            com.kwad.sdk.reward.kwai.a aVar = new com.kwad.sdk.reward.kwai.a(layoutInflater.getContext(), viewGroup, this.f59568b);
            this.a = aVar;
            aVar.a(this);
            Window window = getDialog().getWindow();
            if (window != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
                getDialog().setCanceledOnTouchOutside(false);
                window.setLayout(-1, -1);
                window.setDimAmount(0.0f);
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            this.a.a(this.f59569c);
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.sdk.reward.kwai.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) ? i2 == 4 && keyEvent.getAction() == 0 : invokeLIL.booleanValue;
                }
            });
            return this.a.a();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.kwad.sdk.reward.kwai.a.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dismiss();
            a aVar = this.f59570d;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f59570d = aVar;
        }
    }

    @Override // com.kwad.sdk.reward.kwai.a.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            dismiss();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                if (arguments.containsKey("key_template_json")) {
                    try {
                        String string = arguments.getString("key_template_json");
                        AdTemplate adTemplate = new AdTemplate();
                        this.f59569c = adTemplate;
                        adTemplate.parseJson(new JSONObject(string));
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                }
                if (arguments.containsKey("key_end_location")) {
                    this.f59568b = arguments.getIntArray("key_end_location");
                }
            }
        }
    }
}
