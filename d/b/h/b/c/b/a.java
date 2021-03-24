package d.b.h.b.c.b;

import android.content.Intent;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.permissionhelper.app.ActivityCompat;
/* loaded from: classes2.dex */
public final class a implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdUploadHandler f49469e;

    public a(BdUploadHandler bdUploadHandler) {
        this.f49469e = bdUploadHandler;
    }

    @Override // com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intent createCameraIntentAfterCheckPermission;
        if (i == 4099) {
            boolean z = iArr.length != 0;
            for (int i2 : iArr) {
                if (i2 == -1) {
                    z = false;
                }
            }
            if (z) {
                createCameraIntentAfterCheckPermission = this.f49469e.createCameraIntentAfterCheckPermission();
                this.f49469e.mCanHandleResult = true;
                this.f49469e.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            d.b.h.a.j.a.b().d(4099);
        }
    }
}
