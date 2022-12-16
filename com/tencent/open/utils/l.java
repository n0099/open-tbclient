package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.main.facesdk.BuildConfig;
import com.baidu.sapi2.activity.ImageClipActivity;
import com.baidu.sapi2.result.GetCertStatusResult;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static int e = -1;
    public static String f = "0123456789ABCDEF";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2036590738, "Lcom/tencent/open/utils/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2036590738, "Lcom/tencent/open/utils/l;");
        }
    }

    public static char a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            int i2 = i & 15;
            return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
        }
        return invokeI.charValue;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public long b;
        public long c;

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
            if (str != null) {
                this.c = str.length();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x003c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0015 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.InputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable a(String str, Context context) {
        InterceptResult invokeLL;
        InputStream inputStream;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, context)) == null) {
            InputStream inputStream2 = null;
            r1 = null;
            Drawable drawable = null;
            if (context == null) {
                SLog.e("openSDK_LOG.Util", "context null!");
                return null;
            }
            AssetManager assets = context.getAssets();
            try {
                try {
                    inputStream = assets.open(str);
                    try {
                        drawable = Drawable.createFromStream(inputStream, str);
                        try {
                            inputStream.close();
                            assets = inputStream;
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("inputStream close exception: ");
                            sb.append(e.getMessage());
                            SLog.e("openSDK_LOG.Util", sb.toString());
                            return drawable;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
                        try {
                            inputStream.close();
                            assets = inputStream;
                        } catch (Exception e4) {
                            e = e4;
                            sb = new StringBuilder();
                            sb.append("inputStream close exception: ");
                            sb.append(e.getMessage());
                            SLog.e("openSDK_LOG.Util", sb.toString());
                            return drawable;
                        }
                        return drawable;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = assets;
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                        SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e5.getMessage());
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2.close();
                throw th;
            }
            return drawable;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65563, null, context, str) != null) || context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            b = str2;
            a = str2.substring(0, str2.lastIndexOf(46));
            d = b.substring(b.lastIndexOf(46) + 1, b.length());
            e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        } catch (Exception e3) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
        }
    }

    public static Bundle a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Bundle bundle = new Bundle();
            if (str != null) {
                try {
                    for (String str2 : str.split("&")) {
                        String[] split = str2.split("=");
                        if (split.length == 2) {
                            bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
                        }
                    }
                    return bundle;
                } catch (Exception unused) {
                    return null;
                }
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static File m(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, str)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                if (file.getParentFile() != null && !file.getParentFile().exists()) {
                    if (file.getParentFile().mkdirs()) {
                        file.createNewFile();
                    } else {
                        SLog.d("openSDK_LOG.Util", "createFile failed" + str);
                    }
                } else {
                    file.createNewFile();
                }
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
        }
        return (Bundle) invokeCommon.objValue;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.PARAM_PLATFORM, "1");
            bundle.putString("result", str);
            bundle.putString("code", str2);
            bundle.putString("tmcost", str3);
            bundle.putString("rate", str4);
            bundle.putString("cmd", str5);
            bundle.putString("uin", str6);
            bundle.putString("appid", str7);
            bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_VOICE_ROOM_TYPE, str8);
            bundle.putString("detail", str9);
            bundle.putString("os_ver", Build.VERSION.RELEASE);
            bundle.putString("network", com.tencent.open.a.a.a(f.a()));
            bundle.putString("apn", com.tencent.open.a.a.b(f.a()));
            bundle.putString("model_name", Build.MODEL);
            bundle.putString("sdk_ver", Constants.SDK_VERSION);
            bundle.putString("packagename", f.b());
            bundle.putString("app_ver", d(f.a(), f.b()));
            return bundle;
        }
        return (Bundle) invokeCommon.objValue;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("openid", str);
            bundle.putString("report_type", str2);
            bundle.putString("act_type", str3);
            bundle.putString("via", str4);
            bundle.putString("app_id", str5);
            bundle.putString("result", str6);
            bundle.putString("type", str7);
            bundle.putString(DpStatConstants.KEY_LOGIN_STATUS, str8);
            bundle.putString("need_user_auth", str9);
            bundle.putString("to_uin", str10);
            bundle.putString("call_source", str11);
            bundle.putString("to_type", str12);
            bundle.putString(Constants.PARAM_PLATFORM, "1");
            return bundle;
        }
        return (Bundle) invokeCommon.objValue;
    }

    public static final String a(Context context) {
        InterceptResult invokeL;
        CharSequence applicationLabel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context != null && (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) != null) {
                return applicationLabel.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (i.c(context, "8.1.5") >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            if (i.c(context, "8.1.8") >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            if (i.c(context, "5.9.5") < 0 && i.a(context, Constants.PACKAGE_QQ_SPEED) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) {
            if (str == null) {
                return false;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            if (str == null || !new File(str).exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static byte[] i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, str)) == null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Base64.encodeToString(a(str.getBytes(), "JCPTZXEZ"), 3);
        }
        return (String) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, str)) == null) {
            String b2 = b();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(b2) && str.contains(b2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static String a(Context context, Uri uri) {
        InterceptResult invokeLL;
        boolean z;
        Uri uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, uri)) == null) {
            if (uri == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                z = true;
            } else {
                z = false;
            }
            if (z && DocumentsContract.isDocumentUri(context, uri)) {
                String authority = uri.getAuthority();
                if (ImageClipActivity.m.equals(authority)) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split[0];
                    if (GetCertStatusResult.VALUE_PRIMARY_REAL_NAME.equals(str)) {
                        return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
                    }
                    return "/storage/".concat(str).concat("/").concat(split[1]);
                } else if (ImageClipActivity.l.equals(authority)) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    if (documentId.startsWith("raw:")) {
                        return documentId.replaceFirst("raw:", "");
                    }
                    return b(context, ContentUris.withAppendedId(Uri.parse(ImageClipActivity.n), Long.parseLong(documentId)));
                } else {
                    if (ImageClipActivity.k.equals(authority)) {
                        String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str2 = split2[0];
                        if ("image".equals(str2)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(str2)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if ("audio".equals(str2)) {
                            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return b(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
                    }
                    return null;
                }
            }
            String scheme = uri.getScheme();
            if ("content".equals(scheme)) {
                return b(context, uri);
            }
            if (!"file".equals(scheme)) {
                return null;
            }
            return uri.getPath();
        }
        return (String) invokeLL.objValue;
    }

    public static final String a(String str, int i, String str2, String str3) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65545, null, str, i, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "UTF-8";
            }
            try {
                if (str.getBytes(str2).length <= i) {
                    return str;
                }
                int i2 = 0;
                int i3 = 0;
                while (i2 < str.length()) {
                    int i4 = i2 + 1;
                    i3 += str.substring(i2, i4).getBytes(str2).length;
                    if (i3 > i) {
                        String substring = str.substring(0, i2);
                        if (!TextUtils.isEmpty(str3)) {
                            return substring + str3;
                        }
                        return substring;
                    }
                    i2 = i4;
                }
                return str;
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
                return str;
            }
        }
        return (String) invokeLILL.objValue;
    }

    public static String a(String str, Activity activity, String str2, IUiListener iUiListener) {
        InterceptResult invokeLLLL;
        File a2;
        File cacheDir;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, str, activity, str2, iUiListener)) == null) {
            try {
                boolean n = n(str2);
                SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + n + ",hasSDPermission=" + c());
                if (!n) {
                    if (f.a("Images") != null) {
                        str3 = a2.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                    } else {
                        if (f.a().getCacheDir() == null) {
                            SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                            return null;
                        }
                        str3 = cacheDir.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                    }
                    File file = new File(str2);
                    String absolutePath = file.getAbsolutePath();
                    String str4 = str3 + File.separator + file.getName();
                    if (a(absolutePath, str4)) {
                        str2 = str4;
                    } else {
                        str2 = null;
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    File file2 = new File(str2);
                    String authorities = Tencent.getAuthorities(str);
                    if (TextUtils.isEmpty(authorities)) {
                        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, authorities is null");
                        if (iUiListener != null) {
                            iUiListener.onWarning(-19);
                        }
                        return null;
                    }
                    Uri uriForFile = FileProvider.getUriForFile(activity, authorities, file2);
                    activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                    return uriForFile.toString();
                }
                SLog.e("openSDK_LOG.Util", "getMediaFileUri error, destAppSpecific is null");
                return null;
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e2);
                return null;
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, map, str, str2)) == null) {
            if (map == null) {
                SLog.e("openSDK_LOG.Util", "getString error, params==null");
                return str2;
            } else if (!map.containsKey(str)) {
                SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
                return str2;
            } else {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    return (String) obj;
                }
                return str2;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b2 : bArr) {
                String num = Integer.toString(b2 & 255, 16);
                if (num.length() == 1) {
                    num = "0" + num;
                }
                sb.append(num);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, jSONObject, str)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (str != null) {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=");
                    if (split.length == 2) {
                        try {
                            split[0] = URLDecoder.decode(split[0]);
                            split[1] = URLDecoder.decode(split[1]);
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject.put(split[0], split[1]);
                        } catch (JSONException e2) {
                            SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void a(Context context, String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, str, Long.valueOf(j), str2}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("appid_for_getting_config", str2);
            bundle.putString("strValue", str2);
            bundle.putString("nValue", str);
            bundle.putString("qver", Constants.SDK_VERSION);
            if (j != 0) {
                bundle.putLong("elt", j);
            }
            new Thread(context, bundle) { // from class: com.tencent.open.utils.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ Bundle b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, bundle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.b = bundle;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            HttpUtils.openUrl2(this.a, "https://cgi.qplus.com/report/report", "GET", this.b);
                        } catch (Exception e2) {
                            SLog.e("openSDK_LOG.Util", "reportBernoulli has exception: " + e2.getMessage());
                        }
                    }
                }
            }.start();
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, context, str, str2, str3) == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str, str2));
            intent.setAction("android.intent.action.VIEW");
            intent.addFlags(1073741824);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.setData(Uri.parse(str3));
            context.startActivity(intent);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                file = Environment.getExternalStorageDirectory();
            } else {
                file = null;
            }
            if (file != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            File e2 = f.e();
            if (e2 != null) {
                if (!e2.exists()) {
                    e2.mkdirs();
                }
                return e2.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            Context a2 = f.a();
            if (a2 == null || a2.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", a2.getPackageName()) != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) {
            try {
                z = g(context);
            } catch (Exception unused) {
                z = false;
            }
            try {
                if (z) {
                    a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } else {
                    a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                }
                return true;
            } catch (Exception unused2) {
                if (z) {
                    try {
                        try {
                            try {
                                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            } catch (Exception unused3) {
                                a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                                return true;
                            }
                        } catch (Exception unused4) {
                            a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                            return true;
                        }
                    } catch (Exception unused5) {
                        return false;
                    }
                }
                try {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception unused6) {
                        return false;
                    }
                } catch (Exception unused7) {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                    return true;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(Context context, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, context, str)) == null) {
            boolean z2 = true;
            if (c(context) && i.a(context, Constants.PACKAGE_QQ_PAD) != null) {
                z = false;
            } else {
                z = true;
            }
            if (z && i.a(context, Constants.PACKAGE_TIM) != null) {
                z = false;
            }
            if (z && i.a(context, Constants.PACKAGE_QQ_SPEED) != null) {
                z = false;
            }
            if (z) {
                if (i.c(context, str) >= 0) {
                    z2 = false;
                }
                return z2;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, context, str, str2)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                if (context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                    a2 = a(str, str2);
                } else {
                    a2 = false;
                }
            } else {
                a2 = a(str, str2);
            }
            SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + a2);
            return a2;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65555, null, context, z)) == null) {
            if ((c(context) && i.a(context, Constants.PACKAGE_QQ_PAD) != null) || i.c(context, BuildConfig.VERSION_NAME) >= 0 || i.a(context, Constants.PACKAGE_TIM) != null || i.a(context, Constants.PACKAGE_QQ_SPEED) != null) {
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean g(Context context, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, context, str)) == null) {
            boolean z2 = true;
            if (c(context) && i.a(context, Constants.PACKAGE_QQ_PAD) != null) {
                z = false;
            } else {
                z = true;
            }
            if (z && i.a(context, Constants.PACKAGE_QQ_SPEED) != null) {
                z = false;
            }
            if (z) {
                if (i.c(context, str) >= 0) {
                    z2 = false;
                }
                return z2;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x005e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0060 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0062 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0082 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x009d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x000a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:98:0x000a */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.io.File */
    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v12, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v13, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v14, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v15, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v18, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v23, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v24, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v4, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v5, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v6, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v9, resolved type: java.io.BufferedInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x005a -> B:85:0x009c). Please submit an issue!!! */
    public static boolean a(File file, File file2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, file, file2)) == null) {
            boolean z = false;
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream2 = null;
            fileOutputStream2 = null;
            fileOutputStream2 = null;
            fileOutputStream2 = null;
            try {
                try {
                    try {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                            file2.getParentFile().mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            file2 = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e2) {
                            e = e2;
                            file2 = 0;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            file2 = 0;
                        } catch (Throwable th) {
                            th = th;
                            file2 = 0;
                        }
                    } catch (IOException e4) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e4);
                        fileOutputStream2 = fileOutputStream2;
                        file2 = file2;
                    }
                } catch (IOException e5) {
                    e = e5;
                    file2 = 0;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    file2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    file2 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                byte[] bArr = new byte[102400];
                while (true) {
                    read = file2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                z = true;
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e7);
                }
                file2.close();
                fileOutputStream2 = read;
                file2 = file2;
            } catch (IOException e8) {
                e = e8;
                fileOutputStream2 = fileOutputStream;
                file2 = file2;
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e9) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e9);
                    }
                }
                if (file2 != 0) {
                    file2.close();
                    fileOutputStream2 = fileOutputStream2;
                    file2 = file2;
                }
                return z;
            } catch (OutOfMemoryError e10) {
                e = e10;
                fileOutputStream2 = fileOutputStream;
                file2 = file2;
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e11) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e11);
                    }
                }
                if (file2 != 0) {
                    file2.close();
                    fileOutputStream2 = fileOutputStream2;
                    file2 = file2;
                }
                return z;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e12) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e12);
                    }
                }
                if (file2 != 0) {
                    try {
                        file2.close();
                    } catch (IOException e13) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e13);
                    }
                }
                throw th;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, str, str2)) == null) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    return a(file, m(str2));
                } catch (IOException e2) {
                    SLog.d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Map<String, Object> map, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65558, null, map, str, z)) == null) {
            if (map == null) {
                SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
                return z;
            } else if (!map.containsKey(str)) {
                SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
                return z;
            } else {
                Object obj = map.get(str);
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                return z;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static byte[] a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, bArr, str)) == null) {
            if (bArr != null) {
                try {
                    char[] charArray = str.toCharArray();
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    for (int i = 0; i < length; i++) {
                        bArr2[i] = (byte) (bArr[i] ^ charArray[i % charArray.length]);
                    }
                    return bArr2;
                } catch (Throwable th) {
                    SLog.e("Util", "xor Exception! ", th);
                }
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static Bundle b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            try {
                URL url = new URL(str.replace("auth://", "http://"));
                Bundle a2 = a(url.getQuery());
                a2.putAll(a(url.getRef()));
                return a2;
            } catch (MalformedURLException unused) {
                return new Bundle();
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            try {
                URL url = new URL(str.replace("auth://", "http://"));
                JSONObject a2 = a((JSONObject) null, url.getQuery());
                a(a2, url.getRef());
                return a2;
            } catch (MalformedURLException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static long j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            FileInputStream fileInputStream = null;
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return 0L;
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    long available = fileInputStream2.available();
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return available;
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return 0L;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeL.longValue;
        }
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Base64.encodeToString(str.getBytes("UTF-8"), 2);
                } catch (UnsupportedEncodingException e2) {
                    SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e2.getMessage());
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0207 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, Uri uri) {
        InterceptResult invokeLL;
        Cursor cursor;
        FileOutputStream fileOutputStream;
        ParcelFileDescriptor parcelFileDescriptor;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, uri)) == null) {
            FileInputStream fileInputStream2 = null;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        SLog.e("openSDK_LOG.Util", "queryAbsolutePath error : " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        try {
                            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                            try {
                                fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
                                try {
                                    File h = h(context, "Images");
                                    if (h == null) {
                                        SLog.e("openSDK_LOG.Util", "getExternalFilesDir return null");
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                            SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e3.getMessage());
                                        }
                                        if (parcelFileDescriptor != null) {
                                            try {
                                                parcelFileDescriptor.close();
                                            } catch (IOException e4) {
                                                SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e4.getMessage());
                                            }
                                        }
                                        return null;
                                    }
                                    if (!h.exists()) {
                                        h.mkdirs();
                                    }
                                    File file = new File(h, uri.getLastPathSegment());
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        byte[] bArr = new byte[2048];
                                        while (true) {
                                            int read = fileInputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream2.write(bArr, 0, read);
                                        }
                                        fileOutputStream2.flush();
                                        String absolutePath = file.getAbsolutePath();
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e5) {
                                            SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e5.getMessage());
                                        }
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e6) {
                                            SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e6.getMessage());
                                        }
                                        if (parcelFileDescriptor != null) {
                                            try {
                                                parcelFileDescriptor.close();
                                            } catch (IOException e7) {
                                                SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e7.getMessage());
                                            }
                                        }
                                        return absolutePath;
                                    } catch (Exception e8) {
                                        fileOutputStream = fileOutputStream2;
                                        e = e8;
                                        try {
                                            SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e.getMessage());
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (IOException e9) {
                                                    SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e9.getMessage());
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e10) {
                                                    SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e10.getMessage());
                                                }
                                            }
                                            if (parcelFileDescriptor != null) {
                                                try {
                                                    parcelFileDescriptor.close();
                                                } catch (IOException e11) {
                                                    SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e11.getMessage());
                                                }
                                            }
                                            return null;
                                        } catch (Throwable th) {
                                            th = th;
                                            fileInputStream2 = fileInputStream;
                                            if (fileInputStream2 != null) {
                                                try {
                                                    fileInputStream2.close();
                                                } catch (IOException e12) {
                                                    SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e12.getMessage());
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e13) {
                                                    SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e13.getMessage());
                                                }
                                            }
                                            if (parcelFileDescriptor != null) {
                                                try {
                                                    parcelFileDescriptor.close();
                                                } catch (IOException e14) {
                                                    SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e14.getMessage());
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        fileInputStream2 = fileInputStream;
                                        fileOutputStream = fileOutputStream2;
                                        th = th2;
                                        if (fileInputStream2 != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        if (parcelFileDescriptor != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Exception e15) {
                                    e = e15;
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = null;
                                    fileInputStream2 = fileInputStream;
                                    if (fileInputStream2 != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    if (parcelFileDescriptor != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                fileOutputStream = null;
                                fileInputStream = null;
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = null;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            fileOutputStream = null;
                            parcelFileDescriptor = null;
                            fileInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = null;
                            parcelFileDescriptor = null;
                        }
                    }
                }
                return null;
            } catch (Exception e18) {
                e = e18;
                cursor = null;
            }
        } else {
            return (String) invokeLL.objValue;
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.isConnectedOrConnecting()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        double d2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                d2 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
            } catch (Throwable unused) {
                d2 = 0.0d;
            }
            if (d2 > 6.5d) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, str)) == null) {
            if (context == null) {
                return "";
            }
            b(context, str);
            return b;
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, context, str)) == null) {
            if (context == null) {
                return "";
            }
            b(context, str);
            return a;
        }
        return (String) invokeLL.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, context, str)) == null) {
            if (context == null) {
                return "";
            }
            String d2 = d(context, str);
            c = d2;
            return d2;
        }
        return (String) invokeLL.objValue;
    }

    public static File h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                File[] externalFilesDirs = context.getExternalFilesDirs(str);
                if (externalFilesDirs == null || externalFilesDirs.length <= 0) {
                    return null;
                }
                return externalFilesDirs[0];
            }
            return context.getExternalFilesDir(str);
        }
        return (File) invokeLL.objValue;
    }

    public static JSONObject d(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            if (str.equals("false")) {
                str = "{value : false}";
            }
            if (str.equals("true")) {
                str = "{value : true}";
            }
            if (str.contains("allback(")) {
                str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
            }
            if (str.contains("online[0]=")) {
                str = "{online:" + str.charAt(str.length() - 2) + "}";
            }
            return new JSONObject(str);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(i(str));
                byte[] digest = messageDigest.digest();
                if (digest != null) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        sb.append(a(b2 >>> 4));
                        sb.append(a(b2));
                    }
                    return sb.toString();
                }
                return str;
            } catch (NoSuchAlgorithmException e2) {
                SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
                String str = packageInfo.versionName;
                if (i.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(signatureArr[0].toByteArray());
                        String a2 = a(messageDigest.digest());
                        messageDigest.reset();
                        if (a2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                            return true;
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            if (str != null && str.length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
