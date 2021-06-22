package d.a.m0.a.c0.c.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.camera.view.CameraPreview;
import d.a.m0.a.c0.f.b;
/* loaded from: classes2.dex */
public final class a extends d.a.m0.a.c0.b.a<CameraPreview, d.a.m0.a.z.e.a> {
    public a(@NonNull Context context, @NonNull d.a.m0.a.z.e.a aVar) {
        super(context, aVar);
        g(2);
    }

    @Override // d.a.m0.a.c0.b.a
    public void A() {
        super.A();
        CameraPreview q = q();
        if (q != null) {
            q.h();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.b.a
    @NonNull
    /* renamed from: H */
    public CameraPreview v(@NonNull Context context) {
        return new CameraPreview(context, n());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.b.a
    /* renamed from: I */
    public void D(@NonNull CameraPreview cameraPreview, @NonNull d.a.m0.a.z.e.a aVar, @NonNull b bVar) {
        super.D(cameraPreview, aVar, bVar);
        if (t()) {
            cameraPreview.p(aVar);
        }
    }
}
