package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.z83;
/* loaded from: classes5.dex */
public class ah4 implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public SwanVideoView b;
    public FrameLayout c;
    public LinearLayout d;
    public LinearLayout e;
    public SeekBar f;
    public SeekBar g;
    public AudioManager h;
    public int i;
    public boolean j;

    /* loaded from: classes5.dex */
    public class a implements z83.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah4 a;

        public a(ah4 ah4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah4Var;
        }

        @Override // com.repackage.z83.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.g.setProgress(i);
            }
        }
    }

    public ah4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        f();
    }

    public void b(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.b = swanVideoView;
        }
    }

    public FrameLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (FrameLayout) invokeV.objValue;
    }

    public void d() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (linearLayout = this.d) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void e() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (linearLayout = this.e) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07ca, (ViewGroup) null);
            this.c = frameLayout;
            frameLayout.setOnTouchListener(this);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091df5);
            this.d = linearLayout;
            linearLayout.setVisibility(8);
            this.d.findViewById(R.id.obfuscated_res_0x7f091dfd).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f091dfe).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f091dff).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f091e00).setOnClickListener(this);
            this.d.findViewById(R.id.obfuscated_res_0x7f091e01).setOnClickListener(this);
            this.i = R.id.obfuscated_res_0x7f091dfe;
            k(R.id.obfuscated_res_0x7f091dfe, -13399809);
            i();
            LinearLayout linearLayout2 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091df6);
            this.e = linearLayout2;
            linearLayout2.setVisibility(8);
            this.e.setOnTouchListener(this);
            this.f = (SeekBar) this.e.findViewById(R.id.obfuscated_res_0x7f091e05);
            this.g = (SeekBar) this.e.findViewById(R.id.obfuscated_res_0x7f091e06);
            this.f.setOnSeekBarChangeListener(this);
            this.g.setOnSeekBarChangeListener(this);
            this.f.setMax(100);
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            this.h = audioManager;
            this.g.setMax(audioManager.getStreamMaxVolume(3));
            o();
            z83.e().d("#com.baidu.swan.videoplayer&MediaSettingViewLayer", new a(this));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            k(this.i, -1);
            if (TextUtils.equals("0.75", str)) {
                this.i = R.id.obfuscated_res_0x7f091dfd;
            } else if (TextUtils.equals("1.0", str)) {
                this.i = R.id.obfuscated_res_0x7f091dfe;
            } else if (TextUtils.equals("1.25", str)) {
                this.i = R.id.obfuscated_res_0x7f091dff;
            } else if (TextUtils.equals("1.5", str)) {
                this.i = R.id.obfuscated_res_0x7f091e00;
            } else if (TextUtils.equals("2.0", str)) {
                this.i = R.id.obfuscated_res_0x7f091e01;
            } else {
                this.i = 0;
            }
            k(this.i, -13399809);
            SwanVideoView swanVideoView = this.b;
            if (swanVideoView != null) {
                swanVideoView.Q(str);
            }
        }
    }

    public void i() {
        float dimension;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.d == null) {
            return;
        }
        if (this.j) {
            dimension = this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0706b6);
        } else {
            dimension = this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0706b5);
        }
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.width = (int) dimension;
        this.d.setLayoutParams(layoutParams);
    }

    public void j(int i) {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (swanVideoView = this.b) == null || swanVideoView.A()) {
            return;
        }
        AudioManager audioManager = this.h;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
        if (i == 0) {
            this.b.setMuted(true);
        } else if (this.b.y()) {
            this.b.setMuted(false);
        }
    }

    public final void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) || i == 0) {
            return;
        }
        ((TextView) this.c.findViewById(i)).setTextColor(i2);
    }

    public void l(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048585, this, f) == null) && (this.a instanceof Activity)) {
            f93.c().e((Activity) this.a, f / 100.0f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SwanVideoView swanVideoView = this.b;
            boolean x = swanVideoView != null ? swanVideoView.x() : false;
            if (this.d != null) {
                if (x != this.j) {
                    this.j = x;
                    i();
                }
                this.d.setVisibility(0);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.e == null) {
            return;
        }
        o();
        this.e.setVisibility(0);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a instanceof Activity) {
                this.f.setProgress((int) (f93.c().a((Activity) this.a) * 100.0f));
            }
            SwanVideoView swanVideoView = this.b;
            if (swanVideoView != null && swanVideoView.y()) {
                this.g.setProgress(0);
            } else {
                this.g.setProgress(this.h.getStreamVolume(3));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            d();
            if (this.b == null) {
                return;
            }
            int id = view2.getId();
            int i = this.i;
            if (id == i) {
                return;
            }
            k(i, -1);
            int id2 = view2.getId();
            this.i = id2;
            k(id2, -13399809);
            int i2 = this.i;
            String str = i2 == R.id.obfuscated_res_0x7f091dfd ? "0.75" : i2 == R.id.obfuscated_res_0x7f091dfe ? "1.0" : i2 == R.id.obfuscated_res_0x7f091dff ? "1.25" : i2 == R.id.obfuscated_res_0x7f091e00 ? "1.5" : i2 == R.id.obfuscated_res_0x7f091e01 ? "2.0" : "";
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                this.b.J(Float.parseFloat(str));
                this.b.Q(str);
            } catch (NumberFormatException unused) {
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
            if (seekBar.getId() == R.id.obfuscated_res_0x7f091e06) {
                j(i);
            } else if (seekBar.getId() == R.id.obfuscated_res_0x7f091e05) {
                l(i);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, seekBar) == null) {
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, seekBar) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, view2, motionEvent)) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091df6) {
                return true;
            }
            e();
            d();
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(null);
            z83.e().i("#com.baidu.swan.videoplayer&MediaSettingViewLayer");
        }
    }
}
