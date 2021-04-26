package d.a.h0.a.b1.d.c;

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
import d.a.h0.a.h;
import d.a.h0.g.l.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<MediaModel> f41426a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f41427b = "album";

    /* renamed from: c  reason: collision with root package name */
    public static int f41428c = 9;

    /* renamed from: d  reason: collision with root package name */
    public static String f41429d = "single";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f41430e = false;

    /* renamed from: f  reason: collision with root package name */
    public static String f41431f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f41432g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f41433h = true;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f41434i = false;
    public static String j;

    /* loaded from: classes3.dex */
    public static class a implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b1.d.d.c f41435a;

        public a(d.a.h0.a.b1.d.d.c cVar) {
            this.f41435a = cVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            d.a.h0.a.z0.f.V().d();
            if (i2 != -1) {
                if (i2 == 0) {
                    this.f41435a.a("选择文件失败：用户取消操作");
                    return true;
                }
                return true;
            } else if (intent == null) {
                this.f41435a.a("choose: Selected data is null");
                return true;
            } else {
                this.f41435a.b(intent.getParcelableArrayListExtra("mediaModels"));
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.h0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f41436a;

        public b(Activity activity) {
            this.f41436a = activity;
        }

        @Override // d.a.h0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                if (c.f41422a) {
                    Iterator<? extends Parcelable> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("SwanAppChooseHelper", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("mediaModels", arrayList);
                this.f41436a.setResult(-1, intent);
                this.f41436a.finish();
            }
        }
    }

    public static void a() {
        ArrayList<MediaModel> arrayList = f41426a;
        if (arrayList != null) {
            arrayList.clear();
            f41426a = null;
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
        return f41426a;
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
            float f4 = c.f41424c;
            if (f2 > f4 && f3 > f4) {
                float f5 = f2 / f3;
                float f6 = c.f41423b;
                return f5 > f6 || 1.0f / f5 > f6;
            }
        }
        return false;
    }

    public static boolean f(String str, MediaModel mediaModel) {
        if (e.d() < f41428c || e.g(mediaModel)) {
            return TextUtils.equals(str, "single") && e.d() > 0 && !TextUtils.equals(e.b(), mediaModel.e());
        }
        return true;
    }

    public static void g(Activity activity, Bundle bundle) {
        if (c.f41422a) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.d() <= 0) {
            return;
        }
        d.a.h0.a.w0.a.i().a(activity, bundle, new b(activity));
    }

    public static void h(Activity activity, Bundle bundle, d.a.h0.a.b1.d.d.d dVar) {
        if (c.f41422a) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.d() <= 0) {
            return;
        }
        d.a.h0.a.w0.a.i().a(activity, bundle, dVar);
    }

    public static void i(ArrayList<MediaModel> arrayList) {
        if (f41426a == null) {
            f41426a = new ArrayList<>();
        }
        f41426a.clear();
        f41426a.addAll(arrayList);
    }

    public static void j(String str) {
        if (e.d() == 0) {
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        String string = appContext.getString(h.swanapp_album_selected_max_files, Integer.valueOf(f41428c));
        if (TextUtils.equals(str, "single")) {
            if (e.e().get(0) instanceof ImageModel) {
                string = appContext.getString(h.swanapp_album_selected_max_photos, Integer.valueOf(f41428c));
            } else {
                string = appContext.getString(h.swanapp_album_selected_max_videos, Integer.valueOf(f41428c));
            }
        } else if (TextUtils.equals(str, ShareDirectionType.BOTH)) {
            string = appContext.getString(h.swanapp_album_selected_max_files, Integer.valueOf(f41428c));
        }
        d.a.h0.a.q1.b.f.d.f(appContext, string).C();
    }

    public static void k(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, SwanAppAlbumPreviewActivity.class);
        intent.putExtra("launchParams", bundle);
        activity.startActivityForResult(intent, 32770);
        activity.overridePendingTransition(d.a.h0.a.a.swanapp_album_preview_enter, d.a.h0.a.a.aiapps_hold);
    }

    public static void l(Context context, Bundle bundle, d.a.h0.a.b1.d.d.c cVar) {
        Intent intent = new Intent(context, SwanAppAlbumActivity.class);
        intent.putExtra("launchParams", bundle);
        if (!(context instanceof ActivityResultDispatcherHolder)) {
            cVar.a("choose: context error");
            return;
        }
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
        if (resultDispatcher == null) {
            cVar.a("choose: ActivityResultDispatcher null");
            return;
        }
        resultDispatcher.addConsumer(new a(cVar));
        d.a.h0.a.z0.f.V().r();
        resultDispatcher.startActivityForResult(intent);
        ((Activity) context).overridePendingTransition(d.a.h0.a.a.swanapp_album_slide_bottom_in, 0);
    }

    public static JSONObject m(List<MediaModel> list, d.a.h0.a.r1.e eVar, String str) {
        String r;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (MediaModel mediaModel : list) {
                if (mediaModel != null) {
                    if (eVar.i0()) {
                        r = n.V(mediaModel.d());
                    } else {
                        r = d.a.h0.a.a2.b.r(mediaModel.d(), eVar.f43823f);
                    }
                    jSONArray.put(r);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("path", r);
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
            if (c.f41422a) {
                e2.printStackTrace();
            }
        }
        if (c.f41422a) {
            Log.d("SwanAppChooseHelper", jSONObject.toString());
        }
        return jSONObject;
    }

    public static JSONObject n(List<MediaModel> list, d.a.h0.a.r1.e eVar) {
        String r;
        if (list == null || !(list.get(0) instanceof VideoModel)) {
            return null;
        }
        VideoModel videoModel = (VideoModel) list.get(0);
        if (eVar.i0()) {
            r = n.V(videoModel.d());
        } else {
            r = d.a.h0.a.a2.b.r(videoModel.d(), eVar.f43823f);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tempFilePath", r);
            jSONObject.put("duration", videoModel.j() / 1000);
            jSONObject.put("height", videoModel.k());
            jSONObject.put("width", videoModel.l());
            jSONObject.put("size", videoModel.c());
        } catch (JSONException e2) {
            if (c.f41422a) {
                e2.printStackTrace();
            }
        }
        if (c.f41422a) {
            Log.d("SwanAppChooseHelper", jSONObject.toString());
        }
        return jSONObject;
    }
}
