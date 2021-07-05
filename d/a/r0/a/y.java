package d.a.r0.a;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class y implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f54711e;

    /* renamed from: f  reason: collision with root package name */
    public b f54712f;

    /* renamed from: g  reason: collision with root package name */
    public SensorManager f54713g;

    /* renamed from: h  reason: collision with root package name */
    public Sensor f54714h;

    /* renamed from: i  reason: collision with root package name */
    public Vibrator f54715i;
    public SoundPool j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public MediaPlayer o;

    /* loaded from: classes9.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f54716e;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54716e = yVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f54716e.o.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    public y(@NonNull Context context, @Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        this.f54711e = context;
        this.f54712f = bVar;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f54713g = sensorManager;
        if (sensorManager != null) {
            this.f54714h = sensorManager.getDefaultSensor(1);
        }
        this.f54715i = (Vibrator) context.getSystemService("vibrator");
        SoundPool soundPool = new SoundPool(1, 3, 0);
        this.j = soundPool;
        if (soundPool != null) {
            try {
                this.k = soundPool.load(context, R.raw.shake_tone, 1);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.m > 2000) {
                this.m = currentTimeMillis;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sensorManager = this.f54713g) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
        this.n = false;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final boolean e(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fArr)) == null) {
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
        return invokeL.booleanValue;
    }

    public void f() {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (sensor = this.f54714h) == null) {
            return;
        }
        this.f54713g.registerListener(this, sensor, 2);
        this.n = true;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.f54711e;
            if (context == null) {
                return false;
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int ringerMode = audioManager != null ? audioManager.getRingerMode() : -1;
            Vibrator vibrator = this.f54715i;
            if (vibrator == null || !vibrator.hasVibrator() || ringerMode <= 0) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.f54715i.vibrate(VibrationEffect.createOneShot(400L, 255));
                return true;
            }
            this.f54715i.vibrate(400L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z && (i2 = this.l) != 0) {
                SoundPool soundPool = this.j;
                if (soundPool != null) {
                    soundPool.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
                    return;
                }
                return;
            }
            SoundPool soundPool2 = this.j;
            if (soundPool2 != null) {
                soundPool2.play(this.k, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (this.o == null) {
                this.o = new MediaPlayer();
            }
            try {
                this.o.reset();
                this.o.setLooping(false);
                this.o.setDataSource(str);
                this.o.prepareAsync();
                this.o.setOnPreparedListener(new a(this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 1 && e(sensorEvent.values) && (bVar = this.f54712f) != null) {
            bVar.a();
        }
    }
}
