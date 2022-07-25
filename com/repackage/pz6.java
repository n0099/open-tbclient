package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pz6 implements x68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oz6 a;
    public final Context b;
    public final ViewGroup c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public boolean g;
    public ThreadData h;
    public BdUniqueId i;
    public String j;
    public String k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public s68 n;
    public int o;

    public pz6(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.c = viewGroup;
        a();
    }

    public final void a() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (context = this.b) == null || this.c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08e9, this.c, true);
        if (inflate != null) {
            inflate.setOnClickListener(this);
        }
        ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0923cc);
        if (imageView != null) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            imageView.setOnClickListener(this);
        }
        TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092395);
        this.f = textView;
        if (textView != null) {
            vr4.d(textView).y(R.array.S_O_X001);
        }
        TextView textView2 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0923ce);
        this.e = textView2;
        if (textView2 != null) {
            vr4.d(textView2).y(R.array.S_O_X001);
        }
        TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0923fd);
        this.d = tbImageView;
        if (tbImageView != null) {
            tbImageView.s();
            this.d.setDrawCorner(false);
            this.d.setPlaceHolder(3);
        }
    }

    public final void b() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.g || (viewGroup = this.c) == null || this.b == null || this.h == null) {
            return;
        }
        viewGroup.removeAllViews();
        oz6 oz6Var = new oz6(this.b, this.c);
        this.a = oz6Var;
        oz6Var.setUniqueId(this.i);
        this.a.setFrom(this.j);
        this.a.setStageType(this.k);
        this.a.setData(this.h);
        if (this.h.getThreadVideoInfo() != null && this.h.getThreadVideoInfo().is_vertical.intValue() == 1 && UbsABTestHelper.showNewUI()) {
            this.a.changeRenderViewMode(this.o);
        }
        this.a.setJumpToPbClickListener(this.l);
        this.a.setAfterClickListener(this.m);
        this.a.setStatistic(this.n);
        this.g = true;
    }

    @Override // com.repackage.x68
    public void changeRenderViewMode(int i) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.o = i;
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.changeRenderViewMode(i);
        }
    }

    @Override // com.repackage.x68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return 0;
            }
            return oz6Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.x68
    public View getMainView() {
        InterceptResult invokeV;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return null;
            }
            return oz6Var.getMainView();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.x68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return false;
            }
            return oz6Var.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.x68
    public boolean isPlaying() {
        InterceptResult invokeV;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return false;
            }
            return oz6Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.x68
    public boolean onBackPress() {
        InterceptResult invokeV;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return false;
            }
            return oz6Var.onBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.x68
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return false;
            }
            return oz6Var.onBackground(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            b();
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.onClick(view2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.g && (oz6Var = this.a) != null) {
            oz6Var.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i, i2, obj)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return false;
            }
            return oz6Var.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i, i2, obj)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return false;
            }
            return oz6Var.onInfo(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.g && (oz6Var = this.a) != null) {
            oz6Var.onPrepared();
        }
    }

    @Override // com.repackage.x68
    public void onScroll() {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.g && (oz6Var = this.a) != null) {
            oz6Var.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g && (oz6Var = this.a) != null) {
            oz6Var.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.g && (oz6Var = this.a) != null) {
            oz6Var.onSurfaceDestroyed();
        }
    }

    @Override // com.repackage.x68
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!this.g || (oz6Var = this.a) == null) {
                return false;
            }
            return oz6Var.onVolumeUp();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.x68
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.m = onClickListener;
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.setAfterClickListener(onClickListener);
        }
    }

    @Override // com.repackage.x68
    public void setData(ThreadData threadData) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null) {
            return;
        }
        this.h = threadData;
        if (this.g && (oz6Var = this.a) != null) {
            oz6Var.setData(threadData);
            return;
        }
        int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(intValue));
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(String.format(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0e5b), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
        }
        if (this.d != null) {
            if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 2 && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 1) {
                this.d.J(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            } else if (!oi.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                this.d.J(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
            } else {
                this.d.J(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            }
        }
    }

    @Override // com.repackage.x68
    public void setFrom(String str) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.j = str;
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.setFrom(str);
        }
    }

    @Override // com.repackage.x68
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.l = onClickListener;
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.setJumpToPbClickListener(onClickListener);
        }
    }

    @Override // com.repackage.x68
    public void setStageType(String str) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.k = str;
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.setStageType(str);
        }
    }

    @Override // com.repackage.x68
    public void setStatistic(s68 s68Var) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, s68Var) == null) {
            this.n = s68Var;
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.setStatistic(s68Var);
        }
    }

    @Override // com.repackage.x68
    public void setUniqueId(BdUniqueId bdUniqueId) {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.setUniqueId(bdUniqueId);
        }
    }

    @Override // com.repackage.x68
    public void startPlay() {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            b();
            if (!this.g || (oz6Var = this.a) == null) {
                return;
            }
            oz6Var.startPlay();
        }
    }

    @Override // com.repackage.x68
    public void stopPlay() {
        oz6 oz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.g && (oz6Var = this.a) != null) {
            oz6Var.stopPlay();
        }
    }
}
