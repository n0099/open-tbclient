package com.kwad.sdk.emotion.widget;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f37214a;

    /* renamed from: b  reason: collision with root package name */
    public static int f37215b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.emotion.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0446a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TextView f37216a;

        /* renamed from: b  reason: collision with root package name */
        public final int f37217b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37218c;

        public C0446a(@NonNull TextView textView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37216a = textView;
            this.f37217b = i2;
            this.f37218c = i3;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37216a : (View) invokeV.objValue;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public CharSequence b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37216a.getText() : (CharSequence) invokeV.objValue;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) this.f37216a.getTextSize() : invokeV.intValue;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37217b : invokeV.intValue;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37218c : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @NonNull
        View a();

        @NonNull
        CharSequence b();

        int c();

        int d();

        int e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(353159542, "Lcom/kwad/sdk/emotion/widget/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(353159542, "Lcom/kwad/sdk/emotion/widget/a;");
                return;
            }
        }
        f37214a = Pattern.compile("(\\[[^]]*])");
        f37215b = R.drawable.ksad_emotion_loading;
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Paint paint = new Paint();
            paint.setTextSize(i2);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            return (int) Math.ceil(fontMetrics.bottom - fontMetrics.top);
        }
        return invokeI.intValue;
    }

    public static synchronized CharSequence a(TextView textView, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        CharSequence a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{textView, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            synchronized (a.class) {
                a2 = a(new C0446a(textView, i2, i3), z);
            }
            return a2;
        }
        return (CharSequence) invokeCommon.objValue;
    }

    public static synchronized CharSequence a(@NonNull b bVar, boolean z) {
        InterceptResult invokeLZ;
        int a2;
        Bitmap a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, bVar, z)) == null) {
            synchronized (a.class) {
                if (bVar != null) {
                    if (bVar.a() != null) {
                        CharSequence b2 = bVar.b();
                        int d2 = bVar.d();
                        int e2 = bVar.e();
                        if (b2 != null && b2.length() > 0 && d2 >= 0 && e2 <= b2.length()) {
                            SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(b2);
                            Matcher a4 = a(b2.subSequence(d2, e2 + d2));
                            int i2 = 0;
                            while (a4.find()) {
                                String group = a4.group();
                                if (com.kwad.sdk.emotion.a.c.a().c(group)) {
                                    i2++;
                                    if (i2 >= 300) {
                                        break;
                                    }
                                    int start = a4.start() + d2;
                                    int end = a4.end() + d2;
                                    com.kwad.sdk.emotion.widget.b bVar2 = new com.kwad.sdk.emotion.widget.b();
                                    if (z) {
                                        a2 = bVar.c();
                                        a3 = com.kwad.sdk.emotion.a.c.a().b(group);
                                    } else {
                                        a2 = a(bVar.c());
                                        a3 = com.kwad.sdk.emotion.a.c.a().a(bVar.a().getContext(), group, f37215b);
                                    }
                                    bVar2.setBounds(0, 0, a2, a2);
                                    bVar2.a(a3);
                                    valueOf.setSpan(new c(bVar2, group, bVar.a()), start, end, 17);
                                }
                            }
                            return valueOf;
                        }
                        return b2;
                    }
                }
                Log.w("EmojiDisplay", "filterEmoji on NULL!");
                return "";
            }
        }
        return (CharSequence) invokeLZ.objValue;
    }

    public static Matcher a(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, charSequence)) == null) ? f37214a.matcher(charSequence) : (Matcher) invokeL.objValue;
    }
}
