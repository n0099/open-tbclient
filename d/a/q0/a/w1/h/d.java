package d.a.q0.a.w1.h;

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
import d.a.q0.a.f;
import d.a.q0.a.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51517b;

    /* renamed from: c  reason: collision with root package name */
    public static d f51518c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f51519a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1161729562, "Ld/a/q0/a/w1/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1161729562, "Ld/a/q0/a/w1/h/d;");
                return;
            }
        }
        f51517b = k.f49133a;
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
            if (f51518c == null) {
                synchronized (d.class) {
                    if (f51518c == null) {
                        f51518c = new d();
                    }
                }
            }
            return f51518c;
        }
        return (d) invokeV.objValue;
    }

    public final View a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EmojiBagLayout emojiBagLayout = new EmojiBagLayout(context);
            emojiBagLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.a.q0.a.d.aiapps_emoji_layout_height)));
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
                if (f51517b) {
                    throw illegalArgumentException;
                }
                return false;
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (f51517b) {
                    Log.d("EmojiPanelManager", "start loading emoji " + str);
                }
                this.f51519a = new WeakReference<>(activity);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    File v = d.a.q0.a.a1.e.v(str2, str3, false, null, null);
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
                    if (this.f51519a.get() != null) {
                        a.g(this.f51519a.get().getApplicationContext()).f(editText);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
