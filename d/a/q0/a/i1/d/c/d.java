package d.a.q0.a.i1.d.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h;
import d.a.q0.a.p.b.a.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<MediaModel> f48801a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f48802b = "album";

    /* renamed from: c  reason: collision with root package name */
    public static int f48803c = 9;

    /* renamed from: d  reason: collision with root package name */
    public static String f48804d = "single";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f48805e = false;

    /* renamed from: f  reason: collision with root package name */
    public static String f48806f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f48807g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f48808h = true;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f48809i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.d.c f48810a;

        public a(d.a.q0.a.i1.d.d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48810a = cVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i2, intent)) == null) {
                d.a.q0.a.g1.f.V().b();
                if (i2 != -1) {
                    if (i2 == 0) {
                        this.f48810a.e("选择文件失败：用户取消操作");
                        return true;
                    }
                    return true;
                } else if (intent == null) {
                    this.f48810a.e("choose: Selected data is null");
                    return true;
                } else {
                    this.f48810a.f(intent.getParcelableArrayListExtra("mediaModels"));
                    return true;
                }
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements d.a.q0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f48811a;

        public b(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48811a = activity;
        }

        @Override // d.a.q0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) && z && (obj instanceof ArrayList)) {
                ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                if (c.f48797a) {
                    Iterator<? extends Parcelable> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("SwanAppChooseHelper", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                    }
                }
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("mediaModels", arrayList);
                this.f48811a.setResult(-1, intent);
                this.f48811a.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-849383940, "Ld/a/q0/a/i1/d/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-849383940, "Ld/a/q0/a/i1/d/c/d;");
        }
    }

    public static void a() {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (arrayList = f48801a) == null) {
            return;
        }
        arrayList.clear();
        f48801a = null;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        char c2;
        int i2;
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
            if (c2 == 0) {
                i2 = h.swanapp_album_all_images;
            } else if (c2 == 1) {
                i2 = h.swanapp_album_all_videos;
            } else if (c2 != 2) {
                i2 = h.swanapp_album_all_media;
            } else {
                i2 = h.swanapp_album_all_media;
            }
            return context.getResources().getString(i2);
        }
        return (String) invokeLL.objValue;
    }

    public static ArrayList<MediaModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f48801a : (ArrayList) invokeV.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            float f2 = options.outWidth;
            float f3 = options.outHeight;
            if (!d(str)) {
                float f4 = c.f48799c;
                if (f2 > f4 && f3 > f4) {
                    float f5 = f2 / f3;
                    float f6 = c.f48798b;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, mediaModel)) == null) {
            if (e.d() < f48803c || e.g(mediaModel)) {
                return TextUtils.equals(str, "single") && e.d() > 0 && !TextUtils.equals(e.b(), mediaModel.getType());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void g(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, activity, bundle) == null) {
            if (c.f48797a) {
                Log.d("SwanAppChooseHelper", "selectCompleted");
            }
            if (e.d() <= 0) {
                return;
            }
            d.a.q0.a.c1.a.j().a(activity, bundle, new b(activity));
        }
    }

    public static void h(Activity activity, Bundle bundle, d.a.q0.a.i1.d.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, bundle, dVar) == null) {
            if (c.f48797a) {
                Log.d("SwanAppChooseHelper", "selectCompleted");
            }
            if (e.d() <= 0) {
                return;
            }
            d.a.q0.a.c1.a.j().a(activity, bundle, dVar);
        }
    }

    public static void i(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, arrayList) == null) {
            if (f48801a == null) {
                f48801a = new ArrayList<>();
            }
            f48801a.clear();
            f48801a.addAll(arrayList);
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || e.d() == 0) {
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        String string = appContext.getString(h.swanapp_album_selected_max_files, Integer.valueOf(f48803c));
        if (TextUtils.equals(str, "single")) {
            if (e.e().get(0) instanceof ImageModel) {
                string = appContext.getString(h.swanapp_album_selected_max_photos, Integer.valueOf(f48803c));
            } else {
                string = appContext.getString(h.swanapp_album_selected_max_videos, Integer.valueOf(f48803c));
            }
        } else if (TextUtils.equals(str, ShareDirectionType.BOTH)) {
            string = appContext.getString(h.swanapp_album_selected_max_files, Integer.valueOf(f48803c));
        }
        d.a.q0.a.z1.b.f.e.g(appContext, string).F();
    }

    public static void k(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, activity, bundle) == null) {
            Intent intent = new Intent(activity, SwanAppAlbumPreviewActivity.class);
            intent.putExtra("launchParams", bundle);
            activity.startActivityForResult(intent, 32770);
            activity.overridePendingTransition(d.a.q0.a.a.swanapp_album_preview_enter, d.a.q0.a.a.aiapps_hold);
        }
    }

    public static void l(Context context, Bundle bundle, d.a.q0.a.i1.d.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, bundle, cVar) == null) {
            Intent intent = new Intent(context, SwanAppAlbumActivity.class);
            intent.putExtra("launchParams", bundle);
            if (!(context instanceof ActivityResultDispatcherHolder)) {
                cVar.e("choose: context error");
                return;
            }
            ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
            if (resultDispatcher == null) {
                cVar.e("choose: ActivityResultDispatcher null");
                return;
            }
            resultDispatcher.addConsumer(new a(cVar));
            d.a.q0.a.g1.f.V().p();
            resultDispatcher.startActivityForResult(intent);
            ((Activity) context).overridePendingTransition(d.a.q0.a.a.swanapp_album_slide_bottom_in, 0);
        }
    }

    public static JSONObject m(List<MediaModel> list, d.a.q0.a.a2.e eVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, list, eVar, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                for (MediaModel mediaModel : list) {
                    if (mediaModel != null) {
                        String str2 = null;
                        if (eVar.m0()) {
                            l m = d.a.q0.a.c1.b.m();
                            if (m != null) {
                                str2 = m.h(mediaModel.getTempPath());
                            }
                        } else {
                            str2 = d.a.q0.a.k2.b.J(mediaModel.getTempPath(), eVar.f46683f);
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
                if (c.f48797a) {
                    e2.printStackTrace();
                }
            }
            if (c.f48797a) {
                Log.d("SwanAppChooseHelper", jSONObject.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static JSONObject n(List<MediaModel> list, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, list, eVar)) == null) {
            String str = null;
            if (list == null || !(list.get(0) instanceof VideoModel)) {
                return null;
            }
            VideoModel videoModel = (VideoModel) list.get(0);
            if (eVar.m0()) {
                l m = d.a.q0.a.c1.b.m();
                if (m != null) {
                    str = m.h(videoModel.getTempPath());
                }
            } else {
                str = d.a.q0.a.k2.b.J(videoModel.getTempPath(), eVar.f46683f);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempFilePath", str);
                jSONObject.put("duration", videoModel.getDuration() / 1000);
                jSONObject.put("height", videoModel.getHeight());
                jSONObject.put("width", videoModel.getWidth());
                jSONObject.put("size", videoModel.getSize());
            } catch (JSONException e2) {
                if (c.f48797a) {
                    e2.printStackTrace();
                }
            }
            if (c.f48797a) {
                Log.d("SwanAppChooseHelper", jSONObject.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
