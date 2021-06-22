package d.a.o0.k2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class g implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Handler> f60673a;

    public g(Handler handler) {
        this.f60673a = new WeakReference<>(handler);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        Handler handler;
        Message obtainMessage;
        if (sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        float f2 = -fArr[0];
        float f3 = -fArr[1];
        float f4 = -fArr[2];
        if ((f2 * f2) + (f3 * f3) >= f4 * f4) {
            int round = 90 - Math.round(((float) Math.atan2(-f3, f2)) * 57.29578f);
            if (round >= 360) {
                round -= 360;
            }
            if (round < 0) {
                round += 360;
            }
            WeakReference<Handler> weakReference = this.f60673a;
            if (weakReference == null || weakReference.get() == null || (obtainMessage = (handler = this.f60673a.get()).obtainMessage(1)) == null) {
                return;
            }
            obtainMessage.arg1 = round;
            handler.sendMessage(obtainMessage);
        }
    }
}
