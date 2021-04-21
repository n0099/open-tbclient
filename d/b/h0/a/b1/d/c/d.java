package d.b.h0.a.b1.d.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import d.b.h0.a.h;
import d.b.h0.g.l.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<MediaModel> f44151a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f44152b = "album";

    /* renamed from: c  reason: collision with root package name */
    public static int f44153c = 9;

    /* renamed from: d  reason: collision with root package name */
    public static String f44154d = "single";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44155e = false;

    /* renamed from: f  reason: collision with root package name */
    public static String f44156f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f44157g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f44158h = true;
    public static boolean i = false;
    public static String j;

    /* loaded from: classes2.dex */
    public static class a implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.b1.d.d.c f44159a;

        public a(d.b.h0.a.b1.d.d.c cVar) {
            this.f44159a = cVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            d.b.h0.a.z0.f.V().f();
            if (i != -1) {
                if (i == 0) {
                    this.f44159a.a("选择文件失败：用户取消操作");
                    return true;
                }
                return true;
            } else if (intent == null) {
                this.f44159a.a("choose: Selected data is null");
                return true;
            } else {
                this.f44159a.b(intent.getParcelableArrayListExtra("mediaModels"));
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.b.h0.a.b1.d.d.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f44160a;

        public b(Activity activity) {
            this.f44160a = activity;
        }

        @Override // d.b.h0.a.b1.d.d.d
        public void a(boolean z, String str, Object obj) {
            if (z && (obj instanceof ArrayList)) {
                ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                if (c.f44147a) {
                    Iterator<? extends Parcelable> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.d("SwanAppChooseHelper", "tempPath = " + ((MediaModel) it.next()).d());
                    }
                }
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("mediaModels", arrayList);
                this.f44160a.setResult(-1, intent);
                this.f44160a.finish();
            }
        }
    }

    public static void a() {
        ArrayList<MediaModel> arrayList = f44151a;
        if (arrayList != null) {
            arrayList.clear();
            f44151a = null;
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
        return f44151a;
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
            float f4 = c.f44149c;
            if (f2 > f4 && f3 > f4) {
                float f5 = f2 / f3;
                float f6 = c.f44148b;
                return f5 > f6 || 1.0f / f5 > f6;
            }
        }
        return false;
    }

    public static boolean f(String str, MediaModel mediaModel) {
        if (e.d() < f44153c || e.g(mediaModel)) {
            return TextUtils.equals(str, "single") && e.d() > 0 && !TextUtils.equals(e.b(), mediaModel.e());
        }
        return true;
    }

    public static void g(Activity activity, Bundle bundle) {
        if (c.f44147a) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.d() <= 0) {
            return;
        }
        d.b.h0.a.w0.a.i().a(activity, bundle, new b(activity));
    }

    public static void h(Activity activity, Bundle bundle, d.b.h0.a.b1.d.d.d dVar) {
        if (c.f44147a) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.d() <= 0) {
            return;
        }
        d.b.h0.a.w0.a.i().a(activity, bundle, dVar);
    }

    public static void i(ArrayList<MediaModel> arrayList) {
        if (f44151a == null) {
            f44151a = new ArrayList<>();
        }
        f44151a.clear();
        f44151a.addAll(arrayList);
    }

    public static void j(String str) {
        if (e.d() == 0) {
            return;
        }
        Context appContext = AppRuntime.getAppContext();
        String string = appContext.getString(h.swanapp_album_selected_max_files, Integer.valueOf(f44153c));
        if (TextUtils.equals(str, "single")) {
            if (e.e().get(0) instanceof ImageModel) {
                string = appContext.getString(h.swanapp_album_selected_max_photos, Integer.valueOf(f44153c));
            } else {
                string = appContext.getString(h.swanapp_album_selected_max_videos, Integer.valueOf(f44153c));
            }
        } else if (TextUtils.equals(str, com.baidu.sapi2.utils.enums.a.f11084c)) {
            string = appContext.getString(h.swanapp_album_selected_max_files, Integer.valueOf(f44153c));
        }
        d.b.h0.a.q1.b.f.d.f(appContext, string).C();
    }

    public static void k(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, SwanAppAlbumPreviewActivity.class);
        intent.putExtra("launchParams", bundle);
        activity.startActivityForResult(intent, 32770);
        activity.overridePendingTransition(d.b.h0.a.a.swanapp_album_preview_enter, d.b.h0.a.a.aiapps_hold);
    }

    public static void l(Context context, Bundle bundle, d.b.h0.a.b1.d.d.c cVar) {
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
        d.b.h0.a.z0.f.V().D();
        resultDispatcher.startActivityForResult(intent);
        ((Activity) context).overridePendingTransition(d.b.h0.a.a.swanapp_album_slide_bottom_in, 0);
    }

    public static JSONObject m(List<MediaModel> list, d.b.h0.a.r1.e eVar, String str) {
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
                        r = d.b.h0.a.a2.b.r(mediaModel.d(), eVar.f46461f);
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
            if (c.f44147a) {
                e2.printStackTrace();
            }
        }
        if (c.f44147a) {
            Log.d("SwanAppChooseHelper", jSONObject.toString());
        }
        return jSONObject;
    }

    public static JSONObject n(List<MediaModel> list, d.b.h0.a.r1.e eVar) {
        String r;
        if (list == null || !(list.get(0) instanceof VideoModel)) {
            return null;
        }
        VideoModel videoModel = (VideoModel) list.get(0);
        if (eVar.i0()) {
            r = n.V(videoModel.d());
        } else {
            r = d.b.h0.a.a2.b.r(videoModel.d(), eVar.f46461f);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tempFilePath", r);
            jSONObject.put("duration", videoModel.j() / 1000);
            jSONObject.put("height", videoModel.k());
            jSONObject.put("width", videoModel.l());
            jSONObject.put("size", videoModel.c());
        } catch (JSONException e2) {
            if (c.f44147a) {
                e2.printStackTrace();
            }
        }
        if (c.f44147a) {
            Log.d("SwanAppChooseHelper", jSONObject.toString());
        }
        return jSONObject;
    }
}
