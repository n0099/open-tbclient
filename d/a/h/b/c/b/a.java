package d.a.h.b.c.b;

import android.content.Intent;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.permissionhelper.app.ActivityCompat;
/* loaded from: classes.dex */
public final class a implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdUploadHandler f41046e;

    public a(BdUploadHandler bdUploadHandler) {
        this.f41046e = bdUploadHandler;
    }

    @Override // com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Intent createCameraIntentAfterCheckPermission;
        if (i2 == 4099) {
            boolean z = iArr.length != 0;
            for (int i3 : iArr) {
                if (i3 == -1) {
                    z = false;
                }
            }
            if (z) {
                createCameraIntentAfterCheckPermission = this.f41046e.createCameraIntentAfterCheckPermission();
                this.f41046e.mCanHandleResult = true;
                this.f41046e.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
            }
            d.a.h.a.j.a.b().d(4099);
        }
    }
}
