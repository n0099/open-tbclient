package d.a.i0.z0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d0 {
    public static Point j;

    /* renamed from: a  reason: collision with root package name */
    public Context f50109a;

    /* renamed from: b  reason: collision with root package name */
    public b f50110b;

    /* renamed from: c  reason: collision with root package name */
    public long f50111c;

    /* renamed from: d  reason: collision with root package name */
    public a f50112d;

    /* renamed from: e  reason: collision with root package name */
    public a f50113e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f50114f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f50106g = {"_data", "datetaken"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f50107h = {"_data", "datetaken", "width", "height"};

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f50108i = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    public static final List<String> k = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public Uri f50115a;

        public a(Uri uri, Handler handler) {
            super(handler);
            this.f50115a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            d0.this.f(this.f50115a);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onShot(String str);
    }

    public d0(Context context) {
        this.f50109a = context;
        if (j == null) {
            Point e2 = e();
            j = e2;
            if (e2 != null) {
                BdLog.d("ScreenShotListenManager: Screen Real Size: " + j.x + " * " + j.y);
                return;
            }
            BdLog.d("ScreenShotListenManager: Get screen real size failed.");
        }
    }

    public static boolean h() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public final boolean b(String str) {
        if (k.contains(str)) {
            BdLog.d("ScreenShotListenManager: ScreenShot: imgPath has done; imagePath = " + str);
            return true;
        }
        if (k.size() >= 20) {
            for (int i2 = 0; i2 < 5; i2++) {
                k.remove(0);
            }
        }
        k.add(str);
        return false;
    }

    public final boolean c(String str, long j2, int i2, int i3) {
        if (j2 >= this.f50111c && System.currentTimeMillis() - j2 <= 10000) {
            Point point = j;
            if (point != null && (i2 > point.x || i3 > point.y)) {
                Point point2 = j;
                if (i3 > point2.x || i2 > point2.y) {
                    return false;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            for (String str2 : f50108i) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Point d(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Point(options.outWidth, options.outHeight);
    }

    public final Point e() {
        Exception e2;
        Point point;
        if (!h() || this.f50109a == null) {
            return null;
        }
        try {
            point = new Point();
        } catch (Exception e3) {
            e2 = e3;
            point = null;
        }
        try {
            Display defaultDisplay = ((WindowManager) this.f50109a.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                try {
                    point.set(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue());
                } catch (Exception e4) {
                    point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                    BdLog.e(e4);
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            BdLog.e(e2);
            return point;
        }
        return point;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    public final void f(Uri uri) {
        int i2;
        int i3;
        int i4;
        Cursor cursor = null;
        try {
            try {
                cursor = this.f50109a.getContentResolver().query(uri, Build.VERSION.SDK_INT < 16 ? f50106g : f50107h, null, null, "date_added desc limit 1");
            } catch (Exception e2) {
                e2.printStackTrace();
                if (0 == 0 || cursor.isClosed()) {
                    return;
                }
            }
            if (cursor == null) {
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else if (!cursor.moveToFirst()) {
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else {
                int columnIndex = cursor.getColumnIndex("_data");
                int columnIndex2 = cursor.getColumnIndex("datetaken");
                int i5 = -1;
                if (Build.VERSION.SDK_INT >= 16) {
                    i5 = cursor.getColumnIndex("width");
                    i2 = cursor.getColumnIndex("height");
                } else {
                    i2 = -1;
                }
                String string = cursor.getString(columnIndex);
                long j2 = cursor.getLong(columnIndex2);
                if (i5 >= 0 && i2 >= 0) {
                    i4 = cursor.getInt(i5);
                    i3 = cursor.getInt(i2);
                } else {
                    Point d2 = d(string);
                    int i6 = d2.x;
                    i3 = d2.y;
                    i4 = i6;
                }
                g(string, j2, i4, i3);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0 && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void g(String str, long j2, int i2, int i3) {
        if (c(str, j2, i2, i3)) {
            BdLog.d("ScreenShotListenManager: ScreenShot: path = " + str + "; size = " + i2 + " * " + i3 + "; date = " + j2);
            if (this.f50110b == null || b(str)) {
                return;
            }
            this.f50110b.onShot(str);
            return;
        }
        BdLog.d("ScreenShotListenManager: Media content changed, but not screenshot: path = " + str + "; size = " + i2 + " * " + i3 + "; date = " + j2);
    }

    public void i(b bVar) {
        this.f50110b = bVar;
    }

    public void j() {
        if (h()) {
            this.f50111c = System.currentTimeMillis();
            this.f50112d = new a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f50114f);
            this.f50113e = new a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f50114f);
            if (Build.VERSION.SDK_INT >= 29) {
                this.f50109a.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.f50112d);
                this.f50109a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f50113e);
                return;
            }
            this.f50109a.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.f50112d);
            this.f50109a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f50113e);
        }
    }

    public void k() {
        if (h()) {
            if (this.f50112d != null) {
                try {
                    this.f50109a.getContentResolver().unregisterContentObserver(this.f50112d);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f50112d = null;
            }
            if (this.f50113e != null) {
                try {
                    this.f50109a.getContentResolver().unregisterContentObserver(this.f50113e);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.f50113e = null;
            }
            this.f50111c = 0L;
            this.f50110b = null;
        }
    }
}
