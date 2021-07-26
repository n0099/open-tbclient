package d.a.q0.n2.q;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.p0.s.q.b2;
import d.a.q0.u0.l;
/* loaded from: classes8.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData L0;
    public VideoSerializeVideoThreadInfo M0;
    public b2 N0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, View view) {
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
        n0(false);
        setStageType(null);
    }

    public final void B0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.P);
            pbActivityConfig.createNormalCfg(str2, null, null);
            pbActivityConfig.setForumId(String.valueOf(str));
            pbActivityConfig.setThreadData(this.N0);
            pbActivityConfig.setVideoOriginArea(ThreadCardUtils.computeViewArea(this.R));
            pbActivityConfig.setNeedPreLoad(true);
            l.c(this.N0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            View.OnClickListener onClickListener = this.y0;
            if (onClickListener != null) {
                onClickListener.onClick(E());
            }
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p0(this.f61451i);
        }
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.q.d
    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.q == this.f61450h) {
            C0();
        }
    }

    @Override // d.a.q0.n2.q.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f61451i = 32;
        }
    }

    @Override // d.a.q0.n2.q.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // d.a.q0.n2.q.d
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.d0();
            this.R.setOnTouchListener(null);
            this.R.setOnClickListener(this);
        }
    }

    @Override // d.a.q0.n2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            V();
        } else if (!j.z()) {
            d.a.d.e.p.l.L(this.P, R.string.no_network_guide);
        } else if (this.U) {
            VideoItemData videoItemData = this.L0;
            if (videoItemData != null) {
                B0(videoItemData.forum_id, videoItemData.thread_id);
            }
        } else {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.M0;
            if (videoSerializeVideoThreadInfo != null) {
                B0(videoSerializeVideoThreadInfo.forumId, videoSerializeVideoThreadInfo.threadId);
            }
        }
    }

    @Override // d.a.q0.n2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            startPlay();
        }
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, b2Var) == null) {
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
}
