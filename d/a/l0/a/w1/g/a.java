package d.a.l0.a.w1.g;

import com.baidu.swan.apps.publisher.draft.DraftData;
import d.a.l0.a.a2.e;
import d.a.l0.a.k2.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class a {
    public static final void a() {
        File file = new File(b(), "publisher_draft");
        if (file.exists()) {
            file.delete();
        }
    }

    public static final String b() {
        e i2 = e.i();
        String v = b.v(i2 != null ? i2.f40749f : null);
        Intrinsics.checkNotNullExpressionValue(v, "StorageUtil.getSwanAppStoreDirectory(appId)");
        return v;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final DraftData c() {
        ObjectInputStream objectInputStream;
        File file = new File(b(), "publisher_draft");
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                if (file.exists()) {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    try {
                        Object readObject = objectInputStream.readObject();
                        if (readObject != null) {
                            DraftData draftData = (DraftData) readObject;
                            if (System.currentTimeMillis() - draftData.getTimeStamp() > 432000000) {
                                objectInputStream.close();
                                return null;
                            }
                            objectInputStream.close();
                            return draftData;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.swan.apps.publisher.draft.DraftData");
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                objectInputStream2 = "publisher_draft";
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (objectInputStream2 != null) {
            }
            throw th;
        }
        return null;
    }

    public static final void d(DraftData draftData) {
        ObjectOutputStream objectOutputStream;
        if (draftData != null) {
            File file = new File(b(), "publisher_draft");
            try {
                if (file.exists()) {
                    file.delete();
                    file.createNewFile();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                objectOutputStream.writeObject(draftData);
                objectOutputStream.close();
            } catch (Exception e4) {
                e = e4;
                objectOutputStream2 = objectOutputStream;
                e.printStackTrace();
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
                throw th;
            }
        }
    }
}
