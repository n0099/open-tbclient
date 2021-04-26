package d.a.j0.p2.b.a;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes3.dex */
public class c extends AsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public Camera f57402a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f57403b;

    /* renamed from: c  reason: collision with root package name */
    public a f57404c;

    /* renamed from: d  reason: collision with root package name */
    public int f57405d;

    /* loaded from: classes3.dex */
    public interface a {
        String a(byte[] bArr, int i2, int i3, boolean z);
    }

    public c(Camera camera, byte[] bArr, a aVar, int i2) {
        this.f57402a = camera;
        this.f57403b = bArr;
        this.f57404c = aVar;
        this.f57405d = i2;
    }

    public void a() {
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public String doInBackground(Void... voidArr) {
        Camera.Parameters parameters;
        Camera camera = this.f57402a;
        if (camera == null) {
            return null;
        }
        try {
            parameters = camera.getParameters();
        } catch (RuntimeException e2) {
            BdLog.e(e2);
            parameters = null;
        }
        if (parameters == null) {
            return null;
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        int i2 = previewSize.width;
        int i3 = previewSize.height;
        byte[] bArr = this.f57403b;
        if (this.f57405d == 0) {
            bArr = new byte[bArr.length];
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    bArr[(((i5 * i3) + i3) - i4) - 1] = this.f57403b[(i4 * i2) + i5];
                }
            }
            i2 = i3;
            i3 = i2;
        }
        try {
            try {
                if (this.f57404c == null) {
                    return null;
                }
                return this.f57404c.a(bArr, i2, i3, false);
            } catch (Exception unused) {
                return this.f57404c.a(bArr, i2, i3, true);
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public c c() {
        if (Build.VERSION.SDK_INT >= 11) {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            execute(new Void[0]);
        }
        return this;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.f57404c = null;
    }
}
