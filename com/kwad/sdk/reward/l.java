package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KSCornerImageView;
import com.kwad.sdk.widget.KsPriceView;
import com.kwad.sdk.widget.KsStyledTextButton;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l extends com.kwad.sdk.h.e {
    public static /* synthetic */ Interceptable $ic;
    public static l a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f58993b;

    /* renamed from: c  reason: collision with root package name */
    public a f58994c;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: classes2.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public l a;

        /* renamed from: b  reason: collision with root package name */
        public a f58995b;

        public b(@Nullable l lVar, @Nullable a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58995b = aVar;
            this.a = lVar;
        }

        @Override // com.kwad.sdk.reward.l.a
        public void a() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f58995b) == null) {
                return;
            }
            aVar.a();
        }

        @Override // com.kwad.sdk.reward.l.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                e();
                a aVar = this.f58995b;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void c() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f58995b) == null) {
                return;
            }
            aVar.c();
        }

        @Override // com.kwad.sdk.reward.l.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                e();
                a aVar = this.f58995b;
                if (aVar != null) {
                    aVar.d();
                }
            }
        }

        public void e() {
            l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (lVar = this.a) == null) {
                return;
            }
            lVar.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f58996b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f58997c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58998d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58999e;

        /* renamed from: f  reason: collision with root package name */
        public KSCornerImageView f59000f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59001g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f59002h;

        /* renamed from: i  reason: collision with root package name */
        public View f59003i;

        /* renamed from: j  reason: collision with root package name */
        public AdTemplate f59004j;

        public c(ViewGroup viewGroup, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup, adTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.f59004j = adTemplate;
            b();
        }

        private void a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, eVar) == null) {
                this.f58998d.setText(eVar.b());
                SpannableString g2 = eVar.g();
                if (g2 != null) {
                    this.f58999e.setText(g2);
                }
                this.f59001g.setText(eVar.c());
                this.f59002h.setText(eVar.d());
                KSImageLoader.loadImage(this.f59000f, eVar.a(), this.f59004j);
            }
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f58997c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_end_root);
                this.f58998d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_title);
                this.f58999e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_fans);
                this.f59000f = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_end_icon);
                this.f59001g = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_desc);
                this.f59002h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_follow_end_btn_follow);
                this.f59003i = this.a.findViewById(R.id.ksad_reward_follow_end_btn_close);
                this.f59002h.setOnClickListener(this);
                this.f59003i.setOnClickListener(this);
                this.f59000f.setOnClickListener(this);
                this.f58998d.setOnClickListener(this);
                this.f58999e.setOnClickListener(this);
                this.f59001g.setOnClickListener(this);
            }
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58997c : (ViewGroup) invokeV.objValue;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
                super.a(adTemplate);
                a(e.a(adTemplate));
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.f58996b = aVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.f58996b == null) {
                return;
            }
            if (view.equals(this.f59003i)) {
                this.f58996b.b();
            } else if (view.equals(this.f59002h)) {
                this.f58996b.c();
            } else if (view.equals(this.f59001g) || view.equals(this.f58998d) || view.equals(this.f58999e)) {
                this.f58996b.d();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f59005b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f59006c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59007d;

        /* renamed from: e  reason: collision with root package name */
        public KSCornerImageView f59008e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f59009f;

        /* renamed from: g  reason: collision with root package name */
        public KsPriceView f59010g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f59011h;

        /* renamed from: i  reason: collision with root package name */
        public View f59012i;

        public d(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            b();
        }

        private void a(e eVar, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, eVar, adTemplate) == null) {
                this.f59011h.setText(eVar.d());
                this.f59007d.setText(eVar.b());
                this.f59009f.setText(eVar.c());
                this.f59010g.a(eVar.e(), eVar.f());
                KSImageLoader.loadImage(this.f59008e, eVar.a(), adTemplate);
            }
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f59006c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_order_end_card_root);
                this.f59007d = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_title);
                this.f59008e = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_end_icon);
                this.f59009f = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_desc);
                this.f59010g = (KsPriceView) this.a.findViewById(R.id.ksad_reward_order_end_price);
                this.f59011h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_order_end_btn_buy);
                this.f59012i = this.a.findViewById(R.id.ksad_reward_order_end_btn_close);
                this.f59011h.setOnClickListener(this);
                this.f59012i.setOnClickListener(this);
                this.f59009f.setOnClickListener(this);
                this.f59010g.setOnClickListener(this);
                this.f59007d.setOnClickListener(this);
            }
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59006c : (ViewGroup) invokeV.objValue;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
                super.a(adTemplate);
                a(e.b(adTemplate), adTemplate);
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.f59005b = aVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.f59005b == null) {
                return;
            }
            if (view.equals(this.f59012i)) {
                this.f59005b.b();
            } else if (view.equals(this.f59011h)) {
                this.f59005b.c();
            } else if (view.equals(this.f59009f) || view.equals(this.f59007d) || view.equals(this.f59010g)) {
                this.f59005b.d();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f59013b;

        /* renamed from: c  reason: collision with root package name */
        public String f59014c;

        /* renamed from: d  reason: collision with root package name */
        public String f59015d;

        /* renamed from: e  reason: collision with root package name */
        public String f59016e;

        /* renamed from: f  reason: collision with root package name */
        public String f59017f;

        /* renamed from: g  reason: collision with root package name */
        public SpannableString f59018g;

        public e() {
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

        @Nullable
        public static e a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                if (adTemplate == null) {
                    return null;
                }
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                e eVar = new e();
                eVar.f59013b = com.kwad.sdk.core.response.a.a.aD(j2);
                eVar.a = com.kwad.sdk.core.response.a.a.aE(j2);
                eVar.f59018g = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
                eVar.f59014c = com.kwad.sdk.core.response.a.a.aC(j2);
                eVar.f59015d = com.kwad.sdk.core.response.a.a.aA(j2) ? com.kwad.sdk.core.config.b.aD() : com.kwad.sdk.core.config.b.aG();
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Nullable
        public static e b(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
                if (adTemplate == null) {
                    return null;
                }
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(j2);
                e eVar = new e();
                eVar.f59013b = aK.getName();
                eVar.a = aK.getIcon();
                eVar.f59014c = com.kwad.sdk.core.response.a.a.s(j2);
                eVar.f59015d = com.kwad.sdk.core.config.b.aE();
                eVar.f59016e = aK.getPrice();
                eVar.f59017f = aK.getOriginPrice();
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59013b : (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59014c : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59015d : (String) invokeV.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59016e : (String) invokeV.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59017f : (String) invokeV.objValue;
        }

        public SpannableString g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59018g : (SpannableString) invokeV.objValue;
        }
    }

    public l() {
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

    public static int a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return -1;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            if (com.kwad.sdk.core.response.a.a.aH(j2)) {
                return 0;
            }
            return com.kwad.sdk.core.response.a.a.aI(j2) ? 1 : -1;
        }
        return invokeL.intValue;
    }

    public static void a(Activity activity, AdTemplate adTemplate, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, activity, adTemplate, bVar) == null) || adTemplate == null || activity == null || activity.isFinishing()) {
            return;
        }
        a = new l();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        bVar.a = a;
        a.setArguments(bundle);
        a.a(bVar);
        try {
            a.show(activity.getFragmentManager(), "videoEndDialog");
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: com.kwad.sdk.reward.l$d */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.h.e
    @Nullable
    public View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        View inflate;
        com.kwad.sdk.widget.c cVar;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            getDialog().requestWindowFeature(1);
            try {
                String string = getArguments().getString("key_template_json");
                AdTemplate adTemplate = new AdTemplate();
                this.f58993b = adTemplate;
                adTemplate.parseJson(new JSONObject(string));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
            if (a(this.f58993b) != 0) {
                inflate = layoutInflater.inflate(R.layout.ksad_reward_order_end_dialog, viewGroup, false);
                d dVar = new d((ViewGroup) inflate);
                dVar.a(new b(this, this.f58994c));
                cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
                cVar2 = dVar;
            } else {
                inflate = layoutInflater.inflate(R.layout.ksad_reward_follow_end_dialog, viewGroup, false);
                c cVar3 = new c((ViewGroup) inflate, this.f58993b);
                cVar3.a(new b(this, this.f58994c));
                cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
                cVar2 = cVar3;
            }
            cVar2.a(this.f58993b);
            w.a(cVar, cVar2.a());
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.sdk.reward.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l a;

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
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f58994c = aVar;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Window window = getDialog().getWindow();
            if (window == null) {
                return;
            }
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            a aVar = this.f58994c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
