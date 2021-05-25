package d.a.l0.a.i1.d.c;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<MediaModel> f42878a;

    public static void a() {
        ArrayList<MediaModel> arrayList = f42878a;
        if (arrayList != null) {
            arrayList.clear();
            f42878a = null;
        }
    }

    public static String b() {
        ArrayList<MediaModel> arrayList = f42878a;
        if (arrayList == null || arrayList.size() == 0 || f42878a.get(0) == null) {
            return null;
        }
        return f42878a.get(0).e();
    }

    public static int c(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList;
        if (mediaModel == null || (arrayList = f42878a) == null) {
            return -1;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (mediaModel.equals(f42878a.get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public static int d() {
        ArrayList<MediaModel> arrayList = f42878a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public static ArrayList<MediaModel> e() {
        return f42878a;
    }

    public static boolean f(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = f42878a;
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(mediaModel);
    }

    public static boolean g(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = f42878a;
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        return f42878a.contains(mediaModel);
    }

    public static void h(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = f42878a;
        if (arrayList != null) {
            arrayList.remove(mediaModel);
        }
    }

    public static void i(MediaModel mediaModel) {
        if (mediaModel == null) {
            return;
        }
        if (f42878a == null) {
            f42878a = new ArrayList<>();
        }
        f42878a.add(mediaModel);
    }
}
