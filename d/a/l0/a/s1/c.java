package d.a.l0.a.s1;

import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
/* loaded from: classes3.dex */
public class c {
    public static String a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "getPhoneContacts" : "calendar" : "saveImageToPhotosAlbum" : "getRecorderManager" : BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA : "location";
    }

    public static String b(boolean z) {
        return z ? "success" : "fail";
    }
}
