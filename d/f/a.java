package d.f;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.faceunity.wrapper.faceunity;
import d.b.j0.q3.m.f;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a {
    public static int a(Context context) {
        try {
            InputStream open = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/v3.mp3");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            faceunity.fuSetup(bArr, null, f.a());
            InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
            byte[] bArr2 = new byte[open2.available()];
            open2.read(bArr2);
            open2.close();
            return faceunity.fuCreateItemFromPackage(bArr2);
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
