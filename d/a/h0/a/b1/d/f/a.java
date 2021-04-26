package d.a.h0.a.b1.d.f;

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
import d.a.h0.a.b1.d.c.c;
import d.a.h0.a.b1.d.c.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f41447i = {"image/jpeg", "image/png", "image/gif"};

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.h0.a.b1.d.e.a> f41448e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f41449f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public String f41450g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f41451h;

    public a(String str, Handler handler) {
        this.f41450g = str;
        this.f41451h = handler;
    }

    public final void a() {
        String[] strArr;
        if (TextUtils.equals(this.f41450g, "video")) {
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
        String[] strArr2 = f41447i;
        String[] strArr3 = {strArr2[0], strArr2[1]};
        if (c.f41425d) {
            sb.append(" or ");
            sb.append("mime_type");
            sb.append("=?");
            strArr = f41447i;
        } else {
            strArr = strArr3;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(uri, null, sb.toString(), strArr, "date_added DESC");
            } catch (Exception e2) {
                if (c.f41422a) {
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
                if (file.exists() && (c.f41425d || !d.d(string))) {
                    ImageModel imageModel = new ImageModel(string);
                    imageModel.f(j);
                    imageModel.g(j2);
                    d(file, imageModel);
                }
            }
        } finally {
            d.a.h0.p.d.a(null);
        }
    }

    public final void b() {
        if (TextUtils.equals(this.f41450g, "Image")) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
            } catch (Exception e2) {
                if (c.f41422a) {
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
            d.a.h0.p.d.a(null);
        }
    }

    public final void c(ArrayList<d.a.h0.a.b1.d.e.a> arrayList) {
        Iterator<d.a.h0.a.b1.d.e.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.h0.a.b1.d.e.a next = it.next();
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
        d.a.h0.a.b1.d.e.a aVar = new d.a.h0.a.b1.d.e.a();
        aVar.h(name);
        aVar.g(path);
        int indexOf = this.f41448e.indexOf(aVar);
        if (indexOf >= 0) {
            this.f41448e.get(indexOf).a(mediaModel);
        } else {
            aVar.a(mediaModel);
            this.f41448e.add(aVar);
        }
        this.f41449f.add(mediaModel);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        b();
        c(this.f41448e);
        d.a.h0.a.b1.d.e.a aVar = new d.a.h0.a.b1.d.e.a();
        aVar.h(d.b(AppRuntime.getAppContext(), this.f41450g));
        aVar.f41446h = this.f41449f;
        this.f41448e.add(0, aVar);
        Iterator<d.a.h0.a.b1.d.e.a> it = this.f41448e.iterator();
        while (it.hasNext()) {
            Collections.sort(it.next().f());
        }
        Handler handler = this.f41451h;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(0);
            obtainMessage.obj = this.f41448e;
            this.f41451h.sendMessage(obtainMessage);
        }
    }
}
