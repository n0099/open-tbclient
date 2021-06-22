package d.a.m0.a.w1.h;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.swan.apps.publisher.emoji.adapter.NoHorizontalScrollerVPAdapter;
import com.baidu.swan.apps.publisher.emoji.view.EmojiBagLayout;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import d.a.m0.a.f;
import d.a.m0.a.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49371b = k.f46983a;

    /* renamed from: c  reason: collision with root package name */
    public static d f49372c;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f49373a;

    public static d b() {
        if (f49372c == null) {
            synchronized (d.class) {
                if (f49372c == null) {
                    f49372c = new d();
                }
            }
        }
        return f49372c;
    }

    public final View a(Context context) {
        EmojiBagLayout emojiBagLayout = new EmojiBagLayout(context);
        emojiBagLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_emoji_layout_height)));
        emojiBagLayout.setEmotionList(b.c().b());
        return emojiBagLayout;
    }

    public boolean c(Activity activity, ViewGroup viewGroup, View view, String str, String str2, String str3) {
        IllegalArgumentException illegalArgumentException = !(viewGroup instanceof SPSwitchPanelLinearLayout) ? new IllegalArgumentException("panelLayout must be SPSwitchLinearLayout") : null;
        if (!(view instanceof EditText)) {
            illegalArgumentException = new IllegalArgumentException("focus view must be EditText");
        }
        if (illegalArgumentException != null) {
            if (f49371b) {
                throw illegalArgumentException;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            if (f49371b) {
                Log.d("EmojiPanelManager", "start loading emoji " + str);
            }
            this.f49373a = new WeakReference<>(activity);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                File v = d.a.m0.a.a1.e.v(str2, str3, false, null, null);
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
                if (this.f49373a.get() != null) {
                    a.g(this.f49373a.get().getApplicationContext()).f(editText);
                    return true;
                }
            }
            return false;
        }
    }
}
