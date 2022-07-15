package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.l.o;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.y;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d extends b<AdTemplate> implements NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View.OnClickListener B;
    public KsAdVideoPlayConfig C;
    public a D;
    public View E;
    public com.kwad.components.core.c.a.b F;
    public Runnable G;
    public o H;
    public RatioFrameLayout a;
    public ImageView b;
    public List<Integer> c;
    public TextView d;
    public TextView e;
    public TextView f;
    public ScaleAnimSeekBar g;
    public ImageView h;
    public ImageView i;
    public ImageView n;
    public ViewGroup o;
    public com.kwad.sdk.core.video.videoview.a p;
    public ViewGroup q;
    public TextView r;
    public ViewGroup s;
    public ViewGroup t;
    public com.kwad.components.core.video.c u;
    public int v;
    public boolean w;
    public boolean x;
    public long y;
    public NestedScrollingChildHelper z;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = 100;
        Runnable runnable = new Runnable(this) { // from class: com.kwad.components.core.widget.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.o.setVisibility(8);
                    this.a.n.setVisibility(8);
                    if (this.a.u != null) {
                        this.a.u.a(true);
                    }
                }
            }
        };
        this.G = runnable;
        this.H = new o(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.c;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.c.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.j, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private void a(com.kwad.components.core.video.a aVar, com.kwad.sdk.core.video.videoview.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, aVar, aVar2) == null) {
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.widget.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.a.o.getVisibility() != 8) {
                            if (this.a.getHandler() != null) {
                                this.a.getHandler().removeCallbacks(this.a.G);
                                if (this.a.A) {
                                    return;
                                }
                                this.a.getHandler().postDelayed(this.a.H, 1000L);
                            }
                        } else if (!this.a.p.h()) {
                            this.a.o.setVisibility(0);
                            this.a.n.setVisibility(0);
                            if (this.a.u != null) {
                                this.a.u.a(false);
                            }
                            if (this.a.getHandler() != null) {
                                this.a.getHandler().removeCallbacks(this.a.G);
                                this.a.getHandler().postDelayed(this.a.H, 5000L);
                            }
                        } else if (this.a.v != 101) {
                            if (this.a.B != null) {
                                this.a.B.onClick(view2);
                            }
                        } else {
                            this.a.o.setVisibility(0);
                            this.a.n.setVisibility(8);
                            if (this.a.u != null) {
                                this.a.u.a(false);
                            }
                            if (this.a.getHandler() != null) {
                                this.a.getHandler().removeCallbacks(this.a.G);
                                this.a.getHandler().postDelayed(this.a.H, 5000L);
                            }
                        }
                    }
                }
            });
            aVar.setVideoPlayCallback(new a.b(this, aVar2) { // from class: com.kwad.components.core.widget.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.a a;
                public final /* synthetic */ d b;
                public boolean c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = aVar2;
                    this.c = false;
                }

                @Override // com.kwad.components.core.video.a.b
                public final void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                        this.b.a(j);
                        float duration = (((float) j) * 100.0f) / ((float) this.a.getDuration());
                        if (!this.b.A) {
                            this.b.g.setProgress((int) duration);
                            this.b.e.setText(ay.a(j));
                        }
                        this.b.d.setText(ay.a(this.a.getDuration()));
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void f_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.report.a.h(this.b.j);
                        this.b.d.setText(ay.a(this.a.getDuration()));
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void g_() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.c) {
                        return;
                    }
                    this.c = true;
                    com.kwad.components.core.i.a.a().a(this.b.j, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.components.core.video.a.b
                public final void h_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.i(this.b.j);
                        this.b.o.setVisibility(8);
                        this.b.n.setVisibility(8);
                        this.b.g.setProgress(100);
                        this.b.e.setText(ay.a(this.a.getDuration()));
                    }
                }
            });
            this.u.setAdClickListener(new a.InterfaceC0518a(this) { // from class: com.kwad.components.core.widget.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.video.a.InterfaceC0518a
                public final void a(int i, y.a aVar3) {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, aVar3) == null) {
                        int i3 = 2;
                        boolean z = false;
                        if (i == 1) {
                            i2 = 13;
                        } else if (i == 2) {
                            i2 = 82;
                        } else if (i != 3) {
                            i2 = 108;
                        } else {
                            i2 = 83;
                            i3 = 1;
                            z = true;
                        }
                        u.b bVar = new u.b();
                        bVar.i = aVar3;
                        bVar.c = i2;
                        com.kwad.components.core.c.a.a.a(new a.C0507a(com.kwad.sdk.b.kwai.a.a(this.a.s)).a(this.a.j).a(this.a.F).a(i3).a(z).c(true).a(bVar).a(new a.b(this) { // from class: com.kwad.components.core.widget.d.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.g();
                                }
                            }
                        }));
                    }
                }
            });
            this.g.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a(this, aVar2) { // from class: com.kwad.components.core.widget.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.a a;
                public final /* synthetic */ d b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = aVar2;
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.g.a(true);
                        this.b.getHandler().removeCallbacks(this.b.H);
                        this.b.A = true;
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scaleAnimSeekBar) == null) {
                        this.b.g.a(false);
                        this.a.a((int) ((this.a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                        if (this.b.getHandler() != null) {
                            this.b.getHandler().removeCallbacks(this.b.H);
                            this.b.getHandler().postDelayed(this.b.H, 5000L);
                        }
                        this.b.A = false;
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, scaleAnimSeekBar, z) == null) && z) {
                        this.b.g.a(true);
                        this.b.getHandler().removeCallbacks(this.b.H);
                        this.b.A = true;
                        this.b.e.setText(ay.a((int) ((this.a.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                    }
                }
            });
            this.h.setOnClickListener(new View.OnClickListener(this, aVar2) { // from class: com.kwad.components.core.widget.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.a a;
                public final /* synthetic */ d b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = aVar2;
                }

                /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
                /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void onClick(View view2) {
                    ImageView imageView;
                    Resources resources;
                    int i;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    if (!this.a.g() && !this.a.d()) {
                        if (this.a.f()) {
                            this.b.u.m();
                            this.b.n.setVisibility(0);
                            this.b.n.setImageDrawable(this.b.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c58));
                            imageView = this.b.h;
                            resources = this.b.getContext().getResources();
                            i = R.drawable.obfuscated_res_0x7f080c5e;
                        }
                        if (this.b.getHandler() == null) {
                            this.b.getHandler().removeCallbacks(this.b.H);
                            this.b.getHandler().postDelayed(this.b.H, 5000L);
                            return;
                        }
                        return;
                    }
                    this.b.u.n();
                    this.b.h.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c5c));
                    imageView = this.b.n;
                    resources = this.b.getResources();
                    i = R.drawable.obfuscated_res_0x7f080c5d;
                    imageView.setImageDrawable(resources.getDrawable(i));
                    if (this.b.getHandler() == null) {
                    }
                }
            });
            this.n.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.widget.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.a.p.g() || this.a.p.d()) {
                            this.a.i();
                        } else if (this.a.p.f()) {
                            this.a.j();
                        }
                        if (this.a.getHandler() != null) {
                            this.a.getHandler().removeCallbacks(this.a.H);
                            this.a.getHandler().postDelayed(this.a.H, 5000L);
                        }
                    }
                }
            });
            this.q.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.widget.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.m();
                    }
                }
            });
            this.i.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.widget.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.a.v == 100) {
                            this.a.l();
                        } else if (this.a.v == 101) {
                            this.a.m();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.u.n();
            this.h.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c5c));
            this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c5d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.u.m();
            this.n.setVisibility(0);
            this.n.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c58));
            this.h.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c5e));
        }
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = ((elapsedRealtime - this.y) > 888L ? 1 : ((elapsedRealtime - this.y) == 888L ? 0 : -1));
            if (i > 0) {
                this.y = elapsedRealtime;
            }
            return i > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            a aVar = this.D;
            if (aVar != null) {
                aVar.a();
            }
            if ((this.v == 100) && k()) {
                this.q.setVisibility(0);
                this.r.setText(this.k.adBaseInfo.adDescription);
                boolean z = com.kwad.sdk.core.response.a.a.h(this.k) > com.kwad.sdk.core.response.a.a.g(this.k);
                this.w = ae.a(getContext());
                this.x = ae.e(getContext());
                Context context = getContext();
                if (z) {
                    ae.d(context);
                } else {
                    ae.c(context);
                }
                ViewGroup viewGroup = (ViewGroup) this.s.getParent();
                this.t = viewGroup;
                if (viewGroup != null) {
                    viewGroup.removeView(this.s);
                    View view2 = new View(this.s.getContext());
                    this.E = view2;
                    view2.setLayoutParams(new ViewGroup.LayoutParams(this.s.getWidth(), this.s.getHeight()));
                    viewGroup.addView(this.E);
                }
                ae.a(getContext(), false);
                Context a2 = com.kwad.sdk.b.kwai.a.a(this);
                if (a2 instanceof Activity) {
                    ViewGroup viewGroup2 = (ViewGroup) ((Activity) a2).getWindow().getDecorView();
                    this.s.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                    if (z && viewGroup2.getWidth() != 0) {
                        this.a.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                    }
                    viewGroup2.addView(this.s, new FrameLayout.LayoutParams(-1, -1));
                    setUIWithStateAndMode(101);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            if ((this.v == 101) & k()) {
                this.q.setVisibility(8);
                if (this.w) {
                    ae.a(getContext());
                } else {
                    ae.b(getContext());
                }
                if (this.x) {
                    ae.d(getContext());
                } else {
                    ae.c(getContext());
                }
                ae.a(getContext(), true);
                ViewGroup viewGroup = (ViewGroup) this.s.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.s);
                }
                this.s.setLayoutParams(new ViewGroup.LayoutParams(this.t.getWidth(), this.t.getHeight()));
                this.a.setRatio(0.56f);
                View view2 = this.E;
                if (view2 != null) {
                    this.t.removeView(view2);
                    this.E = null;
                }
                this.t.addView(this.s, new FrameLayout.LayoutParams(-1, -2));
                this.s.requestLayout();
                setUIWithStateAndMode(100);
            }
            a aVar = this.D;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            super.a(view2);
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.c.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksAdVideoPlayConfig, bVar) == null) {
            this.F = bVar;
            com.kwad.sdk.core.response.model.b ae = com.kwad.sdk.core.response.a.a.ae(this.k);
            this.C = ksAdVideoPlayConfig;
            String a2 = ae.a();
            if (TextUtils.isEmpty(a2)) {
                this.b.setVisibility(8);
            } else {
                this.b.setImageDrawable(null);
                KSImageLoader.loadImage(this.b, a2, this.j);
                this.b.setVisibility(0);
            }
            this.c = com.kwad.sdk.core.response.a.a.Z(this.k);
            String b = com.kwad.sdk.core.response.a.a.b(this.k);
            if (TextUtils.isEmpty(b)) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a b2 = AdVideoPlayerViewCache.a().b(b);
            this.p = b2;
            if (b2 == null) {
                this.p = new com.kwad.sdk.core.video.videoview.a(getContext());
                com.kwad.sdk.core.response.a.a.m(this.k);
                this.p.a(new b.a(this.j).a(this.j.mVideoPlayerStatus).a(com.kwad.sdk.core.response.a.d.k(this.j)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.j(this.j))).a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.j, System.currentTimeMillis())).a(), (Map<String, String>) null);
                this.p.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
                com.kwad.components.core.video.c cVar = new com.kwad.components.core.video.c(this.m, this.j, this.p, ksAdVideoPlayConfig);
                this.u = cVar;
                cVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
                this.p.setController(this.u);
                this.u.setAutoRelease(false);
            } else {
                if (b2.getTag() != null) {
                    try {
                        this.c = (List) this.p.getTag();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                com.kwad.components.core.video.c cVar2 = (com.kwad.components.core.video.c) this.p.getController();
                this.u = cVar2;
                cVar2.setAutoRelease(false);
                this.u.getAdTemplate().mAdWebVideoPageShowing = true;
            }
            this.p.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            if (this.p.getParent() != null) {
                ((ViewGroup) this.p.getParent()).removeView(this.p);
            }
            if (this.a.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.a;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.a.setTag(null);
            }
            this.a.addView(this.p);
            this.a.setTag(this.p);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            if (this.k.adConversionInfo.h5Type == 1) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(this.k.adBaseInfo.adDescription);
            }
            a(this.u, this.p);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            super.a((d) adTemplate);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.b
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b();
            if (this.p != null) {
                j();
                if (getHandler() != null) {
                    getHandler().removeCallbacks(this.H);
                    getHandler().postDelayed(this.H, 5000L);
                }
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.z = new NestedScrollingChildHelper(this);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911c3);
            this.a = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911d3);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0911e0);
            ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.obfuscated_res_0x7f0911f5);
            this.g = scaleAnimSeekBar;
            scaleAnimSeekBar.setMaxProgress(100);
            this.g.setMinProgress(0);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0911cc);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0911ca);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911c9);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911cb);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911c6);
            this.o = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911c5);
            this.s = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091048);
            this.q = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911c7);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f0911c8);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) ? this.z.dispatchNestedFling(f, f2, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? this.z.dispatchNestedPreFling(f, f2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) ? this.z.dispatchNestedPreScroll(i, i2, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) ? this.z.dispatchNestedScroll(i, i2, i3, i4, iArr) : invokeCommon.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.v == 101) {
                m();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? R.layout.obfuscated_res_0x7f0d0422 : invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.z.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.z.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.b
    public final void m_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.m_();
            com.kwad.sdk.core.video.videoview.a aVar = this.p;
            if (aVar == null || aVar.f()) {
                return;
            }
            i();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.H);
                getHandler().postDelayed(this.H, 5000L);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.z.setNestedScrollingEnabled(z);
        }
    }

    public final void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public final void setUIWithStateAndMode(int i) {
        ImageView imageView;
        Resources resources;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (i == 101) {
                imageView = this.i;
                resources = getContext().getResources();
                i2 = R.drawable.obfuscated_res_0x7f080c5a;
            } else {
                imageView = this.i;
                resources = getContext().getResources();
                i2 = R.drawable.obfuscated_res_0x7f080c5b;
            }
            imageView.setImageDrawable(resources.getDrawable(i2));
            this.v = i;
        }
    }

    public final void setWindowFullScreenListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.D = aVar;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) ? this.z.startNestedScroll(i) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.z.stopNestedScroll();
        }
    }
}
