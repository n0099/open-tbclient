package d.a.l0.a.v0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.g;
import d.a.l0.a.v2.q0;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48937b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public g f48938a;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* renamed from: d.a.l0.a.v0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0931c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f48939a = new c();
    }

    public static c c() {
        return C0931c.f48939a;
    }

    public boolean a(@NonNull WeakReference<Activity> weakReference) {
        e i2;
        if (!q0.G() || weakReference == null || weakReference.get() == null) {
            return false;
        }
        Activity activity = weakReference.get();
        if (TextUtils.equals("0", g()) || (i2 = e.i()) == null || i2.J().c("boolean_var_key_fav_guide_show", Boolean.FALSE).booleanValue()) {
            return false;
        }
        return i(activity) && !TextUtils.isEmpty(f());
    }

    public final int b(@NonNull Context context) {
        PackageInfo t = q0.t(context, context.getPackageName());
        if (t != null) {
            return t.versionCode;
        }
        return -1;
    }

    public final int d(Activity activity) {
        return this.f48938a.getInt("up_first_in", b(activity));
    }

    public final boolean e() {
        return this.f48938a.getBoolean("new_first_in", true);
    }

    public String f() {
        return this.f48938a.getString("url", "");
    }

    public String g() {
        return this.f48938a.getString(SetImageWatermarkTypeReqMsg.SWITCH, "1");
    }

    public boolean h() {
        e i2 = e.i();
        if (i2 == null) {
            return false;
        }
        return i2.J().c("boolean_var_key_fav_guide_show", Boolean.FALSE).booleanValue();
    }

    public final boolean i(@NonNull Activity activity) {
        boolean e2 = e();
        if (f48937b) {
            Log.e("SwanAppGuideDialogManager", "is first in " + e2);
        }
        if (e2) {
            return true;
        }
        int d2 = d(activity);
        int b2 = b(activity);
        if (f48937b) {
            Log.e("SwanAppGuideDialogManager", "version =" + d2 + " curVerCode" + b2);
        }
        return b2 > d2;
    }

    public void j(@NonNull Activity activity, String str, String str2, d.a.l0.a.v0.b bVar, b bVar2) {
        d.a.l0.a.c1.a.e0().h(activity, str, str2, bVar, bVar2);
    }

    public c() {
        g gVar = new g("aiapps_guide_dialog_sp");
        this.f48938a = gVar;
        gVar.edit();
    }
}
