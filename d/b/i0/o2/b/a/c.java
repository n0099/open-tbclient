package d.b.i0.o2.b.a;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes5.dex */
public class c extends AsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public Camera f57298a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f57299b;

    /* renamed from: c  reason: collision with root package name */
    public a f57300c;

    /* renamed from: d  reason: collision with root package name */
    public int f57301d;

    /* loaded from: classes5.dex */
    public interface a {
        String a(byte[] bArr, int i, int i2, boolean z);
    }

    public c(Camera camera, byte[] bArr, a aVar, int i) {
        this.f57298a = camera;
        this.f57299b = bArr;
        this.f57300c = aVar;
        this.f57301d = i;
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
        Camera camera = this.f57298a;
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
        int i = previewSize.width;
        int i2 = previewSize.height;
        byte[] bArr = this.f57299b;
        if (this.f57301d == 0) {
            bArr = new byte[bArr.length];
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    bArr[(((i4 * i2) + i2) - i3) - 1] = this.f57299b[(i3 * i) + i4];
                }
            }
            i = i2;
            i2 = i;
        }
        try {
            try {
                if (this.f57300c == null) {
                    return null;
                }
                return this.f57300c.a(bArr, i, i2, false);
            } catch (Exception unused) {
                return this.f57300c.a(bArr, i, i2, true);
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
        this.f57300c = null;
    }
}
