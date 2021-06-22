package d.a.m0.a.i1.d.g;

import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import d.a.m0.a.i1.d.c.c;
import d.a.m0.a.i1.d.c.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.m0.a.i1.d.f.a> f46676e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f46677f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public String f46678g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f46679h;

    public a(String str, Handler handler) {
        this.f46678g = str;
        this.f46679h = handler;
    }

    public final void a() {
        if (TextUtils.equals(this.f46678g, "video")) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
            } catch (Exception e2) {
                if (c.f46647a) {
                    e2.printStackTrace();
                }
            }
            if (cursor == null) {
                return;
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("_data"));
                long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                File file = new File(string);
                if (file.exists() && (c.f46650d || !d.d(string))) {
                    ImageModel imageModel = new ImageModel(string);
                    imageModel.f(j);
                    imageModel.g(j2);
                    d(file, imageModel);
                }
            }
        } finally {
            d.a.m0.t.d.d(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x009b, code lost:
        if (r11 != null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        Cursor cursor;
        Throwable th;
        Exception e2;
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th2;
        if (TextUtils.equals(this.f46678g, "Image")) {
            return;
        }
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
        } catch (Exception e3) {
            cursor = null;
            e2 = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            d.a.m0.t.d.d(cursor);
            throw th;
        }
        if (cursor == null) {
            d.a.m0.t.d.d(cursor);
            return;
        }
        while (cursor.moveToNext()) {
            try {
                try {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                    long j2 = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
                    long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                    int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("width"));
                    int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("height"));
                    if (i2 <= 0 || i3 <= 0) {
                        try {
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                try {
                                    mediaMetadataRetriever.setDataSource(string);
                                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                    i2 = Integer.parseInt(extractMetadata);
                                    i3 = Integer.parseInt(extractMetadata2);
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                    throw th2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                if (c.f46647a) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            mediaMetadataRetriever = null;
                        } catch (Throwable th5) {
                            mediaMetadataRetriever = null;
                            th2 = th5;
                        }
                        mediaMetadataRetriever.release();
                    }
                    File file = new File(string);
                    if (file.exists()) {
                        VideoModel videoModel = new VideoModel(string);
                        videoModel.f(j);
                        videoModel.m(j2);
                        videoModel.g(j3);
                        videoModel.o(i2);
                        videoModel.n(i3);
                        d(file, videoModel);
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    if (c.f46647a) {
                        e2.printStackTrace();
                    }
                    d.a.m0.t.d.d(cursor);
                }
            } catch (Throwable th6) {
                th = th6;
                d.a.m0.t.d.d(cursor);
                throw th;
            }
        }
        d.a.m0.t.d.d(cursor);
    }

    public final void c(ArrayList<d.a.m0.a.i1.d.f.a> arrayList) {
        Iterator<d.a.m0.a.i1.d.f.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.m0.a.i1.d.f.a next = it.next();
            next.i(new File(next.b()).lastModified());
        }
        Collections.sort(arrayList);
    }

    public final void d(File file, MediaModel mediaModel) {
        String name;
        String path;
        if (file.getParentFile() != null) {
            name = file.getParentFile().getName();
            path = file.getParent();
        } else {
            name = file.getName();
            path = file.getPath();
        }
        d.a.m0.a.i1.d.f.a aVar = new d.a.m0.a.i1.d.f.a();
        aVar.h(name);
        aVar.g(path);
        int indexOf = this.f46676e.indexOf(aVar);
        if (indexOf >= 0) {
            this.f46676e.get(indexOf).a(mediaModel);
        } else {
            aVar.a(mediaModel);
            this.f46676e.add(aVar);
        }
        this.f46677f.add(mediaModel);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        b();
        c(this.f46676e);
        d.a.m0.a.i1.d.f.a aVar = new d.a.m0.a.i1.d.f.a();
        aVar.h(d.b(AppRuntime.getAppContext(), this.f46678g));
        aVar.f46675h = this.f46677f;
        this.f46676e.add(0, aVar);
        Iterator<d.a.m0.a.i1.d.f.a> it = this.f46676e.iterator();
        while (it.hasNext()) {
            Collections.sort(it.next().f());
        }
        Handler handler = this.f46679h;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(0);
            obtainMessage.obj = this.f46676e;
            this.f46679h.sendMessage(obtainMessage);
        }
    }
}
