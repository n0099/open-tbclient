package d.a.q0.a.e2.c;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e2.c.f;
import d.a.q0.a.k;
import d.a.q0.a.p.d.r;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.t;
import d.a.q0.a.z1.b.b.h;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g implements r {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static final int[] m;
    public static final int[] n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f47643a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.a2.e f47644b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnClickListener f47645c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.e2.c.f f47646d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f47647e;

    /* renamed from: f  reason: collision with root package name */
    public h.a f47648f;

    /* renamed from: g  reason: collision with root package name */
    public View f47649g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47650h;

    /* renamed from: i  reason: collision with root package name */
    public View f47651i;
    public TextView j;
    public TextView k;

    /* loaded from: classes8.dex */
    public class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i2, intent)) == null) {
                d.a.q0.a.g1.f.V().b();
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f47652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f47653f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.e2.c.f f47654g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f47655h;

        public c(g gVar, TextView textView, View view, d.a.q0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, textView, view, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47655h = gVar;
            this.f47652e = textView;
            this.f47653f = view;
            this.f47654g = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47655h.v(!this.f47652e.isEnabled(), this.f47653f, this.f47652e, this.f47654g);
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

    /* loaded from: classes8.dex */
    public class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47656e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f.a f47657f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f47658g;

        public d(g gVar, View view, f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, view, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47658g = gVar;
            this.f47656e = view;
            this.f47657f = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47658g.C(this.f47656e.getContext(), this.f47657f.f47639c);
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

    /* loaded from: classes8.dex */
    public class e extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47659e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47660f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f47661g;

        public e(g gVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47661g = gVar;
            this.f47659e = str;
            this.f47660f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47661g.C(d.a.q0.a.a2.d.g().x(), this.f47660f);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        @SuppressLint({"ResourceAsColor"})
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(Color.parseColor(this.f47659e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f47662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f47663f;

        public f(g gVar, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47663f = gVar;
            this.f47662e = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g gVar = this.f47663f;
                gVar.B(gVar.f47646d, this.f47663f.f47650h, this.f47663f.f47649g, this.f47662e, this.f47663f.f47647e, this.f47663f.f47651i);
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

    /* renamed from: d.a.q0.a.e2.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0739g implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47664a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppRoundedImageView f47665b;

        public C0739g(g gVar, Context context, SwanAppRoundedImageView swanAppRoundedImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, context, swanAppRoundedImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47664a = context;
            this.f47665b = swanAppRoundedImageView;
        }

        @Override // d.a.q0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    bitmap = BitmapFactory.decodeResource(this.f47664a.getResources(), d.a.q0.a.e.swan_app_user_portrait_pressed);
                }
                SwanAppRoundedImageView swanAppRoundedImageView = this.f47665b;
                if (swanAppRoundedImageView != null) {
                    swanAppRoundedImageView.setImageBitmap(bitmap);
                    this.f47665b.setBorderColor(this.f47664a.getResources().getColor(d.a.q0.a.c.swan_app_auth_icon_border));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(g gVar, Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f47666e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f47667f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.e2.c.f f47668g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f47669h;

        public i(g gVar, TextView textView, View view, d.a.q0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, textView, view, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47669h = gVar;
            this.f47666e = textView;
            this.f47667f = view;
            this.f47668g = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47669h.y(!this.f47666e.isEnabled(), this.f47667f, this.f47666e, this.f47668g);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1899954519, "Ld/a/q0/a/e2/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1899954519, "Ld/a/q0/a/e2/c/g;");
                return;
            }
        }
        l = k.f49133a;
        m = new int[]{d.a.q0.a.f.agreement_first, d.a.q0.a.f.agreement_second, d.a.q0.a.f.agreement_third, d.a.q0.a.f.agreement_forth};
        n = new int[]{d.a.q0.a.f.agreement_layout_first, d.a.q0.a.f.agreement_layout_second, d.a.q0.a.f.agreement_layout_third, d.a.q0.a.f.agreement_layout_forth};
    }

    public g() {
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

    public final void A(Context context, View view, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, view, jSONObject) == null) || context == null || view == null || jSONObject == null) {
            return;
        }
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view.findViewById(d.a.q0.a.f.user_icon);
        TextView textView = (TextView) view.findViewById(d.a.q0.a.f.user_name);
        Pair<String, String> o = o(jSONObject);
        if (o != null) {
            t.e((String) o.second, new C0739g(this, context, swanAppRoundedImageView));
            if (textView != null) {
                textView.setText((CharSequence) o.first);
            }
        }
    }

    public final void B(d.a.q0.a.e2.c.f fVar, TextView textView, View view, TextView textView2, JSONObject jSONObject, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fVar, textView, view, textView2, jSONObject, view2}) == null) || fVar == null) {
            return;
        }
        String str = fVar.l;
        if (str != null) {
            textView2.setText(Html.fromHtml(str));
        }
        textView.setText(fVar.f47633f);
        ((LinearLayout) view.findViewById(d.a.q0.a.f.permission_detail_layout)).setVisibility(0);
        if (((!TextUtils.equals(fVar.f47629b, "snsapi_userinfo") || jSONObject == null) && !TextUtils.equals(fVar.f47629b, "mobile")) || view2 == null) {
            return;
        }
        view2.findViewById(d.a.q0.a.f.auth_divider1).setVisibility(8);
    }

    public final void C(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) && (context instanceof SwanAppActivity)) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new a(this));
            d.a.q0.a.g1.f.V().p();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(d.a.q0.a.a.aiapps_slide_in_from_right, d.a.q0.a.a.aiapps_hold);
        }
    }

    @Override // d.a.q0.a.p.d.r
    public h.a a(Context context, d.a.q0.a.a2.e eVar, d.a.q0.a.e2.c.f fVar, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, eVar, fVar, jSONObject, onClickListener)) == null) {
            if (context == null || eVar == null || fVar == null) {
                return null;
            }
            h.a aVar = new h.a(context);
            this.f47648f = aVar;
            this.f47643a = context;
            this.f47644b = eVar;
            this.f47646d = fVar;
            this.f47647e = jSONObject;
            this.f47645c = onClickListener;
            aVar.f(true);
            this.f47648f.W(n());
            this.f47648f.n(new d.a.q0.a.w2.h.a());
            this.f47648f.p(d.a.q0.a.e.aiapps_action_sheet_bg);
            this.f47648f.k(false);
            this.f47648f.j();
            this.f47648f.t(false);
            return this.f47648f;
        }
        return (h.a) invokeLLLLL.objValue;
    }

    public final void k() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (frameLayout = (FrameLayout) this.f47649g.findViewById(d.a.q0.a.f.auth_custom_layout)) == null) {
            return;
        }
        this.f47649g.findViewById(d.a.q0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f47649g.findViewById(d.a.q0.a.f.multi_auth_agreement_layout).setVisibility(8);
        this.f47649g.findViewById(d.a.q0.a.f.auth_custom_layout).setVisibility(0);
        this.f47651i = View.inflate(this.f47643a, d.a.q0.a.g.swan_app_auth_scope_detail, null);
        this.f47646d.f();
        v(false, this.f47651i, this.k, this.f47646d);
        frameLayout.addView(this.f47651i);
    }

    public final void l() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ((FrameLayout) this.f47649g.findViewById(d.a.q0.a.f.multi_auth_custom_layout)) == null) {
            return;
        }
        this.f47649g.findViewById(d.a.q0.a.f.multi_auth_custom_layout).setVisibility(0);
        this.f47649g.findViewById(d.a.q0.a.f.multi_auth_agreement_layout).setVisibility(0);
        this.f47649g.findViewById(d.a.q0.a.f.auth_custom_layout).setVisibility(8);
        this.f47646d.f();
        y(true, this.f47649g.findViewById(d.a.q0.a.f.auth_scope_detail_layout), this.k, this.f47646d);
        TextView textView = (TextView) this.f47649g.findViewById(d.a.q0.a.f.multi_auth_agreement_layout);
        textView.setVisibility(0);
        f.a aVar = this.f47646d.n;
        String str = aVar.f47641e;
        JSONArray jSONArray = aVar.f47642f;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47643a.getString(d.a.q0.a.h.aiapps_check_action_text));
        if (!TextUtils.isEmpty(aVar.f47640d)) {
            sb.append(aVar.f47640d);
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
        if (!TextUtils.isEmpty(aVar.f47640d)) {
            z(spannableString, sb, aVar.f47640d, aVar.f47639c, str);
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0069, code lost:
        if (r1.equals("snsapi_userinfo") == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (frameLayout = (FrameLayout) this.f47649g.findViewById(d.a.q0.a.f.auth_custom_layout)) == null) {
            return;
        }
        this.f47649g.findViewById(d.a.q0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f47649g.findViewById(d.a.q0.a.f.multi_auth_agreement_layout).setVisibility(8);
        char c2 = 0;
        this.f47649g.findViewById(d.a.q0.a.f.auth_custom_layout).setVisibility(0);
        ((TextView) this.f47649g.findViewById(d.a.q0.a.f.multi_auth_agreement_layout)).setVisibility(8);
        this.f47651i = p(this.f47643a, this.f47646d, this.f47647e);
        String str = this.f47646d.f47629b;
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
            JSONObject jSONObject = this.f47647e;
            if (jSONObject != null) {
                A(this.f47643a, this.f47651i, jSONObject);
            } else {
                x(this.f47651i, this.f47646d);
            }
        } else if (c2 != 1) {
            x(this.f47651i, this.f47646d);
        } else {
            w(this.f47651i, this.f47646d);
        }
        frameLayout.addView(this.f47651i);
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f47649g = View.inflate(this.f47643a, d.a.q0.a.g.swan_app_auth_dialog_content_common, null);
            q();
            r();
            s();
            return this.f47649g;
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

    public final View p(Context context, d.a.q0.a.e2.c.f fVar, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, context, fVar, jSONObject)) == null) {
            if (context == null || fVar == null || TextUtils.isEmpty(fVar.f47629b)) {
                return null;
            }
            String str = fVar.f47629b;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1068855134) {
                if (hashCode == -977063690 && str.equals("snsapi_userinfo")) {
                    c2 = 0;
                }
            } else if (str.equals("mobile")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    i2 = d.a.q0.a.g.swan_app_auth_level2_custom;
                } else {
                    i2 = d.a.q0.a.g.swan_app_auth_level1_mobile_custom;
                }
            } else if (jSONObject != null) {
                i2 = d.a.q0.a.g.swan_app_auth_level1_userinfo_custom;
            } else {
                i2 = d.a.q0.a.g.swan_app_auth_level2_custom;
            }
            return View.inflate(context, i2, null);
        }
        return (View) invokeLLL.objValue;
    }

    public void q() {
        List<d.a.q0.a.e2.c.f> list;
        Bitmap i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = (TextUtils.isEmpty(this.f47646d.p) || TextUtils.isEmpty(this.f47646d.q)) ? false : true;
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.f47649g.findViewById(d.a.q0.a.f.swan_app_icon);
            if (swanAppRoundedImageView != null) {
                if (z) {
                    i2 = q0.j(this.f47646d.q, "SwanAppAuthDialog", false);
                } else {
                    i2 = q0.i(this.f47644b.N(), "SwanAppAuthDialog", false);
                }
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.f47643a.getResources(), i2));
                swanAppRoundedImageView.setBorderColor(this.f47643a.getResources().getColor(d.a.q0.a.c.swan_app_auth_icon_border));
            }
            ((TextView) this.f47649g.findViewById(d.a.q0.a.f.swan_app_name)).setText(z ? this.f47646d.p : this.f47644b.O());
            TextView textView = (TextView) this.f47649g.findViewById(d.a.q0.a.f.permission_name);
            this.f47650h = textView;
            if (textView != null) {
                if (u(this.f47646d)) {
                    View findViewById = this.f47649g.findViewById(d.a.q0.a.f.swan_app_action_text);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    this.f47650h.setText(this.f47646d.r);
                } else {
                    this.f47650h.setText(this.f47646d.f47633f);
                }
            }
            if (u(this.f47646d) && (list = this.f47646d.s) != null && list.size() > 0) {
                for (int i3 = 0; i3 < list.size() && i3 <= 3; i3++) {
                    d.a.q0.a.e2.c.f fVar = list.get(i3);
                    if (fVar != null) {
                        this.f47649g.findViewById(n[i3]).setVisibility(0);
                        ((TextView) this.f47649g.findViewById(m[i3])).setText(fVar.f47634g);
                    }
                }
            }
            this.j = (TextView) this.f47649g.findViewById(d.a.q0.a.f.auth_negative_button);
            this.k = (TextView) this.f47649g.findViewById(d.a.q0.a.f.auth_positive_button);
            this.f47648f.l(this.j, -2, this.f47645c);
            this.f47648f.l(this.k, -1, this.f47645c);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (u(this.f47646d)) {
                l();
            } else if (t(this.f47646d)) {
                k();
            } else {
                m();
            }
        }
    }

    public void s() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || TextUtils.isEmpty(this.f47646d.l) || (textView = (TextView) this.f47649g.findViewById(d.a.q0.a.f.permission_detail)) == null) {
            return;
        }
        d.a.q0.a.a2.e eVar = this.f47644b;
        if (eVar != null && eVar.N() != null && TextUtils.equals(this.f47644b.N().T(), "11010020") && TextUtils.equals(this.f47646d.f47629b, "mobile")) {
            B(this.f47646d, this.f47650h, this.f47649g, textView, this.f47647e, this.f47651i);
            textView.setTextColor(-16777216);
            return;
        }
        if (!u(this.f47646d)) {
            d.a.q0.a.w2.b bVar = new d.a.q0.a.w2.b(this.f47643a, d.a.q0.a.e.swan_app_auth_question_mark_pressed);
            SpannableString spannableString = new SpannableString(" # ");
            spannableString.setSpan(bVar, 1, 2, 33);
            spannableString.setSpan(new f(this, textView), 0, spannableString.length(), 33);
            this.f47650h.append(spannableString);
        }
        this.f47650h.setHighlightColor(0);
        this.f47650h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f47650h.setLongClickable(false);
    }

    public boolean t(d.a.q0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            return TextUtils.equals(fVar.f47629b, "ppcert") || TextUtils.equals(fVar.f47629b, "mapp_i_face_verify");
        }
        return invokeL.booleanValue;
    }

    public boolean u(d.a.q0.a.e2.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            return TextUtils.equals(fVar.f47629b, "scope_multi_authorize");
        }
        return invokeL.booleanValue;
    }

    public final void v(boolean z, View view, TextView textView, d.a.q0.a.e2.c.f fVar) {
        f.a aVar;
        TextView textView2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), view, textView, fVar}) == null) || view == null || fVar == null || (aVar = fVar.n) == null || (textView2 = (TextView) view.findViewById(d.a.q0.a.f.auth_scope_detail)) == null || TextUtils.isEmpty(aVar.f47637a)) {
            return;
        }
        if (!aVar.f47637a.startsWith("XXXX   ")) {
            aVar.f47637a = "XXXX   " + aVar.f47637a;
        }
        textView2.setText(aVar.f47637a);
        try {
            textView2.setTextColor(Color.parseColor(aVar.f47638b));
        } catch (RuntimeException e2) {
            if (l) {
                throw e2;
            }
        }
        SpannableString spannableString = new SpannableString(textView2.getText());
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(d.a.q0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(d.a.q0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        spannableString.setSpan(new b(this, drawable), 0, 4, 33);
        spannableString.setSpan(new c(this, textView, view, fVar), 0, 7, 33);
        int length = TextUtils.isEmpty(aVar.f47640d) ? 0 : aVar.f47640d.length();
        int indexOf = aVar.f47637a.indexOf(aVar.f47640d);
        int i2 = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.f47641e)), indexOf, i2, 33);
        } catch (RuntimeException e3) {
            if (l) {
                throw e3;
            }
        }
        spannableString.setSpan(new d(this, view, aVar), indexOf, i2, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
    }

    public final void w(View view, d.a.q0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, view, fVar) == null) || view == null || fVar == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.a.q0.a.f.user_phone_number);
        StringBuilder sb = new StringBuilder();
        for (String str : fVar.f47636i) {
            sb.append(str);
        }
        if (textView != null) {
            textView.setText(sb.toString());
        }
    }

    public final void x(View view, d.a.q0.a.e2.c.f fVar) {
        TextView textView;
        SwanAppConfigData s;
        SwanAppConfigData.e eVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, view, fVar) == null) || view == null || fVar == null || (textView = (TextView) view.findViewById(d.a.q0.a.f.permission_function)) == null) {
            return;
        }
        if (TextUtils.equals(fVar.f47629b, "mapp_location") && (s = d.a.q0.a.g1.f.V().s()) != null && (eVar = s.o) != null && (map = eVar.f11473a.get("scope.userLocation")) != null) {
            String str = map.get("desc");
            if (!TextUtils.isEmpty(str)) {
                fVar.m = str;
            }
        }
        textView.setText(fVar.m);
    }

    public final void y(boolean z, View view, TextView textView, d.a.q0.a.e2.c.f fVar) {
        TextView textView2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), view, textView, fVar}) == null) || view == null || fVar == null || fVar.n == null || (textView2 = (TextView) view.findViewById(d.a.q0.a.f.auth_scope_detail)) == null) {
            return;
        }
        textView2.setText("XXXX   " + this.f47643a.getString(d.a.q0.a.h.swanapp_multi_auth_agreement_desc));
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(d.a.q0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(d.a.q0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        h hVar = new h(this, drawable);
        SpannableString spannableString = new SpannableString(textView2.getText());
        spannableString.setSpan(hVar, 0, 4, 33);
        spannableString.setSpan(new i(this, textView, view, fVar), 0, 7, 33);
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
