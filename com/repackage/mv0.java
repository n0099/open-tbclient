package com.repackage;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class mv0 extends lv0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static int j = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean d;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755485974, "Lcom/repackage/mv0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755485974, "Lcom/repackage/mv0;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mv0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.repackage.lv0, com.repackage.fs0
    public void d(er0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                this.e = false;
                boolean q = q();
                if (!q) {
                    j = qw0.c(getContext());
                }
                if (q != f) {
                    f = q;
                    if (!q && ko0.T() && qw0.c(getContext()) > 0) {
                        nw0.b("HeadsetPlugin", "恢复操作,静音->非静音");
                        i = false;
                        ko0 i2 = i();
                        if (i2 != null) {
                            i2.s0(false);
                        }
                    }
                }
                ko0 i3 = i();
                this.d = i3 != null ? i3.V() : false;
            }
        }
    }

    @Override // com.repackage.fs0
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new int[]{1, 4} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.lv0, com.repackage.fs0
    public void n(er0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), SystemEvent.ACTION_HEADSET_PLUG)) {
                boolean d = event.d(3);
                h = d;
                if (g) {
                    return;
                }
                p(d);
            } else if (Intrinsics.areEqual(event.c(), SystemEvent.ACTION_BLUETOOTH_HEADSET)) {
                boolean d2 = event.d(6);
                g = d2;
                if (h) {
                    return;
                }
                p(d2);
            }
        }
    }

    public final void p(boolean z) {
        ko0 i2;
        ko0 i3;
        ko0 i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("播放器是否静音isMute= ");
            ko0 i5 = i();
            sb.append(i5 != null ? Boolean.valueOf(i5.V()) : null);
            sb.append(',');
            sb.append(" 播放器是否全局静音sGlobalMute= ");
            sb.append(ko0.T());
            sb.append(',');
            sb.append(" 播放器静音状态(业务复写的方法)isPlayerMute= ");
            ko0 i6 = i();
            sb.append(i6 != null ? Boolean.valueOf(i6.X()) : null);
            sb.append(',');
            sb.append(" 播放器耳机连接前的音量大小-> ");
            sb.append(j);
            sb.append(',');
            sb.append(" 播放器音量音量焦点-> ");
            ko0 i7 = i();
            sb.append(i7 != null ? Boolean.valueOf(i7.U()) : null);
            nw0.b("HeadsetPlugin", sb.toString());
            if (z) {
                f = true;
                i = ko0.T();
                ko0 i8 = i();
                this.d = i8 != null ? i8.V() : false;
                nw0.b("HeadsetPlugin", "耳机连接>>> 静音状态,全局=" + i + ", 播放器=" + this.d);
                boolean z2 = this.d;
                if (!z2) {
                    ko0 i9 = i();
                    z2 = i9 != null && i9.V();
                }
                if (z2 && (i4 = i()) != null) {
                    i4.s0(false);
                }
                int c = qw0.c(getContext());
                if (c == 0) {
                    c = (int) (qw0.b(getContext()) * 0.35d);
                }
                qw0.d(getContext(), c);
                if (yw0.k() && (i3 = i()) != null && i3.W() && this.e) {
                    ko0 i10 = i();
                    int r = i10 != null ? i10.r() : 0;
                    ko0 i11 = i();
                    if (r > (i11 != null ? i11.C() : 0)) {
                        this.e = false;
                        ko0 i12 = i();
                        if (i12 != null) {
                            i12.l0();
                        }
                    }
                }
            } else if (f) {
                f = false;
                if (yw0.k() && (i2 = i()) != null && i2.Y()) {
                    this.e = true;
                    ko0 i13 = i();
                    if (i13 != null) {
                        i13.f0(4);
                    }
                }
                nw0.b("HeadsetPlugin", "耳机断开>>> 恢复之前静音状态,全局=" + i + ", 播放器=" + this.d + StringUtil.ARRAY_ELEMENT_SEPARATOR + "声音=" + j);
                if (j == 0) {
                    qw0.d(getContext(), j);
                }
                ko0 i14 = i();
                if (i14 != null) {
                    i14.s0(i);
                }
                ko0 i15 = i();
                if (i15 != null) {
                    i15.w0(this.d);
                }
            } else {
                zv0.c().d(uq0.w(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
            }
        }
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AudioManager a = qw0.a(getContext());
            boolean isWiredHeadsetOn = a != null ? a.isWiredHeadsetOn() : false;
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            boolean z = defaultAdapter != null && defaultAdapter.getProfileConnectionState(1) == 2;
            nw0.b("HeadsetPlugin", "当前耳机连接状态>>> 有线耳机=" + isWiredHeadsetOn + ", 蓝牙=" + z);
            return isWiredHeadsetOn || z;
        }
        return invokeV.booleanValue;
    }
}
