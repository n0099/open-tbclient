package d.b.h0.a.p.c;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface f {

    /* loaded from: classes2.dex */
    public static class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f46164a = d.b.h0.a.k.f45772a;

        /* renamed from: d.b.h0.a.p.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0785a implements d.b.h0.a.k1.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f46165a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f46166b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f46167c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f46168d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f46169e;

            public C0785a(a aVar, String str, String str2, String str3, boolean z, Context context) {
                this.f46165a = str;
                this.f46166b = str2;
                this.f46167c = str3;
                this.f46168d = z;
                this.f46169e = context;
            }

            @Override // d.b.h0.a.k1.b
            public void a(String str) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f46165a));
                String str2 = this.f46165a;
                request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
                if (!TextUtils.isEmpty(this.f46166b) && !TextUtils.isEmpty(this.f46167c)) {
                    request.setNotificationVisibility(1);
                    request.setTitle(this.f46166b);
                    request.setDescription(this.f46167c);
                    request.setVisibleInDownloadsUi(true);
                    request.allowScanningByMediaScanner();
                    request.setMimeType("application/vnd.android.package-archive");
                }
                DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                if (downloadManager != null) {
                    downloadManager.enqueue(request);
                    if (this.f46168d) {
                        return;
                    }
                    d.b.h0.a.i2.e.f(this.f46169e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                }
            }

            @Override // d.b.h0.a.k1.b
            public void b(int i, String str) {
                if (a.f46164a) {
                    Log.d("DownloadImpl", "onAuthorizedFailed,  errorCode: " + i + " errorMsg: " + str);
                }
            }
        }

        @Override // d.b.h0.a.p.c.f
        public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.b.h0.a.q.g.a.a aVar) {
            return e(context, jSONObject);
        }

        @Override // d.b.h0.a.p.c.f
        public boolean b(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            return e(context, jSONObject);
        }

        @Override // d.b.h0.a.p.c.f
        public boolean c(Context context, JSONObject jSONObject) {
            return e(context, jSONObject);
        }

        public final boolean e(Context context, JSONObject jSONObject) {
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("description");
            boolean optBoolean = jSONObject.optBoolean("autoinstall");
            if (TextUtils.isEmpty(optString)) {
                d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "download url is empty");
                return false;
            }
            d.b.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0785a(this, optString, optString2, optString3, optBoolean, context));
            return true;
        }
    }

    boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.b.h0.a.q.g.a.a aVar);

    boolean b(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean c(Context context, JSONObject jSONObject);
}
