package d.a.m0.a;

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
public class x implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f48788a;

    /* renamed from: b  reason: collision with root package name */
    public b f48789b;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f48790c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f48791d;

    /* renamed from: e  reason: collision with root package name */
    public Vibrator f48792e;

    /* renamed from: f  reason: collision with root package name */
    public SoundPool f48793f;

    /* renamed from: g  reason: collision with root package name */
    public int f48794g;

    /* renamed from: h  reason: collision with root package name */
    public int f48795h;

    /* renamed from: i  reason: collision with root package name */
    public long f48796i;
    public boolean j;
    public MediaPlayer k;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            x.this.k.start();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    public x(@NonNull Context context, @Nullable b bVar) {
        if (context == null) {
            return;
        }
        this.f48788a = context;
        this.f48789b = bVar;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f48790c = sensorManager;
        if (sensorManager != null) {
            this.f48791d = sensorManager.getDefaultSensor(1);
        }
        this.f48792e = (Vibrator) context.getSystemService("vibrator");
        SoundPool soundPool = new SoundPool(1, 3, 0);
        this.f48793f = soundPool;
        if (soundPool != null) {
            this.f48794g = soundPool.load(context, R.raw.shake_tone, 1);
        }
    }

    public final boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f48796i > 2000) {
            this.f48796i = currentTimeMillis;
            return true;
        }
        return false;
    }

    public void c() {
        SensorManager sensorManager = this.f48790c;
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
        Sensor sensor = this.f48791d;
        if (sensor != null) {
            this.f48790c.registerListener(this, sensor, 2);
            this.j = true;
        }
    }

    public boolean g() {
        Context context = this.f48788a;
        if (context == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        int ringerMode = audioManager != null ? audioManager.getRingerMode() : -1;
        Vibrator vibrator = this.f48792e;
        if (vibrator == null || !vibrator.hasVibrator() || ringerMode <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f48792e.vibrate(VibrationEffect.createOneShot(400L, 255));
            return true;
        }
        this.f48792e.vibrate(400L);
        return true;
    }

    public void h(boolean z) {
        int i2;
        if (!z && (i2 = this.f48795h) != 0) {
            SoundPool soundPool = this.f48793f;
            if (soundPool != null) {
                soundPool.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
                return;
            }
            return;
        }
        SoundPool soundPool2 = this.f48793f;
        if (soundPool2 != null) {
            soundPool2.play(this.f48794g, 1.0f, 1.0f, 0, 0, 1.0f);
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
        if (sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && (bVar = this.f48789b) != null) {
            bVar.a();
        }
    }
}
