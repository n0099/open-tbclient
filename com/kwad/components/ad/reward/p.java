package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p extends com.kwad.components.core.h.e {
    public static /* synthetic */ Interceptable $ic;
    public static p a;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate b;
    public b c;
    public f d;

    /* loaded from: classes5.dex */
    public interface a extends com.kwad.components.ad.reward.e {
        void a(int i);

        void c();
    }

    /* loaded from: classes5.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public p a;
        public a b;

        public b(@Nullable p pVar, @Nullable a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aVar;
            this.a = pVar;
        }

        private void e() {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (pVar = this.a) == null) {
                return;
            }
            pVar.dismiss();
        }

        @Override // com.kwad.components.ad.reward.e
        public final void a() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.b) == null) {
                return;
            }
            aVar.a();
        }

        @Override // com.kwad.components.ad.reward.p.a
        public void a(int i) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (aVar = this.b) == null) {
                return;
            }
            aVar.a(i);
        }

        @Override // com.kwad.components.ad.reward.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                e();
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        }

        @Override // com.kwad.components.ad.reward.e
        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.kwad.components.ad.reward.p.a
        public void c() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.b) == null) {
                return;
            }
            aVar.c();
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup c;
        public a d;
        public TextView e;
        public KSCornerImageView f;
        public TextView g;
        public KsStyledTextButton h;
        public View i;
        public AdTemplate j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ViewGroup viewGroup, AdTemplate adTemplate) {
            super((byte) 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup, adTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Byte) newInitContext.callArgs[0]).byteValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = viewGroup;
            this.j = adTemplate;
            c();
        }

        private void a(com.kwad.components.ad.reward.model.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
                this.b.setText(aVar.b());
                SpannableString g = aVar.g();
                if (g != null) {
                    this.e.setText(g);
                }
                this.g.setText(aVar.c());
                this.h.setText(aVar.d());
                KSImageLoader.loadImage(this.f, aVar.a(), this.j);
            }
        }

        private void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.a = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f09110b);
                this.b = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09110c);
                this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091109);
                this.f = (KSCornerImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09110a);
                this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091108);
                this.h = (KsStyledTextButton) this.c.findViewById(R.id.obfuscated_res_0x7f091107);
                this.i = this.c.findViewById(R.id.obfuscated_res_0x7f091106);
                this.h.setOnClickListener(this);
                this.i.setOnClickListener(this);
                this.f.setOnClickListener(this);
                this.b.setOnClickListener(this);
                this.e.setOnClickListener(this);
                this.g.setOnClickListener(this);
            }
        }

        @Override // com.kwad.components.ad.reward.i.d
        public final void a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wVar) == null) {
                super.a(wVar);
                a(com.kwad.components.ad.reward.model.a.a(wVar.a()));
            }
        }

        public final void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.d = aVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.d == null) {
                return;
            }
            if (view2.equals(this.i)) {
                this.d.a(false);
            } else if (view2.equals(this.h)) {
                this.d.a(15);
            } else if (view2.equals(this.g) || view2.equals(this.b) || view2.equals(this.e)) {
                this.d.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public TextView g;
        public TextView h;
        public a i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super((byte) 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutInflater, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Byte) newInitContext.callArgs[0]).byteValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0437, viewGroup, false);
            c();
        }

        private void a(com.kwad.components.ad.reward.model.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
                this.g.setText(aVar.t());
                this.b.setText(aVar.b());
                String o = aVar.o();
                if (!TextUtils.isEmpty(o)) {
                    String format = String.format("当前已经有%s预约", o);
                    int color = this.a.getResources().getColor(R.color.obfuscated_res_0x7f06075f);
                    int indexOf = format.indexOf(o);
                    SpannableString spannableString = new SpannableString(format);
                    spannableString.setSpan(new ForegroundColorSpan(color), indexOf, o.length() + indexOf, 17);
                    this.h.setText(spannableString);
                }
                this.d.setText(aVar.p());
                this.e.setText(aVar.q());
                KSImageLoader.loadCircleIcon(this.f, aVar.a(), this.f.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bd1));
            }
        }

        private void c() {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (viewGroup = this.a) == null) {
                return;
            }
            this.c = viewGroup.findViewById(R.id.obfuscated_res_0x7f091088);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091089);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09108a);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09108b);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09108d);
            this.b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09108f);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09108e);
            this.c.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.b.setOnClickListener(this);
            this.h.setOnClickListener(this);
        }

        @Override // com.kwad.components.ad.reward.i.d
        public final void a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wVar) == null) {
                super.a(wVar);
                AdTemplate a = wVar.a();
                if (a != null) {
                    a(com.kwad.components.ad.reward.model.a.d(a));
                }
            }
        }

        public final void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.i = aVar;
            }
        }

        @Override // com.kwad.components.ad.reward.p.f
        public final void a(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
                super.a(adTemplate);
                com.kwad.sdk.core.report.a.c(adTemplate, 19, (JSONObject) null);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.i == null) {
                return;
            }
            if (view2.equals(this.e)) {
                this.i.a(38);
            } else if (view2.equals(this.d)) {
                this.i.a(37);
            } else if (view2.equals(this.c)) {
                this.i.a(false);
            } else if (view2.equals(this.f) || view2.equals(this.b) || view2.equals(this.g) || view2.equals(this.h)) {
                this.i.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup c;
        public a d;
        public KSCornerImageView e;
        public TextView f;
        public KsPriceView g;
        public KsStyledTextButton h;
        public View i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ViewGroup viewGroup) {
            super((byte) 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Byte) newInitContext.callArgs[0]).byteValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = viewGroup;
            c();
        }

        private void a(com.kwad.components.ad.reward.model.a aVar, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, aVar, adTemplate) == null) {
                this.h.setText(aVar.d());
                this.b.setText(aVar.b());
                this.f.setText(aVar.c());
                this.g.a(aVar.e(), aVar.f());
                KSImageLoader.loadImage(this.e, aVar.a(), adTemplate);
            }
        }

        private void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.a = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f091154);
                this.b = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091158);
                this.e = (KSCornerImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091156);
                this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091155);
                this.g = (KsPriceView) this.c.findViewById(R.id.obfuscated_res_0x7f091157);
                this.h = (KsStyledTextButton) this.c.findViewById(R.id.obfuscated_res_0x7f091151);
                this.i = this.c.findViewById(R.id.obfuscated_res_0x7f091152);
                this.h.setOnClickListener(this);
                this.i.setOnClickListener(this);
                this.f.setOnClickListener(this);
                this.g.setOnClickListener(this);
                this.b.setOnClickListener(this);
            }
        }

        @Override // com.kwad.components.ad.reward.i.d
        public final void a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wVar) == null) {
                super.a(wVar);
                a(com.kwad.components.ad.reward.model.a.b(wVar.a()), wVar.a());
            }
        }

        public final void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.d = aVar;
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.d == null) {
                return;
            }
            if (view2.equals(this.i)) {
                this.d.a(false);
            } else if (view2.equals(this.h)) {
                this.d.a(15);
            } else if (view2.equals(this.f) || view2.equals(this.b) || view2.equals(this.g)) {
                this.d.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class f extends com.kwad.components.ad.reward.i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public TextView b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.kwad.components.ad.reward.i.d
        public final ViewGroup a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ViewGroup) invokeV.objValue;
        }

        public void a(AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            }
        }
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
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            if (com.kwad.components.ad.reward.kwai.b.a(i)) {
                return 0;
            }
            if (com.kwad.components.ad.reward.kwai.b.b(i)) {
                return 1;
            }
            return com.kwad.sdk.core.response.a.a.b(adTemplate) ? 2 : -1;
        }
        return invokeL.intValue;
    }

    public static void a(Activity activity, AdTemplate adTemplate, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, activity, adTemplate, bVar) == null) || adTemplate == null || activity == null || activity.isFinishing()) {
            return;
        }
        a = new p();
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

    private void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            this.c = bVar;
        }
    }

    @Override // com.kwad.components.core.h.e
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        InterceptResult invokeLL;
        View inflate;
        com.kwad.components.core.widget.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutInflater, viewGroup)) == null) {
            getDialog().requestWindowFeature(1);
            try {
                String string = getArguments().getString("key_template_json");
                AdTemplate adTemplate = new AdTemplate();
                this.b = adTemplate;
                adTemplate.parseJson(new JSONObject(string));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
            }
            int a2 = a(this.b);
            if (a2 == 0) {
                inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0454, viewGroup, false);
                c cVar = new c((ViewGroup) inflate, this.b);
                cVar.a(new b(this, this.c));
                this.d = cVar;
                fVar = new com.kwad.components.core.widget.f();
            } else if (a2 != 2) {
                inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d045b, viewGroup, false);
                e eVar = new e((ViewGroup) inflate);
                eVar.a(new b(this, this.c));
                this.d = eVar;
                fVar = new com.kwad.components.core.widget.f();
            } else {
                d dVar = new d(layoutInflater, viewGroup);
                dVar.a(new b(this, this.c));
                this.d = dVar;
                fVar = null;
                inflate = dVar.a();
            }
            this.d.b(w.a(this.b));
            com.kwad.components.core.l.j.a(fVar, this.d.a());
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.components.ad.reward.p.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ p a;

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

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 && keyEvent.getAction() == 0 : invokeLIL.booleanValue;
                }
            });
            return inflate;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Window window = getDialog().getWindow();
            if (window == null) {
                return;
            }
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
            f fVar = this.d;
            if (fVar != null) {
                fVar.a(this.b);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            a = null;
            b bVar = this.c;
            if (bVar != null) {
                bVar.d();
            }
        }
    }
}
