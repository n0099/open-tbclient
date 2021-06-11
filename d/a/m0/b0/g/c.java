package d.a.m0.b0.g;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f52612b = new c();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Class<? extends b>> f52613a = new HashMap<>();

    public c() {
        f(d.class);
        f(f.class);
        f(a.class);
        f(e.class);
        f(g.class);
    }

    public static c d() {
        return f52612b;
    }

    public b a(ImageOperation imageOperation) {
        b e2;
        Class<? extends b> cls = this.f52613a.get(imageOperation.actionName);
        if (cls == null || (e2 = e(cls)) == null) {
            return null;
        }
        e2.d(imageOperation.actionParam);
        return e2;
    }

    public Bitmap b(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        if (bitmap == null || ListUtils.isEmpty(list)) {
            return bitmap;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            b a2 = a(list.get(i2));
            if ((a2 instanceof g) && imageFileInfo != null) {
                ((g) a2).e(imageFileInfo.getFilePath());
                return a2.b(bitmap, z);
            }
        }
        d dVar = null;
        int i3 = 0;
        while (i3 < size) {
            ImageOperation imageOperation = list.get(i3);
            if ("resize".equals(imageOperation.actionName)) {
                d dVar2 = (d) a(imageOperation);
                if (dVar == null || dVar2.f() <= dVar.f() || dVar2.e() <= dVar.e()) {
                    dVar = dVar2;
                }
                list.remove(i3);
                i3--;
            }
            i3++;
        }
        Bitmap b2 = dVar != null ? dVar.b(bitmap, z) : null;
        if (list != null) {
            for (int i4 = 0; i4 < size; i4++) {
                b a3 = a(list.get(i4));
                if (a3 != null) {
                    if (b2 == null) {
                        return null;
                    }
                    b2 = a3.b(bitmap, z);
                }
            }
        }
        return b2;
    }

    public Bitmap c(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            b a2 = a(list.get(i2));
            if ((a2 instanceof g) && imageFileInfo != null) {
                return a2.c(imageFileInfo.getFilePath());
            }
        }
        d dVar = null;
        int i3 = 0;
        while (i3 < list.size()) {
            ImageOperation imageOperation = list.get(i3);
            if ("resize".equals(imageOperation.actionName)) {
                d dVar2 = (d) a(imageOperation);
                if (dVar == null || dVar2.f() <= dVar.f() || dVar2.e() <= dVar.e()) {
                    dVar = dVar2;
                }
                list.remove(i3);
                i3--;
            }
            i3++;
        }
        Bitmap c2 = dVar != null ? dVar.c(str) : null;
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                b a3 = a(list.get(i4));
                if (a3 != null) {
                    if (c2 == null) {
                        c2 = a3.c(str);
                    } else {
                        c2 = a3.b(c2, true);
                    }
                }
            }
        }
        return c2;
    }

    public final b e(Class<? extends b> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final void f(Class<? extends b> cls) {
        b e2 = e(cls);
        if (e2 != null) {
            this.f52613a.put(e2.a(), cls);
        }
    }
}
