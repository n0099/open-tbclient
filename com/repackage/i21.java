package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.nadcore.webarch.permission.NadPermissionActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.repackage.j11;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class i21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueCallback<Uri> a;
    public String b;
    public ValueCallback<Uri[]> c;
    public WebChromeClient.FileChooserParams d;
    public boolean e;
    public boolean f;
    public Activity g;
    public boolean h;

    /* loaded from: classes6.dex */
    public class a implements j11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ i21 b;

        public a(i21 i21Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i21Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i21Var;
            this.a = i;
        }

        @Override // com.repackage.j11.b
        @RequiresApi(api = 21)
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == this.a) {
                boolean z = iArr.length != 0;
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.b.h = false;
                    i21 i21Var = this.b;
                    i21Var.startActivityForResult(i21Var.k(), 11);
                } else if (this.b.c != null) {
                    this.b.c.onReceiveValue(null);
                }
                m11.b().d(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements j11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i21 a;

        public b(i21 i21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i21Var;
        }

        @Override // com.repackage.j11.b
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 4099) {
                boolean z = iArr.length != 0;
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.a.h = true;
                    i21 i21Var = this.a;
                    i21Var.startActivityForResult(i21Var.j(), 11);
                }
                m11.b().d(4099);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements j11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i21 a;

        public c(i21 i21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i21Var;
        }

        @Override // com.repackage.j11.b
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 4099) {
                boolean z = iArr.length != 0;
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.a.h = true;
                    this.a.g.startActivityForResult(this.a.h(), 11);
                }
                m11.b().d(4099);
            }
        }
    }

    public i21(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.g = activity;
    }

    private void requestPermissions(int i, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, this, i, strArr) == null) {
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", i);
            intent.putExtra("permissions", strArr);
            m11.b().a(i, new a(this, i));
            try {
                j01.c(this.g, intent);
            } catch (Exception unused) {
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ValueCallback<Uri> valueCallback = this.a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            ValueCallback<Uri[]> valueCallback2 = this.c;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (Activity) invokeV.objValue;
    }

    public final Intent h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (l21.a(this.g)) {
                return new Intent("android.media.action.VIDEO_CAPTURE");
            }
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", 4099);
            intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
            m11.b().a(4099, new c(this));
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public Intent i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (l21.a(this.g) && l21.b(this.g)) {
                return j();
            }
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", 4099);
            String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"};
            if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
                strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            }
            intent.putExtra("permissions", strArr);
            m11.b().a(4099, new b(this));
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @SuppressLint({"NewApi", "ObsoleteSdkInt"})
    public final Intent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File externalFilesDir = dh0.b().getExternalFilesDir(Environment.DIRECTORY_DCIM);
            File file = new File(externalFilesDir.getAbsolutePath() + File.separator + "nad-browser-photos");
            file.mkdirs();
            this.b = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra("output", FileProvider.getUriForFile(dh0.b(), dh0.c().a().r(), new File(this.b)));
            } else {
                intent.putExtra("output", Uri.fromFile(new File(this.b)));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                intent.setFlags(3);
            }
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"ObsoleteSdkInt"})
    public final Intent k() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            WebChromeClient.FileChooserParams fileChooserParams = this.d;
            String[] acceptTypes = fileChooserParams != null ? fileChooserParams.getAcceptTypes() : null;
            String str = "*/*";
            String str2 = (acceptTypes == null || acceptTypes.length <= 0) ? "*/*" : acceptTypes[0];
            if (str2 != null && !str2.trim().isEmpty()) {
                str = str2;
            }
            ArrayList arrayList = new ArrayList();
            boolean z = this.d.getMode() == 1;
            if (str.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                arrayList.add(j());
            } else if (str.equals(BdUploadHandler.VIDEO_MIME_TYPE)) {
                arrayList.add(new Intent("android.media.action.VIDEO_CAPTURE"));
            } else if (str.equals(BdUploadHandler.AUDIO_MIME_TYPE)) {
                arrayList.add(n());
            }
            if (arrayList.isEmpty()) {
                arrayList.add(j());
                arrayList.add(h());
                arrayList.add(n());
            }
            if (str.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
                if (Build.VERSION.SDK_INT >= 18 && z) {
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                }
            } else {
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                if (Build.VERSION.SDK_INT >= 18 && z) {
                    intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                }
                intent2.setType(str);
                intent = intent2;
            }
            Intent intent3 = new Intent("android.intent.action.CHOOSER");
            if (!arrayList.isEmpty()) {
                intent3.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Intent[0]));
            }
            intent3.putExtra("android.intent.extra.INTENT", intent);
            return intent3;
        }
        return (Intent) invokeV.objValue;
    }

    public final Intent l(Intent... intentArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intentArr)) == null) {
            Intent intent = new Intent("android.intent.action.CHOOSER");
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            intent.putExtra("android.intent.extra.TITLE", dh0.b().getResources().getString(R.string.obfuscated_res_0x7f0f0b74));
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public final Intent m() {
        InterceptResult invokeV;
        WebChromeClient.FileChooserParams fileChooserParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            Intent l = l(i(), h(), n());
            l.putExtra("android.intent.extra.INTENT", intent);
            if (Build.VERSION.SDK_INT >= 21 && (fileChooserParams = this.d) != null) {
                l.putExtra("android.intent.extra.INTENT", fileChooserParams.createIntent());
            }
            return l;
        }
        return (Intent) invokeV.objValue;
    }

    public final Intent n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new Intent("android.provider.MediaStore.RECORD_SOUND") : (Intent) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.e : invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: android.webkit.ValueCallback<android.net.Uri[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void p(int i, Intent intent) {
        Uri uri;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, intent) == null) {
            if (this.h) {
                this.h = false;
                return;
            }
            if (i == -1 && intent == null && this.b == null) {
                i = 0;
            }
            if (i == 0 && this.f) {
                this.f = false;
                return;
            }
            if (intent == null || i != -1) {
                uri = null;
            } else {
                try {
                    uri = intent.getData();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            if (uri == null && intent == null && i == -1) {
                File file = new File(this.b);
                if (file.exists()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        fromFile = FileProvider.getUriForFile(dh0.b(), dh0.c().a().r(), file);
                    } else {
                        fromFile = Uri.fromFile(file);
                    }
                    uri = fromFile;
                    dh0.b().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
                }
            }
            if (this.c != null) {
                ArrayList arrayList = new ArrayList();
                if (uri != null) {
                    arrayList.add(uri);
                } else if (intent != null && intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
                        arrayList.add(clipData.getItemAt(i2).getUri());
                    }
                }
                this.c.onReceiveValue(arrayList.toArray(new Uri[0]));
            }
            if (this.a != null) {
                this.a.onReceiveValue(uri);
            }
            this.e = true;
            this.f = false;
        }
    }

    @RequiresApi(api = 21)
    public boolean q(@NonNull ValueCallback<Uri[]> valueCallback, @NonNull WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, valueCallback, fileChooserParams)) == null) {
            this.c = valueCallback;
            this.d = fileChooserParams;
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            String str = (acceptTypes == null || acceptTypes.length <= 0) ? "*/*" : acceptTypes[0];
            ArrayList arrayList = new ArrayList();
            if (str.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                if (!l21.a(this.g)) {
                    arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                }
                boolean z = Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy();
                if (!l21.b(this.g) && z) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            } else if (str.equals(BdUploadHandler.VIDEO_MIME_TYPE) && !l21.a(this.g)) {
                arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            }
            if (arrayList.isEmpty()) {
                if (!l21.a(this.g)) {
                    arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                }
                if (!l21.b(this.g)) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            }
            if (arrayList.size() > 0) {
                requestPermissions(4099, (String[]) arrayList.toArray(new String[0]));
                return true;
            }
            try {
                return startActivityForResult(k(), 11);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean startActivityForResult(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, intent, i)) == null) {
            try {
                try {
                    this.g.startActivityForResult(intent, i);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    g();
                    return false;
                }
            } catch (ActivityNotFoundException unused2) {
                this.f = true;
                this.g.startActivityForResult(m(), i);
                return true;
            }
        }
        return invokeLI.booleanValue;
    }
}
