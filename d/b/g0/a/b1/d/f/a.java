package d.b.g0.a.b1.d.f;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import d.b.g0.a.b1.d.c.c;
import d.b.g0.a.b1.d.c.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a implements Runnable {
    public static final String[] i = {"image/jpeg", "image/png", "image/gif"};

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.b.g0.a.b1.d.e.a> f43449e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f43450f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public String f43451g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f43452h;

    public a(String str, Handler handler) {
        this.f43451g = str;
        this.f43452h = handler;
    }

    public final void a() {
        String[] strArr;
        if (TextUtils.equals(this.f43451g, "video")) {
            return;
        }
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = AppRuntime.getAppContext().getContentResolver();
        StringBuilder sb = new StringBuilder();
        sb.append("mime_type");
        sb.append("=?");
        sb.append(" or ");
        sb.append("mime_type");
        sb.append("=?");
        String[] strArr2 = i;
        String[] strArr3 = {strArr2[0], strArr2[1]};
        if (c.f43428d) {
            sb.append(" or ");
            sb.append("mime_type");
            sb.append("=?");
            strArr = i;
        } else {
            strArr = strArr3;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(uri, null, sb.toString(), strArr, "date_added DESC");
            } catch (Exception e2) {
                if (c.f43425a) {
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
                if (file.exists() && (c.f43428d || !d.d(string))) {
                    ImageModel imageModel = new ImageModel(string);
                    imageModel.f(j);
                    imageModel.g(j2);
                    d(file, imageModel);
                }
            }
        } finally {
            d.b.g0.p.d.a(null);
        }
    }

    public final void b() {
        if (TextUtils.equals(this.f43451g, "Image")) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
            } catch (Exception e2) {
                if (c.f43425a) {
                    e2.printStackTrace();
                }
            }
            if (cursor == null) {
                return;
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                long j2 = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
                long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("width"));
                int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("height"));
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
            }
        } finally {
            d.b.g0.p.d.a(null);
        }
    }

    public final void c(ArrayList<d.b.g0.a.b1.d.e.a> arrayList) {
        Iterator<d.b.g0.a.b1.d.e.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.b.g0.a.b1.d.e.a next = it.next();
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
        d.b.g0.a.b1.d.e.a aVar = new d.b.g0.a.b1.d.e.a();
        aVar.h(name);
        aVar.g(path);
        int indexOf = this.f43449e.indexOf(aVar);
        if (indexOf >= 0) {
            this.f43449e.get(indexOf).a(mediaModel);
        } else {
            aVar.a(mediaModel);
            this.f43449e.add(aVar);
        }
        this.f43450f.add(mediaModel);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        b();
        c(this.f43449e);
        d.b.g0.a.b1.d.e.a aVar = new d.b.g0.a.b1.d.e.a();
        aVar.h(d.b(AppRuntime.getAppContext(), this.f43451g));
        aVar.f43448h = this.f43450f;
        this.f43449e.add(0, aVar);
        Iterator<d.b.g0.a.b1.d.e.a> it = this.f43449e.iterator();
        while (it.hasNext()) {
            Collections.sort(it.next().f());
        }
        Handler handler = this.f43452h;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(0);
            obtainMessage.obj = this.f43449e;
            this.f43452h.sendMessage(obtainMessage);
        }
    }
}
