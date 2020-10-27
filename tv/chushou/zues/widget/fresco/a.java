package tv.chushou.zues.widget.fresco;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.c.j;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import io.reactivex.BackpressureStrategy;
import io.reactivex.g;
import io.reactivex.i;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.OkHttpClient;
import tv.chushou.a.a.a.c;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class a {
    private static volatile boolean oAu = false;

    /* renamed from: tv.chushou.zues.widget.fresco.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1103a {
        void onComplete(boolean z, String str);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void esc();

        void finish();
    }

    public static void b(Context context, OkHttpClient okHttpClient) {
        e.d("ImageLoader", "initialize imageloader---->");
        Context applicationContext = ((Context) c.checkNotNull(context)).getApplicationContext();
        com.facebook.drawee.a.a.c.a(applicationContext, com.facebook.imagepipeline.a.a.a.a(applicationContext, (OkHttpClient) c.checkNotNull(okHttpClient)).d(Bitmap.Config.RGB_565).Ab(true).Ac(true).a(new com.facebook.common.memory.c() { // from class: tv.chushou.zues.widget.fresco.a.1
            @Override // com.facebook.common.memory.c
            public void a(com.facebook.common.memory.b bVar) {
                bVar.a(MemoryTrimType.OnSystemLowMemoryWhileAppInForeground);
            }
        }).ekP());
        oAu = true;
        e.d("ImageLoader", "initialize imageloader");
    }

    public static void resume() {
        com.facebook.drawee.a.a.c.ehf().resume();
    }

    public static void pause() {
        com.facebook.drawee.a.a.c.ehf().pause();
    }

    public static File ah(Uri uri) {
        com.facebook.a.a d;
        if (uri == null) {
            return null;
        }
        com.facebook.cache.common.b c = j.ejI().c(ImageRequest.ab(uri), null);
        if (com.facebook.imagepipeline.d.j.ele().ell().g(c)) {
            com.facebook.a.a d2 = com.facebook.imagepipeline.d.j.ele().ell().d(c);
            if (d2 != null) {
                return ((com.facebook.a.b) d2).getFile();
            }
        } else if (com.facebook.imagepipeline.d.j.ele().elq().g(c) && (d = com.facebook.imagepipeline.d.j.ele().elq().d(c)) != null) {
            return ((com.facebook.a.b) d).getFile();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [174=4] */
    @Nullable
    public static Bitmap C(String str, int i, int i2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        try {
            if (h.isEmpty(str)) {
                return null;
            }
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
            } catch (Exception e) {
                e = e;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                tv.chushou.a.a.d.a.b(null);
                throw th;
            }
            if (httpURLConnection.getResponseCode() != 200) {
                tv.chushou.a.a.d.a.b(null);
                return null;
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] f = tv.chushou.a.a.d.a.f(inputStream);
                if (f == null) {
                    tv.chushou.a.a.d.a.b(inputStream);
                    return null;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (i2 > 0 && i > 0) {
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(f, 0, f.length, options);
                    int i3 = options.outWidth;
                    int i4 = options.outHeight;
                    e.d("ImageLoader", "get bmp orignal w:" + i3 + " h:" + i4);
                    if (i3 * i4 > i2 * i) {
                        options.inSampleSize = tv.chushou.zues.utils.c.computeSampleSize(options, -1, i2 * i);
                    }
                }
                options.inJustDecodeBounds = false;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(f, 0, f.length, options);
                tv.chushou.a.a.d.a.b(inputStream);
                return decodeByteArray;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                tv.chushou.a.a.d.a.b(inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @SuppressLint({"CheckResult"})
    public static void a(final String str, final String str2, final InterfaceC1103a interfaceC1103a) {
        String str3;
        if (h.isEmpty(str) || h.isEmpty(str2)) {
            if (interfaceC1103a != null) {
                interfaceC1103a.onComplete(false, null);
                return;
            }
            return;
        }
        if (str.endsWith("gif") || str.endsWith("GIF")) {
            str3 = String.valueOf(str.hashCode()) + ".gif";
        } else {
            str3 = String.valueOf(str.hashCode()) + ".jpg";
        }
        final File file = new File(str2, str3);
        g.a(new i<Boolean>() { // from class: tv.chushou.zues.widget.fresco.a.4
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [229=4] */
            @Override // io.reactivex.i
            public void subscribe(io.reactivex.h<Boolean> hVar) throws Exception {
                FileInputStream fileInputStream;
                FileInputStream fileInputStream2;
                boolean z;
                FileOutputStream fileOutputStream = null;
                if (hVar.isCancelled()) {
                    return;
                }
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File ah = a.ah(!h.isEmpty(str) ? Uri.parse(str) : null);
                if (ah == null) {
                    z = a.r(str, file);
                } else {
                    try {
                        fileInputStream = new FileInputStream(ah);
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                tv.chushou.a.a.d.a.e(fileInputStream, fileOutputStream2);
                                tv.chushou.a.a.d.a.b(fileInputStream, fileOutputStream2);
                                z = true;
                            } catch (Exception e) {
                                fileOutputStream = fileOutputStream2;
                                fileInputStream2 = fileInputStream;
                                tv.chushou.a.a.d.a.b(fileInputStream2, fileOutputStream);
                                z = false;
                                hVar.onNext(Boolean.valueOf(z));
                                hVar.onComplete();
                            } catch (Throwable th) {
                                fileOutputStream = fileOutputStream2;
                                th = th;
                                tv.chushou.a.a.d.a.b(fileInputStream, fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e2) {
                            fileInputStream2 = fileInputStream;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e3) {
                        fileInputStream2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                }
                hVar.onNext(Boolean.valueOf(z));
                hVar.onComplete();
            }
        }, BackpressureStrategy.BUFFER).b(io.reactivex.f.a.exr()).a(io.reactivex.a.b.a.ewM()).a(new io.reactivex.c.g<Boolean>() { // from class: tv.chushou.zues.widget.fresco.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: z */
            public void accept(Boolean bool) throws Exception {
                if (bool.booleanValue()) {
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(file));
                    h.eDz().sendBroadcast(intent);
                    if (interfaceC1103a != null) {
                        interfaceC1103a.onComplete(true, file.getAbsolutePath());
                    }
                } else if (interfaceC1103a != null) {
                    interfaceC1103a.onComplete(false, null);
                }
            }
        }, new io.reactivex.c.g<Throwable>() { // from class: tv.chushou.zues.widget.fresco.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            public void accept(Throwable th) throws Exception {
                e.e("ImageLoader", "", th);
                if (InterfaceC1103a.this != null) {
                    InterfaceC1103a.this.onComplete(false, null);
                }
            }
        });
    }

    public static com.facebook.datasource.b<Void> a(String str, Context context, final b bVar) {
        com.facebook.datasource.b<Void> a2 = com.facebook.drawee.a.a.c.ehf().a(ImageRequestBuilder.ad(Uri.parse(str)).eoj(), context, Priority.HIGH);
        a2.a(new com.facebook.datasource.a<Void>() { // from class: tv.chushou.zues.widget.fresco.a.5
            @Override // com.facebook.datasource.a
            protected void g(com.facebook.datasource.b<Void> bVar2) {
                b.this.finish();
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<Void> bVar2) {
                b.this.esc();
            }
        }, com.facebook.common.b.a.egg());
        return a2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [323=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static boolean r(String str, File file) {
        InputStream inputStream;
        boolean z;
        Closeable closeable;
        InputStream inputStream2 = null;
        if (h.isEmpty(str) || file == null) {
            return false;
        }
        if (!file.exists() || file.delete()) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        try {
                            ?? fileOutputStream = new FileOutputStream(file);
                            try {
                                tv.chushou.a.a.d.a.e(inputStream, fileOutputStream);
                                inputStream2 = inputStream;
                                z = true;
                                closeable = fileOutputStream;
                            } catch (Exception e) {
                                inputStream2 = fileOutputStream;
                                tv.chushou.a.a.d.a.b(inputStream, inputStream2);
                                z = false;
                                return z;
                            } catch (Throwable th) {
                                inputStream2 = fileOutputStream;
                                th = th;
                                tv.chushou.a.a.d.a.b(inputStream, inputStream2);
                                throw th;
                            }
                        } catch (Exception e2) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        closeable = null;
                        inputStream2 = inputStream;
                        z = false;
                    }
                } else {
                    closeable = null;
                    z = false;
                }
                tv.chushou.a.a.d.a.b(inputStream2, closeable);
            } catch (Exception e3) {
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            return z;
        }
        return false;
    }
}
