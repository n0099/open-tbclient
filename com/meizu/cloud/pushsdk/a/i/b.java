package com.meizu.cloud.pushsdk.a.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.NetworkOnMainThreadException;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.a.a.c;
import com.meizu.cloud.pushsdk.a.d.k;
import com.meizu.cloud.pushsdk.a.h.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
/* loaded from: classes2.dex */
public class b {
    public static String a(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        if (contentTypeFor == null) {
            return "application/octet-stream";
        }
        return contentTypeFor;
    }

    public static c<Bitmap> a(k kVar, int i, int i2, Bitmap.Config config, ImageView.ScaleType scaleType) {
        Bitmap bitmap;
        byte[] bArr = new byte[0];
        try {
            bArr = f.a(kVar.b().a()).i();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i == 0 && i2 == 0) {
            options.inPreferredConfig = config;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int a = a(i, i2, i3, i4, scaleType);
            int a2 = a(i2, i, i4, i3, scaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i3, i4, a, a2);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null || (decodeByteArray.getWidth() <= a && decodeByteArray.getHeight() <= a2)) {
                bitmap = decodeByteArray;
            } else {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, a, a2, true);
                decodeByteArray.recycle();
            }
        }
        if (bitmap == null) {
            return c.a(b(new com.meizu.cloud.pushsdk.a.c.a(kVar)));
        }
        return c.a(bitmap);
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        } else if (i == 0) {
            return (int) ((i2 / i4) * i3);
        } else {
            if (i2 != 0) {
                double d = i4 / i3;
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    if (i * d < i2) {
                        return (int) (i2 / d);
                    }
                    return i;
                } else if (i * d > i2) {
                    return (int) (i2 / d);
                } else {
                    return i;
                }
            }
            return i;
        }
    }

    public static int a(int i, int i2, int i3, int i4) {
        float f = 1.0f;
        while (f * 2.0f <= Math.min(i / i3, i2 / i4)) {
            f *= 2.0f;
        }
        return (int) f;
    }

    public static void a(k kVar, String str, String str2) throws IOException {
        InputStream inputStream;
        FileOutputStream fileOutputStream = null;
        byte[] bArr = new byte[2048];
        try {
            InputStream b = kVar.b().b();
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                while (true) {
                    try {
                        int read = b.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        inputStream = b;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                fileOutputStream2.flush();
                if (b != null) {
                    try {
                        b.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = b;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public static com.meizu.cloud.pushsdk.a.c.a a(com.meizu.cloud.pushsdk.a.c.a aVar) {
        aVar.a("connectionError");
        aVar.a(0);
        return aVar;
    }

    public static com.meizu.cloud.pushsdk.a.c.a a(com.meizu.cloud.pushsdk.a.c.a aVar, com.meizu.cloud.pushsdk.a.a.b bVar, int i) {
        com.meizu.cloud.pushsdk.a.c.a a = bVar.a(aVar);
        a.a(i);
        a.a("responseFromServerError");
        return a;
    }

    public static com.meizu.cloud.pushsdk.a.c.a b(com.meizu.cloud.pushsdk.a.c.a aVar) {
        aVar.a(0);
        aVar.a("parseError");
        return aVar;
    }

    public static com.meizu.cloud.pushsdk.a.c.a a(Exception exc) {
        com.meizu.cloud.pushsdk.a.c.a aVar = new com.meizu.cloud.pushsdk.a.c.a(exc);
        if (Build.VERSION.SDK_INT >= 11 && (exc instanceof NetworkOnMainThreadException)) {
            aVar.a("networkOnMainThreadError");
        } else {
            aVar.a("connectionError");
        }
        aVar.a(0);
        return aVar;
    }
}
