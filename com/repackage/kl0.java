package com.repackage;

import com.baidu.nadcore.max.event.NestedEvent;
import com.baidu.nadcore.max.event.WebEventTypeEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final /* synthetic */ class kl0 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        int[] iArr = new int[NestedEvent.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[NestedEvent.UP_SHOW_WEB.ordinal()] = 1;
        $EnumSwitchMapping$0[NestedEvent.UP_SHOW_VIDEO.ordinal()] = 2;
        int[] iArr2 = new int[WebEventTypeEnum.values().length];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[WebEventTypeEnum.WEB_INIT_SUCCESS.ordinal()] = 1;
        $EnumSwitchMapping$1[WebEventTypeEnum.WEB_DESTROY.ordinal()] = 2;
    }
}
