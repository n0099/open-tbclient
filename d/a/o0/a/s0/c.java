package d.a.o0.a.s0;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g;
import d.a.o0.a.i;
import d.a.o0.a.v2.n0;
import d.a.o0.a.v2.q0;
import d.a.o0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f47780f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Resources f47781g;

        public a(List list, TextView textView, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, textView, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47779e = list;
            this.f47780f = textView;
            this.f47781g = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47779e.size() > 0) {
                    this.f47780f.setBackground(this.f47781g.getDrawable(d.a.o0.a.e.swan_app_auth_positive_bg_selector));
                } else {
                    this.f47780f.setBackground(this.f47781g.getDrawable(d.a.o0.a.e.swan_app_auth_pos_button_unable));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47782e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f47783f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f47784g;

        public b(f fVar, List list, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47782e = fVar;
            this.f47783f = list;
            this.f47784g = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) && this.f47782e.a(dialogInterface, i2, this.f47783f)) {
                this.f47784g.dismiss();
            }
        }
    }

    /* renamed from: d.a.o0.a.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class View$OnClickListenerC0895c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f47785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f47786f;

        public View$OnClickListenerC0895c(h hVar, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47785e = hVar;
            this.f47786f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47785e.e(-1);
                this.f47786f.onClick(this.f47785e, -1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f47787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f47788f;

        public d(h hVar, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47787e = hVar;
            this.f47788f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47787e.e(-2);
                this.f47788f.onClick(this.f47787e, -2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f47789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f47790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f47791g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Drawable f47792h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f47793i;
        public final /* synthetic */ List j;
        public final /* synthetic */ d.a.o0.a.s0.d k;
        public final /* synthetic */ View.OnClickListener l;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i2, List list, d.a.o0.a.s0.d dVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, drawable, drawable2, Integer.valueOf(i2), list, dVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47790f = textView;
            this.f47791g = drawable;
            this.f47792h = drawable2;
            this.f47793i = i2;
            this.j = list;
            this.k = dVar;
            this.l = onClickListener;
            this.f47789e = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = !this.f47789e;
                this.f47789e = z;
                this.f47790f.setCompoundDrawablesWithIntrinsicBounds(z ? this.f47791g : this.f47792h, (Drawable) null, (Drawable) null, (Drawable) null);
                this.f47790f.setCompoundDrawablePadding(this.f47793i);
                if (this.f47789e) {
                    this.j.add(this.k);
                } else {
                    this.j.remove(this.k);
                }
                this.l.onClick(view);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i2, List<d.a.o0.a.s0.d> list);
    }

    @UiThread
    public static h a(@NonNull Activity activity, @NonNull d.a.o0.a.a2.e eVar, @Nullable String str, @NonNull List<d.a.o0.a.s0.d> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, eVar, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, g.swan_app_subscribe_msg_dialog, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(d.a.o0.a.f.swan_app_icon);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, q0.i(eVar.L(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(d.a.o0.a.c.swan_app_auth_icon_border));
            }
            TextView textView = (TextView) inflate.findViewById(d.a.o0.a.f.auth_negative_button);
            TextView textView2 = (TextView) inflate.findViewById(d.a.o0.a.f.auth_positive_button);
            ((TextView) inflate.findViewById(d.a.o0.a.f.swan_app_name)).setText(eVar.O());
            ((TextView) inflate.findViewById(d.a.o0.a.f.tips)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.a.o0.a.f.template_title_layout);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                for (d.a.o0.a.s0.d dVar : list) {
                    linearLayout.addView(b(activity, dVar, arrayList, new a(arrayList, textView2, resources)));
                }
            }
            h.a aVar = new h.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new d.a.o0.a.w2.h.a());
            aVar.p(d.a.o0.a.e.aiapps_action_sheet_bg);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            h c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new View$OnClickListenerC0895c(c2, bVar));
            textView.setOnClickListener(new d(c2, bVar));
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(n0.t(activity), -2);
                window.setWindowAnimations(i.action_sheet_animation);
            }
            return c2;
        }
        return (h) invokeCommon.objValue;
    }

    public static View b(@NonNull Activity activity, @NonNull d.a.o0.a.s0.d dVar, List<d.a.o0.a.s0.d> list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, dVar, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(d.a.o0.a.d.swan_app_template_title_padding);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(d.a.o0.o.a.b.a.b(activity, d.a.o0.a.c.swan_app_msg_dialog_title));
            textView.setText(dVar.f47795b);
            Drawable drawable = resources.getDrawable(d.a.o0.a.e.aiapps_subscribe_msg_unselected);
            Drawable drawable2 = resources.getDrawable(d.a.o0.a.e.aiapps_subscribe_msg_selected);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dVar, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
