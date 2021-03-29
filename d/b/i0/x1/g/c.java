package d.b.i0.x1.g;

import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f62378a = d.b.i0.x1.c.f62339c + "draft/";

    /* renamed from: b  reason: collision with root package name */
    public static final String f62379b = f62378a + "upload_draft";

    public static void a() {
        File file = new File(f62379b);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x000c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft] */
    public static FaceGroupDraft b() {
        FaceGroupDraft faceGroupDraft;
        ObjectInputStream objectInputStream;
        File file = new File(f62379b);
        ?? r2 = 0;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        FaceGroupDraft faceGroupDraft2 = null;
        r2 = null;
        r2 = null;
        ObjectInputStream objectInputStream2 = null;
        try {
            if (file.exists()) {
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                } catch (IOException e2) {
                    e = e2;
                    faceGroupDraft = null;
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    faceGroupDraft = null;
                } catch (Throwable th) {
                    th = th;
                    faceGroupDraft = null;
                }
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject != null && (readObject instanceof FaceGroupDraft)) {
                        faceGroupDraft2 = (FaceGroupDraft) readObject;
                    }
                    objectInputStream.close();
                    d.b.b.e.m.a.c(objectInputStream);
                    return faceGroupDraft2;
                } catch (IOException e4) {
                    e = e4;
                    FaceGroupDraft faceGroupDraft3 = faceGroupDraft2;
                    objectInputStream2 = objectInputStream;
                    faceGroupDraft = faceGroupDraft3;
                    e.printStackTrace();
                    d.b.b.e.m.a.c(objectInputStream2);
                    r2 = faceGroupDraft;
                    return r2;
                } catch (ClassNotFoundException e5) {
                    e = e5;
                    FaceGroupDraft faceGroupDraft4 = faceGroupDraft2;
                    objectInputStream2 = objectInputStream;
                    faceGroupDraft = faceGroupDraft4;
                    e.printStackTrace();
                    d.b.b.e.m.a.c(objectInputStream2);
                    r2 = faceGroupDraft;
                    return r2;
                } catch (Throwable th2) {
                    th = th2;
                    FaceGroupDraft faceGroupDraft5 = faceGroupDraft2;
                    objectInputStream2 = objectInputStream;
                    faceGroupDraft = faceGroupDraft5;
                    th.printStackTrace();
                    d.b.b.e.m.a.c(objectInputStream2);
                    r2 = faceGroupDraft;
                    return r2;
                }
            }
            return null;
        } catch (Throwable th3) {
            d.b.b.e.m.a.c(r2);
            throw th3;
        }
    }

    public static void c(FaceGroupDraft faceGroupDraft) {
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                File file = new File(f62378a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                a();
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(f62379b));
                try {
                    objectOutputStream2.writeObject(faceGroupDraft);
                    d.b.b.e.m.a.d(objectOutputStream2);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    th.printStackTrace();
                }
            } finally {
                d.b.b.e.m.a.d(objectOutputStream);
            }
        } catch (FileNotFoundException e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
