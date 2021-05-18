package d.a.i0.a.i1.d.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
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
import d.a.i0.a.h;
import d.a.i0.a.p.b.a.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<MediaModel> f42693a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f42694b = "album";

    /* renamed from: c  reason: collision with root package name */
    public static int f42695c = 9;

    /* renamed from: d  reason: collision with root package name */
    public static String f42696d = "single";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f42697e = false;

    /* renamed from: f  reason: collision with root package name */
    public static String f42698f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f42699g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f42700h = true;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f42701i = false;
    public static String j;

    /* loaded from: classes3.dex */
    public static class a implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.d.c f42702a;

        public a(d.a.i0.a.i1.d.d.c cVar) {
            this.f42702a = cVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            d.a.i0.a.g1.f.V().b();
            if (i2 != -1) {
                if (i2 == 0) {
                    this.f42702a.e("选择文件失败：用户取消操作");
                    return true;
                }
                return true;
            } else if (intent == null) {
                this.f42702a.e("choose: Selected data is null");
                return true;
            } else {
                this.f42702a.f(intent.getParcelableArrayListExtra("mediaModels"));
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.i0.a.i1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f42703a;

        public b(Activity activity) {
            this.f42703a = activity;
        }

        @Override // d.a.i0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                if (c.f42689a) {
                    Iterator<? extends Parcelable> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("SwanAppChooseHelper", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("mediaModels", arrayList);
                this.f42703a.setResult(-1, intent);
                this.f42703a.finish();
            }
        }
    }

    public static void a() {
        ArrayList<MediaModel> arrayList = f42693a;
        if (arrayList != null) {
            arrayList.clear();
            f42693a = null;
        }
    }

    public static String b(Context context, String str) {
        char c2;
        int i2;
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

    public static ArrayList<MediaModel> c() {
        return f42693a;
    }

    public static boolean d(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        String str2 = options.outMimeType;
        return !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("image/gif");
    }

    public static boolean e(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        float f2 = options.outWidth;
        float f3 = options.outHeight;
        if (!d(str)) {
            float f4 = c.f42691c;
            if (f2 > f4 && f3 > f4) {
                float f5 = f2 / f3;
                float f6 = c.f42690b;
                return f5 > f6 || 1.0f / f5 > f6;
            }
        }
        return false;
    }

    public static boolean f(String str, MediaModel mediaModel) {
        if (e.d() < f42695c || e.g(mediaModel)) {
            return TextUtils.equals(str, "single") && e.d() > 0 && !TextUtils.equals(e.b(), mediaModel.e());
        }
        return true;
    }

    public static void g(Activity activity, Bundle bundle) {
        if (c.f42689a) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.d() <= 0) {
            return;
        }
        d.a.i0.a.c1.a.j().a(activity, bundle, new b(activity));
    }

    public static void h(Activity activity, Bundle bundle, d.a.i0.a.i1.d.d.d dVar) {
        if (c.f42689a) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.d() <= 0) {
            return;
        }
        d.a.i0.a.c1.a.j().a(activity, bundle, dVar);
    }

    public static void i(ArrayList<MediaModel> arrayList) {
        if (f42693a == null) {
            f42693a = new ArrayList<>();
        }
        f42693a.clear();
        f42693a.addAll(arrayList);
    }

    public static void j(String str) {
        if (e.d() == 0) {
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        String string = appContext.getString(h.swanapp_album_selected_max_files, Integer.valueOf(f42695c));
        if (TextUtils.equals(str, "single")) {
            if (e.e().get(0) instanceof ImageModel) {
                string = appContext.getString(h.swanapp_album_selected_max_photos, Integer.valueOf(f42695c));
            } else {
                string = appContext.getString(h.swanapp_album_selected_max_videos, Integer.valueOf(f42695c));
            }
        } else if (TextUtils.equals(str, ShareDirectionType.BOTH)) {
            string = appContext.getString(h.swanapp_album_selected_max_files, Integer.valueOf(f42695c));
        }
        d.a.i0.a.z1.b.f.e.g(appContext, string).F();
    }

    public static void k(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, SwanAppAlbumPreviewActivity.class);
        intent.putExtra("launchParams", bundle);
        activity.startActivityForResult(intent, 32770);
        activity.overridePendingTransition(d.a.i0.a.a.swanapp_album_preview_enter, d.a.i0.a.a.aiapps_hold);
    }

    public static void l(Context context, Bundle bundle, d.a.i0.a.i1.d.d.c cVar) {
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
        d.a.i0.a.g1.f.V().p();
        resultDispatcher.startActivityForResult(intent);
        ((Activity) context).overridePendingTransition(d.a.i0.a.a.swanapp_album_slide_bottom_in, 0);
    }

    public static JSONObject m(List<MediaModel> list, d.a.i0.a.a2.e eVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (MediaModel mediaModel : list) {
                if (mediaModel != null) {
                    String str2 = null;
                    if (eVar.m0()) {
                        l m = d.a.i0.a.c1.b.m();
                        if (m != null) {
                            str2 = m.h(mediaModel.d());
                        }
                    } else {
                        str2 = d.a.i0.a.k2.b.J(mediaModel.d(), eVar.f40575f);
                    }
                    jSONArray.put(str2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("path", str2);
                    if (TextUtils.equals("album", str)) {
                        jSONObject2.put("type", mediaModel.e());
                    }
                    jSONObject2.put("size", mediaModel.c());
                    if (mediaModel instanceof VideoModel) {
                        VideoModel videoModel = (VideoModel) mediaModel;
                        jSONObject2.put("duration", videoModel.j());
                        jSONObject2.put("height", videoModel.k());
                        jSONObject2.put("width", videoModel.l());
                    }
                    jSONArray2.put(jSONObject2);
                }
            }
            jSONObject.put("tempFilePaths", jSONArray);
            jSONObject.put("tempFiles", jSONArray2);
        } catch (JSONException e2) {
            if (c.f42689a) {
                e2.printStackTrace();
            }
        }
        if (c.f42689a) {
            Log.d("SwanAppChooseHelper", jSONObject.toString());
        }
        return jSONObject;
    }

    public static JSONObject n(List<MediaModel> list, d.a.i0.a.a2.e eVar) {
        String str = null;
        if (list == null || !(list.get(0) instanceof VideoModel)) {
            return null;
        }
        VideoModel videoModel = (VideoModel) list.get(0);
        if (eVar.m0()) {
            l m = d.a.i0.a.c1.b.m();
            if (m != null) {
                str = m.h(videoModel.d());
            }
        } else {
            str = d.a.i0.a.k2.b.J(videoModel.d(), eVar.f40575f);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tempFilePath", str);
            jSONObject.put("duration", videoModel.j() / 1000);
            jSONObject.put("height", videoModel.k());
            jSONObject.put("width", videoModel.l());
            jSONObject.put("size", videoModel.c());
        } catch (JSONException e2) {
            if (c.f42689a) {
                e2.printStackTrace();
            }
        }
        if (c.f42689a) {
            Log.d("SwanAppChooseHelper", jSONObject.toString());
        }
        return jSONObject;
    }
}
