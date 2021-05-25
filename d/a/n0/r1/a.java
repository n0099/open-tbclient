package d.a.n0.r1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.PathUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.searchbox.live.impl.IMasterSwitchCallback;
import com.baidu.searchbox.live.impl.LiveNpsGetSwitchManager;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.live.nps.LiveNpsLoadingCallback;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.view.NpsPluginLoadingDialogActivity;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.d.f;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<NpsPluginLoadingDialogActivity> f59873a;

    /* renamed from: b  reason: collision with root package name */
    public int f59874b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59875c;

    /* renamed from: d.a.n0.r1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1561a implements LiveNpsLoadingCallback {
        public C1561a() {
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingEnd(int i2) {
            a.this.f59875c = false;
            a.this.f();
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingProgress(long j, long j2) {
            BdLog.d("[onDownloadUpdate] package:, current:" + j + ",total:" + j2);
            a.this.f59874b = (int) (j2 <= 0 ? 0.0f : (((float) j) * 100.0f) / ((float) j2));
            a aVar = a.this;
            aVar.I(aVar.i());
        }

        @Override // com.baidu.searchbox.live.nps.LiveNpsLoadingCallback
        public void onLoadingStart() {
            a.this.f59875c = true;
            a.this.p(TbadkCoreApplication.getInst());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements IMasterSwitchCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f59877a;

        public b(a aVar, f fVar) {
            this.f59877a = fVar;
        }

        @Override // com.baidu.searchbox.live.impl.IMasterSwitchCallback
        public void switchCallback(String str) {
            if (!k.isEmpty(str)) {
                TbSingleton.getInstance().setYyCloudSwitch(str);
            }
            if (this.f59877a != null) {
                if (FastLoginFeature.SSOLoginType.YY.equals(str)) {
                    this.f59877a.onSwitchGet(true);
                } else if (PathUtils.DIRCTORY_BAIDU.equals(str)) {
                    this.f59877a.onSwitchGet(false);
                } else {
                    this.f59877a.onFail();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ILiveFileSizeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long[] f59878a;

        public c(a aVar, long[] jArr) {
            this.f59878a = jArr;
        }

        @Override // com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback
        public void getFileSize(long j) {
            this.f59878a[0] = j;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final a f59879a = new a(null);
    }

    public /* synthetic */ a(C1561a c1561a) {
        this();
    }

    public static a j() {
        return d.f59879a;
    }

    public void A(@NonNull Context context, @NonNull String str) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startPayActivity(context, str);
        }
    }

    public void B(Context context, String str, String str2) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
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
    public void C(Context context, String str) {
        JSONObject jSONObject;
        JSONException e2;
        if (H()) {
            l.M(context, "安卓系统版本不支持");
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
                liveNPSPluginManager.startMasterActivity(context, str, "");
            }
        } catch (JSONException e4) {
            jSONObject = obj;
            e2 = e4;
        }
        LiveNPSPluginManager liveNPSPluginManager2 = LiveNPSPluginManager.getInstance();
        if (jSONObject != 0) {
            str = jSONObject.toString();
        }
        liveNPSPluginManager2.startMasterActivity(context, str, "");
    }

    public void D(Context context, String str) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startYYCustomerServiceActivity(context, str);
        }
    }

    public void E(Context context, String str) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startYYFeedbackActivity(context, str);
        }
    }

    public void F(Context context, String str) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startYYLiveActivity(context, str);
        }
    }

    public void G(Context context, String str) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startYuYinCreateLiveRoomActivity(context, str);
        }
    }

    public boolean H() {
        return Build.VERSION.SDK_INT < 21;
    }

    public void I(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        if (npsPluginLoadingDialogActivity != null) {
            npsPluginLoadingDialogActivity.setRoundProgress(this.f59874b);
        }
    }

    public void e(Context context) {
        LiveNPSPluginManager.getInstance().clearResourceFile(context);
    }

    public final void f() {
        NpsPluginLoadingDialogActivity i2 = i();
        if (i2 != null) {
            i2.finish();
            this.f59873a = null;
        }
    }

    public void g(Context context, String str, Map<String, Object> map) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().dispatchHostEvent(context, str, map);
        }
    }

    public void h(Context context, String str) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().dispatchYYLiveRouter(context, str);
        }
    }

    public final NpsPluginLoadingDialogActivity i() {
        WeakReference<NpsPluginLoadingDialogActivity> weakReference = this.f59873a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public long k(Context context) {
        long[] jArr = {0};
        LiveNPSPluginManager.getInstance().getLiveResourceFileSize(context, new c(this, jArr));
        return jArr[0];
    }

    public void l(@Nullable f fVar) {
        LiveNpsGetSwitchManager.INSTANCE.getMasterSwitch("", new b(this, fVar));
    }

    public boolean m() {
        return this.f59875c;
    }

    public void n() {
        this.f59873a = null;
        LiveNPSPluginManager.getInstance().cancelLoading();
    }

    public void o(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        this.f59873a = new WeakReference<>(npsPluginLoadingDialogActivity);
        I(npsPluginLoadingDialogActivity);
    }

    public void p(Context context) {
        if (i() != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent(context, NpsPluginLoadingDialogActivity.class);
        intent.putExtra("dialogId", currentTimeMillis);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    public void q(Context context) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startAdminListActivity(context);
        }
    }

    public void r(Context context, String str, int i2) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startFansListActivity(context, str, i2);
        }
    }

    public void s(Context context) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startForbiddenListActivity(context);
        }
    }

    public void t(Context context, String str, String str2) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startGuardianListActivity(context, str, str2);
        }
    }

    public void u(Context context, long j, int i2) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startLiveExpActivity(context, j, i2);
        }
    }

    public void v(Context context, String str, String str2, String str3, Uri uri) {
        if (H()) {
            return;
        }
        LiveNPSPluginManager.getInstance().startLiveMediaActivity(context, str, str2, str3, uri);
    }

    public void w(Context context, String str) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startLiveShowActivity(context, str);
        }
    }

    public void x(Context context, String str, String str2, Map<String, Object> map) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startYuYinActivity(context, str, str2, map);
        }
    }

    public void y(@NonNull Context context) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startPatronageActivity(context);
        }
    }

    public void z(@NonNull Context context, String str) {
        if (H()) {
            l.M(context, "安卓系统版本不支持");
        } else {
            LiveNPSPluginManager.getInstance().startPatronsActivity(context, str);
        }
    }

    public a() {
        this.f59874b = 0;
        this.f59875c = false;
        LiveNPSPluginManager.getInstance().setLoadingCallback(new C1561a());
        d.a.n0.n1.i.a.c(TbadkCoreApplication.getInst());
    }
}
