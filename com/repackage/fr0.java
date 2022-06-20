package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fr0 extends cr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fr0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void d(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, obj) == null) {
            ir0 w = er0.w(StatisticsEvent.ACTION_PLAYER_ERROR);
            w.n(2, String.valueOf(obj));
            w.n(4, Integer.valueOf(i2));
            c(w);
        }
    }

    public void e(int i, int i2, Object obj) {
        ir0 w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) == null) {
            if (i == 701) {
                w = er0.w(StatisticsEvent.ACTION_BUFFER_START);
            } else if (i == 702) {
                w = er0.w(StatisticsEvent.ACTION_BUFFER_END);
            } else if (i == 904 || i == 956) {
                w = er0.w(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY);
                w.n(2, String.valueOf(obj));
            } else if (i == 10009) {
                w = er0.w("statistics_player_carlton");
                w.n(2, String.valueOf(obj));
            } else if (i != 11004) {
                w = i != 11005 ? null : er0.w(StatisticsEvent.ACTION_ERROR_RETRY_END);
            } else {
                w = er0.w(StatisticsEvent.ACTION_ERROR_RETRY_START);
                w.n(4, Integer.valueOf(i2));
            }
            if (w != null) {
                c(w);
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            ir0 w = er0.w(StatisticsEvent.ACTION_PLAYER_COMPLETE);
            w.n(1, Integer.valueOf(i));
            c(w);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c(er0.w(StatisticsEvent.ACTION_PLAYER_PAUSE));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(er0.w(StatisticsEvent.ACTION_PLAYER_RESUME));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c(er0.w(StatisticsEvent.ACTION_PLAYER_START));
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            ir0 w = er0.w(StatisticsEvent.ACTION_PLAYER_STOP);
            w.n(1, Integer.valueOf(i));
            c(w);
        }
    }
}
