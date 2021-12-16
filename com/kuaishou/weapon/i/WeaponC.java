package com.kuaishou.weapon.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class WeaponC {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int WEAPON_RISK_SCENE_COMMENT = 3;
    public static final int WEAPON_RISK_SCENE_HOT_START = 104;
    public static final int WEAPON_RISK_SCENE_LETTER = 6;
    public static final int WEAPON_RISK_SCENE_LIKE = 4;
    public static final int WEAPON_RISK_SCENE_LIVE = 5;
    public static final int WEAPON_RISK_SCENE_LOGIN = 1000;
    public static final int WEAPON_RISK_SCENE_LOGIN_FAIL = 1002;
    public static final int WEAPON_RISK_SCENE_LOGIN_SUCCESS = 1001;
    public static final int WEAPON_RISK_SCENE_PAYMENT = 1;
    public static final int WEAPON_RISK_SCENE_SEARCH = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public WeaponC() {
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
}
