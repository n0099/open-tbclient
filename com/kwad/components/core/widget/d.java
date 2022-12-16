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
import com.kwad.components.core.m.o;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class d extends b<AdTemplate> implements NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NestedScrollingChildHelper GQ;
    public TextView OR;
    public TextView OS;
    public ScaleAnimSeekBar OT;
    public ImageView OU;
    public ImageView OV;
    public ImageView OW;
    public ViewGroup OX;
    public ViewGroup OY;
    public TextView OZ;
    public ViewGroup Pa;
    public ViewGroup Pb;
    public com.kwad.components.core.video.c Pc;
    public int Pd;
    public boolean Pe;
    public boolean Pf;
    public long Pg;
    public boolean Ph;
    public KsAdVideoPlayConfig Pi;
    public a Pj;
    public View Pk;
    public Runnable Pl;
    public o Pm;
    public View.OnClickListener aP;
    public List<Integer> bv;
    public TextView de;
    public RatioFrameLayout dn;

    /* renamed from: do  reason: not valid java name */
    public ImageView f10do;
    public com.kwad.sdk.core.video.videoview.a dp;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    /* loaded from: classes8.dex */
    public interface a {
        void nL();

        void nM();
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
        this.Pd = 100;
        Runnable runnable = new Runnable(this) { // from class: com.kwad.components.core.widget.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d Pn;

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
                this.Pn = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.Pn.OX.setVisibility(8);
                    this.Pn.OW.setVisibility(8);
                    if (this.Pn.Pc != null) {
                        this.Pn.Pc.az(true);
                    }
                }
            }
        };
        this.Pl = runnable;
        this.Pm = new o(runnable);
    }

    private void a(com.kwad.components.core.video.a aVar, com.kwad.sdk.core.video.videoview.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, aVar, aVar2) == null) {
            this.Pa.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.widget.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Pn;

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
                    this.Pn = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.Pn.OX.getVisibility() != 8) {
                            if (this.Pn.getHandler() != null) {
                                this.Pn.getHandler().removeCallbacks(this.Pn.Pl);
                                if (this.Pn.Ph) {
                                    return;
                                }
                                this.Pn.getHandler().postDelayed(this.Pn.Pm, 1000L);
                            }
                        } else if (!this.Pn.dp.isCompleted()) {
                            this.Pn.OX.setVisibility(0);
                            this.Pn.OW.setVisibility(0);
                            if (this.Pn.Pc != null) {
                                this.Pn.Pc.az(false);
                            }
                            if (this.Pn.getHandler() != null) {
                                this.Pn.getHandler().removeCallbacks(this.Pn.Pl);
                                this.Pn.getHandler().postDelayed(this.Pn.Pm, 5000L);
                            }
                        } else if (this.Pn.Pd != 101) {
                            if (this.Pn.aP != null) {
                                this.Pn.aP.onClick(view2);
                            }
                        } else {
                            this.Pn.OX.setVisibility(0);
                            this.Pn.OW.setVisibility(8);
                            if (this.Pn.Pc != null) {
                                this.Pn.Pc.az(false);
                            }
                            if (this.Pn.getHandler() != null) {
                                this.Pn.getHandler().removeCallbacks(this.Pn.Pl);
                                this.Pn.getHandler().postDelayed(this.Pn.Pm, 5000L);
                            }
                        }
                    }
                }
            });
            aVar.setVideoPlayCallback(new a.b(this, aVar2) { // from class: com.kwad.components.core.widget.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Pn;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.a Po;
                public boolean bw;

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
                    this.Pn = this;
                    this.Po = aVar2;
                    this.bw = false;
                }

                @Override // com.kwad.components.core.video.a.b
                public final void bm() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.ax(this.Pn.mAdTemplate);
                        this.Pn.OX.setVisibility(8);
                        this.Pn.OW.setVisibility(8);
                        this.Pn.OT.setProgress(100);
                        this.Pn.OS.setText(bc.v(this.Po.getDuration()));
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void d(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.Pn.c(j);
                        float duration = (((float) j) * 100.0f) / ((float) this.Po.getDuration());
                        if (!this.Pn.Ph) {
                            this.Pn.OT.setProgress((int) duration);
                            this.Pn.OS.setText(bc.v(j));
                        }
                        this.Pn.OR.setText(bc.v(this.Po.getDuration()));
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void onVideoPlayStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.sdk.core.report.a.aw(this.Pn.mAdTemplate);
                        this.Pn.OR.setText(bc.v(this.Po.getDuration()));
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void onVideoPlaying() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.bw) {
                        return;
                    }
                    this.bw = true;
                    com.kwad.components.core.j.a.og().a(this.Pn.mAdTemplate, System.currentTimeMillis(), 1);
                }
            });
            this.Pc.setAdClickListener(new a.InterfaceC0605a(this) { // from class: com.kwad.components.core.widget.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Pn;

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
                    this.Pn = this;
                }

                @Override // com.kwad.components.core.video.a.InterfaceC0605a
                public final void a(int i, aa.a aVar3) {
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
                        bVar.gL = aVar3;
                        bVar.gJ = i2;
                        com.kwad.components.core.c.a.a.a(new a.C0594a(com.kwad.sdk.b.kwai.a.x(this.Pn.Pa)).L(this.Pn.mAdTemplate).b(this.Pn.mApkDownloadHelper).ae(i3).aj(z).al(true).a(bVar).a(new a.b(this) { // from class: com.kwad.components.core.widget.d.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 Pp;

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
                                this.Pp = this;
                            }

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void onAdClicked() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.Pp.Pn.dx();
                                }
                            }
                        }));
                    }
                }
            });
            this.OT.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a(this, aVar2) { // from class: com.kwad.components.core.widget.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Pn;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.a Po;

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
                    this.Pn = this;
                    this.Po = aVar2;
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, scaleAnimSeekBar) == null) {
                        this.Pn.OT.aN(false);
                        this.Po.seekTo((int) ((this.Po.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                        if (this.Pn.getHandler() != null) {
                            this.Pn.getHandler().removeCallbacks(this.Pn.Pm);
                            this.Pn.getHandler().postDelayed(this.Pn.Pm, 5000L);
                        }
                        this.Pn.Ph = false;
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scaleAnimSeekBar, z) == null) && z) {
                        this.Pn.OT.aN(true);
                        this.Pn.getHandler().removeCallbacks(this.Pn.Pm);
                        this.Pn.Ph = true;
                        this.Pn.OS.setText(bc.v((int) ((this.Po.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                    }
                }

                @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
                public final void qf() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.Pn.OT.aN(true);
                        this.Pn.getHandler().removeCallbacks(this.Pn.Pm);
                        this.Pn.Ph = true;
                    }
                }
            });
            this.OU.setOnClickListener(new View.OnClickListener(this, aVar2) { // from class: com.kwad.components.core.widget.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Pn;
                public final /* synthetic */ com.kwad.sdk.core.video.videoview.a Po;

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
                    this.Pn = this;
                    this.Po = aVar2;
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
                    if (!this.Po.isPaused() && !this.Po.isIdle()) {
                        if (this.Po.isPlaying()) {
                            this.Pn.Pc.pc();
                            this.Pn.OW.setVisibility(0);
                            this.Pn.OW.setImageDrawable(this.Pn.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf7));
                            imageView = this.Pn.OU;
                            resources = this.Pn.getContext().getResources();
                            i = R.drawable.obfuscated_res_0x7f080cfd;
                        }
                        if (this.Pn.getHandler() == null) {
                            this.Pn.getHandler().removeCallbacks(this.Pn.Pm);
                            this.Pn.getHandler().postDelayed(this.Pn.Pm, 5000L);
                            return;
                        }
                        return;
                    }
                    this.Pn.Pc.pd();
                    this.Pn.OU.setImageDrawable(this.Pn.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cfb));
                    imageView = this.Pn.OW;
                    resources = this.Pn.getResources();
                    i = R.drawable.obfuscated_res_0x7f080cfc;
                    imageView.setImageDrawable(resources.getDrawable(i));
                    if (this.Pn.getHandler() == null) {
                    }
                }
            });
            this.OW.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.widget.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Pn;

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
                    this.Pn = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.Pn.dp.isPaused() || this.Pn.dp.isIdle()) {
                            this.Pn.qa();
                        } else if (this.Pn.dp.isPlaying()) {
                            this.Pn.oQ();
                        }
                        if (this.Pn.getHandler() != null) {
                            this.Pn.getHandler().removeCallbacks(this.Pn.Pm);
                            this.Pn.getHandler().postDelayed(this.Pn.Pm, 5000L);
                        }
                    }
                }
            });
            this.OY.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.widget.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Pn;

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
                    this.Pn = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.Pn.qd();
                    }
                }
            });
            this.OV.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.widget.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Pn;

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
                    this.Pn = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.Pn.Pd == 100) {
                            this.Pn.qc();
                        } else if (this.Pn.Pd == 101) {
                            this.Pn.qd();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.bv;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.bv.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.Pc.pc();
            this.OW.setVisibility(0);
            this.OW.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf7));
            this.OU.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cfd));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.Pc.pd();
            this.OU.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cfb));
            this.OW.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cfc));
        }
    }

    private boolean qb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = ((elapsedRealtime - this.Pg) > 888L ? 1 : ((elapsedRealtime - this.Pg) == 888L ? 0 : -1));
            if (i > 0) {
                this.Pg = elapsedRealtime;
            }
            return i > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            a aVar = this.Pj;
            if (aVar != null) {
                aVar.nL();
            }
            if ((this.Pd == 100) && qb()) {
                this.OY.setVisibility(0);
                this.OZ.setText(this.mAdInfo.adBaseInfo.adDescription);
                boolean z = com.kwad.sdk.core.response.a.a.G(this.mAdInfo) > com.kwad.sdk.core.response.a.a.F(this.mAdInfo);
                this.Pe = ag.cx(getContext());
                this.Pf = ag.cB(getContext());
                Context context = getContext();
                if (z) {
                    ag.cA(context);
                } else {
                    ag.cz(context);
                }
                ViewGroup viewGroup = (ViewGroup) this.Pa.getParent();
                this.Pb = viewGroup;
                if (viewGroup != null) {
                    viewGroup.removeView(this.Pa);
                    View view2 = new View(this.Pa.getContext());
                    this.Pk = view2;
                    view2.setLayoutParams(new ViewGroup.LayoutParams(this.Pa.getWidth(), this.Pa.getHeight()));
                    viewGroup.addView(this.Pk);
                }
                ag.b(getContext(), false);
                Context x = com.kwad.sdk.b.kwai.a.x(this);
                if (x instanceof Activity) {
                    ViewGroup viewGroup2 = (ViewGroup) ((Activity) x).getWindow().getDecorView();
                    this.Pa.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                    if (z && viewGroup2.getWidth() != 0) {
                        this.dn.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                    }
                    viewGroup2.addView(this.Pa, new FrameLayout.LayoutParams(-1, -1));
                    setUIWithStateAndMode(101);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            if ((this.Pd == 101) & qb()) {
                this.OY.setVisibility(8);
                if (this.Pe) {
                    ag.cx(getContext());
                } else {
                    ag.cy(getContext());
                }
                if (this.Pf) {
                    ag.cA(getContext());
                } else {
                    ag.cz(getContext());
                }
                ag.b(getContext(), true);
                ViewGroup viewGroup = (ViewGroup) this.Pa.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.Pa);
                }
                this.Pa.setLayoutParams(new ViewGroup.LayoutParams(this.Pb.getWidth(), this.Pb.getHeight()));
                this.dn.setRatio(0.56f);
                View view2 = this.Pk;
                if (view2 != null) {
                    this.Pb.removeView(view2);
                    this.Pk = null;
                }
                this.Pb.addView(this.Pa, new FrameLayout.LayoutParams(-1, -2));
                this.Pa.requestLayout();
                setUIWithStateAndMode(100);
            }
            a aVar = this.Pj;
            if (aVar != null) {
                aVar.nM();
            }
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ksAdVideoPlayConfig, cVar) == null) {
            this.mApkDownloadHelper = cVar;
            com.kwad.sdk.core.response.model.b aL = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo);
            this.Pi = ksAdVideoPlayConfig;
            String url = aL.getUrl();
            if (TextUtils.isEmpty(url)) {
                this.f10do.setVisibility(8);
            } else {
                this.f10do.setImageDrawable(null);
                KSImageLoader.loadImage(this.f10do, url, this.mAdTemplate);
                this.f10do.setVisibility(0);
            }
            this.bv = com.kwad.sdk.core.response.a.a.aF(this.mAdInfo);
            String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
            if (TextUtils.isEmpty(A)) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a cw = AdVideoPlayerViewCache.getInstance().cw(A);
            this.dp = cw;
            if (cw == null) {
                this.dp = new com.kwad.sdk.core.video.videoview.a(getContext());
                com.kwad.sdk.core.response.a.a.O(this.mAdInfo);
                this.dp.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).bk(com.kwad.sdk.core.response.a.d.bS(this.mAdTemplate)).bl(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.bR(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).rC(), (Map<String, String>) null);
                this.dp.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
                com.kwad.components.core.video.c cVar2 = new com.kwad.components.core.video.c(this.mContext, this.mAdTemplate, this.dp, ksAdVideoPlayConfig);
                this.Pc = cVar2;
                cVar2.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
                this.dp.setController(this.Pc);
                this.Pc.setAutoRelease(false);
            } else {
                if (cw.getTag() != null) {
                    try {
                        this.bv = (List) this.dp.getTag();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                com.kwad.components.core.video.c cVar3 = (com.kwad.components.core.video.c) this.dp.getController();
                this.Pc = cVar3;
                cVar3.setAutoRelease(false);
                this.Pc.getAdTemplate().mAdWebVideoPageShowing = true;
            }
            this.dp.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            if (this.dp.getParent() != null) {
                ((ViewGroup) this.dp.getParent()).removeView(this.dp);
            }
            if (this.dn.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.dn;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.dn.setTag(null);
            }
            this.dn.addView(this.dp);
            this.dn.setTag(this.dp);
            this.OX.setVisibility(8);
            this.OW.setVisibility(8);
            if (this.mAdInfo.adConversionInfo.h5Type == 1) {
                this.de.setVisibility(8);
            } else {
                this.de.setVisibility(0);
                this.de.setText(this.mAdInfo.adBaseInfo.adDescription);
            }
            a(this.Pc, this.dp);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.b
    public final void aR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aR();
            com.kwad.sdk.core.video.videoview.a aVar = this.dp;
            if (aVar == null || aVar.isPlaying()) {
                return;
            }
            qa();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.Pm);
                getHandler().postDelayed(this.Pm, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.b
    public final void aS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aS();
            if (this.dp != null) {
                oQ();
                if (getHandler() != null) {
                    getHandler().removeCallbacks(this.Pm);
                    getHandler().postDelayed(this.Pm, 5000L);
                }
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.GQ = new NestedScrollingChildHelper(this);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f0912a7);
            this.dn = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.f10do = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912b7);
            this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f0912c4);
            ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.obfuscated_res_0x7f0912d9);
            this.OT = scaleAnimSeekBar;
            scaleAnimSeekBar.setMaxProgress(100);
            this.OT.setMinProgress(0);
            this.OR = (TextView) findViewById(R.id.obfuscated_res_0x7f0912b0);
            this.OS = (TextView) findViewById(R.id.obfuscated_res_0x7f0912ae);
            this.OU = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912ad);
            this.OW = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912af);
            this.OV = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912aa);
            this.OX = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912a9);
            this.Pa = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09114a);
            this.OY = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912ab);
            this.OZ = (TextView) findViewById(R.id.obfuscated_res_0x7f0912ac);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adTemplate) == null) {
            super.c((d) adTemplate);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) ? this.GQ.dispatchNestedFling(f, f2, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? this.GQ.dispatchNestedPreFling(f, f2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) ? this.GQ.dispatchNestedPreScroll(i, i2, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) ? this.GQ.dispatchNestedScroll(i, i2, i3, i4, iArr) : invokeCommon.booleanValue;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.obfuscated_res_0x7f0d0442 : invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.GQ.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.GQ.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void k(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            super.k(view2);
        }
    }

    public final boolean qe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.Pd == 101) {
                qd();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.GQ.setNestedScrollingEnabled(z);
        }
    }

    public final void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.aP = onClickListener;
        }
    }

    public final void setUIWithStateAndMode(int i) {
        ImageView imageView;
        Resources resources;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (i == 101) {
                imageView = this.OV;
                resources = getContext().getResources();
                i2 = R.drawable.obfuscated_res_0x7f080cf9;
            } else {
                imageView = this.OV;
                resources = getContext().getResources();
                i2 = R.drawable.obfuscated_res_0x7f080cfa;
            }
            imageView.setImageDrawable(resources.getDrawable(i2));
            this.Pd = i;
        }
    }

    public final void setWindowFullScreenListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.Pj = aVar;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) ? this.GQ.startNestedScroll(i) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.GQ.stopNestedScroll();
        }
    }
}
