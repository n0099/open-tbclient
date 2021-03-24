package d.b.g0.a.x.d;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.g0.a.x.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0877a implements Camera.AutoFocusCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46947a;

        public C0877a(String str) {
            this.f46947a = str;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Camera.Parameters parameters;
            if (camera == null || (parameters = camera.getParameters()) == null) {
                return;
            }
            parameters.setFocusMode(this.f46947a);
            camera.setParameters(parameters);
        }
    }

    public static Rect a(float f2, float f3, float f4, int i, int i2) {
        int i3 = (int) (((f2 / i) * 2000.0f) - 1000.0f);
        int i4 = (int) (((f3 / i2) * 2000.0f) - 1000.0f);
        int intValue = Float.valueOf(f4 * 300.0f).intValue() / 2;
        RectF rectF = new RectF(b(i3 - intValue, -1000, 1000), b(i4 - intValue, -1000, 1000), b(i3 + intValue, -1000, 1000), b(i4 + intValue, -1000, 1000));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public static int b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static String c(Camera.Parameters parameters) {
        List<String> supportedFocusModes;
        if (parameters != null && (supportedFocusModes = parameters.getSupportedFocusModes()) != null) {
            if (supportedFocusModes.contains("macro")) {
                return "macro";
            }
            if (supportedFocusModes.contains("continuous-picture")) {
                return "continuous-picture";
            }
        }
        return "auto";
    }

    public static void d(MotionEvent motionEvent, Camera camera, int i, int i2) {
        if (motionEvent == null || camera == null) {
            return;
        }
        Rect a2 = a(motionEvent.getX(), motionEvent.getY(), 1.0f, i, i2);
        camera.cancelAutoFocus();
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            return;
        }
        if (parameters.getMaxNumFocusAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(a2, 800));
            parameters.setFocusAreas(arrayList);
        }
        String focusMode = parameters.getFocusMode();
        parameters.setFocusMode(c(parameters));
        camera.setParameters(parameters);
        camera.autoFocus(new C0877a(focusMode));
    }
}
