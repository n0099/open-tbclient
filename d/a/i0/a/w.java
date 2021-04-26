package d.a.i0.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class w implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f47927a;

    /* renamed from: b  reason: collision with root package name */
    public b f47928b;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f47929c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f47930d;

    /* renamed from: e  reason: collision with root package name */
    public Vibrator f47931e;

    /* renamed from: f  reason: collision with root package name */
    public SoundPool f47932f;

    /* renamed from: g  reason: collision with root package name */
    public int f47933g;

    /* renamed from: h  reason: collision with root package name */
    public int f47934h;

    /* renamed from: i  reason: collision with root package name */
    public long f47935i;
    public boolean j;
    public MediaPlayer k;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            w.this.k.start();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    public w(@NonNull Context context, @Nullable b bVar) {
        if (context == null) {
            return;
        }
        this.f47927a = context;
        this.f47928b = bVar;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f47929c = sensorManager;
        if (sensorManager != null) {
            this.f47930d = sensorManager.getDefaultSensor(1);
        }
        this.f47931e = (Vibrator) context.getSystemService("vibrator");
        SoundPool soundPool = new SoundPool(1, 3, 0);
        this.f47932f = soundPool;
        if (soundPool != null) {
            this.f47933g = soundPool.load(context, R.raw.shake_tone, 1);
        }
    }

    public final boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f47935i > 2000) {
            this.f47935i = currentTimeMillis;
            return true;
        }
        return false;
    }

    public void c() {
        SensorManager sensorManager = this.f47929c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.j = false;
        }
    }

    public boolean d() {
        return this.j;
    }

    public final boolean e(float[] fArr) {
        double sqrt = Math.sqrt(Math.pow(Math.abs(fArr[0]) / 9.8d, 2.0d) + Math.pow(Math.abs(fArr[1]) / 9.8d, 2.0d) + Math.pow(Math.abs(fArr[2]) / 9.8d, 2.0d));
        if (Build.VERSION.SDK_INT <= 23) {
            if (sqrt >= 2.5d && b()) {
                return true;
            }
        } else if (sqrt >= 4.2d && b()) {
            return true;
        }
        return false;
    }

    public void f() {
        Sensor sensor = this.f47930d;
        if (sensor != null) {
            this.f47929c.registerListener(this, sensor, 2);
            this.j = true;
        }
    }

    public boolean g() {
        Context context = this.f47927a;
        if (context == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        int ringerMode = audioManager != null ? audioManager.getRingerMode() : -1;
        Vibrator vibrator = this.f47931e;
        if (vibrator == null || !vibrator.hasVibrator() || ringerMode <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f47931e.vibrate(VibrationEffect.createOneShot(400L, 255));
            return true;
        }
        this.f47931e.vibrate(400L);
        return true;
    }

    public void h(boolean z) {
        int i2;
        if (!z && (i2 = this.f47934h) != 0) {
            SoundPool soundPool = this.f47932f;
            if (soundPool != null) {
                soundPool.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
                return;
            }
            return;
        }
        SoundPool soundPool2 = this.f47932f;
        if (soundPool2 != null) {
            soundPool2.play(this.f47933g, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    public void i(String str) {
        if (this.k == null) {
            this.k = new MediaPlayer();
        }
        try {
            this.k.reset();
            this.k.setLooping(false);
            this.k.setDataSource(str);
            this.k.prepareAsync();
            this.k.setOnPreparedListener(new a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        b bVar;
        if (sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && (bVar = this.f47928b) != null) {
            bVar.a();
        }
    }
}
