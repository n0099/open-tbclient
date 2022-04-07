package com.repackage;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mr8;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t88 implements QRCodeView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s88 a;
    public final TbPageContext b;
    public f c;
    public mr8 d;
    public e e;
    public boolean f;

    /* loaded from: classes7.dex */
    public class a implements mr8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t88 b;

        public a(t88 t88Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t88Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t88Var;
            this.a = str;
        }

        @Override // com.repackage.mr8.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.viewHideLoading();
                this.b.a.showRiskForbidDialog();
            }
        }

        @Override // com.repackage.mr8.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.a.viewHideLoading();
                this.b.a.showJumpExternalDialog(this.a);
            }
        }

        @Override // com.repackage.mr8.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.a.viewHideLoading();
                this.b.j(this.a);
            }
        }

        @Override // com.repackage.mr8.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.b.a.viewHideLoading();
                this.b.a.setErrorView();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t88 a;

        public b(t88 t88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t88Var;
        }

        @Override // com.repackage.t88.e.a
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            wt4.k().y("key_gallery_last_image_path", str);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.a.a.showGalleryLastImageTip(str, str2);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t88 b;

        public c(t88 t88Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t88Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t88Var;
            this.a = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, URLDecoder.decode(this.a, "UTF-8")));
                    this.b.b.getPageActivity().finish();
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BdAsyncTask<String, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t88 a;

        public d(t88 t88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t88Var;
        }

        public /* synthetic */ d(t88 t88Var, a aVar) {
            this(t88Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
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
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((d) str);
                this.a.p(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends BdAsyncTask<String, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public a b;

        /* loaded from: classes7.dex */
        public interface a {
            void a(String str, String str2);
        }

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr == null || strArr.length <= 0) {
                    return null;
                }
                String str = strArr[0];
                this.a = str;
                return x88.c(str);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((e) str);
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(this.a, str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BdAsyncTask<String, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t88 a;

        public f(t88 t88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t88Var;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                this.a.a.viewShowLoading();
            }
        }

        public /* synthetic */ f(t88 t88Var, a aVar) {
            this(t88Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr == null || strArr.length <= 0) {
                    return null;
                }
                return x88.c(strArr[0]);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((f) str);
                this.a.a.viewHideLoading();
                this.a.b(str);
            }
        }
    }

    public t88(s88 s88Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s88Var, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = s88Var;
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            oi.M(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f04e0);
            this.b.getPageActivity().finish();
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.c
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.a.viewHideLoading();
                this.a.setErrorView();
            } else if (this.f) {
                Intent intent = new Intent();
                intent.putExtra(QRCodeScanActivityConfig.RESULT_SCAN_CODE, str);
                this.b.getPageActivity().setResult(-1, intent);
                this.b.getPageActivity().finish();
            } else if (k(str)) {
                this.a.viewHideLoading();
            } else if (!StringUtils.isNull(str) && str.contains("feedavatar.baidu.com")) {
                this.a.viewHideLoading();
                i(str);
            } else if (l(str)) {
                this.a.viewHideLoading();
                this.b.getPageActivity().finish();
            } else if (!StringHelper.isNetworkUrl(str)) {
                this.a.viewHideLoading();
                this.a.setErrorView();
            } else {
                m(str);
            }
        }
    }

    public final String f(ContentResolver contentResolver) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, contentResolver)) == null) {
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
        return (String) invokeL.objValue;
    }

    public void g() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = this.b) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || (this.b.getPageActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && this.b.getPageActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
            String f2 = f(this.b.getPageActivity().getContentResolver());
            if (TextUtils.isEmpty(f2) || f2.endsWith(".gif") || f2.endsWith(".GIF") || f2.equals(wt4.k().q("key_gallery_last_image_path", null))) {
                return;
            }
            e eVar = this.e;
            if (eVar != null) {
                eVar.cancel();
            }
            e eVar2 = new e(new b(this));
            this.e = eVar2;
            eVar2.execute(f2);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mr8 mr8Var = this.d;
            if (mr8Var != null && !mr8Var.isCancelled()) {
                this.d.cancel();
            }
            f fVar = this.c;
            if (fVar != null) {
                fVar.cancel();
                this.c = null;
            }
            e eVar = this.e;
            if (eVar != null) {
                eVar.cancel();
                this.e = null;
            }
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            CookieSyncManager.createInstance(this.b.getPageActivity());
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("feedavatar.baidu.com", "cuid=" + TbadkCoreApplication.getInst().getCuid() + ";");
            cookieManager.setCookie("feedavatar.baidu.com", "tiebaapp=1;");
            CookieSyncManager.getInstance().sync();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.getPageActivity(), null, str, false)));
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
            this.b.getPageActivity().finish();
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public final boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921339, null, str);
            return runTask != null && runTask.getData() != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!oi.C()) {
                this.a.viewHideLoading();
                oi.N(this.b.getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c19));
                return;
            }
            mr8 mr8Var = this.d;
            if (mr8Var != null && !mr8Var.isCancelled()) {
                this.d.cancel();
            }
            mr8 mr8Var2 = new mr8(str, new a(this, str));
            this.d = mr8Var2;
            mr8Var2.setPriority(3);
            this.d.execute(new String[0]);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.a.viewShowLoading();
        f fVar = this.c;
        if (fVar != null) {
            fVar.cancel();
        }
        f fVar2 = new f(this, null);
        this.c = fVar2;
        fVar2.execute(str);
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f = z;
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && !StringUtils.isNull(str) && str.startsWith("tiebaclient:")) {
            if (Build.VERSION.SDK_INT <= 21) {
                oi.M(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f00e2);
                return;
            }
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.b.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new c(this, str));
            permissionJudgePolicy.startRequestPermission(this.b.getPageActivity());
        }
    }
}
