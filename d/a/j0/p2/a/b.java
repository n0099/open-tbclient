package d.a.j0.p2.a;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.j0.l3.c;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements QRCodeView.c {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.j0.p2.a.a f57382a;

    /* renamed from: b  reason: collision with root package name */
    public final TbPageContext f57383b;

    /* renamed from: c  reason: collision with root package name */
    public f f57384c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.l3.c f57385d;

    /* renamed from: e  reason: collision with root package name */
    public e f57386e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57387f;

    /* loaded from: classes3.dex */
    public class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f57388a;

        public a(String str) {
            this.f57388a = str;
        }

        @Override // d.a.j0.l3.c.a
        public void a() {
            b.this.f57382a.viewHideLoading();
            b.this.f57382a.showRiskForbidDialog();
        }

        @Override // d.a.j0.l3.c.a
        public void b() {
            b.this.f57382a.viewHideLoading();
            b.this.f57382a.showJumpExternalDialog(this.f57388a);
        }

        @Override // d.a.j0.l3.c.a
        public void c() {
            b.this.f57382a.viewHideLoading();
            b.this.j(this.f57388a);
        }

        @Override // d.a.j0.l3.c.a
        public void onError(String str) {
            b.this.f57382a.viewHideLoading();
            b.this.f57382a.setErrorView();
        }
    }

    /* renamed from: d.a.j0.p2.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1393b implements e.a {
        public C1393b() {
        }

        @Override // d.a.j0.p2.a.b.e.a
        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.i0.r.d0.b.j().x("key_gallery_last_image_path", str);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            b.this.f57382a.showGalleryLastImageTip(str, str2);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f57391a;

        public c(String str) {
            this.f57391a = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, URLDecoder.decode(this.f57391a, "UTF-8")));
                b.this.f57383b.getPageActivity().finish();
            } catch (UnsupportedEncodingException unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<String, Void, String> {
        public d() {
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str = strArr[0];
            if (StringUtils.isNull(str)) {
                return null;
            }
            String postNetData = new NetWork(str).postNetData();
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            try {
                return new JSONObject(postNetData).optString("data");
            } catch (JSONException unused) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((d) str);
            b.this.p(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends BdAsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f57394a;

        /* renamed from: b  reason: collision with root package name */
        public a f57395b;

        /* loaded from: classes3.dex */
        public interface a {
            void a(String str, String str2);
        }

        public e(a aVar) {
            this.f57395b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            String str = strArr[0];
            this.f57394a = str;
            return d.a.j0.p2.b.b.a.c(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((e) str);
            a aVar = this.f57395b;
            if (aVar != null) {
                aVar.a(this.f57394a, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<String, Void, String> {
        public f() {
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            b.this.f57382a.viewShowLoading();
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return d.a.j0.p2.b.b.a.c(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((f) str);
            b.this.f57382a.viewHideLoading();
            b.this.b(str);
        }
    }

    public b(d.a.j0.p2.a.a aVar, TbPageContext tbPageContext) {
        this.f57382a = aVar;
        this.f57383b = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.c
    public void a() {
        l.L(this.f57383b.getPageActivity(), R.string.disallow_camera_permission);
        this.f57383b.getPageActivity().finish();
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.c
    public void b(String str) {
        if (StringUtils.isNull(str)) {
            this.f57382a.viewHideLoading();
            this.f57382a.setErrorView();
        } else if (this.f57387f) {
            Intent intent = new Intent();
            intent.putExtra(QRCodeScanActivityConfig.RESULT_SCAN_CODE, str);
            this.f57383b.getPageActivity().setResult(-1, intent);
            this.f57383b.getPageActivity().finish();
        } else if (k(str)) {
            this.f57382a.viewHideLoading();
        } else if (!StringUtils.isNull(str) && str.contains("feedavatar.baidu.com")) {
            this.f57382a.viewHideLoading();
            i(str);
        } else if (l(str)) {
            this.f57382a.viewHideLoading();
            this.f57383b.getPageActivity().finish();
        } else if (!StringHelper.isNetworkUrl(str)) {
            this.f57382a.viewHideLoading();
            this.f57382a.setErrorView();
        } else {
            m(str);
        }
    }

    public final String f(ContentResolver contentResolver) {
        Throwable th;
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        if (contentResolver == null) {
            return null;
        }
        try {
            cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name", "_data", "_size", "bucket_display_name", "date_modified"}, null, null, null);
        } catch (Exception unused) {
            str = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (cursor == null) {
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
        try {
            try {
                cursor.moveToLast();
                str = cursor.getString(cursor.getColumnIndex("_data"));
                try {
                } catch (Exception unused2) {
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return str;
                }
            } catch (Exception unused3) {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } else if (!new File(str).exists()) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } else {
                cursor.close();
                if (cursor != null) {
                    cursor.close();
                }
                return str;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void g() {
        TbPageContext tbPageContext = this.f57383b;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || (this.f57383b.getPageActivity().checkSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0 && this.f57383b.getPageActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
            String f2 = f(this.f57383b.getPageActivity().getContentResolver());
            if (TextUtils.isEmpty(f2) || f2.endsWith(".gif") || f2.endsWith(".GIF") || f2.equals(d.a.i0.r.d0.b.j().p("key_gallery_last_image_path", null))) {
                return;
            }
            e eVar = this.f57386e;
            if (eVar != null) {
                eVar.cancel();
            }
            e eVar2 = new e(new C1393b());
            this.f57386e = eVar2;
            eVar2.execute(f2);
        }
    }

    public void h() {
        d.a.j0.l3.c cVar = this.f57385d;
        if (cVar != null && !cVar.isCancelled()) {
            this.f57385d.cancel();
        }
        f fVar = this.f57384c;
        if (fVar != null) {
            fVar.cancel();
            this.f57384c = null;
        }
        e eVar = this.f57386e;
        if (eVar != null) {
            eVar.cancel();
            this.f57386e = null;
        }
    }

    public final void i(String str) {
        CookieSyncManager.createInstance(this.f57383b.getPageActivity());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("feedavatar.baidu.com", "cuid=" + TbadkCoreApplication.getInst().getCuid() + ";");
        cookieManager.setCookie("feedavatar.baidu.com", "tiebaapp=1;");
        CookieSyncManager.getInstance().sync();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f57383b.getPageActivity(), null, str, false)));
    }

    public void j(String str) {
        UrlManager.getInstance().dealOneLink(this.f57383b, new String[]{str});
        this.f57383b.getPageActivity().finish();
    }

    public final boolean k(String str) {
        if (StringUtils.isNULL(str)) {
            return false;
        }
        if (str.startsWith("tiebaclient:")) {
            p(str);
            return true;
        } else if (str.contains("smartapp.baidu.com/mappconsole/api/packagescheme") || str.contains("mappconsole/api/packagescheme")) {
            new d(this, null).execute(str);
            return true;
        } else {
            return false;
        }
    }

    public final boolean l(String str) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921339, null, str);
        return runTask != null && runTask.getData() != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue();
    }

    public final void m(String str) {
        if (!l.D()) {
            this.f57382a.viewHideLoading();
            l.M(this.f57383b.getPageActivity(), this.f57383b.getResources().getString(R.string.network_not_available));
            return;
        }
        d.a.j0.l3.c cVar = this.f57385d;
        if (cVar != null && !cVar.isCancelled()) {
            this.f57385d.cancel();
        }
        d.a.j0.l3.c cVar2 = new d.a.j0.l3.c(str, new a(str));
        this.f57385d = cVar2;
        cVar2.setPriority(3);
        this.f57385d.execute(new String[0]);
    }

    public void n(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f57382a.viewShowLoading();
        f fVar = this.f57384c;
        if (fVar != null) {
            fVar.cancel();
        }
        f fVar2 = new f(this, null);
        this.f57384c = fVar2;
        fVar2.execute(str);
    }

    public void o(boolean z) {
        this.f57387f = z;
    }

    public final void p(String str) {
        if (!StringUtils.isNull(str) && str.startsWith("tiebaclient:")) {
            if (Build.VERSION.SDK_INT <= 21) {
                l.L(this.f57383b.getPageActivity(), R.string.ai_apps_not_support);
                return;
            }
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f57383b.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            permissionJudgePolicy.setOnPermissionsGrantedListener(new c(str));
            permissionJudgePolicy.startRequestPermission(this.f57383b.getPageActivity());
        }
    }
}
