package d.a.h0.a.q0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.h0.a.a2.g.g;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43571b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public g f43572a;

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* renamed from: d.a.h0.a.q0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0731c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f43573a = new c();
    }

    public static c c() {
        return C0731c.f43573a;
    }

    public boolean a(@NonNull WeakReference<Activity> weakReference) {
        e h2;
        if (!k0.D() || weakReference == null || weakReference.get() == null) {
            return false;
        }
        Activity activity = weakReference.get();
        if (TextUtils.equals("0", g()) || (h2 = e.h()) == null || h2.H().c("boolean_var_key_fav_guide_show", Boolean.FALSE).booleanValue()) {
            return false;
        }
        return i(activity) && !TextUtils.isEmpty(f());
    }

    public final int b(@NonNull Context context) {
        PackageInfo s = k0.s(context, context.getPackageName());
        if (s != null) {
            return s.versionCode;
        }
        return -1;
    }

    public final int d(Activity activity) {
        return this.f43572a.getInt("up_first_in", b(activity));
    }

    public final boolean e() {
        return this.f43572a.getBoolean("new_first_in", true);
    }

    public String f() {
        return this.f43572a.getString("url", "");
    }

    public String g() {
        return this.f43572a.getString(SetImageWatermarkTypeReqMsg.SWITCH, "1");
    }

    public boolean h() {
        e h2 = e.h();
        if (h2 == null) {
            return false;
        }
        return h2.H().c("boolean_var_key_fav_guide_show", Boolean.FALSE).booleanValue();
    }

    public final boolean i(@NonNull Activity activity) {
        boolean e2 = e();
        if (f43571b) {
            Log.e("SwanAppGuideDialogManager", "is first in " + e2);
        }
        if (e2) {
            return true;
        }
        int d2 = d(activity);
        int b2 = b(activity);
        if (f43571b) {
            Log.e("SwanAppGuideDialogManager", "version =" + d2 + " curVerCode" + b2);
        }
        return b2 > d2;
    }

    public void j(@NonNull Activity activity, String str, String str2, b bVar) {
        d.a.h0.a.w0.a.T().b(activity, str, str2, bVar);
    }

    public c() {
        g gVar = new g("aiapps_guide_dialog_sp");
        this.f43572a = gVar;
        gVar.edit();
    }
}
