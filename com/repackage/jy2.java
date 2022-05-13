package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.publisher.emoji.adapter.NoHorizontalScrollerVPAdapter;
import com.baidu.swan.apps.publisher.emoji.view.EmojiBagLayout;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class jy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static jy2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755572402, "Lcom/repackage/jy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755572402, "Lcom/repackage/jy2;");
                return;
            }
        }
        b = eh1.a;
    }

    public jy2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static jy2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (jy2.class) {
                    if (c == null) {
                        c = new jy2();
                    }
                }
            }
            return c;
        }
        return (jy2) invokeV.objValue;
    }

    public final View a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EmojiBagLayout emojiBagLayout = new EmojiBagLayout(context);
            emojiBagLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07013a)));
            emojiBagLayout.setEmotionList(hy2.c().b());
            return emojiBagLayout;
        }
        return (View) invokeL.objValue;
    }

    public boolean c(Activity activity, ViewGroup viewGroup, View view2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, viewGroup, view2, str, str2, str3})) == null) {
            IllegalArgumentException illegalArgumentException = !(viewGroup instanceof SPSwitchPanelLinearLayout) ? new IllegalArgumentException("panelLayout must be SPSwitchLinearLayout") : null;
            if (!(view2 instanceof EditText)) {
                illegalArgumentException = new IllegalArgumentException("focus view must be EditText");
            }
            if (illegalArgumentException != null) {
                if (b) {
                    throw illegalArgumentException;
                }
                return false;
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (b) {
                    Log.d("EmojiPanelManager", "start loading emoji " + str);
                }
                this.a = new WeakReference<>(activity);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    File v = qj2.v(str2, str3, false, null, null);
                    hy2.c().f(v.getAbsolutePath() + File.separator + str);
                    ViewPager viewPager = (ViewPager) viewGroup.findViewById(R.id.obfuscated_res_0x7f09086c);
                    ImageView imageView = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09086b);
                    if (imageView != null) {
                        imageView.setImageBitmap(hy2.c().d());
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a(activity.getApplicationContext()));
                    viewPager.setAdapter(new NoHorizontalScrollerVPAdapter(arrayList));
                    EditText editText = (EditText) view2;
                    if (this.a.get() != null) {
                        gy2.g(this.a.get().getApplicationContext()).f(editText);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
