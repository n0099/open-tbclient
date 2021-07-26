package d.a.o0.a.w1.h;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.f;
import d.a.o0.a.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48719b;

    /* renamed from: c  reason: collision with root package name */
    public static d f48720c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f48721a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(903564124, "Ld/a/o0/a/w1/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(903564124, "Ld/a/o0/a/w1/h/d;");
                return;
            }
        }
        f48719b = k.f46335a;
    }

    public d() {
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

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f48720c == null) {
                synchronized (d.class) {
                    if (f48720c == null) {
                        f48720c = new d();
                    }
                }
            }
            return f48720c;
        }
        return (d) invokeV.objValue;
    }

    public final View a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EmojiBagLayout emojiBagLayout = new EmojiBagLayout(context);
            emojiBagLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.a.o0.a.d.aiapps_emoji_layout_height)));
            emojiBagLayout.setEmotionList(b.c().b());
            return emojiBagLayout;
        }
        return (View) invokeL.objValue;
    }

    public boolean c(Activity activity, ViewGroup viewGroup, View view, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, viewGroup, view, str, str2, str3})) == null) {
            IllegalArgumentException illegalArgumentException = !(viewGroup instanceof SPSwitchPanelLinearLayout) ? new IllegalArgumentException("panelLayout must be SPSwitchLinearLayout") : null;
            if (!(view instanceof EditText)) {
                illegalArgumentException = new IllegalArgumentException("focus view must be EditText");
            }
            if (illegalArgumentException != null) {
                if (f48719b) {
                    throw illegalArgumentException;
                }
                return false;
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (f48719b) {
                    Log.d("EmojiPanelManager", "start loading emoji " + str);
                }
                this.f48721a = new WeakReference<>(activity);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    File v = d.a.o0.a.a1.e.v(str2, str3, false, null, null);
                    b.c().f(v.getAbsolutePath() + File.separator + str);
                    ViewPager viewPager = (ViewPager) viewGroup.findViewById(f.emoji_viewpager);
                    ImageView imageView = (ImageView) viewGroup.findViewById(f.emoji_pkg_icon);
                    if (imageView != null) {
                        imageView.setImageBitmap(b.c().d());
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a(activity.getApplicationContext()));
                    viewPager.setAdapter(new NoHorizontalScrollerVPAdapter(arrayList));
                    EditText editText = (EditText) view;
                    if (this.f48721a.get() != null) {
                        a.g(this.f48721a.get().getApplicationContext()).f(editText);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
