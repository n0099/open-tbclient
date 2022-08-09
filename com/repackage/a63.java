package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppScopeDetailActivity;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d03;
import com.repackage.wd3;
import com.repackage.z53;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a63 implements al1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static final int[] m;
    public static final int[] n;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public z03 b;
    public DialogInterface.OnClickListener c;
    public z53 d;
    public JSONObject e;
    public d03.a f;
    public View g;
    public TextView h;
    public View i;
    public TextView j;
    public TextView k;

    /* loaded from: classes5.dex */
    public class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(a63 a63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                mm2.U().c();
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a63 a63Var, Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ z53 c;
        public final /* synthetic */ a63 d;

        public c(a63 a63Var, TextView textView, View view2, z53 z53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, textView, view2, z53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a63Var;
            this.a = textView;
            this.b = view2;
            this.c = z53Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.d.v(!this.a.isEnabled(), this.b, this.a, this.c);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ z53.a b;
        public final /* synthetic */ a63 c;

        public d(a63 a63Var, View view2, z53.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, view2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a63Var;
            this.a = view2;
            this.b = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.C(this.a.getContext(), this.b.c);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ a63 c;

        public e(a63 a63Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a63Var;
            this.a = str;
            this.b = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.C(y03.K().w(), this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        @SuppressLint({"ResourceAsColor"})
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(Color.parseColor(this.a));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ a63 b;

        public f(a63 a63Var, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a63Var;
            this.a = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a63 a63Var = this.b;
                a63Var.B(a63Var.d, this.b.h, this.b.g, this.a, this.b.e, this.b.i);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements wd3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ SwanAppRoundedImageView b;

        public g(a63 a63Var, Context context, SwanAppRoundedImageView swanAppRoundedImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, context, swanAppRoundedImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = swanAppRoundedImageView;
        }

        @Override // com.repackage.wd3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeResource(this.a.getResources(), R.drawable.obfuscated_res_0x7f081137);
                }
                SwanAppRoundedImageView swanAppRoundedImageView = this.b;
                if (swanAppRoundedImageView != null) {
                    swanAppRoundedImageView.setImageBitmap(bitmap);
                    this.b.setBorderColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060a39));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a63 a63Var, Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ z53 c;
        public final /* synthetic */ a63 d;

        public i(a63 a63Var, TextView textView, View view2, z53 z53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, textView, view2, z53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a63Var;
            this.a = textView;
            this.b = view2;
            this.c = z53Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.d.y(!this.a.isEnabled(), this.b, this.a, this.c);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755904877, "Lcom/repackage/a63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755904877, "Lcom/repackage/a63;");
                return;
            }
        }
        l = jh1.a;
        m = new int[]{R.id.obfuscated_res_0x7f090161, R.id.obfuscated_res_0x7f090168, R.id.obfuscated_res_0x7f09016a, R.id.obfuscated_res_0x7f090162};
        n = new int[]{R.id.obfuscated_res_0x7f090164, R.id.obfuscated_res_0x7f090166, R.id.obfuscated_res_0x7f090167, R.id.obfuscated_res_0x7f090165};
    }

    public a63() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void A(Context context, View view2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, view2, jSONObject) == null) || context == null || view2 == null || jSONObject == null) {
            return;
        }
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f09243f);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09244f);
        Pair<String, String> o = o(jSONObject);
        if (o != null) {
            wd3.e((String) o.second, new g(this, context, swanAppRoundedImageView));
            if (textView != null) {
                textView.setText((CharSequence) o.first);
            }
        }
    }

    public final void B(z53 z53Var, TextView textView, View view2, TextView textView2, JSONObject jSONObject, View view3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{z53Var, textView, view2, textView2, jSONObject, view3}) == null) || z53Var == null) {
            return;
        }
        String str = z53Var.l;
        if (str != null) {
            textView2.setText(Html.fromHtml(str));
        }
        textView.setText(z53Var.f);
        ((LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091895)).setVisibility(0);
        if (((!TextUtils.equals(z53Var.b, "snsapi_userinfo") || jSONObject == null) && !TextUtils.equals(z53Var.b, "mobile")) || view3 == null) {
            return;
        }
        view3.findViewById(R.id.obfuscated_res_0x7f0902e4).setVisibility(8);
    }

    public final void C(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) && (context instanceof SwanAppActivity)) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new a(this));
            mm2.U().p();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
        }
    }

    @Override // com.repackage.al1
    public d03.a a(Context context, z03 z03Var, z53 z53Var, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, z03Var, z53Var, jSONObject, onClickListener)) == null) {
            if (context == null || z03Var == null || z53Var == null) {
                return null;
            }
            d03.a aVar = new d03.a(context);
            this.f = aVar;
            this.a = context;
            this.b = z03Var;
            this.d = z53Var;
            this.e = jSONObject;
            this.c = onClickListener;
            aVar.f(true);
            this.f.W(n());
            this.f.n(new hg3());
            this.f.p(R.drawable.obfuscated_res_0x7f080124);
            this.f.k(false);
            this.f.j();
            this.f.t(false);
            return this.f;
        }
        return (d03.a) invokeLLLLL.objValue;
    }

    public final void k() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frameLayout = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0902e3)) == null) {
            return;
        }
        this.g.findViewById(R.id.obfuscated_res_0x7f09157a).setVisibility(8);
        this.g.findViewById(R.id.obfuscated_res_0x7f091579).setVisibility(8);
        this.g.findViewById(R.id.obfuscated_res_0x7f0902e3).setVisibility(0);
        this.i = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d07f2, null);
        this.d.h();
        v(false, this.i, this.k, this.d);
        frameLayout.addView(this.i);
    }

    public final void l() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ((FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09157a)) == null) {
            return;
        }
        this.g.findViewById(R.id.obfuscated_res_0x7f09157a).setVisibility(0);
        this.g.findViewById(R.id.obfuscated_res_0x7f091579).setVisibility(0);
        this.g.findViewById(R.id.obfuscated_res_0x7f0902e3).setVisibility(8);
        this.d.h();
        y(true, this.g.findViewById(R.id.obfuscated_res_0x7f0902eb), this.k, this.d);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091579);
        textView.setVisibility(0);
        z53.a aVar = this.d.n;
        String str = aVar.e;
        JSONArray jSONArray = aVar.f;
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.getString(R.string.obfuscated_res_0x7f0f0114));
        if (!TextUtils.isEmpty(aVar.d)) {
            sb.append(aVar.d);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("keyword");
                String optString2 = optJSONObject.optString("detail_url");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optString.length() <= 17) {
                    sb.append(optString);
                }
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (!TextUtils.isEmpty(aVar.d)) {
            z(spannableString, sb, aVar.d, aVar.c, str);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int i4 = 0;
            while (i4 < jSONArray.length()) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i4);
                String optString3 = optJSONObject2.optString("keyword");
                String optString4 = optJSONObject2.optString("detail_url");
                if (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || optString3.length() > 17) {
                    i2 = i4;
                } else {
                    i2 = i4;
                    z(spannableString, sb, optString3, optString4, str);
                }
                i4 = i2 + 1;
            }
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setLongClickable(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0068, code lost:
        if (r1.equals("snsapi_userinfo") == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (frameLayout = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0902e3)) == null) {
            return;
        }
        this.g.findViewById(R.id.obfuscated_res_0x7f09157a).setVisibility(8);
        this.g.findViewById(R.id.obfuscated_res_0x7f091579).setVisibility(8);
        char c2 = 0;
        this.g.findViewById(R.id.obfuscated_res_0x7f0902e3).setVisibility(0);
        ((TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091579)).setVisibility(8);
        this.i = p(this.a, this.d, this.e);
        String str = this.d.b;
        int hashCode = str.hashCode();
        if (hashCode != -1068855134) {
            if (hashCode == -977063690) {
            }
            c2 = 65535;
        } else {
            if (str.equals("mobile")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            JSONObject jSONObject = this.e;
            if (jSONObject != null) {
                A(this.a, this.i, jSONObject);
            } else {
                x(this.i, this.d);
            }
        } else if (c2 != 1) {
            x(this.i, this.d);
        } else {
            w(this.i, this.d);
        }
        frameLayout.addView(this.i);
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.g = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d07ed, null);
            q();
            r();
            s();
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public Pair<String, String> o(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.DB_TABLE_USERINFO);
            if (optJSONObject == null) {
                return null;
            }
            return new Pair<>(optJSONObject.optString("nickname"), optJSONObject.optString("headimgurl"));
        }
        return (Pair) invokeL.objValue;
    }

    public final View p(Context context, z53 z53Var, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, context, z53Var, jSONObject)) == null) {
            if (context == null || z53Var == null || TextUtils.isEmpty(z53Var.b)) {
                return null;
            }
            String str = z53Var.b;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1068855134) {
                if (hashCode == -977063690 && str.equals("snsapi_userinfo")) {
                    c2 = 0;
                }
            } else if (str.equals("mobile")) {
                c2 = 1;
            }
            int i2 = R.layout.obfuscated_res_0x7f0d07f1;
            if (c2 != 0) {
                if (c2 == 1) {
                    i2 = R.layout.obfuscated_res_0x7f0d07ef;
                }
            } else if (jSONObject != null) {
                i2 = R.layout.obfuscated_res_0x7f0d07f0;
            }
            return View.inflate(context, i2, null);
        }
        return (View) invokeLLL.objValue;
    }

    public void q() {
        List<z53> list;
        Bitmap i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = (TextUtils.isEmpty(this.d.p) || TextUtils.isEmpty(this.d.q)) ? false : true;
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091f6e);
            if (swanAppRoundedImageView != null) {
                if (z) {
                    i2 = te3.j(this.d.q, "SwanAppAuthDialog", false);
                } else {
                    i2 = te3.i(this.b.Y(), "SwanAppAuthDialog", false);
                }
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.a.getResources(), i2));
                swanAppRoundedImageView.setBorderColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f060a39));
            }
            ((TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091f70)).setText(z ? this.d.p : this.b.Z());
            TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091899);
            this.h = textView;
            if (textView != null) {
                if (u(this.d)) {
                    View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091f6d);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    this.h.setText(this.d.r);
                } else {
                    this.h.setText(this.d.f);
                }
            }
            if (u(this.d) && (list = this.d.s) != null && list.size() > 0) {
                for (int i3 = 0; i3 < list.size() && i3 <= 3; i3++) {
                    z53 z53Var = list.get(i3);
                    if (z53Var != null) {
                        this.g.findViewById(n[i3]).setVisibility(0);
                        ((TextView) this.g.findViewById(m[i3])).setText(z53Var.g);
                    }
                }
            }
            this.j = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0902e8);
            this.k = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0902e9);
            this.f.l(this.j, -2, this.c);
            this.f.l(this.k, -1, this.c);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (u(this.d)) {
                l();
            } else if (t(this.d)) {
                k();
            } else {
                m();
            }
        }
    }

    public void s() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || TextUtils.isEmpty(this.d.l) || (textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091894)) == null) {
            return;
        }
        z03 z03Var = this.b;
        if (z03Var != null && z03Var.Y() != null && TextUtils.equals(this.b.Y().T(), "11010020") && TextUtils.equals(this.d.b, "mobile")) {
            B(this.d, this.h, this.g, textView, this.e, this.i);
            textView.setTextColor(-16777216);
            return;
        }
        if (!u(this.d)) {
            xf3 xf3Var = new xf3(this.a, R.drawable.obfuscated_res_0x7f081114);
            SpannableString spannableString = new SpannableString(" # ");
            spannableString.setSpan(xf3Var, 1, 2, 33);
            spannableString.setSpan(new f(this, textView), 0, spannableString.length(), 33);
            this.h.append(spannableString);
        }
        this.h.setHighlightColor(0);
        this.h.setMovementMethod(LinkMovementMethod.getInstance());
        this.h.setLongClickable(false);
    }

    public boolean t(z53 z53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, z53Var)) == null) {
            if (z53Var == null) {
                return false;
            }
            return TextUtils.equals(z53Var.b, "ppcert") || TextUtils.equals(z53Var.b, "mapp_i_face_verify");
        }
        return invokeL.booleanValue;
    }

    public boolean u(z53 z53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, z53Var)) == null) {
            if (z53Var == null) {
                return false;
            }
            return TextUtils.equals(z53Var.b, "scope_multi_authorize");
        }
        return invokeL.booleanValue;
    }

    public final void v(boolean z, View view2, TextView textView, z53 z53Var) {
        z53.a aVar;
        TextView textView2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), view2, textView, z53Var}) == null) || view2 == null || z53Var == null || (aVar = z53Var.n) == null || (textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902ea)) == null || TextUtils.isEmpty(aVar.a)) {
            return;
        }
        if (!aVar.a.startsWith("XXXX   ")) {
            aVar.a = "XXXX   " + aVar.a;
        }
        textView2.setText(aVar.a);
        try {
            textView2.setTextColor(Color.parseColor(aVar.b));
        } catch (RuntimeException e2) {
            if (l) {
                throw e2;
            }
        }
        SpannableString spannableString = new SpannableString(textView2.getText());
        textView.setEnabled(z);
        if (z) {
            drawable = view2.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08118d);
        } else {
            drawable = view2.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08118e);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        spannableString.setSpan(new b(this, drawable), 0, 4, 33);
        spannableString.setSpan(new c(this, textView, view2, z53Var), 0, 7, 33);
        int length = TextUtils.isEmpty(aVar.d) ? 0 : aVar.d.length();
        int indexOf = aVar.a.indexOf(aVar.d);
        int i2 = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.e)), indexOf, i2, 33);
        } catch (RuntimeException e3) {
            if (l) {
                throw e3;
            }
        }
        spannableString.setSpan(new d(this, view2, aVar), indexOf, i2, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
    }

    public final void w(View view2, z53 z53Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, view2, z53Var) == null) || view2 == null || z53Var == null) {
            return;
        }
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092458);
        StringBuilder sb = new StringBuilder();
        for (String str : z53Var.i) {
            sb.append(str);
        }
        if (textView != null) {
            textView.setText(sb.toString());
        }
    }

    public final void x(View view2, z53 z53Var) {
        TextView textView;
        SwanAppConfigData s;
        SwanAppConfigData.f fVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, view2, z53Var) == null) || view2 == null || z53Var == null || (textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091896)) == null) {
            return;
        }
        if (TextUtils.equals(z53Var.b, "mapp_location") && (s = mm2.U().s()) != null && (fVar = s.p) != null && (map = fVar.a.get("scope.userLocation")) != null) {
            String str = map.get("desc");
            if (!TextUtils.isEmpty(str)) {
                z53Var.m = str;
            }
        }
        textView.setText(z53Var.m);
    }

    public final void y(boolean z, View view2, TextView textView, z53 z53Var) {
        TextView textView2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), view2, textView, z53Var}) == null) || view2 == null || z53Var == null || z53Var.n == null || (textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902ea)) == null) {
            return;
        }
        textView2.setText("XXXX   " + this.a.getString(R.string.obfuscated_res_0x7f0f12ce));
        textView.setEnabled(z);
        if (z) {
            drawable = view2.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08118d);
        } else {
            drawable = view2.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08118e);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        h hVar = new h(this, drawable);
        SpannableString spannableString = new SpannableString(textView2.getText());
        spannableString.setSpan(hVar, 0, 4, 33);
        spannableString.setSpan(new i(this, textView, view2, z53Var), 0, 7, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
    }

    public final void z(SpannableString spannableString, StringBuilder sb, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, spannableString, sb, str, str2, str3) == null) {
            int length = TextUtils.isEmpty(str) ? 0 : str.length();
            int indexOf = sb.indexOf(str);
            int i2 = length + indexOf;
            try {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), indexOf, i2, 33);
                spannableString.setSpan(new e(this, str3, str2), indexOf, i2, 33);
            } catch (RuntimeException e2) {
                if (l) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
