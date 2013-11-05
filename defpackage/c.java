package defpackage;

import com.baidu.cloudsdk.common.imgloader.CompressBitmapTask;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* renamed from: c  reason: default package */
/* loaded from: classes.dex */
class c implements CompressBitmapTask.ICompressBitmapListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ac acVar) {
        this.f393a = acVar;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.CompressBitmapTask.ICompressBitmapListener
    public void onComplete(ByteArrayOutputStream byteArrayOutputStream) {
        String shareUrl = this.f393a.c.getShareUrl();
        if (byteArrayOutputStream != null && byteArrayOutputStream.size() != 0) {
            this.f393a.f262a.put("pic", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            shareUrl = this.f393a.c.getShareUploadUrl();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        this.f393a.c.a(shareUrl, this.f393a.f262a, this.f393a.b);
    }
}
