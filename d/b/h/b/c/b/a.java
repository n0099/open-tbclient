package d.b.h.b.c.b;

import android.content.Intent;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.permissionhelper.app.ActivityCompat;
/* loaded from: classes.dex */
public final class a implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdUploadHandler f43789e;

    public a(BdUploadHandler bdUploadHandler) {
        this.f43789e = bdUploadHandler;
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
                createCameraIntentAfterCheckPermission = this.f43789e.createCameraIntentAfterCheckPermission();
                this.f43789e.mCanHandleResult = true;
                this.f43789e.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            d.b.h.a.j.a.b().d(4099);
        }
    }
}
