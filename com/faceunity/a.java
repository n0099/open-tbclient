package com.faceunity;

import android.content.Context;
import com.baidu.tieba.video.record.f;
import com.faceunity.wrapper.faceunity;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class a {
    public static int cw(Context context) {
        try {
            InputStream open = context.getAssets().open("beauty/v3.mp3");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            faceunity.fuSetup(bArr, null, f.A());
            InputStream open2 = context.getAssets().open("beauty/face_beautification.mp3");
            byte[] bArr2 = new byte[open2.available()];
            open2.read(bArr2);
            open2.close();
            return faceunity.fuCreateItemFromPackage(bArr2);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
