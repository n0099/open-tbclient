package d.a.s0.n2.q;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.s0.a0.m;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData L0;
    public VideoSerializeVideoThreadInfo M0;
    public b2 N0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, View view) {
        super(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64067e = 5000;
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View.OnClickListener onClickListener = this.z0;
            if (onClickListener != null) {
                onClickListener.onClick(E());
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.M0;
            if (videoSerializeVideoThreadInfo != null) {
                String str = videoSerializeVideoThreadInfo.threadId;
                String str2 = videoSerializeVideoThreadInfo.forumId;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.P);
                pbActivityConfig.createNormalCfg(str, null, null);
                pbActivityConfig.setForumId(String.valueOf(str2));
                pbActivityConfig.setThreadData(this.N0);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.N0 == null) {
            return;
        }
        if (this.L0 == null) {
            this.L0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.L0.buildWithThreadData(this.N0);
        arrayList.add(this.L0);
        Context context = this.P;
        String str = this.i0;
        VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", str, str);
        videoPlayActivityConfig.setParamIsVertail(this.U);
        b2 b2Var = this.N0;
        if (b2Var != null && b2Var.J() != null) {
            videoPlayActivityConfig.setNid(this.N0.J().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
    }

    @Override // d.a.s0.n2.q.d, d.a.s0.n2.q.a
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.N0 == null) {
            return;
        }
        if (this.M0 == null) {
            this.M0 = new VideoSerializeVideoThreadInfo();
        }
        this.M0.copyFromThreadInfo(this.N0);
        VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this.P, this.i0, this.W, m.g(), "", this.M0);
        b2 b2Var = this.N0;
        if (b2Var != null && b2Var.J() != null) {
            videoMiddlePageLightActivityConfig.setNid(this.N0.J().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
    }

    public final void E0() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoSerializeVideoThreadInfo = this.M0) == null) {
            return;
        }
        b2 b2Var = this.N0;
        if (b2Var != null) {
            videoSerializeVideoThreadInfo.copyFromThreadInfo(b2Var);
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.P, this.i0, this.W, m.g(), "", this.M0);
        b2 b2Var2 = this.N0;
        if (b2Var2 != null && b2Var2.J() != null) {
            videoMiddlePageActivityConfig.setNid(this.N0.J().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            s0(this.f64071i);
        }
    }

    @Override // d.a.s0.n2.q.d
    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.q == this.f64070h) {
            F0();
        }
    }

    @Override // d.a.s0.n2.q.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f64071i = 32;
        }
    }

    @Override // d.a.s0.n2.q.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // d.a.s0.n2.q.d
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.d0();
            this.R.setOnTouchListener(null);
            this.R.setOnClickListener(this);
        }
    }

    @Override // d.a.s0.n2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            W();
            return;
        }
        if (!j.z()) {
            l.L(this.P, R.string.no_network_guide);
        } else if (d.a.r0.b.d.L()) {
            D0();
        } else if (d.a.r0.b.d.N()) {
            C0();
        } else if (d.a.r0.b.d.Q()) {
            B0();
        } else if (this.U) {
            C0();
        } else if (!"index".equals(this.i0) && !"frs".equals(this.i0) && !"concern_tab".equals(this.i0) && !"video_tab".equals(this.i0) && !"14".equals(this.i0)) {
            E0();
        } else {
            E0();
        }
        View.OnClickListener onClickListener = this.y0;
        if (onClickListener != null) {
            onClickListener.onClick(E());
        }
    }

    @Override // d.a.s0.n2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            startPlay();
        }
    }

    @Override // d.a.s0.n2.q.d, d.a.s0.n2.q.a
    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, b2Var) == null) {
            super.setData(b2Var);
            this.N0 = b2Var;
            if (this.U) {
                VideoItemData videoItemData = new VideoItemData();
                this.L0 = videoItemData;
                videoItemData.buildWithThreadData(b2Var);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.M0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(b2Var);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.M0;
            videoSerializeVideoThreadInfo2.source = b2Var.T0;
            videoSerializeVideoThreadInfo2.extra = b2Var.W0;
            videoSerializeVideoThreadInfo2.ab_tag = b2Var.V0;
            videoSerializeVideoThreadInfo2.weight = b2Var.U0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context, View view, boolean z) {
        this(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        p0(z);
    }
}
