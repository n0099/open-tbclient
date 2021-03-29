package d.b.h.b.c.b;

import android.app.Activity;
import android.content.Intent;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.permissionhelper.app.ActivityCompat;
/* loaded from: classes.dex */
public final class b implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdUploadHandler f49471e;

    public b(BdUploadHandler bdUploadHandler) {
        this.f49471e = bdUploadHandler;
    }

    @Override // com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Activity activity;
        Intent createCamcorderIntent;
        if (i == 4099) {
            boolean z = iArr.length != 0;
            for (int i2 : iArr) {
                if (i2 == -1) {
                    z = false;
                }
            }
            if (z) {
                this.f49471e.mCanHandleResult = true;
                activity = this.f49471e.mActivity;
                createCamcorderIntent = this.f49471e.createCamcorderIntent();
                activity.startActivityForResult(createCamcorderIntent, 11);
            }
            d.b.h.a.j.a.b().d(4099);
        }
    }
}
