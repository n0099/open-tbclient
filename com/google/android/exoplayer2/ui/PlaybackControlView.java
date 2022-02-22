package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.g0.h;
import c.i.b.a.i0.o;
import c.i.b.a.i0.v;
import c.i.b.a.k;
import c.i.b.a.q;
import c.i.b.a.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes3.dex */
public class PlaybackControlView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final d DEFAULT_CONTROL_DISPATCHER;
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_REWIND_MS = 5000;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public q A;
    public c.i.b.a.c B;
    public f C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public long M;
    public long[] N;
    public boolean[] O;
    public long[] P;
    public boolean[] Q;
    public final Runnable R;
    public final Runnable S;

    /* renamed from: e  reason: collision with root package name */
    public final c f54530e;

    /* renamed from: f  reason: collision with root package name */
    public final View f54531f;

    /* renamed from: g  reason: collision with root package name */
    public final View f54532g;

    /* renamed from: h  reason: collision with root package name */
    public final View f54533h;

    /* renamed from: i  reason: collision with root package name */
    public final View f54534i;

    /* renamed from: j  reason: collision with root package name */
    public final View f54535j;
    public final View k;
    public final ImageView l;
    public final View m;
    public final TextView n;
    public final TextView o;
    public final h p;
    public final StringBuilder q;
    public final Formatter r;
    public final w.b s;
    public final w.c t;
    public final Drawable u;
    public final Drawable v;
    public final Drawable w;
    public final String x;
    public final String y;
    public final String z;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlaybackControlView f54536e;

        public a(PlaybackControlView playbackControlView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playbackControlView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54536e = playbackControlView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54536e.S();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlaybackControlView f54537e;

        public b(PlaybackControlView playbackControlView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playbackControlView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54537e = playbackControlView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54537e.hide();
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c extends q.a implements h.a, View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlaybackControlView f54538e;

        public c(PlaybackControlView playbackControlView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playbackControlView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54538e = playbackControlView;
        }

        @Override // c.i.b.a.q.a, c.i.b.a.q.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f54538e.U();
                this.f54538e.Q();
            }
        }

        @Override // c.i.b.a.q.a, c.i.b.a.q.b
        public void c(w wVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar, obj) == null) {
                this.f54538e.Q();
                this.f54538e.V();
                this.f54538e.S();
            }
        }

        @Override // c.i.b.a.g0.h.a
        public void f(h hVar, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hVar, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.f54538e.G = false;
                if (!z && this.f54538e.A != null) {
                    this.f54538e.N(j2);
                }
                this.f54538e.F();
            }
        }

        @Override // c.i.b.a.g0.h.a
        public void g(h hVar, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(1048579, this, hVar, j2) == null) || this.f54538e.o == null) {
                return;
            }
            this.f54538e.o.setText(v.u(this.f54538e.q, this.f54538e.r, j2));
        }

        @Override // c.i.b.a.q.a, c.i.b.a.q.b
        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.f54538e.Q();
                this.f54538e.S();
            }
        }

        @Override // c.i.b.a.q.b
        public void l(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f54538e.R();
                this.f54538e.S();
            }
        }

        @Override // c.i.b.a.g0.h.a
        public void m(h hVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048582, this, hVar, j2) == null) {
                PlaybackControlView playbackControlView = this.f54538e;
                playbackControlView.removeCallbacks(playbackControlView.S);
                this.f54538e.G = true;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
                if (this.f54538e.A != null) {
                    if (this.f54538e.f54532g == view) {
                        this.f54538e.H();
                    } else if (this.f54538e.f54531f == view) {
                        this.f54538e.I();
                    } else if (this.f54538e.f54535j == view) {
                        this.f54538e.D();
                    } else if (this.f54538e.k == view) {
                        this.f54538e.K();
                    } else if (this.f54538e.f54533h == view) {
                        this.f54538e.B.d(this.f54538e.A, true);
                    } else if (this.f54538e.f54534i == view) {
                        this.f54538e.B.d(this.f54538e.A, false);
                    } else if (this.f54538e.l != view) {
                        if (this.f54538e.m == view) {
                            this.f54538e.B.b(this.f54538e.A, true ^ this.f54538e.A.v());
                        }
                    } else {
                        this.f54538e.B.c(this.f54538e.A, o.a(this.f54538e.A.getRepeatMode(), this.f54538e.K));
                    }
                }
                this.f54538e.F();
            }
        }

        @Override // c.i.b.a.q.a, c.i.b.a.q.b
        public void onRepeatModeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f54538e.T();
                this.f54538e.Q();
            }
        }

        public /* synthetic */ c(PlaybackControlView playbackControlView, a aVar) {
            this(playbackControlView);
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface d extends c.i.b.a.c {
    }

    /* loaded from: classes3.dex */
    public static final class e extends c.i.b.a.d implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(779824241, "Lcom/google/android/exoplayer2/ui/PlaybackControlView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(779824241, "Lcom/google/android/exoplayer2/ui/PlaybackControlView;");
                return;
            }
        }
        k.a("goog.exo.ui");
        DEFAULT_CONTROL_DISPATCHER = new e(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlaybackControlView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean C(w wVar, w.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, wVar, cVar)) == null) {
            if (wVar.o() > 100) {
                return false;
            }
            int o = wVar.o();
            for (int i2 = 0; i2 < o; i2++) {
                if (wVar.l(i2, cVar).f30091i == -9223372036854775807L) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static int E(TypedArray typedArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, typedArray, i2)) == null) ? typedArray.getInt(c.i.b.a.g0.f.PlaybackControlView_repeat_toggle_modes, i2) : invokeLI.intValue;
    }

    @SuppressLint({"InlinedApi"})
    public static boolean G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 == 90 || i2 == 89 || i2 == 85 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88 : invokeI.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.I <= 0) {
            return;
        }
        long duration = this.A.getDuration();
        long currentPosition = this.A.getCurrentPosition() + this.I;
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        M(currentPosition);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            removeCallbacks(this.S);
            if (this.J > 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int i2 = this.J;
                this.M = uptimeMillis + i2;
                if (this.D) {
                    postDelayed(this.S, i2);
                    return;
                }
                return;
            }
            this.M = -9223372036854775807L;
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w m = this.A.m();
            if (m.p()) {
                return;
            }
            int k = this.A.k();
            int u = this.A.u();
            if (u != -1) {
                L(u, -9223372036854775807L);
            } else if (m.m(k, this.t, false).f30087e) {
                L(k, -9223372036854775807L);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r1.f30086d == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            w m = this.A.m();
            if (m.p()) {
                return;
            }
            m.l(this.A.k(), this.t);
            int r = this.A.r();
            if (r != -1) {
                if (this.A.getCurrentPosition() > 3000) {
                    w.c cVar = this.t;
                    if (cVar.f30087e) {
                    }
                }
                L(r, -9223372036854775807L);
                return;
            }
            M(0L);
        }
    }

    public final void J() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q qVar = this.A;
            boolean z = qVar != null && qVar.g();
            if (!z && (view2 = this.f54533h) != null) {
                view2.requestFocus();
            } else if (!z || (view = this.f54534i) == null) {
            } else {
                view.requestFocus();
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.H <= 0) {
            return;
        }
        M(Math.max(this.A.getCurrentPosition() - this.H, 0L));
    }

    public final void L(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.B.a(this.A, i2, j2)) {
            return;
        }
        S();
    }

    public final void M(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            L(this.A.k(), j2);
        }
    }

    public final void N(long j2) {
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            w m = this.A.m();
            if (this.F && !m.p()) {
                int o = m.o();
                k = 0;
                while (true) {
                    long b2 = m.l(k, this.t).b();
                    if (j2 < b2) {
                        break;
                    } else if (k == o - 1) {
                        j2 = b2;
                        break;
                    } else {
                        j2 -= b2;
                        k++;
                    }
                }
            } else {
                k = this.A.k();
            }
            L(k, j2);
        }
    }

    public final void O(boolean z, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048585, this, z, view) == null) || view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? 1.0f : 0.3f);
        view.setVisibility(0);
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            R();
            Q();
            T();
            U();
            S();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q() {
        boolean z;
        boolean z2;
        boolean z3;
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !isVisible() || !this.D) {
            return;
        }
        q qVar = this.A;
        w m = qVar != null ? qVar.m() : null;
        boolean z4 = true;
        if (!((m == null || m.p()) ? false : true) || this.A.e()) {
            z = false;
            z2 = false;
        } else {
            m.l(this.A.k(), this.t);
            w.c cVar = this.t;
            z2 = cVar.f30086d;
            z = (!z2 && cVar.f30087e && this.A.r() == -1) ? false : true;
            if (this.t.f30087e || this.A.u() != -1) {
                z3 = true;
                O(z, this.f54531f);
                O(z3, this.f54532g);
                O(this.I <= 0 && z2, this.f54535j);
                O((this.H > 0 || !z2) ? false : false, this.k);
                hVar = this.p;
                if (hVar == null) {
                    hVar.setEnabled(z2);
                    return;
                }
                return;
            }
        }
        z3 = false;
        O(z, this.f54531f);
        O(z3, this.f54532g);
        O(this.I <= 0 && z2, this.f54535j);
        O((this.H > 0 || !z2) ? false : false, this.k);
        hVar = this.p;
        if (hVar == null) {
        }
    }

    public final void R() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && isVisible() && this.D) {
            q qVar = this.A;
            boolean z2 = true;
            boolean z3 = qVar != null && qVar.g();
            View view = this.f54533h;
            if (view != null) {
                z = (z3 && view.isFocused()) | false;
                this.f54533h.setVisibility(z3 ? 8 : 0);
            } else {
                z = false;
            }
            View view2 = this.f54534i;
            if (view2 != null) {
                z |= (z3 || !view2.isFocused()) ? false : false;
                this.f54534i.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                J();
            }
        }
    }

    public final void S() {
        long j2;
        long j3;
        long j4;
        int i2;
        w.c cVar;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && isVisible() && this.D) {
            q qVar = this.A;
            long j5 = 0;
            boolean z = true;
            if (qVar != null) {
                w m = qVar.m();
                if (m.p()) {
                    j4 = 0;
                    i2 = 0;
                } else {
                    int k = this.A.k();
                    int i4 = this.F ? 0 : k;
                    int o = this.F ? m.o() - 1 : k;
                    long j6 = 0;
                    j4 = 0;
                    i2 = 0;
                    while (true) {
                        if (i4 > o) {
                            break;
                        }
                        if (i4 == k) {
                            j4 = j6;
                        }
                        m.l(i4, this.t);
                        w.c cVar2 = this.t;
                        int i5 = i4;
                        if (cVar2.f30091i == -9223372036854775807L) {
                            c.i.b.a.i0.a.f(this.F ^ z);
                            break;
                        }
                        int i6 = cVar2.f30088f;
                        while (true) {
                            cVar = this.t;
                            if (i6 <= cVar.f30089g) {
                                m.f(i6, this.s);
                                int c2 = this.s.c();
                                int i7 = 0;
                                while (i7 < c2) {
                                    long f2 = this.s.f(i7);
                                    if (f2 == Long.MIN_VALUE) {
                                        i3 = k;
                                        long j7 = this.s.f30077d;
                                        if (j7 == -9223372036854775807L) {
                                            i7++;
                                            k = i3;
                                        } else {
                                            f2 = j7;
                                        }
                                    } else {
                                        i3 = k;
                                    }
                                    long k2 = f2 + this.s.k();
                                    if (k2 >= 0 && k2 <= this.t.f30091i) {
                                        long[] jArr = this.N;
                                        if (i2 == jArr.length) {
                                            int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                            this.N = Arrays.copyOf(this.N, length);
                                            this.O = Arrays.copyOf(this.O, length);
                                        }
                                        this.N[i2] = c.i.b.a.b.b(j6 + k2);
                                        this.O[i2] = this.s.l(i7);
                                        i2++;
                                    }
                                    i7++;
                                    k = i3;
                                }
                                i6++;
                            }
                        }
                        j6 += cVar.f30091i;
                        i4 = i5 + 1;
                        k = k;
                        z = true;
                    }
                    j5 = j6;
                }
                j5 = c.i.b.a.b.b(j5);
                long b2 = c.i.b.a.b.b(j4);
                if (this.A.e()) {
                    j2 = b2 + this.A.q();
                    j3 = j2;
                } else {
                    long currentPosition = this.A.getCurrentPosition() + b2;
                    long t = b2 + this.A.t();
                    j2 = currentPosition;
                    j3 = t;
                }
                if (this.p != null) {
                    int length2 = this.P.length;
                    int i8 = i2 + length2;
                    long[] jArr2 = this.N;
                    if (i8 > jArr2.length) {
                        this.N = Arrays.copyOf(jArr2, i8);
                        this.O = Arrays.copyOf(this.O, i8);
                    }
                    System.arraycopy(this.P, 0, this.N, i2, length2);
                    System.arraycopy(this.Q, 0, this.O, i2, length2);
                    this.p.setAdGroupTimesMs(this.N, this.O, i8);
                }
            } else {
                j2 = 0;
                j3 = 0;
            }
            TextView textView = this.n;
            if (textView != null) {
                textView.setText(v.u(this.q, this.r, j5));
            }
            TextView textView2 = this.o;
            if (textView2 != null && !this.G) {
                textView2.setText(v.u(this.q, this.r, j2));
            }
            h hVar = this.p;
            if (hVar != null) {
                hVar.setPosition(j2);
                this.p.setBufferedPosition(j3);
                this.p.setDuration(j5);
            }
            removeCallbacks(this.R);
            q qVar2 = this.A;
            int playbackState = qVar2 == null ? 1 : qVar2.getPlaybackState();
            if (playbackState == 1 || playbackState == 4) {
                return;
            }
            long j8 = 1000;
            if (this.A.g() && playbackState == 3) {
                float f3 = this.A.d().a;
                if (f3 > 0.1f) {
                    if (f3 <= 5.0f) {
                        long max = 1000 / Math.max(1, Math.round(1.0f / f3));
                        long j9 = max - (j2 % max);
                        if (j9 < max / 5) {
                            j9 += max;
                        }
                        if (f3 != 1.0f) {
                            j9 = ((float) j9) / f3;
                        }
                        j8 = j9;
                    } else {
                        j8 = 200;
                    }
                }
            }
            postDelayed(this.R, j8);
        }
    }

    public final void T() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && isVisible() && this.D && (imageView = this.l) != null) {
            if (this.K == 0) {
                imageView.setVisibility(8);
            } else if (this.A == null) {
                O(false, imageView);
            } else {
                O(true, imageView);
                int repeatMode = this.A.getRepeatMode();
                if (repeatMode == 0) {
                    this.l.setImageDrawable(this.u);
                    this.l.setContentDescription(this.x);
                } else if (repeatMode == 1) {
                    this.l.setImageDrawable(this.v);
                    this.l.setContentDescription(this.y);
                } else if (repeatMode == 2) {
                    this.l.setImageDrawable(this.w);
                    this.l.setContentDescription(this.z);
                }
                this.l.setVisibility(0);
            }
        }
    }

    public final void U() {
        View view;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && isVisible() && this.D && (view = this.m) != null) {
            if (!this.L) {
                view.setVisibility(8);
                return;
            }
            q qVar = this.A;
            if (qVar == null) {
                O(false, view);
                return;
            }
            view.setAlpha(qVar.v() ? 1.0f : 0.3f);
            this.m.setEnabled(true);
            this.m.setVisibility(0);
        }
    }

    public final void V() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (qVar = this.A) == null) {
            return;
        }
        this.F = this.E && C(qVar.m(), this.t);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, keyEvent)) == null) ? dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, keyEvent)) == null) {
            int keyCode = keyEvent.getKeyCode();
            if (this.A == null || !G(keyCode)) {
                return false;
            }
            if (keyEvent.getAction() == 0) {
                if (keyCode == 90) {
                    D();
                } else if (keyCode == 89) {
                    K();
                } else if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode == 85) {
                        c.i.b.a.c cVar = this.B;
                        q qVar = this.A;
                        cVar.d(qVar, !qVar.g());
                    } else if (keyCode == 87) {
                        H();
                    } else if (keyCode == 88) {
                        I();
                    } else if (keyCode == 126) {
                        this.B.d(this.A, true);
                    } else if (keyCode == 127) {
                        this.B.d(this.A, false);
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public q getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.A : (q) invokeV.objValue;
    }

    public int getRepeatToggleModes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.K : invokeV.intValue;
    }

    public boolean getShowShuffleButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.L : invokeV.booleanValue;
    }

    public int getShowTimeoutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.J : invokeV.intValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && isVisible()) {
            setVisibility(8);
            f fVar = this.C;
            if (fVar != null) {
                fVar.a(getVisibility());
            }
            removeCallbacks(this.R);
            removeCallbacks(this.S);
            this.M = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            this.D = true;
            long j2 = this.M;
            if (j2 != -9223372036854775807L) {
                long uptimeMillis = j2 - SystemClock.uptimeMillis();
                if (uptimeMillis <= 0) {
                    hide();
                } else {
                    postDelayed(this.S, uptimeMillis);
                }
            }
            P();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            this.D = false;
            removeCallbacks(this.R);
            removeCallbacks(this.S);
        }
    }

    public void setControlDispatcher(@Nullable c.i.b.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) {
            if (cVar == null) {
                cVar = new c.i.b.a.d();
            }
            this.B = cVar;
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, jArr, zArr) == null) {
            if (jArr == null) {
                this.P = new long[0];
                this.Q = new boolean[0];
            } else {
                c.i.b.a.i0.a.a(jArr.length == zArr.length);
                this.P = jArr;
                this.Q = zArr;
            }
            S();
        }
    }

    public void setFastForwardIncrementMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.I = i2;
            Q();
        }
    }

    public void setPlayer(q qVar) {
        q qVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, qVar) == null) || (qVar2 = this.A) == qVar) {
            return;
        }
        if (qVar2 != null) {
            qVar2.f(this.f54530e);
        }
        this.A = qVar;
        if (qVar != null) {
            qVar.i(this.f54530e);
        }
        P();
    }

    public void setRepeatToggleModes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.K = i2;
            q qVar = this.A;
            if (qVar != null) {
                int repeatMode = qVar.getRepeatMode();
                if (i2 == 0 && repeatMode != 0) {
                    this.B.c(this.A, 0);
                } else if (i2 == 1 && repeatMode == 2) {
                    this.B.c(this.A, 1);
                } else if (i2 == 2 && repeatMode == 1) {
                    this.B.c(this.A, 2);
                }
            }
        }
    }

    public void setRewindIncrementMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.H = i2;
            Q();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.E = z;
            V();
        }
    }

    public void setShowShuffleButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.L = z;
            U();
        }
    }

    public void setShowTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.J = i2;
        }
    }

    public void setVisibilityListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, fVar) == null) {
            this.C = fVar;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (!isVisible()) {
                setVisibility(0);
                f fVar = this.C;
                if (fVar != null) {
                    fVar.a(getVisibility());
                }
                P();
                J();
            }
            F();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlaybackControlView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (AttributeSet) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaybackControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), attributeSet2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.R = new a(this);
        this.S = new b(this);
        int i5 = c.i.b.a.g0.d.exo_playback_control_view;
        this.H = 5000;
        this.I = 15000;
        this.J = 5000;
        this.K = 0;
        this.L = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, c.i.b.a.g0.f.PlaybackControlView, 0, 0);
            try {
                this.H = obtainStyledAttributes.getInt(c.i.b.a.g0.f.PlaybackControlView_rewind_increment, this.H);
                this.I = obtainStyledAttributes.getInt(c.i.b.a.g0.f.PlaybackControlView_fastforward_increment, this.I);
                this.J = obtainStyledAttributes.getInt(c.i.b.a.g0.f.PlaybackControlView_show_timeout, this.J);
                i5 = obtainStyledAttributes.getResourceId(c.i.b.a.g0.f.PlaybackControlView_controller_layout_id, i5);
                this.K = E(obtainStyledAttributes, this.K);
                this.L = obtainStyledAttributes.getBoolean(c.i.b.a.g0.f.PlaybackControlView_show_shuffle_button, this.L);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.s = new w.b();
        this.t = new w.c();
        this.q = new StringBuilder();
        this.r = new Formatter(this.q, Locale.getDefault());
        this.N = new long[0];
        this.O = new boolean[0];
        this.P = new long[0];
        this.Q = new boolean[0];
        this.f54530e = new c(this, null);
        this.B = new c.i.b.a.d();
        LayoutInflater.from(context).inflate(i5, this);
        setDescendantFocusability(262144);
        this.n = (TextView) findViewById(c.i.b.a.g0.c.exo_duration);
        this.o = (TextView) findViewById(c.i.b.a.g0.c.exo_position);
        h hVar = (h) findViewById(c.i.b.a.g0.c.exo_progress);
        this.p = hVar;
        if (hVar != null) {
            hVar.addListener(this.f54530e);
        }
        View findViewById = findViewById(c.i.b.a.g0.c.exo_play);
        this.f54533h = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this.f54530e);
        }
        View findViewById2 = findViewById(c.i.b.a.g0.c.exo_pause);
        this.f54534i = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this.f54530e);
        }
        View findViewById3 = findViewById(c.i.b.a.g0.c.exo_prev);
        this.f54531f = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this.f54530e);
        }
        View findViewById4 = findViewById(c.i.b.a.g0.c.exo_next);
        this.f54532g = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this.f54530e);
        }
        View findViewById5 = findViewById(c.i.b.a.g0.c.exo_rew);
        this.k = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(this.f54530e);
        }
        View findViewById6 = findViewById(c.i.b.a.g0.c.exo_ffwd);
        this.f54535j = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(this.f54530e);
        }
        ImageView imageView = (ImageView) findViewById(c.i.b.a.g0.c.exo_repeat_toggle);
        this.l = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this.f54530e);
        }
        View findViewById7 = findViewById(c.i.b.a.g0.c.exo_shuffle);
        this.m = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(this.f54530e);
        }
        Resources resources = context.getResources();
        this.u = resources.getDrawable(c.i.b.a.g0.b.exo_controls_repeat_off);
        this.v = resources.getDrawable(c.i.b.a.g0.b.exo_controls_repeat_one);
        this.w = resources.getDrawable(c.i.b.a.g0.b.exo_controls_repeat_all);
        this.x = resources.getString(c.i.b.a.g0.e.exo_controls_repeat_off_description);
        this.y = resources.getString(c.i.b.a.g0.e.exo_controls_repeat_one_description);
        this.z = resources.getString(c.i.b.a.g0.e.exo_controls_repeat_all_description);
    }
}
