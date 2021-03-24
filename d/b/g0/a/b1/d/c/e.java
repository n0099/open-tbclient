package d.b.g0.a.b1.d.c;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<MediaModel> f43439a;

    public static void a() {
        ArrayList<MediaModel> arrayList = f43439a;
        if (arrayList != null) {
            arrayList.clear();
            f43439a = null;
        }
    }

    public static String b() {
        ArrayList<MediaModel> arrayList = f43439a;
        if (arrayList == null || arrayList.size() == 0 || f43439a.get(0) == null) {
            return null;
        }
        return f43439a.get(0).e();
    }

    public static int c(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList;
        if (mediaModel == null || (arrayList = f43439a) == null) {
            return -1;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (mediaModel.equals(f43439a.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static int d() {
        ArrayList<MediaModel> arrayList = f43439a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public static ArrayList<MediaModel> e() {
        return f43439a;
    }

    public static boolean f(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = f43439a;
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(mediaModel);
    }

    public static boolean g(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = f43439a;
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        return f43439a.contains(mediaModel);
    }

    public static void h(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = f43439a;
        if (arrayList != null) {
            arrayList.remove(mediaModel);
        }
    }

    public static void i(MediaModel mediaModel) {
        if (mediaModel == null) {
            return;
        }
        if (f43439a == null) {
            f43439a = new ArrayList<>();
        }
        f43439a.add(mediaModel);
    }
}
