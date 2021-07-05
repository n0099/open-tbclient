package d.a.q0.a.s0;

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
import d.a.q0.a.g;
import d.a.q0.a.i;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import d.a.q0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f50577e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f50578f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Resources f50579g;

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
            this.f50577e = list;
            this.f50578f = textView;
            this.f50579g = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50577e.size() > 0) {
                    this.f50578f.setBackground(this.f50579g.getDrawable(d.a.q0.a.e.swan_app_auth_positive_bg_selector));
                } else {
                    this.f50578f.setBackground(this.f50579g.getDrawable(d.a.q0.a.e.swan_app_auth_pos_button_unable));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f50580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f50581f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f50582g;

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
            this.f50580e = fVar;
            this.f50581f = list;
            this.f50582g = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) && this.f50580e.a(dialogInterface, i2, this.f50581f)) {
                this.f50582g.dismiss();
            }
        }
    }

    /* renamed from: d.a.q0.a.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class View$OnClickListenerC0937c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f50583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f50584f;

        public View$OnClickListenerC0937c(h hVar, DialogInterface.OnClickListener onClickListener) {
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
            this.f50583e = hVar;
            this.f50584f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50583e.e(-1);
                this.f50584f.onClick(this.f50583e, -1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f50585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f50586f;

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
            this.f50585e = hVar;
            this.f50586f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50585e.e(-2);
                this.f50586f.onClick(this.f50585e, -2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f50588f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f50589g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Drawable f50590h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f50591i;
        public final /* synthetic */ List j;
        public final /* synthetic */ d.a.q0.a.s0.d k;
        public final /* synthetic */ View.OnClickListener l;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i2, List list, d.a.q0.a.s0.d dVar, View.OnClickListener onClickListener) {
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
            this.f50588f = textView;
            this.f50589g = drawable;
            this.f50590h = drawable2;
            this.f50591i = i2;
            this.j = list;
            this.k = dVar;
            this.l = onClickListener;
            this.f50587e = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = !this.f50587e;
                this.f50587e = z;
                this.f50588f.setCompoundDrawablesWithIntrinsicBounds(z ? this.f50589g : this.f50590h, (Drawable) null, (Drawable) null, (Drawable) null);
                this.f50588f.setCompoundDrawablePadding(this.f50591i);
                if (this.f50587e) {
                    this.j.add(this.k);
                } else {
                    this.j.remove(this.k);
                }
                this.l.onClick(view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i2, List<d.a.q0.a.s0.d> list);
    }

    @UiThread
    public static h a(@NonNull Activity activity, @NonNull d.a.q0.a.a2.e eVar, @Nullable String str, @NonNull List<d.a.q0.a.s0.d> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, eVar, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, g.swan_app_subscribe_msg_dialog, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(d.a.q0.a.f.swan_app_icon);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, q0.i(eVar.L(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(d.a.q0.a.c.swan_app_auth_icon_border));
            }
            TextView textView = (TextView) inflate.findViewById(d.a.q0.a.f.auth_negative_button);
            TextView textView2 = (TextView) inflate.findViewById(d.a.q0.a.f.auth_positive_button);
            ((TextView) inflate.findViewById(d.a.q0.a.f.swan_app_name)).setText(eVar.O());
            ((TextView) inflate.findViewById(d.a.q0.a.f.tips)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.a.q0.a.f.template_title_layout);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                for (d.a.q0.a.s0.d dVar : list) {
                    linearLayout.addView(b(activity, dVar, arrayList, new a(arrayList, textView2, resources)));
                }
            }
            h.a aVar = new h.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new d.a.q0.a.w2.h.a());
            aVar.p(d.a.q0.a.e.aiapps_action_sheet_bg);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            h c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new View$OnClickListenerC0937c(c2, bVar));
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

    public static View b(@NonNull Activity activity, @NonNull d.a.q0.a.s0.d dVar, List<d.a.q0.a.s0.d> list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, dVar, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(d.a.q0.a.d.swan_app_template_title_padding);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(d.a.q0.o.a.b.a.b(activity, d.a.q0.a.c.swan_app_msg_dialog_title));
            textView.setText(dVar.f50593b);
            Drawable drawable = resources.getDrawable(d.a.q0.a.e.aiapps_subscribe_msg_unselected);
            Drawable drawable2 = resources.getDrawable(d.a.q0.a.e.aiapps_subscribe_msg_selected);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dVar, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
