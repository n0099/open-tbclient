package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.zeus.NotificationProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: bm  reason: default package */
/* loaded from: classes.dex */
public class bm implements bn {
    private String a;
    private bn b;
    private int c;
    private int d;
    private Map e = new HashMap();

    public bm(String str, int i, int i2, bn bnVar) {
        this.a = str;
        this.c = i;
        this.d = i2;
        this.b = bnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Bitmap bitmap) {
        return ((bitmap.getHeight() * bitmap.getWidth()) * 4) / NotificationProxy.MAX_URL_LENGTH;
    }

    public bm a(int i) {
        this.d = i;
        return this;
    }

    public bm a(String str) {
        this.a = str;
        return this;
    }

    @Override // defpackage.bn
    public void a(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        File file = new File(c(str));
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Exception e) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            this.e.put(str, 1);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th2) {
            fileOutputStream2 = fileOutputStream;
            th = th2;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    public Bitmap b(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(c(str));
        if (decodeFile != null) {
            Integer num = (Integer) this.e.get(str);
            if (num == null) {
                num = 0;
            }
            if (num.intValue() + 1 <= this.c || this.b == null || a(decodeFile) > this.d) {
                this.e.put(str, Integer.valueOf(num.intValue() + 1));
                return decodeFile;
            }
            this.b.a(str, decodeFile);
            this.e.remove(str);
            return decodeFile;
        }
        return null;
    }

    public bm b(int i) {
        this.c = i;
        return this;
    }

    public String c(String str) {
        return this.a + "/" + str + ".png";
    }
}
