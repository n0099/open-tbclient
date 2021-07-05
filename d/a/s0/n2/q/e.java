package d.a.s0.n2.q;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int L0;
    public int M0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, View view) {
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
        p0(false);
        this.L0 = l.k(this.P) / 10;
    }

    public void B0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.V = str2;
            O();
            P();
            s0(this.f64068f);
            this.G.setPlayer(this.u);
            this.C.setVisibility(8);
            this.v.setPlaceHolder(3);
            this.v.M(str, 10, false);
            this.I.setShareData(null);
        }
    }

    @Override // d.a.s0.n2.q.d
    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            Context context = this.P;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
            } else if (context instanceof BaseActivity) {
                ((BaseActivity) context).setSwipeBackEnabled(this.a0);
            }
            super.U(z);
            if (this.a0) {
                this.R.getLayoutParams().height = -1;
                return;
            }
            this.R.getLayoutParams().height = this.M0;
        }
    }

    @Override // d.a.s0.n2.q.d
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    @Override // d.a.s0.n2.q.d
    public boolean g0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.L0) : invokeL.booleanValue;
    }

    @Override // d.a.s0.n2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPrepared();
            if (this.u.getCyberPlayer() == null) {
                return;
            }
            CyberPlayer cyberPlayer = this.u.getCyberPlayer();
            this.U = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            int videoHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.k(this.P));
            this.M0 = videoHeight;
            if (videoHeight > l.i(this.P)) {
                this.M0 = l.i(this.P);
            }
            this.R.getLayoutParams().height = this.M0;
            this.R.requestLayout();
        }
    }

    @Override // d.a.s0.n2.q.d
    public void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.s0(i2);
            this.K.setVisibility(8);
            this.E.setVisibility(8);
        }
    }
}
