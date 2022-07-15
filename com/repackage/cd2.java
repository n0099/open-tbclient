package com.repackage;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lz2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class cd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ Resources c;

        public a(List list, TextView textView, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, textView, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = textView;
            this.c = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.size() > 0) {
                    this.b.setBackground(this.c.getDrawable(R.drawable.obfuscated_res_0x7f0810a9));
                } else {
                    this.b.setBackground(this.c.getDrawable(R.drawable.obfuscated_res_0x7f0810a8));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ List b;
        public final /* synthetic */ lz2 c;

        public b(f fVar, List list, lz2 lz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, lz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.b = list;
            this.c = lz2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && this.a.a(dialogInterface, i, this.b)) {
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lz2 a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public c(lz2 lz2Var, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz2Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lz2Var;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e(-1);
                this.b.onClick(this.a, -1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lz2 a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public d(lz2 lz2Var, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz2Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lz2Var;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e(-2);
                this.b.onClick(this.a, -2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ Drawable c;
        public final /* synthetic */ Drawable d;
        public final /* synthetic */ int e;
        public final /* synthetic */ List f;
        public final /* synthetic */ dd2 g;
        public final /* synthetic */ View.OnClickListener h;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i, List list, dd2 dd2Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, drawable, drawable2, Integer.valueOf(i), list, dd2Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = textView;
            this.c = drawable;
            this.d = drawable2;
            this.e = i;
            this.f = list;
            this.g = dd2Var;
            this.h = onClickListener;
            this.a = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !this.a;
                this.a = z;
                this.b.setCompoundDrawablesWithIntrinsicBounds(z ? this.c : this.d, (Drawable) null, (Drawable) null, (Drawable) null);
                this.b.setCompoundDrawablePadding(this.e);
                if (this.a) {
                    this.f.add(this.g);
                } else {
                    this.f.remove(this.g);
                }
                this.h.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i, List<dd2> list);
    }

    @UiThread
    public static lz2 a(@NonNull Activity activity, @NonNull h03 h03Var, @Nullable String str, @NonNull List<dd2> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, h03Var, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d07ce, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e74);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, be3.i(h03Var.W(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(R.color.obfuscated_res_0x7f060a2d));
            }
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902d5);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902d6);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e76)).setText(h03Var.Z());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920b7)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f9b);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                for (dd2 dd2Var : list) {
                    linearLayout.addView(b(activity, dd2Var, arrayList, new a(arrayList, textView2, resources)));
                }
            }
            lz2.a aVar = new lz2.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new pf3());
            aVar.p(R.drawable.obfuscated_res_0x7f080124);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            lz2 c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new c(c2, bVar));
            textView.setOnClickListener(new d(c2, bVar));
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(yd3.s(activity), -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f100394);
            }
            return c2;
        }
        return (lz2) invokeCommon.objValue;
    }

    public static View b(@NonNull Activity activity, @NonNull dd2 dd2Var, List<dd2> list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, dd2Var, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070670);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(ie4.b(activity, R.color.obfuscated_res_0x7f060a46));
            textView.setText(dd2Var.b);
            Drawable drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c1);
            Drawable drawable2 = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c0);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dd2Var, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
