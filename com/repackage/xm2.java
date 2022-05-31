package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xm2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static ArrayList<MediaModel> a = null;
    public static String b = "album";
    public static int c = 9;
    public static String d = "single";
    public static boolean e = false;
    public static String f = null;
    public static int g = 0;
    public static boolean h = true;
    public static boolean i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cn2 a;

        public a(cn2 cn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cn2Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                uk2.U().c();
                if (i != -1) {
                    if (i == 0) {
                        this.a.d("选择文件失败：用户取消操作");
                        return true;
                    }
                    return true;
                } else if (intent == null) {
                    this.a.d("choose: Selected data is null");
                    return true;
                } else {
                    this.a.f(intent.getParcelableArrayListExtra("mediaModels"));
                    return true;
                }
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements dn2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public b(Activity activity) {
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
            this.a = activity;
        }

        @Override // com.repackage.dn2
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) && z && (obj instanceof ArrayList)) {
                ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                if (wm2.a) {
                    Iterator<? extends Parcelable> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("SwanAppChooseHelper", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                    }
                }
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("mediaModels", arrayList);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755166860, "Lcom/repackage/xm2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755166860, "Lcom/repackage/xm2;");
        }
    }

    public static void a() {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (arrayList = a) == null) {
            return;
        }
        arrayList.clear();
        a = null;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 70760763) {
                if (str.equals("Image")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 92896879) {
                if (hashCode == 112202875 && str.equals("video")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("album")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            int i2 = R.string.obfuscated_res_0x7f0f1293;
            if (c2 == 0) {
                i2 = R.string.obfuscated_res_0x7f0f1292;
            } else if (c2 == 1) {
                i2 = R.string.obfuscated_res_0x7f0f1294;
            }
            return context.getResources().getString(i2);
        }
        return (String) invokeLL.objValue;
    }

    public static ArrayList<MediaModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : (ArrayList) invokeV.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            String str2 = options.outMimeType;
            return !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("image/gif");
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            float f2 = options.outWidth;
            float f3 = options.outHeight;
            if (!d(str)) {
                float f4 = wm2.c;
                if (f2 > f4 && f3 > f4) {
                    float f5 = f2 / f3;
                    float f6 = wm2.b;
                    return f5 > f6 || 1.0f / f5 > f6;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str, MediaModel mediaModel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, mediaModel)) == null) {
            if (ym2.d() < c || ym2.g(mediaModel)) {
                return TextUtils.equals(str, "single") && ym2.d() > 0 && !TextUtils.equals(ym2.b(), mediaModel.getType());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void g(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, activity, bundle) == null) {
            if (wm2.a) {
                Log.d("SwanAppChooseHelper", "selectCompleted");
            }
            if (ym2.d() <= 0) {
                return;
            }
            oi2.k().a(activity, bundle, new b(activity));
        }
    }

    public static void h(Activity activity, Bundle bundle, dn2 dn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, bundle, dn2Var) == null) {
            if (wm2.a) {
                Log.d("SwanAppChooseHelper", "selectCompleted");
            }
            if (ym2.d() <= 0) {
                return;
            }
            oi2.k().a(activity, bundle, dn2Var);
        }
    }

    public static void i(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, arrayList) == null) {
            if (a == null) {
                a = new ArrayList<>();
            }
            a.clear();
            a.addAll(arrayList);
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || ym2.d() == 0) {
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        String string = appContext.getString(R.string.obfuscated_res_0x7f0f12a0, Integer.valueOf(c));
        if (TextUtils.equals(str, "single")) {
            if (ym2.e().get(0) instanceof ImageModel) {
                string = appContext.getString(R.string.obfuscated_res_0x7f0f12a1, Integer.valueOf(c));
            } else {
                string = appContext.getString(R.string.obfuscated_res_0x7f0f12a2, Integer.valueOf(c));
            }
        } else if (TextUtils.equals(str, ShareDirectionType.BOTH)) {
            string = appContext.getString(R.string.obfuscated_res_0x7f0f12a0, Integer.valueOf(c));
        }
        zy2.g(appContext, string).G();
    }

    public static void k(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, activity, bundle) == null) {
            Intent intent = new Intent(activity, SwanAppAlbumPreviewActivity.class);
            intent.putExtra("launchParams", bundle);
            activity.startActivityForResult(intent, 32770);
            activity.overridePendingTransition(R.anim.obfuscated_res_0x7f010131, R.anim.obfuscated_res_0x7f01001c);
        }
    }

    public static void l(Context context, Bundle bundle, cn2 cn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, bundle, cn2Var) == null) {
            Intent intent = new Intent(context, SwanAppAlbumActivity.class);
            intent.putExtra("launchParams", bundle);
            if (!(context instanceof ActivityResultDispatcherHolder)) {
                cn2Var.d("choose: context error");
                return;
            }
            ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
            if (resultDispatcher == null) {
                cn2Var.d("choose: ActivityResultDispatcher null");
                return;
            }
            resultDispatcher.addConsumer(new a(cn2Var));
            uk2.U().p();
            resultDispatcher.startActivityForResult(intent);
            ((Activity) context).overridePendingTransition(R.anim.obfuscated_res_0x7f010135, 0);
        }
    }

    public static JSONObject m(List<MediaModel> list, hz2 hz2Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, list, hz2Var, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                for (MediaModel mediaModel : list) {
                    if (mediaModel != null) {
                        String str2 = null;
                        if (hz2Var.v0()) {
                            wg1 m = pi2.m();
                            if (m != null) {
                                str2 = m.h(mediaModel.getTempPath());
                            }
                        } else {
                            str2 = p63.J(mediaModel.getTempPath(), hz2Var.b);
                        }
                        jSONArray.put(str2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("path", str2);
                        if (TextUtils.equals("album", str)) {
                            jSONObject2.put("type", mediaModel.getType());
                        }
                        jSONObject2.put("size", mediaModel.getSize());
                        if (mediaModel instanceof VideoModel) {
                            VideoModel videoModel = (VideoModel) mediaModel;
                            jSONObject2.put("duration", videoModel.getDuration());
                            jSONObject2.put("height", videoModel.getHeight());
                            jSONObject2.put("width", videoModel.getWidth());
                        }
                        jSONArray2.put(jSONObject2);
                    }
                }
                jSONObject.put("tempFilePaths", jSONArray);
                jSONObject.put("tempFiles", jSONArray2);
            } catch (JSONException e2) {
                if (wm2.a) {
                    e2.printStackTrace();
                }
            }
            if (wm2.a) {
                Log.d("SwanAppChooseHelper", jSONObject.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static JSONObject n(List<MediaModel> list, hz2 hz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, list, hz2Var)) == null) {
            String str = null;
            if (list == null || !(list.get(0) instanceof VideoModel)) {
                return null;
            }
            VideoModel videoModel = (VideoModel) list.get(0);
            if (hz2Var.v0()) {
                wg1 m = pi2.m();
                if (m != null) {
                    str = m.h(videoModel.getTempPath());
                }
            } else {
                str = p63.J(videoModel.getTempPath(), hz2Var.b);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempFilePath", str);
                jSONObject.put("duration", videoModel.getDuration() / 1000);
                jSONObject.put("height", videoModel.getHeight());
                jSONObject.put("width", videoModel.getWidth());
                jSONObject.put("size", videoModel.getSize());
            } catch (JSONException e2) {
                if (wm2.a) {
                    e2.printStackTrace();
                }
            }
            if (wm2.a) {
                Log.d("SwanAppChooseHelper", jSONObject.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
