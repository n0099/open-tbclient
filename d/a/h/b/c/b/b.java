package d.a.h.b.c.b;

import android.app.Activity;
import android.content.Intent;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.permissionhelper.app.ActivityCompat;
/* loaded from: classes.dex */
public final class b implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdUploadHandler f41047e;

    public b(BdUploadHandler bdUploadHandler) {
        this.f41047e = bdUploadHandler;
    }

    @Override // com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Activity activity;
        Intent createCamcorderIntent;
        if (i2 == 4099) {
            boolean z = iArr.length != 0;
            for (int i3 : iArr) {
                if (i3 == -1) {
                    z = false;
                }
            }
            if (z) {
                this.f41047e.mCanHandleResult = true;
                activity = this.f41047e.mActivity;
                createCamcorderIntent = this.f41047e.createCamcorderIntent();
                activity.startActivityForResult(createCamcorderIntent, 11);
            }
            d.a.h.a.j.a.b().d(4099);
        }
    }
}
