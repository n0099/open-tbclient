package d.b.i0.p1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.live.nps.LiveNpsLoadingCallback;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.view.NpsPluginLoadingDialogActivity;
import d.b.b.e.p.l;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<NpsPluginLoadingDialogActivity> f58782a;

    /* renamed from: b  reason: collision with root package name */
    public int f58783b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58784c;

    /* renamed from: d.b.i0.p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1448a implements LiveNpsLoadingCallback {
        public C1448a() {
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingEnd(int i) {
            a.this.f58784c = false;
            a.this.e();
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingProgress(long j, long j2) {
            BdLog.d("[onDownloadUpdate] package:, current:" + j + ",total:" + j2);
            a.this.f58783b = (int) (j2 <= 0 ? 0.0f : (((float) j) * 100.0f) / ((float) j2));
            a aVar = a.this;
            aVar.B(aVar.g());
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingStart() {
            a.this.f58784c = true;
            a.this.l(TbadkCoreApplication.getInst());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58786a = new a(null);
    }

    public /* synthetic */ a(C1448a c1448a) {
        this();
    }

    public static a h() {
        return b.f58786a;
    }

    public boolean A() {
        return Build.VERSION.SDK_INT < 21;
    }

    public void B(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        if (npsPluginLoadingDialogActivity != null) {
            npsPluginLoadingDialogActivity.setRoundProgress(this.f58783b);
        }
    }

    public final void e() {
        NpsPluginLoadingDialogActivity g2 = g();
        if (g2 != null) {
            g2.finish();
            this.f58782a = null;
        }
    }

    public void f(Context context, String str, Map<String, Object> map) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().dispatchHostEvent(context, str, map);
        }
    }

    public final NpsPluginLoadingDialogActivity g() {
        WeakReference<NpsPluginLoadingDialogActivity> weakReference = this.f58782a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean i() {
        return this.f58784c;
    }

    public void j() {
        this.f58782a = null;
        LiveNPSPluginManager.getInstance().cancelLoading();
    }

    public void k(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        this.f58782a = new WeakReference<>(npsPluginLoadingDialogActivity);
        B(npsPluginLoadingDialogActivity);
    }

    public void l(Context context) {
        new WeakReference(context);
        if (g() != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent(context, NpsPluginLoadingDialogActivity.class);
        intent.putExtra("dialogId", currentTimeMillis);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void m(Context context) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startAdminListActivity(context);
        }
    }

    public void n(Context context, String str, int i) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startFansListActivity(context, str, i);
        }
    }

    public void o(Context context) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startForbiddenListActivity(context);
        }
    }

    public void p(Context context, String str, String str2) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startGuardianListActivity(context, str, str2);
        }
    }

    public void q(Context context, long j, int i) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startLiveExpActivity(context, j, i);
        }
    }

    public void r(Context context, String str, String str2, String str3, Uri uri) {
        if (A()) {
            return;
        }
        LiveNPSPluginManager.getInstance().startLiveMediaActivity(context, str, str2, str3, uri);
    }

    public void s(Context context, String str) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startLiveShowActivity(context, str);
        }
    }

    public void t(Context context, String str, String str2, Map<String, Object> map) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startYuYinActivity(context, str, str2, map);
        }
    }

    public void u(@NonNull Context context) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startPatronageActivity(context);
        }
    }

    public void v(@NonNull Context context, String str) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startPatronsActivity(context, str);
        }
    }

    public void w(@NonNull Context context, @NonNull String str) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startPayActivity(context, str);
        }
    }

    public void x(Context context, String str, String str2) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startRealAuthActivity(context, str, str2);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x002e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(Context context, String str) {
        JSONObject jSONObject;
        JSONException e2;
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
            return;
        }
        Object obj = null;
        try {
            try {
                if (TextUtils.isEmpty(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("show_ar_loading", 1);
                    jSONObject = jSONObject2;
                } else {
                    JSONObject jSONObject3 = new JSONObject(str);
                    obj = jSONObject3.opt("show_ar_loading");
                    jSONObject = jSONObject3;
                    if (obj == null) {
                        jSONObject3.put("show_ar_loading", 1);
                        jSONObject = jSONObject3;
                    }
                }
            } catch (JSONException e3) {
                e2 = e3;
                e2.printStackTrace();
                LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.getInstance();
                if (jSONObject != 0) {
                }
                liveNPSPluginManager.startShowMasterActivity(context, str);
            }
        } catch (JSONException e4) {
            jSONObject = obj;
            e2 = e4;
        }
        LiveNPSPluginManager liveNPSPluginManager2 = LiveNPSPluginManager.getInstance();
        if (jSONObject != 0) {
            str = jSONObject.toString();
        }
        liveNPSPluginManager2.startShowMasterActivity(context, str);
    }

    public void z(Context context, String str) {
        if (A()) {
            l.L(context, "安卓系统版本不支持)");
        } else {
            LiveNPSPluginManager.getInstance().startYuYinCreateLiveRoomActivity(context, str);
        }
    }

    public a() {
        this.f58783b = 0;
        this.f58784c = false;
        LiveNPSPluginManager.getInstance().setLoadingCallback(new C1448a());
        d.b.i0.l1.h.a.c(TbadkCoreApplication.getInst());
    }
}
