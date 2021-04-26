package d.a.h0.a.p.c;

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
        public static final boolean f43511a = d.a.h0.a.k.f43101a;

        /* renamed from: d.a.h0.a.p.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0724a implements d.a.h0.a.k1.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43512a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43513b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43514c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f43515d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f43516e;

            public C0724a(a aVar, String str, String str2, String str3, boolean z, Context context) {
                this.f43512a = str;
                this.f43513b = str2;
                this.f43514c = str3;
                this.f43515d = z;
                this.f43516e = context;
            }

            @Override // d.a.h0.a.k1.b
            public void a(String str) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f43512a));
                String str2 = this.f43512a;
                request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
                if (!TextUtils.isEmpty(this.f43513b) && !TextUtils.isEmpty(this.f43514c)) {
                    request.setNotificationVisibility(1);
                    request.setTitle(this.f43513b);
                    request.setDescription(this.f43514c);
                    request.setVisibleInDownloadsUi(true);
                    request.allowScanningByMediaScanner();
                    request.setMimeType("application/vnd.android.package-archive");
                }
                DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                if (downloadManager != null) {
                    downloadManager.enqueue(request);
                    if (this.f43515d) {
                        return;
                    }
                    d.a.h0.a.i2.e.f(this.f43516e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                }
            }

            @Override // d.a.h0.a.k1.b
            public void b(int i2, String str) {
                if (a.f43511a) {
                    Log.d("DownloadImpl", "onAuthorizedFailed,  errorCode: " + i2 + " errorMsg: " + str);
                }
            }
        }

        @Override // d.a.h0.a.p.c.f
        public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.h0.a.q.g.a.a aVar) {
            return e(context, jSONObject);
        }

        @Override // d.a.h0.a.p.c.f
        public boolean b(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            return e(context, jSONObject);
        }

        @Override // d.a.h0.a.p.c.f
        public boolean c(Context context, JSONObject jSONObject) {
            return e(context, jSONObject);
        }

        public final boolean e(Context context, JSONObject jSONObject) {
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("description");
            boolean optBoolean = jSONObject.optBoolean("autoinstall");
            if (TextUtils.isEmpty(optString)) {
                d.a.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "download url is empty");
                return false;
            }
            d.a.h0.a.k1.a.a(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, context, new C0724a(this, optString, optString2, optString3, optBoolean, context));
            return true;
        }
    }

    boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.h0.a.q.g.a.a aVar);

    boolean b(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean c(Context context, JSONObject jSONObject);
}
