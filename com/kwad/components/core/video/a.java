package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.widget.KSRelativeLayout;
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0581a JA;
    public final com.kwad.sdk.core.download.kwai.a JB;
    public boolean Jk;
    public boolean Jl;
    public boolean Jm;
    public int Jn;
    public int Jo;
    public KSRelativeLayout Jp;
    public RelativeLayout Jq;
    public boolean Jr;
    public boolean Js;
    public LinearLayout Jt;
    public LinearLayout Ju;
    public ImageView Jv;
    public ViewGroup Jw;
    public ImageView Jx;
    public TextView Jy;
    public TextView Jz;
    public b dw;
    public ImageView jQ;
    public TextView jR;
    public ProgressBar kk;
    public boolean kn;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public Context mContext;

    /* renamed from: com.kwad.components.core.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0581a {
        void a(int i, aa.a aVar);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void bm();

        void d(long j);

        void onVideoPlayStart();

        void onVideoPlaying();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.kwad.sdk.core.video.videoview.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Jl = true;
        this.Jm = false;
        this.Js = false;
        this.JB = new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.core.video.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a JC;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.JC = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.JC.Jz.setText(com.kwad.sdk.core.response.a.a.al(this.JC.mAdInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.JC.Jz.setText(com.kwad.sdk.core.response.a.a.aJ(this.JC.mAdTemplate));
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.JC.Jz.setText(com.kwad.sdk.core.response.a.a.aW(0));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    a aVar = this.JC;
                    aVar.aA(com.kwad.sdk.core.response.a.a.al(aVar.mAdInfo));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.JC.Jz.setText(com.kwad.sdk.core.response.a.a.P(this.JC.mAdInfo));
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i3) == null) {
                    this.JC.Jz.setText(com.kwad.sdk.core.response.a.a.uU());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048582, this, i3) == null) {
                    this.JC.Jz.setText(com.kwad.sdk.core.response.a.a.aW(i3));
                }
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        init();
    }

    private void aq(int i) {
        InterfaceC0581a interfaceC0581a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i) == null) || (interfaceC0581a = this.JA) == null) {
            return;
        }
        interfaceC0581a.a(i, this.Jp.getTouchCoords());
    }

    private void init() {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d042b, (ViewGroup) this, true);
            this.Jp = (KSRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09122e);
            this.Jq = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091090);
            this.jR = (TextView) findViewById(R.id.obfuscated_res_0x7f091092);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091091);
            this.jQ = imageView2;
            imageView2.setOnClickListener(this);
            this.Jt = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091227);
            this.Ju = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091222);
            this.kk = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f09122d);
            this.Jv = (ImageView) findViewById(R.id.obfuscated_res_0x7f091235);
            String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                imageView = this.Jv;
                i = 8;
            } else {
                this.Jv.setImageDrawable(null);
                KSImageLoader.loadImage(this.Jv, url, this.mAdTemplate);
                imageView = this.Jv;
                i = 0;
            }
            imageView.setVisibility(i);
            this.jR.setText(bc.v(com.kwad.sdk.core.response.a.a.B(this.mAdInfo) * 1000));
            oI();
        }
    }

    private void oJ() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (viewGroup = this.Jw) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void oN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.Jq.setVisibility(8);
        }
    }

    private void setTopBottomVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65542, this, z) == null) || this.Js) {
            return;
        }
        this.kk.setVisibility(z ? 0 : 8);
        this.Jr = z;
    }

    public final void aA(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ((TextView) findViewById(R.id.obfuscated_res_0x7f09105f)).setText(str);
        }
    }

    public final void az(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.Js) {
            return;
        }
        if (!z) {
            this.kk.setVisibility(8);
        } else if (this.Jr) {
            this.kk.setVisibility(0);
        }
    }

    public void er() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                this.Jx = (ImageView) findViewById(R.id.obfuscated_res_0x7f091213);
                this.Jy = (TextView) findViewById(R.id.obfuscated_res_0x7f091064);
                this.Jz = (TextView) findViewById(R.id.obfuscated_res_0x7f09105f);
                KSImageLoader.loadAppIcon(this.Jx, com.kwad.sdk.core.response.a.d.bU(this.mAdTemplate), this.mAdTemplate, 12);
                this.Jy.setText(com.kwad.sdk.core.response.a.a.bl(this.mAdInfo));
                this.Jz.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
                this.Jw = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091212);
                this.Jx.setOnClickListener(this);
                this.Jy.setOnClickListener(this);
                this.Jz.setOnClickListener(this);
                com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
                this.mApkDownloadHelper = cVar;
                cVar.b(this.JB);
            } else {
                TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0910ba);
                this.Jz = textView;
                textView.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
                this.Jz.setOnClickListener(this);
                this.Jw = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091214);
            }
            this.Jw.setOnClickListener(this);
            this.Jw.setVisibility(0);
        }
    }

    public AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.Jo = i2;
            this.Jn = i;
        }
    }

    public void oI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void oK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.Jt.setVisibility(0);
        }
    }

    public final void oL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.Jt.setVisibility(8);
        }
    }

    public final void oM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.Jq.setVisibility(0);
            this.Jv.setVisibility(0);
            this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
        }
    }

    public void oO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.aef.isIdle()) {
                if (this.aef.isPaused() || this.aef.vE()) {
                    oP();
                    this.aef.restart();
                }
            } else if (!ae.isNetworkConnected(this.mContext)) {
                oK();
            } else {
                oL();
                if (!this.Jm && ((!this.Jl || !ae.isWifiConnected(this.mContext)) && (!this.Jl || (!this.kn && !this.Jk)))) {
                    oM();
                    return;
                }
                oP();
                this.aef.start();
            }
        }
    }

    public final void oP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.aef.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate));
        }
    }

    public final void oQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.aef.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void oR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long currentPosition = this.aef.getCurrentPosition();
            long duration = this.aef.getDuration();
            this.kk.setSecondaryProgress(this.aef.getBufferPercentage());
            this.kk.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
            b bVar = this.dw;
            if (bVar != null) {
                bVar.d(currentPosition);
            }
        }
    }

    public final void oS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.Js = true;
            this.kk.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            if (view2 == this.jQ) {
                this.Jk = true;
                this.Jl = true;
                oO();
            } else if (view2 == this.Jx) {
                aq(1);
            } else if (view2 == this.Jy) {
                aq(2);
            } else if (view2 == this.Jz) {
                aq(3);
            } else {
                aq(4);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            com.kwad.sdk.core.e.b.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i);
            if (i == -1) {
                oY();
                setTopBottomVisible(false);
                this.Jt.setVisibility(8);
                this.Ju.setVisibility(0);
                b bVar = this.dw;
                if (bVar instanceof d.a) {
                    ((d.a) bVar).onVideoPlayError(this.Jn, this.Jo);
                }
                com.kwad.components.core.j.a.og().b(this.mAdTemplate, this.Jn, this.Jo);
            } else if (i == 4) {
                b bVar2 = this.dw;
                if (bVar2 != null) {
                    bVar2.onVideoPlaying();
                }
                this.Jv.setVisibility(8);
            } else if (i == 9) {
                b bVar3 = this.dw;
                if (bVar3 != null) {
                    bVar3.bm();
                }
                oY();
                setTopBottomVisible(false);
                KSImageLoader.loadImage(this.Jv, com.kwad.sdk.core.response.a.a.K(this.mAdInfo), this.mAdTemplate);
                this.Jv.setVisibility(0);
                er();
            } else if (i == 1) {
                oN();
                this.Jt.setVisibility(8);
                this.Ju.setVisibility(8);
                this.kk.setVisibility(8);
                oJ();
            } else if (i != 2) {
            } else {
                b bVar4 = this.dw;
                if (bVar4 != null) {
                    bVar4.onVideoPlayStart();
                }
                setTopBottomVisible(true);
                oX();
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.aef.release();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            oY();
            this.kk.setProgress(0);
            this.kk.setSecondaryProgress(0);
            oN();
            this.Jt.setVisibility(8);
            this.Ju.setVisibility(8);
            this.kk.setVisibility(8);
            this.Jv.setVisibility(8);
            this.Jq.setVisibility(8);
            this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
            oJ();
        }
    }

    public void setAdClickListener(InterfaceC0581a interfaceC0581a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, interfaceC0581a) == null) {
            this.JA = interfaceC0581a;
        }
    }

    public void setCanControlPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.Jm = z;
        }
    }

    public void setDataAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.Jl = z;
        }
    }

    public void setDataFlowAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.kn = z;
        }
    }

    public void setVideoPlayCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.dw = bVar;
        }
    }
}
