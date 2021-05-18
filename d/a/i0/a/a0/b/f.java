package d.a.i0.a.a0.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a {
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public String u;
    public float v;

    public f(String str) {
        super(str);
        this.u = "png";
        this.v = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.o = n0.g((float) jSONObject.optDouble("x"));
            this.p = n0.g((float) jSONObject.optDouble("y"));
            this.q = n0.g((float) jSONObject.optDouble("width"));
            this.r = n0.g((float) jSONObject.optDouble("height"));
            this.s = n0.g((float) jSONObject.optDouble("destWidth"));
            this.t = n0.g((float) jSONObject.optDouble("destHeight"));
            this.u = jSONObject.optString("fileType");
            this.v = (float) jSONObject.optDouble("quality");
        } catch (Exception e2) {
            if (k.f43025a) {
                e2.printStackTrace();
            }
        }
    }

    public boolean h() {
        return TextUtils.equals(this.u, "jpg");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041 A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055 A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075 A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078 A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5 A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8 A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c5 A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ce A[Catch: OutOfMemoryError -> 0x00ef, Exception -> 0x00f8, TryCatch #2 {Exception -> 0x00f8, OutOfMemoryError -> 0x00ef, blocks: (B:7:0x000b, B:9:0x0023, B:12:0x0028, B:14:0x002c, B:16:0x0032, B:19:0x0037, B:21:0x003b, B:23:0x0041, B:26:0x0049, B:28:0x004f, B:30:0x0055, B:33:0x005d, B:35:0x0064, B:37:0x006a, B:39:0x006f, B:41:0x0075, B:43:0x007a, B:45:0x00b5, B:47:0x00ba, B:49:0x00c5, B:50:0x00c8, B:52:0x00ce, B:53:0x00d5, B:46:0x00b8, B:42:0x0078, B:38:0x006d, B:34:0x0060, B:27:0x004c), top: B:65:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(View view, String str) {
        int i2;
        int i3;
        int i4;
        int i5;
        File file;
        if (view != null && !TextUtils.isEmpty(str)) {
            try {
                Bitmap y = n0.y(view, view.getWidth(), view.getHeight());
                int width = y.getWidth();
                int height = y.getHeight();
                if (this.o >= 0 && this.o < width) {
                    i2 = this.o;
                    this.o = i2;
                    if (this.p >= 0 && this.p < height) {
                        i3 = this.p;
                        this.p = i3;
                        if (this.q > 0 && this.o + this.q <= width) {
                            i4 = this.q;
                            this.q = i4;
                            if (this.r > 0 && this.p + this.r <= height) {
                                i5 = this.r;
                                this.r = i5;
                                this.s = this.s > 0 ? this.q : this.s;
                                int i6 = this.t > 0 ? this.r : this.t;
                                this.t = i6;
                                Bitmap createBitmap = Bitmap.createBitmap(this.s, i6, y.getConfig());
                                new Canvas(createBitmap).drawBitmap(y, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                                Bitmap.CompressFormat compressFormat = !h() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
                                file = new File(str);
                                if (file.exists()) {
                                    file.delete();
                                }
                                if (file.getParentFile() != null) {
                                    file.getParentFile().mkdirs();
                                }
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                createBitmap.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream);
                                fileOutputStream.flush();
                                d.a.i0.t.d.d(fileOutputStream);
                                return true;
                            }
                            i5 = height - this.p;
                            this.r = i5;
                            this.s = this.s > 0 ? this.q : this.s;
                            if (this.t > 0) {
                            }
                            this.t = i6;
                            Bitmap createBitmap2 = Bitmap.createBitmap(this.s, i6, y.getConfig());
                            new Canvas(createBitmap2).drawBitmap(y, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                            if (!h()) {
                            }
                            file = new File(str);
                            if (file.exists()) {
                            }
                            if (file.getParentFile() != null) {
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            createBitmap2.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream2);
                            fileOutputStream2.flush();
                            d.a.i0.t.d.d(fileOutputStream2);
                            return true;
                        }
                        i4 = width - this.o;
                        this.q = i4;
                        if (this.r > 0) {
                            i5 = this.r;
                            this.r = i5;
                            this.s = this.s > 0 ? this.q : this.s;
                            if (this.t > 0) {
                            }
                            this.t = i6;
                            Bitmap createBitmap22 = Bitmap.createBitmap(this.s, i6, y.getConfig());
                            new Canvas(createBitmap22).drawBitmap(y, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                            if (!h()) {
                            }
                            file = new File(str);
                            if (file.exists()) {
                            }
                            if (file.getParentFile() != null) {
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream22 = new FileOutputStream(file);
                            createBitmap22.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream22);
                            fileOutputStream22.flush();
                            d.a.i0.t.d.d(fileOutputStream22);
                            return true;
                        }
                        i5 = height - this.p;
                        this.r = i5;
                        this.s = this.s > 0 ? this.q : this.s;
                        if (this.t > 0) {
                        }
                        this.t = i6;
                        Bitmap createBitmap222 = Bitmap.createBitmap(this.s, i6, y.getConfig());
                        new Canvas(createBitmap222).drawBitmap(y, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                        if (!h()) {
                        }
                        file = new File(str);
                        if (file.exists()) {
                        }
                        if (file.getParentFile() != null) {
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream222 = new FileOutputStream(file);
                        createBitmap222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream222);
                        fileOutputStream222.flush();
                        d.a.i0.t.d.d(fileOutputStream222);
                        return true;
                    }
                    i3 = 0;
                    this.p = i3;
                    if (this.q > 0) {
                        i4 = this.q;
                        this.q = i4;
                        if (this.r > 0) {
                        }
                        i5 = height - this.p;
                        this.r = i5;
                        this.s = this.s > 0 ? this.q : this.s;
                        if (this.t > 0) {
                        }
                        this.t = i6;
                        Bitmap createBitmap2222 = Bitmap.createBitmap(this.s, i6, y.getConfig());
                        new Canvas(createBitmap2222).drawBitmap(y, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                        if (!h()) {
                        }
                        file = new File(str);
                        if (file.exists()) {
                        }
                        if (file.getParentFile() != null) {
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream2222 = new FileOutputStream(file);
                        createBitmap2222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream2222);
                        fileOutputStream2222.flush();
                        d.a.i0.t.d.d(fileOutputStream2222);
                        return true;
                    }
                    i4 = width - this.o;
                    this.q = i4;
                    if (this.r > 0) {
                    }
                    i5 = height - this.p;
                    this.r = i5;
                    this.s = this.s > 0 ? this.q : this.s;
                    if (this.t > 0) {
                    }
                    this.t = i6;
                    Bitmap createBitmap22222 = Bitmap.createBitmap(this.s, i6, y.getConfig());
                    new Canvas(createBitmap22222).drawBitmap(y, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                    if (!h()) {
                    }
                    file = new File(str);
                    if (file.exists()) {
                    }
                    if (file.getParentFile() != null) {
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream22222 = new FileOutputStream(file);
                    createBitmap22222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream22222);
                    fileOutputStream22222.flush();
                    d.a.i0.t.d.d(fileOutputStream22222);
                    return true;
                }
                i2 = 0;
                this.o = i2;
                if (this.p >= 0) {
                    i3 = this.p;
                    this.p = i3;
                    if (this.q > 0) {
                    }
                    i4 = width - this.o;
                    this.q = i4;
                    if (this.r > 0) {
                    }
                    i5 = height - this.p;
                    this.r = i5;
                    this.s = this.s > 0 ? this.q : this.s;
                    if (this.t > 0) {
                    }
                    this.t = i6;
                    Bitmap createBitmap222222 = Bitmap.createBitmap(this.s, i6, y.getConfig());
                    new Canvas(createBitmap222222).drawBitmap(y, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                    if (!h()) {
                    }
                    file = new File(str);
                    if (file.exists()) {
                    }
                    if (file.getParentFile() != null) {
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream222222 = new FileOutputStream(file);
                    createBitmap222222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream222222);
                    fileOutputStream222222.flush();
                    d.a.i0.t.d.d(fileOutputStream222222);
                    return true;
                }
                i3 = 0;
                this.p = i3;
                if (this.q > 0) {
                }
                i4 = width - this.o;
                this.q = i4;
                if (this.r > 0) {
                }
                i5 = height - this.p;
                this.r = i5;
                this.s = this.s > 0 ? this.q : this.s;
                if (this.t > 0) {
                }
                this.t = i6;
                Bitmap createBitmap2222222 = Bitmap.createBitmap(this.s, i6, y.getConfig());
                new Canvas(createBitmap2222222).drawBitmap(y, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                if (!h()) {
                }
                file = new File(str);
                if (file.exists()) {
                }
                if (file.getParentFile() != null) {
                }
                file.createNewFile();
                FileOutputStream fileOutputStream2222222 = new FileOutputStream(file);
                createBitmap2222222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream2222222);
                fileOutputStream2222222.flush();
                d.a.i0.t.d.d(fileOutputStream2222222);
                return true;
            } catch (Exception e2) {
                if (k.f43025a) {
                    e2.printStackTrace();
                }
            } catch (OutOfMemoryError e3) {
                if (k.f43025a) {
                    e3.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override // d.a.i0.a.a0.b.a, d.a.i0.a.c0.b.b, d.a.i0.a.l1.a
    public boolean isValid() {
        return this.q > 0 && this.r > 0;
    }
}
